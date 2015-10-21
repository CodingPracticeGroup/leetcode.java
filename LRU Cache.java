import java.util.HashMap;
import java.util.Map;

class DLNode {
  int key;
  int val;
  DLNode pre;
  DLNode nxt;

  DLNode(int k, int v) {
    key = k;
    val = v;
    pre = null;
    nxt = null;
  }
}


public class LRUCache {
  int capacity;
  DLNode head; // for order
  DLNode tail;
  Map<Integer, DLNode> keyVal; // for key-val store

  public LRUCache(int capacity) {
    this.capacity = capacity;
    head = new DLNode(-1, -1);
    tail = new DLNode(-1, -1);
    head.nxt = tail;
    tail.pre = head;
    keyVal = new HashMap<>();
  }

  private void insert(int k, int v) {
    DLNode n = new DLNode(k, v);
    n.nxt = head.nxt;
    n.pre = head;
    n.nxt.pre = n;
    n.pre.nxt = n;

    keyVal.put(k, n);

    if (keyVal.size() > capacity) {
      delete(tail.pre.key);
    }
  }

  private int delete(int k) {
    if (!keyVal.containsKey(k))
      return -1;

    DLNode n = keyVal.remove(k);
    n.pre.nxt = n.nxt;
    n.nxt.pre = n.pre;

    return n.val;
  }

  public int get(int key) {
    int val = delete(key);
    if (val != -1)
      insert(key, val);
    return val;
  }

  public void set(int key, int value) {
    delete(key);
    insert(key, value);
  }
}
