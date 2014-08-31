
public class Divisible {
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
}
