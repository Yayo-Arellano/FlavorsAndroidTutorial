package com.tiarsoft.tutorial.android;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.tiarsoft.tutorial.MainGame;

public class AndroidActivity extends AndroidApplication {

    String store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MainGame(), config);

        Gdx.app.log("Store", store);
    }
}
