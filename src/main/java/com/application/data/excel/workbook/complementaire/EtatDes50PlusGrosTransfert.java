package com.application.data.excel.workbook.complementaire;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatDes50PlusGrosTransfert extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatDes50PlusGrosTransfert.class);
	
	
	public EtatDes50PlusGrosTransfert(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public EtatDes50PlusGrosTransfert(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		super(sheetMasqueSaisie, sheetSics,nomSfd,moisArrete);
		
	}
	
	public void copieTableau(){
		for(int i=0;i<50;i++){
			copieType(223+i, 9+i);
			copieType1(278+i, 9+i);
		}
	}
	
	// transfert Emis
	public void copieType(Integer source, Integer destination){
		//nom prenom
		copie("C"+source,"B"+destination);
		//UEMOA
		copieInt("D"+source,"D"+destination);
		//Autres pays africains
		copieInt("F"+source,"D"+destination);
		//UE
		copieInt("G"+source,"D"+destination);
		//USA
		copieInt("H"+source,"D"+destination);
		//Autres pays
		copieInt("I"+source,"E"+destination);
		//Total hors UEMOA
		//copieInt("H"+source,"F"+destination);
		//Total Transfers Emis
		//copieInt("H"+source,"F"+destination);		
	}
	
	// transfert Recus
		public void copieType1(Integer source, Integer destination){
			//nom prenom
			copie("C"+source,"B"+destination);
			//UEMOA
			copieInt("D"+source,"J"+destination);
			//Autres pays africains
			copieInt("F"+source,"K"+destination);
			//UE
			copieInt("F"+source,"L"+destination);
			//USA
			copieInt("F"+source,"M"+destination);
			//Autres pays
			copieInt("G"+source,"N"+destination);
			//Total hors UEMOA
			//copieInt("H"+source,"F"+destination);
			//Total Transfers Emis
			//copieInt("H"+source,"F"+destination);
			
		}
	public void operation(){
		copieTableau();
		sheetSics.getRow(0).getCell(1).setCellValue(nomSfd);
		sheetSics.getRow(1).getCell(1).setCellValue(moisArrete);
	}
}
