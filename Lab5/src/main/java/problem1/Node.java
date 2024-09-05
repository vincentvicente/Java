package problem1;

import java.util.Objects;

public class Node {
  private MarineMammal marineMammal;
  private Node nextNode;

  public Node(MarineMammal marineMammal, Node nextNode) {
    this.marineMammal = marineMammal;
    this.nextNode = nextNode;
  }

  public MarineMammal getMarineMammal() {
    return marineMammal;
  }

  public void setMarineMammal(MarineMammal marineMammal) {
    this.marineMammal = marineMammal;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(marineMammal, node.marineMammal) && Objects.equals(
        nextNode, node.nextNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(marineMammal, nextNode);
  }

  @Override
  public String toString() {
    return "Node{" +
        "marineMammal=" + marineMammal +
        ", nextNode=" + nextNode +
        '}';
  }
}
