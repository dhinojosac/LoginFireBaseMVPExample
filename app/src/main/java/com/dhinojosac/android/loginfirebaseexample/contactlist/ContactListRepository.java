package com.dhinojosac.android.loginfirebaseexample.contactlist;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface ContactListRepository {
    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void destroyListener();
    void subscribeToContactListEvents();
    void unsubscribeToContactListEvents();
    void changeConnectionStatus(boolean online);

}
