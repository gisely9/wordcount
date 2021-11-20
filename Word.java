/**
 * Date: 19/11/2021
 * This is the 
 * @author gisele
 *
 */
public class Word implements Comparable<Word> {

	// variables 
	
	
	private String word;
	private int count;
	
	//constructor 
	
	public Word(String word, int count) {
		super();
		this.word = word;
		if (count > 0) {
			this.count = count;
		}
	}
	
	// getters and setters 
	
	
	public String getWord() {
		return word;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public void setCount(int count) {
		if(count > 0) {
			this.count = count;
		}
	}
	
	/**
	 * A method that allows Word objects to be compared 
	 * in order to allow ArrayList of word to be sorted 
	 * by the frequency.
	 */
	
	
	@Override
	public int compareTo(Word word) {
		
		return this.count - word.getCount();
	}
	
	
	public String toString(int index) {
		return "\n " + (index + 1) + ") Word: " + word + "\t\t\tCount: " + count;
	}
	

}



