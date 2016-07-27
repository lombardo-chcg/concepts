package com.lombardo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tweet implements Comparable<Tweet>, Serializable {
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
  public int compareTo(Tweet other) {
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

  public List<String> getWords() {
    String[] words = mDescription.toLowerCase().split("[^\\w@#']+");
    return Arrays.asList(words);
  }

  public List<String> getHashTags() {
    return getWordsWithPrefix("#");
  }

  public List<String> getMentions() {
    return getWordsWithPrefix("@");
  }

  private List<String> getWordsWithPrefix(String prefix) {
    List<String> results = new ArrayList<String>();
    for (String word : getWords()) {
      if (word.startsWith(prefix)) {
        results.add(word);
      }
    }
    return results;
  }

}
