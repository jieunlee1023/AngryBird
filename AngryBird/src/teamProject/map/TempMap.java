package teamProject.map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import component.TreeBlock;
import teamProject.frame.MainFrame;

public class TempMap extends Background {
//	
//	String[] images = { "images/woodBlock_downRec.png", "images/woodBlock_upRec.png",
//			"images/woodBlock_thinUpRec.png", "images/woodBlock_thinDownRec.png",
//	"images/woodBlock_square.png" };
//
//   private TreeBlock[] treeSquare = new TreeBlock[40];
//   private TreeBlock[] treeDownRec = new TreeBlock[14];
//   private TreeBlock[] treeUpRec = new TreeBlock[5];
//   private TreeBlock[] treeThinDownRec = new TreeBlock[5];
//   private TreeBlock[] treeThinUpRec = new TreeBlock[5];
//	
//   MainFrame mContext;
//
//   private JLabel iceMap;
//   private JLabel holder;
//
//   TreeBlock treeBlock; 
//
//   public TempMap() {
//      initData();
//      setInitLayout();
//   }
//
//   public TempMap(MainFrame mContext) {
//      this.mContext = mContext;
//      initData();
//      setInitLayout();
//   }
//
//   private void initData() {
//      setTitle("JungleMap");
//      setSize(1000, 570);
//      iceMap = new JLabel(new ImageIcon("images/bg2.png"));
//      holder = new JLabel(new ImageIcon("images/img.png"));
//
//      // 정사각형
//      for (int i = 0; i < treeSquare.length; i++) {
//    	  treeSquare[i] = new TreeBlock(new ImageIcon(images[4]));
//      }
//     
//      // 가로 사각형
//      for (int i = 0; i < treeDownRec.length; i++) {
//    	  treeDownRec[i] = new TreeBlock(new ImageIcon(images[0]));
//      }
//      
//      // 세로 사각형
//      for (int i = 0; i < treeUpRec.length; i++) {
//    	  treeUpRec[i] = new TreeBlock(new ImageIcon(images[1]));
//      }
//      
//      // 얇은 가로 사각형
//      for (int i = 0; i < treeThinDownRec.length; i++) {
//    	  treeThinDownRec[i] = new TreeBlock(new ImageIcon(images[3]));
//      }
//      
//      // 얇은 세로 사각형
//      for (int i = 0; i < treeThinUpRec.length; i++) {
//    	  treeThinUpRec[i] = new TreeBlock(new ImageIcon(images[2]));
//      }
//      
//      
//
//   }
//
//   private void setInitLayout() {
//      setVisible(true);
//      setLayout(null);
//      setLocationRelativeTo(null);
//      // 정사각형-----------------------------------------------------------
//      for (int i = 0; i < 20; i++) { // 맨앞 정사각형
//    	  treeSquare[i].setSize(50, 50);
//    	  treeSquare[i].setLocation(500, 450 - (i*20));
//         add(treeSquare[i]);
//      }
//
//      for (int i = 20; i < 40; i++) { // 맨앞 정사각형
//    	  treeSquare[i].setSize(50, 50);
//    	  treeSquare[i].setLocation(525, 850 - (i*20));
//         add(treeSquare[i]);
//      }
//      
//      // 가로 사각형--------------------------------------------------------
//      for (int i = 0; i < 7; i++) { // 1. 바닥
//    	  treeDownRec[i].setSize(50, 50);
//    	  treeDownRec[i].setLocation(600 + (i * 50) , 450);  
//         add(treeDownRec[i]);
//      }
//      for (int i = 7; i < 14; i++) { // 3. 바닥 위 바닥
//    	  treeDownRec[i].setSize(50, 50);
//    	  treeDownRec[i].setLocation(250 + (i * 50) , 330 );
//         add(treeDownRec[i]);
//      }
//      
//      // 세로 사각형--------------------------------------------------------
//      for (int i = 0; i < 2; i++) { // 4. 바닥 위 바닥 모양 (1)
//    	  treeUpRec[i].setSize(50, 50);
//    	  treeUpRec[i].setLocation(660 + (i * 200) , 290);
//         add(treeUpRec[i]);
//      }
//      
//      for (int i = 2; i < 4; i++) { // 4. 바닥 위 바닥 모양 (2)
//    	  treeUpRec[i].setSize(50, 50);
//    	  treeUpRec[i].setLocation(260 + (i * 200) , 240);
//         add(treeUpRec[i]);
//      }
//      
//      // 얇은 세로 사각형----------------------------------------------------
//      for (int i = 0; i < 5; i++) { // 2. 바닥 위
//    	  treeThinUpRec[i].setSize(15, 100);
//    	  treeThinUpRec[i].setLocation(650 + (i * 60) , 370 );
//         add(treeThinUpRec[i]);
//      }
//      
//      // 얇은 가로 사각형----------------------------------------------------
//      for (int i = 0; i < 2; i++) { // 2. 바닥 위
//    	  treeThinDownRec[i].setSize(100, 15);
//    	  treeThinDownRec[i].setLocation(725 , 310 + (i *15) );
//         add(treeThinDownRec[i]);
//      }
//      
//      
//      holder.setSize(60, 150);
//      holder.setLocation(80, 340);
//      add(holder);
//
//      iceMap.setSize(1000, 570);
//      iceMap.setLocation(0, 0);
//      add(iceMap);
//
//   }
//
//
//   public static void main(String[] args) {
//      new TempMap();
//   }
}