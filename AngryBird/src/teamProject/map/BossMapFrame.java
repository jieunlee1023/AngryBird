package teamProject.map;

import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.IceBlock;
import component.StoneBlock;

public class BossMapFrame extends Background {

	/*
	 * tnt 40* 35 c 63 60 h 85 35 h2 160 25 h3 50 26 v 40 80 v2 30 60 t 50 50 head
	 * 51 51
	 * 
	 * boss 100 100
	 * 
	 */
	String[] images = { "images/boss/boss1.png", "images/boss/boss2.png", "images/boss/boss3.png" };

	protected StoneBlock[] verticalBlocks = new StoneBlock[10];
	protected StoneBlock[] horizonBlocks = new StoneBlock[4];
	protected StoneBlock verticalBlock;
	protected StoneBlock verticalBlockTwo;
	protected StoneBlock horizonBlock;
	protected StoneBlock horizonBlockTwo;
	protected StoneBlock longBlock;
	protected StoneBlock triangleBlock;
	protected StoneBlock triangleBlockTwo;
	protected StoneBlock circleBlock;
	protected StoneBlock circleBlockTwo;
	protected StoneBlock headBlock;
	protected StoneBlock headBlockTwo;

	protected JLabel map;

	String fileName;
	private ImageIcon bomb;

	protected Enemy enemy;
	protected Enemy[] enemyBoss = new Enemy[3];

	public int state = 0;

	public BossMapFrame(String fileName) {
		super(fileName);
		initData();
		bossMove();
		crashV();
		enemyCrash(enemy);
		enemyCrash(enemyBoss[0]);
		enemyCrash(enemyBoss[1]);
		enemyCrash(enemyBoss[2]);
	}

