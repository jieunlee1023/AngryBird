package component;

import javax.swing.ImageIcon;

public class IceBlock extends Block {

	// 적군이 부딪힌 상태
	private int state; // 0(안부딪힘) , 1, (부딪힘)

	public IceBlock(ImageIcon images) {
		super(images);
		initData();
	}

	private void initData() {
		setVisible(true);
	}

	public void squareBlockArrayCrash() {

//		new Thread(() -> {}).start();

	}

}