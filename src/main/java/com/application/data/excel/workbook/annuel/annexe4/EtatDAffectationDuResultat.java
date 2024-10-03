package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDAffectationDuResultat extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDAffectationDuResultat.class);
	
	
	public EtatDAffectationDuResultat(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//L80
		copieType(248, 4);
		//L70
		copieType(249, 5);
		//770
		copieType(250, 6);
		//Affectation res benef
		copieType(251, 7);
		//772
		copieType(252, 8);
		//773
		copieType(253, 9);
		//774
		copieType(254, 10);
		//776
		copieType(255, 11);
		//777
		copieType(256, 12);
		//Affectation res def
		copieType(257, 13);
		//776
		copieType(258, 14);
		//778
		copieType(259, 15);
		//779
		copieType(260, 16);
	}
	
	public void copieType(Integer source, Integer destination){
		//montant bruts
		copie("D"+source,"C"+destination);
		//ammort/prov
		copie("E"+source,"D"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
