package com;

import lec1.IDnoException;

public class GraduateStudent extends Student{

    private String thesis_name;

    public GraduateStudent(int idno) throws IDnoException {
        super(idno);
    }

    public GraduateStudent(int idno, String name, String surname, Major major, String thesis_name) throws IDnoException {
        super(idno, name, surname, major);
        this.thesis_name = thesis_name;
    }

    public String getThesis_name() {
        return thesis_name;
    }

    public void setThesis_name(String thesis_name) {
        this.thesis_name = thesis_name;
    }

    @Override
    public String toString() {
        return "GraduateStudent{" +
                "thesis_name='" + thesis_name + '\'' +
                "} " + super.toString();
    }
}
