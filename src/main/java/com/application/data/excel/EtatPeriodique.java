package com.application.data.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.periodique.BilanHorsBilanPeriodique;
import com.application.data.excel.workbook.periodique.CompteResultatPeriodique;
import com.application.data.excel.workbook.periodique.IndicateurFinancier;
import com.application.data.excel.workbook.periodique.Instruction18Periodique;
import com.application.data.excel.workbook.periodique.RatioPrudentiel;
import com.application.data.excel.workbook.periodique.SommairePeriodique;

public class EtatPeriodique {
	
	protected static final Logger log = LoggerFactory.getLogger(EtatPeriodique.class);
	private Workbook wbMasqueSaisie;
	private String annee;
	
	public EtatPeriodique(Workbook wbMasqueSaisie){
		this.wbMasqueSaisie=wbMasqueSaisie;
	}

	public boolean creerEtat(String chemin) throws Exception{
		log.info("startPeriodique");
		log.info(chemin);
		String numAg=null;
		boolean ok=false;
		FileOutputStream out=null;
		InputStream ist = getClass().getResource("/SICS_V18_Periodique.xls").openStream();//new FileInputStream("C:/Users/LZ2059/Desktop/Projection_2012_Eq2.xlsx");
		Workbook workbook = WorkbookFactory.create(ist);
		for(int i=0;i<wbMasqueSaisie.getNumberOfSheets();i++)
			log.info ("sheet name :"+wbMasqueSaisie.getSheetName(i));
		if(wbMasqueSaisie.getNumberOfSheets()>=10){
			log.info("sommairePeriodique +");
			SommairePeriodique sommaire=new SommairePeriodique(workbook.getSheet("IDENTIFIANT"),wbMasqueSaisie.getSheet("SOMMAIRE"));
			numAg=sommaire.getNumeroAgrement().trim();
			annee=sommaire.getRetour();
			log.info("numAg " +numAg);
			new BilanHorsBilanPeriodique(wbMasqueSaisie.getSheet("Bilan et Hors Bilan"),workbook);
			new CompteResultatPeriodique(wbMasqueSaisie.getSheet("Compte Résultat et Soldes Inter"), workbook);
			new RatioPrudentiel(wbMasqueSaisie.getSheet("Ratio prudentiel"), workbook);
			new IndicateurFinancier(wbMasqueSaisie.getSheet("Indicateurs Financiers"), workbook);
			new Instruction18Periodique(wbMasqueSaisie.getSheet("Instruction 18"), workbook);
			log.info("finPeriodique");
			HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			//numAg="1";
		}
		try {
			if(numAg!=null && !numAg.equals("")){
				creerDossierSiNonExist(chemin+"//periodique");
				out= new FileOutputStream(chemin+"//periodique//"+numAg+"_BCEAO_"+annee+".xls");
				log.info("save" +chemin+"//periodique//"+numAg+"_Remise_BCEAO_periodique.xls");
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
