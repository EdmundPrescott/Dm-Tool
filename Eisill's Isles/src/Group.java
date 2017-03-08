import java.util.ArrayList;

public class Group {
	private int groupNumber;
	private ArrayList<Player> Players = new ArrayList<Player>();
	
	public Group(int x){
		this.groupNumber=x+1;
	}
	
	public void addPlayer(Player player){
		this.Players.add(player);
	}
	
	public void removePlayer(String player){
		this.Players.remove(player);
	}
	
	public Player getPlayer(int x){
		if(x<=this.Players.size()&&x>=0){
		return this.Players.get(x);
		}
		return null;
	}
	
	public Player getPlayer(String player){
		for(int i=0;i<this.Players.size();i++){
		if(this.Players.get(i).getPlayerName().equals(player)){
			return this.Players.get(i);
		}
		}
		return null;
	}
	
	public void printGroup(){
		for(int i=0;i<this.Players.size();i++){
			System.out.println(this.Players.get(i).getPlayerName());
		}
	}
	
	public void printNumberedGroup(){
		for(int i=0;i<this.Players.size();i++){
			System.out.println((i+1)+". "+this.Players.get(i).getPlayerName());
		}
	}
	
	public void moveAll(String x){
		
	}
	
	public boolean groupContains(String player){
		if(this.Players.contains(player)){
			return true;
		}else{
			return false;
		}
	}
	
	public int groupSize(){
		return this.Players.size();
	}
	
}
