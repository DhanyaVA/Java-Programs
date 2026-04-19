package collection;

public class PerformanceTest {

	    public static void main(String[] args) {

	        int n = 10000;

	        // Test with StringBuffer
	        StringBuffer sbf = new StringBuffer();
	        long startTime1 = System.currentTimeMillis();

	        for (int i = 0; i < n; i++) {
	            sbf.append("AIET");
	        }

	        long endTime1 = System.currentTimeMillis();
	        System.out.println("Time taken by StringBuffer: " + (endTime1 - startTime1) + " ms");

	        // Test with StringBuilder
	        StringBuilder sbd = new StringBuilder();
	        long startTime5 = System.currentTimeMillis();

	        for (int i = 0; i < n; i++) {
	            sbd.append("AIET");
	        }

	        long endTime4 = System.currentTimeMillis();
	        System.out.println("Time taken by StringBuilder: " + (endTime4 - startTime5) + " ms");
	    }
	}

