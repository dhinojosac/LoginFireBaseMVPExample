package com.dhinojosac.android.loginfirebaseexample.login;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignIn(String email, String password);
    void doSignUp(String email, String password);
}
