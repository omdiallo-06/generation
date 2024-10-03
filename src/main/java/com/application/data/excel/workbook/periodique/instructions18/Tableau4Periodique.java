package com.application.data.excel.workbook.periodique.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau4;

public class Tableau4Periodique extends Tableau4 {
	//protected static final Logger log = LoggerFactory.getLogger(Tableau4Periodique.class);
	
	
	public Tableau4Periodique(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau41(){
		//montant pret homme
		copieTypeInt(112,138+4);
		//montant pret femme
		copieTypeInt(113,139+4);
		//montant pret pers morale
		copieTypeInt(114,140+4);
	}
	public void copieTableau42(){
		//nb pret homme
		copieTypeInt(120,150+4);
		//nb pret femme
		copieTypeInt(121,151+4);
		//nb pret pers morale
		copieTypeInt(122,152+4);
	}
	public void copieTableau43(){
		//Engagement des financementsdonne en faveur des if
		copieTypeInt(127,159+4);
		//faveur memebre beneficiaire ou client
		copieTypeInt(128,160+4);
		//garantie d'ordre if
		copieTypeInt(129,161+4);
		//garantie d'ordre memebre beneficiaire ou client
		copieTypeInt(130,162+4);
	}
	public void copieTableau44(){
		//encours pret homme
		copieTypeInt(136,170+4);
		//encours pret femme
		copieTypeInt(137,171+4);
		//encours pret pers morale
		copieTypeInt(138,172+4);
	}
	public void copieTableau45(){
		//nb credit homme
		copieTypeInt(144,180+4);
		//nb credit femme
		copieTypeInt(145,181+4);
		//nb credit pers morale
		copieTypeInt(146,182+4);
	}
	public void copieTableau46(){
	//court terme Total
		copieTypeInt(150,189+4);
		//nb credit homme
		//copieType(151,182);
		//nb credit femme
		//copieType(152,183);
		//nb credit pers morale
		//copieType(153,184);
	//moyen et long terme Total	
		copieTypeInt(154,190+4);
		//nb credit homme
		//copieType(155,182);
		//nb credit femme
		//copieType(156,183);
		//nb credit pers morale
		//copieType(157,184);
	}
	public void copieTableau47(){
		//1
		copieType1(161,196+4);
		//2
		copieType1(162,197+4);
		//3
		copieType1(163,198+4);
		//4
		copieType1(164,199+4);
		//5
		copieType1(165,200+4);
	}
	public void copieTableau48(){
		//Nb credit sur ressources affectées
		copieTypeInt(169,214);
		//montant credit sur ressources affectes
		copieTypeInt(181,215);
		//nb credit en cours sur ra
		copieTypeInt(193,216);
		//montant credit en cours sur ra
		copieTypeInt(205,217);
	}
	public void copieTableau49(){
		//********Encours des créances en souffrance (en milliers de FCFA)				
		copieTypeInt(249,223);
		//Taux brut des créances en souffrance3				
		copieTypeInt(221,224);
		//Taux de remboursement des crédits accordés4				
		copieTypeInt(222,225);
		//Taux de recouvrement des créances en souffrance 				
		copieTypeInt(223,226);
		//Encours brut des créances en souffrance sur ressources affectées (en milliers de FCFA)				
		copieTypeInt(224,227);
		//Taux brut de créances en souffrance sur ressources affectées6				
		copieTypeInt(225,228);
		//Taux de remboursement  crédits accordés sur ressources affectées7				
		copieTypeInt(226,229);
		//Taux de recouvrement des créances en souffrance sur ressources affectées8				
		copieTypeInt(227,230);
		//Montant des crédits passés en pertes (en milliers de FCFA)				
		copieTypeInt(228,231);
		//taux de perte sur créances9				
		copieTypeInt(229,232);
	}

}
