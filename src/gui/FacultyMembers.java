package gui;

import com.AssocProf;
import com.Prof;
import com.ResearchAssistant;
import err.AmountOfBookException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * bu sinif fakulte uyelerini eklemek icin kullanilan arayuz olusturur
 * comboBox dan eklenecek kisi turu secilir, ilgili alanlar doldururlur ve
 * listelere eklenir
 * Assoc Prof icin ekstra thesis alani mevcuttur. yonetilen tezleri girmek icin kullanilan texfield,
 * comboBOx dan Assoc Prof secildiginde gorunur.
 * */
public class FacultyMembers extends JFrame{
    private JPanel panel1;
    private JTextField name_TextField;
    private JTextField surname_textField;
    private JButton saveButton;
    private JButton researchAsistantsButton;
    private JButton associateProfsButton;
    private JButton profsButton;
    private JButton backButton;
    private JComboBox comboBox1;
    private JTextArea articles_textArea;
    private JTextArea research_textArea;
    private JTextArea books_textArea;
    private JLabel thesis_label;
    private JTextArea courses_textArea;
    private JTextField theisis_textField;
    private JPanel mainPanel;
    public ArrayList<ResearchAssistant> researchAssistant_list = new ArrayList<>();
    public ArrayList<AssocProf> assocProf_list = new ArrayList<>();
    public ArrayList<Prof> prof_list = new ArrayList<>();
    private String table_columns[] = {"Title","Name","Surname", "Research Field","Articles","Books","Courses", "Thesis"};

