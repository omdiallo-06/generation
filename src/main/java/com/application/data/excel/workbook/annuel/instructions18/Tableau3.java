package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau3 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau3.class);
	
	
	public Tableau3(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau31(){
		//Montant depot homme
		copieType(70, 85);
		//montant depot femme
		copieType(71, 86);
		//montant depot pers morale
		copieType(72, 87);
	}
	
	public void copieTableau32(){
		//DAV
		copieType(77, 93);
		//DAT
		copieType(78, 96);
		//Autres depots
		copieType(79, 99);
	}

	public void copieTableau33(){
		//Nb deposant homme
		copieType(87,107 );
		//Nb deposant femme
		copieType(88,108 );
		//Nb deposant pers morale
		copieType(89, 109);
		//nb comptes inactifs
		copieType(90,110 );
		//montant solde cmpte inactifs
		copieType(91, 111);
		//nb total compte
		copieType(92, 112);
	}
	
	public void copieTableau34(){
		//montant capital social
		copieTypeInt(96, 118);
	}
	
	public void copieTableau35(){
		//1
		copieType1(100,125);
		//2
		copieType1(101,126);
		//3
		copieType1(102,127);
		//4
		copieType1(103,128);
		//5
		copieType1(104,129);
	}
	
	public void copieType1(Integer source, Integer destination){
		//Noms et prenoms
		copie("B"+source,"B"+destination);
		//Montant du capital
		copieInt("E"+source,"C"+destination);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	
	public void copieTypeInt(Integer source, Integer destination){
		//
		copieInt("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau31();
		copieTableau32();
		copieTableau33();
		copieTableau34();
		copieTableau35();
	}
}
