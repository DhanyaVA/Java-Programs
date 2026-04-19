/*Q1. Write a Java Program for Checking if a given string is null or contains only whitespace using user
defined function isNullOrEmpty().*/
package String_Functions;

public class q1 {

	    public static boolean isNullOrEmpty(String str) {
	        return str == null || str.trim().isEmpty();
	    }

	    public static void main(String[] args) {
	        String input = "   ";
	        System.out.println("Is Null or Empty: " + isNullOrEmpty(input));
	    }
	}

