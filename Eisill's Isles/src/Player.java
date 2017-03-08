import java.util.ArrayList;

public class Player {

	private String Name;
	private int playerX;
	private int playerY;
	private int Health;
	private int Strength;
	private int Constitution;
	private int Dexterity;
	private int Intelligence;
	private int Wisdom;
	private int Charisma;
	
	
	public Player(String x,int a,int b){
		this.Name=x;
		this.playerX=a;
		this.playerY=b;
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
	
	
	public void setHealth(int x){
		this.Health=x;
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
