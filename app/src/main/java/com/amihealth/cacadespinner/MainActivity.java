package com.amihealth.cacadespinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = (Spinner) findViewById(R.id.sp);
        sp.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,new ProvinciasDatos(getApplicationContext()).getData()));

    }
}
