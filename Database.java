
import java.sql.*;

public class Database {

    String url = "jdbc:mysql://localhost:3306/Tris";

    String username = "root";

    String password = "";

    Connection conn = null;
    Statement stat;
    ResultSet result;

    String esito = "";
    String mosse = "";

    Tris tris = new Tris();

    public Database() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error in loading driver");
        }

        try {

            conn = DriverManager.getConnection(url, username, password);

            if (conn != null)
                System.out.println("Database connected!");

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot connect the database!", e);
        }

        try {

            stat = conn.createStatement();

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot create Statement!", e);
        }

    }

    public void VariableInitialization() {

        esito = tris.GetEsito();
        mosse = tris.GetMosse();
        System.out.println(esito);

    }

    public void InsertToDB() {

        try {
            String myQuery = " INSERT INTO esperienza (mosse, esito) VALUES ('" + mosse + "',' " + esito + "')";
            stat.executeUpdate(myQuery);
            System.out.print("Dati registrati\n");
        } catch (SQLException e) {

            throw new IllegalStateException("Cannot create Statement!", e);
        }

    }

    public void WatchDB() {

        try {

            result = stat.executeQuery("SELECT * FROM ESPERIENZA");

            while (result.next()) {

                System.out.println("ID:" + result.getString(1) + " MOSSE:" + result.getString(2) + " ESITO:"
                        + result.getString(3));

            }

        } catch (SQLException e) {

            throw new IllegalStateException("Cannot execute query", e);
        }

    }

}
