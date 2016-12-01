package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Seth Morris
 * @version 1.0 10/14/16
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = new String("Mountain Biking");
		this.buildMemesList();
		this.buildPoliticalTopicsList();
	}
	
	/**
	 * Creates the list of .meme data members.
	 */
	private void buildMemesList()
	{
		memesList.add("doge");
        memesList.add("cute animals");
        memesList.add("grumpy cat");
        memesList.add("dat boi");
        memesList.add("willy wonka");
        memesList.add("harambe");
        memesList.add("john cena");
        memesList.add("pawn stars");
        memesList.add("pepe");
        memesList.add("ken bone");
        memesList.add("bad luck brian");
        memesList.add("michael phelps");
        memesList.add("sponge bob");
        memesList.add("pope");
        memesList.add("arthur");
        memesList.add("danny phantom");
        memesList.add("boi");
        memesList.add("battlefield 1");
        memesList.add("icup");
        //memesList.add("")
	}
	
	/**
	 * Creates the list of .politicalTopic data members.
	 */
	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("McMullen");
		politicalTopicList.add("Illuminati");
		politicalTopicList.add("Lies");
		politicalTopicList.add("Deleted emails");
		politicalTopicList.add("Sexism");
		politicalTopicList.add("The Great Wall");
		politicalTopicList.add("Hillary Dabbing");
		politicalTopicList.add("Foreign Policy");
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("liberal");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("Donald");
		politicalTopicList.add("The Don");
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		String temp = "💩";
		System.out.println(temp + temp.toLowerCase());
						
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{	
		boolean hasPolitical = false;
		
		for (int index = 0; index < politicalTopicList.size(); index++)
		{
			if (currentInput != null && currentInput.equals(politicalTopicList.get(index)))
			{
			hasPolitical = true;
			}
		}
		return hasPolitical;
	}	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for (int index = 0; index < memesList.size(); index++)
		{
			if (currentInput != null && currentInput.contains(memesList.get(index)))
			{
			hasMeme = true;
			}
		
		}
		return hasMeme;
	}
	
	/**
	 * Checks the currentInput of the user for keyboard mashing.
	 * @param currentInput
	 * @return
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean didMash = false;
		
		if((currentInput.contains("sdf") || currentInput.contains("derf") || currentInput.contains("asdf") || currentInput.contains("dfg") || currentInput.contains(",./")))
		{
			didMash = true;
		}
		return didMash;
	}
	
	/**
	 * Checks the currentInput of the user for HTML tags. Don't Know what that means, but thats what it does.
	 * @param currentInput
	 * @return
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		boolean htmlBool = false;
		
		if(currentInput.contains("<P>"))
		{
			htmlBool = true;
		}
		else if(currentInput.contains("<A HREF=\""))
		{
			int index = currentInput.indexOf("<A HREF=\"") + 9;
			String sub = currentInput.substring(index);
			
			if(sub.contains("\">"))
			{
				int index2 = sub.indexOf("\">");
				String sub2 = sub.substring(index2);
				
				if(sub2.contains(" </a>"))
				{
					htmlBool = true;
				}
			}
		}
		else if(currentInput.contains("<"))
		{
			String lower = currentInput.toLowerCase();
			int openIndex1 = lower.indexOf("<") + 1;
			String tag = "";
			if(lower.contains(">"))
			{
				int openIndex2 = lower.indexOf(">");
				tag = lower.substring(openIndex1, openIndex2);
				
				String sub = lower.substring(openIndex2 + 1);
				
				if(sub.contains("</" + tag + ">"))
				{
					htmlBool = true;
				}
			}
		}
		return htmlBool;
	}
	
	/**
	 * Checks the currentInput of the user for Twitter tags or usernames.
	 * @param currentInput
	 * @return
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean twitterbool = false;
		String trimmed = currentInput.replaceAll(" ",  "");
		if(trimmed.length() >1 && !currentInput.startsWith(" "))
		{
			twitterbool = true;
		}
		return twitterbool;
	}
	
	/**
	 * Checks the currentInput of the user for the command to quit.
	 * @param currentInput
	 * @return
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean didquit = false;
		
		if(currentInput.equalsIgnoreCase("Quit") || currentInput.equalsIgnoreCase("Exit"));
		{
			didquit = true;
		}
		return didquit;
	}
	
	//GETTERS-----------------------------------------------------------------------------------
	
	
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	
	//SETTTERS---------------------------------------------------------------------------------
	
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * Updates the memes content area for this Chatbot instance
	 * @param memesList
	 */
	public void setMemesList(ArrayList<String> memesList)
	{
		this.memesList = memesList;
	}
	
	/**
	 * Updates the political topics content area for this Chatbot instance.
	 * @param politicalTopicList
	 */
	public void setPoliticalTopicList(ArrayList<String> politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}
	
	/**
	 * Updates the username parameters for this Chatbot instance.
	 * @param userName
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}

