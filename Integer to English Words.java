public class Solution {
  private String numberToWords_3(String str) {
    StringBuilder sb = new StringBuilder();
    int len = str.length();
    if (len - 3 >= 0)
      switch (str.charAt(len - 3)) {
        case '1':
          sb.append("One Hundred");
          break;
        case '2':
          sb.append("Two Hundred");
          break;
        case '3':
          sb.append("Three Hundred");
          break;
        case '4':
          sb.append("Four Hundred");
          break;
        case '5':
          sb.append("Five Hundred");
          break;
        case '6':
          sb.append("Six Hundred");
          break;
        case '7':
          sb.append("Seven Hundred");
          break;
        case '8':
          sb.append("Eight Hundred");
          break;
        case '9':
          sb.append("Nine Hundred");
          break;
      }
    if (len - 2 >= 0)
      switch (str.charAt(len - 2)) {
        case '2':
          sb.append(" Twenty ");
          break;
        case '3':
          sb.append(" Thirty ");
          break;
        case '4':
          sb.append(" Forty ");
          break;
        case '5':
          sb.append(" Fifty ");
          break;
        case '6':
          sb.append(" Sixty ");
          break;
        case '7':
          sb.append(" Seventy ");
          break;
        case '8':
          sb.append(" Eighty ");
          break;
        case '9':
          sb.append(" Ninety ");
          break;
      }
    if (len - 2 >= 0 && str.charAt(len - 2) == '1') {
      switch (str.charAt(len - 1)) {
        case '0':
          sb.append(" Ten");
          break;
        case '1':
          sb.append(" Eleven");
          break;
        case '2':
          sb.append(" Twelve");
          break;
        case '3':
          sb.append(" Thirteen");
          break;
        case '4':
          sb.append(" Fourteen");
          break;
        case '5':
          sb.append(" Fifteen");
          break;
        case '6':
          sb.append(" Sixteen");
          break;
        case '7':
          sb.append(" Seventeen");
          break;
        case '8':
          sb.append(" Eighteen");
          break;
        case '9':
          sb.append(" Nineteen");
          break;
      }
    } else {
      switch (str.charAt(len - 1)) {
        case '1':
          sb.append(" One");
          break;
        case '2':
          sb.append(" Two");
          break;
        case '3':
          sb.append(" Three");
          break;
        case '4':
          sb.append(" Four");
          break;
        case '5':
          sb.append(" Five");
          break;
        case '6':
          sb.append(" Six");
          break;
        case '7':
          sb.append(" Seven");
          break;
        case '8':
          sb.append(" Eight");
          break;
        case '9':
          sb.append(" Nine");
          break;
      }
    }
    return sb.toString();
  }

  public String numberToWords(int num) {
    String numstr = String.valueOf(num);
    if (numstr.equals("0"))
      return "Zero";
    Deque<String> numsplit = new ArrayDeque<>();
    int i = numstr.length() - 3;
    for (; i >= 0; i -= 3) {
      numsplit.offerFirst(numstr.substring(i, i + 3));
    }
    if (i + 3 > 0)
      numsplit.offerFirst(numstr.substring(0, i + 3));
    Deque<String> unit = new ArrayDeque<>();
    unit.offerFirst(" ");
    unit.offerFirst(" Thousand ");
    unit.offerFirst(" Million ");
    unit.offerFirst(" Billion ");
    StringBuilder sb = new StringBuilder();
    while (!numsplit.isEmpty()) {
      String t = numberToWords_3(numsplit.pollLast());
      if (t.trim().length() > 0)
        sb.insert(0, unit.pollLast());
      else
        unit.pollLast();
      sb.insert(0, t);
    }
    return sb.toString().trim().replaceAll(" +", " ");
  }
}
