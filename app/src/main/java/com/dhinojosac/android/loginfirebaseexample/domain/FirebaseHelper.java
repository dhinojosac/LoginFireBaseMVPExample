package com.dhinojosac.android.loginfirebaseexample.domain;

import com.dhinojosac.android.loginfirebaseexample.entities.User;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public class FirebaseHelper {
    private Firebase dataReference;
    private static final String USERS_PATH ="users";
    private static final String CHATS_PATH = "chats";
    private static final String SEPARATOR = "__";
    private static final String CONTACTS_PATH = "contacts";
    private static final String BASE_URL = "https://logintestdohc.firebaseio.com";
    //private static final String BASE_URL = "http://logintestdohc.firebaseapp.com";

    //Singleton holder
    private static class SingletonHolder {
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    //Singleton getInstance
    public static FirebaseHelper getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper() {
        this.dataReference = new Firebase(BASE_URL);
    }

    // Root from Firebase (EndPoint)
    public Firebase getDataReference() {
        return dataReference;
    }

    //Method for return email's user autheticated
    public String getAuthUserEmail(){
        AuthData authData = dataReference.getAuth();
        String email = null;
        if(authData != null){
            Map<String, Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();
        }
        return email;
    }

    //Method that return user reference
    public Firebase getUserReference(String email){
        Firebase userReference = null;
        if (email != null){
            String emailKey = email.replace(".","_");
            userReference =dataReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return  userReference;
    }

    //Method that return my reference
    public Firebase getMyUserReference(){
        return getUserReference(getAuthUserEmail());
    }

    //Method that return one contact
    public Firebase getContactsReference(String email){
        return getUserReference(email).child(CONTACTS_PATH);
    }

    //Method that return one contact
    public Firebase getMyContactsReference(){
        return getContactsReference(getAuthUserEmail());
    }

    //Method that return one contact
    public Firebase getOneContactReference(String mainEmail, String childEmail){
        String childKey = childEmail.replace(".","_");
        return getUserReference(mainEmail).child(CONTACTS_PATH).child(childKey);
    }

    //Method that return chats
    public Firebase getChatsReference(String receiver){
        String keySender =getAuthUserEmail().replace(".","_");
        String keyReceiver =receiver.replace(".","_");

        String keyChat = keySender + SEPARATOR + keyReceiver;
        if(keySender.compareTo(keyReceiver)>0){
            keyChat = keyReceiver + SEPARATOR + keySender;
        }
        return dataReference.getRoot().child(CHATS_PATH).child(keyChat);
    }

    //Change status user connectios
    public void changeUserConnectionStatus(boolean online){
        if (getMyUserReference()!= null){
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("online", online);
            getMyUserReference().updateChildren(updates);
            notifyContactsOfConnectionChange(online);
        }
    }

    //Method that notify to contacts my change connection status
    public void notifyContactsOfConnectionChange(boolean online) {
        notifyContactsOfConnectionChange(online, false);

    }

    public void signOff(){
        notifyContactsOfConnectionChange(User.OFFLINE, true);
    }
    private void notifyContactsOfConnectionChange(final boolean online, final boolean signoff) {
        final String myEmail = getAuthUserEmail();
        getMyContactsReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot child: dataSnapshot.getChildren()){
                    String email = child.getKey();
                    Firebase reference = getOneContactReference(email, myEmail);
                    reference.setValue(online);
                }
                if (signoff){
                    dataReference.unauth();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {           }
        });

    }
}
