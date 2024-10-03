package com.application.data.excel.workbook.periodique.bilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.bilanHorsBilan.HorsBilan;

public class HorsBilanPeriodique extends HorsBilan {
	//protected static final Logger log = LoggerFactory.getLogger(HorsBilanPeriodique.class);
	
	
	public HorsBilanPeriodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("C"+source,"C"+(destination-1));
	}
}
