import java.util.Scanner;

public class Solve {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Polynome : a*X^2 + b*X + c");

        System.out.print("a = ");
        double a = scan.nextDouble();

        System.out.print("b = ");
        double b = scan.nextDouble();

        System.out.print("c = ");
        double c = scan.nextDouble();

        if(a != 0) {
            double delta = b*b - 4*a*c;

            if(delta > 0) {
                System.out.println("Deux solutions distinctes");
                System.out.println((-b-Math.sqrt(delta))/2*a);
                System.out.println((-b+Math.sqrt(delta))/2*a);

            }
            else if(delta == 0) {
                System.out.println("Une solution double");
                System.out.println(-b/2*a);
            }
            else {
                System.out.println("Pas de solutions réelles");
            }
        }
        else {
            // a = 0 <=> x = -c/b
            System.out.println("L'équation est du 1er degré. Solution :");
            System.out.println(-c/b);
        }
    }
}
