import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel {
	Game game;
	Timer tm;
	Panel(){
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		game = new Game(width, height);
		tm = new Timer(3000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

//				game = new Game(width);
				repaint();
			}
		});
		tm.start();
	}
	public void paint(Graphics g) {
		super.paint(g);
		game.ComputerField.paintField(g);
		game.PlayerField.paintField(g);
	}
}
