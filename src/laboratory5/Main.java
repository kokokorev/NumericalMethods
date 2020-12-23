package laboratory5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		double[] x = new double[]{0.092, 0.772, 1.385, 2.108, 2.938};
		double[] y = new double[]{3.161, 1.357, -0.158, -0.129, -4.438};
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите x0: ");
		double count = scanner.nextDouble();

		PlynomLagrange plynomLagrange = new PlynomLagrange();
		plynomLagrange.Main(x, y, count);
		System.out.println();

		PolynomNewton polynomNewton = new PolynomNewton();
		polynomNewton.Main(x, y, count);
		System.out.println();

		SquareSpline squareSpline = new SquareSpline();
		squareSpline.Main(x, y, count);
	}
}
