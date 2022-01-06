import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Records {
   static final String DB_URL = "jdbc:sqlite:movies.db";
   static final String USER = "guest";
   static final String PASS = "guest123";
   static final String QUERY = "SELECT srno ,name ,actor,actress,director FROM movies";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);
      ) {		      
         while(rs.next()){
            //Display values
        	 System.out.print(", srno: " + rs.getInt("srno"));
             System.out.print(", name: " + rs.getString("name"));
             System.out.print(", actor: " + rs.getString("actor"));
             System.out.println(", actress: " + rs.getString("actress"));
             System.out.println(", director: " + rs.getString("director"));
          
          }
       } catch (SQLException e) {
          e.printStackTrace();
       } 
    }
 }