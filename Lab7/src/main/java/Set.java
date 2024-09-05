/**
 * Interface for a generic Set.
 * @param <T> the type of elements in this set
 */
public interface Set<T> {
  /**
   * Creates an empty set.
   *
   * @return an empty set
   */
  static <T> Set<T> emptySet() {
    return new HashSetSet<>();
  }

  /**
   * Checks if the set is empty.
   *
   * @return true if the set is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Adds an element to the set.
   *
   * @param n the element to add
   * @return the updated set
   */
  Set<T> add(T n);

  /**
   * Checks if the set contains the specified element.
   *
   * @param n the element to check for
   * @return true if the set contains the element, false otherwise
   */
  boolean contains(T n);

  /**
   * Removes an element from the set.
   *
   * @param ele the element to remove
   * @return the updated set
   */
  Set<T> remove(T ele);

  /**
   * Returns the number of elements in the set.
   *
   * @return the size of the set
   */
  int size();
}
