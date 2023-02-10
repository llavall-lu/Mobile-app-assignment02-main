package com.example.ticketapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketapplication.R;
import com.example.ticketapplication.adapters.ChangeVerticalSlider;
import com.example.ticketapplication.adapters.HomeSlideAdapter;
import com.example.ticketapplication.adapters.HomeVerAdapter;
import com.example.ticketapplication.databinding.FragmentHomeBinding;
import com.example.ticketapplication.models.HomeSlideModel;
import com.example.ticketapplication.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ChangeVerticalSlider {
    private FragmentHomeBinding binding;

    RecyclerView homeSlideRec,homeVerticalRec;
    ArrayList<HomeSlideModel> homeSlideModelList;
    HomeSlideAdapter homeSlideAdapter;

    ///////////////// Vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeSlideRec = root.findViewById(R.id.home_slide_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);


        /////////////Slider Array
        homeSlideModelList = new ArrayList<>();

        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_baseball_24,""));
        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_basketball_24,""));
        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_golf_24,""));
        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_hockey_24,""));
        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_soccer_24,""));
        homeSlideModelList.add(new HomeSlideModel(R.drawable.baseline_sports_tennis_24,""));

        homeSlideAdapter = new HomeSlideAdapter(this,getActivity(),homeSlideModelList);
        homeSlideRec.setAdapter(homeSlideAdapter);
        homeSlideRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeSlideRec.setHasFixedSize(true);
        homeSlideRec.setNestedScrollingEnabled(false);

        //////////////Vertical Array
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);

    }
}