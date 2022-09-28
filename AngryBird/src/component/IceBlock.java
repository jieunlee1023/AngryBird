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
public class IceBlock extends Block {

	// 이미지
	private ImageIcon image;
	private int blockX;
	private int blockY;

	private IceBlock[] squareBlocks = new IceBlock[10];

	String[] images = { "images/ice_block_square.png", "images/ice_block_width_rectangle.png",
			"images/ice_block_height_rectangle.png", "images/ice_block_width_long.png",
			"images/ice_block_height_long.png" };

	// 적군이 부딪힌 상태
	private int state; // 0(안부딪힘) , 1, (부딪힘)

	public IceBlock(ImageIcon images) {
		super(images);
	}

	private void initData() {
		setVisible(true);
		setLayout(null);

		squareBlocks[0] = new IceBlock(new ImageIcon("images/ice_block_square.png"));

	}

	private void setInitLayout() {
		squareBlocks[0].setSize(50, 50);
		squareBlocks[0].setLocation(100, 100);
		add(squareBlocks[0]);

	}

	public void squareBlockArrayCrash() {

//		new Thread(() -> {}).start();

	}

}