import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterReader {

	public static void main(String[] args) throws TwitterException, InterruptedException {

		final int NR_STATUSES = 7;
		String status = null;
		Twitter twitter = new TwitterFactory().getInstance();
		

		twitter.setOAuthConsumer("E4gcQjp5bpmBjen3pBdw", "uzTlv37gBBEsVYIXREUkXmTdiJyZI0JnJrHK7s93U");

		twitter.setOAuthAccessToken(new AccessToken("1885122589-DLQ5KlC4I4dpEOwTAuOqbZOAZXGErlAgnnkP0qP", 
				"x9NDGbxJEazFhNstsh5WVMdmcGkNGBHL6bjWU5VqFA"));

		System.out.println(twitter.getScreenName());
		ResponseList<Status> responses = twitter.getUserTimeline(new Paging(1, NR_STATUSES));
		for (Status response : responses) {
			status = response.getText();
			if (status.contains("wvu")) {
				status = status.replace("wvu", "West Virginia University");
				System.out.println("Your new status length is: " + (status.length() - 1));
				
			} else if (!(status.contains("wvu"))) {
				//else if is not needed because if(status.contains("wvu")) is already saying
				//if that is true then enter this else means that the if statement is not true
				status = status.concat(" #wvu");
			
			}
			
			System.out.println(status);
			twitter.updateStatus(status);
		}
		
		
	}

}
