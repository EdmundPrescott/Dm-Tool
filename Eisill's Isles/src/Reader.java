import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

	public Reader(){
		
	}
	
	public String[][] readRaces() throws FileNotFoundException{
		File file = new File("Races.txt");
		String[][] Races={{"Dwarve","Dwarves"},{"Elf","Elves"},{"Gnome","Gnomes"},{"Half-Elf","Half-elves"},
						  {"Half-Orc","Half-orcs"},{"Halfling","Halflings"},{"Human","Humans"}}; 
		String[][] raceDataChunk = null;
		boolean print=false;
		boolean traitData = true;
		String Race;
		String fileName="Races.txt";
		String startIndex = "";
		ArrayList<String> raceDataStream = new ArrayList<String>();
		
		System.out.println("What race would you like to print?");
		
		Race=InputCorrecting.correctFor("R","?",false);
		
		System.out.println("Would you like only the traits?");
		
		InputCorrecting.correctFor("B","?",false);
		
		if(InputCorrecting.getCarryValue().equals("true")){
			traitData=true;
		}
		
		if(InputCorrecting.getCarryValue().equals("false")){
			traitData=false;
		}
		
		
		if(traitData==true){
			startIndex+=(Race+" Racial Traits");
		}else{
		for(int i=0;i<Races.length;i++){
		if(Race.equals(Races[i][0])){
			
			startIndex=Races[i][1];
		}
		}
		}
		
		if(startIndex.equals("Dwarve Racial Traits")){
			startIndex="Dwarf Racial Traits";
		}
		
		//System.out.println(startIndex);
        // This will reference one line at a time
        String line = null;
        try {
            // FileReader reads text files in the default encoding.
            java.io.FileReader fileReader = new java.io.FileReader(fileName);
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	
            	
            	if(line.equals(startIndex)&&!line.equals("")){
            		print=true;
            	}
            	
            	for(int i=0;i<Races.length;i++){
            	if(line.equals(Races[i][1])&&!line.equals(startIndex)){
            		print=false;
            		break;
            	}
            	}
            	
            	if(print==true){
            		if(!line.equals("")){
            		raceDataStream.add(line);
            		}
            		///System.out.println(line);
            	}
            }//End of while loop i.e using file information 
            // Always close files.
            bufferedReader.close();         
        }///End of try bracket
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        //System.out.println("---------------------");
        raceDataChunk= new String [2][raceDataStream.size()];
		
        for(int i=0;i<raceDataStream.size();i++){
        	raceDataChunk[1][i]=raceDataStream.get(i);
        	//System.out.println(raceDataChunk[1][i]);
        } 
        
        
        /*
        int HasType;
        for(int i=0;i<raceDataChunk[0].length;i++){
        	
        	HasType=raceDataChunk[1][i].indexOf(":")-1;
        	if(!HasType==null){
        		raceDataChunk[0][1]=raceDataChunk[1][i].substring(0,HasType);
        		raceDataChunk[1][i]=raceDataChunk[1][i].substring(HasType);
        	}else{
        		raceDataChunk[0][i]="null";
        	}
        }
        
        for(int i=0;i<raceDataChunk[0].length;i++){
        	System.out.println(raceDataChunk[0][i]+" "+raceDataChunk[1][i]);
        	
        }
        
        */
        int indexValueName=0;
        for(int i=0;i<raceDataChunk[0].length;i++){ 
        //System.out.println("Loop "+(i+1));
        try{
        indexValueName=raceDataChunk[1][i].indexOf(":");	
        raceDataChunk[0][i]=raceDataChunk[1][i].substring(0,indexValueName);
        raceDataChunk[1][i]=raceDataChunk[1][i].substring(indexValueName+2);
        //System.out.println("Subbed over "+raceDataChunk[0][i]);
        }catch(Exception e){
        if(raceDataChunk[1][i].equals("")){
        	//raceDataChunk[0][i]="---";
        }else{
        	raceDataChunk[0][i]="@";
        }
        
        /*if(raceDataChunk[1][i].indexOf("Traits")>0){
        	raceDataChunk[0][i]="Trait";
        }*/
        
        }
        
        
       }//end of for loop 
        
        
        
        
        for(int i=0;i<raceDataChunk[0].length;i++){ 
        	for(int j=0;j<2;j++){
        		//System.out.print("X:"+j+"Y:"+i+"{-}"+raceDataChunk[j][i]+"");
        		System.out.println(raceDataChunk[j][i]);
        		if(j==0){
        			//System.out.print("---");
        		}
        	}
        	
        	System.out.println();
        }
        
        
        /*for(int i=0;i<Races[i][1].length();i++){
        System.out.println(Races[i][0]);
        }*/
        
        
        
        
        return raceDataChunk;
	}
	
	public void readFile(){
		
	}
	
}
