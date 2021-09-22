import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCountProject {


	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
	
	
       Scanner scan = new Scanner(file);
       
       Map<String,Integer> map = new HashMap<String, Integer>();
       
       while (scan.hasNext())
       
       {
        
    	   String val = scan.nextLine();
    	   if (map.containsKey(val) ==false)
    		   
    		map.put(val,1);
    	   
    	   else 
    	   {
    		   int count = (int)(map.get(val));
    		   map.remove(val);
    		   map.put(val, count+1);
    	   }
       }
    	Set<Map.Entry<String, Integer>> set = map.entrySet(); 
    	 List<Map.Entry<String,Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);
    	Collections.sort(sortedList,new Comparator<Map.Entry<String,Integer>>()
    	
    	{
    		public int compare (Map.Entry<String,Integer> a, Map.Entry<String,Integer> b)
    		{
    			{
    				return (b.getValue()).compareTo(a.getValue());
    				return (a.getValue()).compareTo(b.getValue());
    			

    		  
    		  for(Map.Entry<String,Integer>i:sortedList) {
    			  
    		  }
    			  System.out.println(i.getKey()+" ->"+i.getValue());
    		  
    	   
    			
    		  
    		
    			
    
    	   
    	