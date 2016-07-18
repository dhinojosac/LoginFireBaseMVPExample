package com.dhinojosac.android.loginfirebaseexample.addcontact.events;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class AddContactEvent {
    boolean error =  false;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
