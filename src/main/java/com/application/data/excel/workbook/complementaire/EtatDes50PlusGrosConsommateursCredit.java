package com.application.data.excel.workbook.complementaire;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDes50PlusGrosConsommateursCredit extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDes50PlusGrosConsommateursCredit.class);
	
	public EtatDes50PlusGrosConsommateursCredit(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public EtatDes50PlusGrosConsommateursCredit(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		super(sheetMasqueSaisie, sheetSics,nomSfd,moisArrete);
	}
	
	public void copieTableau(){
		for(int i=0;i<50;i++)
			copieType(6+i, 9+i);	
		
	}
	
	public void copieType(Integer source, Integer destination){
		//nom prenom
		copie("C"+source,"B"+destination);
		//secteur
		copie("D"+source,"C"+destination);
		//duree credit
		copieInt("F"+source,"F"+destination);
		//montant
		copieInt("E"+source,"D"+destination);
		//taux
		//copieInt("H"+source,"F"+destination);
		//duree
	//	copieInt("G"+source,"F"+destination);
		//nature garantie
		//copieInt("H"+source,"F"+destination);
		
	}
	public void operation(){
		copieTableau();
		sheetSics.getRow(0).getCell(1).setCellValue(nomSfd);
		sheetSics.getRow(1).getCell(1).setCellValue(moisArrete);
	}
}
