import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MyproblemMMSP extends Problem {

	InstanceParser instanceParser; 
	
	MyproblemMMSP(String _prob_instance){
		instanceParser = new InstanceParser(_prob_instance);
		instanceParser.readInstanceFile();
	}
	
	@Override
	public double Evaluate(Individual indiv) {
		
		double[] execTimeArray = new double[16];
		// TODO Auto-generated method stub
		double totalExecTime=0.0;
		for(int i=0;i<CL;i++){					/////////(9) we calc the max. exec.time of each gene
			int _machine = indiv.get_allele(i);
			execTimeArray[_machine]+=instanceParser.getInstanceValue(i,_machine);
		}

		return getMaxValue(execTimeArray);  //////(10) return the max exec. time for each gene we add minus to get the minimize exec. time. 
	}
	
	// getting the maximum value
	public static double getMaxValue(double[] array){  
	      double maxValue = array[0];  
	      for(int i=1;i < array.length;i++){  
	      if(array[i] > maxValue){  
	      maxValue = array[i];  

	        }  
	     }  
	             return maxValue;  
	} 

}