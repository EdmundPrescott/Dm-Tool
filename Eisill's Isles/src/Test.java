import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputCorrecting InputCorrecting = new InputCorrecting();
		Scanner console = new Scanner(System.in);
		String userInput="";
		boolean stop=true;
		
		while(stop==false){	
		System.out.println("Please enter yes or no");
		System.out.println(InputCorrecting.correctFor("B","Asshole enter fucking yes or no",true));
		System.out.println("Please enter a number");
		System.out.println(InputCorrecting.correctFor("#","Nice try",false));
		System.out.println("Please enter a string");
		System.out.println(InputCorrecting.correctFor("@",":(",false));
		System.out.println("Please enter a number between 3 and 16");
		System.out.println(InputCorrecting.correctFor(3, 16,"You can't have that many characters, you can have between 3 and 16 players",true));
		System.out.println("Please enter a direction");
		System.out.println(InputCorrecting.correctFor("^","?",false));
	    }
		
		for(int i=0;i<1;i++){
			System.out.println(i);
		}
			
			
		
	}

}
/*
 
System.out.println("Want to load a map?");
while(badValue==true){
			try{
			if(userInput.equals("Yes")||userInput.equals("yes")||userInput.equals("Y")||userInput.equals("y")){
			//Load a map
				System.out.println("Map loaded!");
			badValue=false;
			}else if(userInput.equals("No")||userInput.equals("no")||userInput.equals("N")||userInput.equals("n")){
				System.out.println("No map loaded");
			badValue=false;	
			}else{
				System.out.println("Please type yes or no");
			}
			
			if(badValue==true){
			userInput=console.next();
			}
			
			} catch (NumberFormatException nfe) {
				System.out.println("Please type yes or no");
				userInput=console.next();  
				}
			}
		badValue=true;
		------------------------
		public static void Scope(){
		for(int z=1;z<=64;z++){
			if(z<11&&z>1){
			System.out.print("  ");
			}else{
				System.out.print(" ");
			}
			System.out.print(z);
		    }
		
		for(int i=0;i<64;i++){
			System.out.println();
			for(int j=1;j<=64;j++){
				if(j==1){
					System.out.print(" ");
				}else{
					System.out.print("  ");
				}
				System.out.print("X");
			}
		    }
	}
	------------------------
		
*/