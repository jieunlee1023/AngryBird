package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class Block2 extends JLabel {

	private MainFrame mContext;

	// 블럭들의 위치상태
	private int blockX;
	private int blockY;

	// 적군이 부딪힌 상태
	private int state; // 0(안부딪힘) , 1, (부딪힘)

	// 블럭이 여러개 필요하므로 배열로 생성
	JLabel[] squareRightBlockArray = new JLabel[10];
	JLabel[] squareLeftBlockArray = new JLabel[10];

	JLabel[] longWidthBlockArray = new JLabel[2];
	JLabel[] squareCenterBlockArray = new JLabel[2];
	JLabel[] longHeightBlockArray = new JLabel[2];
	JLabel[] shortWidthBlockArray = new JLabel[4];

//	JLabel[] blockArray = new JLabel[25];

	private ImageIcon blockBomb;

	public Block2(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	// 초기 데이터
	private void initData() {
		setVisible(true);
		setSize(1000, 570);

		for (int i = 0; i < squareRightBlockArray.length; i++) {
			squareRightBlockArray[i] = new JLabel(new ImageIcon("images/tree_block1.png"));
		}
		for (int i = 0; i < squareLeftBlockArray.length; i++) {
			squareLeftBlockArray[i] = new JLabel(new ImageIcon("images/tree_block1.png"));
		}
		for (int i = 0; i < longWidthBlockArray.length; i++) {
			longWidthBlockArray[i] = new JLabel(new ImageIcon("images/tree_block4.png"));
		}
		for (int i = 0; i < squareCenterBlockArray.length; i++) {
			squareCenterBlockArray[i] = new JLabel(new ImageIcon("images/tree_block1.png"));
		}
		for (int i = 0; i < longHeightBlockArray.length; i++) {
			longHeightBlockArray[i] = new JLabel(new ImageIcon("images/tree_block5.png"));
		}
		for (int i = 0; i < shortWidthBlockArray.length; i++) {
			shortWidthBlockArray[i] = new JLabel(new ImageIcon("images/tree_block2.png"));
		}

		blockBomb = new ImageIcon("images/bumb2.png");
		blockX = 650;
		blockY = 400;

		state = 0;

	}

	private void setInitLayout() {

		setLayout(null);

		for (int i = 0; i < squareRightBlockArray.length; i++) {
			add(squareRightBlockArray[i]);
			squareRightBlockArray[i].setLocation(blockX - 30, (blockY + 65) - i * 25);
			squareRightBlockArray[i].setSize(25, 25);
		}
		for (int i = 0; i < squareLeftBlockArray.length; i++) {
			add(squareLeftBlockArray[i]);
			squareLeftBlockArray[i].setLocation(blockX + 280, (blockY + 65) - i * 25);
			squareLeftBlockArray[i].setSize(25, 25);
		}
		for (int i = 0; i < longWidthBlockArray.length; i++) {
			add(longWidthBlockArray[i]);
			longWidthBlockArray[i].setLocation(blockX + 35 + i * 100, blockY - 80);
			longWidthBlockArray[i].setSize(100, 15);
		}
		for (int i = 0; i < squareCenterBlockArray.length; i++) {
			add(squareCenterBlockArray[i]);
			squareCenterBlockArray[i].setLocation(blockX + 25 + i * 200, blockY - 65);
			squareCenterBlockArray[i].setSize(25, 25);
		}
		for (int i = 0; i < longHeightBlockArray.length; i++) {
			add(longHeightBlockArray[i]);
			longHeightBlockArray[i].setLocation(blockX + 30 + i * 200, blockY - 40);
			longHeightBlockArray[i].setSize(15, 100);
		}
		for (int i = 0; i < shortWidthBlockArray.length; i++) {
			add(shortWidthBlockArray[i]);
			shortWidthBlockArray[i].setLocation(blockX + i * 60, blockY + 50);
			shortWidthBlockArray[i].setSize(100, 50);
		}

	}

	public void clearBlock() {
		if (mContext.getPlayer().getState() == 1 && this.state == 1) {

			try {
				Thread.sleep(100);
				for (int i = 0; i < longWidthBlockArray.length; i++) {
					longWidthBlockArray[i].setIcon(blockBomb);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(100);
				for (int i = 0; i < squareCenterBlockArray.length; i++) {
					squareCenterBlockArray[i].setIcon(blockBomb);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(100);
				for (int i = 0; i < longHeightBlockArray.length; i++) {
					longHeightBlockArray[i].setIcon(blockBomb);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				Thread.sleep(100);
				for (int i = 0; i < shortWidthBlockArray.length; i++) {
					shortWidthBlockArray[i].setIcon(blockBomb);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}