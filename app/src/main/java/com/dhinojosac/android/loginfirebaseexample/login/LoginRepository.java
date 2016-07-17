package com.dhinojosac.android.loginfirebaseexample.login;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public interface LoginRepository {
    void signIn(String email, String password);
    void signUp(String email, String password);
    void checkSession();
}
