package lec1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lec1.ShortPrint.print;

public class Homeworks {


    //odev 1
    public class Hw1{
        /*
         * calculates two given number according to string's operator.
         *
         * */
        public static double calculate(String str){
            Double res =0.0, d1, d2;
            String[] arr={};
            if(str.contains("+")){
                arr = str.split("\\+");
                res = Double.parseDouble(arr[0]) + Double.parseDouble(arr[1]);
            }
            else if(str.contains("-")){
                arr = str.split("-");
                res = Double.parseDouble(arr[0]) - Double.parseDouble(arr[1]);
            }
            else if(str.contains("/")){
                arr = str.split("/");
                if(Double.parseDouble(arr[1])==0.0)
                    throw new ArithmeticException("infinite number");
                try{
                    res = Double.parseDouble(arr[0]) / Double.parseDouble(arr[1]);
                }catch (ArithmeticException e){
                    print("can't divide!! "+e.getMessage());
                }finally {
                    print("final block");
                }

            }
            else if(str.contains("*")){
                arr = str.split("\\*");
                res = Double.parseDouble(arr[0]) * Double.parseDouble(arr[1]);
            }
            else{

            }

            return res;
        }

        public static int generateRandomNumber(int max){
            return (int)(Math.random()*max);
        }

        /*
         * Generates number between two given values
         * including min value, but excluding max value
         * */
        public static int generateRandomNumber(int min, int max){
            return (int) (Math.random() * (max - min)) + min;
        }

        /*
         * tries to guess computer's random number which is generated
         * between min and max values. it cotinues until finding the correct number.
         * */
        public static void guessCompNumber(int min, int max){
            int compNum = generateRandomNumber(min, max);
            int guess=0;
            try{
                guess = Integer.parseInt(JOptionPane.showInputDialog("Find computer's number.\n enter a number between "+min+" and "+max));
            }catch(Exception e){
                print(e.getMessage());
            }

            while(compNum != guess){
                if(guess < compNum)
                    guess = Integer.parseInt(JOptionPane.showInputDialog("guess bigger than "+ guess));
                else if(guess > compNum)
                    guess = Integer.parseInt(JOptionPane.showInputDialog("guess smaller than "+guess));
            }

            print(guess);


        }

        public static void guessPlayerNum(int playerGuess, int min, int max){
            int compGuess = generateRandomNumber(min, max);
            int dir=0, count=0;
            while(playerGuess != compGuess){
                try{
                    dir = Integer.parseInt(JOptionPane.showInputDialog("computer guess is "+compGuess+"\nsmaller -> 0\nbigger -> 1\ntry: "+count));
                }catch(ArithmeticException e){
                    print("input error: "+e.getMessage());
                }catch(NullPointerException e){
                    print("no input: "+ e.getMessage());
                }finally {
                    print("final block");
                }

                if(dir == 1){
                    min = compGuess;
                }else if(dir == 0){
                    max = compGuess+1;
                }
                compGuess = generateRandomNumber(min, max);
                count++;
            }
            print("success!!! "+compGuess+"\ntry: "+count);
        }

    }

    //Odev 2
    public class Hw2{


        // SOru 4
        public static void addStudents(List<Student> s_list) throws IDnoException{
            print(consoleColors.BLUE);				//console text color = Blue
            Scanner sc = new Scanner(System.in);
            int howmanyStudent=0;					// kac ogrenci eklenmek isteniyor. default val = 0
            print("enter the number of students you would like to add...");
            try{									// input rakam olmali. aksi tektirde exception dondurur
                howmanyStudent = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                print(e.getMessage());
            }
            int count=1;							//donguyu sonladirmak icin olusturulan degisken. listeye eklenen studentlari sayar
            while(howmanyStudent >=count){
                print("enter id for student "+count+" (id must be "+Student.idnoLength+" digits number)");
                int id = 0;
                String name = "", surname = "";
                try{								//id icin input alir
                    id = Integer.parseInt(sc.nextLine());
                }catch(Exception e){
                    print(e.getMessage());
                }
                print("enter student name: ");
                name = sc.nextLine();				// name icin input alir
                print("enter student surname: ");
                surname = sc.nextLine();			// surname icin input alir
                Student s1;							//student nesnesi olusturur
                try{								// alinan inputlari student nesnesine atar ve listeye ekler
                    s1 = new Student(id, name, surname);
                    s_list.add(s1);
                    count++;
                }catch(IDnoException e){			// id no uzunluk dogru degilse hata verir.
                    print(e.getMessage());
                    continue;
                }


            }
        }

        //Student listesini ekrana yazdirir
        public static void printStudentList(List<Student> l){
            for(int i=0; i<l.size();i++)
                print(l.get(i));
        }

