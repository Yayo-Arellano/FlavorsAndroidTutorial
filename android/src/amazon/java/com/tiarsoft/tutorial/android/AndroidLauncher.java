package com.tiarsoft.tutorial.android;

import android.content.Intent;
import android.os.Bundle;

import com.amazon.ags.api.AmazonGamesCallback;
import com.amazon.ags.api.AmazonGamesClient;
import com.amazon.ags.api.AmazonGamesFeature;
import com.amazon.ags.api.AmazonGamesStatus;
import com.amazon.ags.api.overlay.PopUpLocation;

import java.util.EnumSet;

//Here you can add all the Amazon GameCircle code
public class AndroidLauncher extends AndroidActivity {

    AmazonGamesClient amazonClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        store = "Amazon";
        super.onCreate(savedInstanceState);

    }

    AmazonGamesCallback callback = new AmazonGamesCallback() {
        @Override
        public void onServiceNotReady(AmazonGamesStatus status) {
        }

        @Override
        public void onServiceReady(AmazonGamesClient amazonGamesClient) {
            amazonClient = amazonGamesClient;
            amazonClient.setPopUpLocation(PopUpLocation.TOP_CENTER);
            // ready to use GameCircle
        }
    };

    EnumSet<AmazonGamesFeature> myGameFeatures = EnumSet.of(AmazonGamesFeature.Achievements, AmazonGamesFeature.Leaderboards);

    @Override
    public void onResume() {
        super.onResume();
        AmazonGamesClient.initialize(this, callback, myGameFeatures);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (amazonClient != null) {
            AmazonGamesClient.release();
        }
    }

    public void submitScore(long score) {
        amazonClient.getLeaderboardsClient().submitScore("XXXXXXXXX", score);
    }

    public void unlockAchievement(String achievementId) {
        amazonClient.getAchievementsClient().updateProgress(achievementId, 100.0f);
    }
}
