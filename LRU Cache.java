import java.util.LinkedHashMap;

public class LRUCache {

	public static final float loadFactor = (float) 0.75;

	LinkedHashMap<Integer, Integer> cache;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new LinkedHashMap<Integer, Integer>((int) (capacity / loadFactor) + 1, loadFactor, true);
	}

	public int get(int key) {
		Integer val = cache.get(key);
		if (val == null) {
			return -1;
		}
		return val;
	}

	public void set(int key, int value) {
		if (cache.containsKey(key)) {
			cache.put(key, value);
			return;
		}
		if (cache.size() >= capacity) {
			cache.remove(cache.keySet().iterator().next());
		}
		cache.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache o = new LRUCache(2);
		int v;
		v = o.get(2);
		o.set(2, 6);
		v = o.get(1);
		o.set(1, 5);
		o.set(1, 2);
		v = o.get(1);
		v = o.get(2);
	}
}
