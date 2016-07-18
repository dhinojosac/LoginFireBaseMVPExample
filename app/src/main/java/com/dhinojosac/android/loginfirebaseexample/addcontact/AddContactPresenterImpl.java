package com.dhinojosac.android.loginfirebaseexample.addcontact;

import com.dhinojosac.android.loginfirebaseexample.addcontact.events.AddContactEvent;
import com.dhinojosac.android.loginfirebaseexample.addcontact.ui.AddContactFragment;
import com.dhinojosac.android.loginfirebaseexample.addcontact.ui.AddContactView;
import com.dhinojosac.android.loginfirebaseexample.lib.EventBus;
import com.dhinojosac.android.loginfirebaseexample.lib.GreenRobotEventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class AddContactPresenterImpl implements AddContactPresenter {
    private AddContactView view;
    private EventBus eventBus;
    private AddContactInteractor interactor;

    public AddContactPresenterImpl(AddContactView view) {
        this.view =view;
        this.eventBus = GreenRobotEventBus.getInstance();
        this.interactor = new AddContactInteractorImpl();
    }

    @Override
    public void onShow() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void addContact(String email) {
        if (view != null){
            view.hideInput();
            view.showProgressBar();
        }
        interactor.execute(email);
    }

    @Subscribe
    @Override
    public void onEventMainThread(AddContactEvent evet) {
        if (view != null){
            view.hideProgressBar();
            view.showInput();

            if (evet.isError()){
                view.contactNoAdded();
            }else {
                view.contactAdded();
            }
        }

    }
}
