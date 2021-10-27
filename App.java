
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class App {

	public static String startLine = "<h1>The Raven</h1>";
	public static String endLine = "<!--end chapter-->";
	public static ArrayList<String> wordsList = null;
	public static HashMap<String, Integer> map = new HashMap<>();
	public static ArrayList<Word> list = new ArrayList<Word>();
	
	
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
    			
    
    	   
    	