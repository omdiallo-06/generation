package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau6 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau6.class);
	
	
	public Tableau6(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau61(){
		//Taux d'intérêt créditeur minimum servi sur les dépôts des membres, bénéficiaires ou clients				
		copieTypeInt(302, 300);
		//Taux d'intérêt créditeur maximum servi sur les dépôts des membres, bénéficiaires ou clients				
		copieTypeInt(303, 301);
		//Taux d'intérêt nominal débiteur minimum sur les crédits accordés aux membres, bénéficiaires ou clients				
		copieTypeInt(304, 302);
		//Taux d'intérêt nominal débiteur maximum sur les crédits accordés aux membres, bénéficiaires ou clients				
		copieTypeInt(305, 303);
		//Taux d'intérêt effectif global (**)		
		copieTypeInt(306, 304);
	}
	public void copieTableau62(){
		//Crédits immobiliers				
		copieType(310, 312);
		//Crédits d'équipement				
		copieType(311, 313);
		//Crédits à la consommation				
		copieType(312, 314);
		//Crédits trésorerie				
		copieType(313, 315);
		//Autres crédits
		copieType(314, 316);
	}
	public void copieTableau63(){
		//1
		copieType1(319, 322);
		//2
		copieType1(320, 323);
		//3
		copieType1(321, 324);
		//4
		copieType1(322, 325);
		//5
		copieType1(323, 326);
	}
	public void copieTableau64(){
		//Agriculture, sylviculture et pêche				
		copieType(327, 332);
		//Industries extractives				
		copieType(328, 333);
		//Industries manufacturières				
		copieType(329, 334);
		//Bâtiment et travaux publics				
		copieType(330, 335);
		//Commerce, restaurants et hôtels				
		copieType(331, 336);
		//Électricité, gaz, eau				
		copieType(332, 337);
		//Transports, entrepôts et communications				
		copieType(333, 338);
		//Assurances, services aux entreprises				
		copieType(334, 339);
		//Immobilier				
		copieType(335, 340);
		//Services divers
		copieType(336, 341);
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
		//REFERENCE
		copie("B"+source,"B"+destination);
		//Nature don
		copie("E"+source,"D"+destination);
		//evaluation financieere
		copie("H"+source,"F"+destination);
	}
	public void operation(){
		copieTableau61();
		copieTableau62();
		copieTableau63();
		copieTableau64();
	}
}
