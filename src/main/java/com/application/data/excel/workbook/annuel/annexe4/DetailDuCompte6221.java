package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class DetailDuCompte6221 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(DetailDuCompte6221.class);
	
	
	public DetailDuCompte6221(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//1 cadre sup
		copieType(76, 4);
		//2 tech sup ou cadre moy
		copieType(77, 5);
		//3 tech agents de maitrise
		copieType(78, 6);
		//4 employe manoeuvre ouvriers
		copieType(79, 7);
		//5 permanent
		copieType(81, 9);
		//6 saisonier
		copieType(82, 10);
	}
	
	public void copieType(Integer source, Integer destination){
		//nationaux
		copieInt("D"+source,"C"+destination);
		//Autres UMOA
		copieInt("E"+source,"D"+destination);
		//Hors UMOA
		copieInt("F"+source,"E"+destination);
		//Secteur primaire 
		copieInt("G"+source,"F"+destination);
		//Secteur secondaire
		copieInt("H"+source,"G"+destination);
		//tertiaire
		copieInt("I"+source,"H"+destination);
		//facturation a l'institution
		copieInt("K"+source,"J"+destination);
	}
	public void operation(){
		copieTableau();
	}
}
