package problem2;

public class EmptySet implements Set{

  public EmptySet() {
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.TRUE;
  }

  @Override
  public Set add(int n) {
    return new NonEmptySet(n, this);
  }

  @Override
  public Boolean contains(Integer n) {
    return Boolean.FALSE;
  }

  @Override
  public Set remove(Integer n) {
    return this;
  }

  @Override
  public Integer size() {
    return 0;
  }
}
