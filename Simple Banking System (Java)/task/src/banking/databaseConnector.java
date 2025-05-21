package banking;

import org.sqlite.SQLiteDataSource;

import java.net.CacheRequest;
import java.sql.*;

public class databaseConnector {

    private String url;

    private SQLiteDataSource dataSource = new SQLiteDataSource();


    databaseConnector(String[] args){
        if(args == null&&!(args.length>0)){
            System.out.println("Please enter the database connection url");
        }else {
            if(!args[1].isEmpty()){
                url = "jdbc:sqlite:"+args[1];
                dataSource.setUrl(url);

                createConnection();

            }

        }
    }

    private void createConnection(){
        try(Connection conn = dataSource.getConnection())
        {
            createCardTable(conn);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void createCardTable(Connection conn){
        try(Statement statement = conn.createStatement()){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS card"+
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "number TEXT NOT NULL," +
                    "pin TEXT NOT NULL," +
                    "balance INTEGER DEFAULT 0)");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void insertCard(String cardNumber, String pin, int balance){

        try(Connection connect = dataSource.getConnection()){
            try(Statement statement = connect.createStatement()){
                statement.executeUpdate(
                        "INSERT INTO card (number,pin,balance)"+
                                "values('"+cardNumber+"','"+pin+"',"+balance+");");

        }
        } catch (SQLException e) {
           System.out.println( e.getMessage());
        }
    }


    public Card searchCard(String cardNumber, String pin){
        Card card = null;
        try(Connection connect = dataSource.getConnection()){
        try(Statement statement = connect.createStatement()) {

            try (ResultSet result = statement.executeQuery(
                    "SELECT * FROM CARD WHERE number = '" + cardNumber + "' AND pin = '" + pin + "';"
            )) {
                while (result.next()) {
                    card = new Card();
                    int id = result.getInt("id");
                    card.setCardNumber(result.getString("number"));
                    card.setPinNumber(Integer.parseInt(result.getString("pin")));
                    card.setBalance(result.getInt("balance"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return card;
    }

    public Card searchCardExist(String cardNumber){
        Card card = null;

        String searchCard = "SELECT * FROM CARD WHERE number = ?";
        try(Connection connect = dataSource.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(searchCard)) {

                statement.setString(1, cardNumber);
                try (ResultSet result = statement.executeQuery()) {
                    while (result.next()) {
                        card = new Card();
                        int id = result.getInt("id");
                        card.setCardNumber(result.getString("number"));
                        card.setPinNumber(Integer.parseInt(result.getString("pin")));
                        card.setBalance(result.getInt("balance"));

                    }

                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return card;
    }
    public Boolean updateCardBalance( int balance, String cardNumber){
        int resultCount = -1;
        String updateCardBalanceQuery = "UPDATE card SET balance = ? WHERE number = ?";
        try(Connection connect = dataSource.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(updateCardBalanceQuery)) {
                statement.setInt(1, balance);
                statement.setString(2, cardNumber);
                resultCount= statement.executeUpdate();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return (resultCount != 0);
    }
    public Boolean removeAccount(String cardNumber){
        Boolean result = false;

        String deleteCardQuery = "DELETE FROM CARD WHERE number = ?";
        try(Connection connect = dataSource.getConnection()) {
            try (PreparedStatement statement = connect.prepareStatement(deleteCardQuery)) {
                statement.setString(1, cardNumber);
                statement.executeUpdate();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}
