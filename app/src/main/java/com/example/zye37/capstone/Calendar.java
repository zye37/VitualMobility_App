package com.example.zye37.capstone;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Calendar extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(false);
        actionbar.setTitle(null);

        compactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        // set an event for

        Event ev1 = new Event(Color.BLUE, 1492383285000L,"You have a rehab session scheduled!");
        compactCalendar.addEvent(ev1);
        Event ev2 = new Event(Color.BLUE, 1492037685000L,"You have a rehab session scheduled!");
        compactCalendar.addEvent(ev2);
        Event ev3 = new Event(Color.BLUE, 1491605685000L,"You have a rehab session scheduled!");
        compactCalendar.addEvent(ev3);
        Event ev4 = new Event(Color.BLUE, 1491346485000L,"You have a rehab session scheduled!");
        compactCalendar.addEvent(ev4);


        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();
                System.out.println(dateClicked.toString());
                if(dateClicked.toString().compareTo("Sun Apr 16 00:00:00 EDT 2017")== 0) {
                    Toast.makeText(context, "You have a rehab session scheduled!", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().compareTo("Wed Apr 12 00:00:00 EDT 2017")==0 ) {
                    Toast.makeText(context, "You have a rehab session scheduled!", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().compareTo("Fri Apr 7 00:00:00 EDT 2017")==0 ) {
                    Toast.makeText(context, "You have a rehab session scheduled!", Toast.LENGTH_SHORT).show();
                } else if (dateClicked.toString().compareTo("Tue Apr 4 00:00:00 EDT 2017")==0 ) {
                    Toast.makeText(context, "You have a rehab session scheduled!", Toast.LENGTH_SHORT).show();
                } else {
                        Toast.makeText(context, "No event scheduled",Toast.LENGTH_SHORT).show();
                    }
                }

            @Override
            public void onMonthScroll(Date firstDayofNewMonth) {
                actionbar.setTitle(dateFormatMonth.format(firstDayofNewMonth));
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
