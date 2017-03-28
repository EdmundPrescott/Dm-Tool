import java.util.ArrayList;

public class SideThingPlayer {

	private String Name;
	
	private int playerX;
	private int playerY;
	
	private int Strength;
	private int Constitution;
	private int Dexterity;
	private int Intelligence;
	private int Wisdom;
	private int Charisma;
	
	private double actionPoints;
	
	private ArrayList<Skill> Skills = new ArrayList<Skill>();
	
	public SideThingPlayer(int a,int b){
		playerX=a;
		playerY=b;
		setName();
		setStats();
		
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
	
	public void setStats(){
		setStrength();
		setConstitution();
		setDexterity();
		setIntelligence();
		setWisdom();
		setCharisma();
	}
	
	public void setName(){
		System.out.println("What is the player's name?");
		Name=Input.correctFor("@","Please enter a name",false);
		System.out.println("Are you sure you want "+Name+" to be the players name?");
		if(Input.correctFor("B","?",false).equals("false")){
			setName();
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
		System.out.println("Are you sure you want charisma to be "+Charisma+"?");
		if(Input.correctFor("B","?",false).equals("false")){
			setCharisma();
		}
		
	}
	
	public void editStats(){
		System.out.println("Would you like to edit all stats?");
		Input.correctFor("B","?",false);
		
		if(Input.getCarryValue().equals("true")){
			setStats();
			
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
	
}
