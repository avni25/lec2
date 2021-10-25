package com;

import err.IDnoException;
import les.com.UndergraduateLesson;

import java.util.ArrayList;

public class UndergraduateStudent extends Student {

    private ArrayList<UndergraduateLesson> lessonList;

    public UndergraduateStudent(int idno) throws IDnoException {
        super(idno);
    }

    public UndergraduateStudent(int idno, String name, String surname, Major m) throws IDnoException {
        super(idno, name, surname, m);
    }
}
