package com.application.data.excel.workbook.annuel.annexe4;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class EtatsInformationsAnnexes extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(EtatsInformationsAnnexes.class);
	
	
	public EtatsInformationsAnnexes(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau(){
		//Encours des engagements par signature à court terme
		copieType(99,3);
		//Encours des engagements par signature à moyen et long termes
		copieType(100,4);
		//Montant total consacré par l'institution aux opérations autre que les activités d'épargne et de crédit
		copieType(101,5);
		//Nombre total de membres, bénéficiaires ou clients de l'institution
		copieType(102,6);
		//Nombre total de groupements de l'institution ainsi que de leur membres
		copieType(103,7);
		//Nombre total de membres, bénéficiaires ou clients de sexe masculin de l'institution
		copieType(104,8);
		//Nombre total de membres, bénéficiaires ou clients de sexe féminin de l'institution
		copieType(105,9);
		//Nombre total de groupements bénéficiaires
		copieType(106,10);
		//Nombre total d'usagers bénéficiaires
		copieType(107,11);
		//Nombre total de sociétaires bénéficiaires
		copieType(108,12);
		//Population cible de la caisse (ou son estimation)
		copieType(109,13);
		//126-127-128 Dépôts à plus d'un an du SFD auprès des institutions financières
		copieType(110,14);
		//252- Dépôts à terme à plus d'un an des membres, bénéficiaires ou clients auprès de la caisse
		copieType(111,15);
		//253-Comptes d'épargne à régime spécial
		copieType(112,16);
		//254-255- Autres dépôts à plus d'un an des membres, bénéficiaires ou clients auprès de la caisse
		copieType(113,17);
		//Recouvrements sur prêts intervenus au cours de l'exercice
		copieType(114,18);
		//Recouvrements sur prêts attendus au cours de l'exercice
		copieType(115,19);
		
	}
	
	public void copieType(Integer source, Integer destination){
		//nationaux
		copieInt("D"+source,"C"+destination);
	}
	
	public void operation(){
		copieTableau();
	}
}
