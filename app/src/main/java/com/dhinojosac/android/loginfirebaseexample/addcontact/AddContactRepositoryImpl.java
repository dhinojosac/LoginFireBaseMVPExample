package com.dhinojosac.android.loginfirebaseexample.addcontact;

import com.dhinojosac.android.loginfirebaseexample.addcontact.events.AddContactEvent;
import com.dhinojosac.android.loginfirebaseexample.domain.FirebaseHelper;
import com.dhinojosac.android.loginfirebaseexample.entities.User;
import com.dhinojosac.android.loginfirebaseexample.lib.EventBus;
import com.dhinojosac.android.loginfirebaseexample.lib.GreenRobotEventBus;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class AddContactRepositoryImpl implements AddContactRepository {
    private EventBus eventBus;
    private FirebaseHelper helper;

    public AddContactRepositoryImpl() {
        eventBus = GreenRobotEventBus.getInstance();
        helper = FirebaseHelper.getInstance();
    }

    @Override
    public void addContact(final String email) {
        final String key = email.replace(".", "_");
        Firebase userReference = helper.getUserReference(email);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Traer el usuario
                User user = dataSnapshot.getValue(User.class);
                if (user != null){
                    Firebase myUserContactReference = helper.getMyContactsReference();
                    myUserContactReference.child(key).setValue(user.isOnline());

                    String currentUserKey = helper.getAuthUserEmail();
                    currentUserKey = currentUserKey.replace(".","_");

                    Firebase reverseContactReference = helper.getContactsReference(email);
                    reverseContactReference.child(currentUserKey).setValue(User.ONLINE);

                    postSuccess();

                }else {
                    postError();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                postError();
            }
        });
    }

    private void postSuccess(){
        post(false);
    }
    private void postError(){
        post(true);
    }
    private void post(boolean error) {
        AddContactEvent event =  new AddContactEvent();
        event.setError(error);
        eventBus.post(event);
    }
}
