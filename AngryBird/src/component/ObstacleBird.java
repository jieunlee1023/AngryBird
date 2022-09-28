package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import teamProject.frame.MainFrame;

public class ObstacleBird extends JLabel {

	private MainFrame mContext;

	private JLabel[] obstacleBird = new JLabel[2];

	// 위치
	private int obstacleBirdX;
	private int obstacleBirdY;

	// 움직임 상태
	private boolean up;
	private boolean down;

	public ObstacleBird(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		down();
	}

	private void initData() {
		obstacleBird[0] = new JLabel(new ImageIcon("images/pinkBird.png"));
		obstacleBird[1] = new JLabel(new ImageIcon("images/greenBird.png"));
		obstacleBird[2] = new JLabel(new ImageIcon("images/blueBird.png"));

		obstacleBirdX = 500;
		obstacleBirdY = 0;
	}

	private void setInitLayout() {

		for (int i = 0; i < obstacleBird.length; i++) {
			obstacleBird[i].setSize(70, 55);
			obstacleBird[i].setLocation(obstacleBirdX, obstacleBirdY);
		}
	}

	private void down() {
		down = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < mContext.getHeight(); i++) {
					obstacleBirdY++;
					setLocation(obstacleBirdX, obstacleBirdY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
				up();
			}
		}).start();
	}

	private void up() {
		up = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < mContext.getHeight(); i++) {
					obstacleBirdY--;
					setLocation(obstacleBirdX, obstacleBirdY);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				up = false;
				down();
			}
		}).start();
	}

}
