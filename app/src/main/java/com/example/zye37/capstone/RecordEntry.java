package com.example.zye37.capstone;
import java.util.Date;
import java.text.*;
/**
 * Created by zye37 on 4/11/17.
 */

public class RecordEntry {
    private String performDate;
    private ExerciseType type;
    private FlexionExercisesType exerciseName;
    private double ROM;

// Default constructor for calls
    public RecordEntry() {
    }

    public RecordEntry(String date, ExerciseType flexion, FlexionExercisesType slf, double rangeOfMotion) {
 //       Date dNow = new Date();
 //       SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd");
 //       performDate = ft.format(dNow);
        performDate = date; // for dummy data, the format is yyyy.MM.dd: 2004.08.09
        type = flexion;
        exerciseName = slf;
        ROM = rangeOfMotion;
    }

//getting methods to obtain each attribute
    public String getPerformDate() {
        return performDate;
    }

    public ExerciseType getType() {
        return type;
    }

    public FlexionExercisesType getExerciseName() {
        return exerciseName;
    }

    public double getROM() {
        return ROM;
    }
}
