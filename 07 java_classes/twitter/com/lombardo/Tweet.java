package com.lombardo;

import java.io.Serializable;
import java.util.Date;

public class Tweet implements Comparable, Serializable {
  private static final long serialVersionUID = 4568266612889551649L; //stamps the class to allow changes after serialization without breaking the program

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
    return String.format("Tweet: \"%s\" by %s on %s", mDescription, mAuthor, mCreationDate);
  }

  @Override
  public int compareTo(Object obj)  {
    Tweet other = (Tweet) obj;
    if (equals(other)) {
      return 0;
    }
    int dateComp = mCreationDate.compareTo(other.mCreationDate);
    if (dateComp == 0) {
      return mDescription.compareTo(other.mDescription);
    }
    return dateComp;
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

  public String[] getWords() {
    return mDescription.toLowerCase().split("[^\\w@#']+");
  }
}
