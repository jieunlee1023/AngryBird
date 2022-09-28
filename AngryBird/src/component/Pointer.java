package component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Getter;
import teamProject.frame.MainFrame;

@Getter
public class Pointer extends JLabel {
	MainFrame mContext;
	private JLabel pointer1;
	private JLabel pointer2;
	private JLabel pointer3;
	private JLabel pointer4;

	public Pointer(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();

	}

	private void initData() {

		pointer1 = new JLabel(new ImageIcon("images/pointer.png"));
		pointer1.setSize(10, 10);
		pointer2 = new JLabel(new ImageIcon("images/pointer.png"));
		pointer2.setSize(10, 10);
		pointer3 = new JLabel(new ImageIcon("images/pointer.png"));
		pointer3.setSize(10, 10);
		pointer4 = new JLabel(new ImageIcon("images/pointer.png"));
		pointer4.setSize(10, 10);
	}

	private void setInitLayout() {
		setVisible(true);
	}

}
