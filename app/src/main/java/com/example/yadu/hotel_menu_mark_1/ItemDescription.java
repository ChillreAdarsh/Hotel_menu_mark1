package com.example.yadu.hotel_menu_mark_1;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yadu on 06/02/15.
 */
public class ItemDescription extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemdescription);
        nitView();
        initDrawer();
        toolbar.setTitle("Hotel Menu");
        setSupportActionBar(toolbar);
    }
}
