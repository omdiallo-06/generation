package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau5 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau5.class);
	
	
	public Tableau5(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau51(){
       // UEMOA
		copieType(268,256);
        //Autres pays Africains	
		copieType(269,257);
        //Union Européenne
		copieType(270,258);
        //Etats-Unis	
		copieType(271,259);
        //Autres pays 	
		copieType(272,260);
////Transferts émis (2)				
        //UEMOA			
		copieType(274,262);
        //Autres pays Africains
		copieType(275,263);
        //Union Européenne
		copieType(276,264);
        //Etats-Unis	
		copieType(277,265);
        //Autres pays 	
		copieType(278,266);
	}
	
	public void copieTableau52(){
		//Montant de primes émises	
		copieTypeInt(283,279);
		//Assurance-vie		
		copieTypeInt(284,280);
		//Assurance non vie		
		copieTypeInt(285,281);
		//Montant des arriérés de primes	
		copieTypeInt(286,282);
		//Montant des sinistrés à payer		
		copieTypeInt(287,283);
	}

	public void copieTableau53(){
		//EURO (EUR)
		copieType1(291,288);
		//Dollar des EU (USD)
		copieType1(292,289);
		//Franc Suisse (CHF)
		copieType1(293,290);
		//Livre sterling (GBP)
		copieType1(294,291);
		//Autres
		copieType1(295,292);
	}
	
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void copieTypeInt(Integer source, Integer destination){
		//
		copieInt("G"+source,"G"+destination);
	}
	public void copieType1(Integer source, Integer destination){
		//
		copieInt("C"+source,"C"+destination);
		copieInt("E"+source,"D"+destination);
		copieInt("G"+source,"E"+destination);
		copieInt("I"+source,"F"+destination);
	}
	public void operation(){
		copieTableau51();
		copieTableau52();
		copieTableau53();
	}
}
