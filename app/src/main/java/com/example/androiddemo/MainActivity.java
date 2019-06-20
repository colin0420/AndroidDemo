package com.example.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final String TAG = "zhangyao_MainActivity_1";

    private boolean isNeedStartSeconed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isNeedStartSeconed = true;

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override public void onClick(View v) {
                //if (isNeedStartSeconed){
                //    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //    startActivity(intent);
                //}else{
                //    afterSecond();
                //}
            }
        });
    }

    private void afterSecond(){
        Log.d(TAG, "afterSecond");

        Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

        if (isNeedStartSeconed){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            isNeedStartSeconed = false;
        }else{
            afterSecond();
        }
    }

    @Override protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }
}
