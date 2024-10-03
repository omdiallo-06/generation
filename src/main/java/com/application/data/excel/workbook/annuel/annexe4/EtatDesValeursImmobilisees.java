package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDesValeursImmobilisees extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDesValeursImmobilisees.class);
	
	
	public EtatDesValeursImmobilisees(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//D32
		copieType(227, 12);
		// D33
		copieType(228, 13);
		//D34
		copieType(229, 14);
		//D35
		copieType(230, 15);
		// D42
		copieType(234, 19);
		//D43
		copieType(235, 20);
		//D44
		copieType(236, 21);
	}
	
	public void copieType(Integer source, Integer destination){
		//montant bruts
		copieInt("D"+source,"C"+destination);
		//ammort/prov
		copieInt("E"+source,"D"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
