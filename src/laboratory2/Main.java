package laboratory2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
	public static double[][] a = {
			{4.855, 1.239, 0.272, 0.258, 1.192},
			{1.491, 4.954, 0.124, 0.236, 0.256},
			{0.456, 0.285, 4.354, 0.254, 0.852},
			{0.412, 0.335, 0.158, 2.874, 0.862}
	};

	public static double[][] r = new double[4][4];
	public static double accuracy;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = scanner.next();
		try {
			accuracy = Double.parseDouble(line);
		} catch (Exception e) {
			System.out.println("Неправильный формат числа");
		}
		String str_f;

		int i_f = 0;
		double tmp = accuracy;
		while (tmp != 1) {
			tmp *= 10;
			i_f++;
		}
		str_f = "0.";
		while (i_f > 0) {
			str_f += "0";
			i_f--;
		}
		NumberFormat formatter = new DecimalFormat("#" + str_f);
		new RelaxationMethod(a, r, accuracy, formatter);
	}
}