package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import component.player.Player;

public class Enemy extends JLabel {

	private ImageIcon pig;
	private ImageIcon savedPig;
	Player player;

	public ImageIcon getPig() {
		return pig;
	}

	public void setPig(ImageIcon pig) {
		this.pig = pig;
	}

	public ImageIcon getSavedPig() {
		return savedPig;
	}

	public void setSavedPig(ImageIcon savedPig) {
		this.savedPig = savedPig;
	}

	public Enemy(ImageIcon pig) {
		this.pig = pig;
		initData();
		setInitLayout();
	}

	// 초기 데이터
	private void initData() {
		setVisible(true);
		
	}

	private void setInitLayout() {
		setIcon(pig);
	}

	public void saveEnemy() {
		boolean isTouchedX = Math.abs(this.getX() - player.getX()) < 100;
		boolean isTouchedY = Math.abs(this.getY() - player.getY()) < 100;

		if (isTouchedX && isTouchedY == true) {
			try {
				System.out.println("게임 끝");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setIcon(savedPig);
			// 게임 클리어
		}

	}

}