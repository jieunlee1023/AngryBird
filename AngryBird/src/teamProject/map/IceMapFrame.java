package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.IceBlock;

public class IceMapFrame extends Background {

	String[] images = { "images/ice_block_square.png", "images/ice_block_width_rectangle.png",
			"images/ice_block_height_rectangle.png", "images/ice_block_width_long.png",
			"images/ice_block_height_long.png" };

	protected IceBlock[] squareBlocks = new IceBlock[15];
	protected IceBlock[] heightLongBottom = new IceBlock[3];
	protected IceBlock[] widthLongBottom = new IceBlock[2];
	protected IceBlock[] heightLongCenter = new IceBlock[3];
	protected IceBlock[] widthLongCenter = new IceBlock[2];
	protected IceBlock[] widthRectangleCenter = new IceBlock[3];
	protected IceBlock[] heightLongTop = new IceBlock[2];
	protected IceBlock[] widthLongTop = new IceBlock[1];
	protected JLabel iceRoop;

	protected Enemy enemyBottom;
	protected Enemy enemyTop;

	private ImageIcon iceBreakBlock;

	boolean state;

	public IceMapFrame(String fileName) {
		super(fileName);
		initData();

		new Thread(() -> {
			boolean flag = true;
			while (flag) {
				crash(squareBlocks);
				crash(heightLongBottom);
				crash(widthLongBottom);
				crash(heightLongCenter);
				crash(widthLongCenter);
				crash(widthRectangleCenter);
				crash(heightLongTop);
				crash(widthLongTop);
			} // end of while
			flag = false;
		}).start();

	}

	protected void initData() {
		setTitle("Ice Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		state = false;

		for (int i = 0; i < squareBlocks.length; i++) {
			squareBlocks[i] = new IceBlock(new ImageIcon(images[0]));

		}
		for (int i = 0; i < 3; i++) {
			heightLongBottom[i] = new IceBlock(new ImageIcon(images[4]));
		}
		for (int i = 0; i < 2; i++) {
			widthLongBottom[i] = new IceBlock(new ImageIcon(images[3]));
		}
		for (int i = 0; i < 3; i++) {
			heightLongCenter[i] = new IceBlock(new ImageIcon(images[4]));
		}
		for (int i = 0; i < 2; i++) {
			widthLongCenter[i] = new IceBlock(new ImageIcon(images[3]));
		}
		for (int i = 0; i < 3; i++) {
			widthRectangleCenter[i] = new IceBlock(new ImageIcon(images[1]));
		}
		for (int i = 0; i < 2; i++) {
			heightLongTop[i] = new IceBlock(new ImageIcon(images[4]));
		}
		widthLongTop[0] = new IceBlock(new ImageIcon(images[3]));

		enemyBottom = new Enemy(new ImageIcon("images/pig.png"));
		enemyTop = new Enemy(new ImageIcon("images/pig.png"));

		iceBreakBlock = new ImageIcon("images/icebreak.png");
		iceRoop = new JLabel(new ImageIcon("images/ice_roop.png"));

		for (int i = 0; i < squareBlocks.length; i++) {
			squareBlocks[i].setSize(50, 50);
			squareBlocks[i].setLocation(650, (i * 50 / 2) + 110);
			backgroundImageLabel.add(squareBlocks[i]);
		}
		for (int i = 0; i < 3; i++) {
			heightLongBottom[i].setSize(15, 100);
			heightLongBottom[i].setLocation(720 + (i * 100), +400);
			backgroundImageLabel.add(heightLongBottom[i]);
		}
		for (int i = 0; i < 2; i++) {
			widthLongBottom[i].setSize(100, 15);
			widthLongBottom[i].setLocation(730 + (i * 100), +385);
			backgroundImageLabel.add(widthLongBottom[i]);
		}
		for (int i = 0; i < 3; i++) {
			heightLongCenter[i].setSize(15, 100);
			heightLongCenter[i].setLocation(720 + (i * 100), +290);
			backgroundImageLabel.add(heightLongCenter[i]);
		}
		for (int i = 0; i < 2; i++) {
			widthLongCenter[i].setSize(100, 15);
			widthLongCenter[i].setLocation(730 + (i * 100), +275);
			backgroundImageLabel.add(widthLongCenter[i]);
		}
		for (int i = 0; i < 3; i++) {
			widthRectangleCenter[i].setSize(60, 30);
			widthRectangleCenter[i].setLocation(740 + (i * 60), +250);
			backgroundImageLabel.add(widthRectangleCenter[i]);
		}
		for (int i = 0; i < 2; i++) {
			heightLongTop[i].setSize(15, 100);
			heightLongTop[i].setLocation(770 + (i * 100), +150);
			backgroundImageLabel.add(heightLongTop[i]);
		}

		widthLongTop[0].setSize(100, 15);
		widthLongTop[0].setLocation(780, 135);
		backgroundImageLabel.add(widthLongTop[0]);

		iceRoop.setSize(135, 80);
		iceRoop.setLocation(760, 60);
		backgroundImageLabel.add(iceRoop);

		enemyBottom.setSize(60, 60);
		enemyBottom.setLocation(850, 430);
		backgroundImageLabel.add(enemyBottom);

		enemyTop.setSize(60, 60);
		enemyTop.setLocation(800, 170);
		backgroundImageLabel.add(enemyTop);
		
	}
	
	public void crash(IceBlock[] iceBlock) {
		for (int i = 0; i < iceBlock.length; i++) {
			for (int j = 0; j < player.length; j++) {
				if (Math.abs(iceBlock[i].getX() - player[j].getX()) < 50
						&& Math.abs(iceBlock[i].getY() - player[j].getY()) < 50) {
					System.out.println("부딪힘");
					iceBlock[i].setVisible(false);
				}
			} // end of j-for
		} // end of i-for

	}

}
