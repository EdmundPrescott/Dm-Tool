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
		userInput=console.next();
		while(badValue==true){
		try{
		if(Integer.parseInt(userInput)<=8&&Integer.parseInt(userInput)>=minPlayers){	
		totalPlayers=Integer.parseInt(userInput);
		badValue=false;
		}else{
			System.out.println("You can't have that many players, the max amount of players is "+maxPlayers+" and the min is "+minPlayers);
			userInput=console.next();
		}
		} catch (NumberFormatException nfe) {
			System.out.println("Please type a number");
			userInput=console.next();  
			}
		}
		badValue=true;
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
				if(Integer.parseInt(userInput)<=Group.getNumberOfGroups()&&Integer.parseInt(userInput)>0){	
				chosenGroup=Integer.parseInt(userInput);
				badValue=false;
				}else{
					System.out.println("There is no group "+Integer.parseInt(userInput));
					userInput=console.next();
				}
				} catch (NumberFormatException nfe) {
					System.out.println("Please type a number");
					userInput=console.next();  
					}
				}
				badValue=true;
			System.out.println("Who will be forming a new group?");
			Group.addGroup();
			Group.printGroup(Integer.parseInt(userInput)-1);
			while(badValue==true){/////
				userInput=console.next();
				
			try{
				
				if(Group.groupContains(userInput, chosenGroup-1)==true){
					System.out.println(userInput+" will split from the group\n"
							+ "Would you like to split more players?");
					//badValue=false;
				}else{
					System.out.println("Bad input");
				}
				
			} catch (NumberFormatException nfe) {
				System.out.println("Bad input");
				
				
			}
				
			}/////
			
		}
		
		if(userInput.equals("moveAll")||userInput.equals("mA")){
		System.out.println("Where would you like to move? (invalid inputs will do nothing\n"
				+ "north(n)\n"
				+ "west(w)\n"
				+ "east(e)\n"
				+ "south(s)\n");
		userInput=console.next();
		for(int i=0;i<totalPlayers;i++){
		((Player) players.get(i)).moveAll(userInput);
		}
		playerLocations(players,totalPlayers);
		}
		
		
		if(userInput.equals("testPrint")){
			Reader(file);
		}
		
		
		
		if(userInput.equals("examine")||userInput.equals("Examine")||userInput.equals("ex")||userInput.equals("EX")){
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