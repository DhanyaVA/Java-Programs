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

