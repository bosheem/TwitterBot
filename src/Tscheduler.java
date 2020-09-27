import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.TimerTask;
import java.util.Scanner;

public class Tscheduler extends TimerTask {
	
	 Main mane = new Main();

	@Override
	public void run() {

		// TODO Auto-generated method stub
		int count = 0; 
		mane.NewTweet(); 
		++count;
		
		if(count > 500)
			System.exit(0);
	}
	
	

}
