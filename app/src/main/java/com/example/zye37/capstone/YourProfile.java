package com.example.zye37.capstone;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.RadioButton;
import java.util.Map;
import java.util.HashMap;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;

public class YourProfile extends AppCompatActivity {
    private Button btnCreate;
    private EditText userName, DOB, programStart;
    private RadioButton gender;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        btnCreate = (Button) findViewById(R.id.btnCreate);
        userName = (EditText) findViewById(R.id.InputName);
        DOB = (EditText) findViewById(R.id.InputDOB);
        programStart = (EditText) findViewById(R.id.ProgramStartDate);

//write patient users profile into "patientUser" table
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String DateOfBirth = DOB.getText().toString();
                String initiate = programStart.getText().toString();

                patient newPatient = new patient(name, DateOfBirth, initiate);
                String UID = auth.getCurrentUser().getUid();
                ref.child("patientUser").child(UID).setValue(newPatient);

                /*
                Below codes serve only for testing purpose
                Manually create 10 RecordEntry data points once the user profile is created
                and manually output data point to the progress report page
                 */
                RecordEntry[] recordEntries = new RecordEntry[10];
                recordEntries[0] = new RecordEntry("2017-02-04", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 30.2);
                recordEntries[1] = new RecordEntry("2017-02-07", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 31.8);
                recordEntries[2] = new RecordEntry("2017-02-09", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 32.2);
                recordEntries[3] = new RecordEntry("2017-02-12", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 31.7);
//                RecordEntry record5 = new RecordEntry("2017-02-15", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 32.6);
//                RecordEntry record6 = new RecordEntry("2017-02-18", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 32.4);
//                RecordEntry record7 = new RecordEntry("2017-02-20", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 34.9);
//                RecordEntry record8 = new RecordEntry("2017-02-23", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 33.7);
//                RecordEntry record9 = new RecordEntry("2017-02-25", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 35.8);
//                RecordEntry record10 = new RecordEntry("2017-02-28", ExerciseType.FLEXION, FlexionExercisesType.StandingLumbarFlexion, 37.0);


                DatabaseReference userRef = ref.child("patientUser").child(UID).child("RecordEntry"); //.child(record1.getPerformDate());
                Map<String, RecordEntry> thomasMap = new HashMap<String, RecordEntry>();
                for (RecordEntry entry: recordEntries) {
                    thomasMap.put(entry.getPerformDate(), entry);
                }
//                thomasMap.put(record1.getPerformDate(),record1);
//                thomasMap.put(record2.getPerformDate(),record2 );

//                Map<String, Map<String,String>> thomasRecord = new HashMap<String, Map<String, String>>();
//                thomasRecord.put("2017-02-04", thomasMap);

                userRef.setValue(thomasMap);
//                userRef.setValue(record1);
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
