public class Solution {
  private boolean isMatch_char(char a, char b) {
    if (b == '.')
      return true;
    if (a == b)
      return true;
    return false;
  }

  public boolean isMatch(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();
    // �Ӵ�����Ϊdp����
    boolean dp[][] = new boolean[sLen + 1][pLen + 1];
    for (int i = 1; i <= sLen; i++) {
      for (int j = 0; j <= pLen; j++) {
        dp[i][j] = false;
      }
    }
    dp[0][0] = true;
    for (int j = 2; j <= pLen; j++) {
      if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
        dp[0][j] = true;
      }
    }

    // ����ѭ��dp�����ʱ��ֻҪ��Υ��dp��������ʽ�����ԣ������������Խ����������������к�������
    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= pLen; j++) {

        if (p.charAt(j - 1) == '*') {
          boolean f = false;
          if (dp[i][j - 2] == true) {
            // 0-> p:x*$ matches s:$
            // �����base
            f = true;
          } else if (dp[i - 1][j] == true && isMatch_char(s.charAt(i - 1), p.charAt(j - 2))) {
            // more-> p:x*$ matches 1 s:x..x$
            // �����������ÿ�μ�1
            f = true;
          }
          if (f) {
            dp[i][j] = true;
          }

        } else {
          dp[i][j] = dp[i - 1][j - 1] && isMatch_char(s.charAt(i - 1), p.charAt(j - 1));
        }
      }
    }

    return dp[sLen][pLen];
  }
}
