package String_Functions;

public class q2 {


	    public static int countOccurrences(String mainString, String subString) {
	        if (mainString == null || subString == null || subString.isEmpty()) {
	            return 0;
	        }
	        return (mainString.length() - mainString.replace(subString, "").length()) / subString.length();
	    }

	    public static void main(String[] args) {
	        System.out.println("Occurrences: " + countOccurrences("hello hello world", "hello"));
	    }
	}

