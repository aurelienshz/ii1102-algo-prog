import java.util.Scanner;
import java.util.Arrays;

public class Tp3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre d'éléments du tableau ? ");
        int n = sc.nextInt();

        System.out.println("Saisie d'un tableau à "+n+" éléments :");
        int[] table = input(n);
        for(int i = 0; i<table.length; i++) {
            System.out.println(i+": "+table[i]);
        }

        int[] mean = intMean(table);
        System.out.println("Moyenne entière du tableau : "+mean[0]);
        System.out.println("Index de la moyenne : "+((mean[1]==-1)?"Moyenne absente":mean[1]));


        System.out.println("Partition du tableau autour de la moyenne :");
        System.out.println(Arrays.toString(partition(table, mean[0])));

        System.out.println("Saisie d'un tableau 3x4 éléments :");
        int[][] table3x4 = input3x4();
        for(int i = 0; i<table3x4.length; i++) {
            for(int j = 0; j<table3x4[i].length; j++) {
                System.out.print(table3x4[i][j]+"\t");
            }
            System.out.println();
        }


    }

    public static int[] input(int n) {
        Scanner sc = new Scanner(System.in);
        int[] table = new int[n];

        for(int i = 0; i<n; i++) {
            System.out.print(i+" : ");
            table[i] = sc.nextInt();
        }

        return table;

    }

    public static int[][] input3x4() {
        Scanner sc = new Scanner(System.in);
        int[][] table = new int[3][4];

        for(int i = 0; i<3; i++) {
            for(int j = 0; j<4; j++) {
                System.out.print(i+", "+j+" : ");
                table[i][j] = sc.nextInt();
            }
        }

        return table;
    }

    /**
     *  Renvoie la moyenne ENTIÈRE du tableau :
     */
    public static int[] intMean(int[] table) {
        /**
         *  Tableau de résultat :
         *      res[0] : moyenne
         *      res[1] : index de la moyenne (-1 si absente du tableau)
         */

        int[] res = {0, -1};

        for(int i=0; i<table.length;i++) {
            res[0] += table[i];
        }
        res[0] /= table.length;

        for(int i=0; i<table.length;i++) {
            if(table[i] == res[0]) {
                res[1] = i;
                break;
            }
        }

        return res;
    }

    public static int[] partition(int[] table, int pivot) {
        int lowIndex = 0;
        int highIndex = table.length - 1;
        int[] res = new int[table.length];

        for(int elt: table) {
            if(elt < pivot) {
                res[lowIndex] = elt;
                lowIndex ++;
            }
            else if(elt > pivot) {
                res[highIndex] = elt;
                highIndex --;
            }
        }
        for(int i = lowIndex; i<highIndex; i++) {
            res[i] = pivot;
        }

        return res;
    }

}
