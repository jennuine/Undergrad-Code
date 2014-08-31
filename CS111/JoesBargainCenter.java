import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

public class JoesBargainCenter {
	
	static Product[] products;
	static int totalGivenElements;
	
	public static int minPos(Product [] name, int start) {
		Product min = name[start];
		int pos = start;
		
		
		for (int i = start; i < name.length; i++) {
			if (name[i] != null) {
				if (min.compareTo(name[i]) > 0) {
					min = name[i];
					pos = i;
				}
			}
		}
		return pos;
	}
	
	public static void sort(Product [] name) {
		Product temp = null;
		int pos = 0;
		
		for (int i = 0; i < name.length; i++) {
			if (name[i] != null) {
				temp = name[i];
				pos = minPos(name, i);
				name[i] = name[pos];
				name[pos] = temp;
			}
		}
	}
	
	public static void displayID(int iD) {
		boolean found = false;
		String heading = "ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n";
		
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getIdentity() == iD) {
					found = true;
					heading += products[i].toString() + "\n";
				}
			} 	
		}
		if (found) {
			JOptionPane.showMessageDialog(null, heading, "Product ID", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such ID number.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	
	public static void displayName(String name) {
		boolean found = false;
		String heading = "ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n";
		
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getName().toLowerCase().contains(name.toLowerCase())) {
					found = true;
					heading += products[i].toString() + "\n";
				}
			} 	
		}
		if (found) {
			JOptionPane.showMessageDialog(null, heading, "Product Name", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such product.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public static void displayMaxPrice(double price) {
		
		boolean found = false;
		String heading = "ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n";
		
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getPrice() <= price) {
					found = true;
					heading += products[i].toString() + "\n";
				}
			} 	
		}
		if (found) {
			JOptionPane.showMessageDialog(null, heading, "MAX Price", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such price.", "ERROR", JOptionPane.ERROR_MESSAGE);
		
		}	
	}
	
	public static void displayMinPrice(double price) {
		boolean found = false;
		String heading = "ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n";
		
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getPrice() >= price) {
					found = true;
					heading += products[i].toString() + "\n";
				}
			} 	
		}
		if (found) {
			JOptionPane.showMessageDialog(null, heading, "MIN Price", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such price.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public static void displayBetweenPrices(double minPrice, double maxPrice) {
		boolean found = false;
		String heading = "ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n";
		
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getPrice() >= minPrice && products[i].getPrice() <= maxPrice) {
					found = true;
					heading += products[i].toString() + "\n";
				}
			} 	
		}
		if (found) {
			JOptionPane.showMessageDialog(null, heading, "Between MIN and MAX Price", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such price.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public static void addNewProduct() {
		if (products[products.length - 1] != null) {
			JOptionPane.showMessageDialog(null, "Sorry, your inventory is full. No more products can be added at this time.", "ERROR", JOptionPane.ERROR_MESSAGE);
		} else {
			String iD = JOptionPane.showInputDialog(null, "Please enter the new ID.", "Identity Number", JOptionPane.PLAIN_MESSAGE);
			String name = JOptionPane.showInputDialog(null, "Please enter the new product name.", "Name", JOptionPane.PLAIN_MESSAGE);
			String size = JOptionPane.showInputDialog(null, "Please enter the new size.", "Size", JOptionPane.PLAIN_MESSAGE);
			String price = JOptionPane.showInputDialog(null, "Please enter the new price.", "Price", JOptionPane.PLAIN_MESSAGE);
			String yTDSales = JOptionPane.showInputDialog(null, "Please enter the new YTD-Sales.", "YTD-Sales", JOptionPane.PLAIN_MESSAGE);
			String description = JOptionPane.showInputDialog(null, "Please enter the new description.", "Description", JOptionPane.PLAIN_MESSAGE);
			
			products[totalGivenElements] = new Product(Integer.parseInt(iD), name, size, Double.parseDouble(price), Integer.parseInt(yTDSales), description);
			}
	}
	
	public static void setNewPrice(int iD, double newPrice) {
		int counter = 0;
		
		for (int i = 0; i < products.length; i++) {
			
			if (products[i] != null && products[i].getIdentity() == iD) {
				products[i].setPrice(newPrice);
				JOptionPane.showMessageDialog(null, iD + " " + products[i].getName() + " " + newPrice);
				break;
			} else {
				counter++;
			}
			
		}
		if (counter == products.length) {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such ID number.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void setSold(int iD, int newSold) {
		int counter = 0;
		
		for (int i = 0; i < products.length; i++) {
			
			if (products[i] != null && products[i].getIdentity() == iD) {
				products[i].setYTDSales(newSold);
				JOptionPane.showMessageDialog(null, iD + " " + products[i].getName() + " " + newSold);
				break;
			} else {
				counter++;
			}
			
		}
		if (counter == products.length) {
			JOptionPane.showMessageDialog(null, "Sorry, there is no such ID number.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void displayAll() {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				System.out.println(products[i]);
			}
		}
	}
	
	public static void main(String [] args) {
		
		Scanner inputFile = null;
		Boolean goodFile = false;
		
		String fileName = JOptionPane.showInputDialog("Please enter the filename");
		
		File file = new File(fileName);
		
		while(!goodFile) {
			try {
				inputFile = new Scanner(file);
				goodFile = true;
				
			} catch (FileNotFoundException e) {
				fileName = JOptionPane.showInputDialog("The filename you have entered is incorrect.", "Please enter the correct filename");
				file = new File(fileName);
				
				e.printStackTrace();
			}
		}
		
		totalGivenElements = inputFile.nextInt();
		inputFile.nextLine();
		products = new Product[totalGivenElements + 10];
		int counter = 0;
		
		while (inputFile.hasNextLine()) {
			int iD = inputFile.nextInt();
			String name = inputFile.next();
			String size = inputFile.next();
			double price = inputFile.nextDouble();
			int yTDSales = inputFile.nextInt();
			String description = inputFile.nextLine();
			
			products[counter] = new Product(iD, name, size, price, yTDSales, description);
			counter++;
			
			sort(products);
		}
	
		boolean repeat = true;
		
		while (repeat) {
		String option = JOptionPane.showInputDialog(null, "Please enter one of the following letters:\n"
				+ "A.) Display product by ID.\n"
				+ "B.) Display product by name.\n"
				+ "C.) Display all products with a maximum price of:\n"
				+ "D.) Display all products with a minimum price of:\n"
				+ "E.) Display all products costing between:\n"
				+ "F.) Add new product.\n"
				+ "G.) Set product price.\n"
				+ "H.) Set product sales.\n"
				+ "I.) Display all products.\n"
				+ "J.) Quit.", "Options", JOptionPane.PLAIN_MESSAGE);
		
		if (option.equalsIgnoreCase("A")) {
			String iD = JOptionPane.showInputDialog(null, "Please enter product ID number.", " ", JOptionPane.PLAIN_MESSAGE);
			displayID(Integer.parseInt(iD));
			
		} else if (option.equalsIgnoreCase("B")) {
			String name = JOptionPane.showInputDialog(null, "Please enter product name.", " ", JOptionPane.PLAIN_MESSAGE);
			displayName(name);
			
		} else if (option.equalsIgnoreCase("C")) {
			String max = JOptionPane.showInputDialog(null, "Please enter the maximum price.", " ", JOptionPane.PLAIN_MESSAGE);
			displayMaxPrice(Double.parseDouble(max));
			
		} else if (option.equalsIgnoreCase("D")) {
			String min = JOptionPane.showInputDialog(null, "Please enter the minimum price.", " ", JOptionPane.PLAIN_MESSAGE);
			displayMinPrice(Double.parseDouble(min));
		
		} else if (option.equalsIgnoreCase("E")) {
			String min = JOptionPane.showInputDialog(null, "Please enter the minimum price.", " ", JOptionPane.PLAIN_MESSAGE);
			String max = JOptionPane.showInputDialog(null, "Please enter the maximium price.", " ", JOptionPane.PLAIN_MESSAGE);
			displayBetweenPrices(Double.parseDouble(min), Double.parseDouble(max));
			
		} else if (option.equalsIgnoreCase("F")) {
			addNewProduct();
			sort(products);
			
		} else if (option.equalsIgnoreCase("G")) {
			String iD = JOptionPane.showInputDialog(null, "Please enter the ID number.", " ", JOptionPane.PLAIN_MESSAGE);
			String newAmt = JOptionPane.showInputDialog(null, "Please enter the new price.", " ", JOptionPane.PLAIN_MESSAGE);
			setNewPrice(Integer.parseInt(iD), Double.parseDouble(newAmt));
		
		} else if (option.equalsIgnoreCase("H")) {
			String iD = JOptionPane.showInputDialog(null, "Please enter the ID number.", " ", JOptionPane.PLAIN_MESSAGE);
			String newSales = JOptionPane.showInputDialog(null, "Please enter the new YTD-Sales amount.", " ", JOptionPane.PLAIN_MESSAGE);
			setSold(Integer.parseInt(iD), Integer.parseInt(newSales));
			
		} else if (option.equalsIgnoreCase("I")) {
			System.out.print("ID\t" + "NAME\t\t\t" + "SIZE\t\t" + "PRICE\t\t" + "YRT-SALES\t" + "DESCRIPTION\n\n");
			displayAll();
			
		} else if (option.equalsIgnoreCase("J")) {
			JOptionPane.showMessageDialog(null, "Goodbye.", "Thank You", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
	
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, that is an invalid option. Please try again.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	
	}
}
}
