import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

	private String[][] Races={{"Dwarve","Dwarves"},{"Elf","Elves"},{"Gnome","Gnomes"},{"Half-Elf","Half-elves"},
			  				  {"Half-Orc","Half-orcs"},{"Halfling","Halflings"},{"Human","Humans"}}; 
	private String[][] raceDataChunk = null;
	private ArrayList<String> raceDataStream = new ArrayList<String>();
	private boolean print=false;
	
	public Reader(){
		
	}
	
	public String[][] readRaces(String x) throws FileNotFoundException{
		String fileName="Races.txt";
		String startIndex=(x+" Racial Traits");
		boolean printChunk=false;
		if(startIndex.equals("Dwarve Racial Traits")){
			startIndex="Dwarf Racial Traits";
		}
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
            		if(!line.equals("")&&line!=null){
            		raceDataStream.add(line);
            		}
            		//System.out.println(line);//very useful for bug fixing
            	}
            }//End of while loop i.e using file information 
            // Always close files.
            bufferedReader.close();         
        }///End of try bracket
        catch(FileNotFoundException ex){System.out.println("Unable to open file '" +fileName+ "'");}
        catch(IOException ex){System.out.println("Error reading file '"+fileName+ "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        raceDataChunk=new String[2][raceDataStream.size()];
        int index=0;
        for(int i=0;i<raceDataStream.size();i++){
        	raceDataChunk[1][i]=raceDataStream.get(i);
        	try{
                index=raceDataChunk[1][i].indexOf(":");
                raceDataChunk[0][i]=raceDataChunk[1][i].substring(0,index);
                raceDataChunk[1][i]=raceDataChunk[1][i].substring(index+2);
                if(raceDataChunk[0][i].contains("Speed")){raceDataChunk[0][i]="Speed";}
                if(raceDataChunk[0][i].equalsIgnoreCase("small")||raceDataChunk[0][i].equalsIgnoreCase("medium")||raceDataChunk[0][i].equalsIgnoreCase("large")){
                	raceDataChunk[1][i]=raceDataChunk[0][i];raceDataChunk[0][i]="Size";
                }
                if(raceDataChunk[0][i].contains("+2")){
                	raceDataChunk[1][i]=raceDataChunk[0][i];
                	raceDataChunk[0][i]="Stats";
                }
                }catch(Exception e){
                	raceDataChunk[0][i]="@";//Gets rid of [race] traits, could write code to not load/save this
                }
        }
        
        if(printChunk==true){
        for(int i=0;i<raceDataChunk[0].length;i++){
        	for(int j=0;j<2;j++){
        	System.out.print(raceDataChunk[j][i]);
        	if(j==0){
        		System.out.print("<--->");
        	}
        	}
        	System.out.println();
        }
    	System.out.println();
        }
        
        raceDataStream= new ArrayList<String>();
        return raceDataChunk;
	}
	
}