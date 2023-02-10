package com.example.ticketapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketapplication.R;
import com.example.ticketapplication.models.TicketCartModel;

import java.util.List;

public class TicketCartAdapter extends RecyclerView.Adapter<TicketCartAdapter.Viewholder> {

    List<TicketCartModel> list;

    public TicketCartAdapter(List<TicketCartModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.myticketcart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.time.setText(list.get(position).getTime());
        holder.price.setText(list.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,time,price;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cart_img);
            name = itemView.findViewById(R.id.cart_name);
            time = itemView.findViewById(R.id.cart_time);
            price = itemView.findViewById(R.id.cart_price);

        }
    }
}
