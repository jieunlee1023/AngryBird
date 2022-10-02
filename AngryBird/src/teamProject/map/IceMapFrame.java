package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.IceBlock;
import lombok.Value;

public class IceMapFrame extends Background {

	String[] images = { "images/ice_block_square.png", "images/ice_block_width_rectangle.png",
			"images/ice_block_height_rectangle.png", "images/ice_block_width_long.png",
			"images/ice_block_height_long.png", "images/ice_roop.png" };

	protected IceBlock[] squareBlocks = new IceBlock[15];
	protected IceBlock[] heightLongBottom = new IceBlock[3];
	protected IceBlock[] widthLongBottom = new IceBlock[2];
	protected IceBlock[] heightLongCenter = new IceBlock[3];
	protected IceBlock[] widthLongCenter = new IceBlock[2];
	protected IceBlock[] widthRectangleCenter = new IceBlock[3];
	protected IceBlock[] heightLongTop = new IceBlock[2];
	protected IceBlock[] widthLongTop = new IceBlock[1];
	protected IceBlock[] iceRoop = new IceBlock[1];

	protected Enemy enemyBottom;
	protected Enemy enemyTop;

	boolean crashState;
	int enemyOutState;
	// 0일때 안부딪힘 1일때 한마리 부딪힘 2일때 두마리부딪힘(끝)

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
				crash(iceRoop);
			} // end of while
			flag = false;
		}).start();

		enemyCrash(enemyBottom);
		enemyCrash(enemyTop);
	}

	protected void initData() {
		setTitle("Ice Map");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		crashState = false;
		enemyOutState = 0;

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
		iceRoop[0] = new IceBlock(new ImageIcon(images[5]));

		enemyBottom = new Enemy(new ImageIcon("images/pig.png"));
		enemyTop = new Enemy(new ImageIcon("images/pig.png"));

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

		iceRoop[0].setSize(135, 80);
		iceRoop[0].setLocation(760, 60);
		backgroundImageLabel.add(iceRoop[0]);

		enemyBottom.setSize(60, 60);
		enemyBottom.setLocation(850, 430);
		backgroundImageLabel.add(enemyBottom);

		enemyTop.setSize(60, 60);
		enemyTop.setLocation(800, 170);
		backgroundImageLabel.add(enemyTop);

	}

	public void crash(IceBlock[] iceBlock) {
		crashState = true;
		for (int i = 0; i < iceBlock.length; i++) {
			for (int j = 0; j < player.length; j++) {
				if (Math.abs(iceBlock[i].getX() - player[j].getX()) < 50
						&& Math.abs(iceBlock[i].getY() - player[j].getY()) < 50) {
//					System.out.println("부딪힘");
					// 블록 맞으면 +200 점
					mContext.score += 200;
					mContext.scoreLabel.setText("SCORE : " + mContext.getScore());
					iceBlock[i].setLocation(0, 0);
					iceBlock[i].setVisible(false);
					player[j].isMove = false;
				}
			} // end of j-for
		} // end of i-for
	}

	public void enemyCrash(Enemy enemy) {

		new Thread(() -> {
			while (enemyOutState == 0) {
				for (int i = 0; i < player.length; i++) {
					if (Math.abs(enemy.getX() - player[i].getX()) < 50
							&& Math.abs(enemy.getY() - player[i].getY()) < 50) {
						JLabel enemyOut = new JLabel(new ImageIcon("images/bang.png"));
						enemyOut.setSize(60, 60);
						enemyOut.setLocation(enemy.getX(), enemy.getY());
						backgroundImageLabel.add(enemyOut);
						// 에너미 맞으면 +500 점
						mContext.score += 500;
						mContext.scoreLabel.setText("SCORE : " + mContext.getScore());
						enemy.setVisible(false);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						enemyOut.setVisible(false);
						enemyOutState++;
						System.out.println(enemyOutState);
					}
				}
			}
			if (enemyOutState == 2) {
				for (int i = 0; i < player.length; i++) {
					if (Math.abs(enemy.getX() - player[i].getX()) < 50
							&& Math.abs(enemy.getY() - player[i].getY()) < 50) {
						JLabel enemyOut = new JLabel(new ImageIcon("images/bang.png"));
						enemyOut.setSize(60, 60);
						enemyOut.setLocation(enemy.getX(), enemy.getY());
						backgroundImageLabel.add(enemyOut);
						// 에너미 맞으면 +500 점
						mContext.score += 500;
						mContext.scoreLabel.setText("SCORE : " + mContext.getScore());
						enemy.setVisible(false);

						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						nextStage();

					}
				}
			}
		}).start();

	}

	public void nextStage() {

		if (enemyOutState == 2) {
			JLabel clear = new JLabel(new ImageIcon("images/clear.png"));
			backgroundImageLabel.setVisible(false);
			clear.setSize(1000, 570);
			clear.setLocation(0, 0);
			add(clear);
			repaint();

			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			new HolloweenMapFrame("images/bg3.png");
			setVisible(false);
		}
	}
}
