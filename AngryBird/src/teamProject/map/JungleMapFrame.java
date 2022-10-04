package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.TreeBlock;
import teamProject.frame.BGM;

public class JungleMapFrame extends Background {

	String[] images = { "images/woodBlock_downRec.png", "images/woodBlock_upRec.png", "images/woodBlock_thinUpRec.png",
			"images/woodBlock_thinDownRec.png", "images/woodBlock_square.png", "images/wood_roop.png" };

	private TreeBlock[] woodSquare = new TreeBlock[40];
	private TreeBlock[] woodBlock = new TreeBlock[14];
	private TreeBlock[] longWoodBlock = new TreeBlock[5];
	private TreeBlock[] WoodOblongBlock = new TreeBlock[5];
	private TreeBlock[] longWoodOblongBlock = new TreeBlock[5];
	private TreeBlock[] roofBlock = new TreeBlock[1];

	private int enemyOutState;

	private int WOODSQUARE_WIDTH = 50;
	private int WOODSQUARE_HEIGHT = 50;

	private int WOODBLOCK_WIDTH = 50;
	private int WOODBLOCK_HEIGHT = 50;

	private int WOODBLOCK_L_WIDTH = 50;
	private int WOODBLOCK_L_HEIGHT = 50;

	private int OBLONGWOODBLOCK_WIDTH = 100;
	private int OBLONGWOODBLOCK_HEIGHT = 15;

	private int OBLONGWOODBLOCK_L_WIDTH = 15;
	private int OBLONGWOODBLOCK_L_HEIGHT = 100;

	private int shieldPigWidth = 100;
	private int shieldPigHeight = 100;

	private int realBombWidth = 100;
	private int realBombHeight = 100;

	private int roofBlockWidth = 300;
	private int roofBlockHeight = 180;

	private int clearWidth = 1000;
	private int clearHeight = 570;

	TreeBlock treeBlock;

	private ImageIcon bomb;

	Enemy shieldPig;
	Enemy realBomb;
	Enemy target;

	BGM bgh;

	public Enemy getEnemy() {
		return shieldPig;
	}

	public void setEnemy(Enemy enemy) {
		this.shieldPig = enemy;
	}

	public JungleMapFrame(String fileName) {
		super(fileName);
		initData();
		endStage();
	}

