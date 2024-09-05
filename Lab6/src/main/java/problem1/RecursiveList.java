package problem1;

public class RecursiveList extends AListOfIntegers {

  private Integer headElement;
  private ListOfIntegers rest;

  public RecursiveList(Integer headElement, ListOfIntegers rest) {
    this.headElement = headElement;
    this.rest = rest;
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public Boolean contains(int value) {
    if(this.headElement.equals(value))
      return true;
    else return this.rest.contains(value);
  }

  @Override
  public Integer elementsAt(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index >= this.size())
      throw new IndexOutOfBoundsException("An element with this index "
          + "is not a part of the list");
    else{
      if(index == 0)
        return this.headElement;
      else return this.rest.elementsAt(index - 1);
    }
  }

  @Override
  public Integer sum() {
    return this.headElement + this.rest.sum();
  }
}
