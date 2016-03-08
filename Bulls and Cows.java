public class Solution {
  public String getHint(String secret, String guess) {
    int s[] = new int[10];
    Arrays.fill(s, 0);
    int g[] = new int[10];
    Arrays.fill(g, 0);
    int len = secret.length();
    int A = 0;
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        A++;
      } else {
        s[secret.charAt(i) - '0']++;
        g[guess.charAt(i) - '0']++;
      }
    }
    int B = 0;
    for (int i = 0; i <= 9; i++) {
      B += Math.min(s[i], g[i]);
    }
    return A + "A" + B + "B";
  }

  private Map<Character, Integer> charCount(String s, Set<Integer> tabuIdx) {
    Map<Character, Integer> ret = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (!tabuIdx.contains(i)) {
        char c = s.charAt(i);
        if (!ret.containsKey(c)) {
          ret.put(c, 0);
        }
        ret.put(c, ret.get(c) + 1);
      }
    }
    return ret;
  }

  public String getHint_(String secret, String guess) {
    Set<Integer> bull_idx = new HashSet<>();
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull_idx.add(i);
      }
    }
    Map<Character, Integer> s_ = charCount(secret, bull_idx);
    Map<Character, Integer> g_ = charCount(guess, bull_idx);
    int cow = 0;
    for (Character c : s_.keySet()) {
      if (g_.containsKey(c)) {
        cow += Math.min(s_.get(c), g_.get(c));
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(bull_idx.size());
    sb.append('A');
    sb.append(cow);
    sb.append('B');
    return sb.toString();
  }

  public String getHint__(String secret, String guess) {
    int len = secret.length();
    Set<Integer> A = new HashSet<>();
    for (int i = 0; i < len; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        A.add(i);
      }
    }
    Map<Character, Long> s_ = IntStream.range(0, len).filter(x -> !A.contains(x))
        .mapToObj(x -> Character.valueOf(secret.charAt(x)))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Character, Long> g_ = IntStream.range(0, len).filter(x -> !A.contains(x))
        .mapToObj(x -> Character.valueOf(guess.charAt(x)))
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    int cow = 0;
    for (Character c : s_.keySet()) {
      if (g_.containsKey(c)) {
        cow += Math.min(s_.get(c), g_.get(c));
      }
    }
    return A.size() + "A" + cow + "B";
  }
}
-----------------
public class Solution {
  public String getHint(String secret, String guess) {
    Map<Integer, Long> ss = secret.chars().map(x -> x - '0').boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Map<Integer, Long> gg = guess.chars().map(x -> x - '0').boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    int cows = 0;
    for (int i = 0; i <= 9; i++) {
      if (ss.containsKey(i) && gg.containsKey(i)) {
        cows += Math.min(ss.get(i), gg.get(i));
      }
    }
    int bull = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        cows--;
        bull++;
      }
    }
    return "" + bull + "A" + cows + "B";
  }
}
