import funPath.PathOperationsFun;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int example = 0;
		try {
			example = Integer.parseInt(args[0]);
			runExample(example);
		} catch (Exception e) {
			System.out.println("Integer argument is required");
		}
	}

	private static void runExample(int example) {
		switch (example) {
		case 1: PathOperationsFun.run();
			break;
		default:
			break;
		}

		
	}

}
