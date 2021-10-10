package com.example.timetable;

import static com.example.timetable.value.Value.color_code;
import static com.example.timetable.value.Value.date;
import static com.example.timetable.value.Value.week;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.timetable.Category.categoryAdapter;
import com.example.timetable.Category.categoryObject;
import com.example.timetable.databinding.FragmentBookBinding;
import com.example.timetable.databinding.FragmentFirstBinding;
import com.example.timetable.value.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class BookFragment extends Fragment {

    private FragmentBookBinding binding;
    private categoryAdapter adapterCate ;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBookBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SetBackgroundTopic();
        String dateCurrent = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        date = dateCurrent;
        binding.txtTime.setText(dateCurrent);
        Calendar c = Calendar.getInstance();
        int yearCalendar = c.get(Calendar.YEAR);
        int monthCalendar = c.get(Calendar.MONTH);
        int dayCalendar = c.get(Calendar.DAY_OF_MONTH);

        Value.nam = yearCalendar;
        Value.thang = monthCalendar +1;
        Value.ngay = dayCalendar;

        adapterCate = new categoryAdapter(getContext(),R.layout.items_selected,getListCategory());
        binding.spnCategory.setAdapter(adapterCate);
        binding.spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        week = 1;
                        break;
                    case 1:
                        week = 2;
                        break;
                    case 2:
                        week = 3;
                        break;
                    case 3:
                        week = 4;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.txtTopicColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                View layout_dialog = LayoutInflater.from(getContext()).inflate(R.layout.activity_set_color,null);
                builder.setView(layout_dialog);

                CircleImageView color1 = layout_dialog.findViewById(R.id.color1);
                CircleImageView color2 = layout_dialog.findViewById(R.id.color2);
                CircleImageView color3 = layout_dialog.findViewById(R.id.color3);
                CircleImageView color4 = layout_dialog.findViewById(R.id.color4);
                CircleImageView color5 = layout_dialog.findViewById(R.id.color5);
                CircleImageView color6 = layout_dialog.findViewById(R.id.color6);
                CircleImageView color7 = layout_dialog.findViewById(R.id.color7);
                CircleImageView color8 = layout_dialog.findViewById(R.id.color8);
                CircleImageView color9 = layout_dialog.findViewById(R.id.color9);

                color1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color1.setBorderWidth(5);
                        color1.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 1;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic1);
                    }
                });
                color2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color2.setBorderWidth(5);
                        color2.setBorderColor(Color.BLACK);
                        color1.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 2;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic2);
                    }
                });
                color3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color3.setBorderWidth(5);
                        color3.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color1.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 3;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic3);
                    }
                });
                color4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color4.setBorderWidth(5);
                        color4.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color1.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 4;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic4);
                    }
                });
                color5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color5.setBorderWidth(5);
                        color5.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color1.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 5;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic5);
                    }
                });
                color6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color6.setBorderWidth(5);
                        color6.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color1.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 6;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic6);
                    }
                });
                color7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color7.setBorderWidth(5);
                        color7.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color1.setBorderWidth(0);
                        color8.setBorderWidth(0); color9.setBorderWidth(0);
                        color_code = 7;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic7);
                    }
                });
                color8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color8.setBorderWidth(5);
                        color8.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color9.setBorderWidth(0); color1.setBorderWidth(0);
                        color_code = 8;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic8);
                    }
                });
                color9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        color9.setBorderWidth(5);
                        color9.setBorderColor(Color.BLACK);
                        color2.setBorderWidth(0); color4.setBorderWidth(0); color6.setBorderWidth(0);
                        color3.setBorderWidth(0); color5.setBorderWidth(0); color7.setBorderWidth(0);
                        color8.setBorderWidth(0); color1.setBorderWidth(0);
                        color_code = 9;
//                        binding.txtTopicColor.setImageResource(R.drawable.topic9);
                    }
                });
                builder.setPositiveButton("Chọn", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SetBackgroundTopic();
                    }
                });
                builder.create().show();
                builder.setCancelable(false);

            }
        });
        binding.txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datepick = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        Value.nam = year;
                        Value.thang = month;
                        Value.ngay = dayOfMonth;

                        date =LocalDateTime.of(Value.nam,Value.thang,Value.ngay,0,0,0).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        binding.txtTime.setText(date);
                    }
                } ,yearCalendar,monthCalendar,dayCalendar);
                datepick.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                datepick.setTitle("select date");
                datepick.show();
            }

        });

        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                Value.content_traget = binding.inputTragets.getText().toString();
                String titleTopic = binding.txtTitleTopic.getText().toString();
                Value.list_Plan.add(titleTopic);
                NavHostFragment.findNavController(BookFragment.this)
                        .navigate(R.id.action_bookFragment_to_SecondFragment);

            }
        });
    }

    private List<categoryObject>  getListCategory() {
        List<categoryObject> list = new ArrayList<>();
        list.add(new categoryObject("1 Tuần"));
        list.add(new categoryObject("2 Tuần"));
        list.add(new categoryObject("3 Tuần"));
        list.add(new categoryObject("4 Tuần"));
        return list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SetBackgroundTopic(){
        switch (color_code){
            case 1:
                binding.txtTopicColor.setImageResource(R.drawable.topic1);
                break;
            case 2:
                binding.txtTopicColor.setImageResource(R.drawable.topic2);
                break;
            case 3:
                binding.txtTopicColor.setImageResource(R.drawable.topic3);
                break;
            case 4:
                binding.txtTopicColor.setImageResource(R.drawable.topic4);
                break;
            case 5:
                binding.txtTopicColor.setImageResource(R.drawable.topic5);
                break;
            case 6:
                binding.txtTopicColor.setImageResource(R.drawable.topic6);
                break;
            case 7:
                binding.txtTopicColor.setImageResource(R.drawable.topic7);
                break;
            case 8:
                binding.txtTopicColor.setImageResource(R.drawable.topic8);
                break;
            case 9:
                binding.txtTopicColor.setImageResource(R.drawable.topic9);
                break;

        }
    }

}