package com.dhinojosac.android.loginfirebaseexample.login.events;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class LoginEvent {
    public static final int onSignInError = 0;
    public static final int onSignUpError = 1;
    public static final int onSignInSuccess = 2;
    public static final int onSignUpSuccess = 3;
    public static final int onFailedToRecoverySession = 4;

    private int eventType;
    private String errorMessage;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
