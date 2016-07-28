import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;  // collection of unique items
import java.util.TreeSet; // ordered Set

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
    
    Set<String> allHashTags = new HashSet<String>();
    Set<String> allMentions = new TreeSet<String>();
    
    for (Tweet t : tweets) {
      allHashTags.addAll(t.getHashTags());
      allMentions.addAll(t.getMentions());
    }
    System.out.printf("Hash tags: %s %n", allHashTags);
    System.out.printf("Mentions: %s %n", allMentions);
    
    Map<String, Integer> hashTagCount = new HashMap<String, Integer>();
    for (Tweet t : tweets) {
      for (String hashTag : t.getHashTags()) {
        Integer count = hashTagCount.get(hashTag);
        if (count == null) {
          count = 0;
        }
        count ++;
        hashTagCount.put(hashTag, count);
      }
    }
   System.out.printf("Hash Tag counts: %s %n", hashTagCount);
    
   Map<String, List<Tweet>> tweetsByAuthor = new HashMap<String, List<Tweet>>();
   for (Tweet t : tweets ) {
    List<Tweet> authoredTweets = tweetsByAuthor.get(t.getAuthor());
    if (authoredTweets == null) {
      authoredTweets = new ArrayList<Tweet>();
      tweetsByAuthor.put(t.getAuthor(), authoredTweets);
    }
    authoredTweets.add(t);
   }
   System.out.printf("FUCKING BULL SHIT MAN! %s %n", tweetsByAuthor);  
    
  }    
  
}