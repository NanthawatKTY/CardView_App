package com.namo3t.cardview_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList items = new ArrayList();
        items.addAll(Arrays.asList(
                new CustomItem("Jellybean (v4.1 - 4.3)", R.drawable.jellybean, "Debuted in June 2012"),
                new CustomItem("Kitkat (v4.4)", R.drawable.kitkat, "Debuted in November 2013"),
                new CustomItem("Lollipop (v5.0)", R.drawable.lollipop, "Debuted in November 2014"),
                new CustomItem("Marshmallow (v6.0)", R.drawable.marshmallow, "Debuted in November 2015"),
                new CustomItem("Nougat (v7.0)", R.drawable.nougat, "Debuted in September 2016")
        ));

        CustomAdapter adapter = new CustomAdapter(this, items);
        RecyclerView rcv = (RecyclerView)findViewById(R.id.recyclerView);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
    }
}
