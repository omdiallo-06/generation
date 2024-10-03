package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class TableauEmploisEtRessources extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(TableauEmploisEtRessources.class);
	
	
	public TableauEmploisEtRessources(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//B02 Amortissement
		copie("D8","C4");
		//B02 net
		copie("E8","D4");
		//G02 Amortissement
		copie("D19","C15");
		//G02 net
		copie("E19","D15");
		//G10
		copie("D20","C16");
		//G15
		copie("D21","C17");
		//G2A
		copie("D22","C18");
		//G60
		copie("D23","C19");
		//G70
		copie("D24","C20");
	}
	
	public void copieType(Integer source, Integer destination){
		//nationaux
		copie("D"+source,"C"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
