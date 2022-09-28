package component.player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;
import teamProject.interfaces.Moveable;


public class Player extends JLabel {


	// 위치 상태
	private int playerX;
	private int playerY;
	
	private ImageIcon imageicon;
	
	// 움직임 상태
	private boolean move;

	// 상태 : 0 red / 1 black 2 yellow
	private int state;

//	private JLabel[] player = new JLabel[3];
//	private JLabel[] blackBang = new JLabel[3];

	public Player(ImageIcon imageicon,int playerX, int playerY, int state) {
		this.imageicon = imageicon;
		this.playerX = playerX;
		this.playerY = playerY;
		this.state = state;
		initDate();
	}

	private void initDate() {
		move = false;
		state = 0;
		setIcon(imageicon);
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	

}