package com.dhinojosac.android.loginfirebaseexample.contactlist.events;

import com.dhinojosac.android.loginfirebaseexample.entities.User;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public class ContactListEvent {
    public final static int onContactAdded = 0 ;
    public final static int onContactChanged= 1 ;
    public final static int onContactRemoved = 2 ;

    private User user;
    private int eventType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
