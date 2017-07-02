package jp.techacademy.takashi.nagamoto.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Float answer = intent.getFloatExtra("ANSWER", 0);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(answer));
    }
}
