package com.nemanja.quiz_service.model;

public class QuizDto {
    String category;
    Integer numQuestions;
    String title;

    public QuizDto() {
    }

    public QuizDto(String category, Integer numQuestions, String title) {
        this.category = category;
        this.numQuestions = numQuestions;
        this.title = title;
    }

    @Override
    public String toString() {
        return "QuizDto{" +
                "category='" + category + '\'' +
                ", numQuestions=" + numQuestions +
                ", title='" + title + '\'' +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(Integer numQuestions) {
        this.numQuestions = numQuestions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
