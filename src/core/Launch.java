package core;

import javax.swing.SwingUtilities;

import gui.Builder;

public class Launch {
	
	public static Builder builderWin;
	
	public static void main(String[] args){
		
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				Launch.builderWin = new Builder();
			}
			
		});
		
	}

}
