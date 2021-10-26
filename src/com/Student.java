package com;

import err.IDnoException;
import les.com.Lesson;

import javax.swing.*;
import java.util.ArrayList;

public class Student implements Comparable<Student>{
    private int idno;
    private String name;
    private String surname;
    private Major major;
    private ArrayList<Lesson> lessons;
    public static final int idnoLength = 5;   // id no olmasi gereken uzunluk


    public Student (int idno) throws IDnoException {                 // constructor 1 ad, soyad gerekmiyor
        this(idno, "", "", new Major());               // ad, soyad default olarak bos.
        lessons = new ArrayList<>();
    }

    public Student(int idno, String name, String surname, Major major) throws IDnoException {    // constructor 2
        if(String.valueOf(idno).length() == this.idnoLength)
            this.idno = idno;
        else    // id no olmasi gereken uzunlukta degilse custom hata gonderir
            throw new IDnoException("ID no length must be equal to "+ this.idnoLength);

        this.name = name;
        this.surname = surname;
        this.major = major;
        this.lessons = major.getLessons();
    }

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

    public int getIdno() {
        return idno;
    }
    public int getIdnoLength() {
        return idnoLength;
    }
    public void setIdno(int idno) throws IDnoException{     // id no set edilirken de idno uzunluk kontrolu var
        if(String.valueOf(idno).length() == this.idnoLength)
            this.idno = idno;
        else{
            throw new IDnoException("ID no length must be equals to "+ this.idnoLength);
        }


    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }
    public void setLessons(ArrayList<Lesson> lessons) {
        this.lessons = lessons;
    }
    public void addLesson(Lesson les){
        this.lessons.add(les);
    }
    public void removeLesson(Lesson les){
        this.lessons.remove(les);
    }


    public void show(){
        String s = this.toString();
        JOptionPane.showMessageDialog(null,s, "Student",JOptionPane.PLAIN_MESSAGE);
    }

    public void showAdded(){
        String s = this.toString()+"\nAdded to the list";
        JOptionPane.showMessageDialog(null,s, "Student",JOptionPane.PLAIN_MESSAGE);
    }

    @Override
    public int compareTo(Student s){
        if(s.idno == this.idno)
            return 1;
        else
            return 0;

    }


    //asdasd
    @Override
    public String toString() {      // toString() fonk override
        return "Student{" +
                "idno=" + idno +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", major='"    + major.getName()+'\'' +
                '}';
    }


}
