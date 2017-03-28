
public class Trait {

	private String Name;
	private String Effect;
	//bools I guess
	public Trait(String name,String effect){
		Name=name;
		Effect=effect;
	}
	
	public String getTraitName(){
		return Name;
	}
	
	public String getTraitEffect(){
		return Effect;
	}
	
}
