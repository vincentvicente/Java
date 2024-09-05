package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPlayerTest {

  private BaseballPlayer player1;
  private BaseballPlayer player2;
  private BaseballPlayer player3;
  private Name name1;
  private Name name2;

  @BeforeEach
  void setUp() {
    name1 = new Name("John", "Doe", "Author");
    name2 = new Name("Jane", "Smith", "Marian");
    player1 = new BaseballPlayer(name1, 180.0, 75.0, "MLB", "Red Sox", 0.275, 28);
    player2 = new BaseballPlayer(name1, 180.0, 75.0, "MLB", "Red Sox", 0.275, 28);
    player3 = new BaseballPlayer(name2, 175.0, 70.0, "Yankees", 0.3, 30);
  }

  @Test
  void getTeam() {
    assertEquals("Red Sox", player1.getTeam());
    assertEquals("Yankees", player3.getTeam());
  }

  @Test
  void getAvgBattingScore() {
    assertEquals(0.275, player1.getAvgBattingScore());
    assertEquals(0.3, player3.getAvgBattingScore());
  }

  @Test
  void getSeasonHomeRuns() {
    assertEquals(Integer.valueOf(28), player1.getSeasonHomeRuns());
    assertEquals(Integer.valueOf(30), player3.getSeasonHomeRuns());
  }

  @Test
  void testEquals() {
    assertEquals(player1, player2);
    assertNotEquals(player1, player3);
    assertNotEquals(player1, null);
    assertNotEquals(player1, new Object());
  }

  @Test
  void testHashCode() {
    assertEquals(player1.hashCode(), player2.hashCode());
    assertNotEquals(player1.hashCode(), player3.hashCode());
  }

  @Test
  void testToString() {
    String expected1 = "BaseballPlayer{team='Red Sox', avgBattingScore=0.275, seasonHomeRuns=28, athletesName=Name{firstName='John', middleName='Doe', lastName='Author'}, height=180.0, weight=75.0, league='MLB'}";
    String expected3 = "BaseballPlayer{team='Yankees', avgBattingScore=0.3, seasonHomeRuns=30, athletesName=Name{firstName='Jane', middleName='Smith', lastName='Marian'}, height=175.0, weight=70.0, league='null'}";
    assertEquals(expected1, player1.toString());
    assertEquals(expected3, player3.toString());
  }
}
