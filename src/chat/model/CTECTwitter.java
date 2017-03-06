package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.ArrayList;
import java.util.List;

public class CTECTwitter 
{
	private ChatController baseController;
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	private Twitter twitterBot;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		searchedTweets = new ArrayList<Status>();
		ignoredWords = new ArrayList<String>();
		twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus("I, Seth Morris, just tweeted from my Java Chatbot program 2017!"
					+ " #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private void createIgnoredWordList()
	{
		
	}
	
	private void collectTweets(String username)
	{
		
	}
	
	public String getMostCommonWord()
	{
		return null;
	}
}
