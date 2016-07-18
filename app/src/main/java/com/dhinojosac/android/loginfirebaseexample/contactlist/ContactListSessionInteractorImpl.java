package com.dhinojosac.android.loginfirebaseexample.contactlist;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class ContactListSessionInteractorImpl implements ContactListSessionInteractor {
    private ContactListRepository repository;

    public ContactListSessionInteractorImpl() {
        this.repository = new ContactListRepositoryImpl();
    }

    @Override
    public void signOff() {
        repository.signOff();
    }

    @Override
    public String getCurrentUserEmail() {
        return repository.getCurrentUserEmail();
    }

    @Override
    public void changeConnectionStatus(boolean online) {
        repository.changeConnectionStatus(online);
    }
}
