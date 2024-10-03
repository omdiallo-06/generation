package com.application.data.excel;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.application.data.excel.workbook.old.CompteResultatEtSoldeIntermediaire;
import com.jgoodies.common.collect.ArrayListModel;

public class EtatFinancier{

	private ArrayList<String> listeMasqueSaisieXlsx=new ArrayList<String>();
	private ArrayList<String> listeMasqueSaisieXls=new ArrayList<String>();
	private String pathTemplateEtatFinancier="/masque_2015.xlsx";
	private ArrayListModel<String> listeEtatEFGenere=new ArrayListModel<String>();
	private String chemin;
	private String cheminEFGen;	
	private String cheminWindows;
	private String cheminUnix;
	private String cheminTotal;
	private JFrame jFrame;
	private ArrayList<String> messages=new ArrayList<String>();
	private JProgressBar jProgressBar;
	private boolean checkAnnuel;
	private boolean checkPeriodique;
	static Logger log= Logger.getLogger("org");
	int etape=0;
	public EtatFinancier(ArrayList<String> listeMasqueSaisieXlsx,ArrayList<String> listeMasqueSaisieXls,String chemin,String cheminEFGen,JProgressBar progressBar,JRadioButton jCheckBoxAnnuel,JRadioButton jCheckBoxPeriodique){
		try {
			this.listeMasqueSaisieXlsx=listeMasqueSaisieXlsx;
			this.listeMasqueSaisieXls=listeMasqueSaisieXls;
			this.chemin=chemin;
			this.cheminEFGen=cheminEFGen;
			checkAnnuel=jCheckBoxAnnuel.isSelected();
			checkPeriodique=jCheckBoxPeriodique.isSelected();
			setJProgressBar(progressBar);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
	}
	
	public EtatFinancier(ArrayList<String> listeMasqueSaisie,String chemin,String cheminEFGen,JProgressBar progressBar,JRadioButton jCheckBoxAnnuel,JRadioButton jCheckBoxPeriodique){
		try {
			renseigneListeMasqueSaisie(listeMasqueSaisie);
			this.chemin=chemin;
			this.cheminEFGen=cheminEFGen;
			this.jProgressBar=progressBar;
			checkAnnuel=jCheckBoxAnnuel.isSelected();
			checkPeriodique=jCheckBoxPeriodique.isSelected();
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
	}
	
	public void renseigneListeMasqueSaisie(ArrayList<String> liste){
		 for (int i=0; i<liste.size();i++){                // Get filename of file or directory
	            String filename = liste.get(i);
	            if(filename.endsWith("xls")){
	            	getListeMasqueSaisieXls().add(filename);
	            }
	            else if(filename.endsWith("xlsx")){
	            	getListeMasqueSaisieXlsx().add(filename);
	            }
		 }
	}
	public EtatFinancier(ArrayList<String> masqueSaisie,XSSFWorkbook templateEtatFinancier){
		this.listeMasqueSaisieXlsx=masqueSaisie;
	}
	
	public EtatFinancier() {
		
	}

	public void reevaluateFormula(XSSFWorkbook wb){
		FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
		for(int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
		    XSSFSheet sheet = wb.getSheetAt(sheetNum);
		    for(Row r : sheet) {
		        for(Cell c : r) {
		            if(c.getCellType() == Cell.CELL_TYPE_FORMULA) {
		                evaluator.evaluateFormulaCell(c);
		            }
		        }
		    }
		}
	}
	
	public void creeUnEtatFinancierXlsx(String pathMasqueDeSaisie) {
		boolean ok=false;
		String numAg=null;
		
		try {
			
			XSSFWorkbook wbMasqueSaisie=null;// new XSSFWorkbook(is);
			try{
				setCheminWindows(chemin+"\\"+pathMasqueDeSaisie);
				cheminUnix=chemin+"//"+pathMasqueDeSaisie;
				cheminTotal=cheminUnix;

				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(cheminTotal));
				EncryptionInfo info = new EncryptionInfo(fs);
				Decryptor d = Decryptor.getInstance(info);
				d.verifyPassword(Decryptor.DEFAULT_PASSWORD);
				System.out.println(Decryptor.DEFAULT_PASSWORD);
				wbMasqueSaisie = new XSSFWorkbook(d.getDataStream(fs));
			}catch(OfficeXmlFileException e){
				if(wbMasqueSaisie==null)
					wbMasqueSaisie=new XSSFWorkbook(new FileInputStream(cheminTotal));
			}
           
			ok=creer(wbMasqueSaisie, numAg, pathMasqueDeSaisie);
		}catch (Exception e) {
			messages.add(pathMasqueDeSaisie);
			log.error(e.getMessage(),e);
		}finally{
			if(ok)
				getListeEtatEFGenere().add("OK!!!!-"+pathMasqueDeSaisie);
			else{
				getListeEtatEFGenere().add("NONOK!-"+pathMasqueDeSaisie);
				log.error("Erreur génération de l'etat financier ayant pour masque :"+chemin+"\\"+pathMasqueDeSaisie);
			}
			etape=0;
			renseigneProgressBar();
			
		}
	}
	
	public void renseigneProgressBar(){
		getJProgressBar().setValue( (getListeEtatEFGenere().size()*100+etape)/(getListeMasqueSaisieXls().size()+getListeMasqueSaisieXlsx().size()));
	}
	public int returnProgressBar(){
		return (getListeEtatEFGenere().size()*100)/(getListeMasqueSaisieXls().size()+getListeMasqueSaisieXlsx().size());
	}
	public void creeUnEtatFinancierXls(String pathMasqueDeSaisie){
		boolean ok=false;
		String numAg=null;
		try {
			//InputStream inp = new FileInputStream(cheminTotal);
			HSSFWorkbook wbMasqueSaisie=null; //new HSSFWorkbook(inp);
			try{
				POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(cheminTotal));
				EncryptionInfo info = new EncryptionInfo(fs);
				Decryptor d = Decryptor.getInstance(info);
				d.verifyPassword(Decryptor.DEFAULT_PASSWORD);
				System.out.println(Decryptor.DEFAULT_PASSWORD);
				wbMasqueSaisie = new HSSFWorkbook(d.getDataStream(fs));
			}catch(Exception e){
				if(wbMasqueSaisie==null)
					wbMasqueSaisie=new HSSFWorkbook(new FileInputStream(cheminTotal));
			}
			ok=creer(wbMasqueSaisie, numAg, pathMasqueDeSaisie);
		}catch (Exception e) {
			messages.add(pathMasqueDeSaisie);
			log.error(e.getMessage(),e);
		}finally{
			if(ok)
				getListeEtatEFGenere().add("OK!!!!-"+pathMasqueDeSaisie);
			else{
				getListeEtatEFGenere().add("NONOK!-"+pathMasqueDeSaisie);
				log.error("Erreur génération de l'etat financier ayant pour masque :"+cheminTotal);
			}
			etape=0;
			renseigneProgressBar();		
		}
	}
	//Entree Le masque et le chemin du modele sics
	public boolean creer(Workbook wbMasqueSaisie,String numAg,String pathMasqueDeSaisie) throws Exception{
		/*log.info("pathMasqueDeSaisie"+pathMasqueDeSaisie);
		log.info("pathTemplateEtatFinancier"+pathTemplateEtatFinancier);
		log.info("cheminEFGen"+cheminEFGen);
		log.info("cheminTotal"+cheminTotal);
		log.info("chemin"+chemin);*/
		/*if ((checkAnnuel && checkPeriodique)||(!checkAnnuel && !checkPeriodique))
			return new EtatAnnuel(wbMasqueSaisie).creerDeveloppe(chemin) && new EtatPeriodique(wbMasqueSaisie).creerEtat(chemin) &&new EtatComplementaire(wbMasqueSaisie).creerEtat(chemin);
		else */if (checkAnnuel)
			return new EtatAnnuel(wbMasqueSaisie).creerDeveloppe(chemin);
		else if (checkPeriodique)
			return new EtatPeriodique(wbMasqueSaisie).creerEtat(chemin) && new EtatComplementaire(wbMasqueSaisie).creerEtat(chemin);		
		return false;
	}
	
