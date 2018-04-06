package com.walkerhildebrand.main;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Walker
 */
public class Question {
    protected int answer;
    protected String question;
    
    public Question(String question, int answer) {
        this.answer = answer;
        this.question = question;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public int getAnswer() {
        return answer;
    }
    
    
}
