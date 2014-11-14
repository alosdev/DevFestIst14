package de.alosdev.cloud.devfestist14.domain;

import java.util.ArrayList;

/**
 * Created by hhosgel on 14.11.14.
 */
public class Characters extends ArrayList<Character> {

  private int page;

  private int totalCount;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }
}
