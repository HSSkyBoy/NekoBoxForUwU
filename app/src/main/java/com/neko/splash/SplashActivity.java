package com.neko.splash.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import io.nekohasekai.sagernet.ui.MainActivity;
import io.nekohasekai.sagernet.ui.ThemedActivity;
import io.nekohasekai.sagernet.R;

public class SplashActivity extends ThemedActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView logoView = findViewById(R.id.logo_view);
        setCircularImage(logoView);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }, 2500);
    }

    private void setCircularImage(@NonNull ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable == null) {
            return;
        }

        Bitmap bitmap = drawableToBitmap(drawable);
        if (bitmap == null) {
            return;
        }

        Bitmap circularBitmap = getCircularBitmap(bitmap);
        imageView.setImageBitmap(circularBitmap);
    }

    private static Bitmap drawableToBitmap(@NonNull Drawable drawable) {
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            return null;
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private static Bitmap getCircularBitmap(@NonNull Bitmap bitmap) {
        int diameter = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap circularBitmap = Bitmap.createBitmap(diameter, diameter, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(circularBitmap);
        Paint paint = new Paint();
        RectF rect = new RectF(0, 0, diameter, diameter);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawOval(rect, paint);
        return circularBitmap;
    }
}