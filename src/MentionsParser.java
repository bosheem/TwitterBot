import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MentionsParser {
	
	//get text from the mention
	public String getStatusText() {
		//create variable to hold mentionsTimeline
		ResponseList<Status> mentionsTimeline = null;
		
		Twitter twitter = TwitterFactory.getSingleton();
		try {
		mentionsTimeline = twitter.getMentionsTimeline();
		
		}
		catch(TwitterException e){
			e.printStackTrace();
		}
			
		//get the most recent mention 
		Status mentionsAtZero = mentionsTimeline.get(0);
		//get the text from the most recent mention
		String mentionsText = mentionsAtZero.getText();
		
		//print mentions text (this will be removed, used to test result)
		//System.out.println(mentionsText);
		
		//FIX ME 
		//Parse out the @screenname 
		
		return mentionsText;
		
	}
	
	public String getMentionsScreenName() {
		ResponseList<Status> mentionsTimeline = null;
		
		Twitter twitter = TwitterFactory.getSingleton();
		try {
		mentionsTimeline = twitter.getMentionsTimeline();
		
		}
		catch(TwitterException e){
			e.printStackTrace();
		}
			
		Status mentionsAtZero = mentionsTimeline.get(0);
		User mentionsUser = mentionsAtZero.getUser();
		String mentionsScreenName = mentionsUser.getScreenName();
		//System.out.println(mentionsScreenName);
		
		return mentionsScreenName;
	}
	
	//get tweetID
	public Long getTweetID() {
		ResponseList<Status> mentionsTimeline = null;
		
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			mentionsTimeline = twitter.getMentionsTimeline();
		}
		catch(TwitterException e) {
			e.printStackTrace();
		}
		
		Status mentionsAtZero = mentionsTimeline.get(0);
		Long mentionsStatusID = mentionsAtZero.getId();
		
		return mentionsStatusID;
	}

}
