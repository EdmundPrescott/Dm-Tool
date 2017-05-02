import java.util.ArrayList;
import java.util.Scanner;

public class redesign {

	private static boolean badValue=true;
	private static Scanner console=new Scanner(System.in);
	private static String userInput;
	private static String carryValue;
	private static String heldInput;
	
	
	private static ArrayList<String> DirectionInputs = new ArrayList<String>() {{
	    add("n");
	    add("north");
	    add("w");
	    add("west");
	    add("e");
	    add("east");
	    add("s");
	    add("south");
	}};
	private static ArrayList<String> BooleanNoInputs = new ArrayList<String>() {{
		add("n");
		add("no");
		add("naw");
		add("nope");
	}};
	
	private static ArrayList<String> BooleanYesInputs = new ArrayList<String>() {{
		add("y");
		add("yes");
		add("yeah");
		add("yee");
	}};
	
	private static ArrayList<String> ExamineAbles = new ArrayList<String>() {{
		add("Tiddy");
	}};
	
	private static ArrayList<String> Races = new ArrayList<String>() {{
		add("Dwarve");//Dwarves 
		add("Elf");//Elves
		add("Gnome");//Gnomes
		add("Half-Elf");//Half-elves
		add("Half-Orc");//Half-orcs
		add("Halfling");//Halflings
		add("Human");//Humans
		//add("");
	}};
	
	public redesign(){
		ExamineAbles.sort(null);
	}
	
	public static String correctFor(String typeCheck,String errorCode,String playerMessage,boolean cancelReady, boolean askTwice){
		if(typeCheck.equals("@")){
			if(!playerMessage.equals("?")){
				System.out.println(playerMessage);
			}else{
				System.out.println("Please enter a string");
			}
			while(badValue==true){
				userInput=console.nextLine();
        		if(!userInput.equals("")){
				if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
					carryValue="cancel";
					System.out.println("Cancelled");
					return userInput;
				}
				try{
					Integer.parseInt(userInput);
					if(errorCode.equals("?")){
					System.out.println("Please do not enter numbers");
					}else{
						System.out.println(errorCode);
					}
				}catch(Exception e){
					if(askTwice==true){
						heldInput=userInput;
						if(askTwice()==true){
							carryValue=heldInput;
							return heldInput;
						}else{
							System.out.println("Please enter a string");
						}
					}else{
						carryValue=userInput;
						return userInput;
					}
				}
        	}//End of next line catch
			}//End of while loop
		}
		
        if(typeCheck.equals("#")){
        	if(!playerMessage.equals("?")){
				System.out.println(playerMessage);
			}else{
				System.out.println("Please enter a number");
			}
			while(badValue==true){
				userInput=console.nextLine();
        		if(!userInput.equals("")){
				if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
					carryValue="cancel";
					System.out.println("Cancelled");
					return userInput;
				}
				try{
					Integer.parseInt(userInput);
					if(askTwice==true){
						heldInput=userInput;
						if(askTwice()==true){
							carryValue=heldInput;
							return heldInput;
						}else{
							System.out.println("Please enter a number");
						}
					}else{
						carryValue=userInput;
						return userInput;
					}
				}catch(Exception e){
					if(errorCode.equals("?")){
						System.out.println("Please do not enter letters");
						}else{
							System.out.println(errorCode);
						}
				}
        	}//End of next line catch
			}//End of while loop
		}
		