	public void creerListeEtatFinancierXlsx(ArrayList<String> listeMasqueSaisieXlsx){
		for(int i=0;i<listeMasqueSaisieXlsx.size();i++)
			creeUnEtatFinancierXlsx(listeMasqueSaisieXlsx.get(i));
	}
	
	public void creerListeEtatFinancierXls(ArrayList<String> listeMasqueSaisieXls){
		for(int i=0;i<listeMasqueSaisieXls.size();i++)
			creeUnEtatFinancierXls(listeMasqueSaisieXls.get(i));
	}
	
	public void creerListeEtatFinancier(ArrayList<String> listeMasqueSaisieXlsx,ArrayList<String> listeMasqueSaisieXls){
		creerListeEtatFinancierXlsx(listeMasqueSaisieXlsx);
		creerListeEtatFinancierXls(listeMasqueSaisieXls);
		if(getMessages().size()>0)
			JOptionPane.showMessageDialog(getJFrame(), getMessageErreur(),"Erreur à  la création d'états Financiers!",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(getJFrame(), getMessageOk(),"Etats Financiers générés!",JOptionPane.INFORMATION_MESSAGE);
	}

	public void creerListeEtatFinancier(){
		if(getListeMasqueSaisieXls().size()>0)
			creerListeEtatFinancierXls(getListeMasqueSaisieXls());
		if(getListeMasqueSaisieXlsx().size()>0)
			creerListeEtatFinancierXlsx(getListeMasqueSaisieXlsx());
		if(getMessages().size()>0)
			JOptionPane.showMessageDialog(getJFrame(), getMessageErreur(),"Erreur à  la création d'états Financiers!",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(getJFrame(), getMessageOk(),"Etats Financiers générés!",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getMessageErreur(){
		String retour =getMessages().size()+" erreur(s) détectés lors de la génération des états financiers.\n";
		if(getMessages().size()>0){
			retour +="concernant ces masques de saisies :\n";
			for(int i=0;i<getMessages().size();i++)
				retour+=" - "+getMessages().get(i)+";\n";
			retour+="Format invalide ou données manquantes.";
		}
		return retour;
	}
	
	public String getMessageOk(){
		String retour =getListeEtatEFGenere().size()-getMessages().size()+" Remise(s) BCEAO(s) et  Complémentaire(s) générés avec succés.\n";
		return retour;
	}
	
	public ArrayList<String> getListeMasqueSaisieXlsx() {
		return listeMasqueSaisieXlsx;
	}
	
	public ArrayList<String> getListeMasqueSaisieXls() {
		return listeMasqueSaisieXls;
	}

	public String getPathTemplateEtatFinancier() {
		return pathTemplateEtatFinancier;
	}

	public void setPathTemplateEtatFinancier(String pathTemplateEtatFinancier) {
		this.pathTemplateEtatFinancier = pathTemplateEtatFinancier;
	}

	public ArrayListModel<String> getListeEtatEFGenere() {
		return listeEtatEFGenere;
	}

	public void setListeEtatEFGenere(ArrayListModel<String> listeEtatEFGenere) {
		this.listeEtatEFGenere = listeEtatEFGenere;
	}

	public void setListeMasqueSaisieXlsx(ArrayList<String> listeMasqueSaisieXlsx) {
		this.listeMasqueSaisieXlsx = listeMasqueSaisieXlsx;
	}

	public void setListeMasqueSaisieXls(ArrayList<String> listeMasqueSaisieXls) {
		this.listeMasqueSaisieXls = listeMasqueSaisieXls;
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getCheminEFGen() {
		return cheminEFGen;
	}

	public void setCheminEFGen(String cheminEFGen) {
		this.cheminEFGen = cheminEFGen;
	}

	public JFrame getJFrame() {
		return jFrame;
	}

	public void setJFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public ArrayList<String> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}

	public JProgressBar getJProgressBar() {
		return jProgressBar;
	}

	public void setJProgressBar(JProgressBar jProgressBar) {
		this.jProgressBar = jProgressBar;
	}

	public boolean isCheckAnnuel() {
		return checkAnnuel;
	}

	public void setCheckAnnuel(boolean checkAnnuel) {
		this.checkAnnuel = checkAnnuel;
	}

	public boolean isCheckPeriodique() {
		return checkPeriodique;
	}

	public void setCheckPeriodique(boolean checkPeriodique) {
		this.checkPeriodique = checkPeriodique;
	}

	public String getCheminWindows() {
		return cheminWindows;
	}

	public void setCheminWindows(String cheminWindows) {
		this.cheminWindows = cheminWindows;
	}
}
