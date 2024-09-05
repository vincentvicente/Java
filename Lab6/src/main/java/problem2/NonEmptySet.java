package problem2;

public class NonEmptySet implements Set {

  private Integer headValue;
  private Set rest;

  public NonEmptySet(Integer headValue, Set rest) {
    this.headValue = headValue;
    this.rest = rest;
  }

  @Override
  public Boolean isEmpty() {
    return false;
  }

  @Override
  public Set add(int n) {
    if(!this.contains(n))
      return new NonEmptySet(n, this);
    else return this;
  }

  @Override
  public Boolean contains(Integer n) {
    if(this.headValue.equals(n))
      return true;
    return this.rest.contains(n);
  }

  @Override
  public Set remove(Integer n) {
    if(this.contains(n)){
      if(this.headValue.equals(n))
        return this.rest;
      else return new NonEmptySet(this.headValue, this.rest.remove(n));
    }
    else return this;
  }

  @Override
  public Integer size() {
    return 1 + this.rest.size();
  }
}
