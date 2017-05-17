package action;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Word;
import test.TestClass;
import tools.Factory;
public class ShowWords {
	private int nums;

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}
	public void start(){
		Factory.beforeclass();
		Session s=Factory.getSessionFactory().openSession();
	Transaction tx=s.beginTransaction();
	Word [] res=new Word[nums];
	for(int i=0;i<nums;i++)
		res[i]=(Word)s.get(Word.class, i++);
	tx.commit();
	
	for(int i=0;i<nums;i++){
		if (res[i]!=null)
		System.out.println(i+" "+res[i].getWord());
		else
			System.out.println(i);
	}
	s.close();
	}

	public static void main(String [] args){
		ShowWords sw=new ShowWords();
		sw.setNums(39);
		TestClass tc=new TestClass();
		
		sw.start();
	}
}
