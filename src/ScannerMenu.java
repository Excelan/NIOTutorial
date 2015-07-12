import java.util.Scanner;

public class ScannerMenu {

	public static int ask() {
		char choice = 0;		

		try (Scanner reader = new Scanner(System.in);)
		{


			do {
				System.out.format("1. Path example%n");
				System.out.format("2. File example%n");
				System.out.format("3. Tree example%n");
				System.out.format("0. EXIT%n");

				choice = reader.next().charAt(0);

			} while (choice < '0' || choice > '3');



		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return Integer.parseInt(""+choice);
	}

}
