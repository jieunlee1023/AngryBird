package teamProject.map;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import component.Pointer;
import component.player.Player;

public abstract class Background extends JFrame implements ActionListener {

	String fileName;
	Background mContext = this;
	public JLabel backgroundImageLabel;
	protected JLabel holderLabel;
	protected JLabel floorLabel;
	protected JLabel scoreLabel;
	protected JLabel scoreTotal;

	public JLabel clickHereLabel;
	public JLabel clickHereLetterLabel;
	public JButton goBackButton;

	private MyMouseAdapter myAdapter;

	final int RANGE_X = 130;
	final int RANGE_Y = 380;

	private double pressX;
	private double pressY;
	private double releaseX;
	private double releaseY;

	protected int birdType;
	protected int birdState;
	JungleMapFrame frame;

	boolean crashState;
	String scoreText = "SCORE : ";
	String scoreAll = "TOTAL : ";
	// 블록당 점수를 다르게 만들기 위함
	static int score;

	public Player[] player;
	public Pointer[] pointer;

	public int getBirdType() {
		return birdType;
	}

	public static int getScore() {
		return score;
	}

	public static void setScore(int score) {
		Background.score = score;
	}

	public void setBirdType(int birdType) {
		this.birdType = birdType;
	}

	public int getBirdState() {
		return birdState;
	}

	public void setBirdState(int birdState) {
		this.birdState = birdState;
	}

	public double getPressX() {
		return pressX;
	}

	public void setPressX(double pressX) {
		this.pressX = pressX;
	}

	public double getPressY() {
		return pressY;
	}

	public void setPressY(double pressY) {
		this.pressY = pressY;
	}

	public double getReleaseX() {
		return releaseX;
	}

	public void setReleaseX(double releaseX) {
		this.releaseX = releaseX;
	}

	public double getReleaseY() {
		return releaseY;
	}

	public void setReleaseY(double releaseY) {
		this.releaseY = releaseY;
	}

	public Background(String fileName) {
		this.fileName = fileName;
		initDate();
		setInitLayout();
		addEventListener();

	}

	protected void initDate() {
		setSize(1000, 570);
		setResizable(false);
		birdType = 0; // 0 레드 1블랙 2 옐로
		birdState = 0; // 1살아있음 0죽음

		// 플레이어 주소값 입력
		player = new Player[3];
		player[0] = new Player(new ImageIcon("images/redbird.png"), 40, 410, this);
		player[1] = new Player(new ImageIcon("images/blackbird.png"), 80, 420, this);
		player[2] = new Player(new ImageIcon("images/yellowbird.png"), 0, 420, this);

		pointer = new Pointer[4];
		for (int i = 0; i < pointer.length; i++) {
			pointer[i] = new Pointer(new ImageIcon("images/pointer.png"));
			pointer[i].setSize(10, 10);
		}
		goBackButton = new JButton(new ImageIcon("images/goback.png"));
		holderLabel = new JLabel(new ImageIcon("images/img.png"));
		backgroundImageLabel = new JLabel(new ImageIcon(fileName));
		clickHereLabel = new JLabel(new ImageIcon("images/clickhere.png"));
		clickHereLetterLabel = new JLabel(new ImageIcon("images/clickhere2.png"));

		floorLabel = new JLabel(new ImageIcon("images/floor.png"));

		score = 0;
		scoreLabel = new JLabel(scoreText + score / 1000);
		scoreLabel.setFont(new Font("@CookieRun", Font.BOLD, 18));
		scoreLabel.setForeground(Color.WHITE);

		scoreTotal = new JLabel(scoreAll + score / 1000);
		scoreTotal.setFont(new Font("@CookieRun", Font.BOLD, 45));
		scoreTotal.setForeground(Color.BLUE);

		myAdapter = new MyMouseAdapter();

	}

	protected void setInitLayout() {

		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		backgroundImageLabel.setSize(1000, 570);
		backgroundImageLabel.setLocation(0, 0);
		add(backgroundImageLabel);

		// player
		player[0].setSize(80, 60);
		player[0].setLocation(player[0].getPlayerX(), player[0].getPlayerY());
		player[1].setSize(80, 60);
		player[1].setLocation(player[1].getPlayerX(), player[1].getPlayerY());
		player[2].setSize(80, 60);
		player[2].setLocation(player[2].getPlayerX(), player[2].getPlayerY());

		backgroundImageLabel.add(player[0]);
		backgroundImageLabel.add(player[1]);
		backgroundImageLabel.add(player[2]);

		goBackButton.setSize(60, 50);
		goBackButton.setLocation(10, 10);
		backgroundImageLabel.add(goBackButton);

		// click here
		clickHereLabel.setSize(45, 45);
		clickHereLabel.setLocation(80, 320);
		backgroundImageLabel.add(clickHereLabel);
		clickHereLetterLabel.setSize(75, 50);
		clickHereLetterLabel.setLocation(75, 270);
		backgroundImageLabel.add(clickHereLetterLabel);

		// 점수판
		scoreLabel.setSize(150, 50);
		scoreLabel.setLocation(800, 20);
		scoreLabel.setText(scoreText + score);
		backgroundImageLabel.add(scoreLabel);

		// 거치대
		holderLabel.setSize(60, 150);
		holderLabel.setLocation(80, 340);
		backgroundImageLabel.add(holderLabel);

		floorLabel.setSize(145, 70);
		floorLabel.setLocation(0, 440);
		backgroundImageLabel.add(floorLabel);

	}

