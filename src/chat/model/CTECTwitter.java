package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import twitter4j.Paging;

public class CTECTwitter 
{
	private ChatController baseController;
	private List<Status> allTheTweets;
	private List<String> tweetedWords;
	
	private Twitter twitterBot;
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		allTheTweets = new ArrayList<Status>();
		tweetedWords = new ArrayList<String>();
		twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus("@gaeblejones To join the genius posse, one must make a home-made twitter bot. :D");
			//("I, Seth Morris, just tweeted from my Java Chatbot program 2017!" + " #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
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
	
	private String [] createIgnoredWordsArray()
	{
		String [] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			boringWordScanner.nextLine();
			wordCount++;
		}
		boringWordScanner.close();

		boringWords = new String [wordCount]; 
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		
		return null;
	}

	private String calculateTopWord()
	{
		String results = " ";
		String topWord = " ";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord = tweetedWords.get(mostPopularIndex);
			}
		}
		results += " the most popular word was " + topWord + ", and it occurred " + popularCount + " times.";
		results += "\nThat means it has a percentage of " +((double) popularCount)/tweetedWords.size()*100 + "%";
		
		return results;
		}
	
	
	public String getMostPopularWord(String username)
	{
		gatherTheTweets(username);
		turnTweetsToWords();
		removeBoringWords();
		removeBlankWords();
		
		String information = "The tweetcount is " + allTheTweets.size() +
				" and " + username + "'s"+ calculateTopWord();
		
		return " ";
	}
	
	private void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordsArray();
		
		for(int index = 0; index< tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				{
					tweetedWords.remove(index);
					index --;
					boringIndex = boringWords.length;
				}
			}
		}
	}
	
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(" "))
			{
				tweetedWords.remove(index);
				index --;
			}
		}
	}
	
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1;
		Paging statusPage = new Paging(1,200);
		
		while(pageCount <= 10)
		{
			try
			{
			allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			}
			catch (TwitterException twitterError)
			{
				baseController.handleErrors(twitterError);
			}
			pageCount++;
		}
	}
	
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String tweetText = currentTweet.getText();
			String [] tweetWords = tweetText.split(" ");
			
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
			}
		}
	}
}
