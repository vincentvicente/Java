package problem1;

public class LinkedMarineMammalDirectory implements MarineMammalDirectory {

  private Node headMammal;
  private int numMammals;

  public LinkedMarineMammalDirectory() {
    this.headMammal = null;
    this.numMammals = 0;
  }

  @Override
  public MarineMammalDirectory createEmpty() {
    return new LinkedMarineMammalDirectory();
  }

  @Override
  public Boolean isEmpty() {
    return this.numMammals == 0;
  }

  @Override
  public Integer size() {
    return this.numMammals;
  }

  @Override
  public Boolean containsMammal(MarineMammal marineMammal) {
    Node currNode = this.headMammal;
    //Only one node in the list
    if(currNode.getNextNode() == null){
      return currNode.getMarineMammal().equals(marineMammal);
    }
    currNode = currNode.getNextNode();
    while(currNode != null){
      if(currNode.getMarineMammal().equals(marineMammal))
        return Boolean.TRUE;
      else
        currNode = currNode.getNextNode();
    }
    return Boolean.FALSE;
  }

  @Override
  public MarineMammalDirectory add(MarineMammal marineMammal) {
    if(this.containsMammal(marineMammal))
      return this;
    else{
      Node newNode = new Node(marineMammal, this.headMammal);
      this.headMammal = newNode;
      return this;
    }
  }

  @Override
  public MarineMammalDirectory remove(MarineMammal marineMammal) {
    if(!this.containsMammal(marineMammal))
      return this;
    else{
      Node currNode = this.headMammal;
      if(currNode.getMarineMammal().equals(marineMammal))
        this.headMammal = currNode.getNextNode();
      else{
        while(currNode.getNextNode() != null){
          if(currNode.getNextNode().getMarineMammal().equals(marineMammal)){
            Node auxNode = currNode.getNextNode().getNextNode(); //node's to remove next neighbor
            currNode.setNextNode(auxNode);
          }
          currNode = currNode.getNextNode();
        }
      }
    }
    this.numMammals--;
    return this;
  }

  @Override
  public MarineMammal getSomeMammal() {
    return null;
  }
}
