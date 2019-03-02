
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Jennifer Yan
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = source.toString();//Check if this is the right thing to be doing
		myHash = source.hashCode();
		for(int i = 0; i<size; i++) {
			myWords[i] = source[start];
			start++;
		}
		// TODO: initialize myWords and others as needed
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){//is o a subtype of WordGram
			return false;
		}
		WordGram wg = (WordGram)o;
		if (this.myWords.length != wg.myWords.length) {
			return false;
		}
		for(int i = 0; i<this.length(); i++){
			if(!this.myWords[i].contentEquals(wg.myWords[i])) {
				return false;
			}
		}
	    // TODO: complete this method
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method
		if (myHash == 0) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return wg, a new WordGram that contains k-1 to last
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		String [] newWords = new String[myWords.length];
		for(int i = 0; i<wg.length()-1; i++) {
			newWords[i] = wg.myWords[i+1];
		}
		newWords[newWords.length -1] = last; 
		wg.myWords = newWords;
		return wg;
	}//complete this method

	@Override
	public String toString(){
		// need to make sure can't change value??? "DONT RECOMPUTE..."
			if (myToString == null) {//is this necessary??
				myToString = String.join(" ", myWords);	
			}
			
		return myToString;
	}
}

