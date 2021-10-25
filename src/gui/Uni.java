package gui;

import com.*;
import err.IDnoException;
import lec1.ShortPrint;

import static lec1.ShortPrint.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Uni extends JFrame{
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
    public ArrayList<Student> student_list = new ArrayList<>();
    public ArrayList<GraduateStudent> grad_student_list = new ArrayList<>();
    public ArrayList<PhdStudent> phd_student_list = new ArrayList<>();

    public Uni(String title) {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

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

        studentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShortPrint.print(student_list);
            }
        });
        graduateStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShortPrint.print(grad_student_list);
            }
        });
        PHDStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShortPrint.print(phd_student_list);
            }
        });
    }





}
