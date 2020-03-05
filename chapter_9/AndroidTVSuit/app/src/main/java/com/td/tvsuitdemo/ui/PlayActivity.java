package com.td.tvsuitdemo.ui;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.exoplayer2.Player;
import com.td.exoplayer.PlayerExo;
import com.td.exoplayer.PlayerView;
import com.td.exoplayer.utils.C;
import com.td.tvsuitdemo.R;
import com.td.tvsuitdemo.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayActivity extends BaseActivity implements PlayerView.PlayState, PlayerExo.TryModeIml {
    @BindView(R.id.pv)
    PlayerView pv;
    private String url = "";
    private PlayerExo playerExo;
    private Uri[] uris = new Uri[1];
    private String adUrl = "";
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        initView();
    }

    private void initView() {
        ButterKnife.bind(this);
        uris[0] = Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
        playerExo = new PlayerExo(this, pv);
        playerExo.setLoop(true);
        playerExo.setLoop(false);
        pv.setPlayStateListener(this);
        pv.setTVMode(false);
        initExoPlayer();
    }

    private void initExoPlayer() {
        adUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        playerExo.setStartPosition(C.INDEX_UNSET, C.TIME_UNSET);
        //http://event.android-studio.org/images/event/201605/google-io-2016/gizmodo-02-Google-Assistant-1.gif
        //https://source.android.google.cn/devices/tv/images/LiveChannels_Add_channel.png
        playerExo.initExoPlayer(uris, "");
        playerExo.setLoop(false);
//        playerExo.setTryFreeMode(true);
//        playerExo.setTryTime(10 * 1000);
//        playerExo.setTryModeIml(this);
        pv.setPlayStateListener(this);
    }

    @Override
    public void playComplete() {

    }

    @Override
    public void onTryComplete() {
        Toast.makeText(this, "tryComplete", Toast.LENGTH_SHORT).show();
        System.out.println("tryComplete");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pv != null) {
            pv.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (pv != null) {
            pv.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        playerExo.releaseAdsLoader();
        playerExo.releasePlayer();
    }
}
