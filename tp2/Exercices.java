import java.util.Scanner;

public class Exercices {


    public static void main(String [] args)
    {
        puissance();
    }

    public static void regleGraduee()
    {
        Scanner scan = new Scanner(System.in);

        int length = 0;
        int grad = 0;
        int tailLength = 0;

        String segment = "|";
        String tail = "|";

        /**
         *  Saisie de lalonguer totale de la règle
         */
        do {
            System.out.print("Longueur de la règle : ");
            length = scan.nextInt();
            if(length <= 0)
            {
                System.out.println("Entrez un nombre valide !");
            }
        } while(length <= 0);

        /**
         *  Saisie de l'intervalle entre graduations
         */
        do {
            System.out.print("Intervalle : ");
            grad = scan.nextInt();
            if(grad <= 0)
            {
                System.out.println("Entrez un nombre valide !");
            }
        } while(grad <= 0);

        /**
         * Préparation du segment de base de la règle :
         */
        for(int i=1; i<grad; i++)
        {
            segment += "-";
        }

        /**
         * Préparation de la fin de la règle :
         */
        tailLength = length % grad;
        for(int i = 1; i<tailLength; i++)
        {
            tail += "-";
        }


        /**
         * Affichage final de la règle
         */
        while(length > 0)
        {
            if(length >= grad)
            {
                System.out.print(segment);
                length -= grad;
            }
            else
            {
                System.out.println(tail);
                break;
            }
        }

        System.out.println();
        System.out.println();
    }

    public static void puissance() {
        /*
         *  CA NE MARCHE PAS !!!
         */
        Scanner scan = new Scanner(System.in);

        double a;
        long n;
        long mod = 0;

        System.out.println("On va calculer a^n (n entier)");

        System.out.print("a : ");
        a = scan.nextDouble();

        System.out.print("n : ");
        n = scan.nextLong();

        double result = a;

        /**
         * Tant que n est pair, on réalise le calcul a^2 * a^{n/2}, et ainsi de suite si n/2 est pair.
         */

        while(n%2 == 0) {
            mod += 1;
            n = n/2;
        }

        for(double i=0;i<mod;i++) {
            result = result * result;
        }


        if(n!=1) {
            double pow = result;
            for(double i=1; i<n; i++) {
                result = result * pow;
            }
        }

        System.out.println(result);
    }



}
