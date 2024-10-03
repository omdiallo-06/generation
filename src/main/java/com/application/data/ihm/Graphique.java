package com.application.data.ihm;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import org.apache.log4j.Logger;

import com.application.data.excel.EtatFinancier;
import com.application.data.excel.utils.LectureDesFichiersDunDossier;
import com.application.data.excel.utils.Rendu;
import com.application.data.excel.utils.RenduSansIcone;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.factories.Paddings;
//import com.jgoodies.forms.factories.FormSpecs;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.looks.Options;

public class Graphique implements MouseListener,ActionListener{

	private JFrame frame;
	//private JFrame frame2;
	private JFileChooser jFileChooser;
	private FormLayout formLayout;
	private JPanel jPanel;
	
	private JLabel jLabelPathMasqueSaisie;
	private JTextField jTextFieldPathMasqueSaisie;
	private JButton jButtonPathMasqueSaisie;
	private JProgressBar progressBar;
	private JList<String> jListMasqueSaisie;
	private JList<String> jListMasqueSaisieATraite;
	private ArrayListModel<String> listeMasqueSaisie=new ArrayListModel<String>();
	private ArrayListModel<String> listeMasqueSaisieATraite=new ArrayListModel<String>();
	private JScrollPane jScrollPaneMS;
	private JScrollPane jScrollPaneMST;
	
	private LectureDesFichiersDunDossier ldf;
	private String pathMasqueDeSaisie;
	private JLabel jLabelTitle;
	private JButton btnGenerer;
	private JButton jButtonAddAll;
	private JButton jButtonRemoveSelected;
	private JButton jButtonRemoveAll;
	private JButton jButtonAddSelected;
	
