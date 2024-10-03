package test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Main extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JProgressBar dpb;
	public Main(){
		// JFrame parentFrame = new JFrame();
		   // parentFrame.
		setSize(500, 150);
		//   parentFrame.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 //   parentFrame.
		setVisible(true);

		    dpb = new JProgressBar(0, 100);
		    dpb.setStringPainted(true);
		   // parentFrame.
		    add(BorderLayout.CENTER, dpb);
		    
	}
	
	public void renseigne(int i){
		dpb.setValue(i);
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  public static void main(String[] args) {
   Main main=new Main();
   for (int i = 0; i <= 100; i++) {
   	main.renseigne(i);
   }
  } 
}