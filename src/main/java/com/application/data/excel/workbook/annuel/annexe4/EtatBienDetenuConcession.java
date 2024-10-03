package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatBienDetenuConcession extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatBienDetenuConcession.class);
	
	
	public EtatBienDetenuConcession(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1
		copieType(42, 4);
		//2
		copieType(43, 5);
		//3
		copieType(44, 6);
		//4
		copieType(45, 7);
		//5
		copieType(46, 8);
		//6
		copieType(47, 9);
		//7
		copieType(48, 10);
		//8
		copieType(49, 11);
		//9
		copieType(50, 12);
		//10
		copieType(51, 13);
		//11
		copieType(52, 14);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//postes
		copie("B"+source,"A"+destination);
		//Duree
		copieInt("C"+source,"B"+destination);
		//valeur d'inventaire ou valeur marche
		copieInt("D"+source,"C"+destination);
		//Nom
		copie("E"+source,"D"+destination);
		//Valeur declarée dans le cahier de charges
		copieInt("F"+source,"E"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
