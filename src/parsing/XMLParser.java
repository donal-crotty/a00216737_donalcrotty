package parsing;
import java.util.List;

import games.Game;

public class XMLParser {
	public static void main(String[] args) {
		String text = 
			"<?xml version='1.0'?><hello> Hello Jersey</hello>";
		System.out.println(text);
		List<Game> message = new ParseGame().doParseGames(text);
		System.out.println(message);
	}

}

