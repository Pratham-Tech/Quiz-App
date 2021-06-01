package com.example.quizapp.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.quizapp.questionBank.QuestionService;
import com.example.quizapp.questionBank.Questions;
import com.example.quizapp.R;

import java.util.ArrayList;
import java.util.List;

public class QuestionsFragment extends Fragment {

    private RadioButton radioB;
    private RadioGroup rg1;
    private TextView questionTv;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button nextBt;
    private int counter=0;
    private Button submitBt;
    private Button checkResultsBt;
    private TextView questionCounter;
    private String corrects="Working";
    private String inCorrects="Working";
    private List<String> userAns= new ArrayList<String>();

    public QuestionsFragment() {
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
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        intialize(view);
        checkResultsBt.setVisibility(View.INVISIBLE);
        submitBt.setVisibility(View.INVISIBLE);

        List<Questions> questions = QuestionService.getQuestions();

        setQuestionCounter(counter+1);
        questionTv.setText(questions.get(0).getTitle());
        rb1.setText(questions.get(0).getOptions().get(0));
        rb2.setText(questions.get(0).getOptions().get(1));
        rb3.setText(questions.get(0).getOptions().get(2));
        rb4.setText(questions.get(0).getOptions().get(3));
        counter++;

        nextBt.setOnClickListener(v ->{

            if (isAnyRadioChecked()) {

                rg1.clearCheck();
                setQuestionCounter(counter + 1);

                    if (counter == 2) {

                        nextBt.setVisibility(View.INVISIBLE);
                        submitBt.setVisibility(View.VISIBLE);
                        questionTv.setText(questions.get(counter).getTitle());
                        rb1.setText(questions.get(counter).getOptions().get(0));
                        rb2.setText(questions.get(counter).getOptions().get(1));
                        rb3.setText(questions.get(counter).getOptions().get(2));
                        rb4.setText(questions.get(counter).getOptions().get(3));
                    } else {

                        questionTv.setText(questions.get(counter).getTitle());
                        rb1.setText(questions.get(counter).getOptions().get(0));
                        rb2.setText(questions.get(counter).getOptions().get(1));
                        rb3.setText(questions.get(counter).getOptions().get(2));
                        rb4.setText(questions.get(counter).getOptions().get(3));
                        counter++;

                    }
                } else
                    Toast.makeText(getContext().getApplicationContext(), "Please select any option", Toast.LENGTH_LONG).show();
            });

        submitBt.setOnClickListener(v ->{


            if(isAnyRadioChecked()) {
                Toast.makeText(getContext().getApplicationContext(), "Quiz Completed!", Toast.LENGTH_SHORT).show();
                submitBt.setEnabled(false);
                calculateScore();
                checkResultsBt.setVisibility(View.VISIBLE);
            }
            else
                Toast.makeText(getContext().getApplicationContext(),"Please select any option",Toast.LENGTH_LONG).show();

        });

        checkResultsBt.setOnClickListener(v ->{

                ResultsFragment nextFrag = new ResultsFragment();
                Bundle args = new Bundle();

                args.putString("corrects",corrects);
                args.putString("inCorrects",inCorrects);
                nextFrag.setArguments(args);

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameL,nextFrag)
                        .addToBackStack(null)
                        .commit();
        });
    }

    public boolean isAnyRadioChecked(){

        if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()||rb4.isChecked()) {

            int id = rg1.getCheckedRadioButtonId();
            radioB = rg1.findViewById(id);
            userAns.add(radioB.getText().toString());

            return true;
        }
        else
            return false;
    }

    public void setQuestionCounter(int i){

        String number = "Question " + (int)i;
        questionCounter.setText(number);
    }

    public void intialize(View view){

        questionTv = view.findViewById(R.id.questionsTv);
        rb1 = view.findViewById(R.id.rb1);
        rb2 = view.findViewById(R.id.rb2);
        rb3 = view.findViewById(R.id.rb3);
        rb4 = view.findViewById(R.id.rb4);
        nextBt = view.findViewById(R.id.nextBt);
        submitBt = view.findViewById(R.id.submitBt);
        checkResultsBt = view.findViewById(R.id.checkResultsBt);
        questionCounter = view.findViewById(R.id.questionCounter);
        rg1 = view.findViewById(R.id.rg1);
    }

    public void calculateScore(){

        List<Questions> questions = QuestionService.getQuestions();
        int rights=0, wrongs=0;
        for(int i=0;i<3;i++){

            if(questions.get(i).getAnswer().equals(userAns.get(i)))
                rights++;
            else
                wrongs++;
        }

        corrects = "Corrects: " + rights;
        inCorrects = "InCorrects: " + wrongs;
    }
}