package date0313;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordDictionary2 {

	/** Initialize your data structure here. */
	Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

	public WordDictionary2() {
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		int len = word.length();
		if (!map.containsKey(len)) {
			List<String> list = new ArrayList<String>();
			map.put(len, list);	
		}
		List<String> handler = map.get(len);
			handler.add(word);

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the
	 * dot character '.' to represent any one letter.
	 */
	public boolean search(String word) {
		int len=word.length();
		if(!map.containsKey(len))
			return false;
		List <String>handler=map.get(len);	
		
		for(String s:handler){
			if (this.subSearch(s, word)) {
				return true;
			}
		}
		return false;
	}


	public boolean subSearch(String s, String word) {
		if (s.length() == word.length()) {
			for (int i = 0; i < word.length(); i++) {
				if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.')
					return false;
			}
			return true;
		}
		return false;
	}
}
