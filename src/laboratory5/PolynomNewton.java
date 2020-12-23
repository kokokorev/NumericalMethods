package laboratory5;

import java.text.DecimalFormat;

public class PolynomNewton {

	private double[] one = new double[4];
	private double[] two = new double[3];
	private double[] three = new double[2];
	private double four;
	private double[] coeffs = new double[5];
	DecimalFormat decimalFormat = new DecimalFormat("#.###");

	public void Main(double[] x, double[] y, double count) {
		findCoeffs(x, y);
		printCoeffs();
		printMethod(x);
		System.out.printf("Значение в точке %s: %s", decimalFormat.format(count), method(x, count));
	}

	private void printCoeffs() {
		System.out.print("Коэффициенты полинома Ньютона: ");
		for (int i = 0; i < coeffs.length; i++) {
			System.out.print(decimalFormat.format(coeffs[i]) + " ");
		}
		System.out.println();
	}

	private void findCoeffs(double[] x, double[] y) {
		for (int i = 0; i < one.length; i++) {
			one[i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
		}
		for (int i = 0; i < two.length; i++) {
			two[i] = (one[i + 1] - one[i]) / (x[i + 2] - x[i]);
		}
		for (int i = 0; i < three.length; i++) {
			three[i] = (two[i + 1] - two[i]) / (x[i + 3] - x[i]);
		}
		four = (three[1] - three[0]) / (x[4] - x[0]);

		coeffs[0] = y[0];
		coeffs[1] = one[0];
		coeffs[2] = two[0];
		coeffs[3] = three[0];
		coeffs[4] = four;
	}

	private void printMethod(double[] x) {
		System.out.println("Полином Ньютона: ");
		System.out.print(decimalFormat.format(coeffs[0]) + "+" + decimalFormat.format(coeffs[1]) + "*(x -" + x[0] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[2]) + "*(x-" + x[0] + ")*(x-" + x[1] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[3]) + "*(x-" + x[0] + ")*(x-" + x[1] + ")*(x-" + x[2] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[4]) + "*(x-" + x[0] + ")*(x-" + x[1] + ")*(x-" + x[2] + ")*(x-" + x[3] + ")");
		System.out.println();
	}

	private String method(double[] x, double count) {
		double value = coeffs[0] + coeffs[1] * (count - x[0]) +
				coeffs[2] * (count - x[0]) * (count - x[1]) +
				coeffs[3] * (count - x[0]) * (count - x[1]) * (count - x[2]) +
				coeffs[4] * (count - x[0]) * (count - x[1]) * (count - x[2]) * (count - x[3]);
		return decimalFormat.format(value);
	}

}
