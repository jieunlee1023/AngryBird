package teamProject.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Block1;
import component.Block2;
import component.Pointer;
import component.player.Player;
import lombok.Getter;
import lombok.Setter;
import teamProject.map.StartPage;

@Getter
@Setter
public class MainFrame extends JFrame {

	// 선언부
	private MainFrame mContext = this;

	// 컴포넌트 플레이
	private Player player;

	// 이외의 컴포넌트
	private Block1 block1;
	private Block2 block2;
	private Block2 block3;

//	private JLabel pointer1;
//	private JLabel pointer2;
//	private JLabel pointer3;
//	private JLabel pointer4;
//	private Pointer pointer;
//	private Pointer pointer;

	// 맵
	private StartPage startPage;

	public MainFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Angry Bird");
		setSize(1000, 570);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startPage = new StartPage(mContext);
		player = new Player(mContext);

//		pointer = new Pointer(mContext);
//		myAdapter = new MyMouseAdapter();
//		pointer = new Pointer(this);

//		block1 = new Block1(mContext);
//		block2 = new Block2(mContext);
//		pig = new Pig(mContext);

//		pointer1 = new JLabel(new ImageIcon("images/pointer.png"));
//		pointer1.setSize(10, 10);
//		pointer2 = new JLabel(new ImageIcon("images/pointer.png"));
//		pointer2.setSize(10, 10);
//		pointer3 = new JLabel(new ImageIcon("images/pointer.png"));
//		pointer3.setSize(10, 10);
//		pointer4 = new JLabel(new ImageIcon("images/pointer.png"));
//		pointer4.setSize(10, 10);

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		add(startPage);

	}

	public static void main(String[] args) {
		new MainFrame();

	}

}
