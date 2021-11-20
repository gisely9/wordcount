
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



/**
 * Date: 19/11/2021
 * @author gisele
 * This is an application that pushes the text from the website and displays the top10 
 * words
 * @author gisele
 */
 
public class App {
	
	//Calling variables 

	public static String startLine = "<h1>The Raven</h1>";
	public static String endLine = "<!--end chapter-->";
	public static ArrayList<String> wordsList = null;
	public static HashMap<String, Integer> map = new HashMap<>();
	public static ArrayList<Word> list = new ArrayList<Word>();
	
	/**
	 * declaring an exception that can occur during the execution of the 
	 * program 
	 * @throws FileNotFoundException
	 */
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		wordsList = Text.textFromWeb(startLine, endLine);
		
		map = Text.textToMap(wordsList);
		list = Text.generateWordList(map);
		
		Collections.sort(list);
		Collections.reverse(list);
		
		//System.out.println("List Size: " + list.size());
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString(i));
		}
	   
	}
    		  
} 		
    			
    
    	   
    	