package teamProject.frame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

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

	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(MainFrame.class.getResourceAsStream("bgm/angryBGM.wav" + url));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new MainFrame();

	}

}
