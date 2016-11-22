package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot project.
 * @author Seth Morris
 * @version 1.3 10/26/16 Added icon to output window.
 */
public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	/**
	 * Creates the public view thing.
	 */
	public ChatViewer()
	{
		windowMessage = "This is the chatbot speaking! :D";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}
	
	/**
	 * Collects responses from user.
	 * @param question
	 * @return
	 */
	public String collectResponse(String question)
	{
		String response = "";
		
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please.").toString();
		
		return response;
	}
	
	/**
	 * Confirms input from user
	 * @param question
	 * @return
	 */
	public int collectUserOption(String question)
	{
		int response = 0;
		
		response = JOptionPane.showConfirmDialog(null, question);
		
		return response;
	}
	
	/**
	 * Displays the message from the chatbot
	 * @param message
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
}

