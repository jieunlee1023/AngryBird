package component;

import javax.swing.ImageIcon;

public class TreeBlock extends Block {

	private int blockX;
	private int blockY;

	private int state; // 0(안부딪힘) , 1, (부딪힘)

	public TreeBlock(ImageIcon images) {
		super(images);
		inidData();
		setInitLayout();
	}

	private void inidData() {
		setVisible(true);
	}

	private void setInitLayout() {
	}


}