package com.example.timetable;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.timetable.Category.categoryAdapter;
import com.example.timetable.databinding.FragmentPlanBinding;
import com.example.timetable.databinding.FragmentSecondBinding;
import com.example.timetable.value.Value;

import java.util.ArrayList;

public class PlanFragment extends Fragment {
    private ArrayAdapter<String> itemPlan;
    private FragmentPlanBinding binding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentPlanBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemPlan = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,Value.list_Plan);
        binding.lvPlan.setAdapter(itemPlan);
        binding.lvPlan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}