	protected void initData() {
		setSize(1000, 570);
		setTitle("boss Map");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		for (int i = 0; i < 10; i++) {
			verticalBlocks[i] = new StoneBlock(new ImageIcon("images/boss/stoneV2.png"));
		}
		for (int i = 0; i < 4; i++) {
			horizonBlocks[i] = new StoneBlock(new ImageIcon("images/boss/stoneH3.png"));
		}
		verticalBlock = new StoneBlock(new ImageIcon("images/boss/stoneV.png"));
		verticalBlockTwo = new StoneBlock(new ImageIcon("images/boss/stoneV.png"));
		horizonBlock = new StoneBlock(new ImageIcon("images/boss/stoneH.png"));
		horizonBlockTwo = new StoneBlock(new ImageIcon("images/boss/stoneH.png"));
		longBlock = new StoneBlock(new ImageIcon("images/boss/stoneH2.png"));
		triangleBlock = new StoneBlock(new ImageIcon("images/boss/stoneT.png"));
		triangleBlockTwo = new StoneBlock(new ImageIcon("images/boss/stoneT2.png"));
		circleBlock = new StoneBlock(new ImageIcon("images/boss/stoneC.png"));
		circleBlockTwo = new StoneBlock(new ImageIcon("images/boss/stoneC.png"));
		headBlock = new StoneBlock(new ImageIcon("images/boss/stoneHead.png"));
		headBlockTwo = new StoneBlock(new ImageIcon("images/boss/stoneHead.png"));

		bomb = new ImageIcon("images/bumb1.png");

		for (int i = 0; i < 3; i++) {
			enemyBoss[i] = new Enemy(new ImageIcon(images[i]));
		}
		enemy = new Enemy(new ImageIcon("images/pig.png"));

		// 적
		enemy.setSize(60, 60);
		enemy.setLocation(690, 440);
		backgroundImageLabel.add(enemy);

		for (int i = 0; i < 3; i++) {
			enemyBoss[i].setSize(100, 100);
			enemyBoss[i].setLocation(800, 400);
		}

		// 큰집
		verticalBlocks[0].setSize(30, 60);
		verticalBlocks[0].setLocation(750, 440);
		backgroundImageLabel.add(verticalBlocks[0]);
		verticalBlocks[1].setSize(30, 60);
		verticalBlocks[1].setLocation(750, 390);
		backgroundImageLabel.add(verticalBlocks[1]);
		verticalBlocks[2].setSize(30, 60);
		verticalBlocks[2].setLocation(900, 440);
		backgroundImageLabel.add(verticalBlocks[2]);
		verticalBlocks[3].setSize(30, 60);
		verticalBlocks[3].setLocation(900, 390);
		backgroundImageLabel.add(verticalBlocks[3]);

		// 큰집 지붕
		longBlock.setSize(160, 25);
		longBlock.setLocation(760, 380);
		backgroundImageLabel.add(longBlock);
		circleBlock.setSize(63, 60);
		circleBlock.setLocation(780, 330);
		backgroundImageLabel.add(circleBlock);
		circleBlockTwo.setSize(63, 60);
		circleBlockTwo.setLocation(840, 330);
		backgroundImageLabel.add(circleBlockTwo);

		// 1층
		verticalBlocks[4].setSize(30, 60);
		verticalBlocks[4].setLocation(600, 440);
		backgroundImageLabel.add(verticalBlocks[4]);
		verticalBlocks[5].setSize(30, 60);
		verticalBlocks[5].setLocation(660, 440);
		backgroundImageLabel.add(verticalBlocks[5]);

		// 2층
		horizonBlocks[0].setSize(50, 25);
		horizonBlocks[0].setLocation(600, 425);
		backgroundImageLabel.add(horizonBlocks[0]);
		horizonBlocks[1].setSize(50, 25);
		horizonBlocks[1].setLocation(640, 425);
		backgroundImageLabel.add(horizonBlocks[1]);
		verticalBlocks[6].setSize(30, 60);
		verticalBlocks[6].setLocation(600, 370);
		backgroundImageLabel.add(verticalBlocks[6]);
		verticalBlocks[7].setSize(30, 60);
		verticalBlocks[7].setLocation(660, 370);
		backgroundImageLabel.add(verticalBlocks[7]);

		// 3
		horizonBlocks[2].setSize(50, 25);
		horizonBlocks[2].setLocation(600, 355);
		backgroundImageLabel.add(horizonBlocks[2]);
		horizonBlocks[3].setSize(50, 25);
		horizonBlocks[3].setLocation(640, 355);
		backgroundImageLabel.add(horizonBlocks[3]);
		verticalBlocks[8].setSize(30, 60);
		verticalBlocks[8].setLocation(600, 300);
		backgroundImageLabel.add(verticalBlocks[8]);
		verticalBlocks[9].setSize(30, 60);
		verticalBlocks[9].setLocation(660, 300);
		backgroundImageLabel.add(verticalBlocks[9]);

		// 작은집지붕
		horizonBlock.setSize(85, 35);
		horizonBlock.setLocation(600, 275);
		backgroundImageLabel.add(horizonBlock);
		triangleBlock.setSize(50, 50);
		triangleBlock.setLocation(600, 240);
		backgroundImageLabel.add(triangleBlock);
		triangleBlockTwo.setSize(50, 50);
		triangleBlockTwo.setLocation(635, 240);
		backgroundImageLabel.add(triangleBlockTwo);

		// 정승
		verticalBlock.setSize(40, 80);
		verticalBlock.setLocation(420, 420);
		backgroundImageLabel.add(verticalBlock);
		verticalBlockTwo.setSize(40, 80);
		verticalBlockTwo.setLocation(500, 420);
		backgroundImageLabel.add(verticalBlockTwo);
		headBlock.setSize(50, 50);
		headBlock.setLocation(410, 375);
		backgroundImageLabel.add(headBlock);
		headBlockTwo.setSize(50, 50);
		headBlockTwo.setLocation(490, 375);
		backgroundImageLabel.add(headBlockTwo);

		// 맵

	}

