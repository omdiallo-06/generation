package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau10 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau10.class);
	
	
	public Tableau10(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//Marge d'intérêt en milliers de FCFA				
		copieType(381,386 );
		//Produit financier net en milliers de FCFA				
		copieType(382,387 );
		//Résultat net en milliers de FCFA				
		copieType(383,388 );
		//Taux de marge nette10		
		copieType(384,389 );
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
