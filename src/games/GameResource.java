package games;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/games")
public class GameResource {
	@Context
	private UriInfo context;
	
	private GameDao dao = new GameDao();
	
	public GameResource() {
		
	}
	@POST // add
	@Produces({ MediaType.TEXT_HTML }) // Accept header
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,  MediaType.TEXT_HTML}) // Content-type header
	public void addGame(
			@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("platform") String platform,
			@FormParam("year") String year,
			@FormParam("price") String price) {
		
		Game game = new Game();
		game.setId(id);
		game.setTitle(title);
		game.setPlatform(platform);
		game.setYear(year);
		game.setPrice(price);
		
		//int nextGame = dao.getNextGameID(game.getId());
		//game.setId(nextGame);
		dao.addGame(game);
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Game> getAllGames(){
		return dao.getAllGames();
	}
	@DELETE
	@Path("{id}")
	public void deleteGame(@PathParam("id") String id) {
		System.out.println("Delete id: " + id);
		dao.deleteGame(id);
	}
	@PUT
	@Produces({ MediaType.TEXT_HTML, MediaType.APPLICATION_XML }) 
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.TEXT_HTML, MediaType.APPLICATION_XML }) 
	@Path("{id}")
	public void updateGame(@PathParam("id") String id,
			@FormParam("title") String title,
			@FormParam("platform") String platform,
			@FormParam("year") String year,
			@FormParam("price") String price)  {
		
		System.out.println("PUT title = " + title);
		
		Game game = new Game();
		game.setId(Integer.parseInt(id));
		game.setTitle(title);
		game.setPlatform(platform);
		game.setYear(year);
		game.setPrice(price);
			
		dao.updateGame(game);
	}
	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Game getGame(@PathParam("id") String id){
		return dao.getGame(Integer.parseInt(id));
	}
	

}
