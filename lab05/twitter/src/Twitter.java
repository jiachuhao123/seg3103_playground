public class Twitter {

  public String loadTweet()
  {
    try {
      Thread.sleep(0);
    } catch (InterruptedException e) {}

    double r =  Math.random();
    if (r <= 0.45) {
      return "I am tweet that likes to talk about @me";
    } else if (r <= 0.9) {
      return "Hello to @you";
    } else {
      return null;
    }
  }

  public boolean isMentionned(String name) {
    String tweet = loadTweet();
    if (tweet == null) {
    	return false;
    }
    
    String a = tweet;
	String str=a.substring(0,a.indexOf("@"));
	String b = a.substring(str.length()+1,a.length());
    

    return b.equals(name);
  }

}