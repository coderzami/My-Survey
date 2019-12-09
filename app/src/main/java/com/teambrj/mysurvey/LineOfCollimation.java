package com.teambrj.mysurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class LineOfCollimation extends AppCompatActivity {

    private RecyclerView mStationList;
    private RecyclerView.Adapter mStationListAdapter;
    private RecyclerView.LayoutManager mStationListLayoutManager;

    ArrayList<StationObject> stationList;
    ArrayList<String> newArray;

    TextView mHeadName, mHeadDistance, mHeadReading, mHeadReducedLevel, mHeadHeightOfInstrument;

    float knownRL;
    float hOfI;
    String mStationName = null;
    float mRedecedLevel;
    float mDistance;

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
        setContentView(R.layout.activity_line_of_collimation);

        mHeadName = findViewById(R.id.name);
        mHeadDistance = findViewById(R.id.distance);
        mHeadReading = findViewById(R.id.reading);
        mHeadReducedLevel = findViewById(R.id.reducedLevel);
        mHeadHeightOfInstrument = findViewById(R.id.heightOfInstrument);



        stationList = new ArrayList<>();
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
                CreateStationObject();
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
        stationList.clear();

        mAddKnownRL.setText("");
        mAddDistance.setText("");
        mAddSR.setText("");
        mStationListAdapter.notifyDataSetChanged();


    }

    int i = 0;
    private void CreateStationObject() {
        if(mStationName!=null && mAddDistance!=null && mAddSR!=null){

            switch (i){

                case 0:
                    hOfI = knownRL + Float.valueOf(mAddSR.getText().toString());

                    StationObject fObject =  new StationObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),knownRL,hOfI,mStationName);
                    stationList.add(fObject);
                    mStationListAdapter.notifyDataSetChanged();
                    i =1;
                    break;
                case 1:

                    mRedecedLevel = hOfI - Float.parseFloat(mAddSR.getText().toString());

                    StationObject nObject =  new StationObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),mRedecedLevel,hOfI,mStationName);
                    stationList.add(nObject);
                    mStationListAdapter.notifyDataSetChanged();
                    break;

                case 2:
                    hOfI = mRedecedLevel + Float.valueOf(mAddSR.getText().toString());

                    StationObject cObject =  new StationObject(Float.parseFloat(mAddDistance.getText().toString()),Float.parseFloat(mAddSR.getText().toString()),knownRL,hOfI,mStationName);
                    stationList.add(cObject);
                    mStationListAdapter.notifyDataSetChanged();
                    i =1;
                    break;

            }

        }
    }

    public void ChangeStation(){
        hOfI = mRedecedLevel + Float.valueOf(mAddSR.getText().toString());
        i =2;
        SetStationName();

    }


    int j=0;
    private void SetStationName() {

        mStationName = newArray.get(j);
        mSetStationNameTextView.setText("Station Name : "+mStationName);
        j++;

    }


    private void initializeRecyclerView() {
        mStationList = findViewById(R.id.stationList);
        mStationList.setNestedScrollingEnabled(false);
        mStationList.setHasFixedSize(false);
        mStationListLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false);
        mStationList.setLayoutManager(mStationListLayoutManager);
        mStationListAdapter = new StationObjectAdapter(stationList);
        mStationList.setAdapter(mStationListAdapter);

    }
}
