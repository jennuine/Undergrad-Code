import java.util.Scanner;

public class BinaryConverter {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		
		
		String binaryNumString = null;
		int number = 0;
		int decimalNum = 0;
		String hexString = " ";
		int remainder = 0;
		char hexChar = ' ';
		final int SIXTEEN = 16;
		
		System.out.println("Please enter a binary number.");
		binaryNumString = input.next();
		
		for (int i = 0; i < binaryNumString.length(); i++) {
			if (binaryNumString.charAt(i) == '1') {
				number = 1;
			}
			
			if (binaryNumString.charAt(i) == '0') {
				number = 0;
			}
			
			decimalNum = decimalNum * 2 + number;
				
			
		}
		System.out.println("Decimal: " + decimalNum);
		
		while (0 < decimalNum) {
			remainder = decimalNum % SIXTEEN;
			
			switch (remainder) {
			case 1: hexChar = '1'; break;
			case 2: hexChar = '2'; break;
			case 3: hexChar = '3'; break;
			case 4: hexChar = '4'; break;
			case 5: hexChar = '5'; break;
			case 6: hexChar = '6'; break;
			case 7: hexChar = '7'; break;
			case 8: hexChar = '8'; break;
			case 9: hexChar = '9'; break;
			case 10: hexChar = 'A'; break;
			case 11: hexChar = 'B'; break;
			case 12: hexChar = 'C'; break;
			case 13: hexChar = 'D'; break;
			case 14: hexChar = 'E'; break;
			case 15: hexChar = 'F'; break;
			}
			
			decimalNum = decimalNum / SIXTEEN;
			hexString = hexChar + hexString;
			
		}
		
		System.out.println("Hexadecimal: 0x" + hexString);
	}
}
		
		
		
	

