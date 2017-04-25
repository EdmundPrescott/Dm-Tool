import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		 
		int four=4;
		//redesign redesign = new redesign();
		Reader Reader=new Reader();
		
		ArrayList<String> Inputs = new ArrayList<String>() {{
		    add("@");//0
		    add("#");//1
		    add("B");//2
		    add("R");//3
		    add("E");//4
		    add("^");//5
		}};
		
		int selector=0;
		boolean cycle=true;
		boolean testing=true;
		while(testing==true){
			redesign.correctFor(Inputs.get(selector),"?","?",false,true);
			System.out.println("Output: "+redesign.CarryValue());
			if(cycle==true){
			selector++;
			if(selector>5){selector=0;}
			}
		}
		
		
		
		
		/*
		String[][] board=new String[16][16];
		
		board[0][14]="Old House";
    	board[0][12]="Stubby Goblin";
    	board[0][10]="Wall";
    	board[0][9]="Pixy";
    	board[0][7]="Potion";
    	board[0][6]="Wall";
    	board[0][5]="Orc";
    	board[0][3]="Wall";
    	board[0][1]="Wall";
    	board[0][0]="Badge of Quickness";
    	board[1][15]="Wall";
    	board[1][14]="Wall";
    	board[1][13]="Wall";
    	board[1][10]="Wall";
    	board[1][8]="Wall";
    	board[1][4]="Wall";
    	board[1][2]="Orc";
    	board[1][1]="Wall";
    	board[1][0]="Bob the Obese Orc King";
    	board[2][15]="Potion";
    	board[2][14]="Salty Toad";
    	board[2][12]="Tree";
    	board[2][11]="Stubby Goblin";
    	board[2][10]="Wall";
    	board[2][8]="Wall";
    	board[2][7]="Pixy";
    	board[2][6]="Wall";
    	board[2][3]="Orc";
    	board[2][2]="Wall";
    	board[3][0]="Wall";
    	board[3][1]="Orc";
    	board[3][4]="Wall";
    	board[3][5]="Orc";
    	board[3][6]="Wall";
    	board[3][8]="Wall";
    	board[3][9]="Pixy";
    	board[3][10]="Wall";
    	board[3][12]="Potion";
    	board[3][13]="Wall";
    	board[3][14]="Watering Hole";
    	board[3][15]="Salty Toad";
    	board[4][0]="Wall";
    	board[4][1]="Wall";
    	board[4][2]="Wall";
    	board[4][3]="Wall";
    	board[4][4]="Wall";
    	board[4][5]="Wall";
    	board[4][6]="Wall";
    	board[4][7]="Pixy";
    	board[4][8]="Wall";
    	board[4][9]="Potion";
    	board[4][11]="Wall";
    	board[4][12]="Wall";
    	board[4][13]="Satanic Ritual Site";
    	board[4][14]="Wall";
    	board[5][0]="Boar";
    	board[5][5]="Boar";
    	board[5][9]="Wall";
    	board[5][10]="Salty Toad";
    	board[5][11]="Shrub";
    	board[5][13]="Potion";
    	board[5][14]="Salty Toad";
    	board[6][3]="Boar";
    	board[6][7]="Wall";
    	board[6][10]="Wall";
    	board[6][11]="Wall";
    	board[6][12]="Wall";
    	board[6][13]="Wall";
    	board[6][14]="Wall";
    	board[6][15]="Wall";
    	board[7][3]="Abandoned Cart";
    	board[7][6]="Boar";
    	board[7][7]="Wall";
    	board[7][8]="Wall";
    	board[7][12]="Wall";
    	board[8][2]="Boar";
    	board[8][7]="Wall";
    	board[8][8]="Shop";
    	board[8][9]="Wall";
    	board[8][10]="Wall";
    	board[8][12]="Wall";
    	board[8][13]="Spirit";
    	board[8][14]="Wall";
    	board[9][6]="Boar";
    	board[9][7]="Wall";
    	board[9][9]="Dirty Altar";
    	board[9][10]="Wall";
    	board[9][14]="Wall";
    	board[10][0]="Wall";
    	board[10][1]="Wall";
    	board[10][2]="Wall";
    	board[10][3]="Wall";
    	board[10][4]="Wall";
    	board[10][5]="Wall";
    	board[10][7]="Slimy Slime";
    	board[10][10]="Slimy Slime";
    	board[10][11]="Wall";
    	board[10][12]="Wall";
    	board[10][13]="Wall";
    	board[10][14]="Wall";
    	board[10][15]="Dark Castle";
    	board[11][1]="Rock";
    	board[11][3]="Kobold";
    	board[11][5]="Shrub";
    	board[11][6]="Wall";
    	board[11][7]="Wall";
    	board[11][8]="Wall";
    	board[11][9]="Wall";
    	board[11][12]="Wall";
    	board[11][13]="Spooky Skeleton";
    	board[11][14]="Spooky Skeleton";
    	board[12][0]="Rock";
    	board[12][2]="Wall";
    	board[12][6]="Slime";
    	board[12][9]="Wall";
    	board[12][10]="Slimy Slime";
    	board[12][11]="Shrub";
    	board[12][12]="Wall";
    	board[12][13]="Spooky Skeleton";
    	board[12][14]="Clattery Bones";
    	board[12][15]="Spooky Skeleton";
    	board[13][0]="Rock";
    	board[13][2]="Wall";
    	board[13][4]="Abandoned Camp Site";
    	board[13][5]="Wall";
    	board[13][8]="Slime";
    	board[13][9]="Wall";
    	board[13][12]="Wall";
    	board[13][13]="Spirit";
    	board[13][14]="Spirit";
    	board[13][15]="Spirit";
    	board[14][0]="Wall";
    	board[14][1]="Rock";
    	board[14][2]="Wall";
    	board[14][3]="Shrub";
    	board[14][5]="Wall";
    	board[14][7]="Shrub";
    	board[14][9]="Wall";
    	board[14][11]="Slimy Slime";
    	board[14][12]="Wall";
    	board[14][13]="Wall";
    	board[14][14]="Wall";
    	board[11][15]="Courtyard of Fear";
    	board[15][1]="Dragon";
    	board[15][2]="Wall";
    	board[15][4]="Shrub";
    	board[15][5]="Wall";
    	board[15][7]="Slime";
    	board[15][9]="Slime";
    	board[15][12]="Wall";
    	board[15][0]="Badge of Courage";
    	board[15][13]="way out of the maze! You win!";
    	board[15][15]="Revenant"; 
		
		for(int i=0;i<=15;i++){
			for(int j=0;j<=15;j++){
				if(board[j][i]!=null){
				System.out.print(board[j][i].substring(0,3));
				}else{
					System.out.print("   ");
					}
				}
			System.out.println();
			}
		*/
    	
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
		/*
		String[][] Data = null;
		Data=Reader.readRaces("Elf");
		for(int i=0;i<Data[0].length;i++){
			if(Data[0][i].equals("Stats")){
					//Sysstem.out.println((j+1)+": "+Data[1][i].indexOf("");)
					System.out.println("Looking for Strength and found it at "+Data[1][i].indexOf("Strength"));
					System.out.println("Looking for Constitution and found it at "+Data[1][i].indexOf("Constitution"));
					System.out.println("Looking for Dexterity and found it at "+Data[1][i].indexOf("Dexterity"));
					System.out.println("Looking for Intelligence and found it at "+Data[1][i].indexOf("Intelligence"));
					System.out.println("Looking for Wisdom and found it at "+Data[1][i].indexOf("Wisdom"));
					System.out.println("Looking for Charisma and found it at "+Data[1][i].indexOf("Charisma"));
					System.out.println("Looking for +2 Strength and found it at "+Data[1][i].indexOf("+2 Strength"));
					System.out.println("Looking for +2 Constitution and found it at "+Data[1][i].indexOf("+2 Constitution"));
					System.out.println("Looking for +2 Dexterity and found it at "+Data[1][i].indexOf("+2 Dexterity"));
					System.out.println("Looking for +2 Intelligence and found it at "+Data[1][i].indexOf("+2 Intelligence"));
					System.out.println("Looking for +2 Wisdom and found it at "+Data[1][i].indexOf("+2 Wisdom"));
					System.out.println("Looking for +2 Charisma and found it at "+Data[1][i].indexOf("+2 Charisma"));
					System.out.println("Looking for -2 Strength and found it at "+Data[1][i].indexOf("-2 Strength"));
					System.out.println("Looking for -2 Constitution and found it at "+Data[1][i].indexOf("-2 Constitution"));
					System.out.println("Looking for -2 Dexterity and found it at "+Data[1][i].indexOf("-2 Dexterity"));
					System.out.println("Looking for -2 Intelligence and found it at "+Data[1][i].indexOf("-2 Intelligence"));
					System.out.println("Looking for -2 Wisdom and found it at "+Data[1][i].indexOf("-2 Wisdom"));
					System.out.println("Looking for -2 Charisma and found it at "+Data[1][i].indexOf("-2 Charisma"));
				
			}
			}
		*/
		
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