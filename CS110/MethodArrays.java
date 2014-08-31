
public class MethodArrays {
	
	public static void printArray(int [] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void printArray(double [] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%10.2f", array[i]);
		}
		System.out.println();
	}
	
public static boolean isDivisible(int number,int divisor) {
		
		if (divisor == 0) {
			return false;
		} else if (number % divisor == 0) {
			return true;
		}
		return true;
		}
	
	public static boolean isEven(int number) {
		
		if (isDivisible(number, 2) && (number % 2 == 0)) {
			return true;		
		} else {
		return false;	
		}
	}


	public static int countEven(int [] array) {
		int nrEven = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (isEven(array [i])) {
				nrEven++;
			}
					
		}
		return nrEven;
	}
	
	public static double sumArray(double [] array) {
		double sum = 0;
		
		for (int i = 0; i < array.length; i++) {
				sum += array[i];
		
		}
		return sum;
	}
	
	public static double meanOfArray(double [] array) {
		return sumArray(array) / array.length;
	}
	
	public static double [] normalizeArray(double [] array) {
		double [] numbers = new double [array.length];
		
		for (int i = 0; i < array.length; i++) {
			numbers [i] = array[i] - meanOfArray(array);
			
		}
		return numbers;
	}
	
	public static double [] cumulativeSum(double [] array) {
		double [] numbers = new double [array.length];
		double sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			
			sum += array[i];
			
			numbers[i] = sum;
			
		}
		
		return numbers;
	}

}
