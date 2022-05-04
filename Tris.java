import java.util.*;

public class Tris {
    private int valore_g;
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

    public void input(int b) {
        Scanner sc = new Scanner(System.in);
        valore_g = b;
        flag = true;
        if (valore_g == 1) {
            System.out.print("Player " + valore_g + " inserire la casella: ");
            while (flag) {

                value = sc.nextInt();
                if (value <= 0 || value > 9) {
                    System.out.print("Inserire una casella tra 1 e 9: ");
                } else {
                    System.out.println("Sus:"+a[value-1]);
                    if (a[value - 1] == 0) {

                        flag = false;
                        c++;

                    } else {
                        System.out.print("Casella occupata rinserire: ");
                    }

                }

            }
                }

        if (valore_g == 2) {

            while (flag) {
                value = database.InputAI(SeqMosse);
                if (value <= 0 || value > 9) {
                    System.out.print("Inserire una casella tra 1 e 9: ");
                    
                } else {
                    
                    if (a[value - 1] == 0) {
                        flag = false;
                        c++;

                    } else {
                        System.out.print("Casella occupata rinserire: ");
                    }

                }

                SeqMosse = SeqMosse + Integer.toString(value);
                System.out.println(SeqMosse);

                a[value - 1] += valore_g;
            }

            /*
             * System.out.print("Player " + valore_g + " inserire la casella: ");
             * while (flag) {
             * value = sc.nextInt();
             * if (value <= 0 || value > 9) {
             * System.out.print("Inserire una casella tra 1 e 9: ");
             * } else {
             * if (a[value - 1] == 0) {
             * flag = false;
             * c++;
             * 
             * } else {
             * System.out.print("Casella occupata rinserire: ");
             * }
             * 
             * }
             * 
             * }
             * seq_mosse = seq_mosse + Integer.toString(value);
             * System.out.println(seq_mosse);
             * 
             * a[value - 1] += valore_g;
             * 
             * }
             */
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

}