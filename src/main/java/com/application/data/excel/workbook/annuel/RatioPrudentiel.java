package com.application.data.excel.workbook.annuel;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.application.data.excel.workbook.MetaSheet;

public class RatioPrudentiel extends MetaSheet{
	
	public RatioPrudentiel(Sheet sheetMasqueSaisie,XSSFSheet sheetEtatFinancier){
		super(sheetMasqueSaisie, sheetEtatFinancier);
	}
	
	public void copie(Sheet sheetMasqueSaisie){
		Cell cell=null;
	    for(int i=0;i<sheetMasqueSaisie.getLastRowNum();i++){
          Row row=sheetMasqueSaisie.getRow(i);
          if(row!=null){
    	       for (Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
            	  	cell = (Cell) cellIt.next();
            	  	if(cell.getColumnIndex()<10){
	            	  	if(cell!=null &&(cell.getCellType()==Cell.CELL_TYPE_NUMERIC || (cell.getCellType()==Cell.CELL_TYPE_FORMULA))){
		  						copieCell(cell.getColumnIndex(), cell.getRowIndex(), cell);
		  				}
            	  	}
               }
           }
      }
	}
}
