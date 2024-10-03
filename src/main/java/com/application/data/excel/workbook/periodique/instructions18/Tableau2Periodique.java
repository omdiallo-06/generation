package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau2;

public class Tableau2Periodique extends Tableau2 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau2Periodique.class);
	
	
	public Tableau2Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
}
