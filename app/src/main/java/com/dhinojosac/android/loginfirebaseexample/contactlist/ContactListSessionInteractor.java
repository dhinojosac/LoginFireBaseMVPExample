package com.dhinojosac.android.loginfirebaseexample.contactlist;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface ContactListSessionInteractor {
    //metodos para manejar la sesion
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
