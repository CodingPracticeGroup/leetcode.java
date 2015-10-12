import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ret = new ArrayList<>();

    int word_len = words[0].length();
    int window_len = word_len * words.length;

    Map<String, Long> words_count =
        Arrays.stream(words).collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (int j = 0; j < word_len && j + window_len <= s.length(); j++) {
      List<String> window_words = new ArrayList<>();
      for (int i = j; i < j + window_len; i += word_len) {
        window_words.add(s.substring(i, i + word_len));
      }
      Map<String, Long> window_words_count =
          window_words.stream().collect(
              Collectors.groupingBy(Function.identity(), Collectors.counting()));

      if (window_words_count.equals(words_count)) {
        ret.add(j);
      }
      for (int i = j + word_len; i <= s.length() - window_len; i += word_len) {
        String add = s.substring(i + window_len - word_len, i + window_len);
        if (window_words_count.containsKey(add)) {
          window_words_count.put(add, window_words_count.get(add) + 1);
        } else {
          window_words_count.put(add, 1L);
        }

        String remove = s.substring(i - word_len, i);
        if (window_words_count.get(remove) == 1) {
          window_words_count.remove(remove);
        } else {
          window_words_count.put(remove, window_words_count.get(remove) - 1);
        }

        if (window_words_count.equals(words_count)) {
          ret.add(i);
        }
      }
    }

    return ret;
  }
}
