package com.application.data.excel.workbook.complementaire;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDes50PlusPetitsDeposants extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDes50PlusPetitsDeposants.class);
	
	public EtatDes50PlusPetitsDeposants(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public EtatDes50PlusPetitsDeposants(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		super(sheetMasqueSaisie, sheetSics,nomSfd,moisArrete);
	}
	
	public void copieTableau(){
	
		
	}
	
	public void copieType(Integer source, Integer destination){
		//num compte
		copieInt("B"+source,"B"+destination);
		//nom prenom
		copie("C"+source,"C"+destination);
		//duree credit
		copieInt("F"+source,"D"+destination);
		//duree restatnte
		copieInt("G"+source,"E"+destination);
		//net
		copieInt("H"+source,"F"+destination);
		
	}
	public void operation(){
		copieTableau();
		sheetSics.getRow(0).getCell(1).setCellValue(nomSfd);
		sheetSics.getRow(1).getCell(1).setCellValue(moisArrete);
	}
}
