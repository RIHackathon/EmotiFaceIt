package com.rsquared.robert.emotifaceit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by emesh on 12/3/2016.
 */

public class TestListView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_listview);

        startActivity(new Intent("android.intent.action.TESTLISTVIEW"));
    }
}
