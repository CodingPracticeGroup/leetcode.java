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
