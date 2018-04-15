package games;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "game")
@XmlType(propOrder = { "id", "title", "platform", "year", "price"})
public class Game {
	int id;
	String title, platform, year, price;
	
	public Game() {
		
	}
	public Game(int id, String title, String platform, String year, String price) {
		super();
		this.id = id;
		this.title = title;
		this.platform = platform;
		this.year = year;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", platform=" + platform + ", year=" + year + ", price=" + price
				+ "]";
	}
	
	
}
