package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Comparator;


public class Solution {
  /*
   * Text Justification
   */

  public List<String> fullJustify(String[] words, int L) {
    ArrayList<ArrayList<String>> tmp = putInLines(words, L);
    return justifyLines(tmp, L);
  }

  private ArrayList<ArrayList<String>> putInLines(String[] words, int L) {
    ArrayList<ArrayList<String>> tmp = new ArrayList<ArrayList<String>>();
    ArrayList<String> row = new ArrayList<String>();
    int rowLen = 0;
    for (int i = 0; i < words.length; i++) {
      int expectLen = rowLen == 0 ? rowLen + words[i].length() : rowLen + words[i].length() + 1;
      if (expectLen <= L) {
        row.add(words[i]);
        rowLen = expectLen;
      } else {
        tmp.add(row);
        row = new ArrayList<String>();
        row.add(words[i]);
        rowLen = words[i].length();
      }
    }
    if (row.size() > 0) {
      tmp.add(row);
    }
    return tmp;
  }

  private List<String> justifyLines(ArrayList<ArrayList<String>> tmp, int L) {
    ArrayList<String> ret = new ArrayList<String>();

    for (int ii = 0; ii < tmp.size() - 1; ii++) {
      ArrayList<String> al = tmp.get(ii);
      int spaceNum = al.size() - 1;
      if (spaceNum == 0) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < L - al.get(0).length()) {
          sb.append(" ");
        }
        ret.add(al.get(0) + sb.toString());
      } else {
        int spaceSlot[] = new int[spaceNum];
        for (int i = 0; i < spaceNum; i++) {
          spaceSlot[i] = 1;
        }
        int wordsLen = 0;
        for (String s : al) {
          wordsLen += s.length();
        }
        int expectSpace = spaceNum;
        int idx = -1;
        while (wordsLen + expectSpace < L) {
          spaceSlot[(++idx) % spaceNum]++;
          expectSpace++;
        }

        idx = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : al) {
          sb.append(s);
          if (idx < spaceNum) {
            StringBuilder sb2 = new StringBuilder();
            while (sb2.length() < spaceSlot[idx]) {
              sb2.append(" ");
            }
            sb.append(sb2.toString());
            idx++;
          }
        }
        ret.add(sb.toString());
      }
    }

    //
    ArrayList<String> al = tmp.get(tmp.size() - 1);
    int idx = 0;
    StringBuilder sb = new StringBuilder();
    for (String s : al) {
      sb.append(s);
      if (idx < al.size() - 1) {
        sb.append(" ");
        idx++;
      }
    }
    while (sb.length() < L) {
      sb.append(" ");
    }
    ret.add(sb.toString());

    //
    return ret;
  }

  /*
   * Plus One
   */

  public int[] plusOne(int[] digits) {
    reverseArray(digits);
    int carry = 1;
    for (int i = 0; i < digits.length; i++) {
      int tmp = digits[i] + carry;
      digits[i] = tmp % 10;
      carry = tmp / 10;
    }
    reverseArray(digits);
    if (carry == 0) {
      return digits;
    } else {
      int[] ret = new int[digits.length + 1];
      ret[0] = carry;
      for (int i = 0; i < digits.length; i++) {
        ret[i + 1] = digits[i];
      }
      return ret;
    }
  }

  private void reverseArray(int[] digits) {
    for (int i = 0; i < digits.length / 2; i++) {
      int tmp = digits[i];
      digits[i] = digits[digits.length - i - 1];
      digits[digits.length - i - 1] = tmp;
    }
  }

  /*
   * Valid Number
   */

  public boolean isNumber(String s) {
    int p = 0;
    // 1 & 9
    s = s.trim();
    // 2
    if (p < s.length() && (s.charAt(p) == '+' || s.charAt(p) == '-')) {
      p++;
    }
    // 3
    int n1 = 0;
    while (p + n1 < s.length() && '0' <= s.charAt(p + n1) && s.charAt(p + n1) <= '9') {
      n1++;
    }
    p = p + n1;
    // 4
    if (p < s.length() && s.charAt(p) == '.') {
      p++;
    }
    // 5
    int n2 = 0;
    while (p + n2 < s.length() && '0' <= s.charAt(p + n2) && s.charAt(p + n2) <= '9') {
      n2++;
    }
    p = p + n2;
    // 6
    if (n1 + n2 == 0) {
      return false;
    }
    // 7
    if (p < s.length() && (s.charAt(p) == 'e' || s.charAt(p) == 'E')) {
      p++;
      // 8
      // .2
      if (p < s.length() && (s.charAt(p) == '+' || s.charAt(p) == '-')) {
        p++;
      }
      // .3
      n1 = 0;
      while (p + n1 < s.length() && '0' <= s.charAt(p + n1) && s.charAt(p + n1) <= '9') {
        n1++;
      }
      p = p + n1;
      // 8
      if (n1 == 0) {
        return false;
      }
    }
    // 10
    return p == s.length();
  }

  /*
   * Add Binary
   */

  public String addBinary(String a, String b) {
    StringBuilder aa = new StringBuilder(a).reverse();
    StringBuilder bb = new StringBuilder(b).reverse();
    while (bb.length() < aa.length()) {
      bb.append("0");
    }
    while (aa.length() < bb.length()) {
      aa.append("0");
    }
    //
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for (int i = 0; i < aa.length(); i++) {
      int tmp = (aa.charAt(i) - '0') + (bb.charAt(i) - '0') + carry;
      sb.append(tmp % 2);
      carry = tmp / 2;
    }
    if (carry > 0)
      sb.append(1);
    return sb.reverse().toString();
  }

  /*
   * Merge Two Sorted Lists
   */

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    //
    ListNode retHead;
    ListNode pCurrent;
    if (l1.val < l2.val) {
      retHead = l1;
      pCurrent = l1;
      l1 = l1.next;
    } else {
      retHead = l2;
      pCurrent = l2;
      l2 = l2.next;
    }
    //
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        pCurrent.next = l1;
        pCurrent = l1;
        l1 = l1.next;
      } else {
        pCurrent.next = l2;
        pCurrent = l2;
        l2 = l2.next;
      }
    }
    //
    if (l1 != null)
      pCurrent.next = l1;
    if (l2 != null)
      pCurrent.next = l2;
    return retHead;
  }

  /*
   * Minimum Path Sum
   */

  public int minPathSum(int[][] grid) {
    int dp[][] = new int[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];
    //
    for (int i = 1; i < grid[0].length; i++) {
      dp[0][i] = dp[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < grid.length; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    //
    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[grid.length - 1][grid[0].length - 1];
  }

  /*
   * Unique Paths II
   */

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid[0][0] == 1) {
      return 0;
    }
    //
    obstacleGrid[0][0] = -1;
    for (int i = 1; i < obstacleGrid.length; i++) {
      if (obstacleGrid[i][0] == 0) {
        obstacleGrid[i][0] = obstacleGrid[i - 1][0];
      } else {
        break;
      }
    }
    for (int i = 1; i < obstacleGrid[0].length; i++) {
      if (obstacleGrid[0][i] == 0) {
        obstacleGrid[0][i] = obstacleGrid[0][i - 1];
      } else {
        break;
      }
    }
    //
    for (int i = 1; i < obstacleGrid.length; i++) {
      for (int j = 1; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 0) {
          obstacleGrid[i][j] =
              Math.min(0, obstacleGrid[i - 1][j]) + Math.min(0, obstacleGrid[i][j - 1]);
        }
      }
    }
    //
    if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] > 0) {
      return 0;
    } else {
      return -obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
  }

  /*
   * Unique Paths
   */

  public int uniquePaths(int m, int n) {
    int dp[][] = new int[m][n];
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    //
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  /*
   * Rotate List
   */

  public ListNode rotateRight(ListNode head, int n) {
    int length = 0;
    ListNode pCount = head;
    while (pCount != null) {
      pCount = pCount.next;
      length++;
    }
    //
    if (length == 0) {
      return head;
    }
    n = n % length;
    if (n == 0) {
      return head;
    }
    //
    ListNode p1 = head;
    ListNode p2 = head;
    for (int i = 0; i < n; i++) {
      p2 = p2.next;
    }
    //
    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    //
    ListNode retHead = p1.next;
    p2.next = head;
    p1.next = null;
    return retHead;
  }

  /*
   * Permutation Sequence
   */

  public String getPermutation(int n, int k) {
    ArrayList<Integer> pool = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      pool.add(i);
    }

    int[] jiechen = new int[n + 1];
    jiechen[0] = 1;
    for (int i = 1; i <= n; i++) {
      jiechen[i] = jiechen[i - 1] * i;
    }

    StringBuilder sb = new StringBuilder();
    k--;
    while (n > 0) {
      int idx = k / jiechen[n - 1];
      sb.append(pool.get(idx));
      pool.remove(idx);
      k = k % jiechen[n - 1];
      n--;
    }

    return sb.toString();
  }

  /*
   * Spiral Matrix II
   */

  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int out = 1;
    int round = 0;
    do {
      out = fillOneRound(matrix, n, round++, out);
    } while (out <= n * n);
    return matrix;
  }

  private int fillOneRound(int[][] matrix, int n, int round, int start) {
    for (int i = round; i <= n - round - 1; i++) {
      matrix[round][i] = start++;
    }
    for (int i = round + 1; i <= n - round - 1; i++) {
      matrix[i][n - round - 1] = start++;
    }
    for (int i = n - round - 2; i >= round; i--) {
      matrix[n - round - 1][i] = start++;
    }
    for (int i = n - round - 2; i > round; i--) {
      matrix[i][round] = start++;
    }
    return start;
  }

  /*
   * Length of Last Word
   */

  public int lengthOfLastWord(String s) {
    String ss = s.trim();
    if (ss.length() == 0)
      return 0;

    int p1 = ss.length() - 1;
    while (p1 >= 0 && ss.charAt(p1) != ' ') {
      p1--;
    }
    return ss.length() - p1 - 1;
  }

  /*
   * Insert Interval
   */

  public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    if (intervals.isEmpty()) {
      intervals.add(newInterval);
      return intervals;
    }
    if (newInterval.end < intervals.get(0).start) {
      intervals.add(0, newInterval);
      return intervals;
    } else if (newInterval.start > intervals.get(intervals.size() - 1).end) {
      intervals.add(newInterval);
      return intervals;
    }

    int p1 = -1, p2 = intervals.size();
    for (int i = 0; i < intervals.size(); i++) {
      if (p1 == -1 && newInterval.start <= intervals.get(i).end) {
        p1 = i;
      }
      if (p2 == intervals.size() && newInterval.end < intervals.get(i).start) {
        p2 = i;
      }
    }

    ArrayList<Interval> ret = new ArrayList<Interval>();
    if (p1 >= p2) {
      ret.addAll(intervals.subList(0, p1));
      ret.add(newInterval);
      ret.addAll(intervals.subList(p2, intervals.size()));
    } else {
      ret.addAll(intervals.subList(0, p1));
      newInterval.start = Math.min(newInterval.start, intervals.get(p1).start);
      newInterval.end = Math.max(newInterval.end, intervals.get(p2 - 1).end);
      ret.add(newInterval);
      ret.addAll(intervals.subList(p2, intervals.size()));
    }
    return ret;
  }

  /*
   * Merge Intervals
   */

  public List<Interval> merge(List<Interval> intervals) {
    if (intervals.size() < 2) {
      return intervals;
    }

    Collections.sort(intervals, new Comparator<Interval>() { // List.sort() in java8
          public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
          }
        });

    int p1 = 0;
    int p2 = 1;
    while (p2 < intervals.size()) {
      if (intervals.get(p2).start <= intervals.get(p1).end) {
        intervals.get(p1).end = Math.max(intervals.get(p1).end, intervals.get(p2).end);
      } else {
        p1++;
        intervals.get(p1).start = intervals.get(p2).start;
        intervals.get(p1).end = intervals.get(p2).end;
      }
      p2++;
    }

    return intervals.subList(0, p1 + 1);
  }

  /*
   * Jump Game
   */

  public boolean canJump(int[] A) {
    int i = 0;
    int j = i + A[0];
    while (i < A.length - 1) {
      int tmp = i;
      for (int k = i; k < A.length && k <= j; k++) {
        tmp = Math.max(tmp, k + A[k]);
      }
      if (tmp < A.length - 1 && tmp == j) {
        return false;
      }
      i = j;
      j = tmp;
    }
    return true;
  }

  /*
   * Spiral Matrix
   */

  public List<Integer> spiralOrder(int[][] matrix) {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    int rowcount = matrix.length;
    if (rowcount == 0) {
      return ret;
    }
    int colcount = matrix[0].length;
    if (colcount == 0) {
      return ret;
    }
    int roundmax = Math.min(rowcount / 2 + rowcount % 2, colcount / 2 + colcount % 2);
    for (int i = 0; i < roundmax; i++) {
      ret.addAll(oneRound(matrix, i, rowcount, colcount));
    }
    return ret;
  }

  private List<Integer> oneRound(int[][] matrix, int round, int rowcount, int colcount) {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    for (int i = round; i <= colcount - round - 1; i++) {
      ret.add(matrix[round][i]);
    }
    for (int i = round + 1; i <= rowcount - round - 1; i++) {
      ret.add(matrix[i][colcount - round - 1]);
    }
    if (rowcount - round - 1 != round) {
      for (int i = colcount - round - 2; i >= round; i--) {
        ret.add(matrix[rowcount - round - 1][i]);
      }
    }
    if (colcount - round - 1 != round) {
      for (int i = rowcount - round - 2; i > round; i--) {
        ret.add(matrix[i][round]);
      }
    }
    return ret;
  }

  /*
   * Maximum Subarray
   */

  public int maxSubArray(int[] A) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < A.length; i++) {
      sum += A[i];
      max = Math.max(max, sum);
      sum = Math.max(0, sum); // if sum<0, we dont keep it
    }
    return max;
  }

  /*
   * N-Queens II
   */

  public int totalNQueens(int n) {
    int[] ret = new int[] {0};
    char[][] chess = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chess[i][j] = '.';
      }
    }
    dfsNQ(chess, n, ret, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    return ret[0];
  }

  private void dfsNQ(char[][] track, int n, int[] ret, int row, HashSet<Integer> colMemory,
      HashSet<Integer> diagMemory, HashSet<Integer> diag2Memory) {
    if (row == n) {
      ret[0]++;
      return;
    }
    for (int i = 0; i < n; i++) { // explore
      track[row][i] = 'Q'; // forward
      if (!colMemory.contains(i) && !diagMemory.contains(row - i) && !diag2Memory.contains(row + i)) {
        colMemory.add(i);
        diagMemory.add(row - i);
        diag2Memory.add(row + i);
        dfsNQ(track, n, ret, row + 1, colMemory, diagMemory, diag2Memory);
        colMemory.remove(i);
        diagMemory.remove(row - i);
        diag2Memory.remove(row + i);
      }
      track[row][i] = '.'; // backward
    }
  }

  /*
   * N-Queens
   */

  public List<String[]> solveNQueens(int n) {
    ArrayList<String[]> ret = new ArrayList<String[]>();
    char[][] chess = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        chess[i][j] = '.';
      }
    }
    dfsNQ(chess, n, ret, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    return ret;
  }

  private void dfsNQ(char[][] track, int n, List<String[]> ret, int row,
      HashSet<Integer> colMemory, HashSet<Integer> diagMemory, HashSet<Integer> diag2Memory) {
    if (row == n) {
      String[] rows = new String[n];
      for (int i = 0; i < n; i++) {
        rows[i] = new String(track[i]);
      }
      ret.add(rows);
      return;
    }
    for (int i = 0; i < n; i++) { // explore
      track[row][i] = 'Q'; // forward
      if (!colMemory.contains(i) && !diagMemory.contains(row - i) && !diag2Memory.contains(row + i)) {
        colMemory.add(i);
        diagMemory.add(row - i);
        diag2Memory.add(row + i);
        dfsNQ(track, n, ret, row + 1, colMemory, diagMemory, diag2Memory);
        colMemory.remove(i);
        diagMemory.remove(row - i);
        diag2Memory.remove(row + i);
      }
      track[row][i] = '.'; // backward
    }
  }

  /*
   * Pow(x, n)
   */

  public double pow(double x, int n) {
    if (n >= 0) {
      return powP(x, n);
    } else {
      return 1 / powP(x, -n);
    }
  }

  public double powP(double x, int n) {
    if (n == 0) {
      return 1;
    }

    int half = n / 2;
    double xx = powP(x, half);
    xx *= xx;

    if (n % 2 == 1) {
      xx *= x;
    }

    return xx;
  }

  /*
   * Anagrams
   */

  public List<String> anagrams(String[] strs) {
    ArrayList<String> ret = new ArrayList<String>();
    HashMap<String, String> memory = new HashMap<String, String>(); // digest, original
    for (int i = 0; i < strs.length; i++) {
      String s = strs[i];
      char[] ca = s.toCharArray();
      Arrays.sort(ca);
      String ss = new String(ca);
      if (memory.containsKey(ss)) {
        ret.add(s);
        if (memory.get(ss) != null) {
          ret.add(memory.get(ss));
          memory.put(ss, null);
        }
      } else {
        memory.put(ss, s);
      }
    }
    return ret;
  }

  /*
   * Rotate Image
   */

  public void rotate(int[][] matrix) {
    flip1(matrix);
    flip2(matrix);
  }

  private void flip1(int[][] matrix) { // \
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i + 1; j < matrix.length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

  private void flip2(int[][] matrix) { // |
    for (int i = 0; i < matrix.length; i++) {
      for (int j = matrix.length / 2; j < matrix.length; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - j - 1];
        matrix[i][matrix.length - j - 1] = tmp;
      }
    }
  }

  /*
   * Permutations II
   */

  public List<List<Integer>> permuteUnique(int[] num) {
    Arrays.sort(num);
    ArrayDeque<Integer> track = new ArrayDeque<Integer>();
    ArrayList<Integer> num2 = new ArrayList<Integer>();
    for (int i = 0; i < num.length; i++) {
      num2.add(num[i]);
    }
    HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
    dfsTrack(track, ret, num2);
    return new ArrayList<List<Integer>>(ret);
  }

  private void dfsTrack(ArrayDeque<Integer> track, HashSet<List<Integer>> ret,
      ArrayList<Integer> num) {
    if (num.isEmpty()) {
      ret.add(new ArrayList<Integer>(track));
    } else {
      int last = num.get(0) - 1;
      for (int i = 0; i < num.size(); i++) {
        int n = num.get(i);
        if (n != last) {
          last = n;
          track.push(n);
          num.remove(i);
          dfsTrack(track, ret, num);
          num.add(i, track.pop());
        }
      }
    }
  }

  /*
   * Permutations
   */

  public List<List<Integer>> permute(int[] num) {
    HashSet<Integer> numIdxSet = new HashSet<Integer>();
    for (int i = 0; i < num.length; i++) {
      numIdxSet.add(i);
    }
    return recusivePermute(numIdxSet, num);
  }

  private List<List<Integer>> recusivePermute(HashSet<Integer> numIdxSet, int[] num) {
    if (numIdxSet.size() == 1) {
      ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
      ArrayList<Integer> one = new ArrayList<Integer>();
      one.add(num[numIdxSet.iterator().next()]);
      ret.add(one);
      return ret;
    }
    ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
    for (Iterator<Integer> it = numIdxSet.iterator(); it.hasNext();) {
      int idx = it.next();
      HashSet<Integer> numIdxSetSub = deepClone(numIdxSet);
      numIdxSetSub.remove(idx);
      List<List<Integer>> subRet = recusivePermute(numIdxSetSub, num);
      for (Iterator<List<Integer>> it2 = subRet.iterator(); it2.hasNext();) {
        List<Integer> sub = it2.next();
        sub.add(num[idx]);
        ret.add(sub);
      }
    }
    return ret;
  }

  private HashSet<Integer> deepClone(HashSet<Integer> in) {
    HashSet<Integer> ret = new HashSet<Integer>();
    for (Iterator<Integer> it = in.iterator(); it.hasNext();) {
      int i = it.next();
      ret.add(new Integer(i));
    }
    return ret;
  }

  /*
   * Jump Game II
   */

  public int jump(int[] A) {
    int count = 0;
    int idx = 0;
    int jump = idx + A[0];
    while (idx < A.length - 1) {
      count++;

      int tmp = 0;
      for (int i = idx; i < A.length && i <= jump; i++) {
        tmp = Math.max(tmp, i + A[i]);
      }
      idx = jump;
      jump = tmp;
    }
    return count;
  }

  /*
   * Wildcard Matching
   */

  public boolean isWildcardMatch(String s, String p) {
    int i = 0;
    int j = 0;
    int star = -1;
    int mark = -1;
    while (i < s.length()) {
      if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        ++i;
        ++j;
      } else if (j < p.length() && p.charAt(j) == '*') { // last *, override multiple *
        star = j++;
        mark = i;
      } else if (star != -1) {
        j = star + 1;
        i = ++mark;
      } else {
        return false;
      }
    }
    while (j < p.length() && p.charAt(j) == '*') {
      ++j;
    }
    return j == p.length();
  }

  /*
   * Multiply Strings
   */

  public String multiply(String num1, String num2) {
    char[] num1array = new StringBuilder(num1).reverse().toString().toCharArray();
    for (int i = 0; i < num1array.length; i++) {
      num1array[i] -= '0';
    }
    char[] num2array = new StringBuilder(num2).reverse().toString().toCharArray();
    for (int i = 0; i < num2array.length; i++) {
      num2array[i] -= '0';
    }
    //
    char[] ret = new char[num1array.length + num2array.length + 1];
    for (int i = 0; i < num2array.length; i++) {
      char carry = 0;
      for (int j = 0; j < num1array.length; j++) {
        int tmp = num1array[j] * num2array[i] + carry;
        ret[i + j] += tmp % 10;
        carry = (char) (tmp / 10);
      }
      if (carry > 0) {
        ret[num1array.length + i] = carry;
      }
    }

    char carry = 0;
    for (int i = 0; i < ret.length; i++) {
      ret[i] += carry;
      carry = (char) (ret[i] / 10);
      ret[i] %= 10;
      ret[i] += '0';
    }
    //
    String retStr = new StringBuilder(new String(ret)).reverse().toString();
    for (int i = 0; i < retStr.length(); i++) {
      if (retStr.charAt(i) != '0') {
        return retStr.substring(i);
      }
    }
    return "0";
  }

  /*
   * Trapping Rain Water
   */

  public int trap(int[] A) {
    int[] left2right = new int[A.length]; // trapped by left
    int max = 0;
    for (int i = 0; i < A.length; i++) {
      max = Math.max(max, A[i]);
      left2right[i] = max - A[i];
    }
    int[] right2left = new int[A.length]; // trapped by right
    max = 0;
    for (int i = A.length - 1; i >= 0; i--) {
      max = Math.max(max, A[i]);
      right2left[i] = max - A[i];
    }
    int sum = 0;
    for (int i = 0; i < A.length; i++) {
      sum += Math.min(left2right[i], right2left[i]);
    }
    return sum;
  }

  /*
   * First Missing Positive
   */

  public int firstMissingPositive(int[] A) {
    int idx = 0;
    while (idx < A.length) {
      if (0 < A[idx] && A[idx] <= A.length) {
        if (idx == A[idx] - 1) {
          idx++;
        } else {
          if (A[idx] == A[A[idx] - 1]) {
            A[idx] = 0;
            idx++;
          } else {
            swapInArray(A, idx, A[idx] - 1);
          }
        }
      } else {
        A[idx] = 0;
        idx++;
      }
    }
    for (idx = 0; idx < A.length; idx++) {
      if (A[idx] - 1 != idx) {
        return idx + 1;
      }
    }
    return idx + 1;
  }

  /*
   * Combination Sum II
   */

  public List<List<Integer>> combinationSum2(int[] num, int target) {
    HashSet<List<Integer>> ret = new HashSet<List<Integer>>();
    ArrayList<Integer> track = new ArrayList<Integer>();
    combinationSum2Recursion(num, target, track, ret);
    return new ArrayList<List<Integer>>(ret);
  }

  private void combinationSum2Recursion(int[] num, int target, ArrayList<Integer> track,
      HashSet<List<Integer>> ret) {
    int sum = 0;
    for (Integer e : track) {
      sum += e;
    }
    if (sum > target) {
      return;
    }
    for (int i = 0; i < num.length; i++) {
      if (num[i] > 0) {
        track.add(num[i]);
        num[i] = -1;
        //
        if (sum + track.get(track.size() - 1) == target) {
          @SuppressWarnings("unchecked")
          ArrayList<Integer> sort = (ArrayList<Integer>) track.clone();
          Collections.sort(sort);
          ret.add(sort);
        } else if (sum + track.get(track.size() - 1) < target) {
          combinationSum2Recursion(num, target, track, ret);
        }
        //
        num[i] = track.remove(track.size() - 1);
      }
    }
  }

  /*
   * Combination Sum
   */

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> ret = new HashSet<List<Integer>>();
    ArrayList<Integer> track = new ArrayList<Integer>();
    combinationSumRecursion(candidates, target, track, ret);
    return new ArrayList<List<Integer>>(ret);
  }

  private void combinationSumRecursion(int[] candidates, int target, ArrayList<Integer> track,
      Set<List<Integer>> ret) {
    for (int i = 0; i < candidates.length; i++) {
      track.add(candidates[i]);
      int sum = 0;
      for (Integer e : track) {
        sum += e;
      }
      if (sum == target) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer> sort = (ArrayList<Integer>) track.clone();
        Collections.sort(sort);
        ret.add(sort);
      } else if (sum < target) {
        combinationSumRecursion(candidates, target, track, ret);
      }
      track.remove(track.size() - 1);
    }
  }

  /*
   * Count and Say
   */

  public String countAndSay(int n) {
    String ret = "1";
    for (int i = 1; i < n; i++) {
      ret = countAndSayStr(ret);
    }
    return ret;
  }

  private String countAndSayStr(String s) {
    StringBuilder sb = new StringBuilder();
    int i = 0, j = 1;
    while (j <= s.length()) {
      while (j < s.length() && s.charAt(i) == s.charAt(j)) {
        j++;
      }
      sb.append(j - i);
      sb.append(s.charAt(i));
      //
      i = j;
      j = i + 1;
    }
    return sb.toString();
  }

  /*
   * Sudoku Solver
   */

  public void solveSudoku(char[][] board) {
    solveSudokuRecursion(board, 0, 0);
  }

  private boolean solveSudokuRecursion(char[][] board, int startR, int startC) {
    if (isValidSudoku(board, startR, startC) == false) {
      return false;
    }
    for (int i = startR; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          for (char k = '1'; k <= '9'; k++) {
            board[i][j] = k;
            if (solveSudokuRecursion(board, i, j) == true) {
              return true;
            }
          }
          board[i][j] = '.';
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidSudoku(char[][] board, int r, int c) {
    Map<Character, Integer> pool = new HashMap<Character, Integer>();
    if (isValidSudokuRow(board, r, pool) == false) {
      return false;
    }
    if (isValidSudokuCol(board, c, pool) == false) {
      return false;
    }
    if (isValidSudokuSubBox(board, r / 3 * 3 + 1, c / 3 * 3 + 1, pool) == false) {
      return false;
    }
    return true;
  }

  /*
   * Valid Sudoku
   */

  public boolean isValidSudoku(char[][] board) {
    Map<Character, Integer> pool = new HashMap<Character, Integer>();
    for (int i = 0; i < 9; i++) {
      if (isValidSudokuRow(board, i, pool) == false) {
        return false;
      }
    }
    for (int i = 0; i < 9; i++) {
      if (isValidSudokuCol(board, i, pool) == false) {
        return false;
      }
    }
    for (int i = 1; i < 9; i += 3) {
      for (int j = 1; j < 9; j += 3) {
        if (isValidSudokuSubBox(board, i, j, pool) == false) {
          return false;
        }
      }
    }
    return true;
  }

  private void isValidSudokuResetPool(Map<Character, Integer> pool) {
    for (char i = '1'; i <= '9'; i++) {
      pool.put(i, 1);
    }
  }

  private boolean isValidSudokuRow(char[][] board, int r, Map<Character, Integer> pool) {
    isValidSudokuResetPool(pool);
    for (int i = 0; i < 9; i++) {
      if (board[r][i] != '.') {
        if (pool.get(board[r][i]) == 1) {
          pool.put(board[r][i], 0);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidSudokuCol(char[][] board, int c, Map<Character, Integer> pool) {
    isValidSudokuResetPool(pool);
    for (int i = 0; i < 9; i++) {
      if (board[i][c] != '.') {
        if (pool.get(board[i][c]) == 1) {
          pool.put(board[i][c], 0);
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValidSudokuSubBox(char[][] board, int r, int c, Map<Character, Integer> pool) {
    isValidSudokuResetPool(pool);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[(r - 1) + i][(c - 1) + j] != '.') {
          if (pool.get(board[(r - 1) + i][(c - 1) + j]) == 1) {
            pool.put(board[(r - 1) + i][(c - 1) + j], 0);
          } else {
            return false;
          }
        }
      }
    }
    return true;
  }

  /*
   * Search Insert Position
   */

  public int searchInsert(int[] A, int target) {
    int low = 0, high = A.length - 1, mid = -1;
    while (low <= high) {
      mid = (low + high) / 2;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        low = mid + 1;
      } else if (A[mid] > target) {
        high = mid - 1;
      }
    }
    if (low == mid + 1) {
      return low;
    } else if (high == mid - 1) {
      return mid;
    }
    return -1;
  }

  /*
   * Search for a Range
   */

  public int[] searchRange(int[] A, int target) {
    int mid = -1;
    int low = 0, high = A.length - 1;
    while (low <= high) {
      mid = (low + high) / 2;
      if (A[mid] == target) {
        break;
      } else if (target < A[mid]) {
        high = mid - 1;
      } else if (A[mid] < target) {
        low = mid + 1;
      }
    }
    if (A[mid] != target) {
      return new int[] {-1, -1};
    }

    int left = -1;
    low = 0;
    high = mid;
    while (low <= high) {
      left = (low + high) / 2;
      if (A[left] == target) {
        high = left - 1;
      } else if (A[left] < target) {
        low = left + 1;
      }
    }
    if (A[left] != A[mid]) {
      left = left + 1;
    }

    int right = -1;
    low = mid;
    high = A.length - 1;
    while (low <= high) {
      right = (low + high) / 2;
      if (A[right] == target) {
        low = right + 1;
      } else if (target < A[right]) {
        high = right - 1;
      }
    }
    if (A[right] != A[mid]) {
      right = right - 1;
    }

    return new int[] {left, right};
  }

  /*
   * Search in Rotated Sorted Array
   */

  public int search(int[] A, int target) {
    int low = 0, high = A.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] <= A[high]) {
        if (A[mid] <= target && target <= A[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      } else if (A[low] <= A[mid]) {
        if (A[low] <= target && target <= A[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return -1;
  }

  /*
   * Longest Valid Parentheses
   */

  public int longestValidParentheses(String s) {
    // left to right
    int ret = 0;
    Deque<Character> stack = new ArrayDeque<Character>();
    int pieceLen = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.addFirst(c);
        pieceLen++;
      } else if (c == ')') {
        if (!stack.isEmpty() && stack.peekFirst() == '(') {
          stack.removeFirst();
          pieceLen++;
          if (stack.isEmpty())
            ret = Math.max(ret, pieceLen);
        } else {
          pieceLen = 0;
          stack.clear();
        }
      }
    }
    // right to left
    int ret2 = 0;
    stack.clear();
    pieceLen = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c == ')') {
        stack.addFirst(c);
        pieceLen++;
      } else if (c == '(') {
        if (!stack.isEmpty() && stack.peekFirst() == ')') {
          stack.removeFirst();
          pieceLen++;
          if (stack.isEmpty())
            ret2 = Math.max(ret2, pieceLen);
        } else {
          pieceLen = 0;
          stack.clear();
        }
      }
    }
    //
    return Math.max(ret, ret2);
  }

  /*
   * Next Permutation
   */

  public void nextPermutation(int[] num) {
    int i = num.length - 2;
    while (i >= 0 && num[i] >= num[i + 1]) {
      i--;
    }
    if (i < 0) {
      for (int j = 0; j < num.length / 2; j++) {
        swapInArray(num, j, (num.length - 1) - j);
      }
      return;
    }

    int j = i + 1;
    for (int k = i + 1; k < num.length; k++) {
      if (num[k] > num[i] && num[k] < num[j]) {
        j = k;
      }
    }

    swapInArray(num, i, j);

    Arrays.sort(num, i + 1, num.length);
  }

  private void swapInArray(int[] num, int i, int j) {
    int temp = num[i];
    num[i] = num[j];
    num[j] = temp;
  }

  /*
   * Substring with Concatenation of All Words
   */

  public List<Integer> findSubstring(String S, String[] L) {
    int len = L[0].length();

    Map<String, Integer> pool = new HashMap<String, Integer>();

    List<Integer> ret = new ArrayList<Integer>();
    for (int i = 0; i <= S.length() - len * L.length; i++) {
      resetPool(pool, L);
      if (checkL(pool, S, i, len, L.length)) {
        ret.add(i);
      }
    }
    return ret;
  }

  private void resetPool(Map<String, Integer> pool, String[] L) {
    for (String str : L) {
      pool.put(str, 0);
    }
    for (String str : L) {
      pool.put(str, pool.get(str) + 1);
    }
  }

  private boolean checkL(Map<String, Integer> pool, String S, int idx, int len, int size) {
    for (int i = 0; i < size; i++) {
      String piece = S.substring(idx, idx + len);
      Integer val = pool.get(piece);
      if (val != null) {
        if (val == 1) {
          pool.remove(piece);
        } else {
          pool.put(piece, val - 1);
        }
      } else {
        return false;
      }
      idx += len;
    }
    return true;
  }

  /*
   * Divide Two Integers
   */

  public int divide(int dividend, int divisor) {
    long ldividend = dividend;
    long ldivisor = divisor;
    ldividend = Math.abs(ldividend);
    ldivisor = Math.abs(ldivisor);

    int ret = 0;
    while (ldividend >= ldivisor) {
      int i = 0;
      while (ldividend >= (ldivisor << i)) {
        i++;
      }

      ldividend = ldividend - (ldivisor << (i - 1));
      ret = ret + (1 << (i - 1));
    }

    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
      return -ret;
    else
      return ret;
  }

  /*
   * Implement strStr()
   */

  public String strStr(String haystack, String needle) {
    if (haystack.equals(needle)) {
      return haystack;
    }
    for (int i = 0; i < haystack.length() - needle.length(); i++) {
      if (needle.equals(haystack.substring(i, i + needle.length()))) {
        return haystack.substring(i);
      }
    }
    return null;
  }

  /*
   * Remove Element
   */

  public int removeElement(int[] A, int elem) {
    int head = 0, tail = A.length - 1;
    while (head <= tail) {
      if (A[head] == elem) {
        while (tail >= head && A[tail] == elem) {
          tail--;
        }
        if (tail < head) {
          return head;
        } else {
          A[head] = A[tail];
          A[tail] = elem;
        }
      }
      head++;
    }
    return head;
  }

  /*
   * Remove Duplicates from Sorted Array
   */

  public int removeDuplicates(int[] A) {
    if (A.length < 2) {
      return A.length;
    }
    int insertPoint = 1;
    while (insertPoint < A.length && A[insertPoint - 1] != A[insertPoint]) {
      insertPoint++;
    }
    int scanPoint = insertPoint + 1;
    while (scanPoint < A.length) {
      if (A[insertPoint - 1] != A[scanPoint]) {
        A[insertPoint++] = A[scanPoint++];
      } else {
        scanPoint++;
      }
    }
    return insertPoint;
  }

  /*
   * Reverse Nodes in k-Group
   */

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k < 2) {
      return head;
    }
    ListNode ret = new ListNode(0);
    ret.next = head;
    ListNode prevHead = ret;
    while (true) {
      ListNode postTail = prevHead;
      for (int i = 0; i <= k; i++) {
        if (postTail != null) {
          postTail = postTail.next;
        } else {
          return ret.next;
        }
      }
      prevHead = reverseSegment(prevHead, postTail);
    }
  }

  private ListNode reverseSegment(ListNode prevHead, ListNode postTail) {
    ListNode ret = prevHead.next;
    ListNode p1 = prevHead.next, p2 = p1.next, p3 = p2.next;
    p1.next = postTail;
    while (true) {
      p2.next = p1;

      p1 = p2;
      p2 = p3;
      if (p3 != postTail) {
        p3 = p3.next;
      } else {
        break;
      }
    }
    prevHead.next = p1;
    return ret;
  }

  /*
   * Swap Nodes in Pairs
   */

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode preHead = new ListNode(0);
    preHead.next = head;

    ListNode p0 = preHead, p1 = p0.next, p2 = p1.next;
    while (p2 != null) {
      p1.next = p2.next;
      p2.next = p1;
      p0.next = p2;
      //
      p0 = p1;
      p1 = p0.next;
      if (p1 != null) {
        p2 = p1.next;
      } else {
        p2 = null;
      }
    }

    return preHead.next;
  }

  /*
   * Merge k Sorted Lists
   */

  public ListNode mergeKLists(final List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }

    Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });
    for (ListNode ln : lists) {
      if (ln != null) {
        heap.offer(ln);
      }
    }

    ListNode retHead = new ListNode(0);
    ListNode p = retHead;
    while (!heap.isEmpty()) {
      p.next = heap.poll();
      p = p.next;
      if (p.next != null) {
        heap.offer(p.next);
      }
    }

    return retHead.next;
  }

  /*
   * Generate Parentheses
   */

  public List<String> generateParenthesis(int n) {
    if (n == 1) {
      List<String> ret = new ArrayList<String>();
      ret.add("()");
      return ret;
    }
    List<String> tmp = generateParenthesis(n - 1);
    Set<String> ret = new HashSet<String>();
    for (String s : tmp) {
      for (int i = 0; i <= s.length(); i++) {
        ret.add(new StringBuilder(s).insert(i, "()").toString());
      }
    }
    return new ArrayList<String>(ret);
  }

  /*
   * Valid Parentheses
   */

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<Character>(s.length());
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{') {
        stack.addFirst(c);
      } else if (c == ')') {
        if (!stack.isEmpty() && stack.peekFirst() == '(') {
          stack.removeFirst();
        } else {
          return false;
        }
      } else if (c == ']') {
        if (!stack.isEmpty() && stack.peekFirst() == '[') {
          stack.removeFirst();
        } else {
          return false;
        }
      } else if (c == '}') {
        if (!stack.isEmpty() && stack.peekFirst() == '{') {
          stack.removeFirst();
        } else {
          return false;
        }
      }
    }
    return stack.size() == 0;
  }

  /*
   * Remove Nth Node From End of List
   */

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode p = head;
    for (int i = 0; i < n; i++) {
      p = p.next;
    }
    if (p == null) {
      return head.next;
    }

    ListNode q = head;
    while (p.next != null) {
      q = q.next;
      p = p.next;
    }
    q.next = q.next.next;
    return head;
  }

  /*
   * Letter Combinations of a Phone Number
   */

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      List<String> ret = new ArrayList<String>();
      ret.add("");
      return ret;
    }
    List<String> firstLetter = new ArrayList<String>();
    switch (digits.charAt(0)) {
      case '2':
        firstLetter.add("a");
        firstLetter.add("b");
        firstLetter.add("c");
        break;
      case '3':
        firstLetter.add("d");
        firstLetter.add("e");
        firstLetter.add("f");
        break;
      case '4':
        firstLetter.add("g");
        firstLetter.add("h");
        firstLetter.add("i");
        break;
      case '5':
        firstLetter.add("j");
        firstLetter.add("k");
        firstLetter.add("l");
        break;
      case '6':
        firstLetter.add("m");
        firstLetter.add("n");
        firstLetter.add("o");
        break;
      case '7':
        firstLetter.add("p");
        firstLetter.add("q");
        firstLetter.add("r");
        firstLetter.add("s");
        break;
      case '8':
        firstLetter.add("t");
        firstLetter.add("u");
        firstLetter.add("v");
        break;
      case '9':
        firstLetter.add("w");
        firstLetter.add("x");
        firstLetter.add("y");
        firstLetter.add("z");
        break;
    }
    if (digits.length() == 1) {
      return firstLetter;
    }
    List<String> otherLetters = letterCombinations(digits.substring(1, digits.length()));
    List<String> ret = new ArrayList<String>(firstLetter.size() * otherLetters.size());
    for (int i = 0; i < firstLetter.size(); i++) {
      for (int j = 0; j < otherLetters.size(); j++) {
        ret.add(firstLetter.get(i) + otherLetters.get(j));
      }
    }
    return ret;
  }

  /*
   * 4Sum
   */

  public List<List<Integer>> fourSum(int[] num, int target) {
    Arrays.sort(num);
    Set<List<Integer>> ret = new HashSet<List<Integer>>();
    for (int i = 0; i < num.length; i++) {
      for (int j = i + 1; j < num.length; j++) {
        // find the closest in sorted array
        int p = j + 1, q = num.length - 1;
        while (p < q) {
          if (num[i] + num[j] + num[p] + num[q] == target) {
            List<Integer> found = new ArrayList<Integer>();
            found.add(num[i]);
            found.add(num[j]);
            found.add(num[p]);
            found.add(num[q]);
            ret.add(found);
            p++;
            q--;
          } else if (num[i] + num[j] + num[p] + num[q] < target) {
            p++;
          } else if (num[i] + num[j] + num[p] + num[q] > target) {
            q--;
          }
        }
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }

  /*
   * 3Sum Closest
   */

  public int threeSumClosest(int[] num, int target) {
    Arrays.sort(num);
    int ret = num[0] + num[1] + num[2];
    for (int i = 0; i < num.length; i++) {
      // find the closest in sorted array
      int j = i + 1, k = num.length - 1;
      while (j < k) {
        if (num[i] + num[j] + num[k] == target) {
          return target;
        } else if (num[i] + num[j] + num[k] < target) {
          if (target - (num[i] + num[j] + num[k]) < Math.abs(target - ret)) {
            ret = num[i] + num[j] + num[k];
          }
          j++;
        } else if (num[i] + num[j] + num[k] > target) {
          if ((num[i] + num[j] + num[k]) - target < Math.abs(target - ret)) {
            ret = num[i] + num[j] + num[k];
          }
          k--;
        }
      }
    }
    return ret;
  }

  /*
   * 3Sum
   */

  public List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    Set<List<Integer>> ret = new HashSet<List<Integer>>();
    for (int i = 0; i < num.length; i++) {
      // two sum in sorted array
      int j = i + 1, k = num.length - 1;
      while (j < k) {
        if (num[i] + num[j] + num[k] == 0) {
          List<Integer> found = new ArrayList<Integer>();
          found.add(num[i]);
          found.add(num[j]);
          found.add(num[k]);
          ret.add(found);
          j++;
          k--;
        } else if (num[i] + num[j] + num[k] < 0) {
          j++;
        } else if (num[i] + num[j] + num[k] > 0) {
          k--;
        }
      }
    }
    return new ArrayList<List<Integer>>(ret);
  }

  /*
   * Longest Common Prefix
   */

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    // String.length() is O(1)
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < prefix.length()) {
        prefix = strs[i];
      }
    }
    //
    int prefixLen = prefix.length();
    for (int i = 0; i < strs.length; i++) {
      int idx = 0;
      while (idx < prefixLen && prefix.charAt(idx) == strs[i].charAt(idx)) {
        idx++;
      }
      prefixLen = Math.min(idx, prefixLen);
    }
    return prefix.substring(0, prefixLen);
  }

  /*
   * Roman to Integer
   */

  public int romanToInt(String s) {
    Map<String, Integer> pool = new HashMap<String, Integer>();
    //
    pool.put("M", 1000);
    pool.put("MM", 2000);
    pool.put("MMM", 3000);
    //
    pool.put("C", 100);
    pool.put("CC", 200);
    pool.put("CCC", 300);
    pool.put("CD", 400);
    pool.put("D", 500);
    pool.put("DC", 600);
    pool.put("DCC", 700);
    pool.put("DCCC", 800);
    pool.put("CM", 900);
    //
    pool.put("X", 10);
    pool.put("XX", 20);
    pool.put("XXX", 30);
    pool.put("XL", 40);
    pool.put("L", 50);
    pool.put("LX", 60);
    pool.put("LXX", 70);
    pool.put("LXXX", 80);
    pool.put("XC", 90);
    //
    pool.put("I", 1);
    pool.put("II", 2);
    pool.put("III", 3);
    pool.put("IV", 4);
    pool.put("V", 5);
    pool.put("VI", 6);
    pool.put("VII", 7);
    pool.put("VIII", 8);
    pool.put("IX", 9);
    //
    int i = 0, j = i + 1, ret = 0;
    while (j <= s.length()) {
      while (j <= s.length() && pool.containsKey(s.substring(i, j))) {
        j++;
      } // greedy to match the longest substring
      ret += pool.get(s.substring(i, j - 1));
      i = j - 1;
    }
    return ret;
  }

  /*
   * Integer to Roman
   */

  public String intToRoman(int num) {
    int d1 = num % 10;
    num = num / 10;
    int d2 = num % 10;
    num = num / 10;
    int d3 = num % 10;
    num = num / 10;
    int d4 = num % 10;
    StringBuilder sb = new StringBuilder();
    switch (d4) {
      case 1:
        sb.append("M");
        break;
      case 2:
        sb.append("MM");
        break;
      case 3:
        sb.append("MMM");
        break;
    }
    switch (d3) {
      case 1:
        sb.append("C");
        break;
      case 2:
        sb.append("CC");
        break;
      case 3:
        sb.append("CCC");
        break;
      case 4:
        sb.append("CD");
        break;
      case 5:
        sb.append("D");
        break;
      case 6:
        sb.append("DC");
        break;
      case 7:
        sb.append("DCC");
        break;
      case 8:
        sb.append("DCCC");
        break;
      case 9:
        sb.append("CM");
        break;
    }
    switch (d2) {
      case 1:
        sb.append("X");
        break;
      case 2:
        sb.append("XX");
        break;
      case 3:
        sb.append("XXX");
        break;
      case 4:
        sb.append("XL");
        break;
      case 5:
        sb.append("L");
        break;
      case 6:
        sb.append("LX");
        break;
      case 7:
        sb.append("LXX");
        break;
      case 8:
        sb.append("LXXX");
        break;
      case 9:
        sb.append("XC");
        break;
    }
    switch (d1) {
      case 1:
        sb.append("I");
        break;
      case 2:
        sb.append("II");
        break;
      case 3:
        sb.append("III");
        break;
      case 4:
        sb.append("IV");
        break;
      case 5:
        sb.append("V");
        break;
      case 6:
        sb.append("VI");
        break;
      case 7:
        sb.append("VII");
        break;
      case 8:
        sb.append("VIII");
        break;
      case 9:
        sb.append("IX");
        break;
    }
    return sb.toString();
  }

  /*
   * Container With Most Water
   */

  public int maxArea(int[] height) {
    int i = 0, j = height.length - 1;
    int retMax = Math.min(height[i], height[j]) * (j - i);
    while (i < j) {
      // try best moving to get potential large area
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
      retMax = Math.max(retMax, Math.min(height[i], height[j]) * (j - i));
    }
    return retMax;
  }

  /*
   * Regular Expression Matching
   */

  public boolean isRegularExpressionMatch(String s, String p) {
    char[] sArray = s.toCharArray();
    char[] pArray = p.toCharArray();

    return isArrayMatch(sArray, pArray, 0, 0);
  }

  private boolean isArrayMatch(char[] sArray, char[] pArray, int i, int j) {
    if (j == pArray.length) {
      return i == sArray.length;
    }
    // next is not *
    if (j + 1 == pArray.length || pArray[j + 1] != '*') {
      return (i < sArray.length && ((sArray[i] == pArray[j]) || pArray[j] == '.'))
          && isArrayMatch(sArray, pArray, i + 1, j + 1);
    }
    // next is *
    while (i < sArray.length && ((sArray[i] == pArray[j]) || pArray[j] == '.')) {
      if (isArrayMatch(sArray, pArray, i, j + 2)) {
        return true;
      }
      i++; // i change; j never change
    }
    return isArrayMatch(sArray, pArray, i, j + 2); // i have tried all true *; go to next
  }

  /*
   * Palindrome Number
   */

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }

    int power = 1;
    while (power <= x / 10) {
      power = power * 10;
    }

    while (power > 1) {
      int head = x / power;
      int tail = x % 10;
      if (head != tail) {
        return false;
      }
      x = x % power / 10; // remove both head and tail
      power = power / 100;
    }

    return true;
  }

  /*
   * String to Integer (atoi)
   */

  public int atoi(String str) {
    try {
      String strTrim = str.trim();
      char leading = strTrim.charAt(0);
      if (leading == '+' || leading == '-') {
        strTrim = strTrim.substring(1);
      }
      String[] strs = strTrim.split("\\D+");
      if (leading == '-') {
        if ((leading + strs[0]).length() == String.valueOf(Integer.MIN_VALUE).length()
            && (leading + strs[0]).compareTo(String.valueOf(Integer.MIN_VALUE)) > 0) {
          return Integer.MIN_VALUE;
        } else if ((leading + strs[0]).length() > String.valueOf(Integer.MIN_VALUE).length()) {
          return Integer.MIN_VALUE;
        } else {
          return Integer.parseInt(leading + strs[0]);
        }
      } else {
        if (strs[0].length() == String.valueOf(Integer.MAX_VALUE).length()
            && strs[0].compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
          return Integer.MAX_VALUE;
        } else if (strs[0].length() > String.valueOf(Integer.MAX_VALUE).length()) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.parseInt(strs[0]);
        }
      }
    } catch (Exception e) {
      return 0;
    }
  }

  /*
   * Reverse Integer
   */

  public int reverse(int x) {
    if (x < 0) {
      return -Integer.parseInt((new StringBuilder(String.valueOf(-x))).reverse().toString());
    } else {
      return Integer.parseInt((new StringBuilder(String.valueOf(x))).reverse().toString());
    }
  }

  /*
   * ZigZag Conversion
   */

  public String convert(String s, int nRows) {
    if (nRows == 1) {
      return s;
    }
    char matrix[][] = new char[nRows][s.length()];
    boolean down = true;
    int idxRow = 0, idxCol = 0;
    for (int i = 0; i < s.length(); i++) {
      if (down) {
        matrix[idxRow][idxCol] = s.charAt(i);
        if (idxRow == nRows - 1) {
          down = false;
          idxCol = idxCol + 1;
          idxRow = idxRow - 1;
        } else {
          idxRow = idxRow + 1;
        }
      } else {
        matrix[idxRow][idxCol] = s.charAt(i);
        if (idxRow == 0) {
          down = true;
          idxRow = idxRow + 1;
        } else {
          idxRow = idxRow - 1;
          idxCol = idxCol + 1;
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < nRows; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (matrix[i][j] > 0) {
          sb.append(matrix[i][j]);
        }
      }
    }
    return sb.toString();
  }

  /*
   * Longest Palindromic Substring
   */

  // O(n^2); O(N) (Manacher’s Algorithm)
  public String longestPalindrome(String s) {
    int length = s.length();
    int retLeft = 0;
    int retRight = 0;
    for (int i = 0; i < length; i++) {
      for (int j = 0; 0 <= i - j && i + j < length; j++) {
        if (s.charAt(i - j) == s.charAt(i + j)) { // center [i]
          if ((i + j) - (i - j) + 1 > retRight - retLeft) {
            retLeft = i - j;
            retRight = (i + j) + 1;
          }
        } else {
          break;
        }
      }
    }
    for (int i = 0; i < length - 1; i++) {
      for (int j = 0; 0 <= i - j && i + 1 + j < length; j++) {
        if (s.charAt(i - j) == s.charAt(i + 1 + j)) { // center [i, i+1]
          if ((i + 1 + j) - (i - j) + 1 > retRight - retLeft) {
            retLeft = i - j;
            retRight = (i + j + 1) + 1;
          }
        } else {
          break;
        }
      }
    }
    return s.substring(retLeft, retRight);
  }

  /*
   * Add Two Numbers
   */

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null;
    ListNode tail = null;
    ListNode carry = new ListNode(0);
    while (l1 != null && l2 != null) {
      ListNode newNode = new ListNode((l1.val + l2.val + carry.val) % 10);
      if (head == null) {
        head = newNode; // inclusive
      }
      if (tail == null) {
        tail = newNode; // inclusive
      } else {
        tail.next = newNode;
        tail = tail.next;
      }
      carry.val = (l1.val + l2.val + carry.val) / 10;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null && l2 == null) {
      ListNode newNode = new ListNode((l1.val + carry.val) % 10);
      if (head == null) {
        head = newNode; // inclusive
      }
      if (tail == null) {
        tail = newNode; // inclusive
      } else {
        tail.next = newNode;
        tail = tail.next;
      }
      carry.val = (l1.val + carry.val) / 10;
      l1 = l1.next;
    }
    while (l1 == null && l2 != null) {
      ListNode newNode = new ListNode((l2.val + carry.val) % 10);
      if (head == null) {
        head = newNode; // inclusive
      }
      if (tail == null) {
        tail = newNode; // inclusive
      } else {
        tail.next = newNode;
        tail = tail.next;
      }
      carry.val = (l2.val + carry.val) / 10;
      l2 = l2.next;
    }
    if (carry.val > 0) {
      tail.next = carry;
    }
    return head;
  }

  /*
   * Longest Substring Without Repeating Characters
   */

  public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0; // window traversal
    int longest = j - i; // window size
    int length = s.length();
    Map<Character, Integer> charPool = new HashMap<Character, Integer>(); // tracking
    while (j < length) { // active moving
      Character c = s.charAt(j);
      if (charPool.containsKey(c)) {
        int k = i;
        i = charPool.get(c) + 1; // passive moving
        while (k < i) {
          charPool.remove(s.charAt(k++));
        }
      }
      charPool.put(c, j);
      j++;
      longest = Math.max(j - i, longest);
    }
    return longest;
  }

  /*
   * Median of Two Sorted Arrays
   */

  // binary search A O(log(m)), check B O(1)
  private int kthSmallestInSortedArraysAssumeInA(int A[], int Aleft, int Aright, int B[],
      int Bleft, int Bright, int k) {
    int low = Aleft;
    int high = Aright - 1; // inclusive for binary search
    while (low <= high) {
      int mid = (low + high) / 2; // assume A[mid] is the kth

      int i = mid - Aleft; // count of elements smaller than A[mid] in A
      int j = (k - 1) - i; // insert A[mid] in B[j] should be fine
      if (j < 0) { // i is too large
        high = mid - 1; // to find a smaller A[mid]
        continue;
      } else if (j > Bright - Bleft) { // i is too small
        low = mid + 1; // to find a larger A[mid]
        continue;
      }

      if (Bleft + j - 1 >= Bleft && B[Bleft + j - 1] > A[mid]) { // A[mid] too small
        low = mid + 1; // to find a larger A[mid]
      } else if (Bleft + j < Bright && A[mid] > B[Bleft + j]) { // A[mid] too large
        high = mid - 1; // to find a smaller A[mid]
      } else {
        return mid;
      }
    }
    return -1;
  }

  // log(m) + log(n) = log(mn) < log((m+n)^2) = 2log(m+n) = O(log(m+n))
  private Integer kthSmallestInSortedArrays(int A[], int Aleft, int Aright, int B[], int Bleft,
      int Bright, int k) {
    if (k <= 0 || k > (Aright - Aleft) + (Bright - Bleft)) {
      return null;
    }
    if (Aright - Aleft == 0) {
      return B[Bleft + k - 1];
    } else if (Bright - Bleft == 0) {
      return A[Aleft + k - 1];
    }

    int ret = kthSmallestInSortedArraysAssumeInA(A, Aleft, Aright, B, Bleft, Bright, k);
    if (ret >= 0) {
      return A[ret];
    }
    ret = kthSmallestInSortedArraysAssumeInA(B, Bleft, Bright, A, Aleft, Aright, k);
    return B[ret];
  }

  public double findMedianSortedArrays(int A[], int B[]) {
    int length = A.length + B.length;
    if (length % 2 == 0) {
      int i = kthSmallestInSortedArrays(A, 0, A.length, B, 0, B.length, length / 2);
      int j = kthSmallestInSortedArrays(A, 0, A.length, B, 0, B.length, length / 2 + 1);
      return (i + j) / 2.0;
    } else {
      return kthSmallestInSortedArrays(A, 0, A.length, B, 0, B.length, length / 2 + 1);
    }
  }

  /*
   * Two Sum
   */

  public int[] twoSum(int[] numbers, int target) {
    int[] ret = new int[2];
    Map<Integer, Integer> hash = new HashMap<Integer, Integer>(numbers.length);
    for (int i = 0; i < numbers.length; i++) {
      hash.put(numbers[i], i);
    }
    for (int i = 0; i < numbers.length; i++) {
      Integer j = hash.get(target - numbers[i]);
      if (j != null && j != i) {
        ret[0] = i + 1;
        ret[1] = j + 1;
        break;
      }
    }
    return ret;
  }
}
