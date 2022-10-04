package teamProject.map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapSelectPage extends JFrame implements ActionListener {

	JLabel background;
	JButton button1;
	JButton button2;
	JButton button3;

	final int BUTTON_SIZE_W = 280;
	final int BUTTON_SIZE_H = 280;
	final int BUTTON_SIZE_X = 40;
	final int BUTTON_SIZE_Y = 150;

	public MapSelectPage() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Map Choice");
		setSize(1000, 570);
		background = new JLabel(new ImageIcon("images/select_bg.png"));
		button1 = new JButton(new ImageIcon("images/select_bg1.png"));
		button2 = new JButton(new ImageIcon("images/select_bg2.png"));
		button3 = new JButton(new ImageIcon("images/select_bg3.png"));

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		button1.setSize(BUTTON_SIZE_W, BUTTON_SIZE_H);
		button1.setLocation(BUTTON_SIZE_X, BUTTON_SIZE_Y);
		add(button1);

		button2.setSize(BUTTON_SIZE_W, BUTTON_SIZE_H);
		button2.setLocation(BUTTON_SIZE_X + 315, BUTTON_SIZE_Y);
		add(button2);

		button3.setSize(BUTTON_SIZE_W, BUTTON_SIZE_H);
		button3.setLocation(BUTTON_SIZE_X + 630, BUTTON_SIZE_Y);
		add(button3);

		background.setSize(1000, 570);
		background.setLocation(0, 0);
		add(background);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton targetButton = (JButton) e.getSource();
		if (targetButton.equals(button1)) {
			new JungleMapFrame("images/bg1.png");
			setVisible(false);

		} else if (targetButton.equals(button2)) {
			new IceMapFrame("images/bg2.png");
			setVisible(false);

		} else if (targetButton.equals(button3)) {
//			new HolloweenMapFrame("images/bg3.png");
			setVisible(false);

		}

	}

}
