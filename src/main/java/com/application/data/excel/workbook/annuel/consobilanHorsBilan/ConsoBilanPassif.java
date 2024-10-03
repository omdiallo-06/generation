package com.application.data.excel.workbook.annuel.consobilanHorsBilan;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class ConsoBilanPassif extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(ConsoBilanPassif.class);
	
	
	public ConsoBilanPassif(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieBilanPassif(){
		//300
		copie("I8","C3");
		//310
		copie("I9","C4");
		//311
		copie("I10","C5");
		//312
		copie("I11","C6");
		//320
		copie("I12","C7");
		//330
		copie("I15","C8");
		//331
		copie("I16","C9");
		//332
		copie("I17","C10");
		//334
		copie("I18","C11");
		//335
		copie("I19","C12");
		//345
		copie("I20","C13");
		//350
		copie("I22","C14");
		//355
		copie("I23","C15");
		//360
		copie("I24","C16");
		//362
		copie("I25","C17");
		//365
		copie("I28","C18");
		//370
		copie("I29","C19");
		//375
		copie("I30","C20");
		//380
		copie("I33","C21");
		//385
		copie("I34","C22");
		//390
		copie("I38","C23");
		//391
		copie("I39","C24");
		//392
		copie("I40","C25");
		//400
		copie("I42","C26");
		//420
		copie("I44","C27");
		//421
		copie("I45","C28");
		//422
		copie("I46","C29");
		//450
		copie("I48","C30");
	}
	
	public void operation(){
		CopieBilanPassif();
	}
}
