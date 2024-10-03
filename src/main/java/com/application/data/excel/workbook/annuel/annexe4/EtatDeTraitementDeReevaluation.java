package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDeTraitementDeReevaluation extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDeTraitementDeReevaluation.class);
	
	
	public EtatDeTraitementDeReevaluation(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1 
		copieType(266, 4);
		//2 
		copieType(267, 5);
		//3 
		copieType(268, 6);
		//4 
		copieType(269, 7);
		//5 
		copieType(270, 9);
		//6 
		copieType(271, 10);
		//7
		copieType(272, 11);
		//8 
		copieType(273, 12);
		//9 
		copieType(274, 13);
		//10 
		copieType(275, 14);
		//11
		copieType(276, 15);
		//12 
		copieType(277, 16);
	}
	
	public void copieType(Integer source, Integer destination){
		
		//Bien
		copie("B"+source,"A"+destination);
		//Date de reevalu
		copieInt("D"+source,"B"+destination);
		//nature libre
		copie("E"+source,"C"+destination);
		//nature legale
		copie("F"+source,"D"+destination);
		//meth indicaire
		copieInt("G"+source,"E"+destination);
		//meth cout actu
		copieInt("H"+source,"F"+destination);
		//valeur avant reeva
		copieInt("I"+source,"G"+destination);
		//valeur rreevalue
		copieInt("J"+source,"H"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
