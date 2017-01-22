package main;

import javax.swing.JFrame;

import view.Menu;

public class Boot {

	private static Menu window;

	private static void GUI() {
	    JFrame.setDefaultLookAndFeelDecorated(true);

	    JFrame frame = new JFrame("MyApplication");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    window = new Menu();
		window.getMainPanel().setVisible(true);
	    //menuPane.setPreferredSize( new Dimension(1000, 500) );
	    //menuPane.setOpaque(true);
	    //frame.setContentPane(menuPane);
	    //frame.setResizable(false);	   
	    
	    //frame.pack();
	    //frame.setVisible(true);
	 }
	
	
	public static void main(String[] args){

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI();
			}
		});
	}
}
