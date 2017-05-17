package date0313;

import java.util.Iterator;
import java.util.Stack;

public class MinStack {
	Stack<Long> stack;
	long min;
	public MinStack() {
		stack = new Stack<Long>();
	}
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push((long)0);
			min = x;
		} else {
			stack.push((long)(x - min));
			if (x < min) {
				min = x;
			}
		}
	}
	public void pop() {
		long i = stack.pop();
		if (i < 0)
			min = min - i;
	}
	public long top() {
		long i = stack.peek();
		if (i < 0) {
			return min;
		} else
			return i + min;
	}
	public long getMin() {
		return min;
	}
}
