package parsing;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import games.Game;

public class ParseGame {
	boolean inGames = false;
	boolean inGame = false;
	boolean inId = false;
	boolean inTitle = false;
	boolean inPlatform = false;
	boolean inYear = false;
	boolean inPrice = false;
	
	Game currentGame;
	List<Game> currentGameList;
	
	public List<Game> doParseGames(String s) {
		try{
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser, 0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return currentGameList;
	}
	public Game doParseGame(String s) {
		try{
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser , 1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return currentGame;
	}
	
	public void processDocument(XmlPullParser pullParser,  int key)
			throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start document");
			} else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End document");
			} else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser, key);
			} else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser , key);
			} else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser, key);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
		
	}
	
	public void processStartElement(XmlPullParser pullParser, int key){
		String name = pullParser.getName();
		if(name.equals("games") && key != 1){
			inGames = true;
			currentGameList = new ArrayList<Game>();
		}else if(name.equals("game")){
			inGame = true;
			currentGame = new Game();
		}else if(name.equals("id")){
			inId = true;
		}else if(name.equals("title")){
			inTitle = true;
		}else if(name.equals("platform")){
			inPlatform = true;
		}else if(name.equals("year")){
			inYear = true;
		}else if(name.equals("price")){
			inPrice = true;
		}
	}
	
	public void processEndElement(XmlPullParser pullParser, int key){
		String name = pullParser.getName();
		if(name.equals("games")){
			inGames = false;
			currentGameList = new ArrayList<Game>();
		}else if(name.equals("game") && key != 1){
			inGame = false;
			currentGame = new Game();
		}else if(name.equals("id")){
			inId = false;
		}else if(name.equals("title")){
			inTitle = false;
		}else if(name.equals("platform")){
			inPlatform = false;
		}else if(name.equals("year")){
			inYear = false;
		}else if(name.equals("price")){
			inPrice = false;
		}
	}
	
	public void processText(XmlPullParser event, int key) throws XmlPullParserException{
		if(inId){
			String s= event.getText();
			currentGame.setId(Integer.parseInt(s));
		}
		if(inTitle){
			String s= event.getText();
			currentGame.setTitle(s);
		}
		if(inPlatform){
			String s= event.getText();
			currentGame.setPlatform(s);
		}
		if(inYear){
			String s= event.getText();
			currentGame.setYear(s);
		}
		if(inPrice){
			String s= event.getText();
			currentGame.setPrice(s);
		}
	}
}
