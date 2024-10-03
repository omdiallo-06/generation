package com.application.data.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.application.data.excel.workbook.annuel.SommaireAnnuel;
import com.jgoodies.common.collect.ArrayListModel;

public class MasqueSics{

	private ArrayList<String> listeMasqueSaisieXlsx=new ArrayList<String>();
	private ArrayList<String> listeMasqueSaisieXls=new ArrayList<String>();
	private String pathTemplateMasqueSics="/masque_2015.xlsx";
	private ArrayListModel<String> listeMasqueSicsGenere=new ArrayListModel<String>();
	private String chemin;
	private String cheminMasqueSicsGen;	
	private String cheminWindows;
	private String cheminUnix;
	private String cheminTotal;
	private JFrame jFrame;
	private ArrayList<String> messages=new ArrayList<String>();
	private JProgressBar jProgressBar;
	static Logger log= Logger.getLogger("org");
	int etape=0;
	public MasqueSics(ArrayList<String> listeMasqueSaisieXlsx,ArrayList<String> listeMasqueSaisieXls,String chemin,String cheminMasqueSicsGen,JProgressBar progressBar){
		try {
			this.listeMasqueSaisieXlsx=listeMasqueSaisieXlsx;
			this.listeMasqueSaisieXls=listeMasqueSaisieXls;
			this.chemin=chemin;
			this.cheminMasqueSicsGen=cheminMasqueSicsGen;
			setJProgressBar(progressBar);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(),e);
		}
	}
	
	public MasqueSics(ArrayList<String> listeMasqueSaisie,String chemin,String cheminMasqueSicsGen,JProgressBar progressBar){
		try {
			renseigneListeMasqueSaisie(listeMasqueSaisie);
			this.chemin=chemin;
			this.cheminMasqueSicsGen=cheminMasqueSicsGen;
			this.jProgressBar=progressBar;
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
	public MasqueSics(ArrayList<String> masqueSaisie,XSSFWorkbook templateEtatFinancier){
		this.listeMasqueSaisieXlsx=masqueSaisie;
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
	
	public void creeMasqueSics(String pathMasqueDeSaisie) {
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
				getListeMasqueSicsGenere().add("OK!!!!-"+pathMasqueDeSaisie);
			else{
				getListeMasqueSicsGenere().add("NONOK!-"+pathMasqueDeSaisie);
				log.error("Erreur génération de l'etat financier ayant pour masque :"+chemin+"\\"+pathMasqueDeSaisie);
			}
			etape=0;
			renseigneProgressBar();
			
		}
	}
	
	public void renseigneProgressBar(){
		getJProgressBar().setValue( (getListeMasqueSicsGenere().size()*100+etape)/(getListeMasqueSaisieXls().size()+getListeMasqueSaisieXlsx().size()));
	}
	public int returnProgressBar(){
		return (getListeMasqueSicsGenere().size()*100)/(getListeMasqueSaisieXls().size()+getListeMasqueSaisieXlsx().size());
	}
	public void creeUnMasqueSicsXls(String pathMasqueDeSaisie){
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
				getListeMasqueSicsGenere().add("OK!!!!-"+pathMasqueDeSaisie);
			else{
				getListeMasqueSicsGenere().add("NONOK!-"+pathMasqueDeSaisie);
				log.error("Erreur génération de l'etat financier ayant pour masque :"+cheminTotal);
			}
			etape=0;
			renseigneProgressBar();		
		}
	}
	//Entree Le masque et le chemin du modele sics
	public boolean creer(Workbook wbMasqueSaisie,String numAg,String pathMasqueDeSaisie) throws Exception{
		return creerDeveloppe(wbMasqueSaisie,numAg,pathMasqueDeSaisie);// && creerAllege(wbMasqueSaisie,numAg,pathMasqueDeSaisie) ;		
	}
	
	public boolean creerDeveloppe(Workbook wbMasqueSaisie,String numAg,String pathMasqueDeSaisie) throws Exception{
		boolean ok=false;
		FileOutputStream out=null;
		InputStream ist = getClass().getResource(getPathTemplateMasqueSics()).openStream();//new FileInputStream("C:/Users/LZ2059/Desktop/Projection_2012_Eq2.xlsx");
		OPCPackage opc=OPCPackage.open(ist);
		XSSFWorkbook workbook=new XSSFWorkbook(opc);etape=1;renseigneProgressBar();
		if(wbMasqueSaisie.getNumberOfSheets()>=10){
			/*Sommaire sommaire=new Sommaire(wbMasqueSaisie.getSheetAt(0),workbook.getSheetAt(0));etape=2;renseigneProgressBar();
			numAg=sommaire.getNumeroAgrement().trim();
			System.out.println("bilan "+wbMasqueSaisie.getSheetAt(1).getSheetName()+" -"+workbook.getSheetAt(1).getSheetName());
			new BilanHorsBilan(wbMasqueSaisie.getSheetAt(1),workbook.getSheetAt(1));
			System.out.println("CompteResultatEtSoldeIntermediaire "+wbMasqueSaisie.getSheetAt(2).getSheetName()+" -"+workbook.getSheetAt(2).getSheetName());
			new CompteResultatEtSoldeIntermediaire(wbMasqueSaisie.getSheetAt(2),workbook.getSheetAt(2));etape=5;renseigneProgressBar();
			System.out.println("Annexe4 "+wbMasqueSaisie.getSheetAt(3).getSheetName()+" -"+workbook.getSheetAt(3).getSheetName());
			new Annexe4(wbMasqueSaisie.getSheetAt(3), workbook.getSheetAt(3));
			System.out.println("IndicateurFinancier "+wbMasqueSaisie.getSheetAt(6).getSheetName()+" -"+workbook.getSheetAt(4).getSheetName());
			new IndicateurFinancier(wbMasqueSaisie.getSheetAt(6), workbook.getSheetAt(4));
			System.out.println("RatioPrudentiel "+wbMasqueSaisie.getSheetAt(5).getSheetName()+" -"+workbook.getSheetAt(5).getSheetName());
			new RatioPrudentiel(wbMasqueSaisie.getSheetAt(5), workbook.getSheetAt(5));etape=8;renseigneProgressBar();
			System.out.println("Instruction18 "+wbMasqueSaisie.getSheetAt(7).getSheetName()+" -"+workbook.getSheetAt(7).getSheetName());
			new Instruction18(wbMasqueSaisie.getSheetAt(7), workbook.getSheetAt(7));*/
			SommaireAnnuel sommaire=new SommaireAnnuel(wbMasqueSaisie.getSheet("SOMMAIRE"),workbook.getSheet("IDENTIFIANT"));etape=2;renseigneProgressBar();
			numAg=sommaire.getNumeroAgrement().trim();
			//System.out.println("bilan "+wbMasqueSaisie.getSheetAt(1).getSheetName()+" -"+workbook.getSheetAt(1).getSheetName());
		/*	new BilanHorsBilan(wbMasqueSaisie.getSheet("Bilan et Hors Bilan"),workbook.getSheet("Bilan_et_Hors_Bilan"));
			//System.out.println("CompteResultatEtSoldeIntermediaire "+wbMasqueSaisie.getSheetAt(2).getSheetName()+" -"+workbook.getSheetAt(2).getSheetName());
			new CompteResultatEtSoldeIntermediaire(wbMasqueSaisie.getSheet("Compte Résultat et Soldes Inter"),workbook.getSheet("Compte_Résultat_et_Soldes_Inter"));etape=5;renseigneProgressBar();
			//System.out.println("Annexe4 "+wbMasqueSaisie.getSheetAt(3).getSheetName()+" -"+workbook.getSheetAt(3).getSheetName());
			new Annexe4(wbMasqueSaisie.getSheet("Annexes 4"), workbook.getSheet("Annexes_4"));
			//System.out.println("IndicateurFinancier "+wbMasqueSaisie.getSheetAt(6).getSheetName()+" -"+workbook.getSheetAt(4).getSheetName());
			new IndicateurFinancier(wbMasqueSaisie.getSheet("Indicateurs Financiers"), workbook.getSheet("Indicateurs_Financiers"));
			//System.out.println("RatioPrudentiel "+wbMasqueSaisie.getSheetAt(5).getSheetName()+" -"+workbook.getSheetAt(5).getSheetName());
			new RatioPrudentiel(wbMasqueSaisie.getSheet("Ratio prudentiel"), workbook.getSheet("Ratio_prudentiel"));etape=8;renseigneProgressBar();
			//System.out.println("Instruction18 "+wbMasqueSaisie.getSheetAt(7).getSheetName()+" -"+workbook.getSheetAt(7).getSheetName());
			new Instruction18(wbMasqueSaisie.getSheet("Instruction 18"), workbook.getSheet("Instruction_18"));
			
			new Retraitement(wbMasqueSaisie.getSheet("Retraitement"), workbook.getSheet("Retraitement"));
			
			new Etat50PlusGrosClients(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT_DES_50_PLUS_GROS_CLIENTS"));*/
			
			System.out.println("fin");
			XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
		}
		try {
			if(numAg!=null && !numAg.equals("")){
				out= new FileOutputStream(cheminMasqueSicsGen+"//"+numAg+".xlsx");
				workbook.write(out);
				out.close();
				ok=true;
			}else{
				ok=false;
				messages.add(pathMasqueDeSaisie);
			}
		}catch(FileNotFoundException fe){
			JOptionPane.showMessageDialog(getJFrame(),cheminMasqueSicsGen+"//"+numAg+".xlsx est ouvert par un autre processus,\n veuillez le fermer avant de relancer son execution","Erreur ouverture fichier!",JOptionPane.ERROR_MESSAGE);
			messages.add(pathMasqueDeSaisie);
			return ok;
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			if(out!=null)
				out.close();
			return ok;
		}
		return ok;	
	}
	
	
	public void creerListeMasqueSicsXlsx(ArrayList<String> listeMasqueSaisieXlsx){
		for(int i=0;i<listeMasqueSaisieXlsx.size();i++)
			creeMasqueSics(listeMasqueSaisieXlsx.get(i));
	}
	
	public void creerListeMasqueSicsXls(ArrayList<String> listeMasqueSaisieXls){
		for(int i=0;i<listeMasqueSaisieXls.size();i++)
			creeUnMasqueSicsXls(listeMasqueSaisieXls.get(i));
	}
	
	public void creerListeMasqueSics(ArrayList<String> listeMasqueSaisieXlsx,ArrayList<String> listeMasqueSaisieXls){
		creerListeMasqueSicsXlsx(listeMasqueSaisieXlsx);
		creerListeMasqueSicsXls(listeMasqueSaisieXls);
		if(getMessages().size()>0)
			JOptionPane.showMessageDialog(getJFrame(), getMessageErreur(),"Erreur à  la création d'états Financiers!",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(getJFrame(), getMessageOk(),"Masque SICS générés!",JOptionPane.INFORMATION_MESSAGE);
	}

	public void creerListeMasqueSics(){
		if(getListeMasqueSaisieXls().size()>0)
			creerListeMasqueSicsXls(getListeMasqueSaisieXls());
		if(getListeMasqueSaisieXlsx().size()>0)
			creerListeMasqueSicsXlsx(getListeMasqueSaisieXlsx());
		if(getMessages().size()>0)
			JOptionPane.showMessageDialog(getJFrame(), getMessageErreur(),"Erreur à  la création d'états Financiers!",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(getJFrame(), getMessageOk(),"Masque SICS générés!",JOptionPane.INFORMATION_MESSAGE);
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
		String retour =getListeMasqueSicsGenere().size()-getMessages().size()+" état(s) financier(s) généré(s) avec succès.\n";
		return retour;
	}
	
	public ArrayList<String> getListeMasqueSaisieXlsx() {
		return listeMasqueSaisieXlsx;
	}
	
	public ArrayList<String> getListeMasqueSaisieXls() {
		return listeMasqueSaisieXls;
	}

	public String getPathTemplateMasqueSics() {
		return pathTemplateMasqueSics;
	}

	public void setPathTemplateEtatFinancier(String pathTemplateMasqueSics) {
		this.pathTemplateMasqueSics = pathTemplateMasqueSics;
	}

	public ArrayListModel<String> getListeMasqueSicsGenere() {
		return listeMasqueSicsGenere;
	}

	public void setListeMasqueSicsGenere(ArrayListModel<String> listeMasqueSicsGenere) {
		this.listeMasqueSicsGenere = listeMasqueSicsGenere;
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

	public String getCheminMasqueSicsGen() {
		return cheminMasqueSicsGen;
	}

	public void setCheminMasqueSicsGen(String cheminMasqueSicsGen) {
		this.cheminMasqueSicsGen = cheminMasqueSicsGen;
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

	public String getCheminWindows() {
		return cheminWindows;
	}

	public void setCheminWindows(String cheminWindows) {
		this.cheminWindows = cheminWindows;
	}
}
