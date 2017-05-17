package wangxydhc.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution0312 {
//	public String reverseStr(String s, int k) {
//		int len = s.length();
//		int n = len / (2 * k);
//		int i = 0;
//		String branch, branch2;
//		StringBuffer sb = new StringBuffer();
//		while (n-- >= 0) {
//			if (i + k < len)
//				branch = s.substring(i, last);
//			branch2 = s.substring(i + k, i + 2 * k);
//			sb.append(this.reverseString(branch));
//			sb.append(branch2);
//			i += 2 * k;
//		}
//
//	}

	public boolean repeatedSubstringPattern(String s) {
		int len = s.length();
		int count;
		for (int i = 1; i < s.length() / 2 + 1; i++) {
			System.out.println(i);
			StringBuffer sb = new StringBuffer();
			if (len % i == 0) {
				count = len / i;
				System.out.println(count);
				while (count-- > 0) {
					System.out.println(s.substring(0, i));
					sb.append(s.substring(0, i));
				}
				if (sb.toString().equals(s)) {
					return true;
				}
			} else
				continue;
		}
		return false;
	}

	public List<String> generateParenthesis(int n) {
		LinkedList<String> res=new LinkedList<String>();
		int [] count=new int[2];
		res.add("");
		for(int i=0;i<n*2;i++){			
			while(res.peek().length()==i){	
				System.out.println(i);
				System.out.println(res.peek());
				String t=res.remove();	
				count[0]=0;
				count[1]=0;
				for(int j=0;j<t.length();j++){				
							
					if (t.charAt(j)=='(')
						count[0]++;
					if(t.charAt(j)==')')
						count[1]++;
					System.out.println(  count[0]+"  "+count[1]);
				}
				System.out.println("count[0]:"+count[0]+"  "+"count[1]:"+count[1]);
				if(count[0]<n){
					System.out.println(count[0]);
					char c='(';
					res.add(t+c);
				}
				if(count[1]<n&&count[0]>count[1]){
					char c=')';
					res.add(t+c);
				}
			}
		}
		while(!res.isEmpty())
		System.out.println(res.remove());
		return res;
	}
	
	public List<String> letterCombinations(String digits) {
		int x;
		String[] dic = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		LinkedList<String> res = new LinkedList<String>();
		String t = "";
		res.add(t);
		for (int i = 0; i < digits.length(); i++) {
			while (!res.isEmpty() && res.peek().length() == i) {
				t = res.remove();
				x = Character.getNumericValue(digits.charAt(i));
				for (int j = 0; j < dic[x].length(); j++)
					res.add(t + dic[x].charAt(j));
			}
		}
		if (res.peek() == "") {
			res.remove();
		}
		return res;
	}

	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<String>();
		Set<String> ignor = new HashSet<String>(Arrays.asList(".", "..", ""));
		for (String s : path.split("/")) {
			System.out.println("ss:" + s);
			if (s.equals("..") && !stack.isEmpty())
				stack.pop();
			if (!ignor.contains(s))
				stack.push(s);
		}
		String s = "";
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			s = stack.pollLast();
			System.out.println("s:" + s);
			sb.append("/");
			sb.append(s);
		}
		String res = sb.toString();
		return res.equals("") ? "/" : res.toString();

	}

	public int lengthOfLastWord(String s) {
		int len = 0;
		for (String zi : s.split(" ")) {
			len = zi.length();
		}
		return len;
	}

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] count = new int[26];
		for (int i = 1; i < 26; i++)
			count[i] = 0;
		for (int i = 0; i < magazine.length(); i++) {
			count[magazine.charAt(i) - 'a']++;
		}
		for (int j = 0; j < ransomNote.length(); j++) {
			if (--count[ransomNote.charAt(j) - 'a'] < 0)
				return false;
		}
		return true;
	}

	public String reverseString(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution0312 s = new Solution0312();
		s.generateParenthesis(2);
	}
}
