package games;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GameDao {

    private Connection con = null;

     public GameDao() {
        try {
        	System.out.println("Loading db driver...");
			try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver").newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
    		Statement stmt = con.createStatement();
    		
    		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS GAMES(id INTEGER, title VARCHAR(32) NOT NULL, platform VARCHAR(32) NOT NULL, year VARCHAR(32), price VARCHAR(32))");

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }
     
    public void createDatabase() {
    	try {
    		Statement stmt = con.createStatement();
    		stmt.executeUpdate("DROP TABLE IF EXISTS MOVIE;");
    		stmt.executeUpdate( "CREATE Table MOVIE(" + 
					"			id INTEGER," + 
					"			title VARCHAR(30) NOT NULL," +  
					"			year VARCHAR(4) NOT NULL," +
					"			price VARCHAR(4) NOT NULL,);"
					);
    		stmt.executeUpdate( "INSERT INTO MOVIE ( id, title, year, price) VALUES (1 , '2 Fast 2 Furious', '2003', '10'));");
    		stmt.executeUpdate( "INSERT INTO MOVIE ( id, title, year, price) VALUES (2 , 'Fast and the Furious: Toyko Drift', '2006', '12'));");
    		stmt.executeUpdate( "INSERT INTO MOVIE ( id, title, year, price) VALUES (3 , 'Fast & Furious', '2009', '14'));");
    		stmt.executeUpdate( "INSERT INTO MOVIE ( id, title, year, price) VALUES (4 , 'Fast Five', '2011', '16'));");
			stmt.close();
    		
    	} catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public int getNextGameID(int id) {
        int newGameID = -1;

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "SELECT max(id) as MAX_GAME_ID FROM Games");
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            // ok here
            newGameID = rs.getInt("MAX_GAME_ID") + 1;

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }

        return newGameID;
    }

    public Game getGame(int id) {
        Game ga = null;
        try {

            PreparedStatement ps
                    = con.prepareStatement(
                            "SELECT * FROM Games WHERE "
                            + "id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // move the cursor to the start
            if (!rs.next()) {
                return null;
            }

            // ok here, have at least one record
            ga = new Game(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }
        return ga;
    }

    public ArrayList<Game> getAllGames() {
        ArrayList<Game> games
                = new ArrayList<>();

        try {

            PreparedStatement ps
                    = con.prepareStatement(
                            "SELECT * FROM Games");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game ga = new Game(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                games.add(ga);
            }

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }

        return games;
    }

    public void addGame(Game game) {
        try {
                PreparedStatement ps
                        = con.prepareStatement(
                                "INSERT INTO Games "
                                + "(ID , TITLE, PLATFORM, YEAR, PRICE)"
                                + "VALUES (?,?,?,?,?)");
                ps.setInt(1, game.getId());
                ps.setString(2, game.getTitle());
                ps.setString(3, game.getPlatform());
                ps.setString(4, game.getYear());
                ps.setString(5, game.getPrice());


                ps.executeUpdate();
                

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }

    public void updateGame(Game game) {
    	try {
    		Statement stmt = con.createStatement();
    		ResultSet rs = stmt.executeQuery("SELECT * FROM Games where id = "+game.getId()+"");
    		if(rs.next()) {
    			//It Exists update
    			stmt.executeUpdate("UPDATE Games SET title ='"+game.getTitle()+"', platform='"
    			+game.getPlatform()+"', year = '"+game.getYear()+"', price = '"+game.getPrice()+"' WHERE id = "+game.getId()+"");
    			stmt.close();
    			
    		}else {
    			//Create
    			stmt.executeUpdate("INSERT INTO Games(title , platform , year, price) VALUES('"+game.getTitle()+"','"
    			+game.getPlatform()+"','"+game.getYear()+"','"+game.getPrice()+"')");
    			stmt.close();
    		}
    		stmt.close();
    	}catch(SQLException e){
    		e.printStackTrace();
    	}
    }

    public void deleteGame(String id){
        try {
            PreparedStatement ps
                    = con.prepareStatement(
                            "DELETE FROM GAMES "
                            + "WHERE (ID=?)");
            ps.setInt(1, Integer.parseInt(id));

            ps.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }

    public void deleteAllGames() {
        try {
            PreparedStatement ps
                    = con.prepareStatement(
                            "DELETE * FROM GAMES");

            ps.execute();

        } catch (SQLException ex) {
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }
}
