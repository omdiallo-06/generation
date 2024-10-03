package com.application.data.excel.workbook.periodique.ratiosPrudentiels;

import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class IndicateurNonFinancierActivite extends MetaSheet{
	//protected static final Logger log = LoggerFactory.getLogger(IndicateurNonFinancierActivite.class);
	
	public IndicateurNonFinancierActivite(Sheet sheetMasqueSaisie, Sheet sheetSics) {
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieNombreMembreBeneficiaireClient(){
		//Hommes (a)	
		copie(9,8);
		//Femmes (b)
		copie(10,9);
		//Nombre de personnes morales (groupements, entreprises, associations, etc) (2)	
		copie(11,10);
		//Nombre de groupements de personnes physiques bénéficiaires	
		copie(12,11);
		//Hommes (c)	
		copie(14,13);
		//Femmes (d)
		copie(15,14);
	}
	
	public void copieEffectifDirigeantPersonnel(){
		//Nombre de membres du conseil d'administration ou de l'organe équivalent				3562
		copie(19,20);
		//Nombre de membres du conseil de surveillance, s'il y a lieu				
		copie(20,21);
		//Nombre de membres du comité de crédit, s'il y a lieu				
		copie(21,22);
		//Dirigeants (employés exerçant des fonctions de direction ou de gérance) (1)				
		copie(24,24);
		//Autres Employés (2)				
		copie(27,25);
		//Agents nationaux sous contrat à durée indéterminée				4281
		//Agents nationaux sous contrats à durée déterminée				
		//Personnel expatrié sous contrat à durée indéterminée				
		//Personnel expatrié sous contrat à durée déterminée
	}
	
	public void copieNombreDeposant(){
		//Hommes (a)				
		copie(87,38);
		//Femmes (b)				
		copie(88,39);
		//Nombres de déposants personnes morales (groupements de personnes physiques,entreprises, associations, etc ) (2)
		copie(89,40);
	}
	
	public void copieNbCreditEncours(){
		//Nombre de crédits en cours sur les hommes (a)				
		copie(120,49);
		//Nombre de crédits en cours sur les femmes (b)				
		copie(121,50);
		//Nombre de crédits en cours sur les personnes morales (groupements de personnes physiques, entreprises, associations, etc.)(2)					
		copie(122,51);
	}
	
	public void copieRepartitionCredit(){
		//Crédits immobiliers				
		copie(310,58);
		//Crédits d'équipement				
		copie(311,59);
		//Crédits à la consommation				
		copie(312,60);
		//Crédits de trésorerie				
		copie(313,61);
		//Autres crédits				
		copie(314,62);
	}
	
	public void copieNbCreditSouffrance(){
		//Nombre de crédits en souffrance sur les hommes (a)				
		copie(259,71);
		//Nombre de crédits en souffrance sur les femmes (b)				
		copie(260,72);
		//Nombre de crédits en souffrance sur les personnes morales (groupements de personnes physiques, entreprises, associations, etc.)(2)				
		copie(261,73);
	}
	
	public void copieIndicateurSurveillance(){
		//Nombre d'institutions affiliées 				
		//Nombre d'institutions affiliées contrôlées				
		copie(371,81);
		//Taux de mise en œuvre des recommandations formulées au cours des contrôles				
		copie(373,82);
		//Nombre de réunions tenues par le conseil de surveillance				
		copie(374,83);
		//Nombre d'agences ou de points de services				
		copie(372,84);
		//Nombre de rapports de contrôle interne				
		copie(375,85);
	}
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("G"+source,"G"+destination);
	}
	
	public void operation(){
		copieNombreMembreBeneficiaireClient();
		copieEffectifDirigeantPersonnel();
		copieNombreDeposant();
		copieNbCreditEncours();
		copieRepartitionCredit();
		copieNbCreditSouffrance();
		copieIndicateurSurveillance();
	}
}
