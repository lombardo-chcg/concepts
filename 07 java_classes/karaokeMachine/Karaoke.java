import com.lombardo.model.Song;
import com.lombardo.model.SongBook;
import com.lombardo.KaraokeMachine;

public class Karaoke {
  
 public static void main(String[] args) {
  Song song = new Song(
    "Tame Impala",
    "Less I Know the Better",
    "https://www.youtube.com/watch?v=sBzrzS1Ag_g");
   
  SongBook songBook = new SongBook();
  KaraokeMachine machine = new KaraokeMachine(songBook);
  machine.run();   
 }
}
  