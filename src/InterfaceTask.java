import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceTask {

	public static void interfaceTask() {
		Scanner scan = new Scanner(System.in);
		System.out.println("To calulate the factorial, enter 0. To get the revars of the line, enter 1.");
		try {
			while (scan.hasNextInt()) {
				int value = scan.nextInt();
				if (value == 1) {
					System.out.println("Enter a string for revers: ");
					MyFunctionalInterface<String> mfi1 = d -> new StringBuilder(scan.nextLine()).reverse().toString();
					System.out.println(mfi1.method(scan.nextLine()));
					break;
				} else if (value == 0) {
					System.out.println("Enter a number to calculate the factorial");
					int i = scan.nextInt();
					MyFunctionalInterface<Long> mfi2 = d -> factorial(i);
					System.out.println(mfi2.method((long) i));
					break;
				} else {
					System.out.println("To calulate the factorial, enter 0. To get the revars of the line, enter 1");
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("incorrect enter");
		}
	}

	private static long factorial(int i) {
		if (i < 0) {
			return 0;
		}
		if (i == 0 || i == 1) {
			return 1;
		}
		return i * factorial(i - 1) * 1l;
	}

}
