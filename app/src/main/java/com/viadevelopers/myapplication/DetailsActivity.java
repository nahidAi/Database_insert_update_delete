package com.viadevelopers.myapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private List<Model> models = new ArrayList<>();
    private AdapterClass adapterClass;
    private RecyclerView recyclerView;
    private MyDatabase myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //getData();

        myDatabase = new MyDatabase(getApplicationContext());



        //اطلاعات را از دیتابیس میخونیم هربار که فور که اجرا میشه در واقع یک سطر از دیتابیس رو میخونه
        readDataFromDatabase();


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterClass = new AdapterClass(models, this);
        recyclerView.setAdapter(adapterClass);



    }

    public void getData() {
        Model model = new Model();
        model.setTxtUser("naaahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);
        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);
        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);
        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);
        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);

        model = new Model();
        model.setTxtUser("nahid");
        model.setTxtPass("12345");
        models.add(model);


    }



    public void readDataFromDatabase(){
        myDatabase = new MyDatabase(getApplicationContext());
        Cursor cursor = myDatabase.getInfo();
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String pass = cursor.getString(2);

            Model model = new Model();
            model.setId(id);
            model.setTxtUser(name);
            model.setTxtPass(pass);
            models.add(model);
        }
    }
}
