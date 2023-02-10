package com.example.ticketapplication.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketapplication.R;
import com.example.ticketapplication.models.HomeSlideModel;
import com.example.ticketapplication.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeSlideAdapter extends RecyclerView.Adapter<HomeSlideAdapter.ViewHolder> {

    ChangeVerticalSlider changeVerticalSlider;
    Activity activity;
    ArrayList<HomeSlideModel> list;

    boolean check = true;
    boolean select = true;
    int rowIndex = -1;

    public HomeSlideAdapter(ChangeVerticalSlider changeVerticalSlider, Activity activity, ArrayList<HomeSlideModel> list) {
        this.changeVerticalSlider = changeVerticalSlider;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_slider,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.baseball_field_gc03dfae1a_1920, "Baseball", "00:00 - 00:00", "£00"));


            changeVerticalSlider.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    rowIndex = position;
                    notifyDataSetChanged();

                    if (position == 0){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.baseball_field_gc03dfae1a_1920,"Baseball","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.baseball_field_gc03dfae1a_1920,"Baseball","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                    else if (position == 1){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.basketball_hoop_gda7d7071f_1920,"Basketball","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.basketball_hoop_gda7d7071f_1920,"Basketball","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                    else if (position == 2){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.golf_gb4a32dd8c_1920,"Golf","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.golf_gb4a32dd8c_1920,"Golf","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                    else if (position == 3){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.indoors_gae1649abe_1920,"Indoor Ice Hockey","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.indoors_gae1649abe_1920,"Indoor Ice Hockey","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                    else if (position == 4){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.football_gc01324476_1920,"Football","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.football_gc01324476_1920,"Football","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                    else if (position == 5){
                        ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
                        homeVerModels.add(new HomeVerModel(R.drawable.tennis_ge30415b27_1920,"Tennis","00:00 - 00:00","£00"));
                        homeVerModels.add(new HomeVerModel(R.drawable.tennis_ge30415b27_1920,"Tennis","00:00 - 00:00","£00"));
                        changeVerticalSlider.callBack(position,homeVerModels);
                    }
                }
            });
            if (select){
                if (position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select =false;
                }
            }
            else{
                if (rowIndex == position){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }

        }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.slide_img);
            name = itemView.findViewById(R.id.slide_text);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
