package com.application.data.excel.workbook.annuel.instructions18;


import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class Tableau4 extends MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(Tableau4.class);
	
	
	public Tableau4(Sheet sheetMasqueSaisie,Sheet sheetSics){
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieTableau41(){
		//montant pret homme
		copieTypeInt(112,138);
		//montant pret femme
		copieTypeInt(113,139);
		//montant pret pers morale
		copieTypeInt(114,140);
	}
	public void copieTableau42(){
		//nb pret homme
		copieTypeInt(120,150);
		//nb pret femme
		copieTypeInt(121,151);
		//nb pret pers morale
		copieTypeInt(122,152);
	}
	public void copieTableau43(){
		//Engagement des financementsdonne en faveur des if
		copieTypeInt(127,159);
		//faveur memebre beneficiaire ou client
		copieTypeInt(128,160);
		//garantie d'ordre if
		copieTypeInt(129,161);
		//garantie d'ordre memebre beneficiaire ou client
		copieTypeInt(130,162);
	}
	public void copieTableau44(){
		//encours pret homme
		copieTypeInt(136,170);
		//encours pret femme
		copieTypeInt(137,171);
		//encours pret pers morale
		copieTypeInt(138,172);
	}
	public void copieTableau45(){
		//nb credit homme
		copieTypeInt(144,180);
		//nb credit femme
		copieTypeInt(145,181);
		//nb credit pers morale
		copieTypeInt(146,182);
	}
	public void copieTableau46(){
	//court terme Total
		copieTypeInt(150,189);
		//nb credit homme
		//copieType(151,182);
		//nb credit femme
		//copieType(152,183);
		//nb credit pers morale
		//copieType(153,184);
	//moyen et long terme Total	
		copieTypeInt(154,190);
		//nb credit homme
		//copieType(155,182);
		//nb credit femme
		//copieType(156,183);
		//nb credit pers morale
		//copieType(157,184);
	}
	public void copieTableau47(){
		//1
		copieType1(161,196);
		//2
		copieType1(162,197);
		//3
		copieType1(163,208);
		//4
		copieType1(164,199);
		//5
		copieType1(165,200);
	}
	public void copieTableau48(){
		//Nb credit sur ressources affectées
		copieTypeInt(169,206);
		//montant credit sur ressources affectes
		copieTypeInt(181,207);
		//nb credit en cours sur ra
		copieTypeInt(193,208);
		//montant credit en cours sur ra
		copieTypeInt(205,209);
	}
	public void copieTableau49(){
		//********Encours des créances en souffrance (en milliers de FCFA)				
		copieTypeInt(249,218);
		//Taux brut des créances en souffrance3				
		copieTypeInt(221,216);
		//Taux de remboursement des crédits accordés4				
		copieTypeInt(222,217);
		//Taux de recouvrement des créances en souffrance 				
		copieTypeInt(223,218);
		//Encours brut des créances en souffrance sur ressources affectées (en milliers de FCFA)				
		copieTypeInt(224,219);
		//Taux brut de créances en souffrance sur ressources affectées6				
		copieTypeInt(225,220);
		//Taux de remboursement  crédits accordés sur ressources affectées7				
		copieTypeInt(226,221);
		//Taux de recouvrement des créances en souffrance sur ressources affectées8				
		copieTypeInt(227,222);
		//Montant des crédits passés en pertes (en milliers de FCFA)				
		copieTypeInt(228,223);
		//taux de perte sur créances9				
		copieTypeInt(229,224);
	}
	/*public void copieTableau410(){
		//
		copieType(,);
	}
	public void copieTableau411(){
		//
		copieType(,);
	}
	public void copieTableau412(){
		//
		copieType(,);
	}
	public void copieTableau413(){
		//
		copieType(,);
	}*/
	
	public void copieType1(Integer source, Integer destination){
		//Noms et prenoms
		copie("B"+source,"B"+destination);
		//encours total
		copie("E"+source,"D"+destination);
		//structure de l'emprunteur
		copie("H"+source,"F"+destination);
	}
	public void copieType(Integer source, Integer destination){
		//
		copie("G"+source,"G"+destination);
	}
	public void copieTypeInt(Integer source, Integer destination){
		//
		copieInt("G"+source,"G"+destination);
	}
	public void operation(){
		copieTableau41();
		copieTableau42();
		copieTableau43();
		copieTableau44();
		copieTableau45();
		copieTableau46();
		copieTableau47();
		copieTableau48();
		copieTableau49();
		/*copieTableau410();
		copieTableau411();
		copieTableau412();
		copieTableau413();**/
	}
}
