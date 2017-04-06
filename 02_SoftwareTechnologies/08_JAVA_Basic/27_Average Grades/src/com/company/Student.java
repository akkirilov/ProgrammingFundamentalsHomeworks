package com.company;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Double> grades;

    public String getName() {
        return name;
    }

    public void setName(String n){
        this.name = n;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public double getAverage(){
        double av = 0;
        for(Double grade : this.grades){
            av += grade;
        }

        return av / this.grades.size();
    }
}