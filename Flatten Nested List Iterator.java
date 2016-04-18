public class NestedIterator implements Iterator<Integer> {
  Deque<Iterator<NestedInteger>> stack = new ArrayDeque<>();
  Integer n = null;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack.push(nestedList.iterator());
  }

  @Override
  public Integer next() {
    return n;
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      if (stack.peek().hasNext()) {
        NestedInteger ni = stack.peek().next();
        if (ni.isInteger()) {
          n = ni.getInteger();
          return true;
        } else {
          stack.push(ni.getList().iterator());
        }
      } else {
        stack.pop();
      }
    }
    return false;
  }
}
