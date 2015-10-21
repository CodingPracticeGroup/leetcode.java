public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] arr1 = version1.split("\\.");
    String[] arr2 = version2.split("\\.");
    int minlen = Math.min(arr1.length, arr2.length);
    for (int i = 0; i < minlen; i++) {
      int v1 = Integer.valueOf(arr1[i]);
      int v2 = Integer.valueOf(arr2[i]);
      if (v1 < v2)
        return -1;
      if (v1 > v2)
        return 1;
    }
    if (minlen < arr1.length) {
      for (int i = minlen; i < arr1.length; i++) {
        if (Integer.valueOf(arr1[i]) > 0)
          return 1;
      }
    }
    if (minlen < arr2.length) {
      for (int i = minlen; i < arr2.length; i++) {
        if (Integer.valueOf(arr2[i]) > 0)
          return -1;
      }
    }
    return 0;
  }
}
