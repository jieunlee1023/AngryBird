package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class Enemy extends JLabel {

	private MainFrame mContext;
	private ImageIcon pig;
	private ImageIcon savedPig;

	// 위치상태
	private int pigX;
	private int pigY;

	public Enemy(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	// 초기 데이터
	private void initData() {
		pig = (new ImageIcon("images/pig.png"));
		savedPig = new ImageIcon("images/bumb1.png");

		pigX = 760;
		pigY = 380;

	}

	private void setInitLayout() {
		setIcon(pig);
		this.setLocation(pigX, pigY);
		this.setSize(80, 80);

	}

//	public void saveEnemy() {
//		boolean isTouchedX = Math.abs(pigX - mContext.getPlayer().getPlayer()[???].getX()) < 100;
//		boolean isTouchedY = Math.abs(pigY - mContext.getPlayer().getPlayer()[???].getY()) < 100;
//
//		if (isTouchedX && isTouchedY == true) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			setIcon(savedPig);
//			// 게임 클리어
//		}
//
//	}

}