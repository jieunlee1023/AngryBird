package component.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;
import teamProject.interfaces.Moveable;
import teamProject.map.Background;
import teamProject.map.MapSelectPage;

public class Player extends JLabel {

	// 위치 상태
	private int playerX;
	private int playerY;

	private ImageIcon imageicon;
	Background mContext;
	// 움직임 상태
	private boolean move;

	// 상태 : 0 red / 1 black 2 yellow

//	private JLabel[] player = new JLabel[3];
//	private JLabel[] blackBang = new JLabel[3];

	public Player(ImageIcon imageicon, int playerX, int playerY, Background mContext) {
		this.mContext = mContext;
		this.imageicon = imageicon;
		this.playerX = playerX;
		this.playerY = playerY;

		initDate();
	}

	private void initDate() {
		move = false;

		setIcon(imageicon);
	}

	public void playerMove() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				// x증가량 y증가량
				double a = mContext.getPressX() - mContext.getReleaseX();
				double b = mContext.getPressY() - mContext.getReleaseY();
				// 빗변
				int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();
				int playerX = mContext.player[mContext.getBirdType()].getX();
				int playerY = mContext.player[mContext.getBirdType()].getY();

				System.out.println();
				// 기울기
				double slope = (b / a);

				// 무브 세분화
				// 1 수평 내려오는거 없음
				if (slope > 0 && slope < 1) {
					for (int i = 0; i < c; i++) {

						playerX += 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerX += 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 15도 완만
				} else if (slope > -0.5 && slope <= 0) {

					for (int i = 0; i < c; i++) {

						playerX += 3;
						playerY -= 1;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerX += 3;
						playerY += 1;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 30도
				} else if (slope > -1 && slope <= -0.5) {
					for (int i = 0; i < c; i++) {

						playerX += 2;
						playerY -= 1;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerX += 2;
						playerY += 1;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					// 60 도
				} else if (slope > -1.5 && slope <= -1) {
					for (int i = 0; i < c; i++) {

						playerX += 1;
						playerY -= 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerX += 1;
						playerY += 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					// 매우 가파름 80도 언저리
				} else if (slope < -1.5) {
					for (int i = 0; i < c; i++) {

						playerX += 1;
						playerY -= 3;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 1;
						playerY += 3;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 수직
				} else if (slope > 1) {

					for (int i = 0; i < c; i++) {

						playerY -= 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerY += 2;
						mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				// 상태값 변경
				if (mContext.getBirdType() == 0) {
					mContext.setBirdType(1);
				} else if (mContext.getBirdType() == 1) {
					mContext.setBirdType(2);
				} else if (mContext.getBirdType() == 2) {

				}

//				mContext.getBlock1().squareBlockArrayCrash();

			}

		}).start();

	}

//		bang = new ImageIcon("images/bang.png");
//		blackBang[0] = new JLabel(new ImageIcon("images/bang1.png"));
//		blackBang[1] = new JLabel(new ImageIcon("images/bang2.png"));
//		blackBang[2] = new JLabel(new ImageIcon("images/bang3.png"));

//	private void setInitLayout() {

//		blackBang[0].setSize(50, 50);
//		blackBang[1].setSize(75, 70);
//		blackBang[2].setSize(115, 100);

//		blackBang[0].setLocation(playerX, playerY - 30));
//		blackBang[1].setLocation(playerX + 30, playerY - 70);
//		blackBang[2].setLocation(playerX - 40, playerY - 100);
//	}

	public void move() {

	}

	public int getPlayerX() {
		return playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

}