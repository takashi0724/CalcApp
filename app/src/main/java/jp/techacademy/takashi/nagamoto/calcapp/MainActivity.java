package jp.techacademy.takashi.nagamoto.calcapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //足す
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        //引く
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        //かける
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        //割る
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);

    }

    @Override
    public void onClick(View v) {
        float val1 = Float.valueOf(mEditText1.getText().toString());
        float val2 = Float.valueOf(mEditText2.getText().toString());
        float answer = 0;
        if (v.getId() == R.id.button1) {
            answer = val1 + val2;
        } else if (v.getId() == R.id.button2) {
            answer = val1 - val2;
        } else if (v.getId() == R.id.button3) {
            answer = val1 * val2;
        } else {
            if (val2 != 0) {
                answer = val1 / val2;
            } else {
                new AlertDialog.Builder(this)
                        .setTitle("エラー")
                        .setMessage("0で割らないでください。")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

        }

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("ANSWER", answer);
        startActivity(intent);
    }
}
