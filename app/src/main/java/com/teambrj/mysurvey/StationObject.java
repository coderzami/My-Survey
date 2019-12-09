package com.teambrj.mysurvey;

public class StationObject {
    private float distance, staffReading, reucedLevel, heightOfInstrument;
    private String name;


    public StationObject(float distance, float staffReading, float reucedLevel, float heightOfInstrument, String name) {
        this.distance = distance;
        this.staffReading = staffReading;
        this.reucedLevel = reucedLevel;
        this.heightOfInstrument = heightOfInstrument;
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getStaffReading() {
        return staffReading;
    }

    public void setStaffReading(float staffReading) {
        this.staffReading = staffReading;
    }

    public float getReucedLevel() {
        return reucedLevel;
    }

    public void setReucedLevel(float reucedLevel) {
        this.reucedLevel = reucedLevel;
    }

    public float getHeightOfInstrument() {
        return heightOfInstrument;
    }

    public void setHeightOfInstrument(float heightOfInstrument) {
        this.heightOfInstrument = heightOfInstrument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
