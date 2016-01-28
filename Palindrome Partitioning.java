public class Solution {
  private boolean partition_palindrome(String s, int start, int end) {
    if (end <= start)
      return false;
    while (start <= end - 1) {
      if (s.charAt(start) != s.charAt(end - 1)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }

  private List<List<String>> partition_range(String s, int start, int end) {
    List<List<String>> ret = new LinkedList<>();
    if (partition_palindrome(s, start, end)) {
      List<String> newlist = new LinkedList<>();
      newlist.add(0, s.substring(start, end));
      ret.add(newlist);
    }
    int len = end - start;
    for (int i = 1; i <= len; i++) {// candidates
      if (partition_palindrome(s, start, start + i)) { // prune
        List<List<String>> children = partition_range(s, start + i, end); // recusion
        for (List<String> l : children) {
          l.add(0, s.substring(start, start + i));
        }
        ret.addAll(children);
      }
    }
    return ret;
  }

  public List<List<String>> partition(String s) {
    return partition_range(s, 0, s.length());
  }
}
---------
public class Solution {
  private boolean check(String s, int len) {
    int i = 0;
    int j = len - 1;
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }

  public List<List<String>> partition(String s) {
    List<List<String>> ret = new ArrayList<>();
    if (s.length() == 0) {
      return ret;
    }
    if (check(s, s.length())) {
      List<String> l = new ArrayList<>();
      l.add(s);
      ret.add(l);
    }
    for (int len = 1; len < s.length(); len++) {
      if (check(s, len)) {
        List<List<String>> r = partition(s.substring(len));
        for (List<String> l : r) {
          l.add(0, s.substring(0, len));
          ret.add(l);
        }
      }
    }
    return ret;
  }
}
