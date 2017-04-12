package com.example.zye37.capstone;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.Viewport;
import java.util.Random;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.ChildEventListener;
/**
 * Created by zye37 on 4/5/2017.
 */

public class WeeklyReport extends Fragment {

    private GraphView weekPlot;
    private LineGraphSeries<DataPoint> series;
    private int lastX = 0;
    private static final Random RANDOM = new Random();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weekly_report, container, false);

        // the following codes aim to create a scatterplot with data points grabbed from firebase
         weekPlot = (GraphView) rootView.findViewById(R.id.week_Plot);

         series = new LineGraphSeries<DataPoint>();
         weekPlot.addSeries(series);

        //customize a viewport
        Viewport viewport = weekPlot.getViewport();
        viewport.setYAxisBoundsManual(true);
        viewport.setMinY(0);
        viewport.setMaxY(100);
        viewport.setScrollable(true);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // add 100 new entries
                for (int i=0; i < 100; i++) {
                    getActivity().runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            addEntry();
                        }
                    });

                    //sleep to slow down the add of entries
                    try{
                        Thread.sleep(600);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }


        }).start();
    }


    // add random data to graph
    private void addEntry() {
        //display max 10 datapoint on the viewpoint
        series.appendData(new DataPoint(lastX++, RANDOM.nextDouble() *100d), true, 10);
    }

}
