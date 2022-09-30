package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Enemy;
import component.HalloweenBlocks;
import component.IceBlock;
import component.StoneBlock;
import teamProject.frame.MainFrame;

public class HolloweenMapFrame extends Background {

	String[] images = { "images/halloween/square.png", "images/halloween/lamp.png", "images/halloween/horizon.png",
			"images/halloween/vertical.png", "images/halloween/stoneH.png", "images/halloween/triangleL.png",
			"images/halloween/triangleR.png", "images/halloween/floor.png", "images/halloween/pumpkin.png",
			"images/halloween/pumpkinBlack.png" };

	protected HalloweenBlocks[] leftSquares = new HalloweenBlocks[8];
	protected HalloweenBlocks[] rightSquares = new HalloweenBlocks[8];
	protected HalloweenBlocks[] lamp = new HalloweenBlocks[2];
	protected HalloweenBlocks[] horizon = new HalloweenBlocks[6];
	protected HalloweenBlocks[] vertical = new HalloweenBlocks[12];
	protected HalloweenBlocks[] stoneH = new HalloweenBlocks[2];
	protected HalloweenBlocks[] triangleL = new HalloweenBlocks[2];
	protected HalloweenBlocks[] triangleR = new HalloweenBlocks[2];
	protected HalloweenBlocks floor;
	protected HalloweenBlocks pumpkin;
	protected HalloweenBlocks pumpkinBlack;

	public HolloweenMapFrame(String fileName) {
		super(fileName);
		initData();
	}

	private void initData() {
		setTitle("holloweenMap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 8; i++) {
			leftSquares[i] = new HalloweenBlocks(new ImageIcon(images[0]));
		}
		for (int i = 0; i < 8; i++) {
			rightSquares[i] = new HalloweenBlocks(new ImageIcon(images[0]));
		}
		for (int i = 0; i < 2; i++) {
			lamp[i] = new HalloweenBlocks(new ImageIcon(images[1]));
		}
		for (int i = 0; i < 12; i++) {
			vertical[i] = new HalloweenBlocks(new ImageIcon(images[3]));
		}
		for (int i = 0; i < 6; i++) {
			horizon[i] = new HalloweenBlocks(new ImageIcon(images[2]));
		}
		for (int i = 0; i < 2; i++) {
			stoneH[i] = new HalloweenBlocks(new ImageIcon(images[4]));
		}
		for (int i = 0; i < 2; i++) {
			triangleL[i] = new HalloweenBlocks(new ImageIcon(images[5]));
		}
		for (int i = 0; i < 2; i++) {
			triangleR[i] = new HalloweenBlocks(new ImageIcon(images[6]));
		}

		floor = new HalloweenBlocks(new ImageIcon(images[7]));
		pumpkin = new HalloweenBlocks(new ImageIcon(images[8]));
		pumpkinBlack = new HalloweenBlocks(new ImageIcon(images[9]));

		for (int i = 0; i < leftSquares.length; i = i + 1) {
			leftSquares[i].setSize(40, 40);
			leftSquares[i].setLocation(500, 180 + i * 40);
			backgroundImageLabel.add(leftSquares[i]);
		}
		for (int i = 0; i < leftSquares.length; i = i + 2) {
			leftSquares[i].setSize(40, 40);
			leftSquares[i].setLocation(520, 180 + i * 40);
			backgroundImageLabel.add(leftSquares[i]);
		}
		for (int i = 0; i < rightSquares.length; i = i + 1) {
			rightSquares[i].setSize(40, 40);
			rightSquares[i].setLocation(900, 180 + i * 40);
			backgroundImageLabel.add(rightSquares[i]);
		}
		for (int i = 0; i < rightSquares.length; i = i + 2) {
			rightSquares[i].setSize(40, 40);
			rightSquares[i].setLocation(920, 180 + i * 40);
			backgroundImageLabel.add(rightSquares[i]);
		}
		for (int i = 0; i < lamp.length; i++) {
			lamp[i].setSize(60, 100);
			lamp[i].setLocation(510 + 400 * i, 85);
			backgroundImageLabel.add(lamp[i]);
		}
		floor.setSize(100, 55);
		floor.setLocation(570, 450);
		backgroundImageLabel.add(floor);

		pumpkin.setSize(55, 50);
		pumpkin.setLocation(570, 410);
		backgroundImageLabel.add(pumpkin);

		pumpkinBlack.setSize(60, 50);
		pumpkinBlack.setLocation(620, 410);
		backgroundImageLabel.add(pumpkinBlack);

		for (int i = 0; i < 4; i++) {
			vertical[i].setSize(15, 100);
			vertical[i].setLocation(680 + i * 65, 400);
			backgroundImageLabel.add(vertical[i]);
		}
		for (int i = 4; i < 8; i++) {
			vertical[i].setSize(15, 100);
			vertical[i].setLocation(420 + i * 65, 280);
			backgroundImageLabel.add(vertical[i]);
		}
		for (int i = 8; i < 12; i++) {
			vertical[i].setSize(15, 100);
			vertical[i].setLocation(160 + i * 65, 160);
			backgroundImageLabel.add(vertical[i]);
		}

		for (int i = 0; i < 3; i++) {
			horizon[i].setSize(100, 15);
			horizon[i].setLocation(670, 145 + i * 120);
			backgroundImageLabel.add(horizon[i]);
		}
		for (int i = 3; i < 6; i++) {
			horizon[i].setSize(100, 15);
			horizon[i].setLocation(800, -215 + i * 120);
			backgroundImageLabel.add(horizon[i]);
		}
		for (int i = 0; i < stoneH.length; i++) {
			stoneH[i].setSize(20, 50);
			stoneH[i].setLocation(810 + i * 60, 100);
			backgroundImageLabel.add(stoneH[i]);
		}
		for (int i = 0; i < triangleL.length; i++) {
			triangleL[i].setSize(20, 50);
			triangleL[i].setLocation(810 + i * 60, 100);
			backgroundImageLabel.add(triangleL[i]);
		}
	}

}
