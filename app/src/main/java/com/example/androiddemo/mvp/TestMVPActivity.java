package com.example.androiddemo.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.androiddemo.R;

public class TestMVPActivity extends AppCompatActivity implements TestContract.View{

    private TestContract.Presenter presenter = new TestPresenter(this, TestModel.getInstance());
    private Button button1;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mvp);

        textView = findViewById(R.id.text_view1);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                presenter.getData();
            }
        });
    }

    @Override public void showData(String str) {
        textView.setText(str);
    }

    public static void JumpToTestMVPActivity(Context context){
        Intent intent = new Intent(context, TestMVPActivity.class);
        context.startActivity(intent);
    }
}
