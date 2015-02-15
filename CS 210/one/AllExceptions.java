/**
 * @author Jenn Nguyen
 * AllExceptions.java
 */
package one;

/**
 * The class that will handle all exceptions
 */
@SuppressWarnings("serial")
public class AllExceptions extends Exception {
	
	/**
	 * Instantiates a new all exceptions
	 */
	public AllExceptions() { super(); }
	
	/**
	 * Instantiates a new all exceptions.
	 * @param str the string message
	 */
	public AllExceptions(String str) { super(str); }

}
