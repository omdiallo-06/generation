import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	protected static final Logger log = LoggerFactory.getLogger(Test.class);

	public Test(){
	
	}
	
	public void a(){
		
		ArrayList<String> l= new ArrayList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("f");
		l.add("g");
		log.info(l.size()+"");
		l.clear();
		log.info(l.size()+"");
		/*InputStream ist;
		XSSFWorkbook wb;
		try {
			ist = getClass().getResource("/SICS_V19_Periodique.xls").openStream();
			log.info("ist:"+ist);
			wb = new XSSFWorkbook(ist);
			SXSSFWorkbook workbook=new SXSSFWorkbook(wb);
			System.out.println(workbook.getSheetAt(1).getRow(1).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}*/
		
	}
	
//	public void bd()
	
	public static void main(String[] args){
		new Test().a();
		//sysout
		
	}

}
