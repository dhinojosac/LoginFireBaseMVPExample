package com.dhinojosac.android.loginfirebaseexample.contactlist.ui;

import com.dhinojosac.android.loginfirebaseexample.entities.User;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface ContactListView {
    //Esperamos que la vista reaccione cuando:
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}
