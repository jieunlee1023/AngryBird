package component.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import teamProject.map.Background;
import teamProject.map.IceMapFrame;

public class Player extends JLabel {

	// 위치 상태
	private int playerX;
	private int playerY;

	private ImageIcon imageicon;
	private Background mContext;

	// 움직임 상태
	public boolean isMove = true;

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

	// 상태 : 0 red / 1 black 2 yellow

	private JLabel[] yellowSkill = new JLabel[2];
	private JLabel[] blackSkill = new JLabel[3];

	public Player(ImageIcon imageicon, int playerX, int playerY, Background mContext) {
		this.mContext = mContext;
		this.imageicon = imageicon;
		this.playerX = playerX;
		this.playerY = playerY;

		initDate();
	}

	private void initDate() {

		setIcon(imageicon);

		blackSkill[0] = new JLabel(new ImageIcon("images/bang1.png"));
		blackSkill[1] = new JLabel(new ImageIcon("images/bang2.png"));
		blackSkill[2] = new JLabel(new ImageIcon("images/bang3.png"));
		yellowSkill[0] = new JLabel(new ImageIcon("images/yellowbird.png"));
		yellowSkill[1] = new JLabel(new ImageIcon("images/yellowbird.png"));

		blackSkill[0].setSize(50, 50);
		blackSkill[1].setSize(75, 70);
		blackSkill[2].setSize(115, 100);
		yellowSkill[0].setSize(60, 60);
		yellowSkill[1].setSize(60, 60);

		blackSkill[0].setLocation(playerX, playerY - 30);
		blackSkill[1].setLocation(playerX + 30, playerY - 70);
		blackSkill[2].setLocation(playerX - 40, playerY - 100);

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

				System.out.println();
				// 기울기
				double slope = (b / a);

				// 무브 세분화
				// 1 수평 내려오는거 없음
				if (slope > 0 && slope < 1) {

					fly(0, c, true, 2, 0);
					fly(0, c, true, 2, 0);
					// 15도 완만
				} else if (slope > -0.5 && slope <= 0) {

					fly(0, c, true, 3, 1);
					fly(0, c, false, 3, 1);
					// 30도
				} else if (slope > -1 && slope <= -0.5) {

					fly(0, c, true, 2, 1);
					fly(0, c, false, 2, 1);

					// 60 도
				} else if (slope > -1.5 && slope <= -1) {
					fly(0, c, true, 1, 2);
					fly(0, c, false, 1, 2);

					// 매우 가파름 80도 언저리
				} else if (slope < -1.5) {
					fly(0, c, true, 1, 3);
					fly(0, c, false, 1, 3);

					// 수직
				} else if (slope > 1) {

					fly(0, c, true, 0, 2);
					fly(0, c, false, 0, 2);
				}

				// 상태값 변경
				mContext.setBirdState(0);
				if (mContext.getBirdType() == 0) {
					mContext.setBirdType(1);
				} else if (mContext.getBirdType() == 1) {
					mContext.setBirdType(2);
				} else if (mContext.getBirdType() == 2) {
					mContext.setBirdType(2);
				}
			}
		}).start();

	}

	public void yellowSkill() {

		if (mContext.getBirdType() == 2 && mContext.player[2].getX() >= 400) {

			mContext.backgroundImageLabel.add(yellowSkill[0]);
			mContext.backgroundImageLabel.add(yellowSkill[1]);

		}

	}

	public void blackSkill() {

		if (mContext.getBirdType() == 1 && isMove == false) {
			for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mContext.backgroundImageLabel.add(blackSkill[i]);

			}
		}
	}

	public void redSkill() {
		if (mContext.getBirdType() == 0) {

		}
	}

	// 포물선 메서드를 통해 간소화
	private void fly(int start, int end, boolean type, int moveX, int moveY) {
		int playerX = mContext.player[mContext.getBirdType()].getX();
		int playerY = mContext.player[mContext.getBirdType()].getY();

		for (int j = start; j < end; j++) {

			if (type) {
				playerX += moveX;
				playerY -= moveY;
				mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				playerX += moveX;
				playerY += moveY;
				mContext.player[mContext.getBirdType()].setLocation(playerX, playerY);
				yellowSkill[0].setLocation(playerX + 50, playerY + 50);
				yellowSkill[1].setLocation(playerX + 100, playerY - 100);
				yellowSkill();

				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (isMove == false) {

					break;
				}
			}

		}
	}

}
