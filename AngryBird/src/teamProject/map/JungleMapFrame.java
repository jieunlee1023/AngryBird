package teamProject.map;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import component.Enemy;
import component.TreeBlock;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JungleMapFrame extends Background {

	String[] images = { "images/woodBlock_downRec.png", "images/woodBlock_upRec.png", "images/woodBlock_thinUpRec.png",
			"images/woodBlock_thinDownRec.png", "images/woodBlock_square.png", "images/wood_roop.png" };

	private TreeBlock[] woodSquare = new TreeBlock[40];
	private TreeBlock[] woodBlock = new TreeBlock[14];
	private TreeBlock[] longWoodBlock = new TreeBlock[5];
	private TreeBlock[] WoodOblongBlock = new TreeBlock[5];
	private TreeBlock[] longWoodOblongBlock = new TreeBlock[5];
	private TreeBlock[] roofBlock = new TreeBlock[1];
	

	
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

	TreeBlock treeBlock;

	private ImageIcon pig;
	private ImageIcon bomb;

	Enemy enemy;

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public JungleMapFrame(String fileName) {
		super(fileName);
		initData();

	}

	private void initData() {
		setTitle("jungle Maps");
		// pig
		enemy = new Enemy(new ImageIcon("images/pig.png"));
		backgroundImageLabel.add(enemy);
		enemy.setSize(100, 100);
		enemy.setLocation(750, 235);

		// 터지는 모션
		bomb = new ImageIcon("images/bumb1.png");
		
		//roof
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
			roofBlock[i].setSize(300, 180);
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
								
								// =0  --> 500
								mContext.score += 500;
								mContext.scoreLabel.setText("SCORE : " + mContext.score);
								woodSquare[j].setLocation(0 ,0);
								woodSquare[j].removeAll();
								
								repaint();
								//mContext.scoreLabel.repaint();

							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
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
					Thread.sleep(30);
					woodBlock[i].setVisible(false);
//					mContext.score += 7;
//					mContext.scoreLabel.setText("SCORE : " + (mContext.score += 10 ));
					woodBlock[i].setLocation(0 ,0);
					woodBlock[i].removeAll();
//					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < longWoodOblongBlock.length; i++) {
					
				try {
					longWoodOblongBlock[i].setIcon(bomb);
					Thread.sleep(30);
					longWoodOblongBlock[i].setVisible(false);
//					mContext.scoreLabel.setText("SCORE : " + mContext.score);
					longWoodOblongBlock[i].setLocation(0 ,0);
					longWoodOblongBlock[i].removeAll();
//					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			for (int i = 0; i < WoodOblongBlock.length; i++) {
				try {
					WoodOblongBlock[i].setIcon(bomb);
					Thread.sleep(30);
					WoodOblongBlock[i].setVisible(false);
//					mContext.score += 5;
//					mContext.scoreLabel.setText("SCORE : " + (mContext.score + 500));
					WoodOblongBlock[i].setLocation(0 ,0);
					WoodOblongBlock[i].removeAll();
//					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for (int i = 0; i < longWoodBlock.length; i++) {
				try {
					longWoodBlock[i].setIcon(bomb);
					Thread.sleep(30);
					longWoodBlock[i].setVisible(false);
//					mContext.score += 2;
//					mContext.scoreLabel.setText("SCORE : " + (mContext.score + 200));
					longWoodBlock[i].setLocation(0 ,0);
					longWoodBlock[i].removeAll();
//					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				move();
				
			}
			
			for (int i = 0; i < roofBlock.length; i++) {
				try {
					roofBlock[i].setIcon(bomb);
					Thread.sleep(30);
					roofBlock[i].setVisible(false);
//					mContext.score += 10_000;
//					mContext.scoreLabel.setText("SCORE : " + (mContext.score + 1000));
					roofBlock[i].setLocation(0 ,0);
					roofBlock[i].removeAll();
//					repaint();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

		}).start();

	}
//	/// 내일
//	public void move() {
//		new Thread(() -> {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			for(int j = 0; j < 185; j++) {
//				enemy.setLocation(750, 245 + j);
//				repaint();
//			}
////			enemy.setLocation(750, 420);			 // 235 -> 420		= 185
//		}).start();
//	}
	
	
}
