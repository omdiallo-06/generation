package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EncoursDes10PlusGrosDebiteurs extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EncoursDes10PlusGrosDebiteurs.class);
	
	
	public EncoursDes10PlusGrosDebiteurs(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		for(int i=0;i<10;i++)
			copieType(127+i, 3+i);
		/* //1 
		copieType(127, 3);
		//2 
		copieType(128, 4);
		//3 
		copieType(129, 5);
		//4 
		copieType(130, 6);
		//5 
		copieType(131, 7);
		//6 
		copieType(132, 8);
		//7
		copieType(133, 9);
		//8
		copieType(134, 10);
		//9
		copieType(135, 11);
		//10
		copieType(136, 12);*/
		
	}
	
	public void copieType(Integer source, Integer destination){
		//num compte
		copieInt("B"+source,"B"+destination);
		//nom prenom
		copie("C"+source,"C"+destination);
		//duree credit
		copieInt("F"+source,"D"+destination);
		//duree restatnte
		copieInt("G"+source,"E"+destination);
		//net
		copieInt("H"+source,"F"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
