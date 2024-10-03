package com.application.data.excel.workbook.periodique.compteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.compteResultat.CompteResultatCharge;

public class CompteResultatChargePeriodique extends CompteResultatCharge {
	protected static final Logger log = LoggerFactory.getLogger(CompteResultatChargePeriodique.class);
	
	
	public CompteResultatChargePeriodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+(destination-1));
	}
}
