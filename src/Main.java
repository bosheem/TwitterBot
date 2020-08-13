import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Main {
	
	static MentionsParser mentionsParser = new MentionsParser();

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		
		System.out.print("this is just a test");
		NewTweet();	
		Twitter t = TwitterFactory.getSingleton();
		try {
		System.out.print(t.getMentionsTimeline());
				
		}
		
		catch(TwitterException e){
			e.printStackTrace();
		}
			
		mentionsParser.getStatusText();
		mentionsParser.getMentionsScreenName();
		
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
