package com.example.fragmentsmessagedemo2.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentsmessagedemo2.R;

public class HelloWorldFragment extends Fragment {
    TextView textViewCounter;
    private int count = 0;
    Button incrementButton;
    OnNumberCrossingTenListener onNumberCrossingTenListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onNumberCrossingTenListener = (OnNumberCrossingTenListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hello_world, container, false);
        textViewCounter = view.findViewById(R.id.textView_number);
        incrementButton = view.findViewById(R.id.button_increment);
        incrementButton.setOnClickListener((view1) -> {
            count++;
            if(count == 10) {
                count = 0;
                onNumberCrossingTenListener.onNumberCrossingTen();
            }
            textViewCounter.setText(String.valueOf(count));
        });
        return view;
    }

    public interface OnNumberCrossingTenListener
    {
        void onNumberCrossingTen();
    }

}