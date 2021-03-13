import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {
	Panel panel;
	
	Frame(){
		panel = new Panel();
		add(panel);
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
}
