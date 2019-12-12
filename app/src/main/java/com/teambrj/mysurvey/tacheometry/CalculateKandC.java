package com.teambrj.mysurvey.tacheometry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.teambrj.mysurvey.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculateKandC extends AppCompatActivity {

    EditText smallDistanceID;
    EditText smallInterceptID;
    EditText bigDistanceID;
    EditText bigInterceptID;
    Button calculateKCBtn;
    TextView resultKCtv;

    private void assignViews() {
        smallDistanceID = (EditText) findViewById(R.id.smallDistanceID);
        smallInterceptID = (EditText) findViewById(R.id.smallInterceptID);
        bigDistanceID = (EditText) findViewById(R.id.bigDistanceID);
        bigInterceptID = (EditText) findViewById(R.id.bigInterceptID);
        calculateKCBtn = (Button) findViewById(R.id.calculateKCBtn);
        resultKCtv = (TextView) findViewById(R.id.resultKCtv);
    }


    private Float mSmallDis;
    private Float mSmallIntercept;
    private Float mBigDis;
    private Float mBigIntercept;

    public static float mConstantK = 100;
    public static float mConstantC = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_kand_c);

        assignViews();
        calculateKCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateKC();
            }
        });

    }

    private void CalculateKC() {
        mSmallDis = Float.parseFloat(smallDistanceID.getText().toString());
        mSmallIntercept = Float.parseFloat(smallInterceptID.getText().toString());
        mBigDis = Float.parseFloat(bigDistanceID.getText().toString());
        mBigIntercept = Float.parseFloat(bigInterceptID.getText().toString());

        mConstantK = roundAvoid((mBigDis - mSmallDis)/(mBigIntercept - mSmallIntercept));

        mConstantC = roundAvoid((mSmallDis*mBigIntercept - mBigDis*mSmallIntercept)/(mBigIntercept - mSmallIntercept));

        resultKCtv.setText("Constant K equal to : "+mConstantK+"\n"+"Constant C equal to : "+mConstantC);
    }

    private float roundAvoid(float value) {
        float formated;
        DecimalFormat df =new DecimalFormat();
        df.setMaximumFractionDigits(3);
        df.setRoundingMode(RoundingMode.HALF_UP);
        formated = Float.parseFloat(df.format(value));
        return formated;
    }

    public float getValueOfK(){
        float K = mConstantK;
        return K;
    }

    public float getValueOfC(){
        float C = mConstantC;
        return C;
    }

}
