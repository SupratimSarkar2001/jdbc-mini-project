import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory {
    private static Connection connection=null;
    private ConnectionFactory(){
    }
    public static Connection getConnection(){
        if(connection == null){

            ResourceBundle bundle= ResourceBundle.getBundle("configData");
            String url= bundle.getString("url");
            String username=bundle.getString("username");
            String password=bundle.getString("password");

            try {
                connection = DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}

// class output{
//    public static void main(String[] args) {
//        ConnectionFactory c1=ConnectionFactory.getConnection();
//        ConnectionFactory c2=ConnectionFactory.getConnection();
//        ConnectionFactory c3=ConnectionFactory.getConnection();
//    }
//}
