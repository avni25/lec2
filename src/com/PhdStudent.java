package com;

import err.IDnoException;

public class PhdStudent extends GraduateStudent{



    public PhdStudent(int idno) throws IDnoException {
        super(idno);
    }

    public PhdStudent(int idno, String name, String surname, Major major, String thesis_name) throws IDnoException {
        super(idno, name, surname, major, thesis_name);
    }




}
