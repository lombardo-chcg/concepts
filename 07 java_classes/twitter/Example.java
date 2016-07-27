import java.util.Date;

import com.lombardo.Tweet;

public class Example {

  public static void main(String[] args) {
    Tweet tweet = new Tweet(
      "bob",
      "bob's in the house",
      new Date()
    );
    System.out.printf("Tweet info: %s %n", tweet);
  }

}
