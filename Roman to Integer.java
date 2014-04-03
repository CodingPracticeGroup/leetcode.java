public class Solution {
	public int romanToInt(String s) {
		int ret = 0;

		if (s.startsWith("III")) {
			ret += 3;
		} else if (s.startsWith("II")) {
			ret += 2;
		} else if (s.startsWith("IV")) {
			ret += 4;
		} else if (s.startsWith("IX")) {
			ret += 9;
		} else if (s.startsWith("I")) {
			ret += 1;
		} else if (s.startsWith("VIII")) {
			ret += 8;
		} else if (s.startsWith("VII")) {
			ret += 7;
		} else if (s.startsWith("VI")) {
			ret += 6;
		} else if (s.startsWith("V")) {
			ret += 5;
		} else if (s.startsWith("XXX")) {
			ret += 30;
			ret += romanToInt(s.substring(3, s.length()));
		} else if (s.startsWith("XX")) {
			ret += 20;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("XL")) {
			ret += 40;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("XC")) {
			ret += 90;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("X")) {
			ret += 10;
			ret += romanToInt(s.substring(1, s.length()));
		} else if (s.startsWith("LXXX")) {
			ret += 80;
			ret += romanToInt(s.substring(4, s.length()));
		} else if (s.startsWith("LXX")) {
			ret += 70;
			ret += romanToInt(s.substring(3, s.length()));
		} else if (s.startsWith("LX")) {
			ret += 60;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("L")) {
			ret += 50;
			ret += romanToInt(s.substring(1, s.length()));
		} else if (s.startsWith("CCC")) {
			ret += 300;
			ret += romanToInt(s.substring(3, s.length()));
		} else if (s.startsWith("CC")) {
			ret += 200;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("CD")) {
			ret += 400;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("CM")) {
			ret += 900;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("C")) {
			ret += 100;
			ret += romanToInt(s.substring(1, s.length()));
		} else if (s.startsWith("DCCC")) {
			ret += 800;
			ret += romanToInt(s.substring(4, s.length()));
		} else if (s.startsWith("DCC")) {
			ret += 700;
			ret += romanToInt(s.substring(3, s.length()));
		} else if (s.startsWith("DC")) {
			ret += 600;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("D")) {
			ret += 500;
			ret += romanToInt(s.substring(1, s.length()));
		} else if (s.startsWith("MMM")) {
			ret += 3000;
			ret += romanToInt(s.substring(3, s.length()));
		} else if (s.startsWith("MM")) {
			ret += 2000;
			ret += romanToInt(s.substring(2, s.length()));
		} else if (s.startsWith("M")) {
			ret += 1000;
			ret += romanToInt(s.substring(1, s.length()));
		}

		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Solution().romanToInt("MCMXCVI");
	}

}
