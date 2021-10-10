package com.example.timetable.value;

import android.icu.text.SimpleDateFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.timetable.R;
import com.example.timetable.calendar.CalendarObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Value {
    public static CalendarObject[] list = {
            new CalendarObject("ngay 25/11/2002", R.drawable.ic_complete),
            new CalendarObject("ngay 25/11/2002", R.drawable.ic_nocomplete),
            new CalendarObject("ngay 25/11/2002", R.drawable.ic_nocomplete_note)
    };
    public static int color_code = 1;
    public static int ngay ;
    public static int thang ;
    public static int nam ;
    public static String date;
    public static int  week =1;
    public static String dateEnd;
    public static String content_traget ;
    public static ArrayList<String> list_Plan = new ArrayList<>();
}
