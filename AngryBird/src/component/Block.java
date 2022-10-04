package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Block extends JLabel {

	private ImageIcon image;

	public Block(ImageIcon images) {
		this.image = images;
		setIcon(image);
	}

}
