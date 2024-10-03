package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.application.data.excel.workbook.annuel.consoCompteResultat.ConsoCompteResultatCharge;
import com.application.data.excel.workbook.annuel.consoCompteResultat.ConsoCompteResultatProduit;

public class CompteResultatConsolide {
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	
	public CompteResultatConsolide(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		new ConsoCompteResultatCharge(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2980_CHARGES"));
		new ConsoCompteResultatProduit(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2980_PRODUITS"));
	}
}
