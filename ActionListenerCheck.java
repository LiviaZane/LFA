import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.swing.JOptionPane;


public class ActionListenerCheck implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String p = GUI_Tema1.text_pattern.getText();
		String s = GUI_Tema1.text_string.getText();
		try { 
			Pattern pattern = Pattern.compile(p);                                  // Create a Pattern object
			Matcher matcher = pattern.matcher(s);                                  // Create a Matcher object
			if(p.isEmpty() || s.isEmpty()) {                                       // Pattern or string is null
				throw new Exception("Processing fail. Got a null response");
			} else if(matcher.find()) {                                            // String match to pattern
				   		int matchesCounter = 1;                                    // 1 because it was a first find in the above if
				   		while(matcher.find()) {
				   			matchesCounter++;
				   		}
				   		if(matchesCounter == 1) {
				   			JOptionPane.showMessageDialog(GUI_Tema1.frame, "There is one match!" , "Match!", JOptionPane.INFORMATION_MESSAGE);
				   		} else {                                                   // More than one match
				   			JOptionPane.showMessageDialog(GUI_Tema1.frame, "There are some matches! \nThe pattern was found "+ 
				   		         matchesCounter +" times in the string." , "Match!", JOptionPane.INFORMATION_MESSAGE);
				   		}
	               } else {                                                        // String don't match the pattern
	            	   JOptionPane.showMessageDialog(GUI_Tema1.frame, "String don't match to pattern! ", "No match!", JOptionPane.WARNING_MESSAGE);
	               }
		} catch (PatternSyntaxException pse) {
                JOptionPane.showMessageDialog(GUI_Tema1.frame, "There is a problem with the regular expression!" + "\nThe pattern in question is: " + pse.getPattern() +
                		"\nThe description is: " + pse.getDescription() + "\nThe message is: " + pse.getMessage() + "\nThe index is: " + pse.getIndex(),
                		"PatternSyntaxException catched !!! ", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(GUI_Tema1.frame, ex.getMessage(), "Exception catched !!!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
