package com.example.ticketapplication.adapters;

import com.example.ticketapplication.models.HomeVerModel;

import java.util.ArrayList;

public interface ChangeVerticalSlider {
    void callBack(int position, ArrayList<HomeVerModel> list); // changes the arraylist depending on the position of the slider
}
