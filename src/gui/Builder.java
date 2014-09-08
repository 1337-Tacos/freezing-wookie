package gui;

import java.awt.BorderLayout;
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
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.Box;
import java.awt.ScrollPane;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
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
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
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
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
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
