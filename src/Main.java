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
			
		//mentionsParser.getStatusText();
		//mentionsParser.getMentionsScreenName();
		
		}
			
		public static void NewTweet() {
			Twitter twitter = TwitterFactory.getSingleton();
			
			//store the screenName for most recent mention into userScreenName
			String userScreenName = mentionsParser.getMentionsScreenName();
			//construct tweet using the userScreenName
			String myTweet ="@" + userScreenName + " you should play Super Metroid";
			
			//update the status
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
