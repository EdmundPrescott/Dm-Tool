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
	
	//String[][][] board=new String[][][];
	
	private ArrayList<Item> Items = new ArrayList<Item>();
	private ArrayList<Status> Statuses = new ArrayList<Status>();
	
	private InputCorrecting correct = new InputCorrecting();
	
	public Player(String x,int a,int b){
		this.Name=x;
		this.playerX=a;
		this.playerY=b;
	}
	
	public void initializePlayer(){
		System.out.println("What is the players name?");
		correct.correctFor("@","Please enter a name",false);
		this.Name=correct.getCarryValue();
		System.out.println("What is their race?");
		//correct.correctFor("", errorCode, cancelReady)
	}
	
	public String getPlayerName(){
		return this.Name;
	}
	
	public int getPlayerX(){
		return this.playerX;
	}
	
	public int getPlayerY(){
		return this.playerY;
	}
	
	public void move(String x){
		if(x.equalsIgnoreCase("north")||x.equalsIgnoreCase("n")){
			this.playerY--;
		}
		
		if(x.equalsIgnoreCase("south")||x.equalsIgnoreCase("s")){
			this.playerY++;
		}
		
		if(x.equalsIgnoreCase("west")||x.equalsIgnoreCase("w")){
			this.playerX--;
		}
		
		if(x.equalsIgnoreCase("east")||x.equalsIgnoreCase("e")){
			this.playerX++;
		}
	}
	
	
	public void setStrength(int x){
		this.Strength=x;
	}
	
	public void setConstitution(int x){
		this.Constitution=x;
	}
	
	public void setDexterity(int x){
		this.Dexterity=x;
	}
	
	public void setIntelligence(int x){
		this.Intelligence=x;
	}
	
	public void setWisdom(int x){
		this.Wisdom=x;
	}
	
	public void setCharisma(int x){
		this.Charisma=x;
	}
	
	public int getHealth(){
		return this.Health;
	}
	
	public int getStrength(){
		return this.Strength;
	}
	
	public int getConstitution(){
		return this.Constitution;
	}
	
	public int getDexterity(){
		return this.Dexterity;
	}
	
	public int getIntelligence(){
		return this.Intelligence;
	}
	
	public int getWisdom(){
		return this.Wisdom;
	}
	
	public int getCharisma(){
		return this.Charisma;
	}
	
}
