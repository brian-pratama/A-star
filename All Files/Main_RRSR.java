import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import java.awt.TextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;

public class Main_RRSR {

	private JFrame GUI;
	private JTextField txtMap;
	private JTextField textSearchingMethod;
	private JTextField txtRimini;
	private JTextField txtFerrara;
	private JTextField txtForli;
	private JTextField txtRavenna;
	private JTextField txtHRiver;
	private JTextField txtHn;
	private JTextField txtCesena;
	private JTextField txtFaenza;
	private JTextField txtEmilia;
	private JTextField txtImola;
	private JTextField txtTerme;
	private JTextField txtCarpi;
	private JTextField txtPiacenza;
	private JTextField txtBobbia;
	private JTextField txtMapRavenna;
	private JTextField txtMapRimini;
	private JTextField txtMapFerrara;
	private JTextField txtMapForli;
	private JTextField txtMapCesena;
	private JTextField txtMapFaenza;
	private JTextField txtMapBobbia;
	private JTextField txtMapImola;
	private JTextField txtMapEmilia;
	private JTextField txtMapTerme;
	private JTextField txtMapCarpi;
	private JTextField txtMapPiacenza;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtCost;
	private JTextField txtHeuristics;
	private JDesktopPane tabDistance;
	private JSpinner spinnerGRimini;
	private JSpinner spinnerGFerrara;
	private JSpinner spinnerGForli;
	private JSpinner spinnerGRavenna;
	private JTextField txtGRiver;
	private JTextField txtGn;
	private JSpinner spinnerGCesena;
	private JSpinner spinnerGFaenza;
	private JSpinner spinnerGImola;
	private JSpinner spinnerGEmilia;
	private JSpinner spinnerGTerme;
	private JSpinner spinnerGCarpi;
	private JSpinner spinnerGPiacenza;
	private JSpinner spinnerGBobbia;
	private JTextField txtDistances;
	private JButton btnRoute;
	private JButton button;
	private JButton btnClear;
	private String dataLog;

	private double tempValue;
	
	public static mapInfo myMapInfo;
	public static createMap map;
	public static searchingMethod route;
	
	linkedData myMap;
	linkedData.Graph g;
	linkedData.Node node;
	
	private double totalCost;
	private double optimumCost;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//*** System algorithm ***
					myMapInfo = new mapInfo();
					map = new createMap(myMapInfo);
					route = new searchingMethod(map.riverMap());
					
					
					//*** Window ***
					Main_RRSR window = new Main_RRSR();
					window.GUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_RRSR() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		GUI = new JFrame();
		GUI.setResizable(false);
		GUI.setTitle("Romanian River Shortest Route");
		GUI.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Xenom Hercules\\OneDrive\\Documents\\workspace\\Projects\\Java\\Romanian River Shortest Route\\icon.png"));
		GUI.setBounds(100, 100, 1366, 768);
		GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI.getContentPane().setLayout(null);
		
		JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.setBackground(Color.WHITE);
		tabPanel.setBounds(0, 95, 299, 638);
		GUI.getContentPane().add(tabPanel);
		
		JDesktopPane tabMethod = new JDesktopPane();
		tabMethod.setLayout(null);
		tabMethod.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabMethod.setBackground(Color.WHITE);
		tabPanel.addTab("Method", null, tabMethod, null);
		
		textSearchingMethod = new JTextField();
		textSearchingMethod.setText("SEARCHING METHOD");
		textSearchingMethod.setHorizontalAlignment(SwingConstants.CENTER);
		textSearchingMethod.setForeground(Color.WHITE);
		textSearchingMethod.setFont(new Font("Tahoma", Font.BOLD, 18));
		textSearchingMethod.setEditable(false);
		textSearchingMethod.setColumns(10);
		textSearchingMethod.setBackground(Color.RED);
		textSearchingMethod.setBounds(14, 15, 268, 28);
		tabMethod.add(textSearchingMethod);
		
		JRadioButton rdbtnA = new JRadioButton("A*");
		rdbtnA.setSelected(true);
		rdbtnA.setBackground(Color.WHITE);
		rdbtnA.setBounds(14, 52, 127, 25);
		tabMethod.add(rdbtnA);
		
		tabDistance = new JDesktopPane();
		tabDistance.setLayout(null);
		tabDistance.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabDistance.setBackground(Color.WHITE);
		tabPanel.addTab("Distances", null, tabDistance, null);
		
		txtGRiver = new JTextField();
		txtGRiver.setText("River");
		txtGRiver.setHorizontalAlignment(SwingConstants.CENTER);
		txtGRiver.setForeground(Color.WHITE);
		txtGRiver.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtGRiver.setEditable(false);
		txtGRiver.setColumns(10);
		txtGRiver.setBackground(new Color(255, 69, 0));
		txtGRiver.setBounds(12, 54, 184, 28);
		tabDistance.add(txtGRiver);
		
		txtGn = new JTextField();
		txtGn.setText("g(n)");
		txtGn.setHorizontalAlignment(SwingConstants.CENTER);
		txtGn.setForeground(Color.WHITE);
		txtGn.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtGn.setEditable(false);
		txtGn.setColumns(10);
		txtGn.setBackground(new Color(255, 69, 0));
		txtGn.setBounds(208, 54, 74, 28);
		tabDistance.add(txtGn);
		
