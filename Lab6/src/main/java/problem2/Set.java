package problem2;

public interface Set {

  public static Set emptySet(){
    return new EmptySet();
  }

  Boolean isEmpty();
  Set add(int n);
  Boolean contains(Integer n);
  Set remove(Integer n);
  Integer size();

}
