package lec1;

import com.*;
import err.AmountOfBookException;
import err.IDnoException;
import gui.Uni;
import les.com.Lesson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static lec1.ShortPrint.print;




public class Main {

	public static void main(String[] args)  throws IDnoException {
 		print(consoleColors.BLUE);	//console text color set
 		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18)); // dialog box font settings
 		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14)); // dialog box buttons font settings

 		ArrayList<Student> student_list = new ArrayList<>();
		ArrayList<Prof> profs = new ArrayList<>();
		ArrayList<AssocProf> assocProfs = new ArrayList<>();
		ArrayList<ResearchAssistant> researchAssistants = new ArrayList<>();
		ArrayList<GraduateStudent> grad_student_list = new ArrayList<>();
		ArrayList<UndergraduateStudent> undergrad_student_list = new ArrayList<>();
		ArrayList<PhdStudent> phd_student_list = new ArrayList<>();

		String ug_eem[] = {"Math","Physics","Electronics","Circuit theory"};
		int ug_credits[] = {5,6,6,5};
		String g_eem[] = {"Advanced-Math","Advanced-Physics","Advanced-Electronics","Advanced-Circuit theory"};
		int g_credits[] = {7,8,8,9};
		String phd_eem[] = {"PHD-Math","PHD-Physics","PHD-Electronics","PHD-Circuit theory"};
		int phd_credits[] = {10,11,12,13};


		ArrayList<Lesson> u_lessons = new ArrayList<>();
		ArrayList<Lesson> g_lessons = new ArrayList<>();
		ArrayList<Lesson> phd_lessons = new ArrayList<>();
		for (int i = 0; i <ug_eem.length; i++) {
			u_lessons.add(new Lesson(ug_eem[i], ug_credits[i]));
			g_lessons.add(new Lesson(g_eem[i], g_credits[i]));
			phd_lessons.add(new Lesson(phd_eem[i], phd_credits[i]));
		}

		Major eem = new Major("electronic engineering", 4,0);
		eem.setLessons(u_lessons);
		Major eem_graduate = new Major("electronic engineering", 2,1);
		eem_graduate.setLessons(g_lessons);
		Major eem_phd = new Major("electronic engineering", 4,2);
		eem_phd.setLessons(phd_lessons);


		print("qeqwe");

		Student s = new Student(12345, "huseyin","cubukcu", eem_graduate);
//		s.show();
		print(s.getLessons());

		UndergraduateStudent us = new UndergraduateStudent(44558, "martin", "cubukcu",eem);
		print(us.getLessons());

		GraduateStudent gs = new GraduateStudent(88777, "tanya","cubukcu", eem_graduate, "qwe");
		print(gs.toString());

		PhdStudent ps = new PhdStudent(66977, "avni","cubukcu", eem_phd, "my thesis");
		print(ps.getLessons());
		print("---------------------------------------------");

		Prof avni = new Prof("avni","cubukcu",0);
		ArrayList<String> books = new ArrayList<>(Arrays.asList("asd","zxc"));
		try {
			avni.setPublishedBooks(books);
		} catch (AmountOfBookException e) {
			print(e.getMessage());
		}
		print(avni);
		print("------------------------------------");

		AssocProf martin = new AssocProf("T.Martin", "cubukcu",12);
		print(martin);

		JFrame ui = new Uni("my uni");
		ui.setVisible(true);


	}




	public static int generateRandomNumber(int max){
		return (int)(Math.random()*max);
	}

	/**
	* Generates number between two given values
	* including min value, but excluding max value
	* */
	public static int generateRandomNumber(int min, int max){
		return (int) (Math.random() * (max - min)) + min;
	}



}
