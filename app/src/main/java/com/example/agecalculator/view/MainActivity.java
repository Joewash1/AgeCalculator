package com.example.agecalculator.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.agecalculator.R;
import com.example.agecalculator.databinding.ActivityMainBinding;
import com.example.agecalculator.viewmodel.HomeViewModel;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int year;
    private ActivityMainBinding binding;
    private HomeViewModel homeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        binding.cal.setOnClickListener(this);

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeViewModel.getDisplayValue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer value) {
            binding.display.setText(NumberFormat.getInstance().format(value));
            }
        });
    }
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.cal:
            year = Integer.parseInt(binding.age.getText().toString());
            homeViewModel.calculateAge(year);

            break;


    }
}}