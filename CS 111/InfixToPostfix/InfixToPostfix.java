/*****************************
     InfixToPostfix.java

    Jenn Nguyen (jqnguyen)

    CS111 OutLab3 Lab Sec07

*****************************/

import java.util.*;

public class InfixToPostfix {
    
    public static Scanner in = new Scanner(System.in);
    public static Stack<Character> stack = new Stack<Character>();
    public static LinkedList<Character> queue = new LinkedList<Character>();
    public static LinkedList<Character> postfixExp = new LinkedList<Character>();
    static String infix = null;
    static char thing1 = ' ';
    static char ch = ' ';
    static int open = 0;
    static int close = 0;

    public static void main(String[] args) throws InvalidInfixException {
	reqInfix();
	
	System.out.println("\n\tInfix queue: " + queue);
	
	for (int i = 0; i < infix.length(); i++) {
	    ch = infix.charAt(i);
	   
	    checkFirst();
	    checkExp();
	    isOpand();
	   
	    switch(ch) {
		
	    case '(':
		    
		stack.push(ch);
		queue.poll();//polls off par from queue
	        open++;
		   
		if (!queue.isEmpty() && isArOp(queue.peek())) {
		    throw new InvalidInfixException("\n\nERROR: There is a missing operand in this expression\n");}
		   
		break;
	    case ')': 
		close++;

		while ((!stack.isEmpty()) && (stack.peek() != '(')) {
		    postfixExp.offer(stack.pop());
		}//while
		
		if (stack.isEmpty()) {
		    throw new InvalidInfixException("\n\nERROR: There is a missing open parenthesis for this expression\n"); 

		} else if (stack.peek() == '(' && queue.peek() == ')') { 
		    stack.pop();
		    queue.poll(); 

		    if (!queue.isEmpty() && !isArOp(queue.peek()) && queue.peek() != ')') {
			throw new InvalidInfixException("\n\nERROR: Missing operator between << " + ch + " >> and << " + queue.peek() + " >>\n");}
		} //if/else
		    
		break;

	    case '+': case '-': case '/': case '*':

		while ((!stack.isEmpty()) && (stack.peek() != '(') && (precedence(ch) <= precedence(stack.peek()))) {
		    postfixExp.offer(stack.pop());
		}//while
		
		char polled = queue.poll();
		stack.push(polled);

		if (!queue.isEmpty() && queue.peek() != '(' && queue.peek() != ')'  && !Character.isLetter(queue.peek())) {
		    throw new InvalidInfixException("\n\nERROR: There is a missing operand in this expression\n");}
		else if (queue.isEmpty() && isArOp(polled)) {
		    throw new InvalidInfixException("\n\nERROR: There is a missing operand at the end of this expression\n");}
		break; 
	    }//switch
	}//for

	while (!stack.isEmpty()) {
	    char pop = stack.pop();
	    if ( pop == '(' & (open != close) & (thing1 != '(')) {
		throw new InvalidInfixException("\n\nERROR: There is a missing closing parenthesis for this expression\n");}
	    
	    postfixExp.offer(pop);
	}//while	

	System.out.println("\tConverted Postfix Queue: " + postfixExp);
 
    }//main
    

    /**preconditions: type char, valid operand or operator
       postconditions: return true iff characters in expression contains valid operands or operators
       responses: throws exception if invalid operand or operator
    */
    public static boolean checkExp() throws InvalidInfixException {
	if (Character.isJavaIdentifierPart(ch) && !Character.isLetter(ch) && !isOp(ch)) 
	    throw new InvalidInfixException("\n\nERROR: " + ch + " is not a valid identifier\n");
	
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
	System.out.println("\nPlease enter an infix expression to convert to postfix");
	infix = in.nextLine();

	for (int i = 0; i < infix.length(); i++) {
	    char thing = infix.charAt(i);

	    if (!Character.isSpaceChar(thing))
		queue.offer(thing);
	}//for
    }//reqInfix
}//InfixToPostfix