	private JRadioButton jCheckBoxAnnuel;
	private JRadioButton jCheckBoxPeriodique;
	private ButtonGroup checkGroup = new ButtonGroup();
	static Logger log= Logger.getLogger("org");
	private JLabel lblNewLabel;
	private JLabel lblFichiersGnrer;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphique window = new Graphique();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					log.error(e.getMessage(),e);
				}
			}
		});
	}

	 private void configureUI() {
		 UIManager.put(Options.USE_SYSTEM_FONTS_APP_KEY, Boolean.TRUE);
	     Options.setDefaultIconSize(new Dimension(18, 18));
	     Options.setUseNarrowButtons(true);
	     Options.setTabIconsEnabled(true);
	     try {
	       	UIManager.setLookAndFeel(Options.PLASTICXP_NAME);
	     } catch (Exception e) {
	    	 log.error(e.getMessage(),e);
	        JOptionPane.showMessageDialog(getJFrame(), "Can't set look & feel:" + e, "Erreur graphique", JOptionPane.ERROR_MESSAGE);//("Can't set look & feel:" + e);
	     }
	  }
	 
	/**
	 * Create the application.
	 */
	public Graphique() {
		configureUI();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setOpacity(1f);
		frame.setBounds(100, 100, 690, 686);
		System.out.println(this.getClass().getClassLoader().getResourceAsStream("generateur.jpg"));
		System.out.println(this.getClass().getClassLoader().getResource("resources/generateur.jpg"));
		System.out.println(this.getClass().getClassLoader().getResource("/resources/generateur.jpg"));
		System.out.println("==========================");
		
		System.out.println(ClassLoader.getSystemClassLoader().getResourceAsStream("generateur.jpg"));
		System.out.println(ClassLoader.getSystemClassLoader().getResource("resources/generateur.jpg"));
		System.out.println(ClassLoader.getSystemClassLoader().getResource("/generateur.jpg"));
		frame.setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("generateur.jpg")).getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(getJPane());
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	public JPanel getJPane(){
		if(jPanel==null){
			jPanel = new JPanel(getFormLayout());
			jPanel.setBackground(Color.WHITE);
			//jPanel.setBorder(Borders.DIALOGDIALOG_BORDER);
			jPanel.setBorder(Paddings.DIALOG);
			jPanel.setVisible(true);
			checkGroup.add(getJCheckBoxPeriodique());
			checkGroup.add(getJCheckBoxAnnuel());
			jPanel.add(getJLabelTitle(), "17, 1, 31, 3, center, default");
			jPanel.add(getJLabelPathMasqueSaisie(),     "3, 5, 13, 1, center, default");
			jPanel.add(getJTextFieldPathMasqueSaisie(), "19, 5, 21, 1");
			jPanel.add(getJButtonPathMasqueSaisie()   , "49, 5, 5, 1, right, center");
			jPanel.add(getJCheckBoxPeriodique(),"23, 7, 27, 1, left, center,");
			jPanel.add(getJCheckBoxAnnuel(),"23, 9, 27, 1, left, center");
			jPanel.add(getBtnGenerer(), "23, 11, 11, 1");
			jPanel.add(getJScrollPaneMS(),         "3, 13, 20, 23, fill, fill");
			jPanel.add(getJScrollPaneMST(),        "35, 13, 19, 23, fill, fill");
			jPanel.add(getJButtonAddSelected(),    "25, 19, 7, 1");
			jPanel.add(getJButtonAddAll(),         "25, 21, 7, 1, default, top");
			jPanel.add(getJButtonRemoveSelected(), "25, 23, 7, 1");
			jPanel.add(getJButtonRemoveAll(),      "25, 25, 7, 1");
			jPanel.add(getProgressBar(),           "3, 38, 51, 3");
			montreCacheElement(false);
		}
		return jPanel;
	}
	
	public JFrame getJFrame(){
		if(frame==null){
			
		}
		return frame;
	}

	public JFileChooser getJFileChooser(){
		if(jFileChooser==null){
			jFileChooser=new JFileChooser(".");
			jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jFileChooser.addActionListener(this);
			jFileChooser.setApproveButtonText("Choisir Repertoire");
		}
		return jFileChooser;
	}
	
	public FormLayout getFormLayout(){
		if(formLayout==null){
			formLayout=new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("left:default"),
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),
					FormSpecs.RELATED_GAP_COLSPEC,
					ColumnSpec.decode("max(10dlu;default)"),},
				new RowSpec[] {
					RowSpec.decode("max(20dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref):grow"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;default)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.PARAGRAPH_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.RELATED_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),
					FormSpecs.LINE_GAP_ROWSPEC,
					RowSpec.decode("max(10dlu;pref)"),});
		}
		return formLayout;
	}
	
	public JButton getJButtonPathMasqueSaisie(){
		if(jButtonPathMasqueSaisie==null){
			jButtonPathMasqueSaisie=new JButton("Choisir le répertoire");
			jButtonPathMasqueSaisie.addActionListener(this);
		}
		return jButtonPathMasqueSaisie;
	}
	
	public JLabel getJLabelPathMasqueSaisie(){
		if(jLabelPathMasqueSaisie==null){
			jLabelPathMasqueSaisie=new JLabel("Repertoire Masque(s) de Saisie");
		}
		return jLabelPathMasqueSaisie;		
	}
	
	public JTextField getJTextFieldPathMasqueSaisie(){
		if(jTextFieldPathMasqueSaisie==null){
			jTextFieldPathMasqueSaisie=new JTextField();
			jTextFieldPathMasqueSaisie.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			jTextFieldPathMasqueSaisie.setEnabled(false);
		}
		return jTextFieldPathMasqueSaisie;		
	}


	public JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar(0,100);
			progressBar.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			progressBar.setForeground(UIManager.getColor("CheckBox.focus"));
			progressBar.setStringPainted(true);		
			progressBar.setBackground(Color.WHITE);
		}
		return progressBar;
	}
	
	@SuppressWarnings("unchecked")
	public JList<String> getJListMasqueSaisie(){
		if(jListMasqueSaisie==null){
			jListMasqueSaisie=new JList<String>();
			jListMasqueSaisie.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			jListMasqueSaisie.setCellRenderer(new RenduSansIcone());
			jListMasqueSaisie.setModel(getListeMasqueSaisie());
		}
		return jListMasqueSaisie;
	}
	
	@SuppressWarnings("unchecked")
	public JList<String> getJListMasqueSaisieATraite(){
		if(jListMasqueSaisieATraite==null){
			jListMasqueSaisieATraite=new JList<String>();
			jListMasqueSaisieATraite.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			jListMasqueSaisieATraite.setCellRenderer(new RenduSansIcone());
			jListMasqueSaisie.setModel(getListeMasqueSaisieATraite());
		}
		return jListMasqueSaisieATraite;
	}
	
	public JScrollPane getJScrollPaneMS(){
		if(jScrollPaneMS==null){
			jScrollPaneMS=new JScrollPane(getJListMasqueSaisie());
			jScrollPaneMS.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			jScrollPaneMS.setColumnHeaderView(getLblNewLabel());
		}
		return jScrollPaneMS;
	}
	
	public JScrollPane getJScrollPaneMST(){
		if(jScrollPaneMST==null){
			jScrollPaneMST=new JScrollPane(getJListMasqueSaisieATraite());
			jScrollPaneMST.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 204, 255), null, new Color(153, 204, 255), null));
			jScrollPaneMST.setColumnHeaderView(getLblFichiersGnrer());
			//jScrollPaneMST=new JScrollPane();
		}
		return jScrollPaneMST;
	}
	
	private JLabel getJLabelTitle() {
		if (jLabelTitle == null) {
			jLabelTitle = new JLabel("PASSERELLE DE GENERATION REMISE BCEAO  v1.0");
			jLabelTitle.setForeground(UIManager.getColor("Button.darkShadow"));
			jLabelTitle.setBackground(UIManager.getColor("Button.disabledText"));
			jLabelTitle.setFont(new Font("Century Schoolbook", Font.BOLD, 18));
			jLabelTitle.setLabelFor(frame);
		}
		return jLabelTitle;
	}
	private JButton getBtnGenerer() {
		if (btnGenerer == null) {
			btnGenerer = new JButton("GENERER");
			btnGenerer.addActionListener(this);
		}
		return btnGenerer;
	}
	private JButton getJButtonAddAll() {
		if (jButtonAddAll == null) {
			jButtonAddAll = new JButton("");
			jButtonAddAll.setIcon(new ImageIcon(Graphique.class.getResource("/2fleche_droite_bleue.png")));
			jButtonAddAll.addActionListener(this);
		}
		return jButtonAddAll;
	}

	private JButton getJButtonRemoveSelected() {
		if (jButtonRemoveSelected == null) {
			jButtonRemoveSelected = new JButton("");
			jButtonRemoveSelected.setIcon(new ImageIcon(Graphique.class.getResource("/fleche_gauche_bleue.png")));
			jButtonRemoveSelected.addActionListener(this);
		}
		return jButtonRemoveSelected;
	}
	private JButton getJButtonRemoveAll() {
		if (jButtonRemoveAll == null) {
			jButtonRemoveAll = new JButton("");
			jButtonRemoveAll.setIcon(new ImageIcon(Graphique.class.getResource("/2fleche_gauche_bleue.png")));
			jButtonRemoveAll.addActionListener(this);
		}
		return jButtonRemoveAll;
	}
	private JButton getJButtonAddSelected() {
		if (jButtonAddSelected == null) {
			jButtonAddSelected = new JButton("");
			jButtonAddSelected.setToolTipText("Ajouter s\u00E9lectionn\u00E9");
			jButtonAddSelected.setIcon(new ImageIcon(Graphique.class.getResource("/fleche_droite_bleue.png")));
			jButtonAddSelected.addActionListener(this);
		}
		return jButtonAddSelected;
	}
	
	public void montreCacheElement(boolean visible){
		getBtnGenerer().setVisible(visible);
		getJScrollPaneMS().setVisible(visible);
		getJScrollPaneMST().setVisible(visible);
		getJButtonAddAll().setVisible(visible);
		getJButtonRemoveSelected().setVisible(visible);
		getJButtonRemoveAll().setVisible(visible);
		getJButtonAddSelected().setVisible(visible);
		getProgressBar().setVisible(visible);
	}
	public void enableButton(boolean visible){
		getBtnGenerer().setEnabled(visible);
		getJButtonAddAll().setEnabled(visible);
		getJButtonRemoveSelected().setEnabled(visible);
		getJButtonRemoveAll().setEnabled(visible);
		getJButtonAddSelected().setEnabled(visible);
	}
	public void setJListMasqueSaisie(JList<String> jListMasqueSaisie) {
		this.jListMasqueSaisie = jListMasqueSaisie;
	}

	public void setJListMasqueSaisieATraite(JList<String> jListMasqueSaisieTraite) {
		this.jListMasqueSaisieATraite = jListMasqueSaisieTraite;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource(); 
		if(obj.equals(getJButtonPathMasqueSaisie())){
			int ret=getJFileChooser().showOpenDialog(getJPane());
			if(ret==JFileChooser.APPROVE_OPTION){
				getProgressBar().setValue(0);
				pathMasqueDeSaisie=getJFileChooser().getSelectedFile().getAbsolutePath();
				ldf=new LectureDesFichiersDunDossier(pathMasqueDeSaisie);
				getJTextFieldPathMasqueSaisie().setText(pathMasqueDeSaisie);
				setListeMasqueSaisie(new ArrayListModel<String>());
				setListeMasqueSaisieATraite(new ArrayListModel<String>());
				getListeMasqueSaisie().addAll(ldf.getListeFic());
				getJListMasqueSaisie().setModel(getListeMasqueSaisie());
				getJListMasqueSaisieATraite().setModel(getListeMasqueSaisieATraite());
				getJListMasqueSaisieATraite().setCellRenderer(new RenduSansIcone());
				montreCacheElement(true);
				enableButton(true);
			}
		}
		else if(obj.equals(getBtnGenerer())){
			enableButton(false);
			try{
				Thread t = new Thread(new Runnable() {
			          public void run() {
			        	  	Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);
							EtatFinancier ef=new EtatFinancier(getListeMasqueSaisieATraite(), pathMasqueDeSaisie,ldf.getDirectoryEFGen(),getProgressBar(),getJCheckBoxAnnuel(),getJCheckBoxPeriodique());
							ef.setJFrame(getJFrame());
							ef.setJProgressBar(getProgressBar());
							try {
								Thread t = new Thread(new Runnable() {
					                public void run() {
					                	while(getProgressBar().getValue()<100){
					                	 
					                	}
					                }
					            });
					            t.start();
						        java.lang.Thread.sleep(100);
						    } catch (InterruptedException e2) {
						        ;
						    }
							ef.creerListeEtatFinancier();
							setListeMasqueSaisieATraite(ef.getListeEtatEFGenere());
							getJListMasqueSaisieATraite().setModel(getListeMasqueSaisieATraite());
							getJListMasqueSaisieATraite().setCellRenderer(new Rendu());		
							enableButton(false);
			          }});
	            t.start();
				}catch(Exception e1){
					log.error(e1.getMessage(),e1);
				}
			
		}
		else if(obj.equals(getJButtonAddSelected())){
			List<String> l=getJListMasqueSaisie().getSelectedValuesList();
			getListeMasqueSaisie().removeAll(l);
			getListeMasqueSaisieATraite().addAll(l);
		}
		else if(obj.equals(getJButtonRemoveSelected())){
			List<String> l=getJListMasqueSaisieATraite().getSelectedValuesList();
			getListeMasqueSaisieATraite().removeAll(l);
			getListeMasqueSaisie().addAll(l);
		}
		else if(obj.equals(getJButtonAddAll())){
			getListeMasqueSaisieATraite().addAll(getListeMasqueSaisie());
			getListeMasqueSaisie().removeAll(getListeMasqueSaisie());
			
		}
		else if(obj.equals(getJButtonRemoveAll())){
			getListeMasqueSaisie().addAll(getListeMasqueSaisieATraite());
			getListeMasqueSaisieATraite().removeAll(getListeMasqueSaisieATraite());
			
		}
	}

	public ArrayListModel<String> getListeMasqueSaisie() {
		return listeMasqueSaisie;
	}

	public void setListeMasqueSaisie(ArrayListModel<String> listeMasqueSaisie) {
		this.listeMasqueSaisie = listeMasqueSaisie;
	}

	public ArrayListModel<String> getListeMasqueSaisieATraite() {
		return listeMasqueSaisieATraite;
	}

	public void setListeMasqueSaisieATraite(ArrayListModel<String> listeMasqueSaisieTraite) {
		this.listeMasqueSaisieATraite = listeMasqueSaisieTraite;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Fichier(s) du r\u00E9pertoire");
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setForeground(Color.DARK_GRAY);
			lblNewLabel.setLabelFor(getJListMasqueSaisie());
			lblNewLabel.setFont(new Font("Constantia", Font.PLAIN, 12));
		}
		return lblNewLabel;
	}
	private JLabel getLblFichiersGnrer() {
		if (lblFichiersGnrer == null) {
			lblFichiersGnrer = new JLabel("Fichier(s) \u00E0 g\u00E9n\u00E9rer");
			lblFichiersGnrer.setBackground(Color.WHITE);
			lblFichiersGnrer.setForeground(Color.DARK_GRAY);
			lblFichiersGnrer.setLabelFor(getJListMasqueSaisieATraite());
			lblFichiersGnrer.setFont(new Font("Constantia", Font.PLAIN, 12));
		}
		return lblFichiersGnrer;
	}
	
	private JRadioButton getJCheckBoxAnnuel() {
		if (jCheckBoxAnnuel == null) {
			jCheckBoxAnnuel = new JRadioButton("GENERER REMISE BCEAO ANNUELLE");
			jCheckBoxAnnuel.setSelected(true);	
			jCheckBoxAnnuel.setVisible(true);
		}
		return jCheckBoxAnnuel;
	}
	
	private JRadioButton getJCheckBoxPeriodique() {
		if (jCheckBoxPeriodique == null) {
			jCheckBoxPeriodique = new JRadioButton("GENERER REMISE BCEAO PERIODIQUE ET COMPLEMENTAIRE");
			jCheckBoxPeriodique.setSelected(true);		
		}
		return jCheckBoxPeriodique;
	}
}
