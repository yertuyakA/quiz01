package com.quiz;

import java.util.List;

public abstract class Theme {
    private List<QuestionAnswers> questions;
    private int id;
    private int themeId;
    private String question;
    private String answer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private int point;

    public abstract void checkAnswers();

    void setId(int id) {this.id = id;}
    void setThemeId(int themeId) {this.themeId = themeId;}
    void setQuestion(String question) {this.question = question;}
    void setAnswer(String answer) {this.answer = answer;}
    void setWrongAnswer1(String wrongAnswer1) {this.wrongAnswer1 = wrongAnswer1;}
    void setWrongAnswer2(String wrongAnswer2) {this.wrongAnswer2 = wrongAnswer2;}
    void setWrongAnswer3(String wrongAnswer3) {this.wrongAnswer3 = wrongAnswer3;}
    void setPoint(int point) {this.point = point;}

    void setQuestionList(List<QuestionAnswers> questions) {
        this.questions = questions;
    }

    int getId() {return id;}
    int getThemeId() {return themeId;}
    String getQuestion() {return question;}
    String getAnswer() {return answer;}
    String getWrongAnswer1() {return wrongAnswer1;}
    String getWrongAnswer2() {return wrongAnswer2;}
    String getWrongAnswer3() {return wrongAnswer3;}
    int getPoint() {return point;}

    public List<QuestionAnswers> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", themeId=" + themeId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", wrongAnswer1='" + wrongAnswer1 + '\'' +
                ", wrongAnswer2='" + wrongAnswer2 + '\'' +
                ", wrongAnswer3='" + wrongAnswer3 + '\'' +
                ", point=" + point +
                '}';
    }
}
