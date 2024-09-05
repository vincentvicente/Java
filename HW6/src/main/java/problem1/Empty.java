package problem1;

/**
 * Represents an empty priority queue.
 */
class Empty implements PriorityQueue {

  public Empty() {
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) {
    return new NonEmpty(priority, value, this);
  }

  @Override
  public String peek() {
    throw new IllegalStateException("Priority queue is empty.");
  }

  @Override
  public PriorityQueue pop() {
    throw new IllegalStateException("Priority queue is empty.");
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "Empty";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return true;
  }
}
