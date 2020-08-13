import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MentionsParser {
	
	//Get mentions list from java and parse it. 
	public String getStatusText() {
		ResponseList<Status> mentionsTimeline = null;
		
		Twitter twitter = TwitterFactory.getSingleton();
		try {
		mentionsTimeline = twitter.getMentionsTimeline();
		
		}
		catch(TwitterException e){
			e.printStackTrace();
		}
			
		Status mentionsAtZero = mentionsTimeline.get(0);
		String mentionsText = mentionsAtZero.getText();
		System.out.println(mentionsText);
		
		
		return mentionsText;
		
	}

}
