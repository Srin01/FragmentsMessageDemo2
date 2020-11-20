package com.example.fragmentsmessagedemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fragmentsmessagedemo2.Fragments.HelloWorldFragment;

public class MainActivity extends AppCompatActivity implements HelloWorldFragment.OnNumberCrossingTenListener {

    HelloWorldFragment helloWorldFragment;
    TextView counterTextView ;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helloWorldFragment = new HelloWorldFragment();
        counterTextView = findViewById(R.id.textViewIncrement);



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.linearLayoutHolder,helloWorldFragment)
                .commit();
    }

    @Override
    public void onNumberCrossingTen() {
        counterTextView.setText(String.valueOf(count++));
    }
}