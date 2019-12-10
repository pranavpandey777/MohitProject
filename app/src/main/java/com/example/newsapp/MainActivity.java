package com.example.newsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView one,two,three,four;
String source;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                source="espn";
                Intent i=new Intent(MainActivity.this,MainActivity1.class);
                i.putExtra("source",source);
                startActivity(i);


            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                source="financial-post";
                Intent i=new Intent(MainActivity.this,MainActivity1.class);
                i.putExtra("source",source);
                startActivity(i);

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                source="abc-news";
                Intent i=new Intent(MainActivity.this,MainActivity1.class);
                i.putExtra("source",source);
                startActivity(i);

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                source="buzzfeed";
                Intent i=new Intent(MainActivity.this,MainActivity1.class);
                i.putExtra("source",source);
                startActivity(i);

            }
        });

    }
}
