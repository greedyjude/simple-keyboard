package rkr.simplekeyboard.inputmethod;

import android.app.Activity;
import android.app.Application;
import android.os.CountDownTimer;
import android.util.Log;

import com.greedygame.android.agent.GreedyGameAgent;

public class BaseApplication extends Application {
    //TODO GGCODE
   public static Activity mActivity = null;
   public static GreedyGameAgent mGreedyGameAgent = null;
   public static String unitId = "float-4345";
   public static CountDownTimer adRefreshTimer = null;

    public static void startAdRefreshTimer() {
        if(adRefreshTimer == null){
            adRefreshTimer = new CountDownTimer(700000,1000) {
                //This timer refreshes the ad every 70 seconds.
                // If its not ready for a refresh it will just ignore the call
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    this.start();
                    Log.d("GG","Ad Refreshing");
                    if(mGreedyGameAgent != null){
                        mGreedyGameAgent.startEventRefresh();
                    }
                }
            };
        }
        adRefreshTimer.start();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mActivity = new Activity();
    }

}

