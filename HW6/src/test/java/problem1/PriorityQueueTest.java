package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

  private PriorityQueue emptyQueue;
  private PriorityQueue queue;

  @BeforeEach
  void setUp() {
    emptyQueue = PriorityQueue.createEmpty();
    queue = emptyQueue.add(5, "Medium Priority")
        .add(10, "High Priority")
        .add(3, "Low Priority")
        .add(10, "Another High Priority");
  }

  @Test
  void createEmpty() {
    assertTrue(emptyQueue.isEmpty());
  }

  @Test
  void isEmpty() {
    assertTrue(emptyQueue.isEmpty());
    assertFalse(queue.isEmpty());
  }

  @Test
  void add() {
    PriorityQueue newQueue = emptyQueue.add(1, "New Priority");
    assertFalse(newQueue.isEmpty());
    assertEquals("New Priority", newQueue.peek());

    PriorityQueue anotherQueue = queue.add(8, "Another Priority");
    assertEquals("High Priority", anotherQueue.peek());
  }

  @Test
  void peek() {
    assertEquals("High Priority", queue.peek());
    assertThrows(IllegalStateException.class, () -> {
      emptyQueue.peek();
    });
  }

  @Test
  void pop() {
    PriorityQueue newQueue = queue.pop();
    assertEquals("Another High Priority", newQueue.peek());

    PriorityQueue anotherQueue = newQueue.pop();
    assertEquals("Medium Priority", anotherQueue.peek());

    assertThrows(IllegalStateException.class, () -> {
      emptyQueue.pop();
    });
  }
}
