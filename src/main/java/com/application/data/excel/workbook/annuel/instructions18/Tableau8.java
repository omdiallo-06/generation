package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau8 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau8.class);
	
	
	public Tableau8(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//Nombre d'institutions affiliées déficitaires				
		copieType(354,361);
		//Montant total du déficit d'exploitation des institutions affiliées (en milliers de FCFA)				
		copieType(355,362);
		//Nombre d'institutions affiliées excédentaires				
		copieType(356,363);
		//Montant total de l'excédent d'exploitation des institutions affiliées (en milliers de FCFA)
		copieType(357,364);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
