import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {
    private final static String url="jdbc:postgresql://localhost:5432/OBSSDemo";
    private final static String username="postgres";
    private final static String password="12345";

    public static Connection getConnection(){

        Connection connection=null;
        try {
            connection=DriverManager.getConnection(url,username,password);
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }
        return connection;
    }

}
