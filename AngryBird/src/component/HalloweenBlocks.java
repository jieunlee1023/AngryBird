package component;

import javax.swing.ImageIcon;

public class HalloweenBlocks extends Block {

	// 적군이 부딪힌 상태
	private int state; // 0(안부딪힘) , 1, (부딪힘)

	public HalloweenBlocks(ImageIcon images) {
		super(images);
		initData();
	}

	private void initData() {
		setVisible(true);
	}

}