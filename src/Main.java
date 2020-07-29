import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("this is just a test");
		NewTweet();	
				
		}
			
		public static void NewTweet() {
			Twitter twitter = TwitterFactory.getSingleton();
			String myTweet ="This is a test tweet";
			try {
			   Status status = twitter.updateStatus(myTweet);
			   System.out.print("Sucessful " + status.getText());
			}
			catch(TwitterException e){
				e.printStackTrace();
				System.out.print("failed");
				}
			}


}
