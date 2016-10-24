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
	}
	
	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("McMullen");
		politicalTopicList.add("Illuminati");
		politicalTopicList.add("Lies");
		politicalTopicList.add("Deleted emails");
		politicalTopicList.add("Sexism");
		politicalTopicList.add("The Great Wall");
		politicalTopicList.add("Hilary Dabbing");
		politicalTopicList.add("Foreign Policy");
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/4/16");
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
		return false;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		return false;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		return false;
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
	
	public void setMemesList(ArrayList<String> memesList)
	{
		this.memesList = memesList;
	}
	
	public void setPoliticalTopicList(ArrayList<String> politicalTopicList)
	{
		this.politicalTopicList = politicalTopicList;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}

