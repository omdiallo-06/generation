package com.application.data.excel.workbook.periodique;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.utils.Colonne;


public class SommairePeriodique {
	protected static final Logger log = LoggerFactory.getLogger(SommairePeriodique.class);
	private Sheet sheetSICSSfd;
	private Sheet sheetMasqueSaisie;
	private String numeroAgrement;
	private String retour;
	
	public SommairePeriodique (Sheet sheetSICSSfd,Sheet sheetMasqueSaisie){
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
	
	
	public void copieCell(String collonne,int row,String stringToCopie){
		int col=Colonne.col(collonne);
		Cell cell=sheetSICSSfd.getRow(row-1).getCell(col-1);
		
		if(stringToCopie!=null){
		    cell.setCellValue(stringToCopie);
		}
								
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
	
	public String getAnnee(){
		String annee="";
		Cell year=readCell("D", 2);
		if(year!=null)
			annee=String.valueOf(year.getNumericCellValue());
		return annee.substring(0,4);
	}
	
	
	public void operation() throws Error{
		retour="";
		//Copie D
		//Nom Sfd
		copieCell("B", 2,readCell("D", 5));
		//log.info("Nom sfd "+readCell("D", 5));
		//NumAgrement
		copieCell("B", 3,readCell("D", 4));
		//log.info("NumAgrement "+readCell("D", 4));
		//Annee
		copieCell("B", 4,readCell("D", 2));
		//log.info("Annee "+readCell("D", 2));
		String periodicite=readCell("I", 2).getStringCellValue();
		String periode=readCell("I", 3).getStringCellValue();
		log.info("periode :"+periode.split("-")[0].substring(1));
		log.info("periodicite :"+periodicite);
		if(periodicite.equalsIgnoreCase("Mensuelle")){
			//Mois
			log.info("Mensuelle");
			copieCell("B", 6,periode.split("-")[0].substring(1));
			retour+="M"+periode.split("-")[0].substring(1)+"_"+String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
		}
		else if(periodicite.equalsIgnoreCase("Trimestrielle")){
			String per=periode.split("-")[0].substring(1);
			log.info("trimestrielle");
			//Mois
			if(per.equals("1") || per.equals("2") || per.equals("3")){
				copieCell("B", 5,"1");
				retour+="T1_"+String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
			}
			else if (per.equals("4") || per.equals("5") || per.equals("6")){
				copieCell("B", 5,"2");
				retour+="T2_"+String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
			}	
			else if (per.equals("7") || per.equals("8") || per.equals("9")){
				copieCell("B", 5,"3");
				retour+="T3_"+String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
			}
			else if (per.equals("10") || per.equals("11") || per.equals("12")){
				copieCell("B", 5,"4");
				retour+="T4_"+String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
			}
		//	copieCell("B", 6,periode.split("-")[0].substring(1));
		}
		else if(periodicite.equalsIgnoreCase("Annuelle")){
			copieCell("B", 6,periode.split("-")[0].substring(1));
			retour+=String.valueOf(readCell("D", 2).getNumericCellValue()).substring(0,4);
		}
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
	
	public String getRetour() {
		return retour;
	}

	public void setNumeroAgrement(String numeroAgrement) {
		this.numeroAgrement = numeroAgrement;
	}
	
}
