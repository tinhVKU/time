package com.example.timetable.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.timetable.R;

import java.util.ArrayList;

public class calendarAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater = null;
    ArrayList<CalendarObject> danhsach = new ArrayList<>();
    public  calendarAdapter(Context context, ArrayList<CalendarObject> danhsach) {
        this.context = context;
        this.danhsach = danhsach;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return danhsach.size();
    }
    @Override
    public Object getItem(int position) {
        return danhsach.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_calendar,parent,false);
        }

        TextView ten = (TextView) convertView.findViewById(R.id.txt_ten_lich);
        ImageView hinh = (ImageView)convertView.findViewById(R.id.img_anh_lich);
        ten.setText(danhsach.get(position).ten);
        hinh.setImageResource(danhsach.get(position).nhiemvu);
        return convertView;
    }
}
