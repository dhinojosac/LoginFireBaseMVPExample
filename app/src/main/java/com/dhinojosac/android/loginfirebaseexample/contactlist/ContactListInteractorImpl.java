package com.dhinojosac.android.loginfirebaseexample.contactlist;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class ContactListInteractorImpl implements ContactListInteractor {
    private ContactListRepository repository;

    public ContactListInteractorImpl() {
        this.repository = new ContactListRepositoryImpl();
    }
    @Override
    public void subscribe() {
        repository.subscribeToContactListEvents();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribeToContactListEvents();
    }

    @Override
    public void destroyListener() {
        repository.destroyListener();
    }

    @Override
    public void removeContact(String email) {
        repository.removeContact(email);
    }
}
