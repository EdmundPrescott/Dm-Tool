import java.util.ArrayList;
import java.util.Scanner;

public class InputCorrecting {

	private static boolean badValue=true;
	private static Scanner console=new Scanner(System.in);
	private static String userInput;
	private static String carryValue;
	
	
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
		add("Bella");
		add("Shop");
		add("Meadow");
		add("Apex Beast");
	}};
	
	public InputCorrecting(){
		ExamineAbles.sort(null);
	}
	
	public static String correctFor(String typeCheck,String errorCode,boolean cancelReady){
		if(typeCheck.equals("@")){
			while(badValue==true){
				userInput=console.next();
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
					carryValue=userInput;
					return userInput;
				}
			}
			badValue=false;
		}
		
        if(typeCheck.equals("#")){
        	while(badValue==true){
        		userInput=console.next();
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
				try{
					Integer.parseInt(userInput);
					carryValue=userInput;
					return userInput;
				}catch(Exception e){
					if(errorCode.equals("?")){
						System.out.println("Please enter a number");
						}else{
							System.out.println(errorCode);
						}	
				}
			}
        	badValue=false;
		}
		
        if(typeCheck.equals("B")){
        	while(badValue==true){
        		userInput=console.next();
        		console.nextLine();
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
					
					for(int i=0;i<BooleanYesInputs.size();i++){
					if(userInput.equalsIgnoreCase(BooleanYesInputs.get(i))){
						carryValue="true";
						return "true";
					}}
					
					for(int i=0;i<BooleanNoInputs.size();i++){
					if(userInput.equalsIgnoreCase(BooleanNoInputs.get(i))){
						carryValue="false";
						return "false";
					}}
					
					if(errorCode.equals("?")){
						System.out.println("Please enter yes or no");
						}else{
							System.out.println(errorCode);
						}
			}
        	badValue=false;
		}
        
        if(typeCheck.equals("^")){
        	while(badValue==true){
        		userInput=console.next();
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
        		for(int i=0;i<DirectionInputs.size();i++){
				if(userInput.equalsIgnoreCase(DirectionInputs.get(i))){//
					carryValue=userInput;
					return userInput;}
				}
        		if(errorCode.equals("?")){
					System.out.println("Please enter a direction");
					}else{
						System.out.println(errorCode);
				}
			}
        	badValue=false;
		}
        
        if(typeCheck.equals("E")){
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
					carryValue=ExamineAbles.get(i);
					return ExamineAbles.get(i);
					}
				}
        		if(errorCode.equals("?")){
					System.out.println("Please enter a valid thing to examine");
					}else{
						System.out.println(errorCode);
				}
        		}
			}
        	badValue=false;
		}
        
        return "Error correcting type invalid";
	}
	
	public static String correctFor(int a,int b,String errorCode,boolean cancelReady){
        	while(badValue==true){
        		userInput=console.next();
        		if(cancelReady==true&&userInput.equalsIgnoreCase("cancel")){
        			carryValue="cancel";
        			System.out.println("Cancelled");
					return userInput;
				}
				try{
					if(Integer.parseInt(userInput)>=a&&Integer.parseInt(userInput)<=b){
						carryValue=userInput;
						return userInput;
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
        	badValue=false;
        	return "If you're seeing this you've done something wrong";
	}
	
	public static String getCarryValue(){
		return carryValue;
	}
	
	public void printExamineAbles(){
		for(int i=0;i<ExamineAbles.size();i++){
			System.out.println(ExamineAbles.get(i));
		}
	}
	
}
