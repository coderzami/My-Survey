package com.teambrj.mysurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button mAvgOrdinateBtn;
    Button mSimpsonBtn;
    Button mMidOrdinateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAvgOrdinateBtn = findViewById(R.id.avgOrdinate);
        mMidOrdinateBtn = findViewById(R.id.midOrdinateBtnId);
        mSimpsonBtn = findViewById(R.id.simpsonBtnId);
        mAvgOrdinateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SendToAverageOrdinate();
            }
        });

        mMidOrdinateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToMidOrdinate();
            }
        });

        mSimpsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToSimpson();
            }
        });




    }

    private void SendToMidOrdinate() {
        Intent intent = new Intent(this ,MidOrdinate.class);
        startActivity(intent);
    }

    private void SendToSimpson() {
        Intent intent = new Intent(this ,Simpson.class);
        startActivity(intent);
    }

    private void SendToAverageOrdinate() {
        Intent intent = new Intent(this ,AverageOrdinate.class);
        startActivity(intent);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}
