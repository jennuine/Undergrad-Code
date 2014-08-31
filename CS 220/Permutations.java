import java.util.ArrayList;
import java.util.Scanner;


/********************
 *Permutations Program
 *@author Jenn Nguyen
 *
 *******************/

public class Permutations {
    public static void main(String [] args) {
	Scanner input = new Scanner(System.in);

	String miss = "MISSISSIPPI";
	String flo = "FLORIDA";
    
	System.out.println("\nFLORIDA permutates " + (permutations(flo)).size() + " times.");
	System.out.println("MISSISSIPPI permutates " + (permutations(miss)).size() + " times.");
	System.out.println("\nPlease hit enter if you would like to see FLORIDA permutated.");
	input.nextLine();
	System.out.println(permutations(flo) + "\n\nPlease hit enter if you would like to see MISSISSIPPI permutated.");
	input.nextLine();
	System.out.println(permutations(miss));

	
    }//main
  
  public static ArrayList<String> permutations(String str) {
    ArrayList<String> perms = new ArrayList <String> ();
    
    if (str.isEmpty()) {
	perms.add("");
        System.out.print(str);

   } else if (str.length() == 1) {
      perms.add(str);
      return perms;
	
    } else {
	char first = str.charAt(0);
	String remain = str.substring(1);
	ArrayList<String> rset = permutations(remain);

	for (String current : rset) {

	    for (int i = 0; i <= current.length(); i++) {
			
		String added = current.substring(0, i) + first + current.substring(i);
		if (!perms.contains(added))
		    perms.add(added);	
   
	    }//for
	}//for
	return perms;

    }//else
    return perms; 
  }//permutations
}//class
