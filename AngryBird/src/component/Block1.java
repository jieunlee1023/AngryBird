package component;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class Block1 extends JLabel {

	private MainFrame mContext;

	// 이미지
//	private JLabel blockBomb;
	private ImageIcon blockBomb;
	// 위치
	private int blockX;
	private int blockY;

	// 적군이 부딪힌 상태
	private int state; // 0(안부딪힘) , 1, (부딪힘)

	JLabel[] squareBlockArray = new JLabel[15];
	JLabel[] shortWidthBlockArray = new JLabel[3];
	JLabel[] longWidthTopBlockArray = new JLabel[1];
	JLabel[] longHeightCenterBlockArray = new JLabel[2];
	JLabel[] longWidthBlockArray = new JLabel[2];
	JLabel[] longHeightBottomBlockArray = new JLabel[3];

	public Block1(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {
		setVisible(true);
		this.setSize(1000, 570);

		for (int i = 0; i < squareBlockArray.length; i++) {
			squareBlockArray[i] = new JLabel(new ImageIcon("images/ice_block1.png"));
		}
		for (int i = 0; i < shortWidthBlockArray.length; i++) {
			shortWidthBlockArray[i] = new JLabel(new ImageIcon("images/ice_block2.png"));
		}
		for (int i = 0; i < longWidthTopBlockArray.length; i++) {
			longWidthTopBlockArray[i] = new JLabel(new ImageIcon("images/ice_block4.png"));
		}
		for (int i = 0; i < longHeightCenterBlockArray.length; i++) {
			longHeightCenterBlockArray[i] = new JLabel(new ImageIcon("images/ice_block5.png"));
		}
		for (int i = 0; i < longWidthBlockArray.length; i++) {
			longWidthBlockArray[i] = new JLabel(new ImageIcon("images/ice_block4.png"));
		}
		for (int i = 0; i < longHeightBottomBlockArray.length; i++) {
			longHeightBottomBlockArray[i] = new JLabel(new ImageIcon("images/ice_block5.png"));
		}

//		blockBomb = new JLabel(new ImageIcon("images/bumb1.png"));
		blockBomb = new ImageIcon("images/icebreak.png");

		blockX = 700;
		blockY = 400;

		state = 0;

	}

	private void setInitLayout() {

		setLayout(null);

		for (int i = 1; i < squareBlockArray.length; i++) {
			add(squareBlockArray[i]);
			squareBlockArray[i].setLocation(blockX - 100, (blockY - 350) + i * 30);
			squareBlockArray[i].setSize(25, 25);
		}

		add(shortWidthBlockArray[0]);
		shortWidthBlockArray[0].setLocation(blockX + 75, blockY - 190);
		shortWidthBlockArray[0].setSize(60, 30);
		for (int i = 1; i < shortWidthBlockArray.length; i++) {
			add(shortWidthBlockArray[i]);
			shortWidthBlockArray[i].setLocation((blockX - 30) + i * 70, blockY - 160);
			shortWidthBlockArray[i].setSize(60, 30);
		}

		for (int i = 0; i < longWidthTopBlockArray.length; i++) {
			add(longWidthTopBlockArray[i]);
			longWidthTopBlockArray[i].setLocation((blockX + 60) + i * 100, blockY - 130);
			longWidthTopBlockArray[i].setSize(100, 15);
		}

		for (int i = 0; i < longHeightCenterBlockArray.length; i++) {
			add(longHeightCenterBlockArray[i]);
			longHeightCenterBlockArray[i].setLocation((blockX + 50) + i * 100, blockY - 115);
			longHeightCenterBlockArray[i].setSize(15, 100);
		}

		for (int i = 0; i < longWidthBlockArray.length; i++) {
			add(longWidthBlockArray[i]);
			longWidthBlockArray[i].setLocation((blockX + 10) + i * 100, blockY - 15);
			longWidthBlockArray[i].setSize(100, 15);
		}
		for (int i = 0; i < longHeightBottomBlockArray.length; i++) {
			add(longHeightBottomBlockArray[i]);
			longHeightBottomBlockArray[i].setLocation(blockX + i * 100, blockY);
			longHeightBottomBlockArray[i].setSize(15, 100);
		}

	}

	public void squareBlockArrayCrash() {

//		new Thread(() -> {
//			boolean isCrash = false;
//
//			for (int i = 0; i < squareBlockArray.length; i++) {
//				if ((Math.abs(mContext.getPlayer().getX() - squareBlockArray[i].getX()) < 20)
//						&& (Math.abs(mContext.getPlayer().getY()) - squareBlockArray[i].getY()) < 20) {
//					isCrash = true;
//				}
//			}
//
//			for (int i = 0; i < squareBlockArray.length; i++) {
//				if (mContext.getPlayer().getY() <= 190) { // 위쪽
//					squareBlockArray[i].setIcon(blockBomb);
//					squareBlockArray[i].setSize(25, 25);
//					squareBlockArray[i].setVisible(false);
//				} else if (mContext.getPlayer().getY() > 190 && mContext.getPlayer().getY() <= 380) { // 가운데
//					squareBlockArray[i].setIcon(blockBomb);
//					squareBlockArray[i].setSize(25, 25);
//					squareBlockArray[i].setVisible(false);
//				} else if (mContext.getPlayer().getY() > 380) {// 아래
//					squareBlockArray[squareBlockArray.length - i].setIcon(blockBomb);
//					squareBlockArray[squareBlockArray.length - i].setSize(25, 25);
//
//					squareBlockArray[i].setVisible(false);
//
//				}
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//
//		}).start();
	}

}