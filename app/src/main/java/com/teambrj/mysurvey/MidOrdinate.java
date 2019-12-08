package com.teambrj.mysurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MidOrdinate extends AppCompatActivity {

    EditText mInterval;
    EditText mAddOrdinate;
    TextView mOrdinateText;
    TextView mResultTextView;
    ArrayList<Float> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_ordinate);



        mInterval = findViewById(R.id.intervalId);
        mAddOrdinate = findViewById(R.id.addOrdinateId);
        mOrdinateText = findViewById(R.id.ordinateTextViewId);
        mResultTextView =findViewById(R.id.resultTextViewId);
        Button mAreaCalculate = findViewById(R.id.calculateAreaBtnId);
        Button mAddOrdinateBtn = findViewById(R.id.addOrdinateBtn);
        Button mResetOrdinateBtn = findViewById(R.id.resetOrdinateBtn);

        mAddOrdinateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(mAddOrdinate.getText())) {
                    Toast.makeText(getApplicationContext(),"Please input number",Toast.LENGTH_SHORT).show();
                } else {
                    Float inputValue = Float.valueOf(mAddOrdinate.getText().toString());
                    AddToArrayList(inputValue);
                    mAddOrdinate.setText("");
                }
            }
        });

        mResetOrdinateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetArrayList();
            }
        });

        mAreaCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateArea();

            }
        });
    }

    private void CalculateArea() {

        if(arrayList.size()%2 ==0) {

            float interval = Float.valueOf(mInterval.getText().toString());

            float firstElement = Float.valueOf(arrayList.get(0));
            float lastElement = Float.valueOf(arrayList.get(arrayList.size() - 2));


            float sum1 = firstElement + lastElement;
            float sumOdd = 0;
            float sumEven = 0;


            for (int i = 1; i < arrayList.size() - 2; i++) {


                if (i % 2 == 0) {
                    sumEven = sumEven + arrayList.get(i);
                } else {
                    sumOdd = sumOdd + arrayList.get(i);
                }
            }

            Log.d("SUM", "The sum of first and last : " + sum1);
            Log.d("SUM", "The sum of odd : " + sumOdd);
            Log.d("SUM", "The sum of even : " + sumEven);



            if (arrayList.size() != 0) {
                float area1 = (interval / 3) * (sum1 + 4 * sumOdd + 2 * sumEven);

                Log.d("SUM", "The sum of area1 : " + area1);


                float extraElement = Float.valueOf(arrayList.get(arrayList.size() - 1));
                float area2 = ((lastElement + extraElement) / 2) * interval;
                Log.d("SUM", "The sum of area2 : " + area2);

                float area = area1+area2;
                Log.d("SUM", "The sum of area: " + area);

                mResultTextView.setText("The Area is : "+area);

            } else {
                Toast.makeText(this, "Array size is: " + arrayList.size(), Toast.LENGTH_LONG).show();
            }




        } else {




            float interval = Float.valueOf(mInterval.getText().toString());

            float firstElement = Float.valueOf(arrayList.get(0));
            float lastElement = Float.valueOf(arrayList.get(arrayList.size() - 1));


            float sum1 = firstElement + lastElement;
            float sumOdd = 0;
            float sumEven = 0;


            for (int i = 1; i < arrayList.size() - 1; i++) {


                if (i % 2 == 0) {
                    sumEven = sumEven + arrayList.get(i);
                } else {
                    sumOdd = sumOdd + arrayList.get(i);
                }
            }

            Log.d("SUM", "The sum of first and last : " + sum1);
            Log.d("SUM", "The sum of odd : " + sumOdd);
            Log.d("SUM", "The sum of even : " + sumEven);


            if (arrayList.size() != 0) {
                float area = (interval / 3) * (sum1 + 4 * sumOdd + 2 * sumEven);
                mResultTextView.setText("The Area is : " + area);
            } else {
                Toast.makeText(this, "Array size is: " + arrayList.size(), Toast.LENGTH_LONG).show();
            }

        }



    }

    private void ResetArrayList() {
        arrayList.clear();
        mOrdinateText.setText("");
        mResultTextView.setText("");
        mInterval.setText("");
    }

    private void AddToArrayList(float inputValue) {
        arrayList.add(inputValue);
        AddToTextView();


    }

    private void AddToTextView(){

        mOrdinateText.setText("");
        for(int i=0;i<arrayList.size();i++){
            mOrdinateText.append(arrayList.get(i)+",");
        }


    }

}
