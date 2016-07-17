package com.dhinojosac.android.loginfirebaseexample.login;

/**
 * Created by negro-PC on 16-Jul-16.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl() {
        this.loginRepository = new LoginRepositoryImpl();
    }

    @Override
    public void checkSession() {
        loginRepository.checkSession();
    }

    @Override
    public void doSignIn(String email, String password) {
        loginRepository.signIn(email, password);
    }

    @Override
    public void doSignUp(String email, String password) {
        loginRepository.signUp(email, password);
    }
}
