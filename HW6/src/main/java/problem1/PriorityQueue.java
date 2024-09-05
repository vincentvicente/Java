package problem1;

/**
 * Represents an immutable priority queue interface.
 */
public interface PriorityQueue {

  /**
   * Creates and returns an empty priority queue.
   *
   * @return an empty priority queue
   */
  static PriorityQueue createEmpty() {
    return new Empty();
  }

  /**
   * Checks if the priority queue is empty.
   *
   * @return true if the priority queue contains no items, false otherwise
   */
  Boolean isEmpty();

  /**
   * Adds the given element (priority and value) to the priority queue.
   *
   * @param priority the priority of the element
   * @param value    the value associated with the priority
   * @return a new priority queue with the element added
   */
  PriorityQueue add(Integer priority, String value);

  /**
   * Returns the value in the priority queue that has the highest priority.
   *
   * @return the value with the highest priority
   * @throws IllegalStateException if the priority queue is empty
   */
  String peek();

  /**
   * Returns a copy of the priority queue without the element with the highest priority.
   *
   * @return a new priority queue without the element with the highest priority
   * @throws IllegalStateException if the priority queue is empty
   */
  PriorityQueue pop();
}
