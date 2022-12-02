public class QuadraticEquation {
	
	public static void main(String[] args) {
		calculate(1, 4, 6);
	}

	private static void calculate(double a, double b, double c) {
		double d = b * b - 4.0 * a * c;
		if (d > 0.0) {
			double r1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);
			double r2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);
			System.out.println("The roots are " + r1 + " and " + r2);
		} else if (d == 0.0) {
			double r1 = -b / (2.0 * a);
			System.out.println("The root is " + r1);
		} else {
			System.out.println("The equations does not have real roots.");
		}
	}
}

		
		