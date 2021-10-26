package com;

import les.com.Lesson;

import java.util.ArrayList;

public class Major {

    private String name;
    private int duration;
    private int degree;    // 0: undergraduate, 1: graduate, 2: PHD
    private ArrayList<Lesson> lessons;



    public Major(){
        this.lessons = new ArrayList<>();
    }

    public Major(String name) {
        this(name, 0, 0);
        this.lessons = new ArrayList<>();
    }
    public Major(String name, int duration, int degree) {
        this.name = name;
        this.duration = duration;
        this.degree = degree;
        this.lessons = new ArrayList<>();
    }

    public Major(String name, int duration, int degree, ArrayList<Lesson> lessons) {
        this.name = name;
        this.duration = duration;
        this.degree = degree;
        this.lessons = lessons;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", lessons=" + lessons +
                '}';
    }
}
