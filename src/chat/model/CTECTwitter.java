package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;

public class CTECTwitter 
{
	private ChatController baseController;
	
	private Twitter twitterBot;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
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
}
