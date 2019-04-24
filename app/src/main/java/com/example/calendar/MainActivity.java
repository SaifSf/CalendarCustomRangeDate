package com.example.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sfs.customcalendar.CustomView.DateRangeCalendarView;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private DateRangeCalendarView calendarView;
    private Calendar calendar;
    private  String StartDate;
    private String EndDate;
    private TextView date_start, date_end, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = findViewById(R.id.calendar);
        date_start = findViewById(R.id.tv_start_date);
        date_end = findViewById(R.id.tv_end_date);
        year = findViewById(R.id.dateOfyear);
        calendar = Calendar.getInstance(TimeZone.getDefault());
        final String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
        Toast.makeText(this, "Today's Date: " + currentYear, Toast.LENGTH_SHORT).show();
        year.setText(currentYear);

        calendarView.setCalendarListener(new DateRangeCalendarView.CalendarListener() {
            @Override
            public void onFirstDateSelected(Calendar startDate) {
                Toast.makeText(MainActivity.this, "onFirstDateSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
                EndDate = endDate.getTime().toString();
                StartDate = startDate.getTime().toString();
                date_start.setText(StartDate.substring(0, 3) + ", " + StartDate.substring(4, 10));
                date_end.setText(EndDate.substring(0, 3) + ", " + EndDate.substring(4, 10));
                Toast.makeText(MainActivity.this, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelClick() {

            }

            @Override
            public void onConfirmClick(Calendar mStartDate, Calendar mEndDate) {
                if (mStartDate == null && mEndDate == null) {
                    onCancelClick();
                } else if (mStartDate != null && mEndDate != null) {
                    onDateRangeSelected(mStartDate, mEndDate);
                } else {
                    onFirstDateSelected(mStartDate);
                }
            }


        });


    }
}
