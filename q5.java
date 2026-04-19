/*Q5. Write a Java Program for Eliminating all whitespace characters from a string using user defined
function removeWhitespace()*/
package String_Functions;

public class q5 {

	    public static String removeWhitespace(String str) {
	        return str == null ? null : str.replaceAll("\\s", "");
	    }

	    public static void main(String[] args) {
	        System.out.println("Result: " + removeWhitespace("Hello World"));
	    }
	}

