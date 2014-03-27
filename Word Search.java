public class Solution {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int start, int x, int y) {
		if (start + 1 == word.length()) {
			if (board[x][y] == word.charAt(start)) {
				return true;
			} else {
				return false;
			}
		}

		if (board[x][y] != word.charAt(start)) {
			return false;
		}

		char cache = board[x][y];
		board[x][y] = '+'; // this is cheating
		if (0 <= x - 1 && dfs(board, word, start + 1, x - 1, y)) {
			board[x][y] = cache;
			return true;
		} else if (x + 1 < board.length && dfs(board, word, start + 1, x + 1, y)) {
			board[x][y] = cache;
			return true;
		} else if (0 <= y - 1 && dfs(board, word, start + 1, x, y - 1)) {
			board[x][y] = cache;
			return true;
		} else if (y + 1 < board[0].length && dfs(board, word, start + 1, x, y + 1)) {
			board[x][y] = cache;
			return true;
		}
		board[x][y] = cache;
		return false;
	}
}