public class Solution {
  private boolean numberToWords_0(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '0')
        return false;
    }
    return true;
  }

  private void numberToWords_1to9(char c, StringBuilder sb) {
    switch (c) {
      case '1':
        sb.append(" One ");
        break;
      case '2':
        sb.append(" Two ");
        break;
      case '3':
        sb.append(" Three ");
        break;
      case '4':
        sb.append(" Four ");
        break;
      case '5':
        sb.append(" Five ");
        break;
      case '6':
        sb.append(" Six ");
        break;
      case '7':
        sb.append(" Seven ");
        break;
      case '8':
        sb.append(" Eight ");
        break;
      case '9':
        sb.append(" Nine ");
        break;
    }
  }

  private void numberToWords_1to9ty(char c, StringBuilder sb) {
    switch (c) {
      case '1':
        sb.append(" Ten ");
        break;
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
  }

  private String numberToWords_3(String s) {
    StringBuilder sb = new StringBuilder();
    if (numberToWords_0(s))
      return sb.toString();
    if (s.charAt(0) != '0') {
      numberToWords_1to9(s.charAt(0), sb);
      sb.append(" Hundred ");
    }
    if (s.charAt(1) != '0' && s.charAt(2) != '0') {
      if (s.charAt(1) == '1') {
        switch (s.charAt(2)) {
          case '1':
            sb.append(" Eleven ");
            break;
          case '2':
            sb.append(" Twelve ");
            break;
          case '3':
            sb.append(" Thirteen ");
            break;
          case '4':
            sb.append(" Fourteen ");
            break;
          case '5':
            sb.append(" Fifteen ");
            break;
          case '6':
            sb.append(" Sixteen ");
            break;
          case '7':
            sb.append(" Seventeen ");
            break;
          case '8':
            sb.append(" Eighteen ");
            break;
          case '9':
            sb.append(" Nineteen ");
            break;
        }
      } else {
        numberToWords_1to9ty(s.charAt(1), sb);
        numberToWords_1to9(s.charAt(2), sb);
      }
    } else if (s.charAt(1) != '0') {
      numberToWords_1to9ty(s.charAt(1), sb);
    } else if (s.charAt(2) != '0') {
      numberToWords_1to9(s.charAt(2), sb);
    }
    return sb.toString();
  }

  public String numberToWords(int num) {
    if (num == 0)
      return "Zero";
    String nn = String.valueOf(num);
    if (nn.length() % 3 != 0) {
      StringBuilder nnn = new StringBuilder(nn);
      for (int i = 0; i < 3 - nn.length() % 3; i++) {
        nnn.insert(0, '0');
      }
      nn = nnn.toString();
    }
    StringBuilder ret = new StringBuilder();
    for (int i = 0; i < nn.length(); i += 3) {
      String ss = numberToWords_3(nn.substring(i, i + 3));
      if (!ss.equals("")) {
        ret.append(ss);
        if ((nn.length() - i - 3) / 3 == 1) {
          ret.append(" Thousand ");
        } else if ((nn.length() - i - 3) / 3 == 2) {
          ret.append(" Million  ");
        } else if ((nn.length() - i - 3) / 3 == 3) {
          ret.append(" Billion  ");
        }
      }
    }
    return ret.toString().replaceAll("\\s+", " ").trim();
  }
}
---------------
public class Solution {
  private String tostr(int n) {
    if (n == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    if (n >= 100) {
      switch (n / 100) {
        case 1:
          sb.append("One");
          break;
        case 2:
          sb.append("Two");
          break;
        case 3:
          sb.append("Three");
          break;
        case 4:
          sb.append("Four");
          break;
        case 5:
          sb.append("Five");
          break;
        case 6:
          sb.append("Six");
          break;
        case 7:
          sb.append("Seven");
          break;
        case 8:
          sb.append("Eight");
          break;
        case 9:
          sb.append("Nine");
          break;
      }
      sb.append(" Hundred ");
      n %= 100;
    }
    if (n >= 10 && n < 20) {
      switch (n) {
        case 10:
          sb.append("Ten");
          break;
        case 11:
          sb.append("Eleven");
          break;
        case 12:
          sb.append("Twelve");
          break;
        case 13:
          sb.append("Thirteen");
          break;
        case 14:
          sb.append("Fourteen");
          break;
        case 15:
          sb.append("Fifteen");
          break;
        case 16:
          sb.append("Sixteen");
          break;
        case 17:
          sb.append("Seventeen");
          break;
        case 18:
          sb.append("Eighteen");
          break;
        case 19:
          sb.append("Nineteen");
          break;
      }
      return sb.toString();
    }
    if (n >= 20) {
      switch (n / 10) {
        case 2:
          sb.append("Twenty ");
          break;
        case 3:
          sb.append("Thirty ");
          break;
        case 4:
          sb.append("Forty ");
          break;
        case 5:
          sb.append("Fifty ");
          break;
        case 6:
          sb.append("Sixty ");
          break;
        case 7:
          sb.append("Seventy ");
          break;
        case 8:
          sb.append("Eighty ");
          break;
        case 9:
          sb.append("Ninety ");
          break;
      }
      n %= 10;
    }
    switch (n) {
      case 1:
        sb.append("One");
        break;
      case 2:
        sb.append("Two");
        break;
      case 3:
        sb.append("Three");
        break;
      case 4:
        sb.append("Four");
        break;
      case 5:
        sb.append("Five");
        break;
      case 6:
        sb.append("Six");
        break;
      case 7:
        sb.append("Seven");
        break;
      case 8:
        sb.append("Eight");
        break;
      case 9:
        sb.append("Nine");
        break;
    }
    return sb.toString().replaceAll("\\s+", " ").trim();
  }

  public String numberToWords(int num) {
    String s = String.valueOf(num);
    LinkedList<Integer> l = new LinkedList<>();
    int last = s.length();
    for (int i = s.length() - 3; i > -3; i -= 3) {
      l.offerFirst(Integer.parseInt(s.substring(Math.max(0, i), last)));
      last = i;
    }
    StringBuilder sb = new StringBuilder();
    String[] h =
        new String[] {"", " Thousand ", " Million ", " Billion ", " X ", " XX ", " XXX ", " XXXX "};
    int idx = 0;
    while (!l.isEmpty()) {
      String str = tostr(l.pollLast());
      if (!str.equals("")) {
        sb.insert(0, h[idx]);
        sb.insert(0, str);
      }
      idx++;
    }
    String ret = sb.toString().replaceAll("\\s+", " ").trim();
    if (ret.equals("")) {
      return "Zero";
    }
    return ret;
  }
}
--------------
public class Solution {
  private final String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
      "Seventeen", "Eighteen", "Nineteen"};
  private final String[] tens =
      {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] thousands = {"", "Thousand", "Million", "Billion"};

  public String numberToWords(int num) {
    if (num == 0)
      return "Zero";
    int i = 0;
    String words = "";

    while (num > 0) {
      if (num % 1000 != 0)
        words = helper(num % 1000) + thousands[i] + " " + words;
      num /= 1000;
      i++;
    }

    return words.trim();
  }

  private String helper(int num) {
    if (num == 0)
      return "";
    else if (num < 20)
      return lessThan20[num] + " ";
    else if (num < 100)
      return tens[num / 10] + " " + helper(num % 10);
    else
      return lessThan20[num / 100] + " Hundred " + helper(num % 100);
  }
}
