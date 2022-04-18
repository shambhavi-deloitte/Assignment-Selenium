import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
public class ReadingExcel {
    static XSSFSheet sheet;
    static XSSFWorkbook wb;
    public static String email;
    public static String CardNumber;
    public static String MM;
    public static String YY;
    public static String CVC;
    public static String ZipCode;


    public static HashMap ReadCells() throws IOException {
        String filepath = "C:\\Users\\shampriya\\Desktop\\CardDetails.xlsx";
        File fileobj = new File(filepath);
        FileInputStream fstream = new FileInputStream(filepath);
        wb = new XSSFWorkbook(fstream);
        sheet = wb.getSheetAt(0);
        String sheetname = sheet.getSheetName();
        int colno = sheet.getRow(0).getLastCellNum();
        System.out.println("sheetname is " + sheetname);
        System.out.println("column total is " + colno);
        int row = sheet.getLastRowNum() + 1;

        for (int i = 1; i < row; i++) {
            email = sheet.getRow(i).getCell(0).getStringCellValue();
            CardNumber = sheet.getRow(i).getCell(1).getStringCellValue();
            MM = sheet.getRow(i).getCell(2).getStringCellValue();
            YY= sheet.getRow(i).getCell(3).getStringCellValue();
            CVC= sheet.getRow(i).getCell(4).getStringCellValue();
            ZipCode= sheet.getRow(i).getCell(5).getStringCellValue();

        }

        HashMap hashMap = new HashMap();
        hashMap.put("email", email);
        hashMap.put("CardNumber", CardNumber);
        hashMap.put("MM", MM);
        hashMap.put("YY", YY);
        hashMap.put("CVC",CVC);
        hashMap.put("zipcode",ZipCode);
        return hashMap;
    }
}