    /**
     * Constructor
     * */
    public FacultyMembers(){

        comboBox1.addItem("Research Assistant");        //pencere acıldiginda comboboxa ogeleri ekler
        comboBox1.addItem("Associate Prof");
        comboBox1.addItem("Prof");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
//        this.setSize(1800,150);
        this.pack();
        this.setLocationRelativeTo(null);

        /**
         * comboBox degistirildigi zaman yapilacak islemler
         * */
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(comboBox1.getSelectedIndex()==1){        //Asssoc Pro secirilirse
                    theisis_textField.setVisible(true);     //texfield aktif eder
                    thesis_label.setVisible(true);          //thesis label aktif eder
                    FacultyMembers.super.pack();            // pencere boyutunu ayarlar
                }else{                                         //baska bir oge secilirse
                    theisis_textField.setVisible(false);       // textfield gizle
                    thesis_label.setVisible(false);         // thesis label gizle
                    FacultyMembers.super.pack();             //pencere boyutunu ayarla
                }
            }
        });

        /**
         * Save butonuna basildiginda ilgili kisiyi object olarak olusturur ve ilgili listeye ekler
         * */
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBox1.getSelectedIndex();
                // Text area lardan ilgili veriler alinarak listler olusturulur
                ArrayList<String> articles = new ArrayList<>(Arrays.asList(articles_textArea.getText().split(",")));
                ArrayList<String> researches = new ArrayList<>(Arrays.asList(research_textArea.getText().split(",")));
                ArrayList<String> books = new ArrayList<>(Arrays.asList(books_textArea.getText().split(",")));
                ArrayList<String> courses = new ArrayList<>(Arrays.asList(courses_textArea.getText().split(",")));
                int thesis =0;
                switch (index){     // 0: Research Assistant, 1: ASsoc. Prof, 2: Prof
                    case 0:
                        // alinan inptlarla obje olusturur
                        ResearchAssistant rs = new ResearchAssistant(name_TextField.getText(), surname_textField.getText(), researches, articles, books, courses);
                        researchAssistant_list.add(rs);     //research Assistan ı listeye ekler
                        cleanTextFields();                  // input textleri temizler
                        System.out.println("research Assistant added to List.");
                        rs.showAdded();
                        break;
                    case 1:

                        try{
                             thesis = Integer.parseInt(theisis_textField.getText());    // theisi textini int e donusturur
                        }catch (NumberFormatException ee){
                            System.out.println(ee.getMessage());
                        }catch(NullPointerException ne){
                            System.out.println(ne.getMessage());
                        }
                        // alinan inptlarla obje olusturur
                        AssocProf ap = new AssocProf(name_TextField.getText(), surname_textField.getText(), researches, articles, books, courses, thesis);
                        assocProf_list.add(ap);         //Assoc Prof listeye ekler
                        cleanTextFields();              // input textleri temizler
                        System.out.println("Associate Prof added to List.");
                        ap.showAdded();
                        break;
                    case 2:
                        // alinan inptlarla obje olusturur
                        Prof p = null;
                        try {
                            p = new Prof(name_TextField.getText(), surname_textField.getText(), researches, articles, books, courses, thesis);
                            prof_list.add(p);               // Prof  listeye ekler
                            cleanTextFields();              // input textleri temizler
                            System.out.println("Prof added to List.");
                            p.showAdded();
                        } catch (AmountOfBookException e1) {        // kitaplar 3 ten az ise
                            System.out.println(e1.getMessage());
                            System.out.println("Prof couldn't be added to List.");
                        }catch(NullPointerException ne){            // text box bos ise
                            System.out.println(ne.getMessage());
                        }


                        break;

                }

            }
        });

        /**
         * Butona basildiginda research asistanlari listeler
         * */
        researchAsistantsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = convertRAListToString(researchAssistant_list);
                JOptionPane.showMessageDialog(null,text, "info",JOptionPane.PLAIN_MESSAGE);
            }
        });

        /**
         * Butona basildiginda Assoc Proflari listeler
         * */
        associateProfsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = convertAPListToString(assocProf_list);
                JOptionPane.showMessageDialog(null,text, "info",JOptionPane.PLAIN_MESSAGE);

            }
        });

        /**
         * Butona basildiginda proflari listeler
         * */
        profsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = convertPListToString(prof_list);
                JOptionPane.showMessageDialog(null,text, "info",JOptionPane.PLAIN_MESSAGE);
            }
        });

        /**
         * butona basildiginda bir onceki pencereyi acar.
         * Bu pencereyi kapatir
         * */
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sm = new Uni("my uni");
                sm.setVisible(true);              // yeni pencere (Faculty members) acar
                FacultyMembers.super.setVisible(false);
                cleanTextFields();
            }
        });
    }

    /**
     * tetx fieldlari temizler
     * */
    public void cleanTextFields(){
        name_TextField.setText("");
        surname_textField.setText("");
        research_textArea.setText("");
        articles_textArea.setText("");
        books_textArea.setText("");
        courses_textArea.setText("");
        theisis_textField.setText("");
    }

    public String[][]  convertListTo2DArray(ArrayList<AssocProf> l){
        String arr[][]= new String[l.size()][8];
        for (int i = 0; i < l.size(); i++) {
            arr[i][0] = l.get(i).getClass().toString();
            arr[i][1] = l.get(i).getName();
            arr[i][2] = l.get(i).getSurname();
            arr[i][3] = l.get(i).getResearch_areas().toString();
            arr[i][4] = l.get(i).getPublishedArticles().toString();
            arr[i][5] = l.get(i).getPublishedBooks().toString();
            arr[i][6] = l.get(i).getCourses().toString();
            String s = l.get(i).getClass().toString();
            if(s.contains("AssocProf")){
                arr[i][7] = l.get(i).getManagedThesis()+"";
            }else{
                arr[i][7] = "";
            }
        }

        return arr;
    }

    public String convertRAListToString(ArrayList<ResearchAssistant> rs){
        String res ="Reasearch assistants List\n";
        System.out.println("---------------------------------Research Assistants List--------------------------------------");
        for (int i = 0; i < rs.size(); i++) {
            res += "["+rs.get(i).getName() + " "+ rs.get(i).getSurname()+", "+
                    "researches: "+rs.get(i).getResearch_areas()+", "+
                    "articles: "+rs.get(i).getPublishedArticles()+", "+
                    "Books: "+rs.get(i).getPublishedBooks()+", "+
                    "Course: "+rs.get(i).getPublishedBooks()+"]\n";
        }
        System.out.println(res);
        return res;
    }


    public String convertAPListToString(ArrayList<AssocProf> rs){
        String res ="Associate Prof List List\n";
        System.out.println("---------------------------------Associate Prof List--------------------------------------");
        for (int i = 0; i < rs.size(); i++) {
            res += "["+rs.get(i).getName() + " "+ rs.get(i).getSurname()+", "+
                    "researches: "+rs.get(i).getResearch_areas()+", "+
                    "articles: "+rs.get(i).getPublishedArticles()+", "+
                    "Books: "+rs.get(i).getPublishedBooks()+", "+
                    "Course: "+rs.get(i).getPublishedBooks()+
                    "thesis: "+rs.get(i).getManagedThesis()+"]\n";
        }
        System.out.println(res);
        return res;
    }

    public String convertPListToString(ArrayList<Prof> rs){
        String res ="Prof List List\n";
        System.out.println("---------------------------------Prof List--------------------------------------");
        for (int i = 0; i < rs.size(); i++) {
            res += "["+rs.get(i).getName() + " "+ rs.get(i).getSurname()+", "+
                    "researches: "+rs.get(i).getResearch_areas()+", "+
                    "articles: "+rs.get(i).getPublishedArticles()+", "+
                    "Books: "+rs.get(i).getPublishedBooks()+", "+
                    "Course: "+rs.get(i).getPublishedBooks()+
                    "thesis: "+rs.get(i).getManagedThesis()+"]\n";
        }
        System.out.println(res);
        return res;
    }

}
