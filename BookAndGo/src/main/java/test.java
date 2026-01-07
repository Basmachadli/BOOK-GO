import java.sql.Connection;
import java.sql.DriverManager;

public class test {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:oracle:thin:@localhost:1550/siip";
        String user = "BOOKANDGO_G7";
        String password = "root";

        Connection conn = DriverManager.getConnection(url, user, password);

        System.out.println("Connexion Oracle OK !");
        conn.close();
    }
}
