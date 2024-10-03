package com.application.data.ihm;

import java.io.InputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.application.data.excel.EtatAnnuel;
import com.application.data.excel.EtatPeriodique;

public class Test {
	protected static final Logger log = LoggerFactory.getLogger(Test.class);
	

	public static void main(String[] args) throws Exception {
		InputStream ist1 = Test.class.getResource("/masque_2015.xlsx").openStream();//new FileInputStream("C:/Users/LZ2059/Desktop/Projection_2012_Eq2.xlsx");
		OPCPackage opc1=OPCPackage.open(ist1);
		XSSFWorkbook workbook1=new XSSFWorkbook(opc1);

		for(int i=0;i<14;i++)
		log.info(workbook1.getSheetAt(i).getSheetName());
		//System.out.println(workbook1.getSheet("SOMMAIRE").getRow(5-1).getCell(4).getStringCellValue());
		System.out.println(workbook1.getSheet("SOMMAIRE").getRow(5-1).getCell(3).getStringCellValue());
		//System.out.println(workbook1.getSheet("SOMMAIRE").getRow(5-1).getCell(5).getStringCellValue());
		//System.out.println(workbook1.getSheet("SOMMAIRE").getRow(6-1).getCell(4).getStringCellValue());
		System.out.println(workbook1.getSheet("SOMMAIRE").getRow(6-1).getCell(3).getStringCellValue());
		//System.out.println(workbook1.getSheet("SOMMAIRE").getRow(6-1).getCell(5).getStringCellValue());
		//new EtatAnnuel(workbook1).creerDeveloppe(null);
		//new EtatPeriodique(workbook1).creerEtat(null);

	}
	

}
