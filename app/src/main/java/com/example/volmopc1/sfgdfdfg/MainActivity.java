package com.example.volmopc1.sfgdfdfg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Databasehandle v=new Databasehandle(this);
        v.addRow();
        v.getData();
    }
}