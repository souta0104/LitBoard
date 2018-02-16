package com.lifeistech.android.litboard;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PostActivity extends AppCompatActivity {
    TextView mainText;
    TextView timeText;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mainText = (TextView) findViewById(R.id.text_message_body);
        editText = (EditText) findViewById(R.id.editText);
        timeText = (TextView) findViewById(R.id.text_message_time);

    }

    public void button(View v) {
        if (!editText.getText().toString().equals("")) {
            // Dateクラスで現在日時を取得
            Date d = new Date();
            System.out.println(d); // 出力結果：Fri Aug 05 00:28:47 GMT+09:00 2016

            // その２"yyyy年MM月dd日 HH時mm分ss秒"
            SimpleDateFormat d1 = new SimpleDateFormat("HH:mm");
            String q1 = d1.format(d); // format(d)のdは、Date d = new Date();のd

            mainText.setText(editText.getText().toString());
            editText.setText("");
            timeText.setText(q1.toString());
        }else{
            Toast.makeText(getApplicationContext(),"メッセージを入力してください。",Toast.LENGTH_SHORT).show();
        }
    }
}
