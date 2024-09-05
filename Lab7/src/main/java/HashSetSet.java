import java.util.HashSet;
import java.util.Objects;

/**
 * Implementation of a generic Set using HashSet.
 * @param <T> the type of elements in this set
 */
public class HashSetSet<T> implements Set<T> {
  private final HashSet<T> set;

  /**
   * Constructs an empty set.
   */
  public HashSetSet() {
    this.set = new HashSet<>();
  }

  @Override
  public boolean isEmpty() {
    return set.isEmpty();
  }

  @Override
  public Set<T> add(T n) {
    set.add(n);
    return this;
  }

  @Override
  public boolean contains(T n) {
    return set.contains(n);
  }

  @Override
  public Set<T> remove(T ele) {
    set.remove(ele);
    return this;
  }

  @Override
  public int size() {
    return set.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HashSetSet<?> that = (HashSetSet<?>) o;
    return set.equals(that.set);
  }

  @Override
  public int hashCode() {
    return Objects.hash(set);
  }

  @Override
  public String toString() {
    return "HashSetSet{" +
        "set=" + set +
        '}';
  }
}
