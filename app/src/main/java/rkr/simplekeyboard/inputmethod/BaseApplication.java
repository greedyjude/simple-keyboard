package rkr.simplekeyboard.inputmethod;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.greedygame.android.agent.GreedyGameAgent;

public class BaseApplication extends Application {
   public static Activity mActivity = null;
   public static GreedyGameAgent mGreedyGameAgent = null;
   public static String unitId = "float-4345";
    @Override
    public void onCreate() {
        super.onCreate();
        mActivity = new Activity();
    }
}

