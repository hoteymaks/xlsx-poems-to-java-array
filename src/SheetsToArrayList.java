import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class SheetsToArrayList {
    static ArrayList<Content> poems;

    public static void main(String[] args) throws IOException {
        poems = getPoems("sample-poems.xlsx");

        // Example print of ArrayList contents
        for (Content poem : poems) {
            if (poem.getContent() != null) {
                System.out.println("Author: " + poem.getAuthor() + " | Title: " + (poem.getName().isEmpty() ? "Not provided" : poem.getContent()));
                System.out.println("\n" + poem.getContent() + "\n\n");
            }
        }
    }

    public static ArrayList<Content> getPoems(String filename) throws IOException {
        poems = new ArrayList<>();
        // Use this for Android App instead of FileInputStream:  InputStream myInput;
        //                                                       AssetManager assetManager = context.getAssets();
        //                                                       myInput = assetManager.open(filename);
        FileInputStream myInput = new FileInputStream(filename);  // Make sure you entered poems Word file name correctly
        XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        Iterator<Row> rowIter = mySheet.rowIterator();
        int rowno = 0;
        while (rowIter.hasNext()) {
            XSSFRow myRow = (XSSFRow) rowIter.next();
            Content poem = new Content();
            if (rowno != 0) {
                Iterator<Cell> cellIter = myRow.cellIterator();
                int colno = 0;
                while (cellIter.hasNext()) {
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    if (colno == 0) {
                        poem.setAuthor(myCell.toString());
                    } else if (colno == 1) {
                        poem.setName(myCell.toString());
                    } else if (colno == 2) {
                        poem.setContent(myCell.toString());
                    }
                    colno++;
                }
            }
            poems.add(poem);
            rowno++;
        }
        return poems;
    }
}
