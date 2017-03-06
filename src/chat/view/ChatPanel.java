package chat.view;

import javax.swing.*;
import java.awt.Color;
import chat.controller.ChatController;
import chat.controller.FileController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;
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
	private JButton saveButton;
	private JButton loadButton;
	private JButton sendTwitter;
	private JButton searchTwitter;
	
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
		chatDisplay = new JTextArea(5,25);
		chatButton = new JButton("Chat with the bot");
		chatLabel = new JLabel("Shall we play a game?");
		
		chatPane = new JScrollPane();
		
		
		saveButton = new JButton("Save");
	
		
		loadButton = new JButton("Load");
		
		
		sendTwitter = new JButton("Send a Tweet");
		
		
		searchTwitter = new JButton("Search Twitter");
		
		
	
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
		this.add(searchTwitter);
		this.add(sendTwitter);
		this.add(saveButton);
		this.add(loadButton);
		this.add(chatField);
		this.add(chatLabel);
		
		
		
		
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
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 0, SpringLayout.WEST, chatField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -15, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 103, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -125, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, sendTwitter, 0, SpringLayout.WEST, searchTwitter);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitter, 0, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitter, 6, SpringLayout.EAST, chatField);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTwitter, 1, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -6, SpringLayout.NORTH, loadButton);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 1, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, 0, SpringLayout.EAST, saveButton);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, chatField);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatLabel, -21, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, chatLabel, 0, SpringLayout.EAST, chatButton);
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
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText(currentText + "You said: " + userWords + "\n"
							+ "Chatbot said " + botResponse + "\n");
				chatDisplay.setCaretPosition(0);
				chatField.setText("");
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String fileName = chatField.getText();
				
				FileController.saveFile(baseController, fileName.trim(), chatDisplay.getText());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String fileName = chatField.getText() + ".txt";
				String saved = FileController.readFile(baseController, fileName);
				chatDisplay.setText(saved);
			}
		});
		
		searchTwitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		sendTwitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			baseController.useTwitter(chatField.getText());
			}
		});
		
		
		
	}
	
}
