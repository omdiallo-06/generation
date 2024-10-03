package com.application.data.excel.workbook.complementaire;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDes50PlusGrandsDeposants extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDes50PlusGrandsDeposants.class);
	
	public EtatDes50PlusGrandsDeposants(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public EtatDes50PlusGrandsDeposants(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		super(sheetMasqueSaisie, sheetSics,nomSfd,moisArrete);
	}
	
	public void copieTableau(){
		for(int i=0;i<50;i++)
			copieType(168+i, 9+i);		
	}
	
	public void copieType(Integer source, Integer destination){
		//nom prenom
		copie("C"+source,"B"+destination);
		//Montant
		copieInt("D"+source,"D"+destination);
		//Taux
		copieInt("E"+source,"E"+destination);
		//Duree
		copieInt("F"+source,"F"+destination);		
	}
	public void operation(){
		copieTableau();
		sheetSics.getRow(0).getCell(1).setCellValue(nomSfd);
		sheetSics.getRow(1).getCell(1).setCellValue(moisArrete);
	}
}
