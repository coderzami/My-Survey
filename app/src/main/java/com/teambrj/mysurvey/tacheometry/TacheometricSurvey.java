package com.teambrj.mysurvey.tacheometry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teambrj.mysurvey.R;
import com.teambrj.mysurvey.RiseAndFall;

public class TacheometricSurvey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tacheometric_survey);

        Button mCalculateKandCBtn =  findViewById(R.id.calculateKandC);

        mCalculateKandCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToCalculateKandC();

            }
        });
    }

    private void SendToCalculateKandC() {
        Intent intent =new Intent(this, CalculateKandC.class);
        startActivity(intent);
    }
}
