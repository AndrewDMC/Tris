
public class Main
{
    public static void main(String[] args) {

        Tris tris=new Tris();
        int player1=0;
        int player2=0;
        Database database = new Database();

        

        
        boolean MainChecker=true;
        tris.output();
        do{

            player1 = tris.input(1);
            MainChecker = tris.controllo();
            tris.output();
            if(!MainChecker) break;

            tris.output();
            MainChecker = tris.controllo();

        }while(MainChecker);
        
       

        if(!MainChecker){

            database.VariableInitialization();
            database.InsertToDB();
            database.WatchDB();
        
    }
             
        

}

}