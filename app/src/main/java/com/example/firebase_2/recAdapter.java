package com.example.firebase_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class recAdapter extends RecyclerView.Adapter<recAdapter.ViewHolder>{

    //private final MainActivity mainActivity;
    private List<Model> list;

    public recAdapter(MainActivity mainActivity, List<Model> list) {
        //this.mainActivity = mainActivity;
        this.list = list;
    }
    public recAdapter( List<Model> list) {

        this.list = list;
    }

    public recAdapter(MainActivity mainActivity) {
        //this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.single_row , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.first.setText(list.get(position).getFf());
        holder.last.setText(list.get(position).getSf());
        //Glide.with(holder.itemView).load(list.get(position).getImg()).into(holder.imgView);
        Picasso.get().load(list.get(position).getImg()).into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        private  TextView first ;
                private TextView last;
                private ImageView imgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            first = itemView.findViewById(R.id.first);
            last = itemView.findViewById(R.id.last);
            imgView = itemView.findViewById(R.id.imgView);
        }
    }
}
