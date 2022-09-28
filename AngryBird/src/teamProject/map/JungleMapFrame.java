package teamProject.map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import component.Pointer;
import component.player.Player;
import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class JungleMapFrame extends Background {

//	JLabel[] blackBang;

	
	
	public JungleMapFrame(String fileName) {
		super(fileName);
		//initData();
	}

	private void initData() {
		super.initDate();
		this.setTitle("Jungel Map");
	}

	
}