	public void crush() {
		new Thread(() -> {
			while (true) {
				for (int i = 0; i < player.length; i++) {
					for (int j = 0; j < horizonBlocks.length; j++) {
						if (Math.abs(horizonBlocks[j].getX() - player[i].getX()) < 100
								&& Math.abs(horizonBlocks[j].getY() - player[i].getY()) < 100) {
							try {
								horizonBlocks[j].setIcon(bomb);
								Thread.sleep(50);
								horizonBlocks[j].setVisible(false);

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

	public void crashV() {
		new Thread(() -> {
			while (true) {
				for (int i = 0; i < player.length; i++) {
					for (int j = 0; j < verticalBlocks.length; j++) {
						if (Math.abs(verticalBlocks[j].getX() - player[i].getX()) < 100
								&& Math.abs(verticalBlocks[j].getY() - player[i].getY()) < 100) {
							bomb(verticalBlocks[j]);
						}
					}
					for (int j = 0; j < horizonBlocks.length; j++) {
						if (Math.abs(horizonBlocks[j].getX() - player[i].getX()) < 100
								&& Math.abs(horizonBlocks[j].getY() - player[i].getY()) < 100) {
							bomb(horizonBlocks[j]);
						}
					}
					if (Math.abs(horizonBlock.getX() - player[i].getX()) < 100
							&& Math.abs(horizonBlock.getY() - player[i].getY()) < 100) {
						bomb(horizonBlock);
					}
					if (Math.abs(verticalBlock .getX() - player[i].getX()) < 100
							&& Math.abs(verticalBlock .getY() - player[i].getY()) < 100) {
						bomb(verticalBlock );
					}	
					if (Math.abs(verticalBlockTwo .getX() - player[i].getX()) < 100
							&& Math.abs(verticalBlockTwo .getY() - player[i].getY()) < 100) {
						bomb(verticalBlockTwo );
					}
					if (Math.abs(horizonBlockTwo .getX() - player[i].getX()) < 100
							&& Math.abs(horizonBlockTwo .getY() - player[i].getY()) < 100) {
						bomb(horizonBlockTwo );
					}
					if (Math.abs(longBlock .getX() - player[i].getX()) < 100
							&& Math.abs(longBlock .getY() - player[i].getY()) < 100) {
						bomb(longBlock );
					}
					if (Math.abs(triangleBlock .getX() - player[i].getX()) < 100
							&& Math.abs(triangleBlock .getY() - player[i].getY()) < 100) {
						bomb(triangleBlock );
					}
					if (Math.abs(triangleBlockTwo .getX() - player[i].getX()) < 100
							&& Math.abs(triangleBlockTwo .getY() - player[i].getY()) < 100) {
						bomb(triangleBlockTwo );
					}
					if (Math.abs(circleBlock .getX() - player[i].getX()) < 100
							&& Math.abs(circleBlock .getY() - player[i].getY()) < 100) {
						bomb(circleBlock );
					}
					if (Math.abs(circleBlockTwo .getX() - player[i].getX()) < 100
							&& Math.abs(circleBlockTwo .getY() - player[i].getY()) < 100) {
						bomb(circleBlockTwo );
					}
					if (Math.abs(headBlock .getX() - player[i].getX()) < 100
							&& Math.abs(headBlock .getY() - player[i].getY()) < 100) {
						bomb(headBlock );
					}
					if (Math.abs(headBlockTwo .getX() - player[i].getX()) < 100
							&& Math.abs(headBlockTwo .getY() - player[i].getY()) < 100) {
						bomb(headBlockTwo );
					}
				}

			}
		}).start();
	}

	public void bomb(StoneBlock block) {
		try {
			block.setIcon(bomb);
			Thread.sleep(50);
			block.setVisible(false);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bossMove() {
		new Thread(() -> {
			while (true) {
				if (state == 0) {
					backgroundImageLabel.add(enemyBoss[1]);
					state += 1;
				} else if (state == 1) {
					backgroundImageLabel.add(enemyBoss[2]);
					state += 1;
				} else if (state == 3) {
					backgroundImageLabel.add(enemyBoss[0]);
					state = 0;
				}
				try {
					Thread.sleep(10);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();
	}
	
	public void enemyCrash(Enemy enemy) {

		for (int i = 0; i < player.length; i++) {
			if (Math.abs(enemy.getX() - player[i].getX()) < 50 && Math.abs(enemy.getY() - player[i].getY()) < 50) {
				JLabel enemyOut = new JLabel(new ImageIcon("images/bumd2.png"));
				enemyOut.setSize(60, 60);
				enemyOut.setLocation(enemy.getX(), enemy.getY());
				backgroundImageLabel.add(enemyOut);
				enemy.setVisible(false);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				enemyOut.setVisible(false);
				
			}
		}

	}
	

	public static void main(String[] args) {
		new BossMapFrame("images/boss/bg4.png");
	}

}