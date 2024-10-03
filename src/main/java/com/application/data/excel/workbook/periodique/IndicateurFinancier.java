package com.application.data.excel.workbook.periodique;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.periodique.ratiosPrudentiels.IndicateurFinancierActivite;
import com.application.data.excel.workbook.periodique.ratiosPrudentiels.IndicateurNonFinancierActivite;

public class IndicateurFinancier {
	
//	protected static final Logger log = LoggerFactory.getLogger(IndicateurFinancier.class);
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSicsPeriodique;
	
	public IndicateurFinancier(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSicsPeriodique=workbookSics;
		operation();
	}
	
	public void operation(){
		new IndicateurFinancierActivite(sheetMasqueSaisie, workbookSicsPeriodique.getSheet("INDICATEURS_FINANCIERS_ACTIVITE"));
		new IndicateurNonFinancierActivite(sheetMasqueSaisie.getWorkbook().getSheet("Instruction 18"), workbookSicsPeriodique.getSheet("INDICATEURS_NON_FINANCIERS_ACTI"));
		//new HorsBilanPeriodique(sheetMasqueSaisie, workbookSicsPeriodique.getSheet("INSTRUCTION_NUMERO_18"));
	}
}
