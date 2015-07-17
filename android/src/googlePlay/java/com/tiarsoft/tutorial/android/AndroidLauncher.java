package com.tiarsoft.tutorial.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.tiarsoft.tutorial.MainGame;

//Here you can add all the google game services code
public class AndroidLauncher extends AndroidActivity implements GameHelper.GameHelperListener {

    private GameHelper gameHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        store = "Google PLay";
        super.onCreate(savedInstanceState);

        gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
        gameHelper.setup(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        gameHelper.onStart(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        gameHelper.onStop();
    }

    @Override
    public void onActivityResult(int request, int response, Intent data) {
        super.onActivityResult(request, response, data);
        gameHelper.onActivityResult(request, response, data);
    }

    public void submitScore(long score) {
            Games.Leaderboards.submitScore(gameHelper.getApiClient(),"xxxxxxxxx", score);

    }

    public void unlockAchievement(String achievementId) {
            Games.Achievements.unlock(gameHelper.getApiClient(), achievementId);
    }


    @Override
    public void onSignInFailed() {

    }

    @Override
    public void onSignInSucceeded() {

    }
}
