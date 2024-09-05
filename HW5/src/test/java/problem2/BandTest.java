package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class BandTest {

  @Test
  public void testBandCreation() {
    RecordingArtist artist1 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist2 = new RecordingArtist("Paul", "McCartney");
    List<RecordingArtist> members = Arrays.asList(artist1, artist2);
    Band band = new Band("The Beatles", members);

    assertEquals("The Beatles", band.getName());
    assertEquals(members, band.getMembers());
  }

  @Test
  public void testBandEqualsAndHashCode() {
    RecordingArtist artist1 = new RecordingArtist("John", "Lennon");
    RecordingArtist artist2 = new RecordingArtist("Paul", "McCartney");
    List<RecordingArtist> members1 = Arrays.asList(artist1, artist2);
    List<RecordingArtist> members2 = Arrays.asList(artist1);

    Band band1 = new Band("The Beatles", members1);
    Band band2 = new Band("The Beatles", members1);
    Band band3 = new Band("The Beatles", members2);

    assertEquals(band1, band2);
    assertNotEquals(band1, band3);

    assertEquals(band1.hashCode(), band2.hashCode());
    assertNotEquals(band1.hashCode(), band3.hashCode());
  }
}
