package com.dhinojosac.android.loginfirebaseexample.addcontact;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class AddContactInteractorImpl implements AddContactInteractor {
    AddContactRepository repository;

    public AddContactInteractorImpl() {
        this.repository = new AddContactRepositoryImpl();
    }

    @Override
    public void execute(String email) {
        repository.addContact(email);
    }
}
