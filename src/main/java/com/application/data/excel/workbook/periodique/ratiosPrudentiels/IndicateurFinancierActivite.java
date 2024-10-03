package com.application.data.excel.workbook.periodique.ratiosPrudentiels;

import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.MetaSheet;

public class IndicateurFinancierActivite extends MetaSheet{
	//protected static final Logger log = LoggerFactory.getLogger(IndicateurFinancierActivite.class);
	
	public IndicateurFinancierActivite(Sheet sheetMasqueSaisie, Sheet sheetSics) {
		super(sheetMasqueSaisie, sheetSics);
	}
	
	public void copieIndicateurQualitePortefeuille(){
		//encours echeance 30j
		copieInt(212,5);
		//encours echeance 90j
		copieInt(213,6);
		//encours echeance 180j
		copieInt(214,7);
	}
	
	public void copieIndicateurDActivite(){
		//Montant total credit decaisses au cours de la periode
		copieInt(264,19);
		//Nombre total de credit decaisses au cours de la periode
		copieInt(268,20);
		//Nombre d'epargnant a la fin de la periode
		copieInt(284,23);
		//Nombre total d'eemprunteur a la fin de la periode
		copieInt(300,26);
	}
	
	public void copieIndicateurDEfficacite(){
		//Nombre d'agent de credit
		copie(315,30);
		//Nombres d'employer
		copie(323,33);
		//Montant brut moyen du portefeuille durant la periode
		copie(354,36);
	}
	
	public void copieIndicateurDeRentabilite(){
		//Montant moyen des fonds propres pour la periode
		copie(44,48);
		
	}
	public void copie(Integer source, Integer destination){
		//Amortissement
		copie("D"+source,"F"+destination);
	}
	
	public void copieInt(Integer source, Integer destination){
		//Amortissement
		copieInt("D"+source,"F"+destination);
	}
	
	public void operation(){
		copieIndicateurQualitePortefeuille();
		copieIndicateurDActivite();
		copieIndicateurDEfficacite();
		copieIndicateurDeRentabilite();
	}
}
