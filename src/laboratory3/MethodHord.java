package laboratory3;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class MethodHord {
	DecimalFormat format = new DecimalFormat("#0.00000000");
	int count = 1;
	private double[] x = new double[100];
	private double[] f = new double[100];

	public MethodHord() {
	}

	public void metod(int pow, double x0) {
		x[0] = x0;
		x[1] = x0 + 1.0D;
		f[0] = 1.0D - 0.5D * (x[0] * x[0]) * log(x[0]) + 0.3D * sqrt(x[0]);
		f[1] = 1.0D - 0.5D * (x[1] * x[1]) * log(x[1]) + 0.3D * sqrt(x[1]);

		for (int i = 1; abs(x[i] - x[i - 1]) > pow(10.0D, pow) * pow(10.0D, (pow / 2.0D)); ++i) {
			f[i] = 1.0D - 0.5D * (x[i] * x[i]) * log(x[i]) + 0.3D * sqrt(x[i]);
			x[i + 1] = x[i - 1] - f[i - 1] / (f[i] - f[i - 1]) * (x[i] - x[i - 1]);
			++count;
		}

	}

	public void print(int pow) {
		System.out.println("n\t\t\t\t\t\tx\t\t\t\tf\t\t\t\t\t/xn-xn-1/");

		for (int i = 0; i < this.count; ++i) {
			double New;
			if (i == 0) {
				New = (double) round(this.x[i] * pow(10.0D, (-pow))) / pow(10.0D, (-pow));
				System.out.println(i + 1 + "\t\t\t\t" + New + "\t\t\t\t\t" + this.format.format(this.f[i]));
			} else {
				New = (double) round(this.x[i] * pow(10.0D, (-pow))) / pow(10.0D, (-pow));
				System.out.println(i + 1 + " <=== n" + "\t\t" + New + " <=== x" + "\t\t" + this.format.format(this.f[i]) + " <=== f" + "\t\t" + this.format.format(abs(this.x[i] - this.x[i - 1])) + " <=== xn - xn-1");
			}
		}

	}
}
