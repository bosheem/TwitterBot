import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
	
	static MentionsParser mentionsParser = new MentionsParser();
	static ResponseList<Status> previousMentions = null;
	static ResponseList<Status> currentMentions = null;
	static ResponseList<Status> mentionsToUpdate = null;
	static int count;

	public static void main(String[] args){
		// TODO Auto-generated method stub
			
		MentionsToUpdate();
		
		//Timer timer = new Timer();
		//TimerTask task = new ReplyToMentions();
				
		//timer.scheduleAtFixedRate(task, new Date(), 2000);
		
		}
			
		/*public static void NewTweet() {
			Twitter twitter = TwitterFactory.getSingleton();
			
			//store the screenName for most recent mention into userScreenName
			//String userScreenName = mentionsParser.getMentionsScreenName();
			//construct tweet using the userScreenName
			//String myTweet ="@" + userScreenName + " you should play Super Metroid";
			
			//update the status
			try {
			   Status status = twitter.updateStatus(myTweet);
			   System.out.print("Sucessful " + status.getText());
			}
			catch(TwitterException e){
				e.printStackTrace();
				System.out.print("failed");
				}
			} */
		
		public static ResponseList<Status> MentionsToUpdate(){ 
			
			Twitter t = TwitterFactory.getSingleton();
			try {
			currentMentions = t.getMentionsTimeline();		
			}
			catch(TwitterException e){
				e.printStackTrace();
			}
			
			try {
			mentionsToUpdate = t.getMentionsTimeline();		
			}
			catch(TwitterException e){
				e.printStackTrace();
			}
			
			if (previousMentions == null) {
				ResponseList<Status> previousMentionsHolder = null;
				try {
					previousMentionsHolder = t.getMentionsTimeline();		
					}
				catch(TwitterException e){
					e.printStackTrace();
					}
				
				previousMentions = previousMentionsHolder;
				previousMentions.remove(0);
			}
			
			for(int i = 0; i <= previousMentions.size() - 1; ++i){
				   for(int j = 0; j <= currentMentions.size() - 1; ++j){
					   System.out.println(previousMentions.get(i).equals(currentMentions.get(j)));
				      if(previousMentions.get(i).equals(currentMentions.get(j))){
				         mentionsToUpdate.remove(j);
				     }
				   }
				}

			return mentionsToUpdate;
		}
			/*
			

			
			if(currentMentions != previousMentions) {
				count = currentMentions.size();
				int difference = currentMentions.size() - previousMentions.size();
				System.out.println(currentMentions.size());
				System.out.println(previousMentions.size());
				System.out.println(difference);
				for(int i = previousMentions.size(); i > 0; i--) {
					System.out.println(i);
					if(currentMentions.get((i - 1) + difference) == previousMentions.get(i - 1)) {
						count -= 1;
						System.out.println(count);
					}
				}
				for(int i = 0; i <= count - 1; ++i) {
					mentionsToUpdate.add(currentMentions.get(i));
				}
				
				previousMentions = currentMentions;
			}
			
			System.out.println(previousMentions == currentMentions);
			System.out.println(previousMentions.size());
			System.out.println(currentMentions.size());
			
			System.out.println("These are the " + mentionsToUpdate);
				
			//mentionsParser.getStatusText();
			//mentionsParser.getMentionsScreenName();
			
			//NewTweet();
			
			return mentionsToUpdate;
		}
		*/
		
	 class ReplyToMentions extends TimerTask{
		public void run() {
			
			Twitter t = TwitterFactory.getSingleton();
			
			ResponseList<Status> mentionsToUpdate = MentionsToUpdate();
			
			if(mentionsToUpdate != null) {
				
				String screenName = "";
				String statusText = "";

				for(int i = 0; i < mentionsToUpdate.size(); ++i) {
					Status statusToUpdate = mentionsToUpdate.get(i);
					screenName = mentionsParser.getMentionsScreenName(statusToUpdate);
					statusText = mentionsParser.getStatusText(statusToUpdate);

					//construct tweet using the userScreenName
					String myTweet ="@" + screenName + " you should play Super Metroid";

					//update the status
					try {
						Status status = t.updateStatus(myTweet);
						System.out.print("Sucessful " + status.getText());
					}
					catch(TwitterException e){
						e.printStackTrace();
						System.out.print("failed");
					}
				}
			 }
		  }
		}
	

	

	
}
