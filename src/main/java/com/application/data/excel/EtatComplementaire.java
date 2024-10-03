package com.application.data.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.complementaire.EtatDes50PlusGrandsDeposants;
import com.application.data.excel.workbook.complementaire.EtatDes50PlusGrosConsommateursCredit;
import com.application.data.excel.workbook.complementaire.EtatDes50PlusGrosEncoursDeclassesEnSouffrance;
import com.application.data.excel.workbook.complementaire.EtatDes50PlusGrosEngagementParSignature;
import com.application.data.excel.workbook.complementaire.EtatDes50PlusGrosTransfert;

public class EtatComplementaire {
	
	protected static final Logger log = LoggerFactory.getLogger(EtatComplementaire.class);
	private Workbook wbMasqueSaisie;
	private String annee;
	
	public EtatComplementaire(Workbook wbMasqueSaisie){
		this.wbMasqueSaisie=wbMasqueSaisie;
	}

//	@SuppressWarnings("unused")
	public boolean creerEtat(String chemin) throws Exception{
		log.info("startPeriodique");
		log.info(chemin);
		String numAg=null;
		boolean ok=false;
		FileOutputStream out=null;
		InputStream ist = getClass().getResource("/SICS_complementaire.xls").openStream();//new FileInputStream("C:/Users/LZ2059/Desktop/Projection_2012_Eq2.xlsx");
		Workbook workbook = WorkbookFactory.create(ist);
		String nomSfd=wbMasqueSaisie.getSheet("SOMMAIRE").getRow(5-1).getCell(3).getStringCellValue();
		String moisArrete=wbMasqueSaisie.getSheet("SOMMAIRE").getRow(3-1).getCell(8).getStringCellValue();;
		for(int i=0;i<workbook.getNumberOfSheets();i++)
			log.info ("sheet name :"+workbook.getSheetName(i));
		if(wbMasqueSaisie.getNumberOfSheets()>=10){
			log.info("sommairePeriodique +");
			numAg=wbMasqueSaisie.getSheet("SOMMAIRE").getRow(3).getCell(3).getStringCellValue();
			annee=wbMasqueSaisie.getSheet("SOMMAIRE").getRow(1).getCell(3).getNumericCellValue()+"";
			log.info("numAg " +numAg);
			new EtatDes50PlusGrandsDeposants(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS GROS DEPOSANTS"),nomSfd,moisArrete);
			//new EtatDes50PlusPetitsDeposants(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS PETITS DEPOSAN"));
			new EtatDes50PlusGrosConsommateursCredit(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS GROS CONSOMMAT"),nomSfd,moisArrete);
			//new EtatDes50PlusPetitsConsommateursCredit(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS PETIT CONSOMMAT"));
			new EtatDes50PlusGrosEngagementParSignature(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS GROS ENGAGEMEN"),nomSfd,moisArrete);
			new EtatDes50PlusGrosEncoursDeclassesEnSouffrance(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES CREANCES EN SOUFFRANCE"),nomSfd,moisArrete);
			new EtatDes50PlusGrosTransfert(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS GROS DEPOSANTS"),nomSfd,moisArrete);
			new EtatDes50PlusGrandsDeposants(wbMasqueSaisie.getSheet("ETAT DES 50 PLUS GROS CLIENTS"), workbook.getSheet("ETAT DES 50 PLUS GROS DEPOSANTS"),nomSfd,moisArrete);
			
			
			/*new BilanHorsBilanPeriodique(wbMasqueSaisie.getSheet("Bilan et Hors Bilan"),workbook);
			new CompteResultatPeriodique(wbMasqueSaisie.getSheet("Compte Résultat et Soldes Inter"), workbook);
			new RatioPrudentiel(wbMasqueSaisie.getSheet("Ratio prudentiel"), workbook);
			new IndicateurFinancier(wbMasqueSaisie.getSheet("Indicateurs Financiers"), workbook);
			new Instruction18Periodique(wbMasqueSaisie.getSheet("Instruction 18"), workbook);*/
			log.info("finComplementaire");
			//HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			//numAg="1";
		}
		try {
			if(numAg!=null && !numAg.equals("")){
				creerDossierSiNonExist(chemin+"//periodique");
				out= new FileOutputStream(chemin+"//periodique//"+numAg+"_BCEAO_"+annee+"_complementaire.xls");
				log.info("save" +chemin+"//periodique//"+numAg+"_Remise_BCEAO_"+annee+"periodique_complementaire.xls");
				workbook.write(out);
				out.close();
				ok=true;
			}else{
				ok=false;
				//messages.add(pathMasqueDeSaisie);
			}
		}catch(FileNotFoundException fe){
		//	JOptionPane.showMessageDialog(getJFrame(),cheminEFGen+"//"+numAg+".xlsx est ouvert par un autre processus,\n veuillez le fermer avant de relancer son execution","Erreur ouverture fichier!",JOptionPane.ERROR_MESSAGE);
		//	messages.add(pathMasqueDeSaisie);
			log.error(fe.getMessage(),fe);
			return ok;
		}catch (Exception e) {
			log.error(e.getMessage(),e);
			e.printStackTrace();
			if(out!=null)
				out.close();
			return ok;
		}
		System.out.println(chemin +"complementaire"+ok);
		return ok;	
	}

	public void creerDossierSiNonExist(String chemin){
		File f=new File(chemin);
		if(!f.exists())
			f.mkdirs();	
	}
	public Workbook getWbMasqueSaisie() {
		return wbMasqueSaisie;
	}

	public void setWbMasqueSaisie(Workbook wbMasqueSaisie) {
		this.wbMasqueSaisie = wbMasqueSaisie;
	}
}
