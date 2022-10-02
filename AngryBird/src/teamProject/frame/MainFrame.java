package teamProject.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;

import component.IceBlock;
import component.TreeBlock;
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

	// 맵
	private StartPage startPage;

	public MainFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Angry Bird");
		setSize(1000, 570);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		startPage = new StartPage(mContext);

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
