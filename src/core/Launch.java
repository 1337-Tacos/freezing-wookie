package core;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.Builder;

public class Launch {
	
	public static Builder builderWin;
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				Repository repo = new Repository("lol", "http://hydra.13-thirtyseven.com/");
				repo.updateList();
				
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
