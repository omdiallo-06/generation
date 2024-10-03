package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau5;

public class Tableau5Periodique extends Tableau5 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau5Periodique.class);
	
	
	public Tableau5Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+(destination+8));
	}

}
