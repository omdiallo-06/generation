package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.application.data.excel.workbook.annuel.compteResultat.CompteResultatCharge;
import com.application.data.excel.workbook.annuel.compteResultat.CompteResultatProduit;

public class CompteResultat {
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	
	public CompteResultat(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		new CompteResultatCharge(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2080_CHARGE_DEV"));
		new CompteResultatProduit(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2080_PRODUITS_DEV"));
	}
}
