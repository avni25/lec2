package com;

import java.util.ArrayList;
import err.AmountOfBookException;


/**
 * Prof sinifi Assoc.Prof sinifindan türetilmistir.
 * Assoc.Prof un sahip oldugu tum degiskenler bu sınıfta da mevcuttur.
 * Constructorlar aynidir
 * Ek olarak yayinlanan kitap sayisinda en az 3 olma satri bulunmaktadir.
 * kitap sayisi 3 ten az ise hata dondurur.
 * toString metodu da modifiye edilmistir.
 * */
public class Prof extends AssocProf{

    public Prof(String name, int managedThesis) {
        super(name, managedThesis);
    }

    public Prof(String name, String surname, int managedThesis) {
        super(name, surname, managedThesis);
    }

    public Prof(String name, String surname, ArrayList<String> research_areas, ArrayList<String> publishedArticles, ArrayList<String> publishedBooks, ArrayList<String> courses, int managedThesis) {
        super(name, surname, research_areas, publishedArticles, publishedBooks, courses, managedThesis);
    }
    /**
     * override method: prof sinifinda minimum yayinlanan kitap sayisi 3 olmali.
     * 3un altinda ise custom hata verir.
     * */
    public void setPublishedBooks(ArrayList<String> publishedBooks) throws AmountOfBookException{
        if(publishedBooks.size() >= 3){
            try {
                super.setPublishedBooks(publishedBooks);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            throw  new AmountOfBookException("Books written by prof must be at least 3!!!!");
        }

    }

    @Override
    public String toString() {
        return "Prof{" +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", research_areas=" + super.getResearch_areas() +
                ", publishedArticles=" + super.getPublishedArticles() +
                ", publishedBooks=" + super.getPublishedBooks() +
                ", courses=" + super.getCourses() +
                '}';
    }
}
