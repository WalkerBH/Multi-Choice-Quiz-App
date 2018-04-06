/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walkerhildebrand.main;
import java.util.ArrayList;

/**
 *
 * @author Walker
 */
public class Section {
    private int id;
    private String name;

    ArrayList<Question> questions = new ArrayList<Question>();
    
    public Section() {
        
    }
    
    public Section(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public void setQuestions(Question[] questions) {
        for (int i = 0; i < questions.length; i++) {
            addQuestion(questions[i]);
        }
    }
    
    public void addQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(Question q) {
        this.questions.add(q);
    }
    
    
    public void removeQuestion(Question q) {
        this.questions.remove(q);
    }
    
    public Question[] getQuestions() {
        if (questions != null) {
            return questions.toArray(new Question[questions.size()]);
        } else {
            return new Question[0];
        }
    }
    
    
    
}
