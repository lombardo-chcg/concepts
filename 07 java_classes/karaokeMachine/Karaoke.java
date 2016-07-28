import com.lombardo.model.Song;
import com.lombardo.model.SongBook;
import com.lombardo.KaraokeMachine;

public class Karaoke {
  
 public static void main(String[] args) {
  SongBook songBook = new SongBook();
  songBook.importFrom("songs.txt");
  KaraokeMachine machine = new KaraokeMachine(songBook);
  machine.run();
  System.out.println("Saving song book");
  songBook.exportTo("songs.txt");                     
 }
}
  