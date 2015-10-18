import java.util.Arrays;

public class Solution {
  private int[] isScramble_dictionary_arr = new int[128];

  private boolean isScramble_dictionary(String s1, int s1start, int s1end, String s2, int s2start,
      int s2end) {
    if (s1end - s1start != s2end - s2start)
      return false;
    Arrays.fill(isScramble_dictionary_arr, 0);
    for (int i = s1start; i < s1end; i++) {
      isScramble_dictionary_arr[s1.charAt(i)]++;
    }
    for (int i = s2start; i < s2end; i++) {
      isScramble_dictionary_arr[s2.charAt(i)]--;
      if (isScramble_dictionary_arr[s2.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isScramble_dfs(String s1, int s1start, int s1end, String s2, int s2start,
      int s2end) {
    if (isScramble_dictionary(s1, s1start, s1end, s2, s2start, s2end)) {
      if (s1.substring(s1start, s1end).equals(s2.substring(s2start, s2end))) {
        return true;
      }
      int len = s1end - s1start;
      for (int i = 1; i <= len - 1; i++) { // i is s1 left substring length
        if (isScramble_dfs(s1, s1start, s1start + i, s2, s2end - i, s2end)
            && isScramble_dfs(s1, s1start + i, s1end, s2, s2start, s2end - i)) {
          return true;
        }
        if (isScramble_dfs(s1, s1start, s1start + i, s2, s2start, s2start + i)
            && isScramble_dfs(s1, s1start + i, s1end, s2, s2start + i, s2end)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isScramble(String s1, String s2) {
    return isScramble_dfs(s1, 0, s1.length(), s2, 0, s2.length());
  }
}
