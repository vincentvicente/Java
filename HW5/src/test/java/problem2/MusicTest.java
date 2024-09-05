package problem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {

  @Test
  public void testMusicCreation() {
    RecordingArtist artist = new RecordingArtist("John", "Lennon");
    Music music = new Music("Imagine", 1971, artist);

    assertEquals("Imagine", music.getTitle());
    assertEquals(1971, music.getYear());
    assertEquals(artist, music.getCreator());
  }

  @Test
  public void testMusicEqualsAndHashCode() {
    RecordingArtist artist = new RecordingArtist("John", "Lennon");
    Music music1 = new Music("Imagine", 1971, artist);
    Music music2 = new Music("Imagine", 1971, artist);
    Music music3 = new Music("Hey Jude", 1968, artist);

    assertEquals(music1, music2);
    assertNotEquals(music1, music3);

    assertEquals(music1.hashCode(), music2.hashCode());
    assertNotEquals(music1.hashCode(), music3.hashCode());
  }
}
