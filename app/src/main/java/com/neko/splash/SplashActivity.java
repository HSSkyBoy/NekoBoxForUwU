package com.neko.splash.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import io.nekohasekai.sagernet.ui.MainActivity;
import io.nekohasekai.sagernet.ui.ThemedActivity;
import com.neko.R;

public class SplashActivity extends ThemedActivity {
    public SplashActivity() {
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int i) {
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Config.ARGB_8888);
        Canvas canvas = r17;
        Canvas canvas2 = new Canvas(createBitmap);
        Canvas canvas3 = canvas;
        int i3 = -12434878;
        Paint paint = r17;
        Paint paint2 = new Paint();
        Paint paint3 = paint;
        Rect rect = r17;
        Rect rect2 = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
        Rect rect3 = rect;
        RectF rectF = r17;
        RectF rectF2 = new RectF(rect3);
        RectF rectF3 = rectF;
        float f = (float) i2;
        paint3.setAntiAlias(true);
        canvas3.drawARGB(0, 0, 0, 0);
        paint3.setColor(-12434878);
        canvas3.drawRoundRect(rectF3, f, f, paint3);
        paint = paint3;
        Xfermode xfermode = r17;
        Xfermode porterDuffXfermode = new PorterDuffXfermode(Mode.SRC_IN);
        Xfermode xfermode2 = paint.setXfermode(xfermode);
        canvas3.drawBitmap(bitmap2, rect3, rect3, paint3);
        return createBitmap;
    }

    public void _Radius_ImageView(ImageView imageView, double d) {
        ImageView imageView2 = imageView;
        double d2 = d;
        imageView2.setImageBitmap(getRoundedCornerBitmap(((BitmapDrawable) imageView2.getDrawable()).getBitmap(), (int) d2));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        String str = "uwu.android.kawai";
        super.onCreate(bundle);
        setContentView(R.layout.uwu_activity_splash);
        Handler handler = r10;
        Handler handler2 = new Handler();
        SplashActivity$1 SplashActivity$1 = r10;
        SplashActivity$1 SplashActivity$12 = new Runnable() {
            public void run() {
                SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
                SplashActivity.this.overridePendingTransition(17432578, 17432579);
            }
        };
        boolean postDelayed = handler.postDelayed(SplashActivity$1, (long) 2500);
        _Radius_ImageView((ImageView) findViewById(R.id.logo_view), (double) 1000);
    }
}