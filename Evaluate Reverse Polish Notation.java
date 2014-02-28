import java.util.ArrayDeque;

public class Solution {
	public static int evalRPN(String[] tokens) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>(tokens.length);
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 + operand2);
			} else if (tokens[i].equals("-")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 - operand2);
			} else if (tokens[i].equals("*")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 * operand2);
			} else if (tokens[i].equals("/")) {
				int operand2 = stack.pollLast();
				int operand1 = stack.pollLast();
				stack.offerLast(operand1 / operand2);
			} else {
				stack.offerLast(Integer.valueOf(tokens[i]));
			}
		}
		return stack.pollLast();
	}

	public static void main(String[] args) {
		String[] expr = new String[5];
		expr[0] = "2";
		expr[1] = "1";
		expr[2] = "+";
		expr[3] = "3";
		expr[4] = "*";
		int r = evalRPN(expr);
	}
}