import java.util.Scanner;

public class Exercices {


    public static void main(String [] args)
    {

        // on doit faire en sorte que la fonction principale appelle des sous-fonctions pour chaque exercice :
        // On développera ici un menu mais pour l'instant osef :
        regleGraduee();
    }

    public static void regleGraduee()
    {
        Scanner scan = new Scanner(System.in);

        int length = 0;

        int grad = 0;
        String segment = "|";

        int tailLength = 0;
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
        for(int i=1; i<grad; i++) {
            segment += "-";
        }

        /**
         * Préparation de la fin de la règle :
         */
        tailLength = length % grad;
        for(int i = 1; i<tailLength; i++) {
            tail += "-";
        }


        /**
         * Affichage finale de la règle
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



}
