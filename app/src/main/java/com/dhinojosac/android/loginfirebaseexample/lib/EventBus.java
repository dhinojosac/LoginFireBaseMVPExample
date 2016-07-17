package com.dhinojosac.android.loginfirebaseexample.lib;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
