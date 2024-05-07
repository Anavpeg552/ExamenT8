import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/Tienda";
        String user = "Tienda";
        String password = "Tienda*123";

        try {
            Connection cnx = DriverManager.getConnection(url);
            if(!cnx.isClosed()){
                System.out.println("Conexión realizada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
