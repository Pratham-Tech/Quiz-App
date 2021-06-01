package com.example.quizapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.quizapp.R;

import java.util.ArrayList;

public class ResultsFragment extends Fragment {

    protected TextView correctAns;
    private TextView IncorrectAns;

    public ResultsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        intialize(view);

        Bundle args = this.getArguments();

        if (args != null) {

            correctAns.setText(args.getString("corrects"));
            IncorrectAns.setText(args.getString("inCorrects"));
        }
    }
    public void intialize(View view){

        correctAns = view.findViewById(R.id.correctAnswers);
        IncorrectAns = view.findViewById(R.id.incorrectAnswers);
    }
}