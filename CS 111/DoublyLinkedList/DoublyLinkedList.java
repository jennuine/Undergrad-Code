public class DoublyLinkedList<Comparable> {
    
    public static class Node<Comparable> {
	
	private Comparable data;
	private Node<Comparable> next;
	private Node<Comparable> prev;

	private Node(Comparable d) {
	    data = d;
	    prev = null;
	    next = null;
	}

	private Node(Comparable d, Node<Comparable> pref, Node<Comparable> nref) {
	    data = d;
	    prev = pref;
	    next = nref;
	}

    }//end Node

    private Node<Comparable> head;
    private Node<Comparable> current;
    private int size;

    /**preconditions: none
       postconditions: creates an empty list
       responses: none
     */
    public DoublyLinkedList() { 
	head = new Node<Comparable>(null);

	head.next = head;
	head.prev = head;
	current = head;

	size = 0;
    }//constructor

    /**preconditions: l must be a valid DoublyLinkedList
       postconditions: will create a deep copy of list l
       @param - the DoublyLinkedList to be copied
       responses: error terminate
     */
    public DoublyLinkedList(DoublyLinkedList<Comparable> l) {
     
	head = new Node<Comparable>(l.head.data);
	l.begin();

	current = new Node<Comparable>(l.current.data, head, head);
	head.next = current;
	head.prev = current;

	Node<Comparable> newNode;
	current = head.next;

	for (Node<Comparable> i = l.current.next; i != l.head; i = i.next) {
	    newNode = new Node<Comparable>(i.data);
	    newNode.prev = current;
	    current.next = newNode;
	    current = newNode;
	}//for

	head.prev = current;
	current.next = head;
	
	size = l.size();
    }//copy constructor

    /**preconditions: d is a valid Comparable
       postconditions: Comparable d is inserted, in the correct position, in the list
       @param d - data to be inserted
     */
    public void insert(java.lang.Comparable d) {

	if (empty()) {
	    current = new Node<Comparable>((Comparable)d, head, head);
	    head.prev = current;
	    head.next = current;

	} else {
	    begin();
	    
	    while (current.next != head && d.compareTo(current.data) > 0) { current = current.next; }

	    Node<Comparable> newNode = new Node<Comparable>((Comparable)d, current.prev, current);

	    (current.prev) = newNode;
	    (newNode.prev).next = newNode;
	}//if/else

	size++;
    }//insert

    /**preconditions: d is a valid Comparable
       postcondtions: d will be removed from the list, if it is in the list
       @param d - data to be removed
       responses: will throw ListEmptyException if the list is empty; 
       will throw NotInListException if d is not found in the list
     */
    public void remove(java.lang.Comparable d) throws ListEmptyException, NotInListException {
	
	if (empty()) throw new ListEmptyException(" ");
	
	current = head.next;

	while (current != head && d.compareTo(current.data) > 0) { current = current.next; }

	if (current.next != head && !(current.data).equals(d)) throw new NotInListException(" ");

	(current.prev).next = current.next;
	(current.next).prev = current.prev;
	size--;
    }//remove

    /**preconditions:  valid list created
       postconditions: sets current to point to the node next to head
       responses: error terminate
     */
    public void begin() { current = head.next; }

    /**preconditions: valid list created
       postconditions: moves current to point to the node next to it
       responses: error terminate
     */
    public void advance() { current = current.next; }

    /**preconditions: valid list created
       postconditions: moves current to point to the node before it
       responses: error terminate
     */
    public void retreat() { current = current.prev; }

    /**precondtions: valid list created
       postcondtions: returns the data that current points to
       responses: if the list is empty it will throw ListEmptyException
     */
    public Comparable current() throws ListEmptyException {

	if (empty()) throw new ListEmptyException(" ");
	
	return current.data;
    }//current

    /**preconditions: valid list created
       postconditions: current points to head 
       responses: error terminate
     */
    public boolean end() { return (head == current); }

    /**preconditions: valid list created
       postcondtions: return true if the list is empty;
       return false if the list is not empty
       responses: error terminate
     */
    public boolean empty() { return size == 0; }

    /**preconditions: valid list created
       postconditions: returns the size of the list
       responses: error terminate
    */
    public int size() { return size; }

}//end DoublyLinkedList 