if(typeCheck.equals("B")){
        	if(!playerMessage.equals("?")){
				System.out.println(playerMessage);
			}else{
				System.out.println("Please enter yes or no");
			}
        	while(badValue==true){
        		userInput=console.next();
        		console.nextLine();
        		if(!userInput.equals("")){
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
					for(int i=0;i<BooleanYesInputs.size();i++){
					if(userInput.equalsIgnoreCase(BooleanYesInputs.get(i))){
						if(askTwice==true){
							heldInput=userInput;
						if(askTwice()==true){
						carryValue="true";
						return "true";
						}else{userInput="";}
						}else{
							carryValue="true";
							return "true";
							}
					}}
					for(int i=0;i<BooleanNoInputs.size();i++){
					if(userInput.equalsIgnoreCase(BooleanNoInputs.get(i))){
						if(askTwice==true){
							heldInput=userInput;
						if(askTwice()==true){
						carryValue="false";
						return "false";
						}else{userInput="";}
						}else{
							carryValue="false";
							return "false";
							}
					}}
					if(errorCode.equals("?")){
						System.out.println("Please enter yes or no");
						}else{
							System.out.println(errorCode);
						}
        	}		
			}
		}
        
		if(typeCheck.equals("^")){
				if(!playerMessage.equals("?")){
						System.out.println(playerMessage);
					}else{
						System.out.println("Please enter a direction");
					}
					while(badValue==true){
					userInput=console.next();
					if(!userInput.equals("")){
						if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
							carryValue="cancel";
							System.out.println("Cancelled");
							return userInput;
						}
						for(int i=0;i<DirectionInputs.size();i++){
						if(userInput.equalsIgnoreCase(DirectionInputs.get(i))){//
							if(askTwice==true){
								if(askTwice()==true){
									if(DirectionInputs.get(i).length()==1){
										carryValue=DirectionInputs.get(i+1);
										return DirectionInputs.get(i+1);
									}else{
										carryValue=DirectionInputs.get(i);
										return DirectionInputs.get(i);
									}
								}
							}else{
								if(DirectionInputs.get(i).length()==1){
									carryValue=DirectionInputs.get(i+1);
									return DirectionInputs.get(i+1);
								}else{
									carryValue=DirectionInputs.get(i);
									return DirectionInputs.get(i);
								}
							}
					}}
					if(errorCode.equals("?")){
							System.out.println("Please enter a direction");
						}else{
							System.out.println(errorCode);
						}	
					}
					}
		}
        
		if(typeCheck.equals("E")){
        	if(!playerMessage.equals("?")){
				System.out.println(playerMessage);
			}else{
				System.out.println("Please enter a examinable");
			}
        	while(badValue==true){
        		userInput=console.nextLine();
        		if(!userInput.equals("")){
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
        		for(int i=0;i<ExamineAbles.size();i++){
				if(userInput.equalsIgnoreCase(ExamineAbles.get(i))){//
					if(askTwice==true){
						if(askTwice()==true){
							carryValue=ExamineAbles.get(i);
							return ExamineAbles.get(i);
						}
					}else{
						carryValue=ExamineAbles.get(i);
						return ExamineAbles.get(i);
					}
				}}
        		if(errorCode.equals("?")){
					System.out.println("Please enter a examinable");
					}else{
						System.out.println(errorCode);
				}
        	}
			}
		}
        
		if(typeCheck.equals("R")){
        	if(!playerMessage.equals("?")){
				System.out.println(playerMessage);
			}else{
				System.out.println("Please enter a race");
			}
        	while(badValue==true){
        		userInput=console.nextLine();
        		if(!userInput.equals("")){
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
        		for(int i=0;i<Races.size();i++){
        			if(userInput.equalsIgnoreCase(Races.get(i))){//
        				if(askTwice==true){
        					if(askTwice()==true){
    					carryValue=Races.get(i);
    					return Races.get(i);
        					}
        				}else{
        					carryValue=Races.get(i);
        					return Races.get(i);
        				}
        				}}
        		if(errorCode.equals("?")){
					System.out.println("Please enter a race");
					}else{
						System.out.println(errorCode);
				}
        	}
			}
		}
        
        return "Correcting type invalid";
	}
	
	public static boolean askTwice(){
		System.out.println("Are you sure?");
		while(badValue==true){
    		userInput=console.next();
    		console.nextLine();
    		if(!userInput.equals("")){
				for(int i=0;i<BooleanYesInputs.size();i++){
				if(userInput.equalsIgnoreCase(BooleanYesInputs.get(i))){
						return true;
				}}
				for(int i=0;i<BooleanNoInputs.size();i++){
				if(userInput.equalsIgnoreCase(BooleanNoInputs.get(i))){
						return false;
				}}
				System.out.println("Please enter yes or no");
    		}
		}
		return false;
	}
	
	public static String correctFor(int a,int b,String errorCode,String playerMessage,boolean cancelReady,boolean askTwice){
		if(!playerMessage.equals("?")){
			System.out.println(playerMessage);
		}else{
			System.out.println("Please enter a number");
		}
		while(badValue==true){
			userInput=console.nextLine();
    		if(!userInput.equals("")){
			if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
				carryValue="cancel";
				System.out.println("Cancelled");
				return userInput;
			}
			try{
				if(Integer.parseInt(userInput)>=a&&Integer.parseInt(userInput)<=b){
				if(askTwice==true){
					heldInput=userInput;
					if(askTwice()==true){
						carryValue=heldInput;
						return heldInput;
					}else{
						System.out.println("Please enter a number");
					}
				}else{
					carryValue=userInput;
					return userInput;
				}
				}
			}catch(Exception e){
				if(errorCode.equals("?")){
					System.out.println("Please do not enter letters");
					}else{
						System.out.println(errorCode);
					}
			}
    	}//End of next line catch
		}//End of while loop
        	return "If you're seeing this you've done something wrong";
	}
	
	public static String CarryValue(){
		return carryValue;
	}
	
	public static void setCarryValue(){
		carryValue="north";
	}
	
	public static void clearCarryValue(){
		carryValue="cleared";
	}
	
	public static void forcedCancel(){
		carryValue="cancel";
	}
	
	public void printExamineAbles(){
		for(int i=0;i<ExamineAbles.size();i++){
			System.out.println(ExamineAbles.get(i));
		}
	}
	
}
