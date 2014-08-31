import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class NumbersMain {
		public static void main(String [] args) throws FileNotFoundException {
			int[] array = new int[10];
			
			reader(array);
			
			boolean repeat = true;
			
			while (repeat)
			{
				String option = JOptionPane.showInputDialog("Please enter one of the following numbers:\n"
						+ "1.  Search for a number.\n"
						+ "2.  Find the maximum of the given set of numbers.\n"
						+ "3.  Find the minimum of the given set of numbers.\n"
						+ "4.  Display the numbers falling between input1 and input2.\n"
						+ "5.  Display all the numbers.\n"
						+ "6.  Exit.");
				
				if (option.equals("1"))
				{
					String x = JOptionPane.showInputDialog("Please enter the number you are searching for.");
					JOptionPane.showMessageDialog(null,"The searched value is at position: " + search(array,Integer.parseInt(x)));
				}
				else if (option.equals("2"))
				{
					JOptionPane.showMessageDialog(null, "The maximum number is: " + maximum(array));
				}
				else if (option.equals("3"))
				{
					JOptionPane.showMessageDialog(null, "The minimum number is: " + minimum(array));
				}
				else if (option.equals("4"))
				{
					String x = JOptionPane.showInputDialog("Enter the minimum value.");
					String y = JOptionPane.showInputDialog("Enter the maximum value.");
					rangeSubset(array, Integer.parseInt(x), Integer.parseInt(y));
				}
				else if (option.equals("5"))
				{
					displayArr(array);
				}
				else if (option.equals("6"))
				{
					JOptionPane.showMessageDialog(null, "Goodbye.");
					System.exit(0);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Sorry, invalid entry.  Please try again.");
				}
			}
		}
		
		public static void reader(int[] arr) throws FileNotFoundException 
		{
			Scanner in = new Scanner(new FileReader("numbers.txt"));
			int count = 0;
			
			while (in.hasNextInt())
			{
				arr[count] = in.nextInt();
				count++;
			}
		}
		
		public static int search(int[] arr, int key)
		{
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] == key)
					return i;
			}
			return -1;
		}
		
		public static int maximum(int[] arr)
		{
			int max = arr[0];
			
			for (int i = 0; i < arr.length; i++) 
			{
				if (arr[i] > max)
					max = arr[i];
			}
			return max;
		}
		
		public static int minimum(int[] arr)
		{
			int min = arr[0];
			
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] < min)
					min = arr[i];
			}
			return min;
		}
		
		public static void displayArr(int[] arr)
		{
			for (int i = 0; i < arr.length; i++) 
			{
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
		
		public static void rangeSubset(int[] arr, int input1, int input2)
		{	
			for (int i = 0; i < arr.length; i++)
			{
				if (arr[i] >= input1 && arr[i] <= input2)
				{
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
}

		


