package core;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import gui.Builder;

public class Launch {
	
	public static Builder builderWin;
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					System.err.println("Couldn't change GUI theme.");
				}
				
				Launch.builderWin = new Builder();
			}
			
		});
		
	}

}
