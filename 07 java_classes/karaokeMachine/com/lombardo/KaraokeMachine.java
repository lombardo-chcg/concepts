package com.lombardo;

import com.lombardo.model.Song;
import com.lombardo.model.SongBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class KaraokeMachine {
 private SongBook mSongBook;
 private BufferedReader mReader; 
 private Map<String, String> mMenu; 
  
 public KaraokeMachine(SongBook songBook) {
   mSongBook = songBook;
   mReader = new BufferedReader (new InputStreamReader(System.in));
   mMenu = new HashMap<String, String>();
   mMenu.put("add", "add a new song");
   mMenu.put("quit", "Exit the program");  
 }
  
 private String promptAction() throws IOException {
  System.out.printf("There are %d songs available.  your options are: %n", mSongBook.getSongCount());
  for (Map.Entry<String, String> option : mMenu.entrySet()) {
    System.out.printf("%s - %s %n", option.getKey(), option.getValue());  
  }
  System.out.print("Please choose an option: "); 
  String choice = mReader.readLine(); 
  return choice.trim().toLowerCase(); 
 }
  
 public void run() {
  String choice = "";
  do {
    try {
      choice = promptAction();
      switch(choice) {
        case "add": 
          Song song = promptNewSong();
          mSongBook.addSong(song);
          System.out.printf("%s was successfully added! %n", song);  
          break;
        case "quit":
          System.out.println("thanks for playing");
          break;
        default:
          System.out.println("whoops please try again");
      }
    } catch(IOException ioe) {
      System.out.println("problem with input");
      ioe.printStackTrace();
    }
  }
  while (!choice.equals("quit"));  
 }
  
 private Song promptNewSong() throws IOException {
  System.out.print("Enter artist name: ");
  String artist = mReader.readLine();
  System.out.print("Enter title: ");
  String title = mReader.readLine();
  System.out.print("Enter youtube url: ");
  String videoUrl = mReader.readLine();
 
  return new Song(artist, title, videoUrl);
 }     
}
