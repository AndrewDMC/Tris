import java.util.*;

public class Tris {
    
    private int[] a = new int[9];
    private boolean flag = true;
    private boolean v = true; // vittoria
    private int c = 0;// contatore caselle
    private int value = 0;

    private static String SeqMosse = "";
    private static String esito = "";

    Database database = new Database();

    public Tris() {

    }

    public void input(int playerID) {
        Scanner sc = new Scanner(System.in);
        
        flag = true;
        if (playerID == 1) {
            System.out.print("Player " + playerID + " inserire la casella: ");
            
            try{

                value = sc.nextInt();
                flag = false;

            }
            
            catch(Exception e){

                System.out.print("Il valore corrente non è valido, reinserire:");
                flag = true;
                sc.nextLine();

            }
        } 
        
        else{

            try{

                value = database.InputAI(SeqMosse);
                flag = false;

            }
            
            catch(Exception e){

                System.out.print("Il valore corrente non è valido, reinserire:");
                flag = true;
                sc.nextLine();

            }

        }

            if(value > 0 && value < 10 && a[value - 1] == 0 && flag != true){

                this.InsertoSeq(playerID);

            }
            
            else{

                if(flag == false){

                    //if(playerID == 1)
                    System.out.println("Questo spazio è occupato, ritentare");

                    if (playerID == 2) {

                    for (int i = 0; i < 9; i++) {

                        if (a[i] == 0) {

                            value = i;
                            this.InsertoSeq(playerID);
                            break;

                        }

                    }

                }

                }
                if(playerID == 1)
                this.input(playerID);

            }
        
    }

    public boolean controllo() {
        if (c < 9) {
            if (a[0] == 1 && a[1] == 1 && a[2] == 1 || a[3] == 1 && a[4] == 1 && a[5] == 1
                    || a[6] == 1 && a[7] == 1 && a[8] == 1 || a[0] == 1 && a[3] == 1 && a[6] == 1
                    || a[1] == 1 && a[4] == 1 && a[7] == 1 || a[2] == 1 && a[5] == 1 && a[8] == 1
                    || a[0] == 1 && a[4] == 1 && a[8] == 1 || a[6] == 1 && a[4] == 1 && a[2] == 1) {
                v = false;
                System.out.println("Vittoria player 1");
                esito = "L";
            } else {
                if (a[0] == 2 && a[1] == 2 && a[2] == 2 || a[3] == 2 && a[4] == 2 && a[5] == 2
                        || a[6] == 2 && a[7] == 2 && a[8] == 2 || a[0] == 2 && a[3] == 2 && a[6] == 2
                        || a[1] == 2 && a[4] == 2 && a[7] == 2 || a[2] == 2 && a[5] == 2 && a[8] == 2
                        || a[0] == 2 && a[4] == 2 && a[8] == 2 || a[6] == 2 && a[4] == 2 && a[2] == 2) {
                    v = false;
                    System.out.println("Vittoria player 2");
                    esito = "W";
                }
            }
        } else {
            v = false;
            System.out.print("Pareggio");
            esito = "D";
        }
        return v;
    }

    public void output() {
        for (int i = 0; i < 9; i++) {
            if (a[i] == 1)
                System.out.print("X");
            else {
                if (a[i] == 2)
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            if (i == 2 || i == 5 || i == 8)
                System.out.print(" ");
            else
                System.out.print("|");
            if (i == 2 || i == 5)
                System.out.println("\n- - -");

        }
        System.out.println("\n");
    }

    public String GetMosse() {
        return SeqMosse;
    }

    public String GetEsito() {
        return esito;
    }

    public void InsertoSeq(int playerID) {

        a[value - 1] = playerID;
        SeqMosse = SeqMosse + Integer.toString(value);
        System.out.println(SeqMosse);
        this.output();
        c++;

    }

}