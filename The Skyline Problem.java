public class Solution {
  private int getSkyline_left(int[] idx, int key) {
    int low = 0, high = idx.length - 1;
    while (low < high) {
      int mid = (low + high) / 2; // default towards to 0/low
      if (idx[mid] < key) {
        low = mid + 1;
      } else if (idx[mid] > key) {
        high = mid - 1;
      } else {
        high = mid; // keep 'high' hit possibility
      }
    }
    return high;
  }

  private int getSkyline_right(int[] idx, int key) {
    int low = 0, high = idx.length - 1;
    while (low < high) {
      int mid = (low + high + 1) / 2; // towards to 'high'
      if (idx[mid] < key) {
        low = mid + 1;
      } else if (key < idx[mid]) {
        high = mid - 1;
      } else {
        low = mid; // keep 'low' hit possibility
      }
    }
    return low;
  }

  public List<int[]> getSkyline(int[][] buildings) {
    int size = buildings.length * 2;
    int[] idx = new int[size];
    for (int i = 0; i < buildings.length; i++) {
      idx[i * 2] = buildings[i][0];
      idx[i * 2 + 1] = buildings[i][1];
    }
    Arrays.sort(idx);

    int[] max_height = new int[buildings.length * 2];
    Arrays.fill(max_height, 0);

    for (int i = 0; i < buildings.length; i++) {
      int left = getSkyline_left(idx, buildings[i][0]);
      int right = getSkyline_right(idx, buildings[i][1]);
      for (int j = left; j < right; j++) {
        max_height[j] = Math.max(max_height[j], buildings[i][2]);
      }
    }

    List<int[]> ret = new ArrayList<>();
    int last_height = 0;
    for (int i = 0; i < size; i++) {
      if (max_height[i] != last_height) {
        ret.add(new int[] {idx[i], max_height[i]});
        last_height = max_height[i];
      }
    }
    return ret;
  }
}
