package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JLabel chatLabel;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5,25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		chatLabel = new JLabel("Shall we play a game?");
	
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatLabel);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 10, SpringLayout.NORTH, this);
		chatField.setHorizontalAlignment(SwingConstants.CENTER);
		baseLayout.putConstraint(SpringLayout.NORTH, chatField, 28, SpringLayout.SOUTH, chatDisplay);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 0, SpringLayout.WEST, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 72, SpringLayout.WEST, this);
		chatButton.setVerticalAlignment(SwingConstants.BOTTOM);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 55, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 145, SpringLayout.WEST, this);
	}
	
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
