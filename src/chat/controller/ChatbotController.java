package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	
	public ChatbotController()
	{
		stupidBot = new Chatbot("Farty McFartFace");
	}
	
	public void start()
	{
		String response = "talking to you";
		
		while(stupidBot.lengthChecker(response))
		{
			response = chatView.collectResponse("What shall we talk about today?");
		}
	}
}
