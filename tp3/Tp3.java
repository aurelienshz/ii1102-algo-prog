import java.util.Scanner;

public class Tp3 {

    public static void main(String[] args) {
        System.out.println("Saisie d'un tableau à 4 éléments :");
        int[] table = saisie();
        for(int i = 0; i<table.length; i++) {
            System.out.println(i+": "+table[i]);
        }

        System.out.println("Saisie d'un tableau 3x4 éléments :");
        int[][] table3x4 = saisie3x4();
        for(int i = 0; i<table3x4.length; i++) {
            for(int j = 0; j<table3x4[i].length; j++) {
                System.out.print(table3x4[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static int[] saisie() {
        Scanner sc = new Scanner(System.in);
        int[] table = new int[4];

        for(int i = 0; i<4; i++) {
            System.out.print(i+" : ");
            table[i] = sc.nextInt();
        }

        return table;

    }

    public static int[][] saisie3x4() {
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

}
