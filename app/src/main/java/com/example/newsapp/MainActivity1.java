package com.example.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
ArrayList<Model> arrayList;
    String sources;
    String apikey="a5b563d244c844d1b3caddd914b96b75";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        recyclerView=findViewById(R.id.rv);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        sources=getIntent().getStringExtra("source");
      //  Toast.makeText(this, sources, Toast.LENGTH_SHORT).show();


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api=retrofit.create(Api.class);

        Call<ModelList> call=api.getData(sources,"a5b563d244c844d1b3caddd914b96b75");

        call.enqueue(new Callback<ModelList>() {
            @Override
            public void onResponse(Call<ModelList> call, Response<ModelList> response) {
                ModelList modelList=response.body();
                arrayList=modelList.getArrayList();

              /*  for(int i=0;i<arrayList.size();i++){
                    Model model=arrayList.get(i);
                    String title=model.getTitle();
                    String url=model.getUrlToImage();
                    String content=model.getContent();
                }*/

              MyRecyclerAdapter adapterClass=new MyRecyclerAdapter(MainActivity1.this,arrayList);
              recyclerView.setAdapter(adapterClass);

            }

            @Override
            public void onFailure(Call<ModelList> call, Throwable t) {

            }
        });



    }
}
