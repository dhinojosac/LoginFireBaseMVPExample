package com.dhinojosac.android.loginfirebaseexample.login;

import android.util.Log;

import com.dhinojosac.android.loginfirebaseexample.domain.FirebaseHelper;
import com.dhinojosac.android.loginfirebaseexample.entities.User;
import com.dhinojosac.android.loginfirebaseexample.lib.EventBus;
import com.dhinojosac.android.loginfirebaseexample.lib.GreenRobotEventBus;
import com.dhinojosac.android.loginfirebaseexample.login.events.LoginEvent;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public class LoginRepositoryImpl implements LoginRepository{
    private FirebaseHelper helper;
    private Firebase dataReference;
    private Firebase myUserReference;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
        this.dataReference = helper.getDataReference();
        this.myUserReference = helper.getMyUserReference();
    }

    @Override
    public void signIn(String email, String password) {

        dataReference.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
               initSignIn();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignInError, firebaseError.getMessage());
            }
        });

        //postEvent(LoginEvent.onSignInError, "Cueck");
    }

    @Override
    public void signUp(final String email, final String password) {
        dataReference.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                postEvent(LoginEvent.onSignUpSuccess);
                signIn(email, password);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignUpError, firebaseError.getMessage());
            }
        });
        //postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void checkSession() {
        if(dataReference.getAuth() != null){
            initSignIn();
        }else {
            postEvent(LoginEvent.onFailedToRecoverySession);
        }

    }

    private void initSignIn(){
        myUserReference = helper.getMyUserReference();
        myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User currentUser = dataSnapshot.getValue(User.class);

                if (currentUser == null){
                    registerNewUser();
                }
                helper.changeUserConnectionStatus(User.ONLINE);
                postEvent(LoginEvent.onSignInSuccess);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {                    }
        });
    }

    private void registerNewUser(){
        String email = helper.getAuthUserEmail();
        if(email != null){
            User currentUser = new User();
            currentUser.setEmail(email);
            myUserReference.setValue(currentUser);
        }
    }

    //Method for post event
    private void postEvent(int type, String error){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if(error != null){
            loginEvent.setErrorMessage(error);
        }

        EventBus eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }

    private void postEvent(int type){
        postEvent(type, null);
    }


}
