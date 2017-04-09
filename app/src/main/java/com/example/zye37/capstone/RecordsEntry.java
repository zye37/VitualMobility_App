package com.example.zye37.capstone;

/**
 * Created by zye37 on 4/9/2017.
 */


// a typical model object has an another object's key

// Progress Report:
// 1 Patient user --> Multiple exercises records; 1--> N
// Patients Thomas has exercises records for Standing Lumbar Flexion exercises and other
// exercises

// 1 Exercises --> Exercise records; 1--> N
// Standing Lumbar Flexion exercises has multiple exercises records


import java.sql.Timestamp;


public class RecordsEntry {
    public static final String EXERCISE_KEY = "exerciseKey"; // for Firebase path
    public static final String PATIENT_KEY = "patientKey"; // for Firebase path

    private String key; // each record entry has its own key

    private String exerciseKey;
    private String exerciseName;
    private String exerciseTime; // TimeStamp start exercising time, Date.toString()
    private double ROM;


    // Used by FireBase for deserializing JSON
    public RecordsEntry() {
    }

// Used when creating from scratch

    public RecordsEntry(String exerciseKey, String exerciseName, String exerciseTime, double ROM) {

        this.exerciseKey = exerciseKey;
        this.exerciseName = exerciseName;
        this.exerciseTime = exerciseTime;
        this.ROM = ROM;

    }
}
