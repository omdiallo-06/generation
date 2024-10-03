package com.application.data.excel.workbook;

import java.util.Iterator;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.utils.Colonne;

public class MetaSheet {
	protected static final Logger log = LoggerFactory.getLogger(MetaSheet.class);
//	protected static final Logger log1 = LoggerFactory.getLogger();
	protected Sheet sheetMasqueSaisie;
	protected Sheet sheetSics;
	protected XSSFSheet sheetSicss;
	protected FormulaEvaluator evaluator;
	protected String nomSfd;
	protected String moisArrete;
	
	
	
	public MetaSheet(Sheet sheetMasqueSaisie,XSSFSheet sheetSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.sheetSics=sheetSics;
		evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		operation();
	}
	public MetaSheet(Sheet sheetMasqueSaisie,Sheet sheetSics){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.sheetSics=sheetSics;
	//	System.out.println("--sheetMasqueSaisie--"+sheetMasqueSaisie);
	//	System.out.println("--sheetSics--"+sheetSics);
	//	System.out.println("--sheetMasqueSaisiename--"+sheetMasqueSaisie.getSheetName());
	//	System.out.println("--sheetSicsname--"+sheetSics.getSheetName());
		evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		operation();
	}
	
	public MetaSheet(Sheet sheetMasqueSaisie,Sheet sheetSics,String nomSfd,String moisArrete){
		this.sheetMasqueSaisie=sheetMasqueSaisie;
		this.sheetSics=sheetSics;
		this.nomSfd=nomSfd;
		this.moisArrete=moisArrete;
		evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		operation();
	}
	
	
	public Cell readCell(String collonne,int row){
		int col=Colonne.col(collonne);
		if(sheetMasqueSaisie.getRow(row-1)!=null)
				return sheetMasqueSaisie.getRow(row-1).getCell(col-1);

		return null;
	}
	
