/*5c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada, Denmark,
France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and display the capital of the
countries on console whenever the countries are selected on the list.*/
package swings5;

	import java.util.HashMap;
	import java.util.List;
	import javax.swing.*;

	public class CountryCapitalList extends JFrame {

	    private JList<String> countryList;
	    private HashMap<String, String> capitalMap;

	    public CountryCapitalList() {

	        // Create list model
	        DefaultListModel<String> model = new DefaultListModel<>();
	        model.addElement("USA");
	        model.addElement("India");
	        model.addElement("Vietnam");
	        model.addElement("Canada");
	        model.addElement("Denmark");
	        model.addElement("France");
	        model.addElement("Great Britain");
	        model.addElement("Japan");
	        model.addElement("Africa");
	        model.addElement("Greenland");
	        model.addElement("Singapore");

	        // Create JList
	        countryList = new JList<>(model);

	        // Allow multiple selection
	        countryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

	        // Create HashMap for country-capital
	        capitalMap = new HashMap<>();
	        capitalMap.put("USA", "Washington D.C.");
	        capitalMap.put("India", "New Delhi");
	        capitalMap.put("Vietnam", "Hanoi");
	        capitalMap.put("Canada", "Ottawa");
	        capitalMap.put("Denmark", "Copenhagen");
	        capitalMap.put("France", "Paris");
	        capitalMap.put("Great Britain", "London");
	        capitalMap.put("Japan", "Tokyo");
	        capitalMap.put("Africa", "Addis Ababa");
	        capitalMap.put("Greenland", "Nuuk");
	        capitalMap.put("Singapore", "Singapore");

	        // Add listener
	        countryList.addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                List<String> selected = countryList.getSelectedValuesList();

	                for (String country : selected) {
	                    System.out.println("Capital of " + country + " is: " + capitalMap.get(country));
	                }
	                System.out.println(); // blank line
	            }
	        });

	        // Add to frame
	        add(new JScrollPane(countryList));

	        setTitle("Country Capitals");
	        setSize(300, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new CountryCapitalList();
	    }
	}

