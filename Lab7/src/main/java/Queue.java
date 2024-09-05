/**
 * Interface for a generic Queue.
 * @param <T> the type of elements in this queue
 */
public interface Queue<T> {
  /**
   * Creates an empty queue.
   *
   * @return an empty queue
   */
  static <T> Queue<T> create() {
    return new LinkedListQueue<>();
  }

  /**
   * Checks if the queue is empty.
   *
   * @return true if the queue is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Adds an element to the queue.
   *
   * @param n the element to add
   */
  void enqueue(T n);

  /**
   * Removes and returns the oldest element from the queue.
   *
   * @return the oldest element
   */
  T dequeue();

  /**
   * Removes the specified element from the queue.
   *
   * @param elem the element to remove
   */
  void remove(T elem);

  /**
   * Returns the number of elements in the queue.
   *
   * @return the size of the queue
   */
  int size();
}
