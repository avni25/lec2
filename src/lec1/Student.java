package lec1;

import javax.swing.*;
import java.util.Objects;

public class Student implements Comparable<Student>{
    private int idno;
    private String name;
    private String surname;
    public static final int idnoLength = 5;   // id no olmasi gereken uzunluk

    public Student (int idno) throws IDnoException{                 // constructor 1 ad, soyad gerekmiyor
        this(idno, "", "");                             // ad, soyad default olarak bos.
    }

    public Student(int idno, String name, String surname) throws IDnoException {    // constructor 2
        if(String.valueOf(idno).length() == this.idnoLength)
            this.idno = idno;
        else    // id no olmasi gereken uzunlukta degilse custom hata gonderir
            throw new IDnoException("ID no length must be equal to "+ this.idnoLength);

        this.name = name;
        this.surname = surname;

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

    public void show(){
        String s = this.toString();
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
                '}';
    }


}
