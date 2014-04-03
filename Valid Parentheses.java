import java.util.ArrayDeque;

public class Solution {
	public boolean isValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				stack.push(c);
				break;
			case '[':
				stack.push(c);
				break;
			case '{':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			default:
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}