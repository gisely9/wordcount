
public class Word implements Comparable<Word> {

	
	private String word;
	private int count;
	
	public Word(String word, int count) {
		super();
		this.word = word;
		if (count > 0) {
			this.count = count;
		}
	}
	
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
	
	
	
	@Override
	public int compareTo(Word word) {
		
		return this.count - word.getCount();
	}
	
	
	public String toString(int index) {
		return "\n " + (index + 1) + ") Word: " + word + "\t\t\tCount: " + count;
	}
	

}