	private void initData() {
		bgh = new BGM();

		setTitle("jungle Maps");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		enemyOutState = 0;
		// pig
		shieldPig = new Enemy(new ImageIcon("images/shield.png"));
		realBomb = new Enemy(new ImageIcon("images/bomb.png"));
		target = new Enemy(new ImageIcon("images/bomb.png"));

		backgroundImageLabel.add(target);
		backgroundImageLabel.add(shieldPig);
		shieldPig.setSize(shieldPigWidth, shieldPigHeight);
		shieldPig.setLocation(750, 235);

		backgroundImageLabel.add(realBomb);
		realBomb.setSize(realBombWidth, realBombHeight);
		realBomb.setLocation(615, 270);

		// 터지는 모션
		bomb = new ImageIcon("images/bumb1.png");

		// roof
		for (int i = 0; i < roofBlock.length; i++) {
			roofBlock[i] = new TreeBlock(new ImageIcon(images[5]));
		}

		// 정사각형
		for (int i = 0; i < woodSquare.length; i++) {
			woodSquare[i] = new TreeBlock(new ImageIcon(images[4]));
		}

		// 가로 사각형
		for (int i = 0; i < woodBlock.length; i++) {
			woodBlock[i] = new TreeBlock(new ImageIcon(images[0]));
		}

		// 세로 사각형
		for (int i = 0; i < longWoodBlock.length; i++) {
			longWoodBlock[i] = new TreeBlock(new ImageIcon(images[1]));
		}

		// 얇은 가로 사각형
		for (int i = 0; i < WoodOblongBlock.length; i++) {
			WoodOblongBlock[i] = new TreeBlock(new ImageIcon(images[3]));
		}

		// 얇은 세로 사각형
		for (int i = 0; i < longWoodOblongBlock.length; i++) {
			longWoodOblongBlock[i] = new TreeBlock(new ImageIcon(images[2]));
		}

//------------------------------------------------------------------------------------------------
		// 지붕
		for (int i = 0; i < roofBlock.length; i++) {
			roofBlock[i].setSize(roofBlockWidth, roofBlockHeight);
			roofBlock[i].setLocation(625, 65);
			backgroundImageLabel.add(roofBlock[i]);
		}

//      정사각형-----------------------------------------------------------
		for (int i = 0; i < 20; i++) { // 맨앞 정사각형
			woodSquare[i].setSize(WOODSQUARE_WIDTH, WOODSQUARE_HEIGHT);
			woodSquare[i].setLocation(500, 450 - (i * 20));
			backgroundImageLabel.add(woodSquare[i]);
		}

		for (int i = 20; i < 40; i++) { // 맨앞 정사각형
			woodSquare[i].setSize(WOODSQUARE_WIDTH, WOODSQUARE_HEIGHT);
			woodSquare[i].setLocation(525, 850 - (i * 20));
			backgroundImageLabel.add(woodSquare[i]);
		}

		// 가로 사각형--------------------------------------------------------
		for (int i = 0; i < 7; i++) { // 1. 바닥
			woodBlock[i].setSize(WOODBLOCK_WIDTH, WOODBLOCK_HEIGHT);
			woodBlock[i].setLocation(600 + (i * 50), 450);
			backgroundImageLabel.add(woodBlock[i]);
		}
		for (int i = 7; i < 14; i++) { // 3. 바닥 위 바닥
			woodBlock[i].setSize(WOODBLOCK_WIDTH, WOODBLOCK_HEIGHT);
			woodBlock[i].setLocation(250 + (i * 50), 330);
			backgroundImageLabel.add(woodBlock[i]);
		}

		// 세로 사각형--------------------------------------------------------
		for (int i = 0; i < 2; i++) { // 4. 바닥 위 바닥 모양 (1)
			longWoodBlock[i].setSize(WOODBLOCK_L_WIDTH, WOODBLOCK_L_HEIGHT);
			longWoodBlock[i].setLocation(660 + (i * 200), 290);
			backgroundImageLabel.add(longWoodBlock[i]);
		}

		for (int i = 2; i < 4; i++) { // 4. 바닥 위 바닥 모양 (2)
			longWoodBlock[i].setSize(WOODBLOCK_L_WIDTH, WOODBLOCK_L_HEIGHT);
			longWoodBlock[i].setLocation(260 + (i * 200), 240);
			backgroundImageLabel.add(longWoodBlock[i]);
		}

		// 얇은 세로 사각형----------------------------------------------------
		for (int i = 0; i < 5; i++) { // 2. 바닥 위
			longWoodOblongBlock[i].setSize(OBLONGWOODBLOCK_L_WIDTH, OBLONGWOODBLOCK_L_HEIGHT);
			longWoodOblongBlock[i].setLocation(650 + (i * 60), 370);
			backgroundImageLabel.add(longWoodOblongBlock[i]);
		}

		// 얇은 가로 사각형----------------------------------------------------
		for (int i = 0; i < 2; i++) { // 2. 바닥 위
			WoodOblongBlock[i].setSize(OBLONGWOODBLOCK_WIDTH, OBLONGWOODBLOCK_HEIGHT);
			WoodOblongBlock[i].setLocation(725, 310 + (i * 15));
			backgroundImageLabel.add(WoodOblongBlock[i]);
		}
		crush();
		allBlockArrayCrush();

	}

