import java.util.Scanner;

public class WebTags {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int atSign = 0;
		int hashTag = 0;
		int webLink = 0;
		String status = null;
		String personTag = null;
		String topicTag = null;
		String linkTag = null;
		int atSignWhiteSpace = 0;
		int hashTagWhiteSpace = 0;
		int webLinkWhiteSpace = 0;
		
		
		System.out.println("Update your status and make sure you tag someone, hashtag a topic, and also provide a web link.");
		status = input.nextLine();
		
		
		atSign = status.indexOf('@');
		atSignWhiteSpace = status.indexOf(" ", atSign + 1);
		hashTag = status.indexOf('#');
		hashTagWhiteSpace = status.indexOf(" ", hashTag + 1);
		webLink = status.indexOf("http://");
		webLinkWhiteSpace = status.indexOf(" ", webLink + 1);
		
		
		
		personTag = (atSignWhiteSpace == -1) ? status.substring(atSign) : status.substring(atSign + 1, atSignWhiteSpace);
		topicTag = (hashTagWhiteSpace == -1) ? status.substring(hashTag) : status.substring(hashTag + 1, hashTagWhiteSpace);
		linkTag = (webLinkWhiteSpace == -1) ? status.substring(webLink) : status.substring(webLink, webLinkWhiteSpace);
		
		System.out.println("usertag: " + personTag);
		System.out.println("hashtag: " + topicTag);
		System.out.println("    URL: " + linkTag);
		
		
		
	}
}
