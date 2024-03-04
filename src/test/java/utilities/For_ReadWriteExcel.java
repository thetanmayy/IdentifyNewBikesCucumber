package utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class For_ReadWriteExcel {
	public static XSSFWorkbook workbook = new XSSFWorkbook();
	public static XSSFSheet sheet = workbook.createSheet("HondaBike");
	public static XSSFRow headerrow = sheet.createRow(0);
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
 

	public static void writeBikenames(List<String> bikenames, String filepath) throws IOException {
		headerrow = sheet.getRow(0);
		headerrow.createCell(0).setCellValue("Bike Names");
		for (int i = 0; i < bikenames.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row == null) {
				row = sheet.createRow(i + 1);
			}
			row.createCell(0).setCellValue(bikenames.get(i));
		}
		FileOutputStream file = new FileOutputStream(filepath);
		workbook.write(file);
	}
	
	public static void writebikePrice(List<String> bikePrice, String filepath) throws IOException {
		headerrow = sheet.getRow(0);
		headerrow.createCell(1).setCellValue("Bike Prices");
		for (int i = 0; i < bikePrice.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row == null) {
				row = sheet.createRow(i + 1);
			}
			row.createCell(1).setCellValue(bikePrice.get(i));
		}
		FileOutputStream file = new FileOutputStream(filepath);
		workbook.write(file);
	}
	
	public static void writelaunchDate(List<String> launchDate, String filepath) throws IOException {
		headerrow = sheet.getRow(0);
		headerrow.createCell(2).setCellValue("Launch Date");
		for (int i = 0; i < launchDate.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row == null) {
				row = sheet.createRow(i + 1);
			}
			row.createCell(2).setCellValue(launchDate.get(i));
		}
		FileOutputStream file = new FileOutputStream(filepath);
		workbook.write(file);
	}
	
	public static void writeUsedCars(List<String> usedcar, String filepath) throws IOException {
		headerrow = sheet.getRow(0);
		headerrow.createCell(3).setCellValue("Used Cars");
		for (int i = 0; i < usedcar.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row == null) {
				row = sheet.createRow(i + 1);
			}
			row.createCell(3).setCellValue(usedcar.get(i));
		}
		FileOutputStream file = new FileOutputStream(filepath);
		workbook.write(file);
	}
	public static void writePopularModels(List<String> popularModels, String filepath) throws IOException {
		headerrow = sheet.getRow(0);
		headerrow.createCell(4).setCellValue("Popular Models");
		for (int i = 0; i < popularModels.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			if (row == null) {
				row = sheet.createRow(i + 1);
			}
			row.createCell(4).setCellValue(popularModels.get(i));
		}
		FileOutputStream file = new FileOutputStream(filepath);
		workbook.write(file);
	}
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			//data=cell.toString();
			DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell);
            return data;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		fi.close();
		return data;
}
}