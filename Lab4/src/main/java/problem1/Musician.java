package problem1;

import java.util.ArrayList;

class Musician extends Artist implements MusicArtist {
  private String recordingCompany;
  private String lastRecordAlbum;

  public Musician(String name, int age, ArrayList<String> genres, String recordingCompany, String lastRecordAlbum) {
    super(name, age, genres);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  @Override
  public String getRecordingCompany() {
    return recordingCompany;
  }

  @Override
  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}
