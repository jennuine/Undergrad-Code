
public class StringMethod {
	public static boolean isNumeric(String word) {
		
		for (int i = 0; i < word.length(); i++) {
			
			if (!Character.isDigit(word.charAt(i))) {
				return false;
			}
		}
	 return true;
	}
	
	public static String removeWhitespaces(String text){
		String string = " " ;

		for (int i = 0; i < text.length(); i++) {
			
			if (!Character.isWhitespace(text.charAt(i))) {
				string = string + text.charAt(i);
			}

		}
		return string;
	}	
}
