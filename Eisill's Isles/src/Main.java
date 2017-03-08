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
		ArrayList<Object> Groups = new ArrayList<Object>();
		
		//Classes
		Player Player;
		Groups.add(new Group(Groups.size()));
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
		String chosenPlayer;
		
		//initializes players
		System.out.println("How many players are there?");	
		totalPlayers=Integer.parseInt(InputCorrecting.correctFor(1,8,"Please enter a number between 1 and 8",false));
		System.out.println("There are "+totalPlayers+" players awesome!");	
		System.out.println("What are their names?");
		for(int i=0;i<totalPlayers;i++){
			userInput=console.next();
			System.out.println("Player "+userInput+" was entered");
			((Group) Groups.get(0)).addPlayer(new Player(userInput,spawnX,spawnY));
		}
		 ((Group) Groups.get(0)).printGroup();
		
		//Starts game and prints the commands
		System.out.println("-----Game Start!-----");
		playerCommands();
		
		//Game loop
		while(Endgame==false){
		
		if(userInput.equalsIgnoreCase("playerCommands")||userInput.equalsIgnoreCase("pc")){
			playerCommands();
		}	
			
		if(userInput.equalsIgnoreCase("playerNames")||userInput.equalsIgnoreCase("pn")){
			printPlayerNames(Groups);
		}
		
		if(userInput.equalsIgnoreCase("playerLocations")||userInput.equalsIgnoreCase("pl")){
			printPlayerLocations(Groups);
		}
			
		if(userInput.equalsIgnoreCase("printGroups")||userInput.equalsIgnoreCase("pg")){
			printGroups(Groups);
		}
		
		if(userInput.equalsIgnoreCase("printExamineAbles")||userInput.equalsIgnoreCase("pex")){
			InputCorrecting.printExamineAbles();
		}
		
		if(userInput.equalsIgnoreCase("moveAll")||userInput.equalsIgnoreCase("ma")){
			moveAllPlayers(Groups, chosenGroup);
		}
		
		if(userInput.equals("test")||userInput.equals("tt")){
			//Group.addGroup();
		}
		
		if(userInput.equalsIgnoreCase("cleangroups")||userInput.equalsIgnoreCase("cg")){
			
		}
		
		/*
		if(userInput.equalsIgnoreCase("splitGroup")||userInput.equalsIgnoreCase("sG")){
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
				
				if(userInput.equalsIgnoreCase("cancel")){
					badValue=false;
				}
				
				} catch (NumberFormatException nfe) {
					System.out.println("Please type a number");
					userInput=console.next();  
					}
				}
				badValue=true;
				
				if(!userInput.equalsIgnoreCase("cancel")){
					
				
				
				//Group.addGroup();//if number of groups == 1, if there are more than 1 groups ask the user if they
				//they would like to make a new group to put these players in
				if(Group.NumberOfGroups()<=1){
					Group.addGroup();
				}else{
					System.out.println("Would you like to move these players to a existing group?");
					
					System.out.println("Would you like to make a new group?");
					
					System.out.println("Would you like to stop trying to make a new group?");
				}
				
				if(!userInput.equalsIgnoreCase("cancel")){
				
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
				
				if(userInput.equalsIgnoreCase("cancel")){
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
		*/
		
		/*
		System.out.println("Which group will be splitting?");
			Group.printGroups();
			InputCorrecting.correctFor(1, Group.NumberOfGroups(),"?",true);
			if(!InputCorrecting.getCarryValue().equals("cancel")){
			chosenGroup=Integer.parseInt(InputCorrecting.getCarryValue())-1;
			
			if(Group.NumberOfGroups()<=1){
				System.out.println("Create a new group for these players to move to?\n"
						+ "Warning: You have to few groups and if you do not make a new group the group splitting will be cancelled");
				if(InputCorrecting.correctFor("B","?",true).equals("true")){
					Group.addGroup();
				}
			}
			if(!InputCorrecting.getCarryValue().equals("false")){
			System.out.println("Who will be leaving the group?");
			
				Group.printGroupNumbered(chosenGroup);
				InputCorrecting.correctFor(1,Group.groupSize(chosenGroup)-1,"?",false);
				chosenPlayer=Group.groupPlayerAccess(chosenGroup,Integer.parseInt(InputCorrecting.getCarryValue()));
				System.out.println("Which group will they move too?");
				Group.printGroups();
				InputCorrecting.correctFor(1, Group.NumberOfGroups(),"?",false);
				if(Integer.parseInt(InputCorrecting.getCarryValue())-1==chosenGroup){
					System.out.println("That's the group "+chosenPlayer+" is currently in, "
							+ "are you sure you want to move "+chosenPlayer+" to that group?");
					InputCorrecting.correctFor("B","?",false);
				}
				
				
			}
			}
		*/
		/*
		if(userInput.equalsIgnoreCase("splitGroup")||userInput.equalsIgnoreCase("sG")){//
			for(int i=0;i<1;i++){
			System.out.println("Which group will be splitting?");
			Group.printGroups();
			InputCorrecting.correctFor(1, Group.NumberOfGroups(),"?",true);
			if(InputCorrecting.getCarryValue().equals("cancel")){break;}
			chosenGroup=Integer.parseInt(InputCorrecting.getCarryValue())-1;
			if(Group.NumberOfGroups()<=1){
				System.out.println("Create a new group for these players to move to?\n"
						+ "Warning: You have to few groups and if you do not make a new group the group splitting will be cancelled");
				if(InputCorrecting.correctFor("B","?",true).equals("true")){
					Group.addGroup();
				}
			}
			if(InputCorrecting.getCarryValue().equals("cancel")){break;}
			System.out.println("Who will be leaving the group?");
			
				Group.printGroupNumbered(chosenGroup);
				InputCorrecting.correctFor(1,Group.groupSize(chosenGroup)-1,"?",true);
				if(InputCorrecting.getCarryValue().equals("cancel")){break;}
				chosenPlayer=Group.groupPlayerAccess(chosenGroup,Integer.parseInt(InputCorrecting.getCarryValue()));
				System.out.println("Which group will they move too?");
				Group.printGroups();
				InputCorrecting.correctFor(1, Group.NumberOfGroups(),"?",true);
				if(InputCorrecting.getCarryValue().equals("cancel")){break;}
				if(Integer.parseInt(InputCorrecting.getCarryValue())-1==chosenGroup){
					System.out.println("That's the group "+chosenPlayer+" is currently in, "
							+ "are you sure you want to move "+chosenPlayer+" to that group?");
					InputCorrecting.correctFor("B","?",false);
					if(InputCorrecting.getCarryValue().equals("cancel")){break;}
				}
				
				
			
			}
		}//end of function
		
		if(userInput.equalsIgnoreCase("aG")||userInput.equalsIgnoreCase("addGroup")){
			Group.addGroup();
		}
		*/
		
		if(userInput.equalsIgnoreCase("moveall")||userInput.equalsIgnoreCase("ma")){
		
		}
		
		
		
		if(userInput.equals("testPrint")){
			Reader(file);
		}
		
		if(userInput.equalsIgnoreCase("examine")||userInput.equalsIgnoreCase("ex")){
				System.out.println("What do you want to examine?");
				if(!InputCorrecting.correctFor("E","?",true).equals("cancel")){
				startIndex=entireFileText.indexOf(InputCorrecting.getCarryValue()+":");
				endIndex=entireFileText.substring(startIndex).indexOf("\\")+startIndex;
				System.out.println(entireFileText.substring(startIndex,endIndex));
				}
		}
		
		
		
		
		
		if(userInput.equalsIgnoreCase("quit")){
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
				+ "1.playerCommands (pc)\n"//[x]
				+ "2.playerNames (pn)\n"//[x]
				+ "3.playerLocations (pl)\n"
				+ "4.printGroup (pg)\n"//[x]
				+ "5.moveAll (ma)\n"//[x]
				+ "6.examine (ex)\n"//[x]
				+ "7.printExamineAbles (pex)\n"//[x]
				+ "8.splitGroup (sg)\n"//[]
				);
	}
	
	public static void printPlayerLocations(ArrayList Groups){
		for(int i=0;i<Groups.size();i++){
			for(int j=0;j<((Group) Groups.get(i)).groupSize();j++){
			System.out.print("X: "+((Group) Groups.get(i)).getPlayer(j).getPlayerX());
			System.out.print(" ");
			System.out.print("Y: "+((Group) Groups.get(i)).getPlayer(j).getPlayerY());
			System.out.println(" - "+((Group) Groups.get(i)).getPlayer(j).getPlayerName());
			}
		}
		System.out.println();
	}
	
	public static void printGroups(ArrayList Groups){
		for(int i=0;i<Groups.size();i++){
			System.out.println("Group "+(i+1));
			((Group) Groups.get(i)).printGroup();
		}
	}
	
	public static void Reader(File file) throws FileNotFoundException{
		String entireFileText = new Scanner(file).useDelimiter("\\A").next();
		System.out.println(entireFileText);
	}
	
	public static void printPlayerNames(ArrayList Groups){
		for(int i=0;i<Groups.size();i++){
			((Group) Groups.get(i)).printGroup();
		}
	}
	
	public static void moveAllPlayers(ArrayList Groups,int chosenGroup){
		for(int i=0;i<1;i++){	
			if(Groups.size()>1){
			System.out.println("What group would you like to move?");
			InputCorrecting.correctFor(0,Groups.size(),"?",true);
			if(InputCorrecting.getCarryValue().equals("cancel")){
				break;
			}else{
				chosenGroup=Integer.parseInt(InputCorrecting.getCarryValue());
			}
			}
			System.out.println("Where would you like to move?\n"
					+ "north(n)\n"
					+ "west(w)\n"
					+ "east(e)\n"
					+ "south(s)\n");
			
			if(!InputCorrecting.correctFor("^","?",true).equals("cancel")){
				if(!InputCorrecting.getCarryValue().equals("cancel")){
					break;
				}
			((Player) Groups.get(chosenGroup)).moveAll(InputCorrecting.getCarryValue());
			
			printPlayerLocations(Groups);
			}
			
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