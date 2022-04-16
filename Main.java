import java.util.*;
import java.sql.*;


public class Main
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a = new int[9];
        Tris tris=new Tris();
        int in1=0;
        int in2=0;

        String url = "jdbc:mysql://localhost:3306/Tris";
    
        String username = "root";
    
        String password = "";
    
        Connection conn = null;
        Statement stat;
        ResultSet result;

        
    
        
    

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

        
        boolean b=true;
        tris.output();
        do{
            in1=tris.input(1);
            b=tris.controllo();
            tris.output();
            if(!b) break;
            in2=tris.input(2);
            tris.output();
            b=tris.controllo();
        }while(b);

        if(!b){

        
		
            try{
                String myQuery = " INSERT INTO esperienza (mosse, esito) VALUES ('"+ Tris.GetEsito() + "',' " + Tris.GetMosse() + "')";
                stat.executeUpdate(myQuery);
                System.out.print("Dati registrati");
         }
         catch (SQLException e) {
     
             throw new IllegalStateException("Cannot create Statement!", e);
         }
     
        try {
     
             result = stat.executeQuery("SELECT * FROM ESPERIENZA");
     
             while (result.next()) {
     
                 System.out.println("ID:" + result.getString(0) + " MOSSE:" + result.getString(1) + " ESITO:"
                         + result.getString(2));
     
             }
     
         } catch (SQLException e) {
     
             throw new IllegalStateException("Cannot execute query", e);
         }
    }
             
        

}
}