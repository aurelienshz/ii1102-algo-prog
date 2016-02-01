import java.util.Scanner;

public class Pave {
    public static void main(String [] args) {

        Scanner scan = new Scanner(System.in);

        double l = -1;
        double w = -1;
        double h = -1;

        System.out.print("Hauteur du pavé : ");
        h = scan.nextDouble();

        while(h<=0) {
            System.out.print("Entrez un nombre valide : ");
            h = scan.nextDouble();
        }

        System.out.print("Hauteur du pavé : ");
        h = scan.nextDouble();

        while(h<=0) {
            System.out.print("Entrez un nombre valide : ");
            h = scan.nextDouble();
        }

        System.out.print("Hauteur du pavé : ");
        h = scan.nextDouble();

        while(h<=0) {
            System.out.print("Entrez un nombre valide : ");
            h = scan.nextDouble();
        }

        
        System.out.println("Volume du pavé : " + w*h*l);
    }
}
