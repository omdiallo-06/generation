package com.application.data.excel.workbook.periodique.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.bilanHorsBilan.BilanActif;

public class BilanActifPeriodique extends BilanActif {
	
	//protected static final Logger log = LoggerFactory.getLogger(BilanActifPeriodique.class);
	
	public BilanActifPeriodique(Sheet sheetMasqueSaisie, Sheet sheetSics) {
		super(sheetMasqueSaisie, sheetSics);
	}

	public void copieAmortissementProvision(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+(destination-1));
		//provision
		copie("D"+source,"D"+(destination-1));
	}
	
}