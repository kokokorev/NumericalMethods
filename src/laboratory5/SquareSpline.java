package laboratory5;

import java.text.DecimalFormat;

public class SquareSpline {
	private double[] a = new double[4];
	private double[] b = new double[4];
	DecimalFormat decimalFormat = new DecimalFormat("#.###");

	public void Main(double[] x, double[] y, double count) {
		findCoeffs(x, y);
		printCoeffs();
		System.out.println();
		printMethod(x);
		System.out.printf("Значение в точке %s: %s", decimalFormat.format(count), method(x, count));
	}

	private String method(double[] x, double count) {
		double value = 0;
		if (count >= x[0] && count <= x[1]) {
			value = a[0] * count + b[0];
		} else if (count >= x[1] && count <= x[2]) {
			value = a[1] * count + b[1];
		} else if (count >= x[2] && count <= x[3]) {
			value = a[2] * count + b[2];
		} else if (count >= x[3] && count <= x[4]) {
			value = a[3] * count + b[3];
		} else if (count < x[0]) {
			value = a[0] * count + b[0];
		} else if (count > x[x.length - 1]) {
			value = a[3] * count + b[3];
		}
		return decimalFormat.format(value);
	}

	private void printMethod(double[] x) {
		System.out.println("Линейный сплайн:");
		System.out.printf("%sx + %s; %s <= x <= %s", decimalFormat.format(a[0]), decimalFormat.format(b[0]),
				decimalFormat.format(x[0]), decimalFormat.format(x[1]));
		System.out.println();
		System.out.printf("%sx + %s; %s <= x <= %s", decimalFormat.format(a[1]), decimalFormat.format(b[1]),
				decimalFormat.format(x[1]), decimalFormat.format(x[2]));
		System.out.println();
		System.out.printf("%sx + %s; %s <= x <= %s", decimalFormat.format(a[2]), decimalFormat.format(b[2]),
				decimalFormat.format(x[2]), decimalFormat.format(x[3]));
		System.out.println();
		System.out.printf("%sx + %s; %s <= x <= %s", decimalFormat.format(a[3]), decimalFormat.format(b[3]),
				decimalFormat.format(x[3]), decimalFormat.format(x[4]));
		System.out.println();
	}

	private void printCoeffs() {
		for (int i = 0; i < a.length; i++) {
			System.out.print("a" + (i + 1) + " = " + decimalFormat.format(a[i]) + " ");
		}
		System.out.println();
		for (int i = 0; i < b.length; i++) {
			System.out.print("b" + (i + 1) + " = " + decimalFormat.format(b[i]) + " ");
		}
	}

	private void findCoeffs(double[] x, double[] y) {
		for (int i = 0; i < a.length; i++) {
			a[i] = (y[i + 1] - y[i]) / (x[i + 1] - x[i]);
		}

		for (int i = 0; i < b.length; i++) {
			b[i] = y[i] - a[i] * x[i];
		}

	}
}
