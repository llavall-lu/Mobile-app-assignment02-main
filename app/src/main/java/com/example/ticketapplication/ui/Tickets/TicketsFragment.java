package com.example.ticketapplication.ui.Tickets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ticketapplication.R;
import com.example.ticketapplication.adapters.TicketCartAdapter;
import com.example.ticketapplication.databinding.FragmentTicketsBinding;
import com.example.ticketapplication.models.TicketCartModel;

import java.util.ArrayList;
import java.util.List;

public class TicketsFragment extends Fragment {

    List<TicketCartModel> list;
    TicketCartAdapter ticketCartAdapter;
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tickets, container,false);

        recyclerView = view.findViewById(R.id.tickets_rec);//Links to the layout tickets_rec
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();//adds an Array list
        list.add(new TicketCartModel(R.drawable.football_gc01324476_1920,"Football","00","00:00 - 00:00")); //Adds an Item to the array list
        ticketCartAdapter = new TicketCartAdapter(list);
        recyclerView.setAdapter(ticketCartAdapter);//sets the adapter
        return view;
    }


}