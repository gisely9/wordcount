import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




/**
 * Date: 19/11/2021
 * @author gisele
 * A class that will push the text from given URL and all words from it to a string array and 
 * add each word to a database 
 */
public class Text {
	
	protected static ArrayList<String> textFromWeb(String startLine, String endLine) {
		
		try {
			
	// Representing the URL class 
		
		URL url = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
		
		// retrieving the content of the page 
		
		Scanner scan = new Scanner(url.openStream());
		
		
		//Representing the StringBuffer class to hold the result 
		
		StringBuffer sb = new StringBuffer();
		       
		       
		       while (scan.hasNextLine())
		       
		       {
		        
		    	   String val = scan.nextLine();
		    	   
// detecting the user indicate start 
		    	   
		    	   
		    	   if(val.toString().contains(startLine)) {
		    		   
		    		   
		  // System.out.println("line containing sourceHead: " + line);
		    		   
		    		   sb.append(" " + val);
		    		   
		    		   while(scan.hasNextLine()) {
		    			
		    			   	val = scan.nextLine();
		    			   	sb.append(" " + val);
		    			   	
		    			   	if (val.toString().contains(endLine)) {
		    			   		break;
		    			   	}
		    		   
		    		   }
		    	   }  
		    	   
		    	   
		    	 
		    	}
		       
		       // Create String from StringBuffer object
		       String all = sb.toString();
		       
		       // String array to hold individual words
		       String[] words = null;
		       
		       // Strip HTML
		       String strip = all.toString().toLowerCase().replaceAll("\\<.*?>", "");
		       
		       // Split string, only allow letters of alphabet using regular expression
		       // 
		       words = strip.split("[^a-zA-Z’]+");
		       
		       scan.close();
		       
		       ArrayList<String> wordsList = new ArrayList<String>();
		       
		       for(String word : words) {
		    	   if(word.toString() != "" && word.toString() != " " && !word.toString().contains("mdash") && !word.toString().contains("  ")) {

		    		   wordsList.add(word.toString());
		    	   }
		       }
		       
		       return wordsList;
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	       
	       return null;
		
	}
	
	/** 
	 * Using HashMap to store values which can be accessed using strings 
	 * @param words is a string array created by pareSite() method which 
	 * contains every word and its multiples that was parsed 
	 * @return String [] which contains every word on the requested site 
	 */
	
	
	protected static HashMap<String, Integer> textToMap(ArrayList<String> words) {
		
		 HashMap<String,Integer> map = new HashMap<String, Integer>();
		
		 for (int i = 0; i < words.size(); i++) {
			 
			 if (map.containsKey(words.get(i))) {
				 
				 int count = map.get(words.get(i));
				 
				 map.put(words.get(i), ++count);
			 } else {
				 map.put(words.get(i), 1);
			 }
			 
		 }
		 
		 return map;
	}
	/**
	 *
	 * @param map  contains values that each of those have an entry key 
	 * @return String [] which contains every word on the requested site 
	 */
	protected static ArrayList<Word> generateWordList(HashMap<String, Integer> map) {
		
		ArrayList<Word> wordsList = new ArrayList<Word>();
		
		for(@SuppressWarnings("rawtypes") Map.Entry entry : map.entrySet()) {
			
			//count++;
			//System.out.println("Map Entry: " + count + "   " + entry.getKey().toString());
			String word = entry.getKey().toString();
			
			String wordCount = entry.getValue().toString();
			
			int wordCountInt = Integer.parseInt(wordCount);
			
			Word newWord = new Word(word, wordCountInt);
			
			wordsList.add(newWord);
			
		}
		
		return wordsList;
		
	}
	

}


/*
 * 
 *  }
			    		   
			       		map.put(val,1);
			       	   
			       	   else 
			       	   {
			       		   int count = (int)(map.get(val));
			       		   map.remove(val);
			       		   map.put(val, count+1);
			       	   }
			          }
 * 
 * 
 * Set<Map.Entry<String, Integer>> set = map.entrySet(); 
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
			       		  
			       	   
			       			
				 }
				 
			 }
 * 
 * */
