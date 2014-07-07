package poi.action;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkbookFactory { 

	public static Workbook create(InputStream is) {
		Workbook wb = null;
		try {
			wb = new HSSFWorkbook(is); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wb;
	}

}
