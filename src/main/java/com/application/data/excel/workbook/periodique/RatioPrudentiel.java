package com.application.data.excel.workbook.periodique;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class RatioPrudentiel extends MetaSheet{
	//protected static final Logger log = LoggerFactory.getLogger(RatioPrudentiel.class);
	
	public RatioPrudentiel(Sheet sheetMasqueSaisie, Workbook workbookSics) {
		super(sheetMasqueSaisie, workbookSics.getSheet("DISPOSITIF_PRUDENTIEL"));
	}
	public RatioPrudentiel(Sheet sheetMasqueSaisie, Sheet sheetSics) {
		super(sheetMasqueSaisie, sheetSics);
	}

	public void copieTableauLimitationPretDirigeant(){
		//Encours brut de prets et engagements par signature 
		copie(80,94);		
		//Complement de provision non constituées
		copie(109,122);
		//Toutes participations constituant des fonds propre
		copie(110,123);
	}
	
	public void copieTableauLimitationRisqueSignature(){
		//Montant brut des prets et engagement par signature 
		copie(117,136);			
	}
	
	public void copieTableauLimitationOperationAutreEpargneCredit(){
		//Montant consacre par l'institution aux operation autres que l'epargne et credit
		copie(206,230);			
	}
	
	public void copie(Integer source, Integer destination){
		//nationaux
		copie("D"+source,"C"+destination);
	}
	public void operation(){
		copieTableauLimitationPretDirigeant();
		copieTableauLimitationRisqueSignature();
		copieTableauLimitationOperationAutreEpargneCredit();
	}
}
