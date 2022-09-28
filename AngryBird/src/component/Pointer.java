package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;

public class Pointer extends JLabel {
	
	private int pointerX;
	private int pointerY;
	
	private ImageIcon imageicon;
	

	public Pointer(ImageIcon imageicon) {
		this.imageicon = imageicon;
		setIcon(imageicon);
	
	}

}