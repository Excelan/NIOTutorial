import funFile.FileOps;
import funPath.PathOps;

public class Run {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int example = 0;
		try {
			example = Integer.parseInt(args[0]);
			runExample(example);
		} catch (NumberFormatException e) {
			System.out.println("Integer argument is required");
		}
	}

	private static void runExample(int example) {
		System.out.format("EXAMPLE %s%n", example);
		switch (example) {
		case 1: PathOps.run(); break;
		case 2: FileOps.run(); break;
		default:
			break;
		}
	}
}