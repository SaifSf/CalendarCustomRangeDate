"# CalendarCustomRangeDate" 
An Android Library to  dates range, that helps user to select range from future dates and show them in textView.

Features:

Date selection
Swipe to change month
Full customization
Small in size
Material design support
Resolution support




Developer setup
Import DateRangePicker dependency

For Gradle:

Add following line to App level gradle:

dependencies {
	        implementation 'com.github.SaifSf:CalendarCustomRangeDate:1.0'
}

    <com.sfs.customcalendar.CustomView.DateRangeCalendarView

        android:id="@+id/calendar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="64dp"
        android:layout_marginEnd="24dp"
        android:layout_marginRight="24dp"
        android:layout_marginBottom="64dp"
        app:calendar_tag="Test"
        app:disable_date_color="#ABABAB"
        app:editable="true"
        app:enable_past_date="true"
        app:header_bg="@drawable/calendar_header"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:range_color="@color/range_bg_color_app"
        app:selected_date_circle_color="@color/selected_date_circle_color_app"
        app:title_color="@color/tilte_mois"
        app:week_offset="1">

    </com.sfs.customcalendar.CustomView.DateRangeCalendarView>
XML Attribute set
Attribute	Type	Desciption
title_color	Color	Title color
week_color	Color	Week text color
range_color	Color	Date range color
selected_date_circle_color	Color	Selected date text circle color
selected_date_color	Color	Selected date text color
default_date_color	Color	Default date text color
range_date_color	Color	Date text color when it falls into range
disable_date_color	Color	Disable date color
enable_time_selection	Boolean	true to enable time selection else false
text_size_title	Dimension	Title size
text_size_week	Dimension	Week text size
text_size_date	Dimension	Date text size
header_bg	Drawable	Header background
week_offset	Dimension	To set week start day offset
enable_past_date	Boolean	Enable/Disable past date's by default its value is false
editable	Boolean	When true user can edit. By default its value is true
Set callbacks

//MainActivity.java
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
            }

            @Override
            public void onDateRangeSelected(Calendar startDate, Calendar endDate) {
                EndDate=endDate.getTime().toString();
                StartDate=startDate.getTime().toString();
                date_start.setText(StartDate.substring(0,3)+", "+StartDate.substring(4,10));
                date_end.setText(EndDate.substring(0,3)+", "+EndDate.substring(4,10));

            }
        });
Set selected date range

calendar.setSelectedDateRange(startDate, endDate);
Reset calendar date selection

calendar.resetAllSelectedViews();
Set navigation arrow left-right image

calendar.setNavLeftImage(ContextCompat.getDrawable(this,R.drawable.ic_left));
calendar.setNavRightImage(ContextCompat.getDrawable(this,R.drawable.ic_right));
Set text fonts

Typeface typeface = Typeface.createFromAsset(getAssets(), "Roboto.ttf");
calendar.setFonts(typeface);
Set week offset ( 0-Sun, 1-Mon, 2-Tue, 3-Wed, 4-Thu, 5-Fri, 6-Sat )

calendar.setWeekOffset(1);
Set current visible month on calendar

Calendar current = Calendar.getInstance();
calendar.setCurrentMonth(current);
Set calendar months range

Calendar startMonth = Calendar.getInstance();
startMonth.add(Calendar.MONTH, -2);
Calendar endMonth = (Calendar) now.clone();
endMonth.add(Calendar.MONTH, 5);

calendar.setVisibleMonthRange(startMonth,endMonth);
Set pre selected dates

Calendar startSelectionDate = Calendar.getInstance();
startSelectionDate.add(Calendar.MONTH, -1);
Calendar endSelectionDate = (Calendar) startSelectionDate.clone();
endSelectionDate.add(Calendar.DATE, 40);

calendar.setSelectedDateRange(startSelectionDate, endSelectionDate);
