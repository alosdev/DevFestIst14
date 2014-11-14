package de.alosdev.cloud.devfestist14.domain;

/**
 * Created by hhosgel on 14.11.14.
 */
public class Character {

  private String name;

  private Thumbnail thumbnail;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Thumbnail getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(Thumbnail thumbnail) {
    this.thumbnail = thumbnail;
  }
}
