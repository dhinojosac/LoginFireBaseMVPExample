package com.dhinojosac.android.loginfirebaseexample.contactlist;

import com.dhinojosac.android.loginfirebaseexample.contactlist.events.ContactListEvent;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface ContactListPresenter {
    void onCreate();
    void onDestroy();
    void onPause(); //Para no mantener la coneccion con Firebase siempre abierta
    void onResume();

    void singOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    void onEventMainThread(ContactListEvent event);

}
