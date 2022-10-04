package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel {

	private ImageIcon pig;

	public Enemy(ImageIcon pig) {
		this.pig = pig;
		setIcon(pig);
	}

}