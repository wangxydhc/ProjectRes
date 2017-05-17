package action;

import java.util.Random;

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

	public void start() {
		Factory.beforeclass();
		Session s = Factory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		Word[] res = new Word[nums];
		Random rd = new Random();
		int id = rd.nextInt(2000)+1;
		int i = 0;
		while (nums-- > 0) {
			res[i] = (Word) s.get(Word.class, id);
			if (res[i] != null)
				System.out.println("id: " + id + "      i: " + i
						+ "      word:  " + res[i].getWord()
						+ "           pre: " + res[i].getParaphrase());
			else
				System.out.println("&&&&&&&&&&&&&&&&"+id);
			id = rd.nextInt(2000);
			i++;
		}
		tx.commit();
		s.close();
	}

	public static void main(String[] args) {
		ShowWords sw = new ShowWords();
		sw.setNums(500);
		sw.start();
	}
}
