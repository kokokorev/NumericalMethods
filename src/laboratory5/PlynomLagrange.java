package laboratory5;

import java.text.DecimalFormat;

public class PlynomLagrange {

	private double[] coeffs = new double[5];
	DecimalFormat decimalFormat = new DecimalFormat("#.###");

	public void Main(double[] x, double[] y, double count) {
		findCoeffs(x, y);
		printCoeffs();
		printMethod(x);
		System.out.printf("Значение в точке %s: %s", decimalFormat.format(count), method(x, count));
	}

	private void findCoeffs(double[] x, double[] y) {
		coeffs[0] = 1 / ((x[0] - x[1]) * (x[0] - x[2]) * (x[0] - x[3]) * (x[0] - x[4])) * y[0];
		coeffs[1] = 1 / ((x[1] - x[0]) * (x[1] - x[2]) * (x[1] - x[3]) * (x[1] - x[4])) * y[1];
		coeffs[2] = 1 / ((x[2] - x[0]) * (x[2] - x[1]) * (x[2] - x[3]) * (x[2] - x[4])) * y[2];
		coeffs[3] = 1 / ((x[3] - x[0]) * (x[3] - x[1]) * (x[3] - x[2]) * (x[3] - x[4])) * y[3];
		coeffs[4] = 1 / ((x[4] - x[0]) * (x[4] - x[1]) * (x[4] - x[2]) * (x[4] - x[3])) * y[4];
	}

	private void printCoeffs() {
		System.out.print("Коэффициенты полинома Лагранжа: ");
		for (int i = 0; i < coeffs.length; i++) {
			System.out.print(decimalFormat.format(coeffs[i]) + " ");
		}
		System.out.println();
	}

	private void printMethod(double[] x) {
		System.out.println("Полином Лагранжа: ");
		System.out.print(decimalFormat.format(coeffs[0]) + "*(x -" + x[1] + ")*(x-" + x[2] + ")*(x-" + x[3] + ")*(x-" + x[4] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[1]) + "*(x-" + x[0] + ")*(x-" + x[2] + ")*(x-" + x[3] + ")*(x-" + x[4] + ") - \n"
				+ decimalFormat.format(coeffs[2]) + "*(x-" + x[0] + ")*(x-" + x[1] + ")*(x-" + x[3] + ")*(x-" + x[4] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[3]) + "*(x-" + x[0] + ")*(x-" + x[1] + ")*(x-" + x[2] + ")*(x-" + x[4] + ") + \n"
				+ "+" + decimalFormat.format(coeffs[4]) + "*(x-" + x[0] + ")*(x-" + x[1] + ")*(x-" + x[2] + ")*(x-" + x[3] + ")");
		System.out.println();
	}

	private String method(double[] x, double count) {
		double value = coeffs[0] * (count - x[1]) * (count - x[2]) * (count - x[3]) * (count - x[4]) +
				coeffs[1] * (count - x[0]) * (count - x[2]) * (count - x[3]) * (count - x[4]) +
				coeffs[2] * (count - x[0]) * (count - x[1]) * (count - x[3]) * (count - x[4]) +
				coeffs[3] * (count - x[0]) * (count - x[1]) * (count - x[2]) * (count - x[4]) +
				coeffs[4] * (count - x[0]) * (count - x[1]) * (count - x[2]) * (count - x[3]);
		return decimalFormat.format(value);
	}

}
