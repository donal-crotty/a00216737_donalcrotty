package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


public class MainGameWindow extends JFrame implements ActionListener{
	private JButton addButton = new JButton("Add");
	private JButton readButton = new JButton("Read");
	private JButton readAllButton = new JButton("Read All");
	private JButton updateButton = new JButton("Update");
	private JButton deleteButton = new JButton("Delete");
	private JButton tablesButton = new JButton("Create Tables");
	
	private JButton addCancelButton = new JButton("Cancel");
	private JButton readCancelButton = new JButton("Cancel");
	private JButton updateCancelButton = new JButton("Cancel");
	private JButton deleteCancelButton = new JButton("Cancel");
	
	private JLabel idLabel = new JLabel("Id:");
	private JLabel titleLabel = new JLabel("Title:");
	private JLabel platformLabel = new JLabel("Platform:");
	private JLabel yearLabel = new JLabel("Year:");
	private JLabel priceLabel = new JLabel("Price:");
	
	private JLabel updateIdLabel = new JLabel("Id:");
	private JLabel updateTitleLabel = new JLabel("Title:");
	private JLabel updatePlatformLabel = new JLabel("Platform:");
	private JLabel updateYearLabel = new JLabel("Year:");
	private JLabel updatePriceLabel = new JLabel("Price:");
	
	private JLabel readIdLabel = new JLabel("Id:");
	
	private JLabel deleteIdLabel = new JLabel("Id:");
	
	private JTextField newIdField = new JTextField();
	private JTextField newTitleField = new JTextField();
	private JTextField newPlatformField = new JTextField();
	private JTextField newYearField = new JTextField();
	private JTextField newPriceField = new JTextField();
	
	private JTextField updateIdField = new JTextField();
	private JTextField updateTitleField = new JTextField();
	private JTextField updatePlatformField = new JTextField();
	private JTextField updateYearField = new JTextField();
	private JTextField updatePriceField = new JTextField();
	
	private JTextField readIdField = new JTextField();
	private JTextArea readTextbox = new JTextArea(10,10);
	
	private JTextField deleteIdField = new JTextField();
	
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
		
		JPanel tablesTab = new JPanel(new BorderLayout());
		JPanel tablesCentre = new JPanel(new GridLayout(10,2));
		JPanel tablesSouth = new JPanel();
		tablesCentre.setBackground(myColor1);
		tablesSouth.setBackground(myColor1);
		
		tabbedPane.setBackground(myColor);
		tabbedPane.setForeground(Color.white);
		
		idLabel.setForeground(Color.white);
		titleLabel.setForeground(Color.white);
		platformLabel.setForeground(Color.white);
		yearLabel.setForeground(Color.white);
		priceLabel.setForeground(Color.white);
		updateIdLabel.setForeground(Color.white);
		updateTitleLabel.setForeground(Color.white);
		updatePlatformLabel.setForeground(Color.white);
		updateYearLabel.setForeground(Color.white);
		updatePriceLabel.setForeground(Color.white);
		readIdLabel.setForeground(Color.white);
		deleteIdLabel.setForeground(Color.white);
		
		tabbedPane.addTab("Create", createTab);
		tabbedPane.addTab("Read", readTab);
		tabbedPane.addTab("Update", updateTab);
		tabbedPane.addTab("Delete", deleteTab);
		tabbedPane.addTab("Create Tables", tablesTab);
		frame.add(tabbedPane);
		
		createTab.add(createCentre, BorderLayout.CENTER);
		createTab.add(createSouth, BorderLayout.SOUTH);
		createCentre.add(idLabel);
		createCentre.add(newIdField);
		createCentre.add(titleLabel);
		createCentre.add(newTitleField);
		createCentre.add(platformLabel);
		createCentre.add(newPlatformField);
		createCentre.add(yearLabel);
		createCentre.add(newYearField);
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
		
