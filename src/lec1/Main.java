package lec1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import static lec1.ShortPrint.*;




public class Main {

	public static void main(String[] args)  throws IDnoException{
 		print(consoleColors.BLUE);	//console text color set
 		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18)); // dialog box font settings
 		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14)); // dialog box buttons font settings


 		ArrayList<Student> student_list = new ArrayList<>();
// 		//soru 4
 //		Homeworks.Hw2.addStudents(student_list);
 //		Homeworks.Hw2.printStudentList(student_list);
 //		Homeworks.Hw2.addStudentsUsingGUI(student_list);

// 		// soru 3
// 		Homeworks.Hw2.findCity();

// 		//soru 2
// 		Homeworks.Hw2.showEmojis(50,50);

 		print("huseyin avni");


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



}
