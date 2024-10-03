package com.application.data.excel.workbook.annuel.consobilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class ConsoBilanActif extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(ConsoBilanActif.class);
	
	
	public ConsoBilanActif(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieBilanActif(){
		//010
		copie("E8","C3");
		//014
		copie("E9","C4");
		//015
		copie("E10","C5");
		//016
		copie("E11","C6");
		//017
		copie("E12","C7");
		//018
		copie("E13","C8");
		//019
		copie("E14","C9");
		//030
		copie("E17","C10");
		//035
		copie("E18","C11");
		//037
		copie("E19","C12");
		//051
		copie("E22","C13");
		//100
		copie("E25","C14");
		//110
		copie("E28","C15");
		//120
		copie("E31","C16");
		//140
		copie("E34","C17");
		//145
		copie("E35","C18");
		//150
		copie("E38","C19");
		//155
		copie("E41","C20");
		//160
		copie("E42","C21");
		//165
		copie("E45","C22");
	}

	
	public void operation(){
		CopieBilanActif();
	}
}
