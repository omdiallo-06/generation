package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.application.data.excel.workbook.annuel.bilanHorsBilan.BilanActif;
import com.application.data.excel.workbook.annuel.bilanHorsBilan.BilanPassif;
import com.application.data.excel.workbook.annuel.bilanHorsBilan.HorsBilan;

public class BilanHorsBilan {
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	
	public BilanHorsBilan(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		new BilanActif(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2000_ACTIF_DEV"));
		new BilanPassif(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2000_PASSIF_DEV"));
		new HorsBilan(sheetMasqueSaisie, workbookSics.getSheet("DIMF_2000_HORS_BILAN_DEV"));
	}
}
