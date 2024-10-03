package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatsEngagementsParSignature extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatsEngagementsParSignature.class);
	
	
	public EtatsEngagementsParSignature(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//court terme
		copieType(120,3);
		//moyen et long terme
		copieType(121,4);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//A
		copie("D"+source,"C"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
