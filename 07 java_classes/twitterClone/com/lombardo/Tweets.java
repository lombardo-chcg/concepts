package com.lombardo;

import java.io.*;

public class Tweets {
  public static void save(Tweet[] tweets) {
    try(
      FileOutputStream fos = new FileOutputStream("tweets.ser");  //file name
      ObjectOutputStream oos = new ObjectOutputStream(fos);
    ) {
      oos.writeObject(tweets);
    } catch (IOException ioe) {
      System.out.println("Problem saving tweets");
      ioe.printStackTrace();
    }
  }

  public static Tweet[] load() {
     Tweet[] tweets = new Tweet[0];
     try(
      FileInputStream fis = new FileInputStream("tweets.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
     ) {
       tweets = (Tweet[]) ois.readObject();
     } catch(IOException ioe) {
       System.out.println("File can't be read");
       ioe.printStackTrace();
     } catch(ClassNotFoundException cnfe) {
       System.out.println("Error reading Tweets");
       cnfe.printStackTrace();
     }

     return tweets;
  }
}
