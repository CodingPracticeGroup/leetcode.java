public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> adj = new HashMap<>(); // str -> heap
    for (String[] str : tickets) {
      adj.computeIfAbsent(str[0], k -> new PriorityQueue<String>()).add(str[1]);
    }

    List<String> ret = new ArrayList<>(); // base itinerary
    ret.add("JFK");
    while (adj.containsKey(ret.get(ret.size() - 1))
        && adj.get(ret.get(ret.size() - 1)).size() > 0) {
      ret.add(adj.get(ret.get(ret.size() - 1)).poll());
    }
    while (ret.size() <= tickets.length) { // insert cycle
      for (int i = ret.size() - 1; i >= 0; i--) {
        if (adj.containsKey(ret.get(i)) && adj.get(ret.get(i)).size() > 0) {
          List<String> l = new ArrayList<>(); // cycle
          l.add(adj.get(ret.get(i)).poll());
          while (adj.containsKey(l.get(l.size() - 1)) && adj.get(l.get(l.size() - 1)).size() > 0) {
            l.add(adj.get(l.get(l.size() - 1)).poll());
          }
          ret.addAll(i + 1, l);
          break;
        }
      }
    }
    return ret;
  }
}
--------------
public class Solution {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, PriorityQueue<String>> adj = new HashMap<>(); // str -> heap
    for (String[] str : tickets) {
      adj.computeIfAbsent(str[0], k -> new PriorityQueue<String>()).add(str[1]);
    }

    LinkedList<String> ret = new LinkedList<>(); // base itinerary
    Deque<String> stack = new ArrayDeque<>();
    stack.add("JFK");
    while (!stack.isEmpty()) { // insert cycle
      while (adj.containsKey(stack.peekLast()) && adj.get(stack.peekLast()).size() > 0) {
        stack.offerLast(adj.get(stack.peekLast()).poll());
      }
      ret.offerFirst(stack.pollLast());
    }
    return ret;
  }
}
