package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Comparator;


public class Solution {
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

  public boolean isMatch(String s, String p) {
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
