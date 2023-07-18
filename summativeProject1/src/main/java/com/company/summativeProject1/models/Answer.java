package com.company.summativeProject1.models;
public class Answer {
    private int id;
    private String question;
    private String answer;

    public Answer(String question, String answer, int id){
        this.question = question;
        this.answer = answer;
        this.id = id;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
