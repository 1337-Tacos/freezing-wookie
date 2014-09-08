package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLEditorKit;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Builder extends JFrame {

	private static final long serialVersionUID = 6865530991775121331L;
	public JList<String> totalDep, selectionDep;
	public HTMLEditorKit modInfo;
	public JButton remove, update;
	public Vector<String> testV;
	private JToolBar toolBar;
	private JTable table;
	
	public Builder(){

		this.setTitle("Freezing-Wookie-test");
		this.setSize(1200, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "dfdf"},
				{"", "dfd"},
				{"", "dfd"},
				{"", "fdfd"},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Logo", "Name"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4543429473939562015L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		listScrollPane.setViewportView(table);
		
		JScrollPane detailsScrollPane = new JScrollPane();
		detailsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		detailsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(detailsScrollPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setEnabled(false);
		getContentPane().add(splitPane_1, BorderLayout.NORTH);
		
		toolBar = new JToolBar();
		splitPane_1.setLeftComponent(toolBar);
		toolBar.setFloatable(false);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setHorizontalAlignment(SwingConstants.TRAILING);
		toolBar.add(mnFile);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(mnFile, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		popupMenu.add(menuItem);
		
		JMenu mnHelp = new JMenu("Help");
		toolBar.add(mnHelp);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(mnHelp, popupMenu_1);
		
		JLabel lblLargeAreaFor = new JLabel("Large Area For Title and stuff.");
		lblLargeAreaFor.setPreferredSize(new Dimension(146, 100));
		lblLargeAreaFor.setBackground(Color.ORANGE);
		splitPane_1.setRightComponent(lblLargeAreaFor);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{toolBar, mnFile, popupMenu, menuItem, mnHelp, popupMenu_1, table, listScrollPane}));
		
		this.initComp();
		this.addComponents();
		
		this.setVisible(true);

	}

	private void initComp(){
		this.update = new JButton("Add");
		this.remove = new JButton("Remove");
		
		this.modInfo = new HTMLEditorKit();

	}
	
	private void addComponents(){
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
