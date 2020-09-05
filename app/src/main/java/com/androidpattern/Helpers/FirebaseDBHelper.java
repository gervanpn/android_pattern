package com.androidpattern.Helpers;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.androidpattern.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class FirebaseDBHelper {
	private FirebaseAuth mAuth;
	
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
}
