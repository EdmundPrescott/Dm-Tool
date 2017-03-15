import java.util.ArrayList;

public class Group {
	private int groupNumber;
	private ArrayList<Player> Players = new ArrayList<Player>();
	
	public Group(int x){
		this.groupNumber=x+1;
	}
	
	public int getGroupNumber(){
		return this.groupNumber;
	}
	
	public void setGroupNumber(int x){
		this.groupNumber=x;
	}
	
	public void addPlayer(Player player){
		this.Players.add(player);
	}
	
	public void removePlayer(Player player){
		this.Players.remove(player);
	}
	
	public void addPlayers(ArrayList chosenPlayers){
		this.Players.addAll(chosenPlayers);
	}
	
	public void removePlayers(ArrayList chosenPlayers){
		for(int i=0;i<chosenPlayers.size();i++){
		this.Players.remove(chosenPlayers.get(i));
		}
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
		System.out.println("Player not found");
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
		for(int i=0;i<this.Players.size();i++){
			this.Players.get(i).move(x);
		}
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
