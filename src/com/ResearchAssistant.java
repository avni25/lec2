package com;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ResearchAssistant sinifi:
 *
 * */
public class ResearchAssistant {

    private String name;                            // isim
    private String surname;                         // soyisism
    private ArrayList<String> research_areas;       // arastirma alanlari
    private ArrayList<String> publishedArticles;    // yayinlanmis makalaeler
    private List<String> publishedBooks;            // yayinlanmis kitaplar
    private ArrayList<String> courses;              // verdigi dersler

    //------------------------------CONSTRUCTORS---------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------

    public ResearchAssistant(String name) {
        this(name, "", new ArrayList<>(), new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
    }

    public ResearchAssistant(String name, String surname) {
        this.name = name;
        this.surname = surname;
        research_areas = new ArrayList<>();
        publishedArticles = new ArrayList<>();
        publishedBooks = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public ResearchAssistant(String name, String surname, ArrayList<String> research_areas, ArrayList<String> publishedArticles, ArrayList<String> publishedBooks, ArrayList<String> courses) {
        this.name = name;
        this.surname = surname;
        this.research_areas = research_areas;
        this.publishedArticles = publishedArticles;
        this.publishedBooks = publishedBooks;
        this.courses = courses;
    }
    //--------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList<String> getResearch_areas() {
        return research_areas;
    }

    public void setResearch_areas(ArrayList<String> research_areas) {
        this.research_areas = research_areas;
    }

    public ArrayList<String> getPublishedArticles() {
        return publishedArticles;
    }

    public void setPublishedArticles(ArrayList<String> publishedArticles) {
        this.publishedArticles = publishedArticles;
    }

    public List<String> getPublishedBooks() {
        return publishedBooks;
    }

    public void setPublishedBooks(ArrayList<String> publishedBooks) throws Exception{
        this.publishedBooks = publishedBooks;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }


    public void show(){
        String s = this.toString();
        JOptionPane.showMessageDialog(null,s, "info",JOptionPane.PLAIN_MESSAGE);
    }

    public void showAdded(){
        String s = this.toString()+"\nAdded to the list";
        JOptionPane.showMessageDialog(null,s, "info",JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public String toString() {
        return "ResearchAssistant{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", research_areas=" + research_areas +
                ", publishedArticles=" + publishedArticles +
                ", publishedBooks=" + publishedBooks +
                ", courses=" + courses +
                '}';
    }
}
