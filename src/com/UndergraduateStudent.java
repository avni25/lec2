package com;

import lec1.IDnoException;

import java.util.List;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(int idno) throws IDnoException {
        super(idno);
    }

    public UndergraduateStudent(int idno, String name, String surname, Major m) throws IDnoException {
        super(idno, name, surname, m);
    }
}
