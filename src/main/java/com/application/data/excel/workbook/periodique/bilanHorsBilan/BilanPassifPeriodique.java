package com.application.data.excel.workbook.periodique.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.bilanHorsBilan.BilanPassif;

public class BilanPassifPeriodique extends BilanPassif {
	
	//protected static final Logger log = LoggerFactory.getLogger(BilanPassifPeriodique.class);
	
	public BilanPassifPeriodique(Sheet sheetMasqueSaisie, Sheet sheetSics) {
		super(sheetMasqueSaisie, sheetSics);
		// TODO Auto-generated constructor stub
	}

	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("I"+source,"C"+(destination-1));
	}

}
