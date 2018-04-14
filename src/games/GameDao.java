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

    public static void main(String[] args) {
    	GameDao dao = new GameDao();
//        System.out.println(dao.getNextAccountNumber("123456"));
    }

    

    public GameDao() {
        try {
            System.out.println("Loading db driver...");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "Passw0rd");
    		Statement stmt = conn.createStatement();
    		
    		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS GAMES(id INTEGER, title VARCHAR(32) NOT NULL, platform VARCHAR(32) NOT NULL, year VARCHAR(32), price VARCHAR(32))");

        } catch (SQLException ex) {
            //Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }
    public int getNextGameID(int game_id) {
        int newGameID = -1;

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "SELECT max(id) as MAX_GAME_ID FROM GAMES");
            ResultSet rs = pstmt.executeQuery();
            if (!rs.next()) {
                return -1;
            }
            // ok here
            newGameID = rs.getInt("MAX_GAME_ID") + 1;

        } catch (SQLException ex) {
            //Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }

        return newGameID;
    }

    public Game getGame(int id) {
        Game ba = null;
        try {

            PreparedStatement ps
                    = con.prepareStatement(
                            "SELECT * FROM GAMES WHERE "
                            + "ID=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // move the cursor to the start
            if (!rs.next()) {
                return null;
            }

            // ok here, have at least one record
            ba = new Game();

        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
        return ba;
    }

    public ArrayList<Game> getAllGames() {
        ArrayList<Game> games
                = new ArrayList<>();

        try {

            PreparedStatement ps
                    = con.prepareStatement(
                            "SELECT * FROM GAME");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Game ba = new Game();
                games.add(ba);
            }

        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }

        return games;
    }

    public int addGame(Game game) {
        try {
            // make sure that the account is NOT already in the db
            if (getGame(game.getId()) != null) {
                // account is ALREADY in the db
                return -1;
            } else {
                // add
                PreparedStatement ps
                        = con.prepareStatement(
                                "INSERT INTO GAME "
                                + "(ID , TITLE, PLATFORM, YEAR, PRICE)"
                                + "VALUES (?,?,?,?,?)");
                ps.setInt(1, game.getId());
                ps.setString(2, game.getTitle());
                ps.setString(3, game.getPlatform());
                ps.setString(4, game.getYear());
                ps.setString(5, game.getPrice());


                ps.executeUpdate();
            }

        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
        return 1; //ok
    }

    public int updateGame(Game game) {
        try {
            // make sure that the account exists
            if (getGame(game.getId()) == null) {
                // account is NOT in the db
                return -1;
            } else {
                // update
                PreparedStatement ps
                        = con.prepareStatement(
                                "UPDATE GAME "
                                + "SET ID=?, TITLE=?, PLATFORM=? YEAR=?, PRICE=?,"
                                + "WHERE (ID=?)");
                ps.setInt(1, game.getId());
                ps.setString(2, game.getTitle());
                ps.setString(3, game.getPlatform());
                ps.setString(4, game.getYear());
                ps.setString(5, game.getPrice());

                ps.executeUpdate();

            }
        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
        return 1; //ok
    }

    public void deleteGame(String id){
        try {
            PreparedStatement ps
                    = con.prepareStatement(
                            "DELETE FROM GAME "
                            + "WHERE (ID=?)");
            ps.setInt(1, Integer.parseInt(id));

            ps.executeUpdate();

        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }

    public void deleteAllGames() {
        try {
            PreparedStatement ps
                    = con.prepareStatement(
                            "DELETE * FROM GAME");

            ps.execute();

        } catch (SQLException ex) {
//            Logger.getLogger(BankServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("SQLException");
            ex.printStackTrace();
        }
    }
}
