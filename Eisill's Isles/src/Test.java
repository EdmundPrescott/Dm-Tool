import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		a.addAll(new ArrayList<String>());
		
		
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