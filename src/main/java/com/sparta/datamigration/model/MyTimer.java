package com.sparta.datamigration.model;

public class MyTimer {
    private float startTime;
    public void startTimer(){
        this.startTime = System.nanoTime()/1000000000.0f;
    }

    public float endTimer(){
        float runTime = System.nanoTime()/1000000000.0f - startTime;
        return runTime;
    }
}
