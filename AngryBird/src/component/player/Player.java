package component.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;
import teamProject.interfaces.Moveable;

@Getter
public class Player extends JLabel implements Moveable {

	MainFrame mContext;

	// 위치 상태
	private int playerX;
	private int playerY;

	// 움직임 상태
	private boolean move;

	// 상태 : 0 red / 1 black 2 yellow
	private int state;

	private ImageIcon bang;
	private JLabel[] player = new JLabel[3];
	private JLabel[] blackBang = new JLabel[3];

	public Player(MainFrame mContext) {
		this.mContext = mContext;
		initDate();
		setInitLayout();
	}

	private void initDate() {
		move = false;
		state = 0;

		player[0] = new JLabel(new ImageIcon("images/redBird.png"));
		player[1] = new JLabel(new ImageIcon("images/blackBird.png"));
		player[2] = new JLabel(new ImageIcon("images/yellowBird.png"));

		bang = new ImageIcon("images/bang.png");
		blackBang[0] = new JLabel(new ImageIcon("images/bang1.png"));
		blackBang[1] = new JLabel(new ImageIcon("images/bang2.png"));
		blackBang[2] = new JLabel(new ImageIcon("images/bang3.png"));

		playerX = player[state].getX();
		playerY = player[state].getY();

	}

	private void setInitLayout() {
		for (int i = 0; i < player.length; i++) {
			player[i].setSize(80, 65);
		}
		player[0].setLocation(140, 440);
		player[1].setLocation(100, 440);
		player[2].setLocation(60, 440);

//		blackBang[0].setSize(50, 50);
//		blackBang[1].setSize(75, 70);
//		blackBang[2].setSize(115, 100);

//		blackBang[0].setLocation(playerX, playerY - 30));
//		blackBang[1].setLocation(playerX + 30, playerY - 70);
//		blackBang[2].setLocation(playerX - 40, playerY - 100);
	}

	public void move() {
	}

	public void skill() {
		if (state == 1) {

		} else if (state == 2) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			setIcon(bang);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			add(blackBang[0]);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			add(blackBang[1]);
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			add(blackBang[2]);

		} else if (state == 3) {

		}
	}

}