package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class MainGameWindow extends JFrame implements ActionListener{
	private JButton addButton = new JButton("Add");
	private JButton readButton = new JButton("Read");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	
	private JButton addCancelButton = new JButton("Cancel");
	private JButton readCancelButton = new JButton("Cancel");
	private JButton updateCancelButton = new JButton("Cancel");
	private JButton deleteCancelButton = new JButton("Cancel");
	
	private JLabel titleLabel = new JLabel("Title:");
	private JLabel platformLabel = new JLabel("Platform:");
	private JLabel developerLabel = new JLabel("Developer:");
	private JLabel pegiRatingLabel = new JLabel("PegiRating:");
	private JLabel priceLabel = new JLabel("Price:");
	
	private JLabel updateTitleLabel = new JLabel("Title:");
	private JLabel updatePlatformLabel = new JLabel("Platform:");
	private JLabel updateDeveloperLabel = new JLabel("Developer:");
	private JLabel updatePegiRatingLabel = new JLabel("PegiRating:");
	private JLabel updatePriceLabel = new JLabel("Price:");
	
	private JLabel readTitleLabel = new JLabel("Title:");
	
	private JLabel deleteTitleLabel = new JLabel("Title:");
	
	private JTextField newTitleField = new JTextField("BF1");
	private JTextField newPlatformField = new JTextField("Xbox ");
	private JTextField newDeveloperField = new JTextField("EA");
	private JTextField newPegiRatingField = new JTextField("16");
	private JTextField newPriceField = new JTextField("75");
	
	private JTextField updateTitleField = new JTextField();
	private JTextField updatePlatformField = new JTextField();
	private JTextField updateDeveloperField = new JTextField();
	private JTextField updatePegiRatingField = new JTextField();
	private JTextField updatePriceField = new JTextField();
	
	private JTextField readTitleField = new JTextField();
	
	private JTextField deleteTitleField = new JTextField();
	
	Color myColor = Color.decode("#577099");
	Color myColor1 = Color.decode("#7e7e7f");

	public MainGameWindow() throws RemoteException, MalformedURLException, NotBoundException{
		super("MainGame Window");
		JFrame frame = new JFrame("CRUD Games Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel createTab = new JPanel(new BorderLayout());
		JPanel createCentre = new JPanel(new GridLayout(5, 2));
		JPanel createSouth = new JPanel();
		createCentre.setBackground(myColor1);
		createSouth.setBackground(myColor1);
		
		JPanel readTab = new JPanel(new BorderLayout());
		JPanel readCentre = new JPanel(new GridLayout(10,2));
		JPanel readSouth = new JPanel();
		readCentre.setBackground(myColor1);
		readSouth.setBackground(myColor1);
		
		JPanel updateTab = new JPanel(new BorderLayout());
		JPanel updateCentre = new JPanel(new GridLayout(5,2));
		JPanel updateSouth = new JPanel();
		updateCentre.setBackground(myColor1);
		updateSouth.setBackground(myColor1);
		
		JPanel deleteTab = new JPanel(new BorderLayout());
		JPanel deleteCentre = new JPanel(new GridLayout(10,2));
		JPanel deleteSouth = new JPanel();
		deleteCentre.setBackground(myColor1);
		deleteSouth.setBackground(myColor1);
		
		tabbedPane.setBackground(myColor);
		tabbedPane.setForeground(Color.white);
		
		titleLabel.setForeground(Color.white);
		platformLabel.setForeground(Color.white);
		developerLabel.setForeground(Color.white);
		pegiRatingLabel.setForeground(Color.white);
		priceLabel.setForeground(Color.white);
		updateTitleLabel.setForeground(Color.white);
		updatePlatformLabel.setForeground(Color.white);
		updateDeveloperLabel.setForeground(Color.white);
		updatePegiRatingLabel.setForeground(Color.white);
		updatePriceLabel.setForeground(Color.white);
		readTitleLabel.setForeground(Color.white);
		deleteTitleLabel.setForeground(Color.white);
		
		tabbedPane.addTab("Create Tab", createTab);
		tabbedPane.addTab("Read Tab", readTab);
		tabbedPane.addTab("Update Tab", updateTab);
		tabbedPane.addTab("Delete Tab", deleteTab);
		
		frame.add(tabbedPane);
		
		createTab.add(createCentre, BorderLayout.CENTER);
		createTab.add(createSouth, BorderLayout.SOUTH);
		createCentre.add(titleLabel);
		createCentre.add(newTitleField);
		createCentre.add(platformLabel);
		createCentre.add(newPlatformField);
		createCentre.add(developerLabel);
		createCentre.add(newDeveloperField);
		createCentre.add(pegiRatingLabel);
		createCentre.add(newPegiRatingField);
		createCentre.add(priceLabel);
		createCentre.add(newPriceField);
		createSouth.add(addButton);
		addButton.addActionListener(this);
		createSouth.add(addCancelButton);
		addCancelButton.addActionListener(this);
		addButton.setBackground(myColor);
		addCancelButton.setBackground(myColor);
		addButton.setForeground(Color.white);
		addCancelButton.setForeground(Color.white);
	   // theFactory  = (GameFactory)Naming.lookup(theURL+"factory");
		
		readTab.add(readCentre,BorderLayout.CENTER);
		readTab.add(readSouth,BorderLayout.SOUTH);
		readCentre.add(readTitleLabel);
		readCentre.add(readTitleField);
		readSouth.add(readButton);
		readButton.addActionListener(this);
		readSouth.add(readCancelButton);
		readCancelButton.addActionListener(this);
		readButton.setBackground(myColor);
		readCancelButton.setBackground(myColor);
		readButton.setForeground(Color.white);
		readCancelButton.setForeground(Color.white);
	
		updateTab.add(updateCentre, BorderLayout.CENTER);
		updateTab.add(updateSouth, BorderLayout.SOUTH);
		updateCentre.add(updateTitleLabel);
		updateCentre.add(updateTitleField);
		updateCentre.add(updatePlatformLabel);
		updateCentre.add(updatePlatformField);
		updateCentre.add(updateDeveloperLabel);
		updateCentre.add(updateDeveloperField);
		updateCentre.add(updatePegiRatingLabel);
		updateCentre.add(updatePegiRatingField);
		updateCentre.add(updatePriceLabel);
		updateCentre.add(updatePriceField);
		updateSouth.add(updateButton);
		updateButton.addActionListener(this);
		updateSouth.add(updateCancelButton);
		updateCancelButton.addActionListener(this);
		updateButton.setBackground(myColor);
		updateCancelButton.setBackground(myColor);
		updateButton.setForeground(Color.white);
		updateCancelButton.setForeground(Color.white);
		
		deleteTab.add(deleteCentre,BorderLayout.CENTER);
		deleteTab.add(deleteSouth,BorderLayout.SOUTH);
		deleteCentre.add(deleteTitleLabel);
		deleteCentre.add(deleteTitleField);
		deleteSouth.add(deleteButton);
		deleteButton.addActionListener(this);
		deleteSouth.add(deleteCancelButton);
		deleteCancelButton.addActionListener(this);
		deleteButton.setBackground(myColor);
		deleteCancelButton.setBackground(myColor);
		deleteButton.setForeground(Color.white);
		deleteCancelButton.setForeground(Color.white);
	
		pack();
		frame.setSize(640,480);
		frame.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(addButton)){
			try{
				System.out.println("Add Button Works");
				String priceString ="";
				String pegiRatingString="";
				String title = newTitleField.getText();
				String platform = newPlatformField.getText();
				String developer = newDeveloperField.getText();
				int pegiRating = Integer.parseInt(newPegiRatingField.getText());
				pegiRatingString= Integer.toString(pegiRating);
				int price = Integer.parseInt(newPriceField.getText());
				priceString= Integer.toString(price);
				JOptionPane.showMessageDialog(new JFrame(), "Game created.");
			}catch(NumberFormatException numEx){
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect input for PegiRating/Price, try again");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(e.getSource().equals(readButton)){
			try{
				System.out.println("Read Button Works");
				String title = readTitleField.getText();
				//JOptionPane.showMessageDialog(new JFrame(), "Game Details:\nTitle:"+aGame.getTitle()+" \nPlatform: "+aGame.getPlatform()+" \nDeveloper: "+aGame.getDeveloper()+" \nPegiRating:"+aGame.getPegiRating()+" \nPrice: €"+aGame.getPrice());
			}
			catch(NullPointerException nullP){
				JOptionPane.showMessageDialog(new JFrame(), "This product does not exist.");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(e.getSource().equals(updateButton)){
			try{
				System.out.println("Update Button Works");
				String title = updateTitleField.getText();
				String priceString="";
				String pegiRatingString="";
				String platform = updatePlatformField.getText();
				String developer = updateDeveloperField.getText();
				int pegiRating = Integer.parseInt(updatePegiRatingField.getText());
				pegiRatingString=Integer.toString(pegiRating);
				int price = Integer.parseInt(updatePriceField.getText());
				priceString= Integer.toString(price);
				JOptionPane.showMessageDialog(new JFrame(), "Game updated.");
			}
			catch(NullPointerException nullP){
				JOptionPane.showMessageDialog(new JFrame(), "This product does not exist.");
			}
			catch(NumberFormatException numEx){
				JOptionPane.showMessageDialog(new JFrame(), "Incorrect input for PegiRating/Price, try again");
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(e.getSource().equals(deleteButton)){
			try{
			System.out.println("Delete Button Works");
			String title = deleteTitleField.getText();
			JOptionPane.showMessageDialog(new JFrame(), "Game deleted.");
			}catch(NullPointerException nullP){
				JOptionPane.showMessageDialog(new JFrame(), "This product does not exist.");
			}
			catch(Exception ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Delete Unsuccessful.");
			}
		}
		if(e.getSource().equals(addCancelButton)){
				newTitleField.setText(""); 
				newPlatformField.setText("");
				newDeveloperField.setText("");
				newPegiRatingField.setText(""); 
				newPriceField.setText(""); 
		}
		if(e.getSource().equals(updateCancelButton)){
			updateTitleField.setText(""); 
			updatePlatformField.setText("");
			updateDeveloperField.setText("");
			updatePegiRatingField.setText(""); 
			updatePriceField.setText(""); 
	}
		if(e.getSource().equals(readCancelButton)){
			readTitleField.setText(""); 
	}
		else if(e.getSource().equals(deleteCancelButton)){
			deleteTitleField.setText(""); 
			
	}
	}
	
	

}