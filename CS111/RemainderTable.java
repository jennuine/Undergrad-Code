import java.util.Scanner;

public class RemainderTable {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		int n = 0;
		
		System.out.println("Enter a number");
		n = input.nextInt();
		
		for (int row = 1; row <= n; row++) {
			
			for (int col = 1; col <= n; col++) {	
				
				System.out.printf("%5d", row % col);
							
				}
			
			System.out.println();	
			}		
		}
	}
