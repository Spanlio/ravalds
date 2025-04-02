
import java.text.DecimalFormat;
import java.util.Scanner;

public class atzimes {
    public static void main(String[] args) {
        int studentuSk, kriterijuSk;
        Scanner sc  = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.#");

    do { 
            System.out.println("cik studentiem aprekinat gala vertejumu? : ");
        while (!sc.hasNextInt()){
            System.out.println("cik studentiem aprekinat gala vertejumu? : ");
            sc.next();
        }
        studentuSk = sc.nextInt();
    }while(studentuSk<1);
    String[]studenti = new String[studentuSk];


    do{ 
            System.out.println("kriteriju skaits : ");
        while (!sc.hasNextInt()){
            System.out.println("kriteriju skaits : ");
            sc.next();
        }
        kriterijuSk = sc.nextInt();
    }while(kriterijuSk<1);
    String[]kriteriji = new String[kriterijuSk];
}
}