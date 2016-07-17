package com.dhinojosac.android.loginfirebaseexample.login;

import com.dhinojosac.android.loginfirebaseexample.login.events.LoginEvent;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();

    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

    //Method for EventBus
    void onEventMainThread(LoginEvent event);
}
