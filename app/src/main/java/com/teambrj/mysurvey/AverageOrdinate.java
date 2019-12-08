package com.teambrj.mysurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.teambrj.mysurvey.MainActivity.hideKeyboard;

public class AverageOrdinate extends AppCompatActivity {

    EditText mLength;
    EditText mAddOrdinate;
    TextView mOrdinateText;
    TextView mResultTextView;
    ArrayList<Float> arrayList = new ArrayList<>();







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_ordinate);

        mLength = findViewById(R.id.lengthId);
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
        float length = Float.valueOf(mLength.getText().toString());


        float sum=0;
        for(float num:arrayList){
            sum = sum +num;
        }
        if(arrayList.size() != 0) {
            float area = length * (sum / arrayList.size());
            mResultTextView.setText("The Area is : " + area);
        } else { Toast.makeText(this,"Array size is: "+arrayList.size(),Toast.LENGTH_LONG).show();}

        hideKeyboard(this);

    }

    private void ResetArrayList() {
        arrayList.clear();
        mOrdinateText.setText("");
        mResultTextView.setText("");
        mLength.setText("");
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
