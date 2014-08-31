//UnorderedListDyn

public class UnorderedListDyn<T> {
    
    public class Node<T> {
	T data;
	Node<T> next;

	public Node(T stuff) {
	    data = stuff;
	}

	public Node(T stuff, Node<T> nxt) {
	    data = stuff;
	    next = nxt;
	}
    }//end Node

    Node<T> head;
    int size;

    public UnorderedListDyn() {
	head = null;
	size = 0;
    }

    public void add(T value) {
	Node<T> newNode = new Node<T>(value);
	newNode.next = head;
	head = newNode;
	size++;
    }

    public void remove(T value) throws NotFoundInListException, ListEmptyException {
	Node<T> prev;
	Node<T> curr;

	if (head == null) throw new ListEmptyException("The list is empty");

	prev = null;
	curr = head;

	while(curr != null && !curr.data.equals(value)) {
	    prev = curr;
	    curr = curr.next;

	if (curr.next == null) throw new NotFoundInListException("The data you entered was not found in the list");
	}
	
	prev.next = curr.next;
	curr.next = null;
	size--;
    }//remove

    public void displayForward() {
	Node<T> curr = head;

	while(curr != null) {
	    System.out.print(curr.data);
	    curr = curr.next;
	}
	System.out.println();
    }

    public int size() {
	return size;
    }
}//end UnorderedListDyn