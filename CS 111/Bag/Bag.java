//Bag.java

import java.util.ArrayList;

public class Bag<T> {

    public class BagElement<T> {
	
	private T data;
	private int count;
	
	public BagElement(T d) {
	    data = d;
	    count = 1;
	} 
	
	public void addOne() { count++; }

	public void removeOne() { count--; }

	public boolean equals(Object o) {
	    BagElement element = (BagElement) o;
	   
	    return (o instanceof BagElement && data.equals(element.data));
	}
	
	public int getCount() { return count; }

	public T getData() { return data; }

	public String toString() { return ("<< " + count + " >> " + data); }

    }//end class bagElement

    private ArrayList<BagElement<T>> bag;

    public Bag() { bag = new ArrayList<BagElement<T>>(); }

    public boolean removeAll(T item) throws BagIsEmptyException, ItemNotFoundException {
	BagElement <T> thing = new BagElement<T>(item);

	if (bag.isEmpty()) {
	    throw new BagIsEmptyException("\n\t There is nothing in the bag to remove\n");

	} else if (bag.indexOf(thing) == -1) {
	    throw new ItemNotFoundException("\n\t" + (item.toString()).toUpperCase() + " is not in the bag to remove\n");

	} else {
	    return (bag.remove(new BagElement<T>(item)));
	}//if/else

    } //removeAll

    public int size() { return bag.size(); }

    public void insert(T item) {
	BagElement <T> thing = new BagElement<T>(item);
	
	if (bag.indexOf(thing) == -1) {
	    bag.add(thing);

	} else {
	    thing = bag.remove(bag.indexOf(thing));
	    thing.addOne();
	    bag.add(thing);
	}//if/else

    }//insert

    public void removeOne(T item) throws BagIsEmptyException, ItemNotFoundException {
	BagElement <T> thing = new BagElement<T>(item);

	if (bag.isEmpty()) {
	    throw new BagIsEmptyException("\n\t There is nothing in the bag to remove\n");

	} else if (bag.indexOf(thing) == -1) {
	    throw new ItemNotFoundException("\n\t" + (item.toString()).toUpperCase() + " is not in the bag to remove\n");
	   
	} else {
	    thing = bag.remove(bag.indexOf(thing));
	    thing.removeOne();

	    if (thing.count == 0)
		bag.remove(thing);
	    else
		bag.add(thing);
	}//if/else

    }//removeOne

    public void display() {
	if (bag.isEmpty()) 
	    System.out.println("Your bag is empty!");
	else 
	    for (BagElement element : bag) { System.out.println(element); }
	
    }//display
    
}//end class Bag
