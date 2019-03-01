package com.example.androiddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.androiddemo.mvp.TestMVPActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener()
        {

            @Override public void onClick(View v) {
                //NewsContentActivity.actionStart();
                TestMVPActivity.JumpToTestMVPActivity(MainActivity.this);
            }
        });
    }
}
