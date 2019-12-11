package com.teambrj.mysurvey;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RiseFallObjectAdapter extends RecyclerView.Adapter<RiseFallObjectAdapter.RiseFallListViewHolder> {

    ArrayList<RiseFallObject> risefallList;

    public RiseFallObjectAdapter(ArrayList<RiseFallObject> risefallList) {
        this.risefallList = risefallList;
    }

    @NonNull
    @Override
    public RiseFallListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_risefall,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        RiseFallListViewHolder rcv = new RiseFallListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull RiseFallListViewHolder holder, int position) {

        holder.mName.setText(risefallList.get(position).getName());
        holder.mDistance.setText(String.valueOf(risefallList.get(position).getDistance()));
        holder.mReading.setText(String.valueOf(risefallList.get(position).getStaffReading()));
        holder.mRise.setText(String.valueOf(risefallList.get(position).getRise()));
        holder.mFall.setText(String.valueOf(risefallList.get(position).getFall()));
        holder.mReducedLevel.setText(String.valueOf(risefallList.get(position).getReucedLevel()));

    }

    @Override
    public int getItemCount() {
        return risefallList.size();
    }

    class RiseFallListViewHolder extends RecyclerView.ViewHolder {
        TextView mName, mDistance, mReading, mReducedLevel, mRise, mFall;
        LinearLayout mLayout;

        RiseFallListViewHolder(View view){
            super(view);

            mName = view.findViewById(R.id.name);
            mDistance = view.findViewById(R.id.distance);
            mReading = view.findViewById(R.id.reading);
            mRise = view.findViewById(R.id.rise);
            mFall = view.findViewById(R.id.fall);
            mReducedLevel = view.findViewById(R.id.reducedLevel);
            mLayout = view.findViewById(R.id.layout);

        }

    }
}

