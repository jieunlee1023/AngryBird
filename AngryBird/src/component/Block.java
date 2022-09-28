package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Block extends JLabel {

	private ImageIcon image;

	public Block(ImageIcon images) {
		this.image = images;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

}
