package com.application.data.excel.workbook.periodique;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.periodique.compteResultat.CompteResultatChargePeriodique;
import com.application.data.excel.workbook.periodique.compteResultat.CompteResultatProduitPeriodique;

public class CompteResultatPeriodique {
	
//	protected static final Logger log = LoggerFactory.getLogger(CompteResultatPeriodique.class);
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	
	public CompteResultatPeriodique(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
	//	log.info("compte res");
		new CompteResultatChargePeriodique(sheetMasqueSaisie, workbookSics.getSheet("CR_CHARGES"));
		new CompteResultatProduitPeriodique(sheetMasqueSaisie, workbookSics.getSheet("CR_PRODUITS"));
	//	log.info("fin compte res");
	}
}
