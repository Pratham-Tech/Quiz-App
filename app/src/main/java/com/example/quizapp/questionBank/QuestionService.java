package com.example.quizapp.questionBank;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class QuestionService {

    public static List<Questions> getQuestions(){

        List<Questions> questionList = new ArrayList<>();

        questionList.add(new Questions("What's my name?","Pratham Dhawan",new ArrayList<>(Arrays.asList("Pratham Dhawan","Prathan Rawat", "Pratham Dhiman","Prathan Dhawan"))));
        questionList.add(new Questions("What's my age?","19",new ArrayList<>(Arrays.asList("20","19", "18","21"))));
        questionList.add(new Questions("What am i doing?","BCA",new ArrayList<>(Arrays.asList("MCA","MBA", "BBA","BCA"))));

        return questionList;
    }
}
