package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

public class Toto {
  @SuppressWarnings("resource")
public static void main(String[] args) 
    {
       try
       { 
    	   InputStream is = new FileInputStream("g:\\Masque.xlsx");
    	   OPCPackage opc=OPCPackage.open(is);
          XSSFWorkbook wb= new XSSFWorkbook(opc);
          XSSFSheet sheet=(XSSFSheet)wb.getSheetAt(3);
          int lastRowNum=sheet.getLastRowNum();
          System.out.println(lastRowNum);
          XSSFCell cell=null;
          for(int i=0;i<lastRowNum;i++)
          {
        //	  XSSFClientAnchor b=new XSSFClientAnchor();
               XSSFRow row=sheet.getRow(i);
              if(row!=null){
	              // int lastCellNum=row.getLastCellNum();
	              System.out.println("\n => LIGNE "+i+"\n");
	             /*  for(int j=0;j<lastCellNum;j++)
	               {
	                   XSSFCell cell=row.getCell(j);
	                   if(cell!=null){
	                	   System.out.print(cell.getColumnIndex()+":"+cell.getRowIndex()+":"+cell+" - ");
	                  }*/
	              for (Iterator<Cell> cellIt = row.cellIterator(); cellIt.hasNext();) {
	  				cell = (XSSFCell) cellIt.next();
	  				System.out.print(cell.getRowIndex() +":"+cell.getColumnIndex()+" - "+cell+" : ");
	  				System.out.println(cell.getCellStyle().getFillBackgroundColorColor());
	  				//evaluator.evaluate(cell);
	  			//	evaluator.evaluateFormulaCell(cell);  
	  			}
	                   
	              // }System.out.println();
               }
          }
        //  FileOutputStream fileOut = new FileOutputStream("g:\\EtatFin1.xlsx");
  	   // wb.write(fileOut);
      }
      catch(Exception e)
     {
         e.printStackTrace();
      }
   }
}