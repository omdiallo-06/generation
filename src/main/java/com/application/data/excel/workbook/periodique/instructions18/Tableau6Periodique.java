package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau6;

public class Tableau6Periodique extends Tableau6 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau6Periodique.class);
	
	
	public Tableau6Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
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
	
	public void copieType1(Integer source, Integer destination){
		//REFERENCE
		copie("B"+source,"B"+(destination+8));
		//Nature don
		copie("E"+source,"D"+(destination+8));
		//evaluation financieere
		copie("H"+source,"F"+(destination+8));
	}

}
