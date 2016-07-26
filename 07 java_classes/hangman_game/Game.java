public class Game {
  public static final int MAX_MISSES = 7; 
  private String mAnswer;
  private String mHits;
  private String mMisses;

  public Game(String answer) {
    mAnswer = answer; 
    mHits = "";
    mMisses = "";
  }
  
  private char validateGuess(char letter) {
    if (!Character.isLetter(letter)) {
      throw new IllegalArgumentException("A letter is required");
    }
    letter = Character.toLowerCase(letter);
    if (mMisses.indexOf(letter) >= 0 || mHits.indexOf(letter) >= 0) {
      throw new IllegalArgumentException("Hey!  You already guessed " + letter + "!");
    }
    
    return letter;
  }
  
  public boolean applyGuess(char letter) {
    letter = validateGuess(letter);
    boolean goodGuess = mAnswer.indexOf(letter) >= 0;
    if (goodGuess) {
      mHits += letter;  
    } else {
      mMisses += letter;  
    }
    return goodGuess;
  }
  
  public boolean applyGuess(String letters) {
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));
  }
  
  public String getProgress() {
    String progress = "";
    for (char letter : mAnswer.toCharArray()) {
      char display = '-';
      if (mHits.indexOf(letter) >= 0) {
        display = letter;
      }
     progress += display; 
    }
    return progress;
  }
  
  public int getRemainingTries() {
    return MAX_MISSES - mMisses.length();
  }
  
  public boolean isSolved() {
    return getProgress().indexOf('-') == -1; 
  }
  
  public String getAnswer() {
    return mAnswer;
  } 
}