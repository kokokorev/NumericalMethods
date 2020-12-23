package laboratory4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SteepestDescent spk = new SteepestDescent();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x1 = ");
        double x1 = sc.nextDouble();
        System.out.print("Введите x2 = ");
        double x2 = sc.nextDouble();
        System.out.print("Введите e = 10^");
        int pow = sc.nextInt();
        System.out.println();
        spk.method(x1, x2, pow);
    }
}
