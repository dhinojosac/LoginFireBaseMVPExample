package com.dhinojosac.android.loginfirebaseexample.contactlist.ui.adapters;

import com.dhinojosac.android.loginfirebaseexample.entities.User;

/**
 * Created by negro-PC on 17-Jul-16.
 */
public interface OnItemClickListener {
    void onItemOnClick(User user);
    void onItemLongClick(User user);
}