	public void crush() {
		new Thread(() -> {
			while (true) {
				for (int i = 0; i < player.length; i++) {
					for (int j = 0; j < woodSquare.length; j++) {
						if (Math.abs(woodSquare[j].getX() - player[i].getX()) < 100
								&& Math.abs(woodSquare[j].getY() - player[i].getY()) < 100) {
							try {
								woodSquare[j].setIcon(bomb);
								Thread.sleep(50);
								woodSquare[j].setVisible(false);

								mContext.score += 500;
								mContext.scoreLabel.setText("SCORE : " + mContext.score);
								woodSquare[j].setLocation(0, 0);
								woodSquare[j].removeAll();

								mContext.score += 500;

								mContext.scoreLabel.setText("SCORE : " + mContext.getScore());
								woodSquare[j].setLocation(0, 0);
								woodSquare[j].removeAll();
								repaint();

							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

					}
				}

			}
		}).start();
	}

	public void allBlockArrayCrush() {
		new Thread(() -> {
			while (true) {
				for (int i = 0; i < player.length; i++) {
					for (int j = 0; j < longWoodBlock.length; j++) {
						if (Math.abs(longWoodBlock[j].getX() - player[i].getX()) < 50
								&& Math.abs(longWoodBlock[j].getY() - player[i].getY()) < 50) {
							allBomb();

							if (Math.abs(realBomb.getX() - player[i].getX()) < 50
									&& Math.abs(realBomb.getY() - player[i].getY()) < 50) {
								realBomb.setVisible(false);
								allBomb();
								move();
								realBomb.setVisible(false);
								try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
						}

					}
				}
			}
		}).start();

	}

	public void allBomb() {
		new Thread(() -> {
			for (int i = 0; i < woodBlock.length; i++) {
				try {
					woodBlock[i].setIcon(bomb);
					Thread.sleep(90);
					woodBlock[i].setVisible(false);
					woodBlock[i].setLocation(0, 0);
					woodBlock[i].removeAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < longWoodOblongBlock.length; i++) {

				try {
					longWoodOblongBlock[i].setIcon(bomb);
					Thread.sleep(90);
					longWoodOblongBlock[i].setVisible(false);
					longWoodOblongBlock[i].setLocation(0, 0);
					longWoodOblongBlock[i].removeAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			for (int i = 0; i < WoodOblongBlock.length; i++) {
				try {
					WoodOblongBlock[i].setIcon(bomb);
					Thread.sleep(90);
					WoodOblongBlock[i].setVisible(false);
					WoodOblongBlock[i].setLocation(0, 0);
					WoodOblongBlock[i].removeAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < longWoodBlock.length; i++) {
				try {

					longWoodBlock[i].setIcon(bomb);
					Thread.sleep(90);
					longWoodBlock[i].setVisible(false);
					longWoodBlock[i].setLocation(0, 0);
					longWoodBlock[i].removeAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

			for (int i = 0; i < roofBlock.length; i++) {
				try {
					roofBlock[i].setIcon(bomb);
					Thread.sleep(90);
					roofBlock[i].setVisible(false);
					mContext.scoreLabel.setText("SCORE : " + (mContext.score + 100));
					roofBlock[i].setLocation(0, 0);
					roofBlock[i].removeAll();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}).start();

	}

	public void move() {

		try {
			Thread.sleep(1950);
			for (int j = 0; j < 178; j++) {
				shieldPig.setLocation(750, 245 + j);
				repaint();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void endStage() {
		new Thread(() -> {
			while (enemyOutState == 0) {
				for (int i = 0; i < player.length; i++) {

					if (Math.abs(shieldPig.getX() - player[i].getX()) < 40
							&& Math.abs(shieldPig.getY() - player[i].getY()) < 40) {

						if (Math.abs(shieldPig.getX() - player[i].getX()) < 50
								&& Math.abs(shieldPig.getY() - player[i].getY()) < 50) {

							JLabel enemyOut = new JLabel(new ImageIcon("images/bang.png"));
							enemyOut.setSize(60, 60);
							enemyOut.setLocation(shieldPig.getX(), shieldPig.getY());
							backgroundImageLabel.add(enemyOut);
							shieldPig.setVisible(false);
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							enemyOut.setVisible(false);
							enemyOutState++;

						}
					}
				}
				if (enemyOutState == 1) {

					JLabel clear = new JLabel(new ImageIcon("images/clear.png"));
					clear.setSize(clearWidth, clearHeight);
					clear.setLocation(0, 0);
					backgroundImageLabel.add(clear);

					nextStage();
				}
			}

		}).start();

	}

	public void nextStage() {

		JLabel clear = new JLabel(new ImageIcon("images/clear.png"));

		backgroundImageLabel.setVisible(false);

		clear.setSize(clearWidth, clearHeight);
		clear.setSize(FRAME_W, FRAME_H);
		clear.setLocation(0, 0);
		add(clear);
		mContext.scoreTotal.setSize(420, 570);
		scoreTotal.setLocation(350, 100);
		scoreTotal.setText(scoreAll + score);
		clear.add(mContext.scoreTotal);
		repaint();

		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		new IceMapFrame("images/bg2.png");
		setVisible(false);
		bgh.stop();
	}
}
