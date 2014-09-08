package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JEditorPane;
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

import core.Manager;

public class Builder extends JFrame {

	private static final long serialVersionUID = 6865530991775121331L;
	public JList<String> totalDep, selectionDep;
	public HTMLEditorKit modInfo;
	public JButton remove, update;
	public Vector<String> testV;
	private JToolBar toolBar;
	private JTable modTable;
	
	public String html = DescriptionGenerator.generateDescription(null);
	
	public Builder(Manager man)
	{

		this.setTitle("Freezing-Wookie-test");
		this.setSize(1200, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		listScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(listScrollPane, BorderLayout.WEST);
		
		modTable = new JTable();
		modTable.setSurrendersFocusOnKeystroke(true);
		modTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modTable.setFillsViewportHeight(true);
		modTable.setModel(new DefaultTableModel(
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
		modTable.getColumnModel().getColumn(0).setResizable(false);
		modTable.getColumnModel().getColumn(1).setResizable(false);
		listScrollPane.setViewportView(modTable);
		
		JScrollPane detailsScrollPane = new JScrollPane();
		detailsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		detailsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(detailsScrollPane, BorderLayout.CENTER);
		
		JEditorPane descriptionHTMLPane = new JEditorPane("text/html",html);
		descriptionHTMLPane.setEditable(false);
		detailsScrollPane.setViewportView(descriptionHTMLPane);
		
		JSplitPane topSplitPane = new JSplitPane();
		topSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		topSplitPane.setEnabled(false);
		getContentPane().add(topSplitPane, BorderLayout.NORTH);
		
		toolBar = new JToolBar();
		topSplitPane.setLeftComponent(toolBar);
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
		topSplitPane.setRightComponent(lblLargeAreaFor);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{toolBar, mnFile, popupMenu, menuItem, mnHelp, popupMenu_1, modTable, listScrollPane}));
		
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
