package com.androidpattern.Helpers;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.androidpattern.Models.City;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class FirebaseDBHelper {
	public enum _documentPath { Collection, Document, Field } ;
	public _documentPath DocumentPath;
	public DocumentReference returnReference;
	public City returnValue;
	
	private FirebaseAuth mAuth;
	FirebaseFirestore db = FirebaseFirestore.getInstance();
	
	static final String TAG = "Something TAG";
	
	public FirebaseAuth getInstance () {
		
		
		return mAuth;
	}
	
	public FirebaseDBHelper () {
		mAuth = FirebaseAuth.getInstance();
	}
	
	public void createAccount (String _email , String _password) {
		mAuth.createUserWithEmailAndPassword( _email , _password )
				.addOnCompleteListener( ( Executor ) this , new OnCompleteListener< AuthResult >() {
					@Override
					public void onComplete (@NonNull Task< AuthResult > task) {
						if ( task.isSuccessful() ) {
							// Sign in success, update UI with the signed-in user's information
							Log.d( TAG , "createUserWithEmail:success" );
							FirebaseUser user = mAuth.getCurrentUser();
							updateUI( user );
						} else {
							// If sign in fails, display a message to the user.
							Log.w( TAG , "createUserWithEmail:failure" , task.getException() );
//							Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//									Toast.LENGTH_SHORT).show();
							updateUI( null );
						}
						
						// ...
					}
					
					public void updateUI (FirebaseUser user) {
					
					}
				} );
	}
	
	public void signIn (String _email , String _password) {
		mAuth.signInWithEmailAndPassword( _email , _password )
				.addOnCompleteListener( ( Executor ) this , new OnCompleteListener< AuthResult >() {
					@Override
					public void onComplete (@NonNull Task< AuthResult > task) {
						if ( task.isSuccessful() ) {
							// Sign in success, update UI with the signed-in user's information
							Log.d( TAG , "signInWithEmail:success" );
							FirebaseUser user = mAuth.getCurrentUser();
							updateUI( user );
						} else {
							// If sign in fails, display a message to the user.
							Log.w( TAG , "signInWithEmail:failure" , task.getException() );
//							Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//									Toast.LENGTH_SHORT).show();
							updateUI( null );
						}
						
						// ...
					}
				} );
	}
	
	private void signOut () {
		mAuth.signOut();
		updateUI( null );
	}
	
	public void updateUI (FirebaseUser user) {
		if ( user != null ) {
			// Name, email address, and profile photo Url
			String name = user.getDisplayName();
			String email = user.getEmail();
			Uri photoUrl = user.getPhotoUrl();
			
			// Check if user's email is verified
			boolean emailVerified = user.isEmailVerified();
			
			// The user's ID, unique to the Firebase project. Do NOT use this value to
			// authenticate with your backend server, if you have one. Use
			// FirebaseUser.getIdToken() instead.
			String uid = user.getUid();
		}
		
	}
	
	public String returnPath(_documentPath docPath){
		return "";
		}
		
//		public String getField(String _collection, String _document){
//			String returnField;
//			DocumentReference docRef = db.collection(_collection).document(_document);
//			docRef.get().addOnCompleteListener(new OnCompleteListener< DocumentSnapshot >() {
//
//				DocumentSnapshot document = null;
//				@Override
//				public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//
//					if (task.isSuccessful()) {
//						document = task.getResult();
//						if (document.exists()) {
//							Log.d(TAG, "DocumentSnapshot data: " + document.getData());
//							//returnField = document.getData(  ).toString();
//						} else {
//							Log.d(TAG, "No such document");
//						}
//
//					} else {
//						Log.d(TAG, "get failed with ", task.getException());
//					}
//
//
//
//
//				}
//
//
//					});
//			return returnField;
//		}
	
	public void createDocument(String _collection, String _document, City city){
		//City city = new City("Los Angeles", "CA", "USA",
		//		false, 5000000L, Arrays.asList("west_coast", "sorcal"));
		db.collection(_collection).document(_document).set(city);
	}
	
		public void addDocument(String _collection, String _document){
			// Create a new user with a first and last name
			Map<String, Object> user = new HashMap<>();
			user.put("first", "Ada");
			user.put("last", "Lovelace");
			user.put("born", 1815);
			
			CollectionReference doc = db.collection(_collection);
			// Add a new document with a generated ID
			doc.document( _document).set( user );
		}
		public DocumentReference  getDocument(String _collection, String _document){
			DocumentReference docRef = db.collection(_collection).document(_document);
			docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
				@Override
				public void onComplete(@NonNull Task<DocumentSnapshot> task) {
					if (task.isSuccessful()) {
						DocumentSnapshot document = task.getResult();
						if (document.exists()) {
							//returnReference = ( DocumentReference ) document.getData();
							Log.d(TAG, "DocumentSnapshot data: " + document.getData());
						} else {
							Log.d(TAG, "No such document");
						}
					} else {
						Log.d(TAG, "get failed with ", task.getException());
					}
				}
			});
			return null;
		}
		
	public void updateDocument(String _collection, String _document, String _field){
	
	
	}
	
	public City returnDocument(String _collection, String _document){
		
		DocumentReference docRef = db.collection(_collection).document(_document);
		docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
			City city; //= new City();
			@Override
			public void onSuccess(DocumentSnapshot documentSnapshot) {
				city = documentSnapshot.toObject(City.class);
				
				returnValue = (City)city;
				//returnValue = new City(city.getName(),city.getState(),city.getCountry(), city.isCapital(), city.getPopulation(),city.getRegions());
				System.out.println("in db helper -> " + city.getName());
			}
		});
		//return city;
		return returnValue;
		//return null;
	}
}

