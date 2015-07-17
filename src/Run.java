
import funFile.FileOps;
import funPath.PathOps;
import funTree.TreeOps;

public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int example;
		try {
			example = Integer.parseInt(args[0]);
			runExample(example);
		} catch (Exception e) {
			System.out.println("Integer argument is required");
			runExample((ScannerMenu.ask()));


		}
	}

	private static void runExample(int example) {
		System.out.format("EXAMPLE %s%n", example);
		switch (example) {
		case 0: System.exit(0); break;
		case 1: PathOps.run(); break;
		case 2: FileOps.run(); break;
		case 3: new TreeOps(); break;
		default:
			break;
		}
		System.out.println("******************"+Thread.currentThread().getName());
	}
}