import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
  public int maxProduct__(String[] words) {
    Map<Character, Set<String>> a2z = new HashMap<>();
    for (char c = 'a'; c <= 'z'; c++) {
      a2z.put(c, new HashSet<String>());
    }
    for (String w : words) {
      for (int i = 0; i < w.length(); i++) {
        a2z.get(w.charAt(i)).add(w);
      }
    }
    int max = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        boolean share = false;
        for (char c = 'a'; c <= 'z'; c++) {
          Set<String> s = a2z.get(c);
          if (s.contains(words[i]) && s.contains(words[j])) {
            share = true;
            break;
          }
        }
        if (!share) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }

  public int maxProduct_(String[] words) {
    Map<Character, Set<Integer>> cs = new HashMap<>(); // char idx_set
    for (char c = 'a'; c <= 'z'; c++) {
      cs.put(c, new HashSet<Integer>());
    }
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        char c = words[i].charAt(j);
        cs.get(c).add(i);
      }
    }

    int ret = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        boolean b = true;
        for (char c = 'a'; c <= 'z'; c++) {
          Set<Integer> s = cs.get(c);
          if (s.contains(i) && s.contains(j)) {
            b = false;
            break;
          }
        }
        if (b) {
          ret = Math.max(ret, words[i].length() * words[j].length());
        }
      }
    }
    return ret;
  }

  public int maxProduct(String[] words) {
    int[] k = new int[words.length];
    Arrays.fill(k, 0);
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        k[i] |= 1 << (words[i].charAt(j) - 'a');
      }
    }

    int ret = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((k[i] & k[j]) == 0) {
          ret = Math.max(ret, words[i].length() * words[j].length());
        }
      }
    }
    return ret;
  }
}
---------------
public class Solution {
  public int maxProduct(String[] words) {
    int[] e = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      int[] idx = words[i].chars().map(x -> x - 'a').distinct().toArray();
      for (int j : idx) {
        e[i] |= 1 << j;
      }
    }
    int ret = 0;
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if ((e[i] & e[j]) == 0) {
          ret = Math.max(ret, words[i].length() * words[j].length());
        }
      }
    }
    return ret;
  }
}