        //swing kutuphanesi kullanilarak olusturulmustur
        public static void addStudentsUsingGUI(List<Student> l) {

            JFrame f = new JFrame("new window");			//frame nesnesi olusturur
            JLabel l_idno = new JLabel("ID No: ");			//label nesnesi olusturur
            JLabel l_name = new JLabel("Name: ");			//label nesnesi olusturur
            JLabel l_surname = new JLabel("Surname: ");	//label nesnesi olusturur

            JButton b_save = new JButton("Save");			//buton nesnesi olusturur
            JButton b_show = new JButton("View List");		//buton nesnesi olusturur

            JTextField t_idno = new JTextField(5);		// textbox nesnesi olusturur
            JTextField t_name = new JTextField(10);		// textbox nesnesi olusturur
            JTextField t_surname = new JTextField(10);	// textbox nesnesi olusturur

            JPanel p = new JPanel();							// panel nesnesi olusturur
            p.add(l_idno);										//panel nesnesinin icine butonlari, labelari ve textbox lari ekler
            p.add(t_idno);
            p.add(l_name);
            p.add(t_name);
            p.add(l_surname);
            p.add(t_surname);

            p.add(b_save);
            p.add(b_show);
//		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
            f.add(p);
            f.setSize(300,300);			// pencere buyuklugu
            f.pack();								// pencere gorunum format
            f.setVisible(true);						// pencereyi gosterir

            //view list butonuna basildiginda:
            b_show.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    printStudentList(l);
                }
            });

            //Save butonuna basildiginda
            b_save.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int id = Integer.parseInt(t_idno.getText());	//idno textboxt textini alir ve int cevirir
                    Student s = null;								// studen nesnesi olusturur
                    try {											//idno uzunluk kontrolu icin try catch
                        s = new Student(id, t_name.getText(), t_surname.getText());
                        l.add(s); 									//olusturulan student nesnesi fonk parametrisi olan Student listesine eklenir
                        print(s.toString()+ " added to list.");
                    } catch (IDnoException ex) {					//id no uzunluk olmasi gereken uzunlukta degilse:
                        ex.getMessage();
                        print("unable to add student!");
                    }

                    t_idno.setText("");		//textbox text sifirla
                    t_name.setText("");		//textbox text sifirla
                    t_surname.setText("");	//textbox text sifirla
                }
            });


        }

        //Soru 3
        public static  void findCity(){
            String[] cities = {"ANTALYA", "BURSA", "IZMIR", "MUGLA","ANKARA", "EDIRNE", "ISTANBUL","TRABZON","GIRESUN"};
            int a = Homeworks.Hw1.generateRandomNumber(0, cities.length);  // iki deger arasinda random sayi uretir
            int score = 0, turn=0;
            char[] answer = cities[a].toCharArray();	// yeni bir char dizisi
            print(cities[a]+" - len: "+ answer.length);
            List<String> player_stat = new ArrayList<>();	// player dogru tercihlerini tutan liste
            for(int i= 0;i<answer.length;i++){
                player_stat.add("-");			// default value olarak player dogru tercihleri hepsi "-"
            }

            print(player_stat);
            while(player_stat.contains("-")){  // player tercihleri listesi "-" icerdigi surece oyun devam eder
                turn++;
                String display_string = "length: "+ cities[a].length()+"\n"+	// dialog da gosterilecek string ifade
                        player_stat+"\n"+
                        "score: "+ score+"\n"+
                        "round: "+turn;
                String s;
                try{
                    s = JOptionPane.showInputDialog(null, display_string);	//input alir
                    s = s.toUpperCase();
                }catch(NullPointerException e){	// input bossa oyundan cikar
                    print(e.getMessage());
                    s = "-";
                    break;
                }

                for(int i=0;i<answer.length;i++){	// dogru tahmin ise "-" degerlrini dogru tahmin edilen harfler ile degistirir
                    if(s.equals(Character.toString(answer[i]))) {
                        player_stat.set(i, Character.toString(answer[i]));
                        score++;	//dogru tahmin ise skor++
                    }
                }//for

            }//while
            if(!player_stat.contains("-")){	// oyuncu butun harfleri tahmin ederse
                JOptionPane.showMessageDialog(null, "Congratulations!\nyou found city: "+
                        cities[a]+"\n"+
                        "Your score: "+score);
            }else{
                JOptionPane.showMessageDialog(null, "you quit the game.");
            }

        }

        // Soru 2
        public static void showEmojis(int width, int height){
            String[] image_file_names = {"angel.png","basketball.png","bicycle.png", "car.png","pawn.png","rainbow.png", "sad.png","smile.png","tree.png","umbrella.png"};

            while(true){
                try{
                    String s = JOptionPane.showInputDialog(null,"enter a number between 0 and "+image_file_names.length);
                    if(s==null) break;													// birsey girilmezse donguden cikar
                    int index_choice = Integer.parseInt(s);								// inputu integer cevirir
                    String dir = "src/lec1/images/"+image_file_names[index_choice];		 //dosya yolu
                    String emo_name = image_file_names[index_choice].split("\\.")[0];	//dosya ismini string degere etar
                    //imageIcaon objesi olusturur.
                    ImageIcon icon1 = new ImageIcon(new ImageIcon(dir).getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
                    JOptionPane.showMessageDialog(null, emo_name, "qwr", JOptionPane.PLAIN_MESSAGE, icon1);
                }catch(ArrayIndexOutOfBoundsException e){	// index degeri dizinin disindaysa dondurur
                    print(e.getMessage());
                }catch (NumberFormatException e){		// rakam disinda bir ifade girilirse dondurur.
                    print(e.getMessage());
                }
            }




        }
    }



}
