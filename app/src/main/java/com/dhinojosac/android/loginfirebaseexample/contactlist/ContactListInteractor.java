package com.dhinojosac.android.loginfirebaseexample.contactlist;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();

    void destroyListener();

    void removeContact(String email);
}
