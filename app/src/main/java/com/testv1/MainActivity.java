package com.testv1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crash.FirebaseCrash;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnGo;
    TextView tvResults;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        FirebaseCrash.report(new Exception("My first Android non-fatal error"));
        setViews();
    }

    private void setViews() {
        tvResults = (TextView) findViewById(R.id.result);
        editText = (EditText) findViewById(R.id.editText);
        btnGo = (Button) findViewById(R.id.go);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = editText.getText().toString().trim();
                if (TextUtils.isEmpty(input)) { //check if string is empty
                    displayToastError(getString(R.string.empty_text));
                } else if (!input.matches("[0-9, /,]+")) {//check if string has only numbers and commas
                    displayToastError(getString(R.string.invalid_text));
                } else {//text is valid, so We send that to sumAllDigits(String) and set the result to textview
                    tvResults.setText("" + sumAllDigits(input));
                }
            }
        });
    }

    private void displayToastError(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_LONG).show();
    }

    public long sumAllDigits(String input) {//we remove all commas with regex and cast to long.
        long i = Long.parseLong(input.replaceAll("\\D+", ""));
        return i == 0 ? 0 : i % 10 + sumAllDigits(String.valueOf(i / 10));
    }
}
