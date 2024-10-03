package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.workbook.annuel.instructions18.Tableau1;
import com.application.data.excel.workbook.annuel.instructions18.Tableau10;
import com.application.data.excel.workbook.annuel.instructions18.Tableau2;
import com.application.data.excel.workbook.annuel.instructions18.Tableau3;
import com.application.data.excel.workbook.annuel.instructions18.Tableau4;
import com.application.data.excel.workbook.annuel.instructions18.Tableau5;
import com.application.data.excel.workbook.annuel.instructions18.Tableau6;
import com.application.data.excel.workbook.annuel.instructions18.Tableau7;
import com.application.data.excel.workbook.annuel.instructions18.Tableau8;
import com.application.data.excel.workbook.annuel.instructions18.Tableau9;

public class Instruction18 {
	protected static final Logger log = LoggerFactory.getLogger(Instruction18.class);
	protected Sheet sheetMasqueSaisie;
	protected Workbook workbookSics;
	public Instruction18(Sheet sheetMasqueSaisie,Workbook workbookSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.workbookSics=workbookSics;
		operation();
	}
	
	public void operation(){
		Sheet sheetSics=workbookSics.getSheet("ANNEXES_AU_RAPPORT_ANNUEL");
		new Tableau1(sheetMasqueSaisie, sheetSics);
		new Tableau2(sheetMasqueSaisie, sheetSics);
		new Tableau3(sheetMasqueSaisie, sheetSics);
		new Tableau4(sheetMasqueSaisie, sheetSics);
		new Tableau5(sheetMasqueSaisie, sheetSics);
		new Tableau6(sheetMasqueSaisie, sheetSics);
		new Tableau7(sheetMasqueSaisie, sheetSics);
		new Tableau8(sheetMasqueSaisie, sheetSics);
		new Tableau9(sheetMasqueSaisie, sheetSics);
		new Tableau10(sheetMasqueSaisie, sheetSics);
		}
	
}
