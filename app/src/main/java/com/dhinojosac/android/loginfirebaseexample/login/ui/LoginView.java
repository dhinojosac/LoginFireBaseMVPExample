package com.dhinojosac.android.loginfirebaseexample.login.ui;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    //Method that allow us manage
    void handleSignIn();
    void handleSignUp();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}
