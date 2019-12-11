package com.teambrj.mysurvey;

public class RiseFallObject {
    private float distance, staffReading, reducedLevel, lastStaffReading, rise, fall;
    private String name;

    public RiseFallObject(float distance, float staffReading, float reducedLevel, float rise, float fall, String name, float lastStaffReading) {
        this.distance = distance;
        this.staffReading = staffReading;
        this.reducedLevel = reducedLevel;
        this.rise = rise;
        this.fall = fall;
        this.name = name;
        this.lastStaffReading = lastStaffReading;
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
        return reducedLevel;
    }

    public void setReucedLevel(float reducedLevel) {
        this.reducedLevel = reducedLevel;
    }

    public float getLastStaffReading() {
        return lastStaffReading;
    }

    public void setLastStaffReading(float lastStaffReading) {
        this.lastStaffReading = lastStaffReading;
    }

    public float getRise() {
        return rise;
    }

    public void setRise(float rise) {
        this.rise = rise;
    }

    public float getFall() {
        return fall;
    }

    public void setFall(float fall) {
        this.fall = fall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
