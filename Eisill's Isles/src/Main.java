import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//Files
		File file = new File("DnDMap.txt");
		String entireFileText = new Scanner(file).useDelimiter("\\A").next();
		
		//Classes
		Player Player;
		Input Input = new Input();
		
		//Booleans
		boolean Endgame=false;
		boolean badValue=true;
		
		//Integers
		int startIndex=0;
		int endIndex=0;
		int totalPlayers=0;
		int placeHolder;
		int maxPlayers=8;
		int minPlayers=1;
		int spawnX=0;
		int spawnY=0;
		int chosenGroup=0;
		
		//Array lists
		String[][][] board=new String[64][64][3];
		ArrayList<Object> Groups = new ArrayList<Object>();
		Groups.add(new Group((Groups.size())));
		
		//Strings
		Scanner console = new Scanner(System.in);
		String userInput="";
		Player chosenPlayer = null;
		ArrayList<Player> chosenPlayers = new ArrayList<Player>();
		
		//initializes players
		System.out.println("How many players are there?");	
		totalPlayers=Integer.parseInt(Input.correctFor(minPlayers,maxPlayers,"Please enter a number between 1 and 8",false));
		System.out.println("There are "+totalPlayers+" players awesome!");	
		//System.out.println("What are their names?");
		for(int i=0;i<totalPlayers;i++){
			System.out.println("Player "+(i+1)+": ");
			((Group) Groups.get(0)).addPlayer(new Player(spawnX,spawnY));
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
			Input.printExamineAbles();
		}
		
		if(userInput.equalsIgnoreCase("moveAll")||userInput.equalsIgnoreCase("ma")){
			moveAllPlayers(Groups, chosenGroup);
		}
		
		if(userInput.equalsIgnoreCase("examine")||userInput.equalsIgnoreCase("ex")){
			examine(entireFileText,startIndex,chosenGroup);
	    }
		
		if(userInput.equalsIgnoreCase("addplayer")||userInput.equalsIgnoreCase("ap")){
			addPlayer(Groups,chosenGroup,spawnX,spawnY);
		}
		
		if(userInput.equalsIgnoreCase("splitGroup")||userInput.equalsIgnoreCase("sG")){
			cleanGroups(Groups);
			splitGroupStart(Groups,chosenGroup,chosenPlayers);
		}
		
		if(userInput.equalsIgnoreCase("aG")||userInput.equalsIgnoreCase("addGroup")){
			Groups.add(new Group((Groups.size()+1)));
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
		System.out.println(" sumo wresttler edmund, this is an easter egg");
	}
	
	public static void cleanGroups(ArrayList Groups){
		for(int i=0;i<Groups.size();i++){
			if(((Group) Groups.get(i)).groupSize()<=0){
				Groups.remove(i);
			}else{
				((Group) Groups.get(i)).setGroupNumber(i+1);
			}
		}
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
				+ "8.splitGroup (sg)\n"//[x] can edit/add more if wanted
				+ "9.addPlayer (ap)\n"//[]
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
	}
	
	public static void printGroups(ArrayList Groups){
		for(int i=0;i<Groups.size();i++){
			System.out.println("Group "+((Group) Groups.get(i)).getGroupNumber());
			((Group) Groups.get(i)).printGroup();
		}
	}
	
	public static void printGroup(ArrayList Groups,int chosenGroup){
		((Group) Groups.get(chosenGroup)).printGroup();
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
	
	public static void initializePlayer(){
		
	}
	
	public static void addPlayer(ArrayList Groups,int chosenGroup,int spawnX,int spawnY) throws FileNotFoundException{
		for(int i=0;i<1;i++){
		System.out.println("Which group will the player be added to?");
		printGroups(Groups);
		Input.correctFor(1, Groups.size(),"?",true);
		if(Input.getCarryValue().equals("cancel")){break;}
		chosenGroup=Integer.parseInt(Input.getCarryValue());
		System.out.println("The player will be added to group "+chosenGroup+" what is the players name?");
		Input.correctFor("@","Please enter a name",true);
		if(Input.getCarryValue().equals("cancel")){break;}
		((Group) Groups.get(chosenGroup-1)).addPlayer(new Player(spawnX,spawnY));
		printGroups(Groups);
		}
	}
	
	public static void moveAllPlayers(ArrayList Groups,int chosenGroup){
		for(int i=0;i<1;i++){	
			
			if(Groups.size()>1){
			System.out.println("What group would you like to move?");
			printGroups(Groups);
			Input.correctFor(0,Groups.size(),"?",true);
			if(Input.getCarryValue().equals("cancel")){
				break;
			}else{
				chosenGroup=Integer.parseInt(Input.getCarryValue())-1;
			}
			}
			
			System.out.println("Where would you like to move?\n"
					+ "north(n)\n"
					+ "west(w)\n"
					+ "east(e)\n"
					+ "south(s)\n");
			
			if(!Input.correctFor("^","?",true).equals("cancel")){
			((Group) Groups.get(chosenGroup)).moveAll(Input.getCarryValue());
			printPlayerLocations(Groups);
			}
			
			}
	}
		
	public static void examine(String entireFileText,int startIndex,int endIndex){
		System.out.println("What do you want to examine?");
		if(!Input.correctFor("E","?",true).equals("cancel")){
		startIndex=entireFileText.indexOf(Input.getCarryValue()+":");
		endIndex=entireFileText.substring(startIndex).indexOf("\\")+startIndex;
		System.out.println(entireFileText.substring(startIndex,endIndex));
		}
	}
	
	public static void splitGroupStart(ArrayList Groups,int chosenGroup,ArrayList chosenPlayers){
		for(int i=0;i<1;i++){
			System.out.println("Which group will be splitting?");
			printGroups(Groups);
			Input.correctFor(1, Groups.size(),"?",true);
			if(Input.getCarryValue().equals("cancel")){break;}
			chosenGroup=Integer.parseInt(Input.getCarryValue())-1;
			
			
			if(Groups.size()<=1){
				System.out.println("Create a new group for these players to move to?\n"
						+ "Warning: You have to few groups and if you do not make a new group the group splitting will be cancelled");
				if(Input.correctFor("B","?",true).equals("true")){
					Groups.add(new Group(Groups.size()));
				}else{
					if(!Input.getCarryValue().equals("cancel")){
					System.out.println("There is no group to split to so the groups will not split");
					}
					break;
				}
			}else{
				System.out.println("Would you like to create a new group?");
				Input.correctFor("B","?",true);
				if(Input.getCarryValue().equals("cancel")){break;}
				if(Input.getCarryValue().equals("true")){
					Groups.add(new Group(Groups.size()));
				}
			}
			
			if(Input.getCarryValue().equals("cancel")){break;}
			System.out.println("Who will be leaving the group?");
				Input.clearCarryValue();
				while(!Input.getCarryValue().equals("false")){
				((Group) Groups.get(chosenGroup)).printNumberedGroup();
				Input.correctFor(1,((Group) Groups.get(chosenGroup)).groupSize(),"?",true);
				if(Input.getCarryValue().equals("cancel")){break;}
				chosenPlayers.add(((Group) Groups.get(chosenGroup)).getPlayer(Integer.parseInt(Input.getCarryValue())-1));
				System.out.println("Want to continue splitting groups?");
				Input.correctFor("B","?",true);
				}
				
				splitGroupEnd(Groups,chosenGroup,chosenPlayers);
		}
	}
		
	public static void splitGroupEnd(ArrayList Groups,int chosenGroup,ArrayList chosenPlayers){
		for(int i=0;i<1;i++){
			System.out.print("Which group will");
			for(int j=0;j<chosenPlayers.size();j++){
			System.out.print(" "+((Player) chosenPlayers.get(j)).getPlayerName());
			}
			System.out.println(" will move too?");
			printGroups(Groups);
			Input.correctFor(1, Groups.size(),"?",true);
			if(Input.getCarryValue().equals("cancel")){break;}
			if(Integer.parseInt(Input.getCarryValue())-1==chosenGroup){
				System.out.print("That's the group");
				for(int j=0;j<chosenPlayers.size();j++){
				System.out.print(" "+((Player) chosenPlayers.get(j)).getPlayerName());
				}
				System.out.println(" are currently in that group are you sure you want to move them to that group?");
				Input.correctFor("B","?",true);
				if(Input.getCarryValue().equals("cancel")){break;}
				if(Input.getCarryValue().equals("true")){System.out.println("The groups were not changed");break;}else{
					splitGroupEnd(Groups,chosenGroup,chosenPlayers);
		}
		}//Chosen Group picked bracket 
			((Group) Groups.get(Integer.parseInt(Input.getCarryValue())-1)).addPlayers(chosenPlayers);
			((Group) Groups.get(chosenGroup)).removePlayers(chosenPlayers);
			cleanGroups(Groups);
			printGroups(Groups);
		}//Loop bracket
	}//Method bracket
}