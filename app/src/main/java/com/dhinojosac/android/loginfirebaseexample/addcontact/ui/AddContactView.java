package com.dhinojosac.android.loginfirebaseexample.addcontact.ui;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgressBar();
    void hideProgressBar();

    void contactAdded();
    void contactNoAdded();
}
