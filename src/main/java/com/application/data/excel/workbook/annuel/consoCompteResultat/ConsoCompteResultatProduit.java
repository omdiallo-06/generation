package com.application.data.excel.workbook.annuel.consoCompteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class ConsoCompteResultatProduit extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(ConsoCompteResultatProduit.class);
	
	
	public ConsoCompteResultatProduit(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieCRProduit(){
		
	}
	
	public void operation(){
		CopieCRProduit();
	}
}
