

public class Product {
	
	private int identity;
	private String name;
	private String description;
	private String size;
	private double price;
	private int yTDSales;
	
	
	public Product(int identity2, String name2, String size2, double price2, int yTDSales2, String description2) {
		identity = identity2;
		name = name2;
		size = size2;
		price = price2;
		yTDSales = yTDSales2;
		description = description2;
		
	}
	
	public Product() {
		identity = 0;
		name = "N/A";
		description = "N/A";
		size = "N/A";
		price = 0;
		yTDSales = 0;
		
	}

	public String toString() {
	
		if (getName().length() <= 5) {
			return identity + "\t" + name + "\t\t\t" + size + "\t\t" + price + "\t\t" + yTDSales + "\t" + description + "\t\t";	
		} else if (getName().length() <= 15){
			return identity + "\t" + name + "\t\t" + size + "\t\t" + price + "\t\t" + yTDSales + "\t" + description + "\t\t";
		} else {
			return identity + "\t" + name + "\t" + size + "\t\t" + price + "\t\t" + yTDSales + "\t" + description + "\t\t";
		}	
	} 
	
	public int compareTo(Product product1) {
		return this.getName().compareTo(product1.getName());	
		
	}
	
	public int getIdentity() {
		return identity;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSize() {
		return size;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getYTDSales() {
		return yTDSales;
	}
	
	public void setDescription(String newDescription) {
		
		if (newDescription.length() <= 25) {
			description = newDescription;
		} else {
			System.out.println("You can not have more than 25 characters. Please try again.");
		}
	}
	
	public void setSize(String newSize) {
		size = newSize;
	}
	
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	
	public void setYTDSales(int newYTDSales) {
		yTDSales = newYTDSales;
	}

}
