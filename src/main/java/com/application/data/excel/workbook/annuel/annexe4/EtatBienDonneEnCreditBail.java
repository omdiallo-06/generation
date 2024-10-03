package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatBienDonneEnCreditBail extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatBienDonneEnCreditBail.class);
	
	
	public EtatBienDonneEnCreditBail(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//credit bail mobilier
		copieType(30, 4);
		//credit bail immobilier
		copieType(31, 5);
		//credit bail sur actif incorporel
		copieType(32, 6);
		//Location avec option d'acchat
		copieType(33, 7);
		//location-vente
		copieType(34, 8);
		//creance souffrance
		copieType(35, 9);
	}
	
	public void copieType(Integer source, Integer destination){
		//Duree
		copieInt("D"+source,"C"+destination);
		//bruts
		copieInt("E"+source,"D"+destination);
		//ammortisssement
		copieInt("F"+source,"E"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
