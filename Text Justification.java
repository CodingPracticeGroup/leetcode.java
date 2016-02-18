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
-------------
public class Solution {
  private StringBuilder fj(LinkedList<String> line, int maxWidth, int wc) {
    StringBuilder sb = new StringBuilder(line.pollFirst());
    if (!line.isEmpty()) {
      int space1 = (maxWidth - wc) / line.size();
      int space2 = space1 + 1;
      int count2 = (maxWidth - wc) - space1 * line.size();
      int count1 = line.size() - count2;
      while (!line.isEmpty()) {
        if (count2 > 0) {
          for (int i = 0; i < space2; i++) {
            sb.append(' ');
          }
          count2--;
        } else {
          for (int i = 0; i < space1; i++) {
            sb.append(' ');
          }
        }
        sb.append(line.pollFirst());
      }
    } else {
      while (sb.length() < maxWidth) {
        sb.append(' ');
      }
    }
    return sb;
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ret = new ArrayList<>();
    LinkedList<String> line = new LinkedList<>();

    for (String w : words) {
      int wc = line.stream().mapToInt(x -> x.length()).sum();
      if (!line.isEmpty() && !(wc + line.size() + w.length() <= maxWidth)) {
        StringBuilder sb = fj(line, maxWidth, wc);
        ret.add(sb.toString());
        line.clear();
      }
      line.offerLast(w);
    }

    StringBuilder sb = new StringBuilder(line.pollFirst());
    while (!line.isEmpty()) {
      sb.append(' ');
      sb.append(line.pollFirst());
    }
    while (sb.length() < maxWidth) {
      sb.append(' ');
    }
    ret.add(sb.toString());

    return ret;
  }
}
