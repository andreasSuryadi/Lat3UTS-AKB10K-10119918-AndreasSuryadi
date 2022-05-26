package com.example.a10119918uts;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 26 Mei 2022
 *
 */

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, SlideScreenPagerActivity.class);
            startActivity(intent);
            finish();
        }, 2000);

    }
}
