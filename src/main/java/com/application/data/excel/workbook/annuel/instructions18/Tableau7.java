package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau7 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau7.class);
	
	
	public Tableau7(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//Encours des placements auprès des autres institutions financières				
		copieType(342, 349);
		//Encours des emprunts auprès des autres institutions financières				
		copieType(343, 350);
		//Montant total des emprunts obtenus dans l'année auprès des autres institutions financières (en milliers de FCFA)				
		copieType(344, 351);
		//Taux d'intérêt moyen des emprunts obtenus dans l'année auprès des autres institutions financières				
		copieType(345, 352);
		//Ressources affectées (en milliers de FCFA)				
		copieType(346, 353);
		//Subventions d'exploitation reçues (en milliers de FCFA)				
		copieType(347, 354);
		//Subventions d'équipement reçues (en milliers de FCFA)
		copieType(348, 355);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
