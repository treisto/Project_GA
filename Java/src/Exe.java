import java.util.Random;

/***********************************************/
/** PROBLEM SOLVING                           **/
/** UNIVERSITY OF LUXEMBOURG                  **/
/** DEC 2010                                  **/
/** Prof. Pascal Bouvry                       **/
/** Assistant Patricia Ruiz                   **/
/** Assistant Cesar Diaz                      **/
//8888888888888//**********************************************/

public class Exe
{
  public static void main(String args[]) throws Exception
  {
/*     
    // PARAMETERS PPEAKS 
    int    gn         = 512;                           // Gene number
    int    gl         = 1;                            // Gene length
    int    popsize    = 512;                          // Population size
    double pc         = 0.8;                          // Crossover probability
    double pm  = 1.0/(double)((double)gn*(double)gl); // Mutation probability
    double tf         = (double)1 ;              // Target fitness beign sought
    long   MAX_ISTEPS = 50000;

      
    // PARAMETERS ONEMAX
    int    gn         = 512;                          // Gene number
    int    gl         = 1;                            // Gene length
    int    popsize    = 512;                          // Population size
    double pc         = 0.8;                          // Crossover probability
    double pm  = 1.0/(double)((double)gn*(double)gl); // Mutation probability
    double tf         = (double)gn*gl ;               // Target fitness being sought
    long   MAX_ISTEPS = 10000;
   */
	  
    // PARAMETERS MMSP
    int    gn         = 512;                          // Gene number
    int    gl         = 1;                            // Gene length
    int    popsize    = 1024;                          // Population size
    double pc         = 0.8;                          // Crossover probability
    double pm  = 1.0/(double)((double)gn*(double)gl); // Mutation probability
    double tf         = (double)0.0 ;               // Target fitness being sought
    long   MAX_ISTEPS = 5000;  									/////////(3) we change the execution steps by this number.
    int    n          = 50;                         //number of iterations
    int    results[];
    results = new int[n];
    
    for (int iterations=0; iterations<n; iterations++)
    {
    
    Problem   problem;                             // The problem being solved

    // problem = new ProblemPPeaks(); 
    //problem = new ProblemPPeaks();
    problem = new MyproblemMMSP("u_s_lolo_512_16.txt"); 				/////(4) we open our file we desire.
    //InstanceParser ip = new InstanceParser("u_c_hihi_512_16.txt");
    //ip.readInstanceFile();
    
    problem.set_geneN(gn);
    problem.set_geneL(gl);
    problem.set_target_fitness(tf);



    Algorithm ga;          // The ssGA being used
    ga = new Algorithm(problem, popsize, gn, gl, pc, pm);


    for (int step=0; step<MAX_ISTEPS; step++)
    {  
      ga.go_one_step();
      System.out.print(step); System.out.print("  ");
      System.out.println(ga.get_bestf());

      if(     (problem.tf_known())                    &&
      (ga.get_solution()).get_fitness()<=problem.get_target_fitness()
      )
      { System.out.print("Solution Found! After ");
        System.out.print(problem.get_fitness_counter());
        System.out.println(" evaluations");
        break;
      }

    }

    // Print the solution
    for(int i=0;i<gn*gl;i++)
      System.out.print( (ga.get_solution()).get_allele(i)+"," ); System.out.println();
      System.out.println((ga.get_solution()).get_fitness());
      
      
      
      //for (int i=0; i<length; i++){
      	//double start = 0;		//(2) we use 0-16 array for the allele and reveals the machines
      	//double end = 16;
      	//double random = new Random().nextDouble();
      	//double result = start + (random * (end - start));
      	results[iterations]=(int)((ga.get_solution()).get_fitness());
  	  //}  
      
    }//end for iterations  
    
    	System.out.println("MakeSpans for "+n+" iterations:");
    	for(int i=0;i<n;i++){
    		System.out.print(results[i]+",");
    	}
    
    
  }// end public static void main

}
// END OF CLASS: Exe
