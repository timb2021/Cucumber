import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class excelPractice {
    public static void main(String[] args) {

        // Apache POI
        try {
            String filePath = System.getProperty("user.dir") + "/src/main/resources/data/Book1.xlsx"; // user.dir   user.home
            File file = new File(filePath);

            System.out.println(filePath);
            System.out.println("if file exists: " + file.exists());

            // Workbook
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);

            //Sheet
            Sheet sheet = workbook.getSheet("sheet1");
            // sheet.getLastRowNum()+1   => gives number of rows

            //Row
            Row row = sheet.getRow(0);
            // row.getLastCellNum()  => gives number of cells in a row

            //Cell
            Cell cell = row.getCell(0);


            System.out.println("=====>1) " + cell.toString());
            System.out.println("=====>2) " + row.getLastCellNum());
            //String str = "";

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                String str = "";
                row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    System.out.print(row.getCell(j).toString() + " ");
                    str += row.getCell(j).toString() + " ";


                }
                //System.out.println(str);
                if (str.equals("Central Morgan Pencil ")) {
                    System.out.print("   <== following row exists");
                }


                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
