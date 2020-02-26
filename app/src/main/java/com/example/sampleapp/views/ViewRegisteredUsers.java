package com.example.sampleapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.sampleapp.R;
import com.example.sampleapp.db.AppDatabase;
import com.example.sampleapp.db.PersonInfo;

import java.util.ArrayList;
import java.util.List;

public class ViewRegisteredUsers extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.Adapter myAdapter;
    List<PersonInfo> personInfoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_registered_users);

        //personInfoList = new ArrayList<>();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "persons").allowMainThreadQueries().build();

        List<PersonInfo> personInfoList =db.personInfoDao().getAll();

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter= new MyAdapter(personInfoList);
        recyclerView.setAdapter(myAdapter);

    }
}
