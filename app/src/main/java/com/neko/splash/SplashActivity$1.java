package com.neko.splash.app;

import android.content.Intent;
import io.nekohasekai.sagernet.ui.MainActivity;

class SplashActivity$1 implements Runnable {
    final /* synthetic */ SplashActivity this$0;

    SplashActivity$1(SplashActivity splashActivity) {
        this.this$0 = splashActivity;
    }

    public void run() {
        this.this$0.startActivity(new Intent(this.this$0, MainActivity.class));
        this.this$0.finish();
        this.this$0.overridePendingTransition(17432578, 17432579);
    }
}