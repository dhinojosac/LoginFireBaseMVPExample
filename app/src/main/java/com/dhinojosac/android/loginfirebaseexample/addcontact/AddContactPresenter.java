package com.dhinojosac.android.loginfirebaseexample.addcontact;

import com.dhinojosac.android.loginfirebaseexample.addcontact.events.AddContactEvent;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent evet);
}
