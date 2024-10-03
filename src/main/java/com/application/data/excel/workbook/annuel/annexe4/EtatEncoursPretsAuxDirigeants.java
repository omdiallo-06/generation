package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatEncoursPretsAuxDirigeants extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatEncoursPretsAuxDirigeants.class);
	
	
	public EtatEncoursPretsAuxDirigeants(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1 
		copieType(182, 3);
		//2 
		copieType(183, 4);
		//3 
		copieType(184, 5);
		//4 
		copieType(185, 6);
		//5 
		copieType(186, 7);
		//6 
		copieType(187, 8);
		//7
		copieType(188, 9);
		//8
		copieType(189, 10);
		//9
		copieType(190, 11);
		//10
		copieType(191, 12);
		//11
		copieType(192, 13);
		//12
		copieType(193, 14);
		//13
		copieType(194, 15);
		//14
		copieType(195, 16);
		//15
		copieType(196, 17);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//num compte
		//copie("B"+source,"A"+destination);
		//nom prenom
		copie("B"+source,"B"+destination);
		//encours brut
		copie("E"+source,"C"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
