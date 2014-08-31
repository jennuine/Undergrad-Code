import java.util.*;

public class InfixConverter {
    
    public static Scanner in = new Scanner(System.in);
    public static Stack<Character> stack = new Stack<Character>();
    public static LinkedList<Character> queue = new LinkedList<Character>();
    public static LinkedList<Character> postfixExp = new LinkedList<Character>();
    static String infix = null;
    static char thing1 = ' ';
    static char thing2 = ' ';
    static char ch = ' ';
    static int match = 0;
    static int matchclose = 0;
    static int i = 0;
    public static void main(String[] args) throws InvalidInfixException {
	reqInfix();
	
	System.out.println("\nInfix Expression: “ + infix + “\nInitial queue: " + queue);
	
	for (i = 0; i < infix.length(); i++) {
	    ch = infix.charAt(i);
	   
	    checkFirst();
	    checkExp();
	    isOpand();
	   
		switch(ch) {
		
		case '(':
		    
		    stack.push(ch);
		 queue.poll(); //polls off open parenthesis from queue
		    match++;
		   
		    if (!queue.isEmpty() && isArOp(queue.peek())) {
			throw new InvalidInfixException("\n\nERROR: There is a missing operand in this expression\n"); 
		    }
		    System.out.println("The stack: " + stack);//delete
		    break;
		case ')': 
		    matchclose++;
		    System.out.println("this is the stack" + stack);//delete out
		    

		    while ((!stack.isEmpty()) && (stack.peek() != '(')) {
			postfixExp.offer(stack.pop());
		       

		    }//while
		    // if ((!stack.isEmpty()) && !isOp(infix.charAt(i+1))) {
		    //	    throw new InvalidInfixException("\n\nERROR: Missing operator between << " + ch + " >> and << " + infix.charAt(i+1) + " >>\n");}
		    System.out.println("\n\nThis is the stack & then the queue: \n\t\t" + stack + "\n\t\t" + queue); 
		    if (stack.isEmpty()) {
			throw new InvalidInfixException("\n\nERROR: There is a missing open parenthesis for this expression\n"); 
		    }
		    	
		    else if (stack.peek() == '(' && queue.peek() == ')') { 
			stack.pop();
			thing1 = queue.poll(); 
			if (!queue.isEmpty() && !isArOp(queue.peek()) && queue.peek() != ')') {
			    throw new InvalidInfixException("\n\nERROR: Missing operator between << " + ch + " >> and << " + queue.peek() + " >>\n");}

		    } //pops open par
		    //stack.pop();
		    //thing1 = queue.poll();
		    
		    break;

		    case '+': case '-': case '/': case '*':

		        
        
		    while ((!stack.isEmpty()) && (stack.peek() != '(') && (precedence(ch) <= precedence(stack.peek()))) {
			postfixExp.offer(stack.pop());
		    }//while

		    stack.push(queue.poll());
		    if (!queue.isEmpty() && queue.peek() != '(' && queue.peek() != ')'  && !Character.isLetter(queue.peek())) {
			throw new InvalidInfixException("\n\nERROR: There is a missing operand in this expression\n"); 
			  }
		    break; 

		default:
		   
		 
	      
		    


		}//switch

	}//for
	

	while (!stack.isEmpty()) {
	    char pop = stack.pop();
	    if ( pop == '(' & (match != matchclose) & (thing1 != '(')) {throw new InvalidInfixException("\n\nERROR: There is a missing closing parenthesis for this expression\n");}
	    postfixExp.offer(pop);
	}	
    }//main
    

    /**preconditions: type char, valid operand or operator
       postconditions: return true iff characters in expression contains valid operands or operators
       responses: throws exception if invalid operand or operator
    */
    public static boolean checkExp() throws InvalidInfixException {
	if (Character.isJavaIdentifierPart(ch) && !Character.isLetter(ch) && !isOp(ch)) 
	    throw new InvalidInfixException("\n\nERROR: " + ch + " is not a valid identifier at position " + (i + 1) + " in the queue");
	
	return true;
    }//checkExp

    /**preconditions: type char, valid operand
       postconditions: polls operand off queue and offers into postFixExp iff there is not another operand adjacent
       responses: throws exception if 2 operands are adjacent
    */
    public static void isOpand() throws InvalidInfixException {
	if (Character.isLetter(ch)) {
	    postfixExp.offer(queue.poll());

	    if (!queue.isEmpty() && Character.isLetter(queue.peek()) | queue.peek() == '(') {
		throw new InvalidInfixException("\n\nERROR: Missing operator between << " + ch + " >> and << " + queue.peek() + " >>\n");}
	}//if
    }//isOpand

	/**preconditions: type char, valid operator
	   postconditions: return true iff for char +  -  *  / ( ); else return false
	   @param c --- the char operator
	   responses: true or false
	*/
    public static boolean isOp(char c) {
	return (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')');
    }//iOp
   
    /**preconditions: type char, valid arithmetic operator
       postconditions: return true iff for char + - * /; else return false
       @param c --- the char operator
       responses: true or false
    */
    public static boolean isArOp(char c) {
	return (c == '+' || c == '-' || c == '*' || c == '/');
    }//isArOp

    /**preconditions: type char, 1st character must be operand or open parenthesis
       postconditions: return true if 1st character is operand
       responses: throws exception for beginning with closing parenthesis
       and throws exception for beginning with an operator
       and returns false for else
    */   
    public static boolean checkFirst() throws InvalidInfixException {
	char first = infix.charAt(0);

	if (Character.isLetter(first) || first == '(') {return true;}
	else if (isOp(first)) {
	    throw new InvalidInfixException("\n\nERROR: The infix expression can not start with an operator");}
	else if (first == ')') {
	    throw new InvalidInfixException("\n\nERROR: The infix expression can not start with a closing parenthesis");}

	
	return false;

    }//checkFirst

        /**preconditions: type char, valid operator
       postconditons: returns 0 for + and -; returns 1 for * and /
       responses: returns nothing
    */
    public static int precedence(char ch) {
	int num = 0;
	switch(ch) {
	case '+': case '-':
	    break;
	case '*': case '/':
	    num = 1;
	    break;
	}//switch
	return num;
    }//precedence

   /**preconditions: valid infix expression
       postconditions: store identifiers in the queue except for spaces
       responses: does nothing
    */
    private static void reqInfix() {
	System.out.println("Please enter an infix expression to convert to postfix");
	infix = in.nextLine();

	for (int i = 0; i < infix.length(); i++) {
	    char thing = infix.charAt(i);

	    if (!Character.isSpaceChar(thing))
		queue.offer(thing);
	}//for
    }//reqInfix

}//InfixConverter

import java.util.*;

public class Test {
    public static void main(String[] args) {

	System.out.println(Character.isJavaIdentifierPart('a'));
    }

}
