package com.application.data.excel.workbook.annuel.consoCompteResultat;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class ConsoCompteResultatCharge extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(ConsoCompteResultatCharge.class);
	
	
	public ConsoCompteResultatCharge(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void CopieCRCharge(){
		
	}
	
	public void operation(){
		CopieCRCharge();
	}
}
