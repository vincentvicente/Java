package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecordingArtistTest {

  @Test
  public void testRecordingArtistCreation() {
    RecordingArtist artist = new RecordingArtist("John", "Lennon");
    assertEquals("John", artist.getFirstName());
    assertEquals("Lennon", artist.getLastName());
  }

  @Test
  public void testRecordingArtistEqualsAndHashCode() {
    RecordingArtist artist1 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist2 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist3 = new RecordingArtist("Paul", "McCartney");

    assertEquals(artist1, artist2);
    assertNotEquals(artist1, artist3);

    assertEquals(artist1.hashCode(), artist2.hashCode());
    assertNotEquals(artist1.hashCode(), artist3.hashCode());
  }
}
