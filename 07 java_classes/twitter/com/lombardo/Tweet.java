package com.lombardo;

import java.util.Date;

public class Tweet {
  private String mAuthor;
  private String mDescription;
  private Date mCreationDate;

  public Tweet(String author, String description, Date creationDate) {
    mAuthor = author;
    mDescription = description;
    mCreationDate = creationDate;
  }

  @Override
  public String toString() {
    return "Tweet: \"" + mDescription + "\" @" + mAuthor;
  }

  public String getAuthor() {
    return mAuthor;
  }

  public String getDescription() {
    return mDescription;
  }

  public Date getCreationDate() {
    return mCreationDate;
  }

}
