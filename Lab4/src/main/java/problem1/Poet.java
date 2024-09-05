package problem1;

import java.util.ArrayList;

class Poet extends Artist implements PoetArtist {
  private String publishingCompany;
  private String lastPublishedCollection;

  public Poet(String name, int age, ArrayList<String> genres, String publishingCompany, String lastPublishedCollection) {
    super(name, age, genres);
    this.publishingCompany = publishingCompany;
    this.lastPublishedCollection = lastPublishedCollection;
  }

  @Override
  public String getPublishingCompany() {
    return publishingCompany;
  }

  @Override
  public String getLastPublishedCollection() {
    return lastPublishedCollection;
  }
}
