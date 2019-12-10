package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Pranav on 18-04-2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<Model> myLayoutArrayList;


    public MyRecyclerAdapter(Context context, ArrayList<Model> myLayoutArrayList) {
        this.context = context;
        this.myLayoutArrayList = myLayoutArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.modelview, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view, context, myLayoutArrayList);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Model m = myLayoutArrayList.get(position);

        String urlToImage = m.urlToImage;
        String title = m.getTitle();
        String content = m.getContent();

        Picasso.with(context).load(urlToImage).into(holder.imageView);
        holder.txt1.setText(title);
        holder.txt2.setText(content);


    }

    @Override
    public int getItemCount() {
        return myLayoutArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView txt1, txt2;
        Context context;
        ArrayList<Model> myLayoutArrayList;

        public MyViewHolder(View itemView, Context context, ArrayList<Model> myLayoutArrayList) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            txt1 = itemView.findViewById(R.id.title);
            txt2 = itemView.findViewById(R.id.content);
            itemView.setOnClickListener(this);
            this.context = context;
            this.myLayoutArrayList = myLayoutArrayList;

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Model m = this.myLayoutArrayList.get(position);
             Intent i=new Intent(this.context,Show.class);
             i.putExtra("image_url",m.getUrl());
              context.startActivity(i);

        }
    }
}
