import java.util.Scanner;

public class Tp2 {


    /**
     *  Appel du menu, qui se chargera d'appeler la méthode demandée :
     */
    public static void main(String[] args) {
        boolean cont = true;

        System.out.println("\n\n\n#####   ALGORITHMIQUE & PROGRAMMATION - TP2   #####\n");

        do {
            cont = menu();
        } while(cont == true);

        return;
    }

    /**
     * Méthode qui affiche le menu et retourne false en se terminant si on doit quitter, true sinon.
     */
    public static boolean menu()
    {
        Scanner scan = new Scanner(System.in);

        int method = 0;

        System.out.println("---   MENU   ---");

        System.out.println("1 : Règle graduée");
        System.out.println("2 : Calcul d'une puissance");
        System.out.println("3 : Test de primalité d'un nombre");
        System.out.println("4 : Tables de multiplications 10x10");
        System.out.println("5 : Table de multiplication de n entre 0 et max");
        System.out.println("6 : Recherche dans un tableau");
        System.out.println("\n0 : Quitter\n\n");

        System.out.print("Choisissez une option [1-6] : ");
        method = scan.nextInt();

        switch(method) {
            case 1:
                regleGraduee();
            break;
            case 2:
                double a;
                long n;

                System.out.println("On va calculer a^n (n entier)");
                System.out.print("a : ");
                a = scan.nextDouble();

                System.out.print("n : ");
                n = scan.nextLong();

                System.out.println(pow(a,n));
            break;
            case 3:

                System.out.print("Entrez un nombre : ");
                long trololo = scan.nextLong();

                boolean res = isPrime(trololo);
                System.out.println(res?"Ce nombre est premier":"Ce nombre n'est pas premier");
            break;
            case 4:
                multiplication();
            break;
            case 5:
                System.out.print("Nombre : ");
                int nb = scan.nextInt();
                System.out.print("Max : ");
                int max = scan.nextInt();

                int[] table = calculerTable(nb,max);

                System.out.println("Tableau retourné :\n{");
                for(int i=0; i<table.length; i++) {
                    System.out.println("\t" + i + ": " + table[i] + ",");
                }
                System.out.println("}");

            break;
            case 6:
                int[] tab1 = {1,2,3,4,5};
                int[] tab2 = {9, 8, 7, 6,5,4,3,2,1,0};

                System.out.println("On va chercher :");
                System.out.println("55 dans {1,2,3,4,5}\n\tRésultat : "+recherche(55, tab1));
                System.out.println("5 dans {1,2,3,4,5}\n\tRésultat : "+recherche(5,tab1));
                System.out.println("9 dans {9, 8, 7, 6,5,4,3,2,1,0}\n\tRésultat : "+recherche(9,tab2));
                System.out.println("5 dans {9, 8, 7, 6,5,4,3,2,1,0}\n\tRésultat : "+recherche(5,tab2));

            break;
            default:
            case 0:
                return false;
        }
        System.out.println("\n--- Fin d'exécution de la méthode ---\n[Entrée] : Retour au menu...");

        scan.nextLine();
        scan.nextLine();
        return true;
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

    /**
     *  3.2 - Puissance :
     *  Cette méthode attend la saisie de deux nombres a et n et calcule a^n
     *  Le nombre de multiplications est réduit par le constat suivant :
     *  On cherche p et q tels que n = (2^p)*q, puis on réalise le calcul suivant :
     *  a^n = ((a^2)^2 [... n fois] )^q
     *  Pour voir cette équation sous sa forme la plus lisible, visiter l'adresse suivante :
     *  http://bit.ly/1WlKRV0
     */
    public static double pow(double a, long n)
    {

        long mod = 0;
        double result = a;

        /**
         * Tant que n est pair, on réalise le calcul a^2 * a^{n/2}, et ainsi de suite si n/2 est pair.
         * Exemple : Si n = 28, on réalisera le calcul a^n = ((a^2)^2)^7
         * (autrement dit on extrait les facteurs égaux à 2 dans la décomposition en facteurs premiers de n)
         */

        /**
         * Calcul du nombre de fois qu'on peut passer le nombre au carré
         * (exemple : si mod = 3, alors on a a^n = ((a^2)^2)^2)^n/8
         */
        while(n%2 == 0) {
            mod += 1;
            n = n/2;
        }

        /**
         * Réalisation du calcul des carrés imbriqués
         */
        for(double i=0;i<mod;i++) {
            result = result * result;
        }

        /**
         * Mise à la puissance restante (ie n/2^p)
         */
        if(n!=1) {
            double pow = result;
            for(double i=1; i<n; i++) {
                result = result * pow;
            }
        }

        return result;
    }




    /**
     *  3.3 - Nombre premier
     *  Cette méthode attend la saisie d'un nombre, calcule s'il est premier,
     *  renvoie true si c'est le cas, et false sinon.
     */
    public static boolean isPrime(long n)
    {
        /*
         *  Cas particulier où n vaut 1 :
         *  (on ne va boucler qu'à partir de 2 dans la suite')
         */
        if(n == 1) {
            return false;
        }
        /**
         * On ne boucle que jusqu'à floor(n/2) car il est impossible que n ait un diviseur entier inférieur à 2
         */
        for(long i = 2; i<=Math.floor(n/2); i++) {
            if(n%i == 0) {
                return false;    // n pas premier
            }
        }

        return true;
    }



    /**
     *  3.4 - Table de multiplication [1-10]
     *  NB : la ligne et la colonne de zéros de l'énoncé n'ont pas été reproduites.
     *  Pour ce faire, il aurait suffi d'initialiser i et j à 0 dans les boucles for.
     */
     public static void multiplication()
     {
         int res = 0;
         for(int i=1;i<=10;i++) {
             for(int j=1;j<=10;j++) {
                 res = i*j;
                 if(res<10) {
                    System.out.print(res + "  ");
                 }
                 else {
                    System.out.print(res + " ");
                 }
             }
             System.out.println();
         }
     }

     /**
      * 3.5 - Table de multiplication
      * Retourne un tableau contenant la table de multiplication de nb, entre 0 et max inclus.
      */
      public static int[] calculerTable(int nb, int max)
      {

          int[] table;

          // Pré-allocation du tableau :
          table = new int[max+1];

          for(int i=0; i<=max; i++) {
              table[i] = i * nb;
              // On peut si on le souhaite, voir s'afficher la table au fur et à mesure de sa constuction :
                // System.out.println(i+" x "+nb+" = "+i*nb);
          }
          return table;
      }


      /**
       *    3.6 - Recherche dans un tableau
       *    renvoie l'index de val si trouvé dans tab, -1 sinon
       */
      public static int recherche(int val, int[] tab)
      {
          // Parcours du tableau :
          for(int i=0;i<tab.length;i++) {
              if(val==tab[i]) {
                  return i;
              }
          }
          return -1;
      }

}
