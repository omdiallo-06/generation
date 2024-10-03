package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatBienDetenuClauseReservePropriete extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatBienDetenuClauseReservePropriete.class);
	
	
	public EtatBienDetenuClauseReservePropriete(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1
		copieType(59, 4);
		//2
		copieType(60, 5);
		//3
		copieType(61, 6);
		//4
		copieType(62, 7);
		//5
		copieType(63, 8);
		//6
		copieType(64, 9);
		//7
		copieType(65, 10);
		//8
		copieType(66, 11);
		//9
		copieType(67, 12);
		//10
		copieType(68, 13);
		//11
		copieType(69, 14);
	}
	
	public void copieType(Integer source, Integer destination){
		//libelle
		copie("B"+source,"A"+destination);
		//Objet
		copie("D"+source,"B"+destination);
		//brut
		copieInt("E"+source,"C"+destination);
		//Date Inscription
		copieInt("F"+source,"D"+destination);
		//duree jouissance
		copieInt("G"+source,"E"+destination);
		//creanciers
		copie("H"+source,"F"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
