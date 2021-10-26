package lec1;

import com.Major;
import err.IDnoException;
import gui.Uni;
import les.com.Lesson;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static lec1.ShortPrint.print;




public class Main {

	public static void main(String[] args)  throws IDnoException {
 		print(consoleColors.BLUE);	//console text color set
 		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 18)); // dialog box font settings
 		UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 14)); // dialog box buttons font settings

 		//Baslangicta bolumler icin dersler olusturulup ilgili bolumlere atamasi yapiliyor

		String ug_eem[] = {"Math","Physics","Electronics","Circuit theory"};	//ders isimleri
		int ug_credits[] = {5,6,6,5};		//derslerin kredileri
		String g_eem[] = {"Advanced-Math","Advanced-Physics","Advanced-Electronics","Advanced-Circuit theory"};
		int g_credits[] = {7,8,8,9};
		String phd_eem[] = {"PHD-Math","PHD-Physics","PHD-Electronics","PHD-Circuit theory"};
		int phd_credits[] = {10,11,12,13};


		ArrayList<Lesson> u_lessons = new ArrayList<>();		// ders nesnelerinden olusan listeler.
		ArrayList<Lesson> g_lessons = new ArrayList<>();
		ArrayList<Lesson> phd_lessons = new ArrayList<>();
		for (int i = 0; i <ug_eem.length; i++) {				//donguyle dersler listelere eklenir
			u_lessons.add(new Lesson(ug_eem[i], ug_credits[i]));
			g_lessons.add(new Lesson(g_eem[i], g_credits[i]));
			phd_lessons.add(new Lesson(phd_eem[i], phd_credits[i]));
		}

		/** major nesneleri olusturulur. parametreler:
		 * bolum ismi, egitim suresi, egitim seviyesi, bolum dersleri
		 *
		 */
		Major eem = new Major("electronic engineering", 4,0, u_lessons);   // egitim seviyesi = 0: undergraduate, 1: graduate, 2: PHD
		Major eem_graduate = new Major("electronic engineering", 2,1,g_lessons);
		Major eem_phd = new Major("electronic engineering", 4,2,phd_lessons);



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
