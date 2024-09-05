package problem1;

import java.awt.HeadlessException;
import java.util.List;
import org.w3c.dom.Node;

public class RecursiveList extends ALinkedList {
  private int headElement;
  private ListOfIntegers rest;

  public RecursiveList(int headElement, ListOfIntegers rest) {
    this.headElement = headElement;
    this.rest = rest;
  }

  @Override
  public Integer size() {
    return 1 + rest.size();
  }

  @Override
  public Boolean contains(Integer element) {
    if this.headElement.equals(element){
      return Boolean.TRUE;
    }else return this.rest.contains(element);
  }

  @Override
  public Boolean isEmpty() {
    return Boolean.FALSE;
  }

  @Override
  public int elementsAt(Integer index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= this.size()) {
      throw new IndexOutOfBoundsException("Index out of bound");
    }
    else{
      if (index == 0){
        return this.headElement;
      }
      else return this.rest.elementsAt(index - 1);
    }
  }
}