	public void copieCell(String collonne,int row,Cell cellToCopie){
		int col=Colonne.col(collonne);
		copieCell(col,row,cellToCopie);
	}
	public void copieCell(int col,int row,Cell cellToCopie){
		Cell cell=sheetSics.getRow(row).getCell(col);
		//FormulaEvaluator evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		if(cellToCopie!=null&& cell!=null){
			Integer type=cellToCopie.getCellType();
			if (cell.getCellType()!=Cell.CELL_TYPE_FORMULA){
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
	}
	
	public void copieCell(Cell cellToCopie,Cell cellDestination){
		//Cell cell=sheetSics.getRow(row).getCell(col);
		if(cellToCopie!=null&& cellDestination!=null){
			Integer type=cellToCopie.getCellType();
			if (cellDestination.getCellType()!=Cell.CELL_TYPE_FORMULA){
				if(type.equals(Cell.CELL_TYPE_NUMERIC))
					cellDestination.setCellValue(cellToCopie.getNumericCellValue());
				else if(type.equals(Cell.CELL_TYPE_STRING)&& ((!cellToCopie.getStringCellValue().equalsIgnoreCase("NEANT")) && (!cellToCopie.getStringCellValue().equalsIgnoreCase("NéANT"))))
					cellDestination.setCellValue(cellToCopie.getStringCellValue());
				else if(type.equals(Cell.CELL_TYPE_FORMULA)){
					CellReference cfr=new CellReference(cellToCopie.getRowIndex(),cellToCopie.getColumnIndex());
					Row rowcfr = cellToCopie.getSheet().getRow(cfr.getRow());
					Cell cell1 = rowcfr.getCell(cfr.getCol()); 
					if (cell1!=null) {
						Integer type1=evaluator.evaluateInCell(cell1).getCellType();
					    if ( type1.equals(Cell.CELL_TYPE_BOOLEAN))
					    	cellDestination.setCellValue(cell1.getBooleanCellValue());
					    if ( type1.equals( Cell.CELL_TYPE_NUMERIC ))
					    	cellDestination.setCellValue(cell1.getNumericCellValue());
					    if ( type1.equals( Cell.CELL_TYPE_STRING))
					    	cellDestination.setCellValue(cell1.getStringCellValue());
					}
				 }else if(type.equals(Cell.CELL_TYPE_BLANK)){
					 if(cellDestination.getCellType()==Cell.CELL_TYPE_NUMERIC)
						 cellDestination.setCellValue(0);
					 else if(cellDestination.getCellType()==Cell.CELL_TYPE_STRING)
						 cellDestination.setCellValue("");
					 
				 }
			}
		}
	}
	
	public void copieCellInt(Cell cellToCopie,Cell cellDestination){
		//Cell cell=sheetSics.getRow(row).getCell(col);
	//	FormulaEvaluator evaluator = sheetMasqueSaisie.getWorkbook().getCreationHelper().createFormulaEvaluator();
		if(cellToCopie!=null&& cellDestination!=null){
			Integer type=cellToCopie.getCellType();
			if (cellDestination.getCellType()!=Cell.CELL_TYPE_FORMULA){
				if(type.equals(Cell.CELL_TYPE_NUMERIC))
					cellDestination.setCellValue(cellToCopie.getNumericCellValue());
				else if(type.equals(Cell.CELL_TYPE_FORMULA)){
					CellReference cfr=new CellReference(cellToCopie.getRowIndex(),cellToCopie.getColumnIndex());
					Row rowcfr = cellToCopie.getSheet().getRow(cfr.getRow());
					Cell cell1 = rowcfr.getCell(cfr.getCol()); 
					if (cell1!=null) {
						Integer type1=evaluator.evaluateInCell(cell1).getCellType();
					    if ( type1.equals(Cell.CELL_TYPE_BOOLEAN))
					    	cellDestination.setCellValue(cell1.getBooleanCellValue());
					    if ( type1.equals( Cell.CELL_TYPE_NUMERIC ))
					    	cellDestination.setCellValue(cell1.getNumericCellValue());
					}
				 }else if(type.equals(Cell.CELL_TYPE_BLANK)){
					 if(cellDestination.getCellType()==Cell.CELL_TYPE_NUMERIC)
						 cellDestination.setCellValue(0);					 
				 }
			}
		}
	}
	
	public void copie(Sheet sheetMasqueSaisie){
		  Cell cell=null;
	      for(int i=0;i<sheetMasqueSaisie.getLastRowNum();i++){
	          Row row=sheetMasqueSaisie.getRow(i);
	          if(row!=null){
		               for (Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
			  				cell = (Cell) cellIt.next();
			  				if(cell!=null  && ((cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC ) || (cell.getCellType()==XSSFCell.CELL_TYPE_FORMULA ) || (cell.getCellType()==XSSFCell.CELL_TYPE_STRING && !cell.getCellStyle().getLocked()) )){
				  					copieCell(cell.getColumnIndex(), cell.getRowIndex(), cell);
			  				}
		               }
	           }
	      }
	}
	
/*	public void copie(String source, String destination){
		Cell cellSource =cellMasqueSaisie(source);
		Cell cellDesti = cellSics(destination); 
		copieCell(cellSource,cellDesti);
	}*/
	public void copie(String source, String destination){
		copieCell(cellMasqueSaisie(source),cellSics(destination));
	}
	
	/*public void copieInt(String source, String destination){
		Cell cellSource =cellMasqueSaisie(source);
		Cell cellDesti = cellSics(destination); 
		copieCellInt(cellSource,cellDesti);
	}*/
	public void copieInt(String source, String destination){
		//Cell cellSource =cellMasqueSaisie(source);
		//Cell cellDesti = cellSics(destination); 
		copieCellInt(cellMasqueSaisie(source),cellSics(destination));
	}
	
	public Cell cellMasqueSaisie(String pos){
		CellReference cellReference = new CellReference(pos); 
		return  sheetMasqueSaisie.getRow(cellReference.getRow()).getCell(cellReference.getCol());		
	}
	
	public Cell cellSics(String pos){
		CellReference cellReference = new CellReference(pos); 
		return  sheetSics.getRow(cellReference.getRow()).getCell(cellReference.getCol());		
	}

	
	public void operation(){
		copie(getSheetMasqueSaisie());
	}
	
	public void evaluate(){
		FormulaEvaluator evaluatorSics = getSheetSics().getWorkbook().getCreationHelper().createFormulaEvaluator();
		evaluatorSics.evaluateAll();
	/*	XSSFRow row = null;
		XSSFCell cell = null;
		for (Iterator<Row> rowIt = getSheetSics().rowIterator(); rowIt.hasNext();) {
			row = (XSSFRow) rowIt.next();
			for (Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
				cell = (XSSFCell) cellIt.next();
				evaluator.evaluateFormulaCell(cell);
			}
		}*/
		
	}
	
	public Sheet getSheetMasqueSaisie() {
		return sheetMasqueSaisie;
	}

	public void setSheetMasqueSaisieXlsx(XSSFSheet sheetMasqueSaisie) {
		this.sheetMasqueSaisie = sheetMasqueSaisie;
	}
	

	public Sheet getSheetSics() {
		return sheetSics;
	}

	public void setSheetSics(XSSFSheet sheetEtatFinancier) {
		this.sheetSics = sheetEtatFinancier;
	}
}
