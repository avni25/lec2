package com;

import java.util.ArrayList;



/**
 * AssocProf sinifi ResearchAsistant sinifindan türetilmişstir.
 * ResearchAssistan sinifinin degiskenlerine ek olarak "managed thesis" degiskeni vardir.
 * 3 tane constructor bulunmaktadir.
 * toString metodu sinifa uygun sekilde tekrar duzenlenmiştir.
 * */
public class AssocProf extends ResearchAssistant{

    private int managedThesis;

    public AssocProf(String name, int managedThesis) {
        super(name);
        this.managedThesis = managedThesis;
    }

    public AssocProf(String name, String surname, int managedThesis) {
        super(name, surname);
        this.managedThesis = managedThesis;
    }

    public AssocProf(String name, String surname, ArrayList<String> research_areas, ArrayList<String> publishedArticles, ArrayList<String> publishedBooks, ArrayList<String> courses, int managedThesis) {
        super(name, surname, research_areas, publishedArticles, publishedBooks, courses);
        this.managedThesis = managedThesis;
    }

    @Override
    public String toString() {
        return "Assoc.Prof{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", research_areas=" + super.getResearch_areas() +
                ", publishedArticles=" + super.getPublishedArticles() +
                ", publishedBooks=" + super.getPublishedBooks() +
                ", courses=" + super.getCourses() +
                ", managed thesis="+this.managedThesis+
                '}';
    }
}
