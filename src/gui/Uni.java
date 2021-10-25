package gui;

import com.GraduateStudent;
import com.Major;
import com.PhdStudent;
import com.Student;
import err.IDnoException;
import lec1.ShortPrint;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Ogrenci kayit ekrani icin JFrame kutuphaneisnden turetilmis siniftir.
 * JFrame kutuphanesi ogeleri kullanilarak pencere olusturulmustur.
 * İlgili alanlar doldurularak ogrenci turune gore bilgileri girilir, kaydedilir ve listelenir
 *
 * */
public class Uni extends JFrame{

    /**
     * gorsel ogeler
     * */
    private JPanel panel1;
    private JTextField student_id_textField;
    private JTextField student_name_textField;
    private JTextField grad_id_textField;
    private JTextField grad_names_textField;
    private JTextField student_surname_textField;
    private JTextField student_major_textField;
    private JButton saveStudentButton;
    private JTextField phd_id_textField;
    private JTextField phd_name_textField;
    private JTextField phd_surname_textField;
    private JButton savePHDStudentButton;
    private JButton saveGradStudentButton;
    private JTextField grad_thesis_textField;
    private JTextField grad_surname_textField;
    private JButton studentsButton;
    private JButton graduateStudentsButton;
    private JButton PHDStudentsButton;
    private JTextField phd_thesis_textField;
    private JTextField grad_major_textField;
    private JTextField phd_major_textField;
    private JButton facultyMembersButton;
    public ArrayList<Student> student_list = new ArrayList<>();
    public ArrayList<GraduateStudent> grad_student_list = new ArrayList<>();
    public ArrayList<PhdStudent> phd_student_list = new ArrayList<>();



    /**
     * Constructor
     * @param title pencere ismi
     * */
    public Uni(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();


        /**
         * Save student butonuna basildiginda girilen ogranciyi ilgili listeye ekler
         *
         *
         * */
        saveStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(student_id_textField.getText());	//idno textboxt textini alir ve int cevirir
                Student s = null;								// studen nesnesi olusturur
                try {											//idno uzunluk kontrolu icin try catch
                    s = new Student(id, student_name_textField.getText(), student_surname_textField.getText(), new Major(student_major_textField.getText()));
                    student_list.add(s); 									//olusturulan student nesnesi fonk parametrisi olan Student listesine eklenir
                    System.out.println(s+ " added to list.");
                } catch (IDnoException ex) {					//id no uzunluk olmasi gereken uzunlukta degilse:
                    ex.getMessage();
                    System.out.println("unable to add student!");
                }

                student_id_textField.setText("");		//textbox text sifirla
                student_name_textField.setText("");		//textbox text sifirla
                student_surname_textField.setText("");	//textbox text sifirla
                student_major_textField.setText("");
            }
        });

        /**
         * Save graduate student butonuna basildiginda girilen ogranciyi ilgili listeye ekler
         * */
        saveGradStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(grad_id_textField.getText());	//idno textboxt textini alir ve int cevirir
                GraduateStudent gs = null;								// studen nesnesi olusturur
                try {											//idno uzunluk kontrolu icin try catch
                    gs = new GraduateStudent(id, grad_names_textField.getText(), grad_surname_textField.getText(), new Major(grad_major_textField.getText()),grad_thesis_textField.getText());
                    grad_student_list.add(gs); 									//olusturulan student nesnesi fonk parametrisi olan Student listesine eklenir
                    System.out.println(gs+ " added to list.");
                } catch (IDnoException ex) {					//id no uzunluk olmasi gereken uzunlukta degilse:
                    ex.getMessage();
                    System.out.println("unable to add Grad student!");
                }

                grad_id_textField.setText("");		//textbox text sifirla
                grad_names_textField.setText("");		//textbox text sifirla
                grad_surname_textField.setText("");	//textbox text sifirla
                grad_major_textField.setText("");
                grad_thesis_textField.setText("");
            }
        });

        /**
         * Save phd student butonuna basildiginda girilen ogranciyi ilgili listeye ekler
         * */
        savePHDStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(phd_id_textField.getText());	//idno textboxt textini alir ve int cevirir
                PhdStudent phds = null;								// studen nesnesi olusturur
                try {											//idno uzunluk kontrolu icin try catch
                    phds = new PhdStudent(id, phd_name_textField.getText(), phd_surname_textField.getText(), new Major(phd_major_textField.getText()),phd_thesis_textField.getText());
                    phd_student_list.add(phds); 									//olusturulan student nesnesi fonk parametrisi olan Student listesine eklenir
                    System.out.println(phds+ " added to list.");
                } catch (IDnoException ex) {					//id no uzunluk olmasi gereken uzunlukta degilse:
                    ex.getMessage();
                    System.out.println("unable to add Phd student!");
                }

                phd_id_textField.setText("");		//textbox text sifirla
                phd_name_textField.setText("");		//textbox text sifirla
                phd_surname_textField.setText("");	//textbox text sifirla
                phd_major_textField.setText("");
                phd_thesis_textField.setText("");
            }
        });


        /**
         * Students bunonuna tiklandiginda ilgili ogrencileri listeler
         * */
        studentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("---------------------------------Undergraduate Students List--------------------------------------");
                ShortPrint.print(student_list);
            }
        });

        /**
         * Graduate students bunonuna tiklandiginda ilgili ogrencileri listeler
         * */
        graduateStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("-------------------------Graduate Students List----------------------------------------------");
                ShortPrint.print(grad_student_list);
            }
        });

        /**
         * PHD students bunonuna tiklandiginda ilgili ogrencileri listeler
         * */
        PHDStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("-------------------------PHD Students List----------------------------------------------");
                ShortPrint.print(phd_student_list);
            }
        });

        //Facult members bunonuna tiklandiginda;
        facultyMembersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame fm = new FacultyMembers();   // yeni faculty member jframe objesi olusturur. (pencere)
                fm.setVisible(true);              // yeni pencere (Faculty members) acar
                Uni.super.setVisible(false);    //onceki student pencerisini kapatir
            }
        });
    }





}
