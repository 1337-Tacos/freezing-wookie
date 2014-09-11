package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import utilities.DescriptionGenerator;
import core.MCPackage;
import core.Manager;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Builder extends JFrame {

	private static final long serialVersionUID = 6865530991775121331L;
	public JButton remove, update;
	public Vector<String> testV;
	private JTable modTable;
	/**
	 * displayTable is the table of objects which is responsible for showing the packages in the GUI<br>
	 * element 0 is the image object which is the logo for each package<br>
	 * element 1 is the Human-Readable name of the mod to display in the second column<br>
	 * element 2 is packageID of the mod.  This is used to allow us to find the proper package again.
	 */
	private Object[][] displayTable = new Object[1][3];
	JEditorPane descriptionHTMLPane;
	ArrayList<MCPackage> packs;
	private JTextField txtSearchBox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Builder(final Manager man)
	{
		packs = man.getAllPackages();
		updateList(packs);

		this.setTitle("Freezing-Wookie-test");
		this.setSize(1200, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane leftSplitPane = new JSplitPane();
		leftSplitPane.setEnabled(false);
		leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		getContentPane().add(leftSplitPane, BorderLayout.WEST);
		
		JScrollPane modScrollPane = new JScrollPane();
		modScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		modScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		leftSplitPane.setRightComponent(modScrollPane);
		
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
		modScrollPane.setViewportView(modTable);
		
		JPanel searchPanel = new JPanel();
		leftSplitPane.setLeftComponent(searchPanel);
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		JLabel lblCatagory = new JLabel("Catagory:");
		searchPanel.add(lblCatagory);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All", "Technology", "Magic", "Tacos", "Nuclear Bombs", "Atomic Dogs", "Radioactive Windmills"}));
		searchPanel.add(comboBox);
		
		JCheckBox chckbxLaunchMissiles = new JCheckBox("Launch Missiles");
		searchPanel.add(chckbxLaunchMissiles);
		
		txtSearchBox = new JTextField();
		txtSearchBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSearchBox.setText("");
			}
		});
		txtSearchBox.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearchBox.setText("Type To Search");
		searchPanel.add(txtSearchBox);
		txtSearchBox.setColumns(10);
		
		JSplitPane topSplitPane = new JSplitPane();
		topSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		topSplitPane.setEnabled(false);
		getContentPane().add(topSplitPane, BorderLayout.NORTH);
		
		JLabel lblLargeAreaFor = new JLabel("Large Area For Title and stuff.");
		lblLargeAreaFor.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
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
		
		JPanel rightPanel = new JPanel();
		getContentPane().add(rightPanel, BorderLayout.CENTER);
		rightPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel actionButtonPane = new JPanel();
		rightPanel.add(actionButtonPane, BorderLayout.SOUTH);
		
		JButton installButton = new JButton("Install");
		actionButtonPane.add(installButton);
		
		JButton btnUpdate = new JButton("Update");
		actionButtonPane.add(btnUpdate);
		
		JButton btnRemove = new JButton("Remove");
		actionButtonPane.add(btnRemove);
		
		JScrollPane detailsScrollPanescrollPane_1 = new JScrollPane();
		rightPanel.add(detailsScrollPanescrollPane_1, BorderLayout.CENTER);
		
		descriptionHTMLPane = new JEditorPane();
		descriptionHTMLPane.setContentType("text/html");
		descriptionHTMLPane.setText( DescriptionGenerator.generateDescription(man.getPackage("Logistics_Pipes")) );
		descriptionHTMLPane.setEditable(false);
		detailsScrollPanescrollPane_1.setViewportView(descriptionHTMLPane);
		
		this.initComp();
		
		this.setVisible(true);

	}

	private void initComp(){
		this.update = new JButton("Add");
		this.remove = new JButton("Remove");
	}

	private void updateList(ArrayList<MCPackage> packs) {
		ArrayList<Object[]> arLs = new ArrayList<Object[]>();
		for (MCPackage pack : packs) {
			Object[] array = new Object[3];
			//TODO:  array[0] = pack.getImage();
			array[1] = pack.getName();
			array[2] = pack.getID();
			arLs.add(array);
		}
		this.displayTable = arLs.toArray(displayTable);
	}
}