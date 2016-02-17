import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int maxPoints(Point[] points) {
    if (points.length == 0)
      return 0;
    int max = 1;
    for (int i = 0; i < points.length; i++) {
      int i_max = 1;
      Map<Double, Integer> k_count = new HashMap<>();
      int inf_count = 1;
      int duplicate = 0;
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          duplicate++;
        } else if (points[i].x == points[j].x) {
          inf_count++;
          i_max = Math.max(i_max, inf_count);
        } else {
          int bigx = i;
          int smallx = j;
          if (points[bigx].x < points[smallx].x) {
            bigx = j;
            smallx = i;
          }
          double k =
              (points[bigx].y - points[smallx].y) * 1.0 / (points[bigx].x - points[smallx].x);
          if (k_count.containsKey(k)) {
            int newcount = k_count.get(k) + 1;
            k_count.put(k, newcount);
            i_max = Math.max(i_max, newcount);
          } else {
            k_count.put(k, 2);
            i_max = Math.max(i_max, 2);
          }
        }
      }
      max = Math.max(max, i_max + duplicate);
    }
    return max;
  }
}
------------
public class Solution {
  public int maxPoints(Point[] points) {
    int ret = 0;
    for (int i = 0; i < points.length; i++) {
      int samex = 1; // case 1
      int samep = 0; // case 2
      Map<Double, Integer> kc = new HashMap<>(); // case 3
      for (int j = i + 1; j < points.length; j++) {
        if (points[i].x == points[j].x && points[i].y == points[j].y) {
          samep++;
        } else if (points[i].x == points[j].x) {
          samex++;
        } else {
          double k = (points[i].y - 1.0 * points[j].y) / (points[i].x - points[j].x);
          if (k == 0) // -0 != 0
            k = 0;
          if (!kc.containsKey(k)) {
            kc.put(k, 1);
          }
          kc.put(k, kc.get(k) + 1);
        }
      }
      ret = Math.max(ret, samex + samep);
      if (!kc.isEmpty()) {
        ret = Math.max(ret, kc.values().stream().mapToInt(x -> x).max().getAsInt() + samep);
      }
    }
    return ret;
  }
}
