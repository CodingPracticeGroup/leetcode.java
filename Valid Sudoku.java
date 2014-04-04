public class Solution {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] check = new int[9];
			for (int j = 0; j < 9; j++) {
				if ('0' < board[i][j] && board[i][j] <= '9' && check[board[i][j] - '1'] == 1) {
					return false;
				} else {
					if ('0' < board[i][j] && board[i][j] <= '9') {
						check[board[i][j] - '1'] = 1;
					}
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			int[] check = new int[9];
			for (int j = 0; j < 9; j++) {
				if ('0' < board[j][i] && board[j][i] <= '9' && check[board[j][i] - '1'] == 1) {
					return false;
				} else {
					if ('0' < board[j][i] && board[j][i] <= '9') {
						check[board[j][i] - '1'] = 1;
					}
				}
			}
		}
		if (!checkSubBox(board, 1, 1)) {
			return false;
		}
		if (!checkSubBox(board, 1, 4)) {
			return false;
		}
		if (!checkSubBox(board, 1, 7)) {
			return false;
		}
		if (!checkSubBox(board, 4, 1)) {
			return false;
		}
		if (!checkSubBox(board, 4, 4)) {
			return false;
		}
		if (!checkSubBox(board, 4, 7)) {
			return false;
		}
		if (!checkSubBox(board, 7, 1)) {
			return false;
		}
		if (!checkSubBox(board, 7, 4)) {
			return false;
		}
		if (!checkSubBox(board, 7, 7)) {
			return false;
		}
		return true;
	}

	private boolean checkSubBox(char[][] board, int i, int j) {
		int[] check = new int[9];
		if ('0' < board[i - 1][j - 1] && board[i - 1][j - 1] <= '9' && check[board[i - 1][j - 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i - 1][j - 1] && board[i - 1][j - 1] <= '9') {
				check[board[i - 1][j - 1] - '1'] = 1;
			}
		}
		if ('0' < board[i - 1][j] && board[i - 1][j] <= '9' && check[board[i - 1][j] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i - 1][j] && board[i - 1][j] <= '9') {
				check[board[i - 1][j] - '1'] = 1;
			}
		}
		if ('0' < board[i - 1][j + 1] && board[i - 1][j + 1] <= '9' && check[board[i - 1][j + 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i - 1][j + 1] && board[i - 1][j + 1] <= '9') {
				check[board[i - 1][j + 1] - '1'] = 1;
			}
		}
		if ('0' < board[i][j - 1] && board[i][j - 1] <= '9' && check[board[i][j - 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i][j - 1] && board[i][j - 1] <= '9') {
				check[board[i][j - 1] - '1'] = 1;
			}
		}
		if ('0' < board[i][j] && board[i][j] <= '9' && check[board[i][j] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i][j] && board[i][j] <= '9') {
				check[board[i][j] - '1'] = 1;
			}
		}
		if ('0' < board[i][j + 1] && board[i][j + 1] <= '9' && check[board[i][j + 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i][j + 1] && board[i][j + 1] <= '9') {
				check[board[i][j + 1] - '1'] = 1;
			}
		}
		if ('0' < board[i + 1][j - 1] && board[i + 1][j - 1] <= '9' && check[board[i + 1][j - 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i + 1][j - 1] && board[i + 1][j - 1] <= '9') {
				check[board[i + 1][j - 1] - '1'] = 1;
			}
		}
		if ('0' < board[i + 1][j] && board[i + 1][j] <= '9' && check[board[i + 1][j] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i + 1][j] && board[i + 1][j] <= '9') {
				check[board[i + 1][j] - '1'] = 1;
			}
		}
		if ('0' < board[i + 1][j + 1] && board[i + 1][j + 1] <= '9' && check[board[i + 1][j + 1] - '1'] == 1) {
			return false;
		} else {
			if ('0' < board[i + 1][j + 1] && board[i + 1][j + 1] <= '9') {
				check[board[i + 1][j + 1] - '1'] = 1;
			}
		}
		return true;
	}
}