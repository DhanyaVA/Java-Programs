/*5d. Develop a Swing program in Java to create a Tabbed Pan of Cyan, Magenta and Yellow and
display the concerned color whenever the specific tab is selected in the Pan*/
 package swings5;
 
	import javax.swing.*;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;
	import java.awt.*;

	public class TabbedPaneColors extends JFrame {

	    public TabbedPaneColors() {

	        // Create Tabbed Pane
	        JTabbedPane tabbedPane = new JTabbedPane();

	        // Create panels with colors
	        JPanel cyanPanel = new JPanel();
	        cyanPanel.setBackground(Color.CYAN);

	        JPanel magentaPanel = new JPanel();
	        magentaPanel.setBackground(Color.MAGENTA);

	        JPanel yellowPanel = new JPanel();
	        yellowPanel.setBackground(Color.YELLOW);

	        // Add tabs
	        tabbedPane.addTab("Cyan", cyanPanel);
	        tabbedPane.addTab("Magenta", magentaPanel);
	        tabbedPane.addTab("Yellow", yellowPanel);

	        // Add Change Listener
	        tabbedPane.addChangeListener(new ChangeListener() {
	            public void stateChanged(ChangeEvent e) {
	                int index = tabbedPane.getSelectedIndex();
	                String title = tabbedPane.getTitleAt(index);
	                System.out.println("Selected Color: " + title);
	            }
	        });

	        // Add to frame
	        add(tabbedPane);

	        setTitle("Tabbed Pane Example");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        new TabbedPaneColors();
	    }
	}

