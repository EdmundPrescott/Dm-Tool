import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Player {
	//make a file with character details?
	private String Name;
	private String Race;
	private String Alignment;
	private String Class;
	
	private int Level;
	private int exp;
	private int Gold;
	
	private int playerX;
	private int playerY;
	
	private int initiativeModifier;//dependent
	private int actionPoints;
	private int Speed;
	
	//String[][][] board=new String[][][];
	private String[][] Data = null;
	private String[][] Stats = {{"Strength","0"},{"Constitution","0"},{"Dexterity","0"},
								{"Intelligence","0"},{"Wisdom","0"},{"Charisma","0"}};
	
	private ArrayList<Item> Items = new ArrayList<Item>();
	private ArrayList<Trait> Traits = new ArrayList<Trait>();
	private ArrayList<Status> Statuses = new ArrayList<Status>();
	
	//private Input correct = new Input();
	private Reader Reader = new Reader();
	
	public Player(int a,int b) throws FileNotFoundException{
		playerX=a;
		playerY=b;
		initializePlayer();
	}
	
	public void initializePlayer() throws FileNotFoundException{
		setName();
		setRace();
		
		System.out.println("Do you want to skip setting stats?");
		if(Input.correctFor("B","?",false).equals("false")){
			setStats(0);
		}
		
		printStats();
	}
	
	public String getPlayerName(){
		return Name;
	}
	
	public int getPlayerX(){
		return playerX;
	}
	
	public int getPlayerY(){
		return playerY;
	}
	
	public void move(String x){
		if(x.equalsIgnoreCase("north")||x.equalsIgnoreCase("n")){
			playerY--;
		}
		
		if(x.equalsIgnoreCase("south")||x.equalsIgnoreCase("s")){
			playerY++;
		}
		
		if(x.equalsIgnoreCase("west")||x.equalsIgnoreCase("w")){
			playerX--;
		}
		
		if(x.equalsIgnoreCase("east")||x.equalsIgnoreCase("e")){
			playerX++;
		}
	}
	
	public void setStats(int zero){
		int count=zero;
		System.out.println("What would you like to set "+Name+"'s "+Stats[count][0]+" to be?");
		Stats[count][1]=Input.correctFor(0,20,"?",false);
		System.out.println("Are you sure you want "+Name+"'s "+Stats[count][0]+" to be "+Stats[count][1]+"?");
		if(Input.correctFor("B","?",false).equals("true")){
			if((count+1)<Stats.length){setStats(count+1);}
		}else{setStats(count);}
	}
	
	public void setName(){
		System.out.println("What is the player's name?");
		Name=Input.correctFor("@","Please enter a name",false);
		System.out.println("Are you sure you want "+Name+" to be the players name?");
		if(Input.correctFor("B","?",false).equals("false")){
			setName();
		}
		
	}
	
	public void setRace(){
		System.out.println("What is "+Name+"'s race");
		Race=Input.correctFor("R","?",false);
		System.out.println("Are you sure you want "+Race+" to be the players race?");
		if(Input.correctFor("B","?",false).equals("false")){
			setRace();
		}
		
	}
	
	@SuppressWarnings("null")
	public int getStat(String statName){
		for(int i=0;i<Stats.length;i++){
			if(Stats[i][0].equalsIgnoreCase(statName)){
				return Integer.parseInt(Stats[i][0]);
			}
		}
		return (Integer)null;
	}
	
	public int getSpeed(){
		return Speed;
	}
	
	public void printStats(){
		for(int i=0;i<Stats.length;i++){
			System.out.println(Stats[i][0]+" : "+Stats[i][1]);
		}
		for(int i=0;i<Traits.size();i++){
			System.out.println(Traits.get(i).getTraitName()+": ");
			System.out.println("    "+Traits.get(i).getTraitEffect());
		}
	}
	
	public void printSixStats(){
		for(int i=0;i<Stats.length;i++){
			System.out.println(Stats[i][0]+" : "+Stats[i][1]);
		}
	}
	
	public void editStats(){
		
		System.out.println("Would you like to edit all stats?");
		if(Input.correctFor("B","?",false).equals("true")){
			setStats(0);
			
		}else{
			while(!Input.getCarryValue().equals("false")){
			editStats();
			System.out.println("Are you done editing single stats?");
			Input.correctFor("B","?",false);
			}
		}
	}
	
	public void editStat(){
		int chosen=0;
		System.out.println("Which stat would you like to edit?");
		printSixStats();
		chosen=Integer.parseInt(Input.correctFor(1,Stats.length,"?",false))-1;
		System.out.println("What would you like to set "+Name+"'s "+Stats[chosen][0]+" to?");
		Stats[chosen][1]=Input.correctFor(0,20,"?",false);
		System.out.println(Name+"'s "+Stats[chosen][0]+" is now "+Stats[chosen][1]);
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
