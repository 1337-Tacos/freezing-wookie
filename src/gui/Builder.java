package gui;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit;

public class Builder extends JFrame {
	
	public JList modList, installList, totalDep, selectionDep;
	public HTMLEditorKit modInfo;
	public JButton build, add, remove;
	public Vector testV;
	
	public Builder(){
		
		this.setTitle("Freezing-Wookie");
		this.setLayout(new BorderLayout());
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.testV = new Vector(10);
		
		this.testV.add(new String("Derp"));
		this.testV.add(new String("Merp"));
		
		this.initComp();
		this.addComponents();
		
		this.pack();
		this.setVisible(true);
			
	}

	private void initComp(){
		
		this.build = new JButton("Build");
		this.add = new JButton("Add");
		this.remove = new JButton("Remove");
		
		this.modInfo = new HTMLEditorKit();
		
	}
	
	private void addComponents(){
		
		this.add(this.add, BorderLayout.WEST);
		
	}
	
}