		readTab.add(readCentre,BorderLayout.CENTER);
		readTab.add(readSouth,BorderLayout.SOUTH);
		readCentre.add(readIdLabel);
		readCentre.add(readIdField);
		readCentre.add(readTextbox);
		readSouth.add(readButton);
		readSouth.add(readAllButton);
		readButton.addActionListener(this);
		readAllButton.addActionListener(this);
		readSouth.add(readCancelButton);
		readCancelButton.addActionListener(this);
		readButton.setBackground(myColor);
		readAllButton.setBackground(myColor);
		readCancelButton.setBackground(myColor);
		readButton.setForeground(Color.white);
		readAllButton.setForeground(Color.white);
		readCancelButton.setForeground(Color.white);
	
		updateTab.add(updateCentre, BorderLayout.CENTER);
		updateTab.add(updateSouth, BorderLayout.SOUTH);
		updateCentre.add(updateIdLabel);
		updateCentre.add(updateIdField);
		updateCentre.add(updateTitleLabel);
		updateCentre.add(updateTitleField);
		updateCentre.add(updatePlatformLabel);
		updateCentre.add(updatePlatformField);
		updateCentre.add(updateYearLabel);
		updateCentre.add(updateYearField);
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
		deleteCentre.add(deleteIdLabel);
		deleteCentre.add(deleteIdField);
		deleteSouth.add(deleteButton);
		deleteButton.addActionListener(this);
		deleteSouth.add(deleteCancelButton);
		deleteCancelButton.addActionListener(this);
		deleteButton.setBackground(myColor);
		deleteCancelButton.setBackground(myColor);
		deleteButton.setForeground(Color.white);
		deleteCancelButton.setForeground(Color.white);
		
