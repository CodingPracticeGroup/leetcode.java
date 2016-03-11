public class Solution {
  char idx(String a, String b, int idx) {
    if (idx < a.length()) {
      return a.charAt(idx);
    } else {
      return b.charAt(idx - a.length());
    }
  }

  boolean is(String a, String b) {
    int i = 0;
    int j = a.length() + b.length() - 1;
    while (i < j) {
      if (idx(a, b, i) != idx(a, b, j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ret = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j && is(words[i], words[j])) {
          List<Integer> l = new ArrayList<>();
          l.add(i);
          l.add(j);
          ret.add(l);
        }
      }
    }
    return ret;
  }
}
