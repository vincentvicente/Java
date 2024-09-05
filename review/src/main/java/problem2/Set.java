package problem2;

public interface Set {

  public static Set emptySet() {
    return newEmptySet();
  }

  Boolean isEmpty();

  Set add(Integer n);

  Boolean contains(Integer n);

  Set remove(Integer n);

  Integer size();
}
