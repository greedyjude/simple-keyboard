package rkr.simplekeyboard.inputmethod;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.greedygame.android.agent.GreedyGameAgent;
import com.greedygame.android.core.campaign.CampaignStateListener;

public class DummyActivity extends Activity {
    //TODO: GGCODE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApplication.mGreedyGameAgent = new GreedyGameAgent.Builder(this)
                .enableAdmob(true)
                .setGameId("66081223")
                .addUnitId(BaseApplication.unitId)
                .withAgentListener(new CampaignStateListener() {
                    @Override
                    public void onUnavailable() {

                    }

                    @Override
                    public void onAvailable(String s) {
                        Log.d("GG","Campaign Available");
                        BaseApplication.startAdRefreshTimer();
                    }

                    @Override
                    public void onError(String s) {

                    }
                })
                .build();
        BaseApplication.mGreedyGameAgent.init();
        finish();
    }
}
