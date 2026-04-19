/*2 a. Develop a java program for performing various string operations with different string handling
functions directed as follows
String Creation and Basic Operations, Length and Character Access, String Comparison, String Searching,
Substring Operations , String Modification, Whitespace Handling, String Concatenation, String
Splitting, StringBuilder Demo, String Formatting , Validate Email with contains( ) and startsWith() and
endsWith()*/
package collection;

public class StringOperationsDemo {


	    public static void main(String[] args) {

	        // 1. String Creation and Basic Operations
	        String str1 = "Hello";
	        String str2 = new String("World");
	        System.out.println("String 1: " + str1);
	        System.out.println("String 2: " + str2);

	        // 2. Length and Character Access
	        System.out.println("\nLength of str1: " + str1.length());
	        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

	        // 3. String Comparison
	        String str3 = "hello";
	        System.out.println("\nEquals: " + str1.equals(str3));
	        System.out.println("Equals Ignore Case: " + str1.equalsIgnoreCase(str3));
	        System.out.println("CompareTo: " + str1.compareTo(str2));

	        // 4. String Searching
	        String text = "Java Programming";
	        System.out.println("\nIndex of 'Pro': " + text.indexOf("Pro"));
	        System.out.println("Contains 'Java': " + text.contains("Java"));

	        // 5. Substring Operations
	        System.out.println("\nSubstring (0-4): " + text.substring(0, 4));

	        // 6. String Modification
	        System.out.println("\nTo Upper Case: " + text.toUpperCase());
	        System.out.println("To Lower Case: " + text.toLowerCase());
	        System.out.println("Replace 'Java' with 'Python': " + text.replace("Java", "Python"));

	        // 7. Whitespace Handling
	        String str4 = "   Hello Java   ";
	        System.out.println("\nBefore Trim: '" + str4 + "'");
	        System.out.println("After Trim: '" + str4.trim() + "'");

	        // 8. String Concatenation
	        String concat = str1 + " " + str2;
	        System.out.println("\nConcatenated String: " + concat);
	        System.out.println("Using concat(): " + str1.concat(str2));

	        // 9. String Splitting
	        String fruits = "Apple,Banana,Orange";
	        String[] arr = fruits.split(",");
	        System.out.println("\nSplitting Fruits:");
	        for (String fruit : arr) {
	            System.out.println(fruit);
	        }

	        // 10. StringBuilder Demo
	        StringBuilder sb = new StringBuilder("Hello");
	        sb.append(" World");
	        sb.insert(5, " Java");
	        sb.replace(0, 5, "Hi");
	        System.out.println("\nStringBuilder Result: " + sb);

	        // 11. String Formatting
	        int age = 20;
	        String formatted = String.format("My age is %d", age);
	        System.out.println("\nFormatted String: " + formatted);

	        // 12. Validate Email using contains(), startsWith(), endsWith()
	        String email = "example@gmail.com";

	        if (email.contains("@") &&
	            email.endsWith(".com") &&
	            !email.startsWith("@")) {
	            System.out.println("\nValid Email");
	        } else {
	            System.out.println("\nInvalid Email");
	        }
	    }
	
	}

