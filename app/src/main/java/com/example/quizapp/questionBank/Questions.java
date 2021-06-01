package com.example.quizapp.questionBank;

import java.util.List;

public class Questions {

    private String title;
    private String answer;
    private List<String> options;

    public Questions(String title, String answer, List<String> options) {
        this.title = title;
        this.answer = answer;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
