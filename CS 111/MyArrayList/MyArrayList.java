public class MyArrayList<T> {

    private T[] arr = (T[]) new Object[2];
    private int numElements = 0;

    public void display() {
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] != null) 
		System.out.println(arr[i]);
	}
    }

    public boolean empty() {
	return (numElements == 0);
    }

    public void resize() {
	T[] temp = (T[]) new Object[2 * numElements];

	for (int i = 0; i < arr.length; i++) {
	    temp[i] = arr[i];
	}
	arr = temp;
    }

    public void add(T item) {
	if (numElements == arr.length) { resize(); }

	arr[numElements] = item;
	numElements++;	
    }

    public T remove(T value) {
	T found = null;

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == value) {
		found = arr[i];
		arr[i] = arr[numElements - 1];
		arr[numElements -1] = null;
	    }//if

	    if (empty()) { 
		found = null;;
	    }
	}//for
	return found;
    }//remove

    public T front() {
	return arr[0];
    }


}//end MyArrayList