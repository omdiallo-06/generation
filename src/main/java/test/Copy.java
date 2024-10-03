package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Copy {
	 
	private static String inFilename;
	private static String outFilename;
	
	private FileOutputStream file = null;
	private XSSFWorkbook workbookNew = new XSSFWorkbook();
	private ArrayList<XSSFSheet> sheets = new ArrayList<XSSFSheet>(10);
 
	@SuppressWarnings("resource")
	public Copy(String inFilename,String outFilename) {
		this.setInFilename(inFilename);
		this.setOutFilename(outFilename);
		FileChannel in = null; // canal d'entr�e
		FileChannel out = null; // canal de sortie
		 
		try {
		  // Init
		  file = new FileOutputStream(outFilename);
		  in = new FileInputStream(inFilename).getChannel();
		  out = new FileOutputStream(outFilename).getChannel();
		 
		  // Copie depuis le in vers le out
		  in.transferTo(0, in.size(), out);
		} catch (Exception e) {
		  e.printStackTrace(); // n'importe quelle exception
		} finally { // finalement on ferme
		  if(in != null) {
		  	try {
			  in.close();
			} catch (IOException e) {}
		  }
		  if(out != null) {
		  	try {
			  out.close();
			} catch (IOException e) {}
		  }
		}
	}
	
	public void copyNew(){
		for(int i=0;i<sheets.size();i++){
			XSSFSheet sheet=workbookNew.createSheet(sheets.get(i).getSheetName());
			copySheet(sheet,sheets.get(i));
		}
	}
 
	public void copySheet(XSSFSheet newSheet,XSSFSheet ancSheet){
		int lastRowNum=ancSheet.getLastRowNum();
		 for(int i=0;i<lastRowNum;i++)
         {
       	//  XSSFClientAnchor b=new XSSFClientAnchor();
       	  XSSFRow newRow=newSheet.createRow(i);
          XSSFRow ancRow=ancSheet.getRow(i);
              if(ancRow!=null){
	               int lastCellNum=ancRow.getLastCellNum();
	                for(int j=0;j<lastCellNum;j++)
	               {
	                   XSSFCell ancCell=ancRow.getCell(j);
	                   if(ancCell!=null){
	                	   XSSFCell newCell=newRow.createCell(j,ancCell.getCellType());
	 	                  
	                	   System.out.print(ancCell.getColumnIndex()+":"+ancCell.getRowIndex()+":"+ancCell+" - ");
	                	   newCell.setCellComment(ancCell.getCellComment());
	                	   Integer type=ancCell.getCellType();
	                	   if(type.equals(Cell.CELL_TYPE_NUMERIC))
	                		   	newCell.setCellValue(ancCell.getNumericCellValue());
	                	   else if(type.equals(Cell.CELL_TYPE_BOOLEAN))
	                		   	newCell.setCellValue(ancCell.getBooleanCellValue());
		                   else if(type.equals(Cell.CELL_TYPE_FORMULA))
		                		newCell.setCellValue(ancCell.getCellFormula());
			               else if(type.equals(Cell.CELL_TYPE_STRING))
			                	newCell.setCellValue(ancCell.getStringCellValue());
			               else if(type.equals(Cell.CELL_TYPE_BLANK))
			                	newCell.setCellValue("");
	                   }
	                   
	               }
	                System.out.println();
              }
         }
     }
	public void close() throws NullPointerException {
		try {
			workbookNew.write(file);
			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
 
	public XSSFCell getCell(XSSFSheet sheet,int row,int col,int type) {
		System.out.println(row);
		XSSFRow r = sheet.getRow(row);
		if (r == null) {
			r = sheet.createRow(row);
		}
		XSSFCell c = r.getCell((short)col);
		if (c == null) {
			c = r.createCell((short)col);
		}
		c.setCellType(type);
		return c;
	}
	
	
	 public static void main(String[] args) 
	    {
	      try {
			//new Copy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }

	public  String getInFilename() {
		return inFilename;
	}

	public  void setInFilename(String inFilename) {
		Copy.inFilename = inFilename;
	}

	public  String getOutFilename() {
		return outFilename;
	}

	public  void setOutFilename(String outFilename) {
		Copy.outFilename = outFilename;
	}
}