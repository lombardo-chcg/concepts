public class Hangman {
    
  public static void main(String[] args) {
      // Enter amazing code here:
    Game game = new Game("hangman");
    Prompter prompter = new Prompter(game);
    prompter.play();
  }
}