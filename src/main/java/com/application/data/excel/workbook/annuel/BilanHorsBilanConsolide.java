package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.application.data.excel.workbook.annuel.consobilanHorsBilan.ConsoBilanActif;
import com.application.data.excel.workbook.annuel.consobilanHorsBilan.ConsoBilanPassif;
import com.application.data.excel.workbook.annuel.consobilanHorsBilan.ConsoHorsBilan;

public class BilanHorsBilanConsolide {
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	
	public BilanHorsBilanConsolide(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		new ConsoBilanActif(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2900_ACTIF"));
		new ConsoBilanPassif(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2900_PASSIF"));
		new ConsoHorsBilan(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2900_HORS_BILAN"));
	}
}
