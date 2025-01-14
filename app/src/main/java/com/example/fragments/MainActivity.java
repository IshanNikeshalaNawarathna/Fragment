package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button activityButtons1 = findViewById(R.id.activebutton);
        activityButtons1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView activityText = findViewById(R.id.activitytextView);
                activityText.setText("Activity button 1 Hello");
            }
        });

        Button activityButtons2 = findViewById(R.id.addFragmentbutton);
        activityButtons2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, TestFragment.class, null)
                        .setReorderingAllowed(true)
                        .commit();
            }
        });

        Button activityButtons3 = findViewById(R.id.updateFragmentTextViewButton);
        activityButtons3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView activityText = findViewById(R.id.fragmentTextView);
                activityText.setText(" Activity button 3 Hello");
            }
        });

    }
}