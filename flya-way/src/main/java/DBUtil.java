
/**
 * sky
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {



    public static Connection getConnection() throws
            SQLException, ClassNotFoundException{

        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";
        // Database name to access
        String dbName = "db_flyaway";
        String dbUsername = "sushil";
        // String dbPassword = "";
        String dbPassword = "123456";


        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL + dbName , dbUsername,  dbPassword);
        return con;
    }

}
