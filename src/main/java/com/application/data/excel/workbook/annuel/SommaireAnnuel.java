package com.application.data.excel.workbook.annuel;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.utils.Colonne;


public class SommaireAnnuel {
	protected static final Logger log = LoggerFactory.getLogger(SommaireAnnuel.class);
	private Sheet sheetSICSSfd;
	private Sheet sheetMasqueSaisie;
	private String numeroAgrement;
		
	public SommaireAnnuel (Sheet sheetSICSSfd,Sheet sheetMasqueSaisie){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.sheetSICSSfd=sheetSICSSfd;
		operation();
		renseigneNumAgr();
	}
	
	
	public Cell readCell(String collonne,int row){
		int col=Colonne.col(collonne);
		if(sheetMasqueSaisie.getRow(row-1)!=null)
			return sheetMasqueSaisie.getRow(row-1).getCell(col-1);
		
		return null;
	}
	
	public void renseigneNumAgr(){
		Cell cell=null;
		cell=sheetMasqueSaisie.getRow(3).getCell(3);
		setNumeroAgrement(cell.getStringCellValue());
	}
	public void copieCell(String collonne,int row,Cell cellToCopie){
		int col=Colonne.col(collonne);
		FormulaEvaluator evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		Cell cell=sheetSICSSfd.getRow(row-1).getCell(col-1);
		
		if(cellToCopie!=null && cell!=null){
			Integer type=cellToCopie.getCellType();
			if(type.equals(Cell.CELL_TYPE_NUMERIC))
	 		   	cell.setCellValue(cellToCopie.getNumericCellValue());
	 		else if(type.equals(Cell.CELL_TYPE_STRING))
		        cell.setCellValue(cellToCopie.getStringCellValue());
			else if(type.equals(Cell.CELL_TYPE_FORMULA)){
				CellReference cfr=new CellReference(cellToCopie.getRowIndex(),cellToCopie.getColumnIndex());
				Row rowcfr = cellToCopie.getSheet().getRow(cfr.getRow());
				Cell cell1 = rowcfr.getCell(cfr.getCol()); 
				if (cell1!=null) {
					Integer type1=evaluator.evaluateInCell(cell1).getCellType();
			    if ( type1.equals(Cell.CELL_TYPE_BOOLEAN))
					cell.setCellValue(cell1.getBooleanCellValue());
			    if ( type1.equals( Cell.CELL_TYPE_NUMERIC ))
			    	cell.setCellValue(cell1.getNumericCellValue());
			    if ( type1.equals( Cell.CELL_TYPE_STRING))
			    		cell.setCellValue(cell1.getStringCellValue());
			 }
		}
								
		}
	}
	
	public void copieCellTrim(String collonne,int row,Cell cellToCopie){
		int col=Colonne.col(collonne);
		FormulaEvaluator evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		Cell cell=sheetSICSSfd.getRow(row-1).getCell(col-1);
		
		if(cellToCopie!=null && cell!=null){
			Integer type=cellToCopie.getCellType();
			if(type.equals(Cell.CELL_TYPE_NUMERIC))
	 		   	cell.setCellValue(cellToCopie.getNumericCellValue());
	 		else if(type.equals(Cell.CELL_TYPE_STRING))
		        cell.setCellValue(cellToCopie.getStringCellValue().trim());
			else if(type.equals(Cell.CELL_TYPE_FORMULA)){
				CellReference cfr=new CellReference(cellToCopie.getRowIndex(),cellToCopie.getColumnIndex());
				Row rowcfr = cellToCopie.getSheet().getRow(cfr.getRow());
				Cell cell1 = rowcfr.getCell(cfr.getCol()); 
				if (cell1!=null) {
					Integer type1=evaluator.evaluateInCell(cell1).getCellType();
			    if ( type1.equals(Cell.CELL_TYPE_BOOLEAN))
					cell.setCellValue(cell1.getBooleanCellValue());
			    if ( type1.equals( Cell.CELL_TYPE_NUMERIC ))
			    	cell.setCellValue(cell1.getNumericCellValue());
			    if ( type1.equals( Cell.CELL_TYPE_STRING))
			    		cell.setCellValue(cell1.getStringCellValue().trim());
			 }
		}
								
		}
	}
	
	public String getAnnee(){
		String annee="";
		Cell year=readCell("D", 2);
		log.info("Cellule est sous quel format ? :"+year.getCellType());
		if(year!=null)
			annee=String.valueOf(year.getNumericCellValue());
		return annee.substring(0,4);
	}
	public void copieFormulaCell(String collonne,int row,Cell cellToCopie){
		int col=Colonne.col(collonne);
		FormulaEvaluator evaluator = sheetSICSSfd.getWorkbook().getCreationHelper().createFormulaEvaluator();
		Cell cell=sheetSICSSfd.getRow(row-1).getCell(col-1);
		
		if(cellToCopie!=null && cell!=null){
			Integer type=cellToCopie.getCellType();
			if(type.equals(Cell.CELL_TYPE_NUMERIC))
	 		   	cell.setCellValue(cellToCopie.getNumericCellValue());
	 		else if(type.equals(Cell.CELL_TYPE_STRING))
		        cell.setCellValue(cellToCopie.getStringCellValue());
			else if(type.equals(Cell.CELL_TYPE_FORMULA)){
				//if(cellToCopie.getCachedFormulaResultType()==0){
					CellValue cellValue = evaluator.evaluate(cell);
					if(type.equals(Cell.CELL_TYPE_NUMERIC))
			 		   	cell.setCellValue(cellValue.getNumberValue());
			 		else if(type.equals(Cell.CELL_TYPE_STRING))
				        cell.setCellValue(cellValue.getStringValue());
					
			}
			
		}
	}
	public void operation() throws Error{
		//Copie D
		//Nom Sfd
		copieCellTrim("B", 2,readCell("D", 5));
		//log.info("Nom sfd "+readCell("D", 5));
		//NumAgrement
		copieCellTrim("B", 3,readCell("D", 4));
		//log.info("NumAgrement "+readCell("D", 4));
		//Annee
		copieCell("B", 4,readCell("D", 2));
		//log.info("Annee "+readCell("D", 2));
		//Trimestre
		//copieCell("B", 5,readCell("I", 3));
		//log.info("Trimestre" +readCell("I", 3));
		//MOIS (A ajouter)
		
		
	}
	
	public Sheet getSheetMasqueSaisie() {
		return sheetMasqueSaisie;
	}

	public void setSheetMasqueSaisie(Sheet sheetMasqueSaisie) {
		this.sheetMasqueSaisie = sheetMasqueSaisie;
	}
	
	public Sheet getSheetSICSSfd() {
		return sheetSICSSfd;
	}

	public void setSheetSICSSfd(Sheet sheetSICSSfd) {
		this.sheetSICSSfd = sheetSICSSfd;
	}

	public String getNumeroAgrement() {
		return numeroAgrement;
	}

	public void setNumeroAgrement(String numeroAgrement) {
		this.numeroAgrement = numeroAgrement;
	}
	
}
