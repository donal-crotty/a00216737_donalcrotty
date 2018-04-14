package games;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.servlet.ServletContext;
import javax.servlet.http.*;

@Path("/games")
public class GameResource {
	private UriInfo context;
	
	private GameDao dao = new GameDao();
	
	public GameResource() {
		
	}
	@POST
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void addGame(@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("platform") String platform,
			@FormParam("year") String year,
			@FormParam("price") String price) throws IOException {
		
		Game game = new Game();
		game.setTitle(title);
		game.setPlatform(platform);
		game.setYear(year);
		game.setPrice(price);
		
		int nextGame = dao.getNextGameID(game.getId());
		game.setId(nextGame);
		dao.addGame(game);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Game>getAllGames(){
		return dao.getAllGames();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{id}")
	public Game getGame(@PathParam("id") String id){
		return dao.getGame(Integer.parseInt(id));
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Path("{gameId}")
	public void deleteGame(@PathParam("gameId") String id) throws IOException {
		System.out.println("Delete id: " + id);
		dao.deleteGame(id);
	}
	
	@PUT
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Path("{gameId}")
	public void updateGame(@FormParam("id") String id,
			@FormParam("title") String title,
			@FormParam("platform") String platform,
			@FormParam("year") String year,
			@FormParam("price") String price) throws IOException {
		System.out.println("PUT id = " + id);
		
		Game game = new Game();
		game.setTitle(title);
		game.setPlatform(platform);
		game.setYear(year);
		game.setPrice(price);
	
		
		dao.updateGame(game);
	}
}
