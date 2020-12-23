package laboratory2;

import java.text.NumberFormat;

public class RelaxationMethod {

	public static double[][] a;
	public static double[][] r;
	public static double accuracy;
	public static NumberFormat formatter;

	public RelaxationMethod(double[][] a_input, double[][] r_input, double accuracy_input, NumberFormat formatter_input) {
		a = a_input;
		r = r_input;
		accuracy = accuracy_input;
		formatter = formatter_input;

		for (int i = 0; i < 4; i++) {
			String str = "";
			for (int j = 0; j < 5; j++) {
				str += a[i][j] + " ";
			}
			System.out.println(str);
		}
		System.out.println();
		firstStep();
		secondStep();
		for (int i = 0; i < 4; i++) {
			String str = "";
			for (int j = 0; j < 4; j++) {
				str += formatter.format(r[i][j]) + " ";
			}
			System.out.println(str);
		}
		System.out.println();
		thirdStep(formatter);
	}

	public static void firstStep() {
		for (int i = 0; i < 4; i++) {
			double tmp = a[i][i];
			for (int j = 0; j < 5; j++) {
				a[i][j] = a[i][j] / tmp;
			}

		}
	}

	public static void secondStep() {
		for (int i = 0; i < 4; i++) {
			r[i][0] = a[i][4];
		}
		for (int i = 0; i < 4; i++) {
			int k = 1;
			for (int j = 0; j < 4; j++) {
				if (a[i][j] != 1) {
					r[i][k] = a[i][j] * (-1);
					k++;
				}
			}
		}
	}

	public static void thirdStep(NumberFormat numberFormat) {
		int max_k = 20;
		double[][] x = new double[max_k][4];
		double[][] R = new double[max_k][4];


		for (int i = 0; i < 4; i++) {
			x[0][i] = 0;
		}
		boolean cheak = true;
		int k = 0;
		while (k < max_k - 1 && cheak) {
			for (int i = 0; i < 4; i++) {
				if (i == 0)
					R[k][i] = r[i][0] - x[k][0] + r[i][1] * x[k][1] + r[i][2] * x[k][2] + r[i][3] * x[k][3];
				if (i == 1)
					R[k][i] = r[i][0] - x[k][1] + r[i][1] * x[k][0] + r[i][2] * x[k][2] + r[i][3] * x[k][3];
				if (i == 2)
					R[k][i] = r[i][0] - x[k][2] + r[i][1] * x[k][0] + r[i][2] * x[k][1] + r[i][3] * x[k][3];
				if (i == 3)
					R[k][i] = r[i][0] - x[k][3] + r[i][1] * x[k][0] + r[i][2] * x[k][1] + r[i][3] * x[k][2];
			}
			int i_max = 0;
			double max = Math.abs(R[k][0]);
			for (int i = 0; i < 4; i++) {
				if (Math.abs(R[k][i]) > max) {
					max = Math.abs(R[k][i]);
					i_max = i;
				}
			}
			int tmp = 0;
			for (int i = 0; i < 4; i++) {
				x[k + 1][i] = x[k][i];
				if (Math.abs(R[k][i]) < accuracy)
					tmp++;
			}
			if (tmp == 4) {
				cheak = false;
			}
			x[k + 1][i_max] += R[k][i_max];

			System.out.println("\n");
			System.out.println(k);
			String str = "";
			for (int j = 0; j < 4; j++) {
				str += "x" + j + " = " + numberFormat.format(x[k][j]) + "	";
			}
			str += "\n";
			for (int j = 0; j < 4; j++) {
				str += "r" + j + " = " + numberFormat.format(R[k][j]) + "	";
			}
			System.out.println(str);
			k++;
		}

		System.out.println("\n");
		System.out.println(k);
		String str = "";
		for (int j = 0; j < 4; j++) {
			str += "x" + j + " = " + numberFormat.format(x[k][j]) + "	";
		}
		System.out.println(str);
	}
}
