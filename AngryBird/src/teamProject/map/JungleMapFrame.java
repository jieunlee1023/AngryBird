package teamProject.map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import component.Enemy;
import component.Pointer;
import component.TreeBlock;
import component.player.Player;
import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class JungleMapFrame extends Background {

	String[] images = { "images/woodBlock_downRec.png", "images/woodBlock_upRec.png", "images/woodBlock_thinUpRec.png",
			"images/woodBlock_thinDownRec.png", "images/woodBlock_square.png" };

	private TreeBlock[] treeSquare = new TreeBlock[40];
	private TreeBlock[] treeDownRec = new TreeBlock[14];
	private TreeBlock[] treeUpRec = new TreeBlock[5];
	private TreeBlock[] treeThinDownRec = new TreeBlock[5];
	private TreeBlock[] treeThinUpRec = new TreeBlock[5];

	TreeBlock treeBlock;
	
	private ImageIcon pig;
	private ImageIcon treeRoop;
	Enemy enemy;

	public JungleMapFrame(String fileName) {
		super(fileName);
		initData();

	}

	private void initData() {
		setTitle("jungle Maps");
		//pig
		enemy = new Enemy(new ImageIcon("images/pig.png"));

		backgroundImageLabel.add(enemy);
		enemy.setSize(100, 100);
		enemy.setLocation(750, 235);
		//roop
		TreeBlock treeRoop = new TreeBlock(new ImageIcon("images/wood_roop.png"));
		backgroundImageLabel.add(treeRoop);
		treeRoop.setSize(300, 180);
		treeRoop.setLocation(625, 65);
		
		// 정사각형
		for (int i = 0; i < treeSquare.length; i++) {
			treeSquare[i] = new TreeBlock(new ImageIcon(images[4]));
		}

		// 가로 사각형
		for (int i = 0; i < treeDownRec.length; i++) {
			treeDownRec[i] = new TreeBlock(new ImageIcon(images[0]));
		}

		// 세로 사각형
		for (int i = 0; i < treeUpRec.length; i++) {
			treeUpRec[i] = new TreeBlock(new ImageIcon(images[1]));
		}

		// 얇은 가로 사각형
		for (int i = 0; i < treeThinDownRec.length; i++) {
			treeThinDownRec[i] = new TreeBlock(new ImageIcon(images[3]));
		}

		// 얇은 세로 사각형
		for (int i = 0; i < treeThinUpRec.length; i++) {
			treeThinUpRec[i] = new TreeBlock(new ImageIcon(images[2]));
		}
		
//------------------------------------------------------------------------------------------------
		
		

//      정사각형-----------------------------------------------------------
//		for (int i = 0; i < 20; i++) { // 맨앞 정사각형
//			treeSquare[i].setSize(50, 50);
//			treeSquare[i].setLocation(500, 450 - (i * 20));
//			backgroundImageLabel.add(treeSquare[i]);
//		}
//
//		for (int i = 20; i < 40; i++) { // 맨앞 정사각형
//			treeSquare[i].setSize(50, 50);
//			treeSquare[i].setLocation(525, 850 - (i * 20));
//			backgroundImageLabel.add(treeSquare[i]);
//		}

		// 가로 사각형--------------------------------------------------------
		for (int i = 0; i < 7; i++) { // 1. 바닥
			treeDownRec[i].setSize(50, 50);
			treeDownRec[i].setLocation(600 + (i * 50), 450);
			backgroundImageLabel.add(treeDownRec[i]);
		}
		for (int i = 7; i < 14; i++) { // 3. 바닥 위 바닥
			treeDownRec[i].setSize(50, 50);
			treeDownRec[i].setLocation(250 + (i * 50), 330);
			backgroundImageLabel.add(treeDownRec[i]);
		}

		// 세로 사각형--------------------------------------------------------
		for (int i = 0; i < 2; i++) { // 4. 바닥 위 바닥 모양 (1)
			treeUpRec[i].setSize(50, 50);
			treeUpRec[i].setLocation(660 + (i * 200), 290);
			backgroundImageLabel.add(treeUpRec[i]);
		}

		for (int i = 2; i < 4; i++) { // 4. 바닥 위 바닥 모양 (2)
			treeUpRec[i].setSize(50, 50);
			treeUpRec[i].setLocation(260 + (i * 200), 240);
			backgroundImageLabel.add(treeUpRec[i]);
		}

		// 얇은 세로 사각형----------------------------------------------------
		for (int i = 0; i < 5; i++) { // 2. 바닥 위
			treeThinUpRec[i].setSize(15, 100);
			treeThinUpRec[i].setLocation(650 + (i * 60), 370);
			backgroundImageLabel.add(treeThinUpRec[i]);
		}

		// 얇은 가로 사각형----------------------------------------------------
		for (int i = 0; i < 2; i++) { // 2. 바닥 위
			treeThinDownRec[i].setSize(100, 15);
			treeThinDownRec[i].setLocation(725, 310 + (i * 15));
			backgroundImageLabel.add(treeThinDownRec[i]);
		}

	}
}
