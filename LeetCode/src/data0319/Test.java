package data0319;

import java.util.Iterator;
import java.util.Stack;



public class Test {
	Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		Test t = new Test();
		t.stack.push(1);
		t.stack.push(2);
		Iterator<Integer> n=t.stack.iterator();
		while (n.hasNext())
			System.out.println((n.next()));
	}
}
