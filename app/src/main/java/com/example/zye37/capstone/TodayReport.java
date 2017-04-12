package com.example.zye37.capstone;
import android.widget.EditText;
import android.widget.ProgressBar;
import java.util.Map;
/**
 * Created by zye37 on 4/5/2017.
 */
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.sql.Types.*;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;

public class TodayReport extends Fragment{

    private EditText flexionProgressNum, extensionProgressNum, lateralProgressNum;
    private ProgressBar flexionBar, extensionBar, lateralBar;
    private Button updateBtn;
    private FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_today_report, container, false);

        flexionProgressNum = (EditText) rootView.findViewById(R.id.FlexionROM_Percentage);
        extensionProgressNum = (EditText) rootView.findViewById(R.id.ExtensionROM_Percentage);
        lateralProgressNum =(EditText) rootView.findViewById(R.id.LateralFlexionROM_Percentage);

        flexionBar = (ProgressBar) rootView.findViewById(R.id.Flexion_progressBar);
        extensionBar = (ProgressBar) rootView.findViewById(R.id.Extension_progressBar);
        lateralBar = (ProgressBar) rootView.findViewById(R.id.LateralFlexion_progressBar);


        updateBtn = (Button) rootView.findViewById(R.id.Today_Update_Button);


        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        String UID = auth.getCurrentUser().getUid();
        final DatabaseReference userRef = ref.child(UID).child("RecordEntry");



        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                            RecordEntry entry= (RecordEntry) dataSnapshot.getValue(RecordEntry.class);
                            System.out.println(entry);
                            flexionProgressNum.setText("40");
                            extensionProgressNum.setText("25");
                            lateralProgressNum.setText("12");

                        flexionBar.setProgress(68);
                        extensionBar.setProgress(25);
                        lateralBar.setProgress(12);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getCode());
                    }
                });
            }});

        return rootView;




    }
}
