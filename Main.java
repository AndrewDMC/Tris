import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] a = new int[9];
        Tris tris=new Tris();
        int in1=0;
        int in2=0;
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
    }
}