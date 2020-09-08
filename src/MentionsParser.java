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
	public String getStatusText(Status statusToUpdate) {

		//get the text from the most recent mention
		String mentionsText = statusToUpdate.getText();
		
		//print mentions text (this will be removed, used to test result)
		//System.out.println(mentionsText);
        
        String[] mentionsTextArr = mentionsText.split(" ");
        String parsedText = "";

        for(int i = 0; i <= mentionsTextArr.length - 1; ++i){
            if(mentionsTextArr[i].charAt(0) == '@'){
               mentionsTextArr[i] = "";
            }
        parsedText = parsedText + mentionsTextArr[i] + " ";
        }
        
        System.out.println(parsedText);
        
		return parsedText;
		
	}
	
	public String getMentionsScreenName(Status screenNameToUpdate) {

		User mentionsUser = screenNameToUpdate.getUser();
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
