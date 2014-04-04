public class Solution {
	public String convert(String s, int nRows) {
		if (nRows == 1) {
			return s;
		}
		int nCols = s.length();
		char[][] table = new char[nRows][nCols];
		int x = 0, y = 0;
		boolean down = true;
		for (int i = 0; i < s.length(); i++) {
			table[x][y] = s.charAt(i);
			if (down) {
				if (x == nRows - 1) {
					x--;
					y++;
					down = false;
				} else {
					x++;
				}
			} else {
				if (x == 0) {
					x++;
					down = true;
				} else {
					y++;
					x--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (table[i][j] != 0) {
					sb.append(table[i][j]);
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		new Solution().convert("AB", 1);
	}
}