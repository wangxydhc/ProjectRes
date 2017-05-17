package date0313;

public class Trie{
	Trie root=this;
	Trie[]node=new Trie[26]; ;	
	boolean isWord=false;
	
    public Trie() {
    }
    
    public void insert(String word) {
    	Trie temp=root;
    	for(int i=0;i<word.length();i++){
    		char c=word.charAt(i);
    		System.out.println("2"+c);
    		if(temp.node[c-'a']==null)
    		temp.node[c-'a']=new Trie();
    		if (i==word.length()-1) temp.node[c-'a'].isWord=true;
    		temp=temp.node[c-'a'];
    	}    		
    	System.out.println(root.node['a'-'a']);
    	System.out.println(root.node['a'-'a'].node['b'-'a']);
    }
    
    public boolean search(String word) {	

		Trie temp=root;
    	for(char c:word.toCharArray()){
    		System.out.println("dd:"+c);
		if(temp.node[c-'a']==null) return false;
		else temp=temp.node[c-'a'];
	}
    	if(temp.isWord==true)
    			return true;      
    	else 
    		return false;
}
    
    
    public boolean startsWith(String prefix) {
    	Trie temp=root;
    	for(char c:prefix.toCharArray()){    		
    	System.out.println("^"+c);
    		if(temp.node[c-'a']==null) 
    		{
    			System.out.println("="+c);
    			 return false;
    		}
    		else temp=temp.node[c-'a'];
    	}
    	return true;        
    }
    public static void main(String[] args) {
		Trie tree=new Trie();
		tree.insert("app");
		tree.insert("apps");
		System.out.println(tree.search("app"));
	}
}