	public void addEventListener() {
		addMouseListener(myAdapter);
		addMouseMotionListener(myAdapter);
		goBackButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetButton = (JButton) e.getSource();
		if (targetButton.equals(goBackButton)) {
			new MapSelectPage();
			mContext.setVisible(false);
		}
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			pressX = ((Number) e.getX()).doubleValue();
			pressY = ((Number) e.getY()).doubleValue();
			if (e.getX() <= RANGE_X && e.getY() >= RANGE_Y) {
			if (birdType == 0) {
				player[0].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			} else if (birdType == 1) {
				player[1].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			} else if (birdType == 2) {
				player[2].setLocation(e.getX() - 80 / 2, e.getY() - 65);
			}
			}

		}

		@Override
		public void mouseDragged(MouseEvent e) {

			if (e.getX() <= RANGE_X && e.getY() >= RANGE_Y) {
				double a = getPressX() - e.getX();
				double b = getPressY() - e.getY();
				int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();
				double slope = (b / a);

				int x = ((Number) getPressX()).intValue();
				int y = ((Number) getPressY()).intValue() - 50;

				new Thread(new Runnable() {

					@Override
					public synchronized void run() {

						try {
							Thread.sleep(10);

							// 이게 진짜임 건들지 말것 건드리면 화냄 !!!!!!!!!
							// 수평
							if (slope > 0 && slope < 1) {

								pointer[0].setLocation(x + c / 4, y);
								pointer[1].setLocation(x + c / 2, y);
								pointer[2].setLocation(x + c / 2 + c / 4, y);
								pointer[3].setLocation(x + c, y);

								// 15도 완만
							} else if (slope > -0.5 && slope <= 0) {

								pointer[0].setLocation(x + c / 4, y - 5);
								pointer[1].setLocation(x + c / 2, y - 20);
								pointer[2].setLocation(x + c / 2 + c / 4, y - 35);
								pointer[3].setLocation(x + c, y - 50);

								// 30도
							} else if (slope > -1 && slope <= -0.5) {

								pointer[0].setLocation(x + c / 4, y - 5);
								pointer[1].setLocation(x + c / 2, y - 30);
								pointer[2].setLocation(x + c / 2 + c / 4, y - 55);
								pointer[3].setLocation(x + c, y - 70);

								// 60 도
							} else if (slope > -1.5 && slope <= -1) {
								pointer[0].setLocation(x + 5, y - c / 4);
								pointer[1].setLocation(x + 30, y - c / 2);
								pointer[2].setLocation(x + 55, y - (c / 2 + c / 4));
								pointer[3].setLocation(x + 70, y - c);

								// 매우 가파름 80도 언저리
							} else if (slope < -1.5) {
								pointer[0].setLocation(x + 5, y - c / 4);
								pointer[1].setLocation(x + 20, y - c / 2);
								pointer[2].setLocation(x + 35, y - (c / 2 + c / 4));
								pointer[3].setLocation(x + 50, y - c);

								// 수직
							} else if (slope > 1) {

								pointer[0].setLocation(x, y - c / 4);
								pointer[1].setLocation(x, y - c / 2);
								pointer[2].setLocation(x, y - c / 2 + c / 4);
								pointer[3].setLocation(x, y - c);

							}

							backgroundImageLabel.add(pointer[0]);
							backgroundImageLabel.add(pointer[1]);
							backgroundImageLabel.add(pointer[2]);
							backgroundImageLabel.add(pointer[3]);

						} catch (InterruptedException e1) {

							e1.printStackTrace();
						}

						// 드래그 모션
						if (birdType == 0) {
							player[0].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else if (birdType == 1) {
							player[1].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else if (birdType == 2) {
							player[2].setLocation(e.getX() - 80 / 2, e.getY() - 65);
						} else {

						}
					}
				}).start();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getX() <= RANGE_X && e.getY() >= RANGE_Y) {
				releaseX = ((Number) e.getX()).doubleValue();
				releaseY = ((Number) e.getY()).doubleValue();

				if (birdType < 3) {
					player[birdType].playerMove();

				} else {
					new GameOverFrame();
					setVisible(false);
				}
			}
		}
	}

	public void pointerMove(int x, int y, int c, int a, int b) {
		for (int i = 0; i < 10; i++) {
			pointer[0].setLocation(x + c / 4, y - 5);
			pointer[1].setLocation(x + c / 2, y - 50);
			pointer[2].setLocation(x + c / 2 + c / 4, y - 85);
			pointer[3].setLocation(x + c, y - 120);
		}
	}

}
