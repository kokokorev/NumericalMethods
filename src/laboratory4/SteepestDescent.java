package laboratory4;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class SteepestDescent {

    private double x[] = new double[1000];
    private double f[] = new double[1000];
    private static double a = 0.18;
    int count = 1;

    public void method(double x1, double x2, int pow) {
        x[0] = x1;
        x[1] = x2;

        f[0] = 2 * (sin(x[0] + 1.5) - x[1] + 2.9) * (cos(x[0] + 1.5)) + 2 * (cos(x[1] - 2) + x[0]) * 1;
        f[1] = 2 * (sin(x[0] + 1.5) - x[1] + 2.9) * (-1) + 2 * (cos(x[1] - 2) + x[0]) * (-sin(x[1] - 2));

        int i = 2;
        while (true) {
            x[i] = x[i - 2] - a * f[i - 2]; //x1
            x[i + 1] = x[i - 1] - a * f[i - 1];//x2

            f[i] = 2 * (sin(x[i] + 1.5) - x[i + 1] + 2.9) * (cos(x[i] + 1.5)) + 2 * (cos(x[i + 1] - 2) + x[i]) * 1;
            f[i + 1] = 2 * (sin(x[i] + 1.5) - x[i + 1] + 2.9) * (-1) + 2 * (cos(x[i + 1] - 2) + x[i]) * (-sin(x[i + 1] - 2));

            double norm = round((max(abs(x[i] - x[i - 2]), abs(x[i + 1] - x[i - 1]))) * (pow(10, -pow))) / (pow(10, -pow));
            count++;
            if ((i - 2 != 0) && (norm <= pow(10, pow) * pow(10, pow / 2.0))) {
                print(pow);
                break;
            } else {
                i = i + 2;
            }
        }

    }

    public void print(int pow) {
        DecimalFormat format = new DecimalFormat("#0.00000000");

        int j = 0;
        for (int i = 2; i < count * 2 - 2; i = i + 2) {
            double x1 = round(x[i - 2] * (pow(10, -pow))) / (pow(10, -pow));
            double x2 = round(x[i - 1] * (pow(10, -pow))) / (pow(10, -pow));

            double f1 = round(f[i - 2] * (pow(10, -pow))) / (pow(10, -pow));
            double f2 = round(f[i - 1] * (pow(10, -pow))) / (pow(10, -pow));


            if (i - 2 != 0) {
                double norm = round((max(abs(x[i - 2] - x[i - 4]), abs(x[i - 1] - x[i - 3]))) * (pow(100, -pow))) / (pow(100, -pow));
                System.out.println("\t\t x1 = " + x1 + "\t\t\t x2 = " + x2 + "\t\t\t f1 = " + format.format(f1) + "\t\t\t f2 = " + format.format(f2) + "\t\t\t norm = " + format.format(norm));
            } else {
                System.out.println("\t\t x1 = " + x1 + "\t\t\t x2 = " + x2 + "\t\t\t f1 = " + format.format(f1) + "\t\t\t f2 = " + format.format(f2));
            }
            j++;

        }
        System.out.println("n =====> " + j);

    }
}
