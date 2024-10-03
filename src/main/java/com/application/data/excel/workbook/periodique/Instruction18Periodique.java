package com.application.data.excel.workbook.periodique;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.periodique.instructions18.*;

public class Instruction18Periodique {
//	protected static final Logger log = LoggerFactory.getLogger(Instruction18Periodique.class);
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	public Instruction18Periodique(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		Sheet sheetSics=workbookSics.getSheet("INSTRUCTION_NUMERO_18");
		new Tableau1Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau2Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau3Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau4Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau5Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau6Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau7Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau8Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau9Periodique(sheetMasqueSaisie, sheetSics);
		new Tableau10Periodique(sheetMasqueSaisie, sheetSics);
		}
	
}
