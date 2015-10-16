public class Solution {
  private String fullJustify_space(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(' ');
    }
    return sb.toString();
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ret = new ArrayList<>();
    Deque<String> row = new ArrayDeque<>();
    for (String w : words) {
      int wordTotalLen =
          row.stream().reduce(0, (acc, e) -> acc + e.length(), (acc1, acc2) -> acc1 + acc2);
      if (row.size() + wordTotalLen + w.length() > maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (row.size() == 1) {
          sb.append(row.poll());
          if (sb.length() < maxWidth) {
            sb.append(fullJustify_space(maxWidth - sb.length()));
          }
        } else {
          int commonSpace = (maxWidth - wordTotalLen) / (row.size() - 1);
          int extraSpace = (maxWidth - wordTotalLen) % (row.size() - 1);
          while (!row.isEmpty()) {
            sb.append(row.poll());
            if (!row.isEmpty()) {
              sb.append(fullJustify_space(commonSpace));
              if (extraSpace > 0) {
                sb.append(' ');
                extraSpace--;
              }
            }
          }
        }
        ret.add(sb.toString());
        row.clear();
      }
      row.offer(w);
    }
    if (!row.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      while (!row.isEmpty()) {
        sb.append(row.poll());
        if (!row.isEmpty()) {
          sb.append(' ');
        } else {
          sb.append(fullJustify_space(maxWidth - sb.length()));
        }
      }
      ret.add(sb.toString());
    }
    return ret;
  }
}
