package date0313;

import java.util.HashSet;
import java.util.Set;

public class WordDictionary {

    /** Initialize your data structure here. */
	Set <String> map=new HashSet<String>();
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        map.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        for(String s:map){
        	if (this.subSearch(s, word))
        		return true;
        }
        return false;
    }	
    public static void main(String[] args) {
		WordDictionary wd=new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad"));
	}
    public boolean subSearch(String s,String word){
    	if(s.length()==word.length()){
    		for(int i=0;i<word.length();i++){
    			if(s.charAt(i)!=word.charAt(i)&&word.charAt(i)!='.')
    				return false;
    		}
    		return true;
    	}  
    	return false;
    }
}
