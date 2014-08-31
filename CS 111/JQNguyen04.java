import java.util.ArrayList;

public class JQNguyen04 {
    public static void main(String [] args) 
    {

	
	System.out.println();

	int[] test = {1, 2, 3, 4, 5, 6};
       
	rev(test, 0, 5);

	for ( int i = 0; i < test.length; i++)
	    {
		System.out.print(test[i]+ " ");
	    }
	System.out.println();
	String str = "abc";
	
	System.out.println(permutations(str));

    }

    public static void rev(int[] arr, int low, int high)
    {	
	if (low <= high)
	    {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		
		rev(arr, low + 1, high - 1);
	    }
    }

   public static ArrayList<String> permutations(String str)
	{
	    ArrayList<String> perms = new ArrayList <String> ();
	    
	    	if (str.isEmpty())
	    	{
	    		System.out.print(str);
	    	}
	    	else if (str.length() == 1)
	    	{
	    		perms.add(str);
	    		return perms;
	    	}
	    	else
	    	{
	    		char first = str.charAt(0);
    			String remain = str.substring(1);
    			ArrayList<String> rset = permutations(remain);
    			
	    		for (String current : rset)
	    		{
	    			for (int i = 0; i < current.length(); i++)
	    			{
				    String added = current.substring(0, i) + first + current.substring(i);
	    				perms.add(added);
	    			}
	    			perms.addAll(rset);
	    		}
	    		return perms;
	    	}
	    return perms;
	    
	    
	}
}
