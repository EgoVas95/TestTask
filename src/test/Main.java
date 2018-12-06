package test;

public class Main {
	static byte[] array = {0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11 };
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cycle cycle = new Cycle(array);
		ReturnClass answer = cycle.findStepsAndLength();
		System.out.println("Steps = " + answer.Steps);
		System.out.println("Cycle length = " + answer.Cycle_length);
	}

}
