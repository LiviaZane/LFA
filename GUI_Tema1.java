import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class GUI_Tema1 {

	protected static JFrame frame;                             //static to be accessed from ActionListenerCheck class
	protected static JTextArea text_pattern;
	protected static JTextArea text_string;
	
	public GUI_Tema1() {
		frame = new JFrame("Application with a grafic interface that check if a string respects a pattern using regular expressions");
		frame.setSize(760,310); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
	    text_pattern = new JTextArea();
	    text_pattern.setBounds(10,10,200,75);
	    frame.add(text_pattern);
	    
	    text_string = new JTextArea();
	    text_string.setBounds(10,100,600,75);
	    frame.add(text_string);
	    
	    JLabel pattern_label = new JLabel("(text pattern)");
	    pattern_label.setBounds(220,10,200,75);
	    frame.add(pattern_label);
	    
		JLabel string_label = new JLabel("(string search)");
		string_label.setBounds(620,100,600,75);
		frame.add(string_label);
		
		JButton btn1 = new JButton("Check");
		btn1.setBounds(100, 200, 100, 30); 
		ActionListener listenerCheck = new ActionListenerCheck();
		btn1.addActionListener(listenerCheck);
		frame.add(btn1);
		    
		JButton btn2 = new JButton("Clear fields");
		btn2.setBounds(400, 200, 100, 30);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_pattern.setText("");
				text_string.setText("");
			}
		});
		frame.add(btn2);
		
		frame.setVisible(true);
		
	}
	
}
