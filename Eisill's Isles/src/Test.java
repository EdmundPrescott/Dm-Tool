import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		 
		int four=4;
		Reader read = new Reader();
		Player Player = new Player(0,0);
		Player.test();
		boolean testing=true;
		//while(testing==true){read.readRaces();}
		//System.out.println("Speed: "+Player.getSpeed());
		//System.out.println("Size: "+Player.getSize());
		//String butt="poop buuts 69 lolololololo";
		//System.out.println(butt.matches(".*\\d+.*"));// detects number
		//System.out.println(extractNumber(butt));
		//read.readRaces("");
		
		//read.readRaces("Human");
		//read.readRaces("Elf");
		//read.readRaces("Dwarve");
		//read.readRaces("Half-Orc");
		
}
	
	public static String extractNumber(String str) {                

	    if(str == null || str.isEmpty()) return "";

	    StringBuilder sb = new StringBuilder();
	    boolean found = false;
	    for(char c : str.toCharArray()){
	        if(Character.isDigit(c)){
	            sb.append(c);
	            found = true;
	        } else if(found){
	            // If we already found a digit before and this char is not a digit, stop looping
	            break;                
	        }
	    }

	    return sb.toString();
	}
	
}
/*

*/