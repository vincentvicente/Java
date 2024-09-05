package problem1;

import java.util.Objects;

/**
 * Represents a non-empty priority queue.
 */
class NonEmpty implements PriorityQueue {
  private final Integer priority;
  private final String value;
  private final PriorityQueue next;

  NonEmpty(Integer priority, String value, PriorityQueue next) {
    this.priority = priority;
    this.value = value;
    this.next = next;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public PriorityQueue add(Integer priority, String value) {
    if (priority > this.priority) {
      return new NonEmpty(priority, value, this);
    } else if (priority.equals(this.priority)) {
      // Insert the new element after the current one if they have the same priority, (FIFO for elements with the same priority)
      return new NonEmpty(this.priority, this.value, next.add(priority, value));
    } else {
      return new NonEmpty(this.priority, this.value, next.add(priority, value));
    }
  }

  @Override
  public String peek() {
    return value;
  }

  @Override
  public PriorityQueue pop() {
    return next;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NonEmpty nonEmpty = (NonEmpty) o;
    return Objects.equals(priority, nonEmpty.priority) && Objects.equals(value,
        nonEmpty.value) && Objects.equals(next, nonEmpty.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, value, next);
  }

  @Override
  public String toString() {
    return "NonEmpty{" +
        "priority=" + priority +
        ", value='" + value + '\'' +
        ", next=" + next +
        '}';
  }
}
