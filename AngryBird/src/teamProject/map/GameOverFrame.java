package teamProject.map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverFrame extends JFrame implements ActionListener {

	JLabel background;
	JButton button1;

	final int BUTTONWIDTH = 250;
	final int BUTTONHEIGHT = 70;
	final int BUTTONX = 390;
	final int BUTTONY = 300;

	public GameOverFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Map Choice");
		setSize(1000, 570);
		background = new JLabel(new ImageIcon("images/gameover.png"));
		button1 = new JButton(new ImageIcon("images/retry.png"));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		button1.setSize(BUTTONWIDTH, BUTTONHEIGHT);
		button1.setLocation(BUTTONX, BUTTONY);
		add(button1);

		background.setSize(1000, 570);
		background.setLocation(0, 0);
		add(background);
	}

	private void addEventListener() {
		button1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.equals(button1)) {
			new MapSelectPage();
			setVisible(false);

		}

	}

}
