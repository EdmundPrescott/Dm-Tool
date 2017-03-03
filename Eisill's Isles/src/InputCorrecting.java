import java.util.ArrayList;
import java.util.Scanner;

public class InputCorrecting {

	private boolean badValue=true;
	private boolean cancel=false;
	private Scanner console=new Scanner(System.in);
	private String userInput="";
	private String carryValue;
	
	ArrayList<String> DirectionInputs = new ArrayList<String>() {{
	    add("n");
	    add("N");
	    add("north");
	    add("North");
	    add("w");
	    add("W");
	    add("west");
	    add("West");
	    add("e");
	    add("E");
	    add("east");
	    add("East");
	    add("s");
	    add("S");
	    add("south");
	    add("South");
	}};
	ArrayList<String> BooleanInputs = new ArrayList<String>() {{
		add("y");
		add("Y");
		add("yes");
		add("Yes");
		add("yeah");
		add("yee");
		add("n");
		add("N");
		add("no");
		add("No");
		add("naw");
		add("nope");
	}};
	
	
	public InputCorrecting(){
		
	}
	
	public String correctFor(String x,String errorCode,boolean cancelReady){
		if(x.equals("@")){
			while(this.badValue==true){
				this.userInput=this.console.next();
				if(cancelReady==true&&this.userInput.equals("cancel")){
					return this.userInput;
				}
				try{
					Integer.parseInt(this.userInput);
					if(errorCode.equals("?")){
					System.out.println("Please do not enter numbers");
					}else{
						System.out.println(errorCode);
					}
				}catch(Exception e){
					this.carryValue=this.userInput;
					return this.userInput;
				}
				
			}
			this.badValue=false;
		}
		
        if(x.equals("#")){
        	while(this.badValue==true){
        		this.userInput=this.console.next();
        		if(cancelReady==true&&this.userInput.equals("cancel")){
					return this.userInput;
				}
				try{
					Integer.parseInt(this.userInput);
					this.carryValue=this.userInput;
					return this.userInput;
				}catch(Exception e){
					if(errorCode.equals("?")){
						System.out.println("Please enter a number");
						}else{
							System.out.println(errorCode);
						}
					
				}
			}
        	this.badValue=false;
		}
		
        if(x.equals("B")){
        	while(this.badValue==true){
        		this.userInput=this.console.next();
        		if(cancelReady==true&&this.userInput.equals("cancel")){
					return this.userInput;
				}
				if(this.BooleanInputs.contains(this.userInput)){
					this.carryValue=this.userInput;
					if(this.userInput.equals("y")||this.userInput.equals("Y")||this.userInput.equals("yes")||this.userInput.equals("Yes")
							||this.userInput.equals("yeah")||this.userInput.equals("yee")){
						return "true";
					}
					
					if(this.userInput.equals("n")||this.userInput.equals("N")||this.userInput.equals("no")||this.userInput.equals("No")
							||this.userInput.equals("nope")||this.userInput.equals("naw")){
						return "false";
					}
					
				}else{
					if(errorCode.equals("?")){
						System.out.println("Please enter yes or no");
						}else{
							System.out.println(errorCode);
						}
					
				}
			}
        	this.badValue=false;
		}
        
        if(x.equals("^")){
        	while(this.badValue==true){
        		this.userInput=this.console.next();
        		if(cancelReady==true&&this.userInput.equals("cancel")){
					return this.userInput;
				}
				if(this.DirectionInputs.contains(this.userInput)){
					this.carryValue=this.userInput;
					return this.userInput;
				}else{
					if(errorCode.equals("?")){
						System.out.println("Please enter a direction");
						}else{
							System.out.println(errorCode);
						}
					
				}
			}
        	this.badValue=false;
		}
        
        return "Error correcting type invalid";
	}
	
	public String correctFor(int a,int b,String errorCode,boolean cancelReady){
        	while(this.badValue==true){
        		this.userInput=this.console.next();
        		if(cancelReady==true&&this.userInput.equals("cancel")){
					return this.userInput;
				}
				try{
					if(Integer.parseInt(this.userInput)>=a&&Integer.parseInt(this.userInput)<=b){
						this.carryValue=this.userInput;
						return this.userInput;
					}else{
						System.out.println("That number isn't between "+a+" and "+b);
					}
				}catch(Exception e){
					if(errorCode.equals("?")){
						System.out.println("Please enter a number");
						}else{
							System.out.println(errorCode);
						}
					
				}
			}
        	this.badValue=false;
        
        return "Error correcting type invalid";
	}
	
	public void newThing(String x,Scanner console){
		
	}
	
	public String getCarryValue(){
		return this.carryValue;
	}
	
}
