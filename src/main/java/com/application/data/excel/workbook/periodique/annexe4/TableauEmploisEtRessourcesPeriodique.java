package com.application.data.excel.workbook.periodique.annexe4;

import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class TableauEmploisEtRessourcesPeriodique extends MetaSheet {
protected static final Logger log = LoggerFactory.getLogger(TableauEmploisEtRessourcesPeriodique.class);
	
	
	public TableauEmploisEtRessourcesPeriodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//G10
		copie(20,16);
		//G15
		copie(21,17);
		//G2A
		copie(22,18);
		//G60
		copie(23,19);
		//G70
		copie(24,20);
	}
	
	public void copie(Integer source, Integer destination){
		//nationaux
		copie("D"+source,"C"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
