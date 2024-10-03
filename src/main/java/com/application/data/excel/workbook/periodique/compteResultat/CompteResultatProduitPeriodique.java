package com.application.data.excel.workbook.periodique.compteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.compteResultat.CompteResultatProduit;

public class CompteResultatProduitPeriodique extends CompteResultatProduit {
	protected static final Logger log = LoggerFactory.getLogger(CompteResultatProduitPeriodique.class);
	
	
	public CompteResultatProduitPeriodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	

	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("G"+source,"C"+(destination-1));
	}
	
}
