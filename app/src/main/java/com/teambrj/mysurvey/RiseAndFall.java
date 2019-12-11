package com.teambrj.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class RiseAndFall extends AppCompatActivity {

    private RecyclerView mRiseFallList;
    private RecyclerView.Adapter mRiseFallListAdapter;
    private RecyclerView.LayoutManager mRiseFallListLayoutManager;

    ArrayList<RiseFallObject> riseFallList;
    ArrayList<String> newArray;

    TextView mHeadName, mHeadDistance, mHeadReading, mHeadReducedLevel, mHeadHeightOfInstrument;

    float knownRL;
    String mStationName = null;
    float mRedecedLevel;
    float mLastSR=0;


    EditText mAddKnownRL;
    Button mAddKnownRLBtn;
    Button mResetAll;

    Button mSetStationNameBtn;
    TextView mSetStationNameTextView;

    EditText mAddDistance;
    EditText mAddSR;
    Button mAddSRBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rise_and_fall);

        mHeadName = findViewById(R.id.name);
        mHeadDistance = findViewById(R.id.distance);
        mHeadReading = findViewById(R.id.reading);
        mHeadReducedLevel = findViewById(R.id.reducedLevel);
        mHeadHeightOfInstrument = findViewById(R.id.heightOfInstrument);



        riseFallList = new ArrayList<>();
        newArray = new ArrayList(Arrays.asList("A","B","C","D","E","F","G"));


        mAddKnownRL = findViewById(R.id.addKnownRL);
        mAddKnownRLBtn = findViewById(R.id.addKnownRLBtn);
        mResetAll = findViewById(R.id.resetAllBtn);
        mAddKnownRLBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                knownRL = Float.valueOf(mAddKnownRL.getText().toString());
                mAddKnownRL.setEnabled(false);
            }
        });


        mResetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetAll();
            }
        });


        mSetStationNameBtn = findViewById(R.id.setStationNameBtn);
        mSetStationNameTextView = findViewById(R.id.setStationNameTextView);

        mSetStationNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ChangeStation();
            }
        });

        mAddDistance = findViewById(R.id.addDistance);
        mAddSR = findViewById(R.id.addSR);
        mAddSRBtn = findViewById(R.id.addSRBtn);
        mAddSRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateRiseFallObject();
                mAddDistance.setText("");
                mAddSR.setText("");
            }
        });

        SetStationName();
        initializeRecyclerView();


    }

    private void ResetAll() {
        knownRL = 0.0f;
        mAddKnownRL.setEnabled(true);
        mAddKnownRLBtn.setVisibility(View.VISIBLE);
        j =0;
        i = 0;
        SetStationName();
        riseFallList.clear();

        mAddKnownRL.setText("");
        mAddDistance.setText("");
        mAddSR.setText("");
        mRiseFallListAdapter.notifyDataSetChanged();


    }

    int i = 0;
    private void CreateRiseFallObject() {
        if(mStationName!=null && mAddDistance!=null && mAddSR!=null){

            switch (i){

                case 0:

                    float mRise = 0, mFall=0;

                    RiseFallObject fObject =  new RiseFallObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),knownRL,mRise,mFall,mStationName,mLastSR);
                    riseFallList.add(fObject);
                    mRiseFallListAdapter.notifyDataSetChanged();
                    mLastSR = Float.parseFloat(mAddSR.getText().toString());
                    i =1;
                    break;
                case 1:

                    mRise = 0.0f;
                    mFall = 0.0f;

                    float difference = mLastSR-Float.parseFloat(mAddSR.getText().toString());

                    knownRL = knownRL + difference;

                    if(difference >0) mRise = difference;
                    if(difference<0) mFall = Math.abs(difference);
                    if(difference == 0) mFall =0;
                    if(difference == 0) mRise =0;


                    RiseFallObject nObject =  new RiseFallObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),knownRL,roundAvoid(mRise),roundAvoid(mFall),mStationName,mLastSR);
                    riseFallList.add(nObject);
                    mRiseFallListAdapter.notifyDataSetChanged();

                    mRise = 0.0f;
                    mFall = 0.0f;
                    break;

                case 2:
                    mRise = 0;
                    mFall = 0;

                    RiseFallObject cObject =  new RiseFallObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),knownRL,mRise,mFall,mStationName,mLastSR);
                    riseFallList.add(cObject);
                    mRiseFallListAdapter.notifyDataSetChanged();
                    mLastSR = Float.parseFloat(mAddSR.getText().toString());
                    i =1;
                    break;

            }

        } mLastSR = Float.parseFloat(mAddSR.getText().toString());
    }

    public void ChangeStation(){
        i =2;
        SetStationName();

    }


    int j=0;
    private void SetStationName() {

        mStationName = newArray.get(j);
        mSetStationNameTextView.setText("Station Name : "+mStationName);
        j++;

    }

    private float roundAvoid(float value) {
        float formated;
        DecimalFormat df =new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);
        formated = Float.parseFloat(df.format(value));
        return formated;
    }



    private void initializeRecyclerView() {
        mRiseFallList = findViewById(R.id.riseFallList);
        mRiseFallList.setNestedScrollingEnabled(false);
        mRiseFallList.setHasFixedSize(false);
        mRiseFallListLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        mRiseFallList.setLayoutManager(mRiseFallListLayoutManager);
        mRiseFallListAdapter = new RiseFallObjectAdapter(riseFallList);
        mRiseFallList.setAdapter(mRiseFallListAdapter);

    }
}
