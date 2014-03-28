import java.util.ArrayList;

public class Solution {
	public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> ret = new ArrayList<String>();
		StringBuilder sb = null;

		int rowStart = 0;
		int rowEnd = 1;
		int rowLen = words[rowStart].length();
		while (rowEnd <= words.length) {
			sb = new StringBuilder();
			// find rowEnd
			while (rowEnd < words.length && rowLen + words[rowEnd].length() + 1 <= L) {
				rowLen += words[rowEnd].length() + 1;
				rowEnd++;
			}
			// distribute words in row
			if (rowEnd - rowStart == 1 || rowEnd == words.length) { // put from the left: incomplete row
				for (int i = rowStart; i < rowEnd; i++) {
					sb.append(words[i]);
					if (i != rowEnd - 1)
						sb.append(' ');
				}
				int restSpaceCount = L - sb.length();
				for (int i = 0; i < restSpaceCount; i++) {
					sb.append(' ');
				}
			} else { // put from the right
				int spaceCount = L;
				for (int i = rowStart; i < rowEnd; i++) {
					spaceCount -= words[i].length();
				}
				int rightSpaceCount = spaceCount / (rowEnd - rowStart - 1);
				int leftSpaceCountDelta = spaceCount - rightSpaceCount * (rowEnd - rowStart - 1);
				for (int i = rowEnd - 1; i > rowStart + leftSpaceCountDelta; i--) {
					sb.insert(0, words[i]);
					for (int j = 0; j < rightSpaceCount; j++) {
						sb.insert(0, ' ');
					}
				}
				for (int i = rowStart + leftSpaceCountDelta; i > rowStart; i--) {
					sb.insert(0, words[i]);
					for (int j = 0; j < rightSpaceCount; j++) {
						sb.insert(0, ' ');
					}
					sb.insert(0, ' ');
				}
				sb.insert(0, words[rowStart]);
			}
			ret.add(sb.toString());
			// loop
			if (rowEnd == words.length) {
				break;
			} else {
				rowStart = rowEnd;
				rowEnd++;
				rowLen = words[rowStart].length();
			}
		}

		return ret;
	}

	public static void main(String[] args) {
		String words[] = { "Don't", "go", "around", "saying", "the", "world", "owes", "you", "a", "living;", "the",
				"world", "owes", "you", "nothing;", "it", "was", "here", "first." };

		new Solution().fullJustify(words, 30);
	}
}