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

  public int compareVersion_(String version1, String version2) {
    long c1 = version1.chars().filter(x -> x == '.').count();
    long c2 = version2.chars().filter(x -> x == '.').count();
    if (c1 < c2) {
      StringBuilder sb = new StringBuilder(version1);
      for (int i = 0; i < c2 - c1; i++) {
        sb.append(".0");
      }
      version1 = sb.toString();
    } else if (c1 > c2) {
      StringBuilder sb = new StringBuilder(version2);
      for (int i = 0; i < c1 - c2; i++) {
        sb.append(".0");
      }
      version2 = sb.toString();
    }
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    for (int i = 0; i < v1.length && i < v2.length; i++) {
      int v1_ = Integer.parseInt(v1[i]);
      int v2_ = Integer.parseInt(v2[i]);
      if (v1_ < v2_) {
        return -1;
      } else if (v1_ > v2_) {
        return 1;
      }
    }
    return 0;
  }
}
