import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class JQNguyen9 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	LinkedList<Character> queue = new LinkedList<Character>();
	Stack<String> stack = new Stack<String>();
	char thing;
	char op;

	System.out.println("Please enter the postfix expression:");
	String postFix = in.next();

	for (int i = 0; i < postFix.length(); i++) {
	    thing = postFix.charAt(i);
	    queue.offer(thing); 
	}//for
	
	System.out.println("Queue for postfix: " + queue);

	while (!queue.isEmpty()) {
	    if (Character.isLetter(queue.peek())) {
		char letter = queue.poll();
		stack.push(Character.toString(letter));
	    } else if (Character.isDigit(queue.peek())) {
		int digit = queue.poll();
		stack.push(Integer.toString(digit));
	    } else {
		op = queue.poll();
		String right = stack.pop();
		String left = stack.pop();
		stack.push(op + left + right);
	
	    }//else
	}//while
	System.out.println("Converted prefix: " + stack);

    }//main
}//class JQNguyen9
