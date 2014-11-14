package de.alosdev.cloud.devfestist14.domain;

/**
 * Created by hhosgel on 14.11.14.
 */
public class Thumbnail {
  private String path;

  private String extension;

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getPath() {
    return path + "." + extension;
  }

  @Override
  public String toString() {
    return getPath();
  }
}
