package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLEditorKit;

public class Builder extends JFrame {
	
	public JList<String> modList, installList, totalDep, selectionDep;
	public HTMLEditorKit modInfo;
	public JButton build, add, remove;
	public Vector<String> testV;
	
	public Builder(){
		
		this.setTitle("Freezing-Wookie");
		this.setLayout(new BorderLayout());
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.testV = new Vector<String>(10);
		
		this.testV.add(new String("Derp"));
		this.testV.add(new String("Merp"));
		
		this.initComp();
		this.addComponents();
		
		this.setVisible(true);
			
	}

	private void initComp(){
		
		this.build = new JButton("Build");
		this.add = new JButton("Add");
		this.remove = new JButton("Remove");
		
		this.modList = new JList<String>();
		this.installList = new JList<String>();
		
		this.modInfo = new HTMLEditorKit();
		
	}
	
	private void addComponents(){
		
		JPanel westPan = new JPanel();
		JPanel buttonPan = new JPanel();
		GridBagLayout buttonLayout = new GridBagLayout();
		GridLayout wLayout = new GridLayout(1,3);
		
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
		
		wLayout.setVgap(2);
		wLayout.setHgap(2);
		
		this.modList.setBorder(BorderFactory.createEtchedBorder());
		this.installList.setBorder(BorderFactory.createEtchedBorder());
		
		westPan.setLayout(wLayout);
		buttonPan.setLayout(buttonLayout);
		
		buttonPan.add(this.add, gbc);
		buttonPan.add(this.remove, gbc);
		
		westPan.add(this.modList);
		westPan.add(buttonPan);
		westPan.add(this.installList);
		
		this.add(westPan, BorderLayout.WEST);
		
	}
	
}
