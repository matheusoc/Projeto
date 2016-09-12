package view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 8456560429229699542L;
	
	public MainFrame(int width, int height) {
		setVisible(true);
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
