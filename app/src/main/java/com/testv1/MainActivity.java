package com.testv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnGo;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        tvResults = (TextView) findViewById(R.id.result);
        editText = (EditText) findViewById(R.id.editText);
        btnGo = (Button) findViewById(R.id.go);
    }
}
