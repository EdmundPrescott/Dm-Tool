import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Player {
	//make a file with character details?
	private String Name;
	private String Race;
	private String Alignment;
	private String Class;
	private String Size;
	private String armorClass;//dependent
	private String savingThrows;//dependent-placeholder 
	private String attackValues;//dependent-placeholder
	
	private int Level;
	private int exp;
	private int Gold;
	private int age;
	
	
	private int playerX;
	private int playerY;
	
	private int Health;//dependent
	private int Initiative;//dependent
	private int Strength;
	private int Constitution;
	private int Dexterity;
	private int Intelligence;
	private int Wisdom;
	private int Charisma;
	
	private int initiativeModifier;//dependent
	private int spellsPerDay;
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
		//initializePlayer();
	}
	
	public void test(){
		System.out.println("Length: "+Stats.length);
		for(int i=0;i<Stats.length;i++){
			System.out.println(Stats[i][0]+" : "+Stats[i][1]);
			System.out.println("------");
		}
	}
	
	public void initializePlayer() throws FileNotFoundException{
		/*
		setName();
		setRace();
		Data=Reader.readRaces(Race);
		for(int i=0;i<Data[0].length;i++){
		if(Data[0][i].equals("Size")){Size=Data[1][i];}else
		if(Data[0][i].equals("Speed")){Speed=Integer.parseInt(extractNumber(Data[1][i]));}else
		if(Data[0][i]!="@"){Traits.add(new Trait(Data[0][i],Data[1][i]));}
		}
		System.out.println("Do you want to skip setting stats?");
		if(Input.correctFor("B","?",false).equals("false")){
		setStatss();
		}
		printStats();
		*/
		
		setStats(0);
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
	
	
	public void setStatss(){
		setStrength();
		setConstitution();
		setDexterity();
		setIntelligence();
		setWisdom();
		setCharisma();
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
	
	public void setStrength(){
		System.out.println("What is "+Name+"'s strength stat?");
		Strength=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s strength to be "+Strength+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setStrength();
		}
		
	}
	
	public void setConstitution(){
		System.out.println("What is "+Name+"'s constitution stat?");
		Constitution=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s constitution to be "+Constitution+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setConstitution();
		}
		
	}
	
	public void setDexterity(){
		System.out.println("What is "+Name+"'s dexterity stat?");
		Dexterity=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s dexterity to be "+Dexterity+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setDexterity();
		}
		
	}
	
	public void setIntelligence(){
		System.out.println("What is "+Name+"'s intelligence stat?");
		Intelligence=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s intelligence to be "+Intelligence+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setIntelligence();
		}
		
	}
	
	public void setWisdom(){
		System.out.println("What is "+Name+"'s wisdom stat?");
		Wisdom=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s wisdom to be "+Wisdom+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setWisdom();
		}
		
	}
	
	public void setCharisma(){
		System.out.println("What is "+Name+"'s charisma stat?");
		Charisma=Integer.parseInt(Input.correctFor(0,20,"Please enter a stat",false));
		System.out.println("Are you sure you want "+Name+"'s charisma to be "+Charisma+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setCharisma();
		}
		
	}
	
	public int getHealth(){
		return Health;
	}
	
	public int getStrength(){
		return Strength;
	}
	
	public int getConstitution(){
		return Constitution;
	}
	
	public int getDexterity(){
		return Dexterity;
	}
	
	public int getIntelligence(){
		return Intelligence;
	}
	
	public int getWisdom(){
		return Wisdom;
	}
	
	public int getCharisma(){
		return Charisma;
	}
	
	public int getSpeed(){
		return Speed;
	}
	
	public String getSize(){
		return Size;
	}
	
	public void printStats(){
		System.out.println("Name: "+Name);
		System.out.println("Race: "+Race);
		System.out.println("Strength: "+Strength);
		System.out.println("Constitution: "+Constitution);
		System.out.println("Dexterity: "+Dexterity);
		System.out.println("Intelligence: "+Intelligence);
		System.out.println("Wisdom: "+Wisdom);
		System.out.println("Charisma: "+Charisma);
		System.out.println("Size: "+Size);
		System.out.println("Speed: "+Speed);
		System.out.println("Traits:");
		for(int i=0;i<Traits.size();i++){
			System.out.println(Traits.get(i).getTraitName()+": ");
			System.out.println("    "+Traits.get(i).getTraitEffect());
		}
	}
	
	public void editStats(){
		System.out.println("Would you like to edit all stats?");
		Input.correctFor("B","?",false);
		
		if(Input.getCarryValue().equals("true")){
			setStatss();
			
		}
		
		if(Input.getCarryValue().equals("false")){
			System.out.println("What stat would you like to edit?");
			while(!Input.getCarryValue().equals("cancel")||!Input.getCarryValue().equals("false"))
			Input.correctFor("@","?",true);
			if(Input.getCarryValue().equalsIgnoreCase("Strength")||Input.getCarryValue().equalsIgnoreCase("Str")){
				setStrength();
			}
			if(Input.getCarryValue().equalsIgnoreCase("Constitution")||Input.getCarryValue().equalsIgnoreCase("Con")){
				setConstitution();
			}
			if(Input.getCarryValue().equalsIgnoreCase("Dexterity")||Input.getCarryValue().equalsIgnoreCase("Dex")){
				setDexterity();
			}
			if(Input.getCarryValue().equalsIgnoreCase("Intelligence")||Input.getCarryValue().equalsIgnoreCase("Int")){
				setIntelligence();
			}
			if(Input.getCarryValue().equalsIgnoreCase("Wisdom")||Input.getCarryValue().equalsIgnoreCase("Wis")){
				setWisdom();
			}
			if(Input.getCarryValue().equalsIgnoreCase("Charisma")||Input.getCarryValue().equalsIgnoreCase("Cha")){
				setCharisma();
			}
			
			
			
		}
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