		tablesTab.add(tablesCentre,BorderLayout.CENTER);
		tablesTab.add(tablesSouth,BorderLayout.SOUTH);
		tablesSouth.add(tablesButton);
		tablesButton.addActionListener(this);
		pack();
		frame.setLocationRelativeTo(null);
		frame.setSize(640,480);
		frame.setVisible(true);	
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(addButton)){
			//POST
				System.out.println("Add Button Works");
				int id = Integer.parseInt(newIdField.getText());
				String title = newTitleField.getText();
				String platform = newPlatformField.getText();
				String year = newYearField.getText();
				String price = newPriceField.getText();
				
				URI uri = null;
				try {
					uri = new URIBuilder()
							.setScheme("http")
							.setHost("localhost")
							.setPort(8080)
							.setPath("/A00216737_DonalCrotty/games/games").build();
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println(uri.toString());
				
				HttpPost httpPost = new HttpPost(uri);
				httpPost.setHeader("Accept" , "text/html");
				CloseableHttpClient client = HttpClients.createDefault();
				
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("id" , ""+id));
				nameValuePairs.add(new BasicNameValuePair("title" , title));
				nameValuePairs.add(new BasicNameValuePair("platform" , platform));
				nameValuePairs.add(new BasicNameValuePair("year" , "" + year));
				nameValuePairs.add(new BasicNameValuePair("price" , "" + price));
				
				try {
					httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Sending Request ...");
				CloseableHttpResponse response;
				try {
					response = client.execute(httpPost);
					System.out.println("Response " + response.toString());
					JOptionPane.showMessageDialog(new JFrame(), "Game created.");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
		if(e.getSource().equals(readButton)){
			CloseableHttpResponse response = null;
			CloseableHttpClient httpClient = null;
			String id = readIdField.getText();
			try{
				URI uri = new URIBuilder()
						.setScheme("http")
						.setHost("localhost")
						.setPort(8080)
						.setPath("/A00216737_DonalCrotty/games/games"+id)
						.build();
			
				System.out.println(uri.toString());
				HttpGet httpGet = new HttpGet(uri);
				//httpGet.setHeader("Accept" , "application/json");
				httpGet.setHeader("Accept" , "application/xml");
				//httpGet.setHeader("Accept" , "text/html");
				httpGet.setHeader("Content-Type" , "application/xml");
				
				httpClient = HttpClients.createDefault();
				response = httpClient.execute(httpGet);
				
				String text;
				try{
					HttpEntity entity = response.getEntity();
					text = getASCIIContentFromEntity(entity);
					
				}finally{
					response.close();
				}
				
				System.out.println("REPLY: " + text);
				readTextbox.setText(text);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else {
			//GET ALL
			CloseableHttpResponse response = null;
			CloseableHttpClient httpClient = null;
		
			try{
				URI uri = new URIBuilder().setScheme("http").setHost("localhost")
						.setPort(8080).setPath("/A00216737_DonalCrotty/games/games").build();
			
				System.out.println(uri.toString());
				HttpGet httpGet = new HttpGet(uri);
				//httpGet.setHeader("Accept" , "application/json");
				httpGet.setHeader("Accept" , "application/xml");
				//httpGet.setHeader("Accept" , "text/html");
				httpGet.setHeader("Content-Type" , "application/xml");
				
				httpClient = HttpClients.createDefault();
				response = httpClient.execute(httpGet);
				
				String text;
				try{
					HttpEntity entity = response.getEntity();
					text = getASCIIContentFromEntity(entity);
					
				}finally{
					response.close();
				}
				
				System.out.println("REPLY: " + text);
				readTextbox.setText(text);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}

		if(e.getSource().equals(updateButton)){
				System.out.println("Update Button Works");
				int id = Integer.parseInt(updateIdField.getText());
				String title = updateTitleField.getText();
				String platform = updatePlatformField.getText();
				String year= updateYearField.getText();
				String price = updatePriceField.getText();
				
				URI uri = null;
				try {
					uri = new URIBuilder()
							.setScheme("http")
							.setHost("localhost")
							.setPort(8080)
							.setPath("/A00216737_DonalCrotty/games/games/").build();
				} catch (URISyntaxException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				System.out.println(uri.toString());
				
				HttpPut httpPut = new HttpPut(uri);
				//httpPut.setHeader("Accept" , "text/html");
				httpPut.setHeader("Content-Type", "application/x-www-form-urlencoded");
				CloseableHttpClient client = HttpClients.createDefault();
				
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("id" , ""+id));
				nameValuePairs.add(new BasicNameValuePair("title" , title));
				nameValuePairs.add(new BasicNameValuePair("platform" , platform));
				nameValuePairs.add(new BasicNameValuePair("year" , "" + year));
				nameValuePairs.add(new BasicNameValuePair("price" , "" + price));
				
				try {
					httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Sending Request ...");
				CloseableHttpResponse response;
				try {
					response = client.execute(httpPut);
					System.out.println("Response " + response.toString());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(new JFrame(), "Game updated.");
		}
		if(e.getSource().equals(deleteButton)){
			try{
			System.out.println("Delete Button Works");
			String title = deleteIdField.getText();
			JOptionPane.showMessageDialog(new JFrame(), "Game deleted.");
			}catch(NullPointerException nullP){
				JOptionPane.showMessageDialog(new JFrame(), "This product does not exist.");
			}
			catch(Exception ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Delete Unsuccessful.");
			}
		}
		if(e.getSource().equals(tablesButton)){
			try{
				JOptionPane.showMessageDialog(new JFrame(), "Tables created.");
			}
			catch(Exception ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(new JFrame(), "Table Creation Unsuccessful.");
			}
		}
		if(e.getSource().equals(addCancelButton)){
				newTitleField.setText(""); 
				newPlatformField.setText("");
				newYearField.setText(""); 
				newPriceField.setText(""); 
		}
		if(e.getSource().equals(updateCancelButton)){
			updateTitleField.setText(""); 
			updatePlatformField.setText("");
			updateYearField.setText(""); 
			updatePriceField.setText(""); 
	}
		if(e.getSource().equals(readCancelButton)){
			readIdField.setText(""); 
	}
		else if(e.getSource().equals(deleteCancelButton)){
			deleteIdField.setText(""); 
			
	}
	}
	
	static String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException{
		InputStream in = entity.getContent();
		StringBuffer out = new StringBuffer();
		int n = 1;
		while( n> 0 ){
			byte[] b = new byte[4096];
			n = in.read(b);
			if( n > 0 )
				out.append(new String (b , 0 , n));
		}
		return out.toString();
	}

}