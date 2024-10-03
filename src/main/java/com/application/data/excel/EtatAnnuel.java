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

import com.application.data.excel.workbook.annuel.Annexe4;
import com.application.data.excel.workbook.annuel.BilanHorsBilan;
import com.application.data.excel.workbook.annuel.BilanHorsBilanConsolide;
import com.application.data.excel.workbook.annuel.CompteResultat;
import com.application.data.excel.workbook.annuel.CompteResultatConsolide;
import com.application.data.excel.workbook.annuel.Instruction18;
import com.application.data.excel.workbook.annuel.SommaireAnnuel;

public class EtatAnnuel {
	protected static final Logger log = LoggerFactory.getLogger(EtatAnnuel.class);
	String annee="";
	private Workbook wbMasqueSaisie;
	
	public EtatAnnuel(Workbook wbMasqueSaisie){
		this.wbMasqueSaisie=wbMasqueSaisie;
	}

	
	public boolean creerDeveloppe(String chemin) throws Exception{
	//	log.info("startannuel");
	//	log.info(chemin);
		String numAg=null;
		boolean ok=false;
		FileOutputStream out=null;
		InputStream ist = getClass().getResource("/SICS_V28_DEV.xls").openStream();//new FileInputStream("C:/Users/LZ2059/Desktop/Projection_2012_Eq2.xlsx");
		Workbook workbook = WorkbookFactory.create(ist);
		/*for(int i=0;i<wbMasqueSaisie.getNumberOfSheets();i++)
			log.info ("sheet name :"+wbMasqueSaisie.getSheetName(i));*/
		if(wbMasqueSaisie.getNumberOfSheets()>=10){
			log.info("sommaireAnnuel +");
			SommaireAnnuel sommaire=new SommaireAnnuel(workbook.getSheet("IDENTIFIANT"),wbMasqueSaisie.getSheet("SOMMAIRE"));
			annee=sommaire.getAnnee();
			numAg=sommaire.getNumeroAgrement().trim();
			new BilanHorsBilan(wbMasqueSaisie.getSheet("Bilan et Hors Bilan"),workbook);
			new CompteResultat(wbMasqueSaisie.getSheet("Compte Résultat et Soldes Inter"), workbook);
			new Annexe4(wbMasqueSaisie.getSheet("Annexes 4"), workbook);
			new Instruction18(wbMasqueSaisie.getSheet("Instruction 18"), workbook);
			if(wbMasqueSaisie.getSheet("CONSO_Bilan_HBilan")!=null){
				new BilanHorsBilanConsolide(wbMasqueSaisie.getSheet("CONSO_Bilan_HBilan"), workbook);
				new CompteResultatConsolide(wbMasqueSaisie.getSheet("CONSO_COMP_RESULT"), workbook);
			}
			System.out.println("finAnnuel");
			HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			//numAg="1";
		}
		try {
			if(numAg!=null && !numAg.equals("")){
				creerDossierSiNonExist(chemin+"//annuel");
				out= new FileOutputStream(chemin+"//annuel//"+numAg+"_BCEAO_DEV_"+annee+".xls");
				log.info("save");
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
