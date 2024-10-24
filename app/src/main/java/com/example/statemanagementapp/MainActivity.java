package com.example.statemanagementapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.CompoundButton;
import androidx.lifecycle.ViewModelProvider;
import android.content.res.ColorStateList;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Switch;



public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count";
    private TextView textViewCount;
    private int count =0;
    private Switch switch1;
    private EditText input;
    private TextView textViewOptionClicked;
    private CheckBox checkbox1;
    private LinearLayout main;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textViewCount=findViewById(R.id.clickNumber);
        Button buttonIncrement = findViewById(R.id.button);

        if(savedInstanceState !=null){
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                updateCountText();
            }
        });

        // Ustawienie słuchacza zmiany stanu
        switch1 = findViewById(R.id.switch1);
        main = findViewById(R.id.main_layout);
        input = findViewById(R.id.inputText);
        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {if (isChecked) {
            main.setBackgroundColor(Color.BLACK);
            textViewCount.setTextColor(Color.WHITE);
            input.setTextColor(Color.WHITE);
            input.setHintTextColor(Color.GRAY);
            input.setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
            checkbox1.setTextColor(Color.WHITE);
            textViewOptionClicked.setTextColor(Color.WHITE);
            switch1.setTextColor(Color.WHITE);
            switch1.setThumbTintList(ColorStateList.valueOf(Color.WHITE)); // Kolor główki Switcha
            switch1.setTrackTintList(ColorStateList.valueOf(Color.GRAY));
            buttonIncrement.setTextColor(Color.BLACK);
            buttonIncrement.setBackgroundColor(Color.WHITE);

        } else {

            main.setBackgroundColor(Color.WHITE);
            textViewCount.setTextColor(Color.BLACK);
            input.setTextColor(Color.BLACK);
            checkbox1.setTextColor(Color.BLACK);
            textViewOptionClicked.setTextColor(Color.BLACK);
            switch1.setTextColor(Color.BLACK);
        }
        });

        checkbox1 = findViewById(R.id.checkbox);
        textViewOptionClicked = findViewById(R.id.OptionClicked);


        // ten kod da nam nasluchiwanie na zmiane check czy zaznaczony czy nie
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Jeśli zaznaczony to wyświetli się text
                    textViewOptionClicked.setVisibility(View.VISIBLE);
                } else {
                    // Jeśli odznaczony to ukryje text
                    textViewOptionClicked.setVisibility(View.GONE);
                }
            }
        });

    }


    @Override

    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }

    protected void updateCountText(){
        textViewCount.setText("Licznik: "+ count);
    }

}
