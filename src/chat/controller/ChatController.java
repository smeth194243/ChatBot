package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;

/**
 * The main controller class.
 * @author smor7432
 *
 */

public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer display;
	private ChatFrame baseFrame;
	
	/**
	 * Declares the data members
	 */
	
	public ChatController()
	{
		stupidBot = new Chatbot("Farty McFartFace");
		display = new ChatViewer();
		baseFrame = new ChatFrame(this);
	}
	
	/**
	 * Starts the program and holds the main body of said program
	 */
	
	public void start()
	{
	/*	String response = display.collectResponse("What shall we talk about today?");
		
		while(stupidBot.lengthChecker(response))
		{
			display.displayMessage(useChatbotCheckers(response));
			response = display.collectResponse("Oh, you are interested in " + response + "?");
		}	
		*/
	}
	
	/**
	 * This method calls the checkers which check the input from the user,
	 * and sees if it contains the defined strings or values.
	 * @param input
	 * @return
	 */
	
	public String useChatbotCheckers(String input)
	{
		String answer = "";
		
	if(!stupidBot.quitChecker(input))
	{
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special secret\n";
		}
		
		if(stupidBot.memeChecker(input))
		{
			answer += "\nI can has memes?\n";
		}
		
		if(stupidBot.politicalTopicChecker(input))
		{
			answer += "\nAre you sure?\n";
		}
		
		if(!stupidBot.lengthChecker(answer))
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		if(stupidBot.inputHTMLChecker(input))
		{
			answer += "\nWhat am I, Google Chrome?\n";
		}
		
		if(stupidBot.twitterChecker(input))
		{
			answer += "\nThat should go on twitter :D\n";
		}
		
		int canBeRandom = (int) (Math.random() * 7);
		if (canBeRandom % 7 == 0)
		{
			answer += randomTopicGenerator();
		}
	}
	else
	{
		display.displayMessage("Thank you for chatting with me :D");
		System.exit(0);
	}
		return answer;
	}
	
	/**
	 * This method generates random topics for the user to talk with the chatbot about.
	 * @return
	 */
	
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch (random)
		{
		case 0 : 
			randomTopic = "Did you hear about the Beatles Daft Punk remix?";
			break;
		case 1:
			randomTopic = "Can I have some Mayo?";
			break;
		case 2:
			randomTopic = "Time for some industrial!";
			break;
		case 3:
			randomTopic = "Reading books is good.";
			break;
		case 4:
			randomTopic = "I love java.";
			break;
		case 5:
			randomTopic = "I like to bike!";
			break;
		case 6:
			randomTopic = "Who did this!?";
			break;
		default:
			randomTopic = "I can't believe this! :o :o";
			break;
		}
		
		return randomTopic;
	}
	
	public void handleErrors(Exception currentException)
	{
		display.displayMessage("An error has occured. Details provided next.");
		display.displayMessage(currentException.getMessage());
	}
	/**
	 * creates(gets) the BaseFrame method
	 * @return
	 */
	public Object getBaseFrame()
	{
		return baseFrame;
	}
	public ChatViewer getPopup()
	{
		return display;
	}
	
	/**
	 * creates(gets) the chatBot method
	 * @return
	 */
	public Object getChatbot()
	{
		return stupidBot;
	}
}
