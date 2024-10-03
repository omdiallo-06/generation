package com.application.data.excel.workbook.annuel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.application.data.excel.workbook.MetaSheet;

public class Etat50PlusGrosClients extends MetaSheet{
	
	public Etat50PlusGrosClients(Sheet sheetMasqueSaisie,XSSFSheet sheetEtatFinancier){
		super(sheetMasqueSaisie, sheetEtatFinancier);
	}
}
