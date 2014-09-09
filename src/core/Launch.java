package core;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.Builder;

public class Launch {
	
	public static Builder builderWin;
	public static Manager man = new Manager();
	
	public static void main(String[] args){
		
		man.addRepo("hydra-main", "http://hydra.13-thirtyseven.com/");
		man.updateRepos();
		
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
				
				Launch.builderWin = new Builder(man);
			}
			
		});
		
	}

}
