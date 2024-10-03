package com.application.data.excel.workbook.complementaire;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDes50PlusGrosEncoursDeclassesEnSouffrance extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDes50PlusGrosEncoursDeclassesEnSouffrance.class);
	
	public EtatDes50PlusGrosEncoursDeclassesEnSouffrance(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public EtatDes50PlusGrosEncoursDeclassesEnSouffrance(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		super(sheetMasqueSaisie, sheetSics,nomSfd,moisArrete);
	}
	
	public void copieTableau(){
		for(int i=0;i<50;i++)
			copieType(60+i, 8+i);
	
	}
	
	public void copieType(Integer source, Integer destination){
		//nom prenom
		copie("C"+source,"B"+destination);
		//secteur d'activite
		copie("D"+source,"C"+destination);
		//montant
		copieInt("E"+source,"D"+destination);
		//provision
		copieInt("F"+source,"E"+destination);
		//net
		copieInt("G"+source,"F"+destination);
		//nombre d'impayé 
		copieInt("H"+source,"G"+destination);
		
	}
	public void operation(){
		copieTableau();
		sheetSics.getRow(0).getCell(1).setCellValue(nomSfd);
		sheetSics.getRow(1).getCell(1).setCellValue(moisArrete);
	}
}
