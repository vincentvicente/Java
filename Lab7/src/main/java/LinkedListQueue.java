import java.util.LinkedList;
import java.util.Objects;

/**
 * Implementation of a generic Queue using LinkedList.
 * @param <T> the type of elements in this queue
 */
public class LinkedListQueue<T> implements Queue<T> {
  private final LinkedList<T> queue;

  /**
   * Constructs an empty queue.
   */
  public LinkedListQueue() {
    this.queue = new LinkedList<>();
  }

  @Override
  public boolean isEmpty() {
    return queue.isEmpty();
  }

  @Override
  public void enqueue(T n) {
    queue.addLast(n);
  }

  @Override
  public T dequeue() {
    return queue.removeFirst();
  }

  @Override
  public void remove(T elem) {
    queue.remove(elem);
  }

  @Override
  public int size() {
    return queue.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LinkedListQueue<?> that = (LinkedListQueue<?>) o;
    return queue.equals(that.queue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(queue);
  }

  @Override
  public String toString() {
    return "LinkedListQueue{" +
        "queue=" + queue +
        '}';
  }
}
