package com.application.data.excel.workbook.periodique;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.periodique.bilanHorsBilan.BilanActifPeriodique;
import com.application.data.excel.workbook.periodique.bilanHorsBilan.BilanPassifPeriodique;
import com.application.data.excel.workbook.periodique.bilanHorsBilan.HorsBilanPeriodique;

public class BilanHorsBilanPeriodique {
	
//	protected static final Logger log = LoggerFactory.getLogger(BilanHorsBilanPeriodique.class);
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSicsPeriodique;
	
	public BilanHorsBilanPeriodique(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSicsPeriodique=workbookSics;
		operation();
	}
	
	public void operation(){
	//	log.info("bilan");
		new BilanActifPeriodique(sheetMasqueSaisie, workbookSicsPeriodique.getSheet("ACTIF"));
		new BilanPassifPeriodique(sheetMasqueSaisie, workbookSicsPeriodique.getSheet("PASSIF"));
		new HorsBilanPeriodique(sheetMasqueSaisie, workbookSicsPeriodique.getSheet("HORS_BILAN"));
	//	log.info("fin bilan");
	}
}
