package laboratory3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MethodHord hrd = new MethodHord();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x0 = ");
        double x0 = sc.nextDouble();
        System.out.print("Введите e = 10^");
        int pow = sc.nextInt();
        System.out.println();
        hrd.metod(pow, x0);
        hrd.print(pow);
    }
}
