package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau3;

public class Tableau3Periodique extends Tableau3 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau3Periodique.class);
	
	
	public Tableau3Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	
	public void copieTableau32(){
		//DAV
		copieTypeInt(77, 93);
		//DAT
		copieTypeInt(78, 97);
		//Autres depots
		copieTypeInt(79, 101);
	}

	public void copieTableau33(){
		//Nb deposant homme
		copieTypeInt(87,109 );
		//Nb deposant femme
		copieTypeInt(88,110 );
		//Nb deposant pers morale
		copieTypeInt(89, 111);
		//nb comptes inactifs
		copieTypeInt(90,112 );
		//montant solde cmpte inactifs
		copieTypeInt(91, 113);
		//nb total compte
		copieTypeInt(92, 114);
	}
	
	public void copieTableau34(){
		//montant capital social
		copieTypeInt(96, 120);
	}
	
	public void copieTableau35(){
		//1
		copieType1(100,127);
		//2
		copieType1(101,128);
		//3
		copieType1(102,129);
		//4
		copieType1(103,130);
		//5
		copieType1(104,131);
	}
	

}
