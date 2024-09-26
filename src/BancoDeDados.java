import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {

    public static Connection getConnection() {
        //Connection con;
        //private String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/cinema";
        String user = "root";
        String password = "22292254";


       try{
           return DriverManager.getConnection(url, user, password);
       }
       catch (SQLException e){
           System.out.println("Erro ao conectar ao banco de dados: "+ e.getMessage());
           throw new RuntimeException(e);
       }
    }
}
