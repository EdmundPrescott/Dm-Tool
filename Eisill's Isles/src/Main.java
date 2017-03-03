import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Files
		File file = new File("DnDMap.txt");
		String entireFileText = new Scanner(file).useDelimiter("\\A").next();
		
		//Array lists
		String[][] board=new String[64][64];
		ArrayList<String> ExamineAbles = new ArrayList<String>();
		ArrayList<Object> players = new ArrayList<Object>();
		
		//Classes
		Player Player;
		Group Group = new Group();
		InputCorrecting InputCorrecting = new InputCorrecting();
		
		//Booleans
		boolean Endgame=false;
		boolean badValue=true;
		
		//Integers
		int startIndex;
		int endIndex;
		int totalPlayers=0;
		int count = 0;
		int placeHolder;
		int maxPlayers=8;
		int minPlayers=1;
		int spawnX=0;
		int spawnY=0;
		int chosenGroup=0;
		
		//Strings
		Scanner console = new Scanner(System.in);
		String userInput="";
		//userInput=console.next();
		
		//Initializations
		//ExamineAbles.add("");
		ExamineAbles.add("Shop");
		ExamineAbles.add("Meadow");
		
		//initializes players
		System.out.println("How many players are there?");	
		totalPlayers=Integer.parseInt(InputCorrecting.correctFor(1,8,"Please enter a number between 1 and 8",false));
		
		
		System.out.println("There are "+totalPlayers+" players awesome!");	
		
		System.out.println("What are their names?");
		for(int i=0;i<totalPlayers;i++){
			userInput=console.next();
			System.out.println("Player "+userInput+" was entered");
			players.add(new Player(userInput,spawnX,spawnY));
		}
		
		//initializes main group
		for(int i=0;i<totalPlayers;i++){
			Group.addToGroup(((Player) players.get(i)).getPlayerName(),0);
		}
		Group.printGroups();
		
		
		
		
				
		//Starts game and prints the commands
		System.out.println("-----Game Start!-----");
		playerCommands();
		//Game loop
		while(Endgame==false){
		
		if(userInput.equals("playerNames")||userInput.equals("pN")){
			playerNames(players,totalPlayers);
		}
		
		if(userInput.equals("playerLocations")||userInput.equals("pL")){
			playerLocations(players,totalPlayers);
		}
			
		if(userInput.equals("playerCommands")||userInput.equals("pC")){
			playerCommands();
		}
		
		if(userInput.equals("printGroups")||userInput.equals("pG")){
			Group.printGroups();
		}
		
		if(userInput.equals("test")||userInput.equals("tt")){
			Group.addGroup();
		}
		
		if(userInput.equals("splitGroup")||userInput.equals("sG")){
			System.out.println("Which group will be spliting?");
			Group.printGroups();
			userInput=console.next();
			while(badValue==true){
				try{
				if(Integer.parseInt(userInput)<=Group.NumberOfGroups()&&Integer.parseInt(userInput)>0){	
				chosenGroup=Integer.parseInt(userInput)-1;
				badValue=false;
				}else{
					System.out.println("There is no group "+Integer.parseInt(userInput));
					userInput=console.next();
				}
				
				if(userInput.equals("cancel")){
					badValue=false;
				}
				
				} catch (NumberFormatException nfe) {
					System.out.println("Please type a number");
					userInput=console.next();  
					}
				}
				badValue=true;
				
				if(!userInput.equals("cancel")){
					
				
				
				//Group.addGroup();//if number of groups == 1, if there are more than 1 groups ask the user if they
				//they would like to make a new group to put these players in
				if(Group.NumberOfGroups()<=1){
					Group.addGroup();
				}else{
					System.out.println("Would you like to move these players to a existing group?");
					
					System.out.println("Would you like to make a new group?");
					
					System.out.println("Would you like to stop trying to make a new group?");
				}
				
				if(!userInput.equals("cancel")){
				
			System.out.println("Who will be forming a new group?");
			
			Group.printGroupNumbered(Integer.parseInt(userInput)-1);
			while(badValue==true){/////
				userInput=console.next();
				
			try{
				
				if(Group.groupContains(userInput, chosenGroup)==true){
					System.out.println(userInput+" will split from the group\n"
							+ "Would you like to split more players?");
					System.out.println("name success");
					//badValue=false;
				}else
				
				if(Integer.parseInt(userInput)>0&&Integer.parseInt(userInput)<=Group.groupSize(chosenGroup)){
					System.out.println(Group.groupPlayerAccess(chosenGroup, Integer.parseInt(userInput))+" will split from the group\n"
							+ "Would you like to split more players?");
					System.out.println("number success");
				}else if(!userInput.equals("cancel")){}
				
				if(userInput.equals("cancel")){
					badValue=false;
				}
				
				//if(userInput.equals("yes")||userInput.equals("y")){badValue=false;}
				
			} catch (NumberFormatException nfe) {
				//Nothings supposed to be here by the by
				
			}
				
			
			}/////while loop
			badValue=true;
			
				}//Cancel quit
				}//Cancel quit
			
		}//end of function
		
		if(userInput.equals("aG")){
			Group.addGroup();
		}
		
		if(userInput.equals("moveAll")||userInput.equals("mA")){
		System.out.println("Where would you like to move?\n"
				+ "north(n)\n"
				+ "west(w)\n"
				+ "east(e)\n"
				+ "south(s)\n");
		
		if(!InputCorrecting.correctFor("^","?",true).equals("cancel")){
		for(int i=0;i<totalPlayers;i++){
		((Player) players.get(i)).moveAll(InputCorrecting.getCarryValue());
		}
		playerLocations(players,totalPlayers);
		}
		}
		
		
		if(userInput.equals("testPrint")){
			Reader(file);
		}
		
		
		
		if(userInput.equals("examine")||userInput.equals("Examine")||userInput.equals("ex")||userInput.equals("EX")){
			while(badValue==true){
			System.out.println("What do you want to examine?");
			userInput=console.next();
			if(ExamineAbles.contains(userInput)){
				startIndex=entireFileText.indexOf(userInput+":");
				endIndex=entireFileText.substring(startIndex).indexOf("\\")+startIndex;
				//System.out.println("Start index: "+startIndex+" End index: "+endIndex);
				System.out.println(entireFileText.substring(startIndex,endIndex));
			}else{
				System.out.println("You tried examining "+userInput+" but that can't be examined or does not exist");
			}
				System.out.println("Would you like to continue examining?");
				if(InputCorrecting.correctFor("B","?",false).equals("false")){
					badValue=false;
				}
			}
			badValue=true;
		}
		
		if(userInput.equals("examine")||userInput.equals("Examine")||userInput.equals("ex")||userInput.equals("EX")){
			Examine(userInput,entireFileText,console,ExamineAbles);
		}
		
		
		
		if(userInput.equals("quit")){
			Endgame=true;
		}
		
		if(Endgame!=true){
		userInput=console.next();
		}
		}//end of game loop
		
	}

	
	
	public static void populateBoard(){
		
	}
	
	public static void playerCommands(){
		System.out.println("-----Command List-----\n"
				+ "1.playerCommands (pC)\n"
				+ "2.playerNames (pN)\n"
				+ "3.playerLocations (pL)\n"
				+ "4.moveAll (mA)\n"
				+ "5.examine (ex)\n"
				+ "6.splitGroup (sG)\n");
	}
	
	public static void playerLocations(ArrayList players,int x){
		System.out.println("The player's locations are");
		for(int i=0;i<x;i++){
		System.out.println(((Player) players.get(i)).getPlayerName()
				+ " X:"+((Player) players.get(i)).getPlayerX()+" Y:"+((Player) players.get(i)).getPlayerY());
		}
	}
	
	
	
	public static void Reader(File file) throws FileNotFoundException{
		String entireFileText = new Scanner(file).useDelimiter("\\A").next();
		System.out.println(entireFileText);
	}
	
	public static void playerNames(ArrayList players,int x){
		System.out.println("The player's names are");
		for(int i=0;i<x;i++){
		System.out.println(((Player) players.get(i)).getPlayerName());
		System.out.println();
		}
		}
		
		public static void Examine(String x,String entireFileText,Scanner console,ArrayList ExamineAbles){
			int startIndex;
			int endIndex;
			//System.out.println(entireFileText.substring(startIndex,endIndex));
			System.out.println("What do you want to examine?");
			x=console.next();
			if(ExamineAbles.contains(x)){
				startIndex=entireFileText.indexOf(x+":");
				endIndex=entireFileText.substring(startIndex).indexOf("\\")+startIndex;
				//System.out.println("Start index: "+startIndex+" End index: "+endIndex);
				System.out.println(entireFileText.substring(startIndex,endIndex));
			}else{
				System.out.println("You tried examining "+x+" but that can't be examined or does not exist");
				//if(InputCorrecting.correctFor("B","?",false).equals("true")){
				Examine(x,entireFileText,console,ExamineAbles);
				//}
			}
		}
	
	
	
	
}
/*
while(badValue==true){
		try{
		if(){	
		
		badValue=false;
		}else{
			
			userInput=console.next();
		}
		} catch (NumberFormatException nfe) {
			System.out.println("Please type a number");
			userInput=console.next();  
			}
		}
		badValue=true;
*/