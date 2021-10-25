package gui;

import javax.swing.*;

public class FacultyMembers extends JFrame{
    private JPanel panel1;
    private JTextField student_id_textField;
    private JTextField student_name_textField;
    private JTextField grad_id_textField;
    private JTextField grad_names_textField;
    private JTextField student_surname_textField;
    private JButton saveStudentButton;
    private JTextField grad_surname_textField;
    private JTextField grad_thesis_textField;
    private JButton saveGradStudentButton;
    private JTextField phd_id_textField;
    private JTextField phd_name_textField;
    private JTextField phd_surname_textField;
    private JButton savePHDStudentButton;
    private JButton studentsButton;
    private JButton graduateStudentsButton;
    private JButton PHDStudentsButton;
    private JTextField grad_major_textField;
    private JTextField student_major_textField;
    private JTextField phd_thesis_textField;
    private JTextField phd_major_textField;
    private JButton facultyMembersButton;
    private JComboBox comboBox1;


    public FacultyMembers(){
        comboBox1.addItem("asdasd");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();

    }


}
