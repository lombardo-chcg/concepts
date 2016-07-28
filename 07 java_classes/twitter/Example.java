import java.util.Arrays;
import java.util.Date;

import com.lombardo.Tweet;
import com.lombardo.Tweets;

public class Example {

  public static void main(String[] args) {
    Tweet tweet = new Tweet(
      "bob",
      "@bob's in the #house!",
      new Date()
    );

    Tweet tweet2 = new Tweet(
      "bob2",
      "hey @bob",
      new Date()
    );

    System.out.printf("Tweet info: %s %n", tweet);
    System.out.println("Words in this tweet are:");
    for (String word : tweet.getWords()) {
      System.out.println(word);
    }

    Tweet[] tweets = {tweet2, tweet};
    Arrays.sort(tweets);
    //for (Tweet t : tweets) {
    //  System.out.println(t);
    //}

    Tweets.save(tweets);

    Tweet[] reloadedTweets = Tweets.load();

    for (Tweet t : reloadedTweets) {
      System.out.println(t);
    }

    for (String hashtag : tweet.getHashTags()) {
      System.out.println("Hashtag present: " + hashtag);
    }
  }
}
