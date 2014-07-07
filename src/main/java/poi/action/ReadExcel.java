package poi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		InputStream is = new FileInputStream(new File("d://SummaryHSSF.xls"));
		// 根据输入流创建Workbook对象
		Workbook wb = WorkbookFactory.create(is);
		// get到Sheet对象
		Sheet sheet = wb.getSheetAt(0); 
		// 这个必须用接口 
		for (Row row : sheet) {
			for (Cell cell : row) {
				// cell.getCellType是获得cell里面保存的值的type
				// 如Cell.CELL_TYPE_STRING
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					// 得到Boolean对象的方法
					System.out.print(cell.getBooleanCellValue() + " "); 
					break;
				case Cell.CELL_TYPE_NUMERIC: 
					// 先看是否是日期格式
					if (DateUtil.isCellDateFormatted(cell)) { 
						// 读取日期格式
						System.out.print(cell.getDateCellValue() + " ");
					} else {
						// 读取数字
						System.out.print(cell.getNumericCellValue() + " ");
					}
					break;
				case Cell.CELL_TYPE_FORMULA:
					// 读取公式
					System.out.print(cell.getCellFormula() + " ");
					break;
				case Cell.CELL_TYPE_STRING:
					// 读取String
					System.out.print(cell.getRichStringCellValue().toString()
							+ " ");
					break;
				}
			}
			System.out.println("");
		}
	}
}
