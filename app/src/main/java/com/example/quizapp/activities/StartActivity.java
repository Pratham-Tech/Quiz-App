package com.example.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import com.example.quizapp.R;
import com.example.quizapp.fragments.QuestionsFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        launchFragment(new QuestionsFragment());
    }

    public void launchFragment(Fragment fragment){
        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.frameL,fragment)
                .addToBackStack(null)
                .commit();
    }
}