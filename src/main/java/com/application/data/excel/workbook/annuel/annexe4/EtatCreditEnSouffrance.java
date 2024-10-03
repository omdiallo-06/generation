package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatCreditEnSouffrance extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatCreditEnSouffrance.class);
	
	
	public EtatCreditEnSouffrance(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1 B71
		copieType(89, 4);
		//2 B72
		copieType(91, 6);
		//3 B73
		copieType(92, 8);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//A
		copie("D"+source,"C"+destination);
		//B
		copie("E"+source,"D"+destination);
		//D
		copie("G"+source,"F"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
