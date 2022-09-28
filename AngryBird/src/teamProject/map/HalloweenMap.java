package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import teamProject.frame.MainFrame;

public class HalloweenMap extends Background {

	MainFrame mContext;

	JLabel halloweenMap;
	private JLabel holder;

	public HalloweenMap(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("Halloween Map");
		setSize(1000, 570);

		halloweenMap = new JLabel(new ImageIcon("images/bg3.png"));
		holder = new JLabel(new ImageIcon("images/img.png"));
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		holder.setSize(60, 150);
		holder.setLocation(80, 340);
		add(holder);

		halloweenMap.setSize(1000, 570);
		halloweenMap.setLocation(0, 0);
		add(halloweenMap);
	}

}
