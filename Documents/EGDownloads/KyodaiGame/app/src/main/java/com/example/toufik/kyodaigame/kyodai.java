package com.example.toufik.kyodaigame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by toufik on 24/02/2016.
 */
public class kyodai extends Activity {
    private KyodaiView mKyodaiView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mKyodaiView = (KyodaiView)findViewById(R.id.KyodaiView);
        mKyodaiView.setVisibility(View.VISIBLE);
    }
}
