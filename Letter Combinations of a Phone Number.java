import java.util.ArrayList;

public class Solution {
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> ret = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			ret.add("");
			return ret;
		}
		char firstDigit = digits.charAt(0);
		ArrayList<String> tmp = letterCombinations(digits.substring(1, digits.length()));
		switch (firstDigit) {
		case '2':
			for (String s : tmp) {
				ret.add("a" + s);
				ret.add("b" + s);
				ret.add("c" + s);
			}
			break;
		case '3':
			for (String s : tmp) {
				ret.add("d" + s);
				ret.add("e" + s);
				ret.add("f" + s);
			}
			break;
		case '4':
			for (String s : tmp) {
				ret.add("g" + s);
				ret.add("h" + s);
				ret.add("i" + s);
			}
			break;
		case '5':
			for (String s : tmp) {
				ret.add("j" + s);
				ret.add("k" + s);
				ret.add("l" + s);
			}
			break;
		case '6':
			for (String s : tmp) {
				ret.add("m" + s);
				ret.add("n" + s);
				ret.add("o" + s);
			}
			break;
		case '7':
			for (String s : tmp) {
				ret.add("p" + s);
				ret.add("q" + s);
				ret.add("r" + s);
				ret.add("s" + s);
			}
			break;
		case '8':
			for (String s : tmp) {
				ret.add("t" + s);
				ret.add("u" + s);
				ret.add("v" + s);
			}
			break;
		case '9':
			for (String s : tmp) {
				ret.add("w" + s);
				ret.add("x" + s);
				ret.add("y" + s);
				ret.add("z" + s);
			}
			break;
		default:
		}
		return ret;
	}

	public static void main(String[] args) {
		new Solution().letterCombinations("2");
	}
}