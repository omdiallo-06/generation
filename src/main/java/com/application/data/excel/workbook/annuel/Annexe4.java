package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.application.data.excel.workbook.annuel.annexe4.DetailDuCompte6221;
import com.application.data.excel.workbook.annuel.annexe4.EncoursDes10PlusGrosDebiteurs;
import com.application.data.excel.workbook.annuel.annexe4.EtatBienDetenuClauseReservePropriete;
import com.application.data.excel.workbook.annuel.annexe4.EtatBienDetenuConcession;
import com.application.data.excel.workbook.annuel.annexe4.EtatBienDonneEnCreditBail;
import com.application.data.excel.workbook.annuel.annexe4.EtatCreditEnSouffrance;
import com.application.data.excel.workbook.annuel.annexe4.EtatDAffectationDuResultat;
import com.application.data.excel.workbook.annuel.annexe4.EtatDeTraitementDeReevaluation;
import com.application.data.excel.workbook.annuel.annexe4.EtatDesRessourcesAffectees;
import com.application.data.excel.workbook.annuel.annexe4.EtatDesValeursImmobilisees;
import com.application.data.excel.workbook.annuel.annexe4.EtatEncoursPretsAuxDirigeants;
import com.application.data.excel.workbook.annuel.annexe4.EtatsEngagementsParSignature;
import com.application.data.excel.workbook.annuel.annexe4.EtatsInformationsAnnexes;
import com.application.data.excel.workbook.annuel.annexe4.TableauEmploisEtRessources;

public class Annexe4 {
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	public Annexe4(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		new TableauEmploisEtRessources(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2005"));
		new EtatBienDonneEnCreditBail(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2006"));
		new EtatBienDetenuConcession(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2007"));
		new EtatBienDetenuClauseReservePropriete(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2008"));
		new DetailDuCompte6221(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2009"));
		new EtatCreditEnSouffrance(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2010"));
		new EtatsInformationsAnnexes(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2011"));
		new EtatsEngagementsParSignature(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2011-1"));
		new EncoursDes10PlusGrosDebiteurs(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2012"));
		new EtatEncoursPretsAuxDirigeants(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2013"));
		new EtatDesRessourcesAffectees(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2014"));
		new EtatDesValeursImmobilisees(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2015"));
		new EtatDAffectationDuResultat(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2016"));
		new EtatDeTraitementDeReevaluation(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2018"));
	}
	
}
