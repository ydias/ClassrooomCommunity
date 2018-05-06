package com.example.yann.classroom_community.BDD2;

import java.util.List;

public class Question {
    int id;
    String text;
    int duration;
    List<Answer> answers;

    public Question(int id, String text, int duration, List<Answer> answers){
        this.id = id;
        this.text = text;
        this.duration = duration;
        this.answers = answers;
    }
}
