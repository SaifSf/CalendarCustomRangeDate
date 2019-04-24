package com.example.calendar;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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


        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View calendarDialogView = inflater.inflate(R.layout.alert_layout, null);
        calendarView = calendarDialogView.findViewById(R.id.calendar);
        date_start = calendarDialogView.findViewById(R.id.tv_start_date);
        date_end = calendarDialogView.findViewById(R.id.tv_end_date);
        year = calendarDialogView.findViewById(R.id.dateOfyear);
        calendar = Calendar.getInstance(TimeZone.getDefault());
        final String currentYear = String.valueOf(calendar.get(Calendar.YEAR));
        Toast.makeText(this, "Today's Date: " + currentYear, Toast.LENGTH_SHORT).show();
        year.setText(currentYear);
        dialogBuilder.create();
        dialogBuilder.setView(calendarDialogView);
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setLayout(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();

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
