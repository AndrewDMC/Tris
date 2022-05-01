
import java.sql.*;


public class Main
{
    public static void main(String[] args) {

        Tris tris=new Tris();
        int player1=0;
        int player2=0;

        String url = "jdbc:mysql://localhost:3306/Tris";
    
        String username = "root";
    
        String password = "";
    
        Connection conn = null;
        Statement stat;
        ResultSet result;
        
        String esito = "";
        String mosse = "";
        
        
        
    
        
    

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            System.out.println("Error in loading driver");
            //ciao
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

        
        boolean MainChecker=true;
        tris.output();
        do{

            player1 = tris.input(1);
            MainChecker = tris.controllo();
            tris.output();
            if(!MainChecker) break;
            try{
                result = stat.executeQuery( "SELECT * FROM esperienza WHERE mosse LIKE '15%' AND esito ='W' ");
            }

            catch (SQLException e) {
                                       
                throw new IllegalStateException("Cannot execute query", e);
           
           }  

            tris.output();
            MainChecker = tris.controllo();

        }while(MainChecker);
        
        esito = tris.GetEsito();
        mosse = tris.GetMosse();
        System.out.println(esito);

        if(!MainChecker){
	

        
		
            try{
                String myQuery = " INSERT INTO esperienza (mosse, esito) VALUES ('"+ mosse + "',' " + esito + "')";
                stat.executeUpdate(myQuery);
                System.out.print("Dati registrati\n");
         }
         catch (SQLException e) {
     
             throw new IllegalStateException("Cannot create Statement!", e);
         }
     
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

}