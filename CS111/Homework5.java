
public class Homework5 {
	public static void main(String [] args) {
		char[][] alpha = new char[5][10];
		
		
		for (int row = 0; row < alpha.length; row++) {
			for (int col = 0; col < alpha[0].length; col++) {
				alpha[row][col] = 'B';
			}
		}
		
		 for (int row = 0; row < alpha.length; row++) {
			for (int col = 0; col < alpha[0].length; col++) {
				
				alpha[row][col] = 'Z';
				
				alpha[0][col] = 'A';
				alpha[4][col] = 'A';
				alpha[row][0] = 'A';
				alpha[row][9] = 'A';
			}
		}
		

		for (int row = 0; row < alpha.length; row++) {
			for (int col = 0; col < alpha[0].length; col++) {
				System.out.print(alpha[row][col] + " ");
			}
			System.out.println();
		} 
		
		

		
	}
	
}
