public class Solution {
  private List<String> letterCombinations_recursion(char[][] map, int[] arr, int start,
      String prefix) {
    List<String> ret = new ArrayList<>();
    if (start == arr.length - 1) {
      for (int i = 0; i < map[arr[start]].length; i++) {
        ret.add(new String(prefix + map[arr[start]][i]));
      }
    } else {
      for (int i = 0; i < map[arr[start]].length; i++) {
        ret.addAll(letterCombinations_recursion(map, arr, start + 1, prefix + map[arr[start]][i]));
      }
    }
    return ret;
  }

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<String>();
    }
    char[][] map = new char[][] { {' '}, // 0
        {}, // 1
        {'a', 'b', 'c'}, // 2
        {'d', 'e', 'f'}, // 3
        {'g', 'h', 'i'}, // 4
        {'j', 'k', 'l'}, // 5
        {'m', 'n', 'o'}, // 6
        {'p', 'q', 'r', 's'}, // 7
        {'t', 'u', 'v'}, // 8
        {'w', 'x', 'y', 'z'} // 9
        };
    int[] arr = digits.chars().map(x -> x - '0').toArray();
    return letterCombinations_recursion(map, arr, 0, "");
  }
}
------------
public class Solution {
  char[] digit = new char[] {'2', '3', '4', '5', '6', '7', '8', '9', '0'};
  char[][] letters =
      new char[][] {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
          {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}, {' '}};

  public List<String> letterCombinations(String digits) {
    List<String> ret = new ArrayList<>();
    if (digits.length() == 0) {
      return ret;
    }
    int idx = Arrays.binarySearch(digit, digits.charAt(0));
    if (idx >= 0) {
      List<String> r = letterCombinations(digits.substring(1));
      for (String s : r) {
        for (char c : letters[idx]) {
          ret.add(c + s);
        }
      }
      if (ret.isEmpty()) {
        for (char c : letters[idx]) {
          ret.add(c + "");
        }
      }
      return ret;
    } else {
      return letterCombinations(digits.substring(1));
    }
  }
}
