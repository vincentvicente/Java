package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RegattaDirectoryTest {

  private Regatta regatta1;
  private Regatta regatta2;
  private RegattaDirectory directory;

  @BeforeEach
  public void setUp() {
    regatta1 = new Regatta("1", "Regatta 1", "USA", "California", "Nevada", 300.0,
        LocalDate.of(2023, 5, 10), RegattaLevel.NATIONS_CUP, true);
    regatta2 = new Regatta("2", "Regatta 2", "USA", "Florida", "Georgia", 150.0,
        LocalDate.of(2022, 6, 15), RegattaLevel.REGIONAL_GAMES, true);
    directory = new EmptyRegattaDirectory();
  }

  @Test
  public void testContainsRegatta() {
    directory = directory.addRegatta(regatta1);
    assertTrue(directory.containsRegatta(regatta1));
    assertFalse(directory.containsRegatta(regatta2));
  }

  @Test
  public void testFindAllRegattaBasedOnLevel() {
    directory = directory.addRegatta(regatta1);
    directory = directory.addRegatta(regatta2);
    RegattaDirectory result = directory.findAllRegattaBasedOnLevel(RegattaLevel.NATIONS_CUP);
    assertTrue(result.containsRegatta(regatta1));
    assertFalse(result.containsRegatta(regatta2));
  }

  @Test
  public void testFindAllRegattaBasedOnStartingPoint() {
    directory = directory.addRegatta(regatta1);
    directory = directory.addRegatta(regatta2);
    RegattaDirectory result = directory.findAllRegattaBasedOnStartingPoint("California");
    assertTrue(result.containsRegatta(regatta1));
    assertFalse(result.containsRegatta(regatta2));
  }
}