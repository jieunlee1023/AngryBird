package teamProject.map;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class StartPage extends JLabel implements ActionListener {

	MainFrame mContext;

	JLabel startBackground;
	JButton startButton;

	public StartPage(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();

	}

	private void initData() {
		startBackground = new JLabel(new ImageIcon("images/main.png"));
		startButton = new JButton(new ImageIcon("images/start.png"));
		setSize(1000, 570);

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);

		startButton.setLocation(410, 444);
		startButton.setSize(150, 70);
		startButton.setBackground(Color.yellow);
		add(startButton);

		startBackground.setLocation(0, 0);
		startBackground.setSize(1000, 570);
		add(startBackground);

	}

	private void addEventListener() {
		startButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton) e.getSource();
		if (targetButton.equals(startButton)) {
			new MapSelectPage();
			mContext.setVisible(false);
		}

	}

}
