package com.viadevelopers.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private Button showButton;
    public EditText edtName;
    public EditText edtPass;
    private MyDatabase myDatabase;
    private int id;
    public static boolean edit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  گرفتن یک نمونه از کلاس دیتابیس
        myDatabase = new MyDatabase(getApplicationContext());


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        saveButton = findViewById(R.id.saveButton);
        // اینجا قبلش یک فیلد بنام  edit بصورت سراسری تعریف کردیم و مقدارش رو فلز گذاشتیم وقتی از طریق اینتنت داده هارد دریافت میکنیم این ادیت رو ترو قرار میدیم و ...

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!edit) {
                    try {
                        if (!edtName.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty()) {
                            long result = myDatabase.addInfo(edtName.getText().toString(), edtPass.getText().toString());


                            Snackbar snackbar = Snackbar.make(v, "  در دیتابیس با آیدی  " + result + "  ذخیره شد                                       ",Snackbar.LENGTH_LONG);
                            View view = snackbar.getView();
                            view.setBackgroundColor(getResources().getColor(R.color.colorYello));
                            TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                            textView.setTextColor(Color.BLACK);
                            snackbar.show();

                            edtName.getText().clear();
                            edtPass.getText().clear();

                        } else {
                            Snackbar snackbar = Snackbar.make(v,"لطفا فیلدهای خالی را پر کنید...                                    ",Snackbar.LENGTH_LONG);
                            View view = snackbar.getView();
                            view.setBackgroundColor(getResources().getColor(R.color.colorYello));
                            TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                            textView.setTextColor(Color.BLACK);
                            snackbar.show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "دوباره سعی کنید", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    try {
                        if (!edtName.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty()) {
                            myDatabase.updateRow(edtName.getText().toString(), edtPass.getText().toString(), id);
                            saveButton.setText("ثبت اطلاعات");
                            edtName.getText().clear();
                            edtPass.getText().clear();
                            edtName.requestFocus();
                            edit = false;
                            Snackbar snackbar = Snackbar.make(v,"اطلاعات ویرایش شد...                                            ",Snackbar.LENGTH_LONG);
                            View view = snackbar.getView();
                            view.setBackgroundColor(getResources().getColor(R.color.colorYello));
                            TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                            textView.setTextColor(Color.BLACK);
                            snackbar.show();


                        } else {
                            Snackbar snackbar = Snackbar.make(v,"لطفا فیلدهای خالی را پر کنید...                                    ",Snackbar.LENGTH_LONG);
                            View view = snackbar.getView();
                            view.setBackgroundColor(getResources().getColor(R.color.colorYello));
                            TextView textView = view.findViewById(android.support.design.R.id.snackbar_text);
                            textView.setTextColor(Color.BLACK);
                            snackbar.show();
                        }

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "دوباره سعی کنید", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });


        showButton = findViewById(R.id.showButton);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
        edtName = findViewById(R.id.edtname);
        edtPass = findViewById(R.id.edtPass);


        saveButton = findViewById(R.id.saveButton);
        showButton = findViewById(R.id.showButton);


        Typeface typeface = Typeface.createFromAsset(getAssets(), "irsans_font.ttf");
        saveButton.setTypeface(typeface);
        showButton.setTypeface(typeface);

        edtName = findViewById(R.id.edtname);
        edtName.setTypeface(typeface);

        edtPass = findViewById(R.id.edtPass);
        edtPass.setTypeface(typeface);


        //getIntent
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            String name = intent.getExtras().getString("NAME");
            String pass = intent.getExtras().getString("PASS");
            id = intent.getExtras().getInt("ID");
            edtName.setText(name);
            edtPass.setText(pass);
            saveButton.setText("ویرایش اطلاعات ");
            edit = true;












           /* saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long result = myDatabase.addInfo(edtName.getText().toString(), edtPass.getText().toString());
                    Toast.makeText(MainActivity.this, "Id is " + result, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "در دیتابیس ذخیره شد", Toast.LENGTH_SHORT).show();
                    edtName.getText().clear();
                    edtPass.getText().clear();

                }
            });*/

        }


    }

   /* @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        if (menu instanceof MenuBuilder) {
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);

        }

        return true;
    }*/
}
