package com.example.agecalculator.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Calendar;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<Integer> display = new MutableLiveData<>();

    public LiveData<Integer> getDisplayValue() {
        return display;
    }

    public void calculateAge(Integer a) {
    display.setValue(Calendar.getInstance().get(Calendar.YEAR) - a);
    }
}