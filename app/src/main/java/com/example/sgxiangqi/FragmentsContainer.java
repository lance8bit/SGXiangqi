package com.example.sgxiangqi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sgxiangqi.ui.fragmentxiangqiboard.FragmentXiangQiBoard;

public class FragmentsContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_container_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FragmentXiangQiBoard.newInstance())
                    .commitNow();
        }
    }
}