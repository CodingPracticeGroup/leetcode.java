public class Solution {
	public boolean isNumber(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len = s.length();
		if (len == 0)
			return false;

		if (s.indexOf(".") != s.lastIndexOf("."))
			return false;
		if (s.indexOf("e") != s.lastIndexOf("e"))
			return false;
		if (s.indexOf("E") != s.lastIndexOf("E"))
			return false;

		if (s.indexOf("e") >= 0)
			return checkE(s, "e");
		else if (s.indexOf("E") >= 0)
			return checkE(s, "E");
		else if (s.indexOf(".") >= 0)
			return checkDot(s);
		else
			return checkNormal(s);

	}

	boolean checkE(String s, String e) {
		String[] ss = s.split(e);
		if (ss.length == 2 && !ss[0].equals("") && !ss[1].equals(""))
			return checkLeft(ss[0]) && checkEright(ss[1]);
		else
			return false;
	}

	boolean checkEright(String s) {
		if (s.indexOf("+") == s.lastIndexOf("+") && s.indexOf("+") >= 0) {
			return s.matches("\\+\\d+\\s*");
		} else if (s.indexOf("-") == s.lastIndexOf("-") && s.indexOf("-") >= 0) {
			return s.matches("\\-\\d+\\s*");
		} else {
			return s.matches("\\d+\\s*");
		}
	}

	boolean checkDot(String s) {
		String[] ss = s.split("\\.");
		if (ss.length == 2) {
			if (ss[1].equals(""))
				return checkLeft(ss[0]);
			else if (ss[0].equals(""))
				return ss[1].matches("\\d+\\s*");
			else {
				if (ss[0].indexOf("+") == ss[0].lastIndexOf("+") && ss[0].indexOf("+") >= 0) {
					return s.matches("\\s*\\+\\d+.\\d*\\s*") || s.matches("\\s*\\+\\d*.\\d+\\s*");
				} else if (ss[0].indexOf("-") == ss[0].lastIndexOf("-") && ss[0].indexOf("-") >= 0) {
					return s.matches("\\s*\\-\\d+.\\d*\\s*") || s.matches("\\s*\\-\\d*.\\d+\\s*");
				} else {
					return s.matches("\\s*\\d+.\\d*\\s*") || s.matches("\\s*\\d*.\\d+\\s*");
				}
			}
		} else if (ss.length == 1) {
			if (s.indexOf("+") == s.lastIndexOf("+") && s.indexOf("+") >= 0) {
				return s.matches("\\s*\\+\\d+.");
			} else if (s.indexOf("-") == s.lastIndexOf("-") && s.indexOf("-") >= 0) {
				return s.matches("\\s*\\-\\d+.");
			} else {
				return s.matches("\\s*\\d+.");
			}
		} else
			return false;
	}

	boolean checkLeft(String s) {
		if (s.indexOf(".") == s.lastIndexOf(".") && s.indexOf(".") >= 0) {
			String[] ss = s.split("\\.");
			if (ss.length == 2) {
				if (ss[1].equals("")) {
					if (ss[0].indexOf("+") == ss[0].lastIndexOf("+") && ss[0].indexOf("+") >= 0) {
						return ss[0].matches("\\s*\\+\\d+");
					} else if (ss[0].indexOf("-") == ss[0].lastIndexOf("-") && ss[0].indexOf("-") >= 0) {
						return ss[0].matches("\\s*\\-\\d+");
					} else {
						return ss[0].matches("\\s*\\d+");
					}
				} else if (ss[0].equals(""))
					return ss[1].matches("\\d+");
				else {
					if (ss[0].indexOf("+") == ss[0].lastIndexOf("+") && ss[0].indexOf("+") >= 0) {
						return s.matches("\\s*\\+\\d+.\\d*") || s.matches("\\s*\\+\\d*.\\d+");
					} else if (ss[0].indexOf("-") == ss[0].lastIndexOf("-") && ss[0].indexOf("-") >= 0) {
						return s.matches("\\s*\\-\\d+.\\d*") || s.matches("\\s*\\-\\d*.\\d+");
					} else {
						return s.matches("\\s*\\d+.\\d*") || s.matches("\\s*\\d*.\\d+");
					}
				}
			} else if (ss.length == 1) {
				if (s.indexOf("+") == s.lastIndexOf("+") && s.indexOf("+") >= 0) {
					return s.matches("\\s*\\+\\d+.");
				} else if (s.indexOf("-") == s.lastIndexOf("-") && s.indexOf("-") >= 0) {
					return s.matches("\\s*\\-\\d+.");
				} else {
					return s.matches("\\s*\\d+.");
				}
			} else
				return false;
		} else {
			if (s.indexOf("+") == s.lastIndexOf("+") && s.indexOf("+") >= 0) {
				return s.matches("\\s*\\+\\d+");
			} else if (s.indexOf("-") == s.lastIndexOf("-") && s.indexOf("-") >= 0) {
				return s.matches("\\s*\\-\\d+");
			} else {
				return s.matches("\\s*\\d+");
			}
		}
	}

	boolean checkNormal(String s) {
		if (s.indexOf("+") == s.lastIndexOf("+") && s.indexOf("+") >= 0) {
			return s.matches("\\s*\\+\\d+\\s*");
		} else if (s.indexOf("-") == s.lastIndexOf("-") && s.indexOf("-") >= 0) {
			return s.matches("\\s*\\-\\d+\\s*");
		} else {
			return s.matches("\\s*\\d+\\s*");
		}
	}
}