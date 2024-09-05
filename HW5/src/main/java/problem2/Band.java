package problem2;

import java.util.List;
import java.util.Objects;

/**
 * Class representing a band.
 */
public class Band extends Creator {
  private String name;
  private List<RecordingArtist> members;

  /**
   * Constructs a Band with the specified name and members.
   *
   * @param name The name of the band.
   * @param members The list of recording artists who are members of the band.
   */
  public Band(String name, List<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * Gets the name of the band.
   *
   * @return The name of the band.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the list of members of the band.
   *
   * @return The list of members of the band.
   */
  public List<RecordingArtist> getMembers() {
    return members;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Band band = (Band) o;
    return Objects.equals(name, band.name) &&
        Objects.equals(members, band.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }
}