		txtDistances = new JTextField();
		txtDistances.setText("DISTANCES");
		txtDistances.setHorizontalAlignment(SwingConstants.CENTER);
		txtDistances.setForeground(Color.WHITE);
		txtDistances.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDistances.setEditable(false);
		txtDistances.setColumns(10);
		txtDistances.setBackground(Color.RED);
		txtDistances.setBounds(12, 13, 270, 28);
		tabDistance.add(txtDistances);
		
		JComboBox comboBoxGRavenna = new JComboBox();
		comboBoxGRavenna.setModel(new DefaultComboBoxModel(new String[] {"Ravenna"}));
		comboBoxGRavenna.setBounds(12, 89, 184, 28);
		tabDistance.add(comboBoxGRavenna);
		
		spinnerGRavenna = new JSpinner();
		spinnerGRavenna.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setGRavenna( (double) spinnerGRavenna.getValue() );
			}
		});
		spinnerGRavenna.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGRavenna()), null, null, new Double(1)));
		spinnerGRavenna.setBounds(208, 89, 74, 28);
		tabDistance.add(spinnerGRavenna);
		
		JComboBox comboBoxGRimini = new JComboBox();
		comboBoxGRimini.setModel(new DefaultComboBoxModel(new String[] {"Rimini to Ravenna"}));
		comboBoxGRimini.setBounds(12, 124, 184, 28);
		tabDistance.add(comboBoxGRimini);
		
		spinnerGRimini = new JSpinner();
		spinnerGRimini.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setGRiminiToRavenna( (double) spinnerGRimini.getValue() );
			}
		});
		spinnerGRimini.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGRiminiToRavenna()), null, null, new Double(1)));
		spinnerGRimini.setBounds(208, 124, 74, 28);
		tabDistance.add(spinnerGRimini);
		
		JComboBox comboBoxGFerrara = new JComboBox();
		comboBoxGFerrara.setModel(new DefaultComboBoxModel(new String[] {"Ferrara to Imola", "Ferrara to Ravenna"}));
		comboBoxGFerrara.setBounds(12, 159, 184, 28);
		tabDistance.add(comboBoxGFerrara);
		
		spinnerGFerrara = new JSpinner();
		spinnerGFerrara.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGFerrara.getSelectedItem() == "Ferrara to Imola") {
					myMapInfo.setGFerraraToImola( (double) spinnerGFerrara.getValue() );
				}else {
					myMapInfo.setGFerraraToRavenna( (double) spinnerGFerrara.getValue() );
				}
			}
		});
		spinnerGFerrara.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGFerraraToImola()), null, null, new Double(1)));
		spinnerGFerrara.setBounds(208, 159, 74, 28);
		comboBoxGFerrara.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGFerrara.getSelectedItem() == "Ferrara to Imola"){
					tempValue = myMapInfo.getGFerraraToImola();
				}else {
					tempValue = myMapInfo.getGFerraraToRavenna();
				}
				spinnerGFerrara.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGFerrara);
		
		JComboBox comboBoxGForli = new JComboBox();
		comboBoxGForli.setModel(new DefaultComboBoxModel(new String[] {"Forli to Cesena", "Forli to Ravenna"}));
		comboBoxGForli.setBounds(12, 194, 184, 28);
		tabDistance.add(comboBoxGForli);
		
		spinnerGForli = new JSpinner();
		spinnerGForli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGForli.getSelectedItem() == "Forli to Cesena") {
					myMapInfo.setGForliToCesena( (double) spinnerGForli.getValue() );
				}else {
					myMapInfo.setGForliToRavenna( (double) spinnerGForli.getValue() );
				}
			}
		});
		spinnerGForli.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGForliToCesena()), null, null, new Double(1)));
		spinnerGForli.setBounds(208, 194, 74, 28);
		comboBoxGForli.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGForli.getSelectedItem() == "Forli to Cesena"){
					tempValue = myMapInfo.getGForliToCesena();
				}else {
					tempValue = myMapInfo.getGForliToRavenna();
				}
				spinnerGForli.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGForli);
		
		JComboBox comboBoxGCesena = new JComboBox();
		comboBoxGCesena.setModel(new DefaultComboBoxModel(new String[] {"Cesena to Rimini"}));
		comboBoxGCesena.setBounds(12, 229, 184, 28);
		tabDistance.add(comboBoxGCesena);
		
		spinnerGCesena = new JSpinner();
		spinnerGCesena.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setGCesenaToRimini( (double) spinnerGCesena.getValue() );
			}
		});
		spinnerGCesena.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGCesenaToRimini()), null, null, new Double(1)));
		spinnerGCesena.setBounds(208, 229, 74, 28);
		tabDistance.add(spinnerGCesena);
		
		JComboBox comboBoxGFaenza = new JComboBox();
		comboBoxGFaenza.setModel(new DefaultComboBoxModel(new String[] {"Faenza to Forli", "Faenza to Cesena"}));
		comboBoxGFaenza.setBounds(12, 264, 184, 28);
		tabDistance.add(comboBoxGFaenza);
		
		spinnerGFaenza = new JSpinner();
		spinnerGFaenza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGFaenza.getSelectedItem() == "Faenza to Forli") {
					myMapInfo.setGFaenzaToForli( (double) spinnerGFaenza.getValue() );
				}else {
					myMapInfo.setGFaenzaToCesena( (double) spinnerGFaenza.getValue() );
				}
			}
		});
		spinnerGFaenza.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGFaenzaToForli()), null, null, new Double(1)));
		spinnerGFaenza.setBounds(208, 264, 74, 28);
		comboBoxGFaenza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGFaenza.getSelectedItem() == "Faenza to Forli"){
					tempValue = myMapInfo.getGFaenzaToForli();
				}else {
					tempValue = myMapInfo.getGFaenzaToCesena();
				}
				spinnerGFaenza.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGFaenza);
		
		JComboBox comboBoxGImola = new JComboBox();
		comboBoxGImola.setModel(new DefaultComboBoxModel(new String[] {"Imola to Faenza", "Imola to Forli"}));
		comboBoxGImola.setBounds(12, 299, 184, 28);
		tabDistance.add(comboBoxGImola);
		
		spinnerGImola = new JSpinner();
		spinnerGImola.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGImola.getSelectedItem() == "Imola to Faenza") {
					myMapInfo.setGImolaToFaenza( (double) spinnerGImola.getValue() );
				}else {
					myMapInfo.setGImolaToForli( (double) spinnerGImola.getValue() );
				}
			}
		});
		spinnerGImola.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGImolaToFaenza()), null, null, new Double(1)));
		spinnerGImola.setBounds(208, 299, 74, 28);
		comboBoxGImola.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGImola.getSelectedItem() == "Imola to Faenza"){
					tempValue = myMapInfo.getGImolaToFaenza();
				}else {
					tempValue = myMapInfo.getGImolaToForli();
				}
				spinnerGImola.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGImola);
		
		JComboBox comboBoxGEmilia = new JComboBox();
		comboBoxGEmilia.setModel(new DefaultComboBoxModel(new String[] {"Emilia to Imola"}));
		comboBoxGEmilia.setBounds(12, 334, 184, 28);
		tabDistance.add(comboBoxGEmilia);
		
		spinnerGEmilia = new JSpinner();
		spinnerGEmilia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setGEmiliaToImola( (double) spinnerGEmilia.getValue() );
			}
		});
		spinnerGEmilia.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGEmiliaToImola()), null, null, new Double(1)));
		spinnerGEmilia.setBounds(208, 334, 74, 28);
		tabDistance.add(spinnerGEmilia);
		
		JComboBox comboBoxGTerme = new JComboBox();
		comboBoxGTerme.setModel(new DefaultComboBoxModel(new String[] {"Terme to Emilia", "Terme to Faenza"}));
		comboBoxGTerme.setBounds(12, 369, 184, 28);
		tabDistance.add(comboBoxGTerme);
		
		spinnerGTerme = new JSpinner();
		spinnerGTerme.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (comboBoxGTerme.getSelectedItem() == "Terme to Emilia") {
					myMapInfo.setGTermeToEmilia( (double) spinnerGTerme.getValue() );
				}else {
					myMapInfo.setGTermeToFaenza( (double) spinnerGTerme.getValue() );
				}
			}
		});
		spinnerGTerme.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGTermeToEmilia()), null, null, new Double(1)));
		spinnerGTerme.setBounds(208, 369, 74, 28);
		comboBoxGTerme.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGTerme.getSelectedItem() == "Terme to Emilia"){
					tempValue = myMapInfo.getGTermeToEmilia();
				}else {
					tempValue = myMapInfo.getGTermeToFaenza();
				}
				spinnerGTerme.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGTerme);
		
		JComboBox comboBoxGCarpi = new JComboBox();
		comboBoxGCarpi.setModel(new DefaultComboBoxModel(new String[] {"Carpi to Emilia", "Carpi to Ferrara"}));
		comboBoxGCarpi.setBounds(12, 404, 184, 28);
		tabDistance.add(comboBoxGCarpi);
		
		spinnerGCarpi = new JSpinner();
		spinnerGCarpi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (comboBoxGCarpi.getSelectedItem() == "Carpi to Emilia") {
					myMapInfo.setGCarpiToEmilia( (double) spinnerGCarpi.getValue() );
				}else {
					myMapInfo.setGCarpiToFerrara( (double) spinnerGCarpi.getValue() );
				}
			}
		});
		spinnerGCarpi.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGCarpiToEmilia()), null, null, new Double(1)));
		spinnerGCarpi.setBounds(208, 404, 74, 28);
		comboBoxGCarpi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGCarpi.getSelectedItem() == "Carpi to Emilia"){
					tempValue = myMapInfo.getGCarpiToEmilia();
				}else {
					tempValue = myMapInfo.getGCarpiToFerrara();
				}
				spinnerGCarpi.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGCarpi);
		
		JComboBox comboBoxGPiacenza = new JComboBox();
		comboBoxGPiacenza.setModel(new DefaultComboBoxModel(new String[] {"Piacenza to Carpi", "Piacenza to Terme"}));
		comboBoxGPiacenza.setBounds(12, 439, 184, 28);
		tabDistance.add(comboBoxGPiacenza);
		
		spinnerGPiacenza = new JSpinner();
		spinnerGPiacenza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGPiacenza.getSelectedItem() == "Piacenza to Carpi") {
					myMapInfo.setGPiacenzaToCarpi( (double) spinnerGPiacenza.getValue() );
				}else {
					myMapInfo.setGPiacenzaToTerme( (double) spinnerGPiacenza.getValue() );
				}
			}
		});
		spinnerGPiacenza.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGPiacenzaToCarpi()), null, null, new Double(1)));
		spinnerGPiacenza.setBounds(208, 439, 74, 28);
		comboBoxGPiacenza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGPiacenza.getSelectedItem() == "Piacenza to Carpi"){
					tempValue = myMapInfo.getGPiacenzaToCarpi();
				}else {
					tempValue = myMapInfo.getGPiacenzaToTerme();
				}
				spinnerGPiacenza.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGPiacenza);
		
		JComboBox comboBoxGBobbia = new JComboBox();
		comboBoxGBobbia.setModel(new DefaultComboBoxModel(new String[] {"Bobbia to Piacenza", "Bobbia to Terme", "Bobbia to Cesena"}));
		comboBoxGBobbia.setBounds(12, 474, 184, 28);
		tabDistance.add(comboBoxGBobbia);
		
		spinnerGBobbia = new JSpinner();
		spinnerGBobbia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (comboBoxGBobbia.getSelectedItem() == "Bobbia to Piacenza") {
					myMapInfo.setGBobbiaToPiacenza( (double) spinnerGBobbia.getValue() );
				}else if (comboBoxGBobbia.getSelectedItem() == "Bobbia to Terme"){
					myMapInfo.setGBobbiaToTerme( (double) spinnerGBobbia.getValue() );
				}else {
					myMapInfo.setGBobbiaToCesena( (double) spinnerGBobbia.getValue() );
				}
			}
		});
		spinnerGBobbia.setModel(new SpinnerNumberModel(new Double(myMapInfo.getGBobbiaToPiacenza()), null, null, new Double(1)));
		spinnerGBobbia.setBounds(208, 474, 74, 28);
		comboBoxGBobbia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(comboBoxGBobbia.getSelectedItem() == "Bobbia to Piacenza"){
					tempValue = myMapInfo.getGBobbiaToPiacenza();
				}else if (comboBoxGBobbia.getSelectedItem() == "Bobbia to Terme"){
					tempValue = myMapInfo.getGBobbiaToTerme();
				}else {
					tempValue = myMapInfo.getGBobbiaToCesena();
				}
				spinnerGBobbia.setValue(new Double(tempValue));
			}
		});
		tabDistance.add(spinnerGBobbia);
		
		JButton btnApply = new JButton("APPLY");
		btnApply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				map = new createMap(myMapInfo);
				route = new searchingMethod(map.riverMap());
			}
		});
		btnApply.setForeground(Color.DARK_GRAY);
		btnApply.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnApply.setBounds(77, 561, 141, 34);
		tabDistance.add(btnApply);
		
		JDesktopPane tabCost = new JDesktopPane();
		tabCost.setLayout(null);
		tabCost.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		tabCost.setBackground(Color.WHITE);
		tabPanel.addTab("Heuristics", null, tabCost, null);
		
		txtRimini = new JTextField();
		txtRimini.setHorizontalAlignment(SwingConstants.CENTER);
		txtRimini.setText("Rimini");
		txtRimini.setForeground(Color.WHITE);
		txtRimini.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtRimini.setEditable(false);
		txtRimini.setColumns(10);
		txtRimini.setBackground(Color.GRAY);
		txtRimini.setBounds(12, 124, 184, 28);
		tabCost.add(txtRimini);
		
		JSpinner spinner_hRimini = new JSpinner();
		spinner_hRimini.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHRimini((double) spinner_hRimini.getValue());
			}
		});
		spinner_hRimini.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHRimini()), new Double(0), null, new Double(1)));
		spinner_hRimini.setBounds(208, 124, 74, 28);
		tabCost.add(spinner_hRimini);
		
		txtFerrara = new JTextField();
		txtFerrara.setHorizontalAlignment(SwingConstants.CENTER);
		txtFerrara.setText("Ferrara");
		txtFerrara.setForeground(Color.WHITE);
		txtFerrara.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFerrara.setEditable(false);
		txtFerrara.setColumns(10);
		txtFerrara.setBackground(Color.GRAY);
		txtFerrara.setBounds(12, 159, 184, 28);
		tabCost.add(txtFerrara);
		
		JSpinner spinner_hFerrara = new JSpinner();
		spinner_hFerrara.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHFerrara((double) spinner_hFerrara.getValue());
			}
		});
		spinner_hFerrara.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHFerrara()), new Double(0), null, new Double(1)));
		spinner_hFerrara.setBounds(208, 159, 74, 28);
		tabCost.add(spinner_hFerrara);
		
		txtForli = new JTextField();
		txtForli.setHorizontalAlignment(SwingConstants.CENTER);
		txtForli.setText("Forli");
		txtForli.setForeground(Color.WHITE);
		txtForli.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtForli.setEditable(false);
		txtForli.setColumns(10);
		txtForli.setBackground(Color.GRAY);
		txtForli.setBounds(12, 194, 184, 28);
		tabCost.add(txtForli);
		
		JSpinner spinner_hForli = new JSpinner();
		spinner_hForli.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHForli((double) spinner_hForli.getValue());
			}
		});
		spinner_hForli.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHForli()), new Double(0), null, new Double(1)));
		spinner_hForli.setBounds(208, 194, 74, 28);
		tabCost.add(spinner_hForli);
		
		txtRavenna = new JTextField();
		txtRavenna.setHorizontalAlignment(SwingConstants.CENTER);
		txtRavenna.setText("Ravenna");
		txtRavenna.setForeground(Color.WHITE);
		txtRavenna.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtRavenna.setEditable(false);
		txtRavenna.setColumns(10);
		txtRavenna.setBackground(Color.GRAY);
		txtRavenna.setBounds(12, 89, 184, 28);
		tabCost.add(txtRavenna);
		
		JSpinner spinner_hRavenna = new JSpinner();
		spinner_hRavenna.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				myMapInfo.setHRavenna( (double) spinner_hRavenna.getValue() );
			}
		});
		spinner_hRavenna.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHRavenna()), new Double(0), null, new Double(1)));
		spinner_hRavenna.setBounds(208, 89, 74, 28);
		tabCost.add(spinner_hRavenna);
		
		txtHRiver = new JTextField();
		txtHRiver.setHorizontalAlignment(SwingConstants.CENTER);
		txtHRiver.setText("River");
		txtHRiver.setForeground(Color.WHITE);
		txtHRiver.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtHRiver.setEditable(false);
		txtHRiver.setColumns(10);
		txtHRiver.setBackground(new Color(255, 69, 0));
		txtHRiver.setBounds(12, 54, 184, 28);
		tabCost.add(txtHRiver);
		
		txtHn = new JTextField();
		txtHn.setText("h(n)");
		txtHn.setHorizontalAlignment(SwingConstants.CENTER);
		txtHn.setForeground(Color.WHITE);
		txtHn.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtHn.setEditable(false);
		txtHn.setColumns(10);
		txtHn.setBackground(new Color(255, 69, 0));
		txtHn.setBounds(208, 54, 74, 28);
		tabCost.add(txtHn);
		
		txtCesena = new JTextField();
		txtCesena.setHorizontalAlignment(SwingConstants.CENTER);
		txtCesena.setText("Cesena");
		txtCesena.setForeground(Color.WHITE);
		txtCesena.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCesena.setEditable(false);
		txtCesena.setColumns(10);
		txtCesena.setBackground(Color.GRAY);
		txtCesena.setBounds(12, 229, 184, 28);
		tabCost.add(txtCesena);
		
		txtFaenza = new JTextField();
		txtFaenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtFaenza.setText("Faenza");
		txtFaenza.setForeground(Color.WHITE);
		txtFaenza.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtFaenza.setEditable(false);
		txtFaenza.setColumns(10);
		txtFaenza.setBackground(Color.GRAY);
		txtFaenza.setBounds(12, 264, 184, 28);
		tabCost.add(txtFaenza);
		
		txtEmilia = new JTextField();
		txtEmilia.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmilia.setText("Emilia");
		txtEmilia.setForeground(Color.WHITE);
		txtEmilia.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEmilia.setEditable(false);
		txtEmilia.setColumns(10);
		txtEmilia.setBackground(Color.GRAY);
		txtEmilia.setBounds(12, 334, 184, 28);
		tabCost.add(txtEmilia);
		
		txtImola = new JTextField();
		txtImola.setHorizontalAlignment(SwingConstants.CENTER);
		txtImola.setText("Imola");
		txtImola.setForeground(Color.WHITE);
		txtImola.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtImola.setEditable(false);
		txtImola.setColumns(10);
		txtImola.setBackground(Color.GRAY);
		txtImola.setBounds(12, 299, 184, 28);
		tabCost.add(txtImola);
		
		JSpinner spinner_hCesena = new JSpinner();
		spinner_hCesena.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHCesena((double) spinner_hCesena.getValue());
			}
		});
		spinner_hCesena.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHCesena()), new Double(0), null, new Double(1)));
		spinner_hCesena.setBounds(208, 229, 74, 28);
		tabCost.add(spinner_hCesena);
		
		JSpinner spinner_hFaenza = new JSpinner();
		spinner_hFaenza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHFaenza((double) spinner_hFaenza.getValue());
			}
		});
		spinner_hFaenza.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHFaenza()), new Double(0), null, new Double(1)));
		spinner_hFaenza.setBounds(208, 264, 74, 28);
		tabCost.add(spinner_hFaenza);
		
		JSpinner spinner_hImola = new JSpinner();
		spinner_hImola.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHImola((double) spinner_hImola.getValue());
			}
		});
		spinner_hImola.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHImola()), new Double(0), null, new Double(1)));
		spinner_hImola.setBounds(208, 299, 74, 28);
		tabCost.add(spinner_hImola);
		
		JSpinner spinner_hEmilia = new JSpinner();
		spinner_hEmilia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHEmilia((double) spinner_hEmilia.getValue());
			}
		});
		spinner_hEmilia.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHEmilia()), new Double(0), null, new Double(1)));
		spinner_hEmilia.setBounds(208, 334, 74, 28);
		tabCost.add(spinner_hEmilia);
		
		txtTerme = new JTextField();
		txtTerme.setHorizontalAlignment(SwingConstants.CENTER);
		txtTerme.setText("Terme");
		txtTerme.setForeground(Color.WHITE);
		txtTerme.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTerme.setEditable(false);
		txtTerme.setColumns(10);
		txtTerme.setBackground(Color.GRAY);
		txtTerme.setBounds(12, 369, 184, 28);
		tabCost.add(txtTerme);
		
		txtCarpi = new JTextField();
		txtCarpi.setHorizontalAlignment(SwingConstants.CENTER);
		txtCarpi.setText("Carpi");
		txtCarpi.setForeground(Color.WHITE);
		txtCarpi.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCarpi.setEditable(false);
		txtCarpi.setColumns(10);
		txtCarpi.setBackground(Color.GRAY);
		txtCarpi.setBounds(12, 404, 184, 28);
		tabCost.add(txtCarpi);
		
		txtPiacenza = new JTextField();
		txtPiacenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtPiacenza.setText("Piacenza");
		txtPiacenza.setForeground(Color.WHITE);
		txtPiacenza.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtPiacenza.setEditable(false);
		txtPiacenza.setColumns(10);
		txtPiacenza.setBackground(Color.GRAY);
		txtPiacenza.setBounds(12, 439, 184, 28);
		tabCost.add(txtPiacenza);
		
		txtBobbia = new JTextField();
		txtBobbia.setHorizontalAlignment(SwingConstants.CENTER);
		txtBobbia.setText("Bobbia");
		txtBobbia.setForeground(Color.WHITE);
		txtBobbia.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtBobbia.setEditable(false);
		txtBobbia.setColumns(10);
		txtBobbia.setBackground(Color.GRAY);
		txtBobbia.setBounds(12, 474, 184, 28);
		tabCost.add(txtBobbia);
		
		JSpinner spinner_hTerme = new JSpinner();
		spinner_hTerme.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHTerme((double) spinner_hTerme.getValue());
			}
		});
		spinner_hTerme.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHTerme()), new Double(0), null, new Double(1)));
		spinner_hTerme.setBounds(208, 369, 74, 28);
		tabCost.add(spinner_hTerme);
		
		JSpinner spinner_hCarpi = new JSpinner();
		spinner_hCarpi.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHCarpi((double) spinner_hCarpi.getValue());
			}
		});
		spinner_hCarpi.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHCarpi()), new Double(0), null, new Double(1)));
		spinner_hCarpi.setBounds(208, 404, 74, 28);
		tabCost.add(spinner_hCarpi);
		
		JSpinner spinner_hPiacenza = new JSpinner();
		spinner_hPiacenza.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHPiacenza((double) spinner_hPiacenza.getValue());
			}
		});
		spinner_hPiacenza.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHPiacenza()), new Double(0), null, new Double(1)));
		spinner_hPiacenza.setBounds(208, 439, 74, 28);
		tabCost.add(spinner_hPiacenza);
		
		JSpinner spinner_hBobbia = new JSpinner();
		spinner_hBobbia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				myMapInfo.setHBobbia((double) spinner_hBobbia.getValue());
			}
		});
		spinner_hBobbia.setModel(new SpinnerNumberModel(new Double(myMapInfo.getHBobbia()), new Double(0), null, new Double(1)));
		spinner_hBobbia.setBounds(208, 474, 74, 28);
		tabCost.add(spinner_hBobbia);
		
		txtHeuristics = new JTextField();
		txtHeuristics.setText("HEURISTICS");
		txtHeuristics.setHorizontalAlignment(SwingConstants.CENTER);
		txtHeuristics.setForeground(Color.WHITE);
		txtHeuristics.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtHeuristics.setEditable(false);
		txtHeuristics.setColumns(10);
		txtHeuristics.setBackground(Color.RED);
		txtHeuristics.setBounds(12, 13, 270, 28);
		tabCost.add(txtHeuristics);
		
		button = new JButton("APPLY");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				map = new createMap(myMapInfo);
				route = new searchingMethod(map.riverMap());
			}
		});
		button.setForeground(Color.DARK_GRAY);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(77, 561, 141, 34);
		tabCost.add(button);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setLayout(null);
		desktopPane_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		desktopPane_1.setBackground(Color.WHITE);
		tabPanel.addTab("Cost", null, desktopPane_1, null);
		
		textField = new JTextField();
		textField.setToolTipText("Total Cost");
		textField.setText("Total");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(12, 61, 126, 28);
		desktopPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Optimal Cost");
		textField_1.setText("Optimal");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(12, 95, 126, 28);
		desktopPane_1.add(textField_1);
		
		TextField txtTotalCost = new TextField();;
		txtTotalCost.setEditable(false);
		txtTotalCost.setBounds(144, 61, 140, 28);
		desktopPane_1.add(txtTotalCost);
		
		TextField txtOptimumCost = new TextField();
		txtOptimumCost.setEditable(false);
		txtOptimumCost.setBounds(144, 95, 138, 28);
		desktopPane_1.add(txtOptimumCost);
		
		txtCost = new JTextField();
		txtCost.setText("COST");
		txtCost.setHorizontalAlignment(SwingConstants.CENTER);
		txtCost.setForeground(Color.WHITE);
		txtCost.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCost.setEditable(false);
		txtCost.setColumns(10);
		txtCost.setBackground(Color.RED);
		txtCost.setBounds(12, 13, 272, 28);
		desktopPane_1.add(txtCost);
		
		JDesktopPane Stage = new JDesktopPane();
		Stage.setLayout(null);
		Stage.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Stage.setBackground(Color.WHITE);
		Stage.setBounds(311, 95, 1049, 638);
		GUI.getContentPane().add(Stage);
		
		//Stage.getGraphics().drawLine(50, 378, 12, 137);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Panel.background"));
		desktopPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		desktopPane.setBounds(12, 601, 1025, 37);
		Stage.add(desktopPane);
		
		dataLog = "";
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setBounds(12, 37, 1001, 525);
		desktopPane.add(scrollPane);
		
		JTextPane txtLog = new JTextPane();
		txtLog.setEditable(false);
		scrollPane.setViewportView(txtLog);
		
		JButton btnMap = new JButton("Map");
		btnMap.setForeground(Color.DARK_GRAY);
		btnMap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataLog = dataLog + map.printData(map.riverMap());
				txtLog.setText( dataLog );
			}
		});
		btnMap.setBounds(12, 7, 88, 25);
		desktopPane.add(btnMap);
		
		btnRoute = new JButton("Route");
		btnRoute.setForeground(Color.DARK_GRAY);
		btnRoute.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				route.A_star();
				dataLog = dataLog + route.getData();
				totalCost = route.getTotalCost();
				optimumCost = route.getOptimumCost();
				txtTotalCost.setText( String.valueOf(totalCost) );
				txtOptimumCost.setText( String.valueOf(optimumCost) );
				txtLog.setText( dataLog );
			}
		});
		btnRoute.setBounds(101, 7, 88, 25);
		desktopPane.add(btnRoute);
		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataLog = "";
				txtLog.setText( dataLog );
			}
		});
		btnClear.setForeground(Color.DARK_GRAY);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(191, 7, 88, 25);
		desktopPane.add(btnClear);
		
		JButton btnShowLog = new JButton("Show Log");
		btnShowLog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (btnShowLog.getText() == "Show Log") {
					desktopPane.setBounds(12, 63, 1025, 575);
					btnShowLog.setText("Hide Log");
				}
				else if (btnShowLog.getText() == "Hide Log") {
					desktopPane.setBounds(12, 601, 1025, 37);
					btnShowLog.setText("Show Log");
					
				}
			}
		});
		btnShowLog.setForeground(Color.DARK_GRAY);
		btnShowLog.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShowLog.setBounds(884, 7, 129, 25);
		desktopPane.add(btnShowLog);
		
		txtMap = new JTextField();
		txtMap.setText("MAP");
		txtMap.setHorizontalAlignment(SwingConstants.CENTER);
		txtMap.setForeground(Color.WHITE);
		txtMap.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtMap.setEditable(false);
		txtMap.setColumns(10);
		txtMap.setBackground(Color.RED);
		txtMap.setBounds(12, 13, 1025, 37);
		Stage.add(txtMap);
		
		txtMapRavenna = new JTextField();
		txtMapRavenna.setText("Ravenna");
		txtMapRavenna.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapRavenna.setForeground(Color.WHITE);
		txtMapRavenna.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapRavenna.setEditable(false);
		txtMapRavenna.setColumns(10);
		txtMapRavenna.setBackground(new Color(255, 69, 0));
		txtMapRavenna.setBounds(891, 233, 90, 37);
		Stage.add(txtMapRavenna);
		
		txtMapRimini = new JTextField();
		txtMapRimini.setText("Rimini");
		txtMapRimini.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapRimini.setForeground(Color.WHITE);
		txtMapRimini.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapRimini.setEditable(false);
		txtMapRimini.setColumns(10);
		txtMapRimini.setBackground(Color.BLUE);
		txtMapRimini.setBounds(947, 352, 90, 37);
		Stage.add(txtMapRimini);
		
		txtMapFerrara = new JTextField();
		txtMapFerrara.setText("Ferrara");
		txtMapFerrara.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapFerrara.setForeground(Color.WHITE);
		txtMapFerrara.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapFerrara.setEditable(false);
		txtMapFerrara.setColumns(10);
		txtMapFerrara.setBackground(Color.BLUE);
		txtMapFerrara.setBounds(637, 137, 90, 37);
		Stage.add(txtMapFerrara);
		
		txtMapForli = new JTextField();
		txtMapForli.setText("Forli");
		txtMapForli.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapForli.setForeground(Color.WHITE);
		txtMapForli.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapForli.setEditable(false);
		txtMapForli.setColumns(10);
		txtMapForli.setBackground(Color.BLUE);
		txtMapForli.setBounds(637, 352, 90, 37);
		Stage.add(txtMapForli);
		
		txtMapCesena = new JTextField();
		txtMapCesena.setText("Cesena");
		txtMapCesena.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapCesena.setForeground(Color.WHITE);
		txtMapCesena.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapCesena.setEditable(false);
		txtMapCesena.setColumns(10);
		txtMapCesena.setBackground(Color.BLUE);
		txtMapCesena.setBounds(689, 453, 90, 37);
		Stage.add(txtMapCesena);
		
		txtMapFaenza = new JTextField();
		txtMapFaenza.setText("Faenza");
		txtMapFaenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapFaenza.setForeground(Color.WHITE);
		txtMapFaenza.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapFaenza.setEditable(false);
		txtMapFaenza.setColumns(10);
		txtMapFaenza.setBackground(Color.BLUE);
		txtMapFaenza.setBounds(442, 309, 90, 37);
		Stage.add(txtMapFaenza);
		
		txtMapBobbia = new JTextField();
		txtMapBobbia.setText("Bobbia");
		txtMapBobbia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapBobbia.setForeground(Color.WHITE);
		txtMapBobbia.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapBobbia.setEditable(false);
		txtMapBobbia.setColumns(10);
		txtMapBobbia.setBackground(new Color(255, 215, 0));
		txtMapBobbia.setBounds(50, 378, 90, 37);
		Stage.add(txtMapBobbia);
		
		txtMapImola = new JTextField();
		txtMapImola.setText("Imola");
		txtMapImola.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapImola.setForeground(Color.WHITE);
		txtMapImola.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapImola.setEditable(false);
		txtMapImola.setColumns(10);
		txtMapImola.setBackground(Color.BLUE);
		txtMapImola.setBounds(442, 210, 90, 37);
		Stage.add(txtMapImola);
		
		txtMapEmilia = new JTextField();
		txtMapEmilia.setText("Emilia");
		txtMapEmilia.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapEmilia.setForeground(Color.WHITE);
		txtMapEmilia.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapEmilia.setEditable(false);
		txtMapEmilia.setColumns(10);
		txtMapEmilia.setBackground(Color.BLUE);
		txtMapEmilia.setBounds(312, 157, 90, 37);
		Stage.add(txtMapEmilia);
		
		txtMapTerme = new JTextField();
		txtMapTerme.setText("Terme");
		txtMapTerme.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapTerme.setForeground(Color.WHITE);
		txtMapTerme.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapTerme.setEditable(false);
		txtMapTerme.setColumns(10);
		txtMapTerme.setBackground(Color.BLUE);
		txtMapTerme.setBounds(224, 249, 90, 37);
		Stage.add(txtMapTerme);
		
		txtMapCarpi = new JTextField();
		txtMapCarpi.setText("Carpi");
		txtMapCarpi.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapCarpi.setForeground(Color.WHITE);
		txtMapCarpi.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapCarpi.setEditable(false);
		txtMapCarpi.setColumns(10);
		txtMapCarpi.setBackground(Color.BLUE);
		txtMapCarpi.setBounds(224, 65, 90, 37);
		Stage.add(txtMapCarpi);
		
		txtMapPiacenza = new JTextField();
		txtMapPiacenza.setText("Piacenza");
		txtMapPiacenza.setHorizontalAlignment(SwingConstants.CENTER);
		txtMapPiacenza.setForeground(Color.WHITE);
		txtMapPiacenza.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtMapPiacenza.setEditable(false);
		txtMapPiacenza.setColumns(10);
		txtMapPiacenza.setBackground(Color.BLUE);
		txtMapPiacenza.setBounds(12, 137, 90, 37);
		Stage.add(txtMapPiacenza);
		
		JDesktopPane Header = new JDesktopPane();
		Header.setLayout(null);
		Header.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		Header.setBackground(Color.WHITE);
		Header.setBounds(0, 0, 1360, 57);
		GUI.getContentPane().add(Header);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("C:\\Users\\Xenom Hercules\\OneDrive\\Documents\\workspace\\Projects\\Java\\Romanian River Shortest Route\\icon.png"));
		Logo.setBounds(0, 0, 50, 57);
		Header.add(Logo);
		
		JLabel lblRrsrRomanian = new JLabel("RRSR - Romanian River Shortest Route");
		lblRrsrRomanian.setForeground(Color.RED);
		lblRrsrRomanian.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRrsrRomanian.setBounds(59, 13, 359, 31);
		Header.add(lblRrsrRomanian);
		
		JLabel myIdentity = new JLabel("IF 37 03 - ARTIFICIAL INTELLIGENCE - by FEBRIAN ADHI PRATAMA");
		myIdentity.setHorizontalAlignment(SwingConstants.TRAILING);
		myIdentity.setForeground(Color.RED);
		myIdentity.setFont(new Font("Tahoma", Font.BOLD, 18));
		myIdentity.setBounds(738, 13, 610, 31);
		Header.add(myIdentity);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 57, 1360, 32);
		GUI.getContentPane().add(toolBar);
	}
	
	public void systemAlgorithm(){
	}
}
