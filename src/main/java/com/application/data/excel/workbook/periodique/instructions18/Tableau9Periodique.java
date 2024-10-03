package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau9;

public class Tableau9Periodique extends Tableau9 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau9Periodique.class);
	
	
	public Tableau9Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+(destination+8));
	}
	
	public void copieTypeInt(Integer source, Integer destination){
		//
		copieInt("G"+source,"G"+(destination+8));
	}
}
