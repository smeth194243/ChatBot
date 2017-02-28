package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Initiates data members and holds everything. Extends the JPanel class.
 * @author smor7432
 *
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JLabel chatLabel;
	private JScrollPane chatPane;
	
	/**
	 * Initiates the different parts of the Panel and calls setup methods
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatField = new JTextField(25);
		
		chatButton = new JButton("Chat with the bot");
		
		chatLabel = new JLabel("Shall we play a game?");
		
		chatPane = new JScrollPane();
	
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Modifies the display, changing the users abilities.
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatPane.setViewportView(chatDisplay);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
	}
	
	/**
	 * Sets up the panel, background, and adds data members.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatPane);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatLabel);
		chatDisplay = new JTextArea(5,25);
		
		add(chatDisplay);
		
	}
	
	/**
	 * Sets up the layout and holds all the constraints from the WindowBuilder.
	 */
	private void setupLayout()
	{
		chatField.setHorizontalAlignment(SwingConstants.CENTER);
		chatButton.setVerticalAlignment(SwingConstants.BOTTOM);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 103, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -7, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 149, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -57, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatLabel, 0, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -25, SpringLayout.NORTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 0, SpringLayout.WEST, chatField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -15, SpringLayout.NORTH, chatField);
	}
	
	/**
	 * Sets up the actions and responses to actions from the user and/or chatbot.
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				
				chatDisplay.setText("You said: " + userWords + "\n" + "Chatbot said " + botResponse);
				chatField.setText("");
			}
		});
	}
	
}
