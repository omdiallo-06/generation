package com.application.data.excel.workbook.annuel.consobilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class ConsoHorsBilan extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(ConsoHorsBilan.class);
	
	
	public ConsoHorsBilan(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
/*	public void CopieHorsBilan(){
		//ENGAGEMENTS DONNÉS
		//copie("C","");
		//ENGAGEMENTS DE FINANCEMENT
		copie("C55","C4");
		//465
		copie("C56","C5");
		//470
		copie("C57","C6");
		//ENGAGEMENTS DE GARANTIE
		copie("C59","C7");
		//475
		copie("C60","C8");
		//480
		copie("C61","C9");
		//485
		copie("C63","C10");
			
		//ENGAGEMENTS REÇUS
		//copie("C","C12");
		//ENGAGEMENTS DE FINANCEMENT
		copie("C68","C13");
		//490
		copie("C70","C14");
		//495
		copie("C71","C15");
		//ENGAGEMENTS DE GARANTIE
		copie("C73","C16");
		//500
		copie("C74","C17");
		//505
		copie("C75","C18");
		//510
		copie("C77","C19");
		
	}*/
	public void CopieHorsBilan(){
	
		
	}

	public void operation(){
		CopieHorsBilan();
	}
}
