package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.IceBlock;
import teamProject.frame.MainFrame;

public class IceMap extends Background {

	String[] images = { "images/ice_block_square.png", "images/ice_block_width_rectangle.png",
			"images/ice_block_height_rectangle.png", "images/ice_block_width_long.png",
			"images/ice_block_height_long.png" };
	private IceBlock[] squareBlocks = new IceBlock[15];
	private IceBlock[] heightLongBottom = new IceBlock[3];
	private IceBlock[] widthLongBottom = new IceBlock[2];
	private IceBlock[] heightLongCenter = new IceBlock[3];
	private IceBlock[] widthLongCenter = new IceBlock[2];
	private IceBlock[] widthRectangleCenter = new IceBlock[3];
	private IceBlock[] heightLongTop = new IceBlock[2];
	private IceBlock[] widthLongTop = new IceBlock[1];

	MainFrame mContext;

	private JLabel iceMap;
	private JLabel holder;

	private Enemy enemyBottom;
	private Enemy enemyCenter;
	private Enemy enemyTop;

	final int SQUARE_BLOCKS_W = 50;
	final int SQUARE_BLOCKS_H = 50;

	public IceMap() {
		initData();
		setInitLayout();
	}

	public IceMap(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Ice Map");
		setSize(1000, 570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		iceMap = new JLabel(new ImageIcon("images/bg2.png"));
		holder = new JLabel(new ImageIcon("images/img.png"));

		for (int i = 0; i < squareBlocks.length; i++) {
			squareBlocks[i] = new IceBlock(new ImageIcon(images[0]));
		}
		for (int i = 0; i < 3; i++) {
			heightLongBottom[i] = new IceBlock(new ImageIcon(images[4]));
		}
		for (int i = 0; i < 2; i++) {
			widthLongBottom[i] = new IceBlock(new ImageIcon(images[3]));
		}
		for (int i = 0; i < 3; i++) {
			heightLongCenter[i] = new IceBlock(new ImageIcon(images[4]));
		}
		for (int i = 0; i < 2; i++) {
			widthLongCenter[i] = new IceBlock(new ImageIcon(images[3]));
		}
		for (int i = 0; i < 3; i++) {
			widthRectangleCenter[i] = new IceBlock(new ImageIcon(images[1]));
		}
		for (int i = 0; i < 2; i++) {
			heightLongTop[i] = new IceBlock(new ImageIcon(images[4]));
		}
		widthLongTop[0] = new IceBlock(new ImageIcon(images[3]));

		enemyBottom = new Enemy(new ImageIcon("images/pig.png"));
		enemyCenter = new Enemy(new ImageIcon("images/pig.png"));
		enemyTop = new Enemy(new ImageIcon("images/pig.png"));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		for (int i = 0; i < squareBlocks.length; i++) {
			squareBlocks[i].setSize(SQUARE_BLOCKS_W, SQUARE_BLOCKS_H);
			squareBlocks[i].setLocation(650, (i * SQUARE_BLOCKS_W / 2) + 110);
			add(squareBlocks[i]);
		}
		for (int i = 0; i < 3; i++) {
			heightLongBottom[i].setSize(15, 100);
			heightLongBottom[i].setLocation(720 + (i * 100), +400);
			add(heightLongBottom[i]);
		}
		for (int i = 0; i < 2; i++) {
			widthLongBottom[i].setSize(100, 15);
			widthLongBottom[i].setLocation(730 + (i * 100), +385);
			add(widthLongBottom[i]);
		}
		for (int i = 0; i < 3; i++) {
			heightLongCenter[i].setSize(15, 100);
			heightLongCenter[i].setLocation(720 + (i * 100), +290);
			add(heightLongCenter[i]);
		}
		for (int i = 0; i < 2; i++) {
			widthLongCenter[i].setSize(100, 15);
			widthLongCenter[i].setLocation(730 + (i * 100), +275);
			add(widthLongCenter[i]);
		}
		for (int i = 0; i < 3; i++) {
			widthRectangleCenter[i].setSize(60, 30);
			widthRectangleCenter[i].setLocation(740 + (i * 60), +250);
			add(widthRectangleCenter[i]);
		}
		for (int i = 0; i < 2; i++) {
			heightLongTop[i].setSize(15, 100);
			heightLongTop[i].setLocation(770 + (i * 100), +150);
			add(heightLongTop[i]);
		}

		widthLongTop[0].setSize(100, 15);
		widthLongTop[0].setLocation(780, 135);
		add(widthLongTop[0]);

		enemyBottom.setSize(60, 60);
		enemyBottom.setLocation(850, 430);
		add(enemyBottom);

		enemyCenter.setSize(60, 60);
		enemyCenter.setLocation(740, 320);
		add(enemyCenter);

		enemyTop.setSize(60, 60);
		enemyTop.setLocation(800, 170);
		add(enemyTop);

		holder.setSize(60, 150);
		holder.setLocation(80, 340);
		add(holder);

		iceMap.setSize(1000, 570);
		iceMap.setLocation(0, 0);
		add(iceMap);

	}

	public static void main(String[] args) {
		new IceMap();
	}
}