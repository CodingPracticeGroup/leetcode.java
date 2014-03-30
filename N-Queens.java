import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> ret = new ArrayList<String[]>();
		// initialize track
		String[] track = new String[n];
		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < n; j++) {
				sb.append('.');
			}
			track[i] = sb.toString();
		}
		// trigger recursion
		recursion(n, ret, track, -1, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
		//
		return ret;
	}

	private void recursion(int n, ArrayList<String[]> ret, String[] track, int row, HashSet<Integer> ocupiedCol,
			HashSet<Integer> ocupiedDiagPositive, HashSet<Integer> ocupiedDiagNegtive) {
		if (row == n - 1) {// found solution
			ret.add(Arrays.copyOf(track, track.length));
		} else { // continue searching
			row++; // track index
			for (int col = 0; col < n; col++) { // construct candidates
				if (!ocupiedCol.contains(col) && !ocupiedDiagPositive.contains(row + col)
						&& !ocupiedDiagNegtive.contains(row - col)) {// prune
					StringBuilder sb = new StringBuilder();
					for (int j = 0; j < n; j++) {
						sb.append('.');
					}
					sb.setCharAt(col, 'Q');
					// track forward
					String old = track[row];
					track[row] = sb.toString();
					ocupiedCol.add(col);
					ocupiedDiagPositive.add(row + col);
					ocupiedDiagNegtive.add(row - col);
					// recursion & pruning
					recursion(n, ret, track, row, ocupiedCol, ocupiedDiagPositive, ocupiedDiagNegtive);
					// track backward
					track[row] = old;
					ocupiedCol.remove(col);
					ocupiedDiagPositive.remove(row + col);
					ocupiedDiagNegtive.remove(row - col);
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Solution().solveNQueens(3);
	}

}
