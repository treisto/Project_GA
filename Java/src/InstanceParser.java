import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class InstanceParser {
	
	private String fileName;
	private String baseDir = "../Instances/"; // folder to load the txt files
	private double[][] executionTimeVectors;
	
	InstanceParser(String _instance_name){
		fileName = _instance_name;
		executionTimeVectors = new double[512][16];
		
	     System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
	}

	void readInstanceFile(){
		
		String instFile = baseDir+fileName;
		BufferedReader br = null;
		String line = "";
		String lineSplitBy = " +";  							 //////  *(F) remove spaces 
	 
		try {
	 
			br = new BufferedReader(new FileReader(instFile));
			int i=0;
			while ((line = br.readLine()) != null) {
				line=line.replace(",", ""); // *(E) swap comma with void.
			    // use comma as separator
				String[] splittedLine = line.split(lineSplitBy);
				if(splittedLine.length>1){
					for(int j=0;j<splittedLine.length-1;j++){			
						executionTimeVectors[i][j]=Double.parseDouble(splittedLine[j+1]); 		///////  *(G) delete numbers from first column. 
					}
				}
				i++;
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	 
		System.out.println("Done");
		
		
	}
	
	double getInstanceValue(int _job, int _machine){
		return executionTimeVectors[_job][_machine];
	}
	
}
