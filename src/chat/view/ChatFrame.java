package chat.view;


import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatController;

/**
 * The ChatFrame extends or accesses the JFrame library
 * @author smor7432
 *
 */

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	
	/**
	 * Creates the frame for the GUI by importing stuff from the controller and initializing said stuff
	 * @param baseController
	 */
	
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		this.appPanel = new ChatPanel(baseController);
		this.setupFrame();
	}
	
	/**
	 * Sets up the frame by defining the constraints.
	 */
	
	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("ChatBot");
		this.setSize(new Dimension(600,400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
