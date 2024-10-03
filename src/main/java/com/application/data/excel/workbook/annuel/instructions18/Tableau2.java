package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau2 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau2.class);
	
	
	public Tableau2(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		// Nombre d'institutions de base
		copieType(59,72);
		//Nombre d'agences
	//	copieType(60,);
		//Nombre de guichets
		copieType(61,73);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
