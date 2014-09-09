package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import utilities.DescriptionGenerator;
import core.MCPackage;
import core.Manager;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Builder extends JFrame {

	private static final long serialVersionUID = 6865530991775121331L;
	public JButton remove, update;
	public Vector<String> testV;
	private JTable modTable;
	private Object[][] displayTable = new Object[1000][3];
	
	public String html = "";
	JEditorPane descriptionHTMLPane;
	
	public Builder(final Manager man)
	{
		ArrayList<MCPackage> packs = man.getAllPackages();
		html = DescriptionGenerator.generateDescription(packs.get(0));
		
		int i = 0;
		for (MCPackage pack : packs) {
			//this.displayTable[i][0] = pack.getImage();
			this.displayTable[i][1] = pack.getName();
			this.displayTable[i][2] = pack.getID();
			i++;
		}

		this.setTitle("Freezing-Wookie-test");
		this.setSize(1200, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		modTable = new JTable();
		modTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 1) {
					JTable target = (JTable)arg0.getSource();
					MCPackage mod = man.getPackage((String) displayTable[target.getSelectedRow()][2]);
					descriptionHTMLPane.setText(DescriptionGenerator.generateDescription(mod));
				}
			}
		});
		modTable.setSurrendersFocusOnKeystroke(true);
		modTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modTable.setFillsViewportHeight(true);
		modTable.setModel(new DefaultTableModel(
			displayTable ,
			new String[] {
				"Logo", "Name"
			}
		) {
			private static final long serialVersionUID = 4464075965532478875L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		modTable.getColumnModel().getColumn(0).setResizable(false);
		modTable.getColumnModel().getColumn(1).setResizable(false);
		listScrollPane.setViewportView(modTable);
		
		JScrollPane detailsScrollPane = new JScrollPane();
		detailsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		detailsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(detailsScrollPane, BorderLayout.CENTER);
		
		descriptionHTMLPane = new JEditorPane();
		descriptionHTMLPane.setContentType("text/html");
		descriptionHTMLPane.setText(html);
		descriptionHTMLPane.setEditable(false);
		detailsScrollPane.setViewportView(descriptionHTMLPane);
		
		JSplitPane topSplitPane = new JSplitPane();
		topSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		topSplitPane.setEnabled(false);
		getContentPane().add(topSplitPane, BorderLayout.NORTH);
		
		JLabel lblLargeAreaFor = new JLabel("Large Area For Title and stuff.");
		lblLargeAreaFor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLargeAreaFor.setForeground(Color.BLACK);
		lblLargeAreaFor.setPreferredSize(new Dimension(146, 100));
		lblLargeAreaFor.setBackground(Color.ORANGE);
		topSplitPane.setRightComponent(lblLargeAreaFor);
		
		JMenuBar menuBar = new JMenuBar();
		topSplitPane.setLeftComponent(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmUpdateRepositories = new JMenuItem("Update Repositories");
		mnFile.add(mntmUpdateRepositories);
		
		JMenuItem mntmEditRepositories = new JMenuItem("Edit Repositories");
		mnFile.add(mntmEditRepositories);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		
		JMenuItem mntmSupport = new JMenuItem("Support Us");
		mnHelp.add(mntmSupport);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{modTable, listScrollPane}));
		
		this.initComp();
		this.addComponents();
		
		this.setVisible(true);

	}

	private void initComp(){
		this.update = new JButton("Add");
		this.remove = new JButton("Remove");
	}
	
	private void addComponents(){
		
	}
}
