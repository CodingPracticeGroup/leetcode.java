public class Solution {
	public String intToRoman(int num) {
		if (1 <= num && num <= 9) {
			return one(num);
		} else if (10 <= num && num <= 99) {
			return ten(num);
		} else if (100 <= num && num <= 999) {
			return hundred(num);
		} else if (1000 <= num && num <= 3999) {
			return thousand(num);
		}
		return "";
	}

	private String one(int num) {
		int n = num / 1;
		StringBuilder sb = new StringBuilder();
		switch (n) {
		case 1:
			sb.append("I");
			break;
		case 2:
			sb.append("II");
			break;
		case 3:
			sb.append("III");
			break;
		case 4:
			sb.append("IV");
			break;
		case 5:
			sb.append("V");
			break;
		case 6:
			sb.append("VI");
			break;
		case 7:
			sb.append("VII");
			break;
		case 8:
			sb.append("VIII");
			break;
		case 9:
			sb.append("IX");
			break;
		default:
		}
		return sb.toString();
	}

	private String ten(int num) {
		int n = num / 10;
		StringBuilder sb = new StringBuilder();
		switch (n) {
		case 1:
			sb.append("X");
			break;
		case 2:
			sb.append("XX");
			break;
		case 3:
			sb.append("XXX");
			break;
		case 4:
			sb.append("XL");
			break;
		case 5:
			sb.append("L");
			break;
		case 6:
			sb.append("LX");
			break;
		case 7:
			sb.append("LXX");
			break;
		case 8:
			sb.append("LXXX");
			break;
		case 9:
			sb.append("XC");
			break;
		default:
		}
		sb.append(one(num % 10));
		return sb.toString();
	}

	private String hundred(int num) {
		int n = num / 100;
		StringBuilder sb = new StringBuilder();
		switch (n) {
		case 1:
			sb.append("C");
			break;
		case 2:
			sb.append("CC");
			break;
		case 3:
			sb.append("CCC");
			break;
		case 4:
			sb.append("CD");
			break;
		case 5:
			sb.append("D");
			break;
		case 6:
			sb.append("DC");
			break;
		case 7:
			sb.append("DCC");
			break;
		case 8:
			sb.append("DCCC");
			break;
		case 9:
			sb.append("CM");
			break;
		default:
		}
		sb.append(ten(num % 100));
		return sb.toString();
	}

	private String thousand(int num) {
		int n = num / 1000;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append("M");
		}
		sb.append(hundred(num % 1000));
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
