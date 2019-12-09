package com.teambrj.mysurvey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StationObjectAdapter extends RecyclerView.Adapter<StationObjectAdapter.StationListViewHolder> {

    ArrayList<StationObject> stationList;

    public StationObjectAdapter(ArrayList<StationObject> stationList) {
        this.stationList = stationList;
    }

    @NonNull
    @Override
    public StationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        StationListViewHolder rcv = new StationListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull StationListViewHolder holder, int position) {

        holder.mName.setText(stationList.get(position).getName());
        holder.mDistance.setText(String.valueOf(stationList.get(position).getDistance()));
        holder.mReading.setText(String.valueOf(stationList.get(position).getStaffReading()));
        holder.mReducedLevel.setText(String.valueOf(stationList.get(position).getReucedLevel()));
        holder.mHeightOfInstrument.setText(String.valueOf(stationList.get(position).getHeightOfInstrument()));

    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    class StationListViewHolder extends RecyclerView.ViewHolder {
        TextView mName, mDistance, mReading, mReducedLevel, mHeightOfInstrument;
        LinearLayout mLayout;

        StationListViewHolder(View view){
            super(view);

            mName = view.findViewById(R.id.name);
            mDistance = view.findViewById(R.id.distance);
            mReading = view.findViewById(R.id.reading);
            mReducedLevel = view.findViewById(R.id.reducedLevel);
            mHeightOfInstrument = view.findViewById(R.id.heightOfInstrument);
            mLayout = view.findViewById(R.id.layout);

        }

    }
}
