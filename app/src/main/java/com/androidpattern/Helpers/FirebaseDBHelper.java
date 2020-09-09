package com.androidpattern.Helpers;

import android.app.Activity;
import android.content.Context;
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
import com.google.firebase.firestore.auth.User;

import java.util.HashMap;
import java.util.Map;

public class FirebaseDBHelper {
	
	private static final FirebaseDBHelper ourInstance = new FirebaseDBHelper();
	
	public enum _documentPath { Collection, Document, Field } ;
	//public _documentPath DocumentPath;
	public DocumentReference returnReference;
	public City returnValue = new City();
	
	private FirebaseAuth mAuth;// = FirebaseAuth.getInstance();
	private String masterCollection;
	private String masterDocument;
	
	FirebaseFirestore db = FirebaseFirestore.getInstance();
	FirebaseUser user;
	
	static final String TAG = "Something TAG";
	
	public interface Update{
		void updateUI();
	}
	
	public void setCollection(String _collection){
		masterCollection = _collection;
	}
	public String getCollection(){
		return masterCollection;
	}
	
	public void setDocument(String _document){
		masterDocument = _document;
	}
	
	public String getDocument(){
		return masterDocument;
	}
	private FirebaseDBHelper () {
		//super();
		mAuth = FirebaseAuth.getInstance();
		
	}
	
	public static FirebaseDBHelper getInstance() {
		return ourInstance;
	}
	
//	public FirebaseDBHelper (String _collection, String _document) {
//		//super();
//		masterCollection = _collection;
//		masterDocument = _document;
//
//		mAuth = FirebaseAuth.getInstance();
//	}
	
	public void createAccount (final Context context, String _email , String _password) {
		mAuth.createUserWithEmailAndPassword( _email , _password )
				.addOnCompleteListener((Activity) context , new OnCompleteListener< AuthResult >() {
					@Override
					public void onComplete (@NonNull Task< AuthResult > task) {
						if ( task.isSuccessful() ) {
							//returnReference = db.collection(getCollection()).document(getDocument());
							// Sign in success, update UI with the signed-in user's information
							Log.d( TAG , "createUserWithEmail:success" );
							user = mAuth.getCurrentUser();
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
					
//					public void updateUI (FirebaseUser user) {
//
//					}
				} );
	}
	
	public void signIn (final Context context,String _email , String _password) {
		mAuth.signInWithEmailAndPassword( _email , _password )
				.addOnCompleteListener((Activity) context , new OnCompleteListener< AuthResult >() {
					@Override
					public void onComplete (@NonNull Task< AuthResult > task) {
						if ( task.isSuccessful() ) {
							//returnReference = db.collection(getCollection()).document(getDocument());
							// Sign in success, update UI with the signed-in user's information
							Log.d( TAG , "signInWithEmail:success" );
							user = mAuth.getCurrentUser();
							updateUI( user );
							//update.updateUI();
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
	
	public void updateUI (FirebaseUser _user) {
		if ( user != null ) {
			// Name, email address, and profile photo Url
			String name = _user.getDisplayName();
			String email = _user.getEmail();
			Uri photoUrl = _user.getPhotoUrl();

			// Check if user's email is verified
			boolean emailVerified = _user.isEmailVerified();

			// The user's ID, unique to the Firebase project. Do NOT use this value to
			// authenticate with your backend server, if you have one. Use
			// FirebaseUser.getIdToken() instead.
			String uid = _user.getUid();
			//System.out.println("name - " + _user.getDisplayName());

			System.out.println("email - " +_user.getEmail());
		}

	}
	
	public String returnPath(_documentPath docPath){
		return "";
		}


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
//		returnValue = docRef.get().getResult().toObject( City.class );
//		return returnValue;
		
		docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
			City city; //= new City();
			@Override
			public void onSuccess(DocumentSnapshot documentSnapshot) {
				
				if (documentSnapshot.exists()) {
					city = documentSnapshot.toObject(City.class);
					updateUI();
					System.out.println("line 186 db helper -> " + returnValue.getName());
				} else {
				
				}
				//_city =  (City) city;
				//returnValue = (City) city;
				//returnValue = new City(city.getName(),city.getState(),city.getCountry(), city.isCapital(), city.getPopulation(),city.getRegions());
				
			}
			public void updateUI(){
				returnValue = city;
			}
		});
		//return city;
		
		return (City) returnValue;
		//return null;
	}
//	public void update(City _city){
//		returnValue = _city;
//	}
}

