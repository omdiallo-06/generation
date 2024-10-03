package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau1 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau1.class);
	
	
	public Tableau1(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau11(){
		//      Hommes (a)	
		copie(9,9);
		//      Femmes (b)	
		copie(10,10);
		//Nombre de personnes morales (groupements de personnes physiques, entreprises, associations, etc) (2)	
		copie(11,11);
		//Nombre de groupements de personnes physiques bénéficiaires	
		copie(12,12);
		
		//Hommes ( c )	
		copie(14,14);
		//Femmes (d)	
		copie(15,15);


			
	}
	
	public void copieTableau12(){
		//Nombre de membres du Conseil d'Administration ou de l'organe équivalent	
		copie(19,21);
		//Nombre de membres du Conseil de Surveillance (*)	
		copie(20,22);
		//Nombre de membres du Comité de Crédit (*)	
		copie(21,23);
		//nombre de membres des autres comités créés par les SFD (**)	
		copie(22,24);
			
			
		//   - nationaux   	
		copie(25,27);
		//   - personnel expatrié	
		copie(26,28);
			
		//Agents permanents (a)	
		copie(28,30);
		//Agents contractuels (b)	
		copie(29,31);
		//Personnel expatrié ( c )	
		copie(30,32);
	}
	
	public void copieTableau13(){

		// Etat des renumerations dirigeants et personnel
		//- Personnel dirigeant (Directeur Général et son adjoint, Directeur de service) ;    	
		copie(37,43);
		//- Autre personnel	
		copie(38,44);
		//Montant des frais généraux en FCFA	
		copie(39,45);
		
		//Tableau remboursement frais dirigeant elu
				
		//Indemnités de fonctions versées aux administrateurs non salariés2 en FCFA	
		copie(45,55);
		// - Perdiem   	
		copie(47,57);
		//- Transport	
		copie(48,58);
		//	    - Hébergement	
		copie(49,59);
		//	    - Téléphone	
		copie(50,60);
		//   - Carburant	
		copie(51,61);
		//	    - Autres	
		copie(52,62);
	}
	
	public void copie(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau11();
		copieTableau12();
		copieTableau13();
	}
}
