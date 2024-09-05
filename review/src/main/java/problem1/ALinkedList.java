package problem1;

public abstract class ALinkedList implements ILinkedList {


  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean contains(Integer element) {
    return null;
  }

  @Override
  public Boolean isEmpty() {
    return null;
  }

  public abstract Boolean contains(int element);

  @Override
  public int elementsAt(Integer index) {
    return 0;
  }
}
