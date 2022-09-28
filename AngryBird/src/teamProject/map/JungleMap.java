package teamProject.map;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import component.TreeBlock;
import lombok.Getter;
import lombok.Setter;
import teamProject.frame.MainFrame;

@Getter
@Setter
public class JungleMap extends Background {

	MainFrame mContext;

	private MyMouseAdapter myAdapter;

	private double pressX;
	private double pressY;
	private double releaseX;
	private double releaseY;

	private int state;

	private JLabel jungelMap;
	private JLabel holder;

	private TreeBlock block2;

	public JungleMap(MainFrame mContext) {
		this.mContext = mContext;
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("Jungel Map");
		setSize(1000, 570);
//		mContext.addEventListenr();
		jungelMap = new JLabel(new ImageIcon("images/bg1.png"));
		holder = new JLabel(new ImageIcon("images/img.png"));
		myAdapter = new MyMouseAdapter();
		block2 = new TreeBlock(mContext);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);

		add(mContext.getPlayer().getPlayer()[0]);
		add(mContext.getPlayer().getPlayer()[1]);
		add(mContext.getPlayer().getPlayer()[2]);

		holder.setSize(60, 150);
		holder.setLocation(80, 340);
		add(holder);

		jungelMap.setSize(1000, 570);
		jungelMap.setLocation(0, 0);
		add(jungelMap);

		add(block2);
	}

	public void addEventListener() {
		addMouseListener(myAdapter);
		addMouseMotionListener(myAdapter);
	}

	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			pressX = ((Number) e.getX()).doubleValue();
			pressY = ((Number) e.getY()).doubleValue();
		}

		@Override
		public void mouseDragged(MouseEvent e) {

			double a = getPressX() - e.getX();
			double b = getPressY() - e.getY();
			int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();
			double slope = (b / a);

			int x = ((Number) getPressX()).intValue();
			int y = ((Number) getPressY()).intValue() - 50;
			new Thread(new Runnable() {

				@Override
				public void run() {

					try {
						Thread.sleep(100);
//						System.out.println("slope: " + slope);
//						if (slope == -1) {
////							System.out.println("-1");
//							mContext.getPointer1().setLocation(x + c / 4, y - 5);
//							mContext.getPointer2().setLocation(x + c / 2, y - 25);
//							mContext.getPointer3().setLocation(x + (c / 2) + (c / 4), y - 45);
//							mContext.getPointer4().setLocation(x + c, y - 65);
//
//						} else if (slope > -1 && slope <= 0.5) {
////							System.out.println(" -1 초과 0.5 이");
//							mContext.getPointer1().setLocation(x + c / 4, y - 5);
//							mContext.getPointer2().setLocation(x + c / 2, y - 15);
//							mContext.getPointer3().setLocation(x + c / 2 + c / 4, y - 25);
//							mContext.getPointer4().setLocation(x + c, y - 35);
//
//						} else if (slope > 0.5 && slope <= 0) {
////							System.out.println("05초과  0 이하  ");
//							mContext.getPointer1().setLocation(x + c / 4, y - 0);
//							mContext.getPointer2().setLocation(x + c / 2, y - 5);
//							mContext.getPointer3().setLocation(x + c / c / 2 + c / 4, y - 10);
//							mContext.getPointer4().setLocation(x + c, y - 15);
//
//						} else if (slope < -1 && slope >= 1.5) {
////							System.out.println("-1초과  1.5 이하 ");
//							mContext.getPointer1().setLocation(x + c / 4, y - 5);
//							mContext.getPointer2().setLocation(x + c / 2, y - 40);
//							mContext.getPointer3().setLocation(x + c / 2 + c / 4, y - 75);
//							mContext.getPointer4().setLocation(x + c, y - 105);
//
//						} else if (slope < 1.5) {
////							System.out.println("1.5 이하 ");
//							mContext.getPointer1().setLocation(x + c / 4, y - 5);
//							mContext.getPointer2().setLocation(x + c / 2, y - 50);
//							mContext.getPointer3().setLocation(x + c / 2 + c / 4, y - 85);
//							mContext.getPointer4().setLocation(x + c, y - 120);
//
//						}
//
//						add(mContext.getPointer1());
//						add(mContext.getPointer2());
//						add(mContext.getPointer3());
//						add(mContext.getPointer4());

						// 오류 있음
						mContext.getPlayer().getPlayer()[mContext.getPlayer().getState()].setLocation(e.getX() - 80 / 2,
								e.getY() - 65);

					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}).start();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			releaseX = ((Number) e.getX()).doubleValue();
			releaseY = ((Number) e.getY()).doubleValue();

			if (mContext.getPlayer().getState() == 0) {
				playerMove();

			} else if (mContext.getPlayer().getState() == 1) {

				playerMove();
			} else if (mContext.getPlayer().getState() == 2) {

				playerMove();
			}

		}

	}

	public void playerMove() {
		new Thread(new Runnable() {
			@Override
			public void run() {

				// x증가량 y증가량
				double a = getPressX() - getReleaseX();
				double b = getPressY() - getReleaseY();
				// 빗변
				int c = ((Number) Math.sqrt((a * a) + (b * b))).intValue();
				int playerX = mContext.getPlayer().getPlayer()[state].getX();
				int playerY = mContext.getPlayer().getPlayer()[state].getY();

				System.out.println();
				// 기울기
				double slope = (b / a);

				// 무브 세분화
				// 1 수평 내려오는거 없음
				if (slope > 0 && slope < 1) {
					for (int i = 0; i < c; i++) {

						playerX += 2;

						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);

						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 2;

						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 15도 완만
				} else if (slope > -0.5 && slope <= 0) {

					for (int i = 0; i < c; i++) {
						playerX += 3;
						playerY -= 1;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 3;
						playerY += 1;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 30도
				} else if (slope > -1 && slope <= -0.5) {
					for (int i = 0; i < c; i++) {
						playerX += 2;
						playerY -= 1;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 2;
						playerY += 1;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					// 60 도
				} else if (slope > -1.5 && slope <= -1) {
					for (int i = 0; i < c; i++) {
						playerX += 1;
						playerY -= 2;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 1;
						playerY += 2;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					// 매우 가파름 80도 언저리
				} else if (slope < -1.5) {
					for (int i = 0; i < c; i++) {
						playerX += 1;
						playerY -= 3;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {
						playerX += 1;
						playerY += 3;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					// 수직
				} else if (slope > 1) {

					for (int i = 0; i < c; i++) {

						playerY -= 2;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					for (int j = 0; j < c; j++) {

						playerY += 2;
						mContext.getPlayer().getPlayer()[state].setLocation(playerX, playerY);
						System.out.println("새X:" + playerX);
						System.out.println("새Y:" + playerY);

						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				if (state < 2) {
					state += 1;
				}

//				player[i]

				mContext.getBlock1().squareBlockArrayCrash();
				System.out.println("dead");
				state = 0;

			}

		}).start();

	}

}
