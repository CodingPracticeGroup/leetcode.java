// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

  Integer cache;
  Iterator<Integer> iterator;

  public PeekingIterator(Iterator<Integer> iterator) {
    // initialize any member here.
    this.iterator = iterator;
    if (iterator.hasNext()) {
      cache = iterator.next();
    } else {
      cache = null;
    }
  }

  // Returns the next element in the iteration without advancing the iterator.
  public Integer peek() {
    return cache;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  @Override
  public Integer next() {
    Integer ret = cache;
    if (iterator.hasNext()) {
      cache = iterator.next();
    } else {
      cache = null;
    }
    return ret;
  }

  @Override
  public boolean hasNext() {
    return cache != null;
  }
}
