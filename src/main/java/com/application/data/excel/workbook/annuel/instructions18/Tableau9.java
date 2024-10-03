package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau9 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau9.class);
	
	
	public Tableau9(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//Par l'Assemblée Générale
		copieType(363, 373);
		//Par le Conseil d'Administration ou l'organe équivalent				
		copieType(364, 374);
		//Par le Conseil de Surveillance (*)				
		copieType(365, 375);
		//Par le Comité de Crédit (*)				
		copieType(366, 376);
		//Par les autres comités (**)	
		copieType(367, 377);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
