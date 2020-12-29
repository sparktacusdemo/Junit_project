package tddProject;


import java.util.ArrayList;
import java.util.List;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Scanner; 

//-----------------class------------------------

public class fileIndex {

	public static void main(String[] args) throws IOException {
		
		System.out.print(" -- Java Tool to index files -- ");
		//parameters:
		
		File dir = new File(args[0]);
		
		try {
		
				System.out.print("\n\n> Check if your directory exists: " + dir.list().length + " Files found inside \n\n");
				//int count_files = dir.list().length;
				//System.out.print("\n\n> Files found in the directory: " + count_files);
		}
		catch(Exception e) {
				System.out.print("\n" +  e);
			    System.out.print("\n\nerror, your directory doesn't exist. Please check the path. \n\n");
			    System.exit(0);
			
		}
		
		if (directory_is_empty(dir)) {
			System.out.print("\nyour directory is empty. No Files found in your directory.\n\n");
			System.exit(0);
		}
		else {
				System.out.print("\n\n -----------------------\n");
				System.out.print("\n File(s) Finder \n");
				
				System.out.print("> Enter a string: \n");
				
				// Using Scanner for Getting Input from User 
		        Scanner scan = new Scanner(System.in);
		        
		        while (scan.hasNextLine()) {
		  
			        String kw = scan.nextLine(); 
			        
			        if (kw.equals(":q")) {
			        	System.out.print("\n\nbye (^-^) \n\n"); 
			        	System.exit(0);
			        	scan.close();
			        }
			        else {
							try (Stream<Path> walk = Files.walk(Paths.get("/home/hdpu00/adevinta_files"))) {
					
								List<String> result = walk.map(x -> x.getFileName().toString())
										.filter(f -> f.contains(kw))
										.collect(Collectors.toList());
					
								//result.forEach(System.out::println);
								result.forEach(x -> System.out.print(" + " + x + "\n SCORE : " + String.format("%.1f",score(x,kw)) + " % \n"));
					
							} catch (IOException e) {
								e.printStackTrace();
							}
			        }
		        }
		}
        

        
	}
	
	
	//FUNCTION1: calculate the score of similarity between 2 string parameters s1 and s2: take 2 string and return a double type value (score as percentage)
	  public static Double score(String s1, String s2) {
            
		  ArrayList<Integer> list1 = new ArrayList<Integer>();
		  char[] chars1 = s1.toCharArray();
	        for (char aChar : chars1) {
	            
	                    String foo1 = String.format("%8s", Integer.parseInt(Integer.toBinaryString(aChar),2))   // char -> int, auto-cast
	                            .replaceAll(" ", "0");                // zero pads
	                    
	                    list1.add(Integer.parseInt(foo1));
	        }
		  
	        Integer[] arr1 = new Integer[list1.size()];
			list1.toArray(arr1);
		    double sum1 = sum_array(arr1);
		   
			//-----------
			  ArrayList<Integer> list2 = new ArrayList<Integer>();
			  char[] chars2 = s2.toCharArray();
		        for (char aChar : chars2) {
		            
		                    String foo2 = String.format("%8s", Integer.parseInt(Integer.toBinaryString(aChar),2))   // char -> int, auto-cast
		                            .replaceAll(" ", "");                // zero pads
		                    
		                    list2.add(Integer.parseInt(foo2));
		        }
			  
		        Integer[] arr2 = new Integer[list2.size()];
				list2.toArray(arr2);
				double sum2 = sum_array(arr2);
			
				 //double dsum1 = sum1;
				 //double dsum2 = sum2;
	       
				return (sum2/sum1)*100;
				
	        
		  }

	  //FUNCTION2: calculate the sum of array Integer[]: take an Array Integer[] and return a double type value
	  public static Double sum_array(Integer[] arr) {
		  int i =0;int sum=0;
	        for (i = 0; i < arr.length; i++) {
	            //System.out.print("\n" + arr[i]);
	            sum +=  arr[i];
	         }
	      double dsum = sum;
		  return dsum;
	  
	  }
	  
	  //Function3: check if the directory is empty (no files found inside)
	  public static Boolean directory_is_empty(File dir) {
		  
		  if (dir.list().length == 0) {
			  return true;
		  }
		  else return false;
		  
	  }
	
}
