package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDesRessourcesAffectees extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDesRessourcesAffectees.class);
	
	
	public EtatDesRessourcesAffectees(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1 Ressources affectées
		copieType(208, 4);
		// credits consentis sur RA
		copieType(210, 6);
		//dont credit en souffrance
		copieType(211, 7);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//cours terme
		copie("D"+source,"C"+destination);
		//Moyen
		copie("E"+source,"D"+destination);
		//long
		copie("F"+source,"E"+destination);
		
	}
	public void operation(){
		copieTableau();
	}
}
