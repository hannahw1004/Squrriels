package com.example.squrriels;

import android.content.res.AssetManager;
import android.inputmethodservice.Keyboard;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.Iterator;

public class ExcelReadIn {
    public void readData() throws Exception{
        try {
            InputStream myInput;
            // initialize asset manager
            AssetManager assetManager = getAssets();
            //  open excel file name as myexcelsheet.xls
            myInput = assetManager.open("CarData.xlsx");
            // Create a POI File System object
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            // Create a workbook using the File System
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            // Get the first sheet from workbook
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            // We now need something to iterate through the cells.
            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowNum = 0;
            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                if (rowNum != 0) {
                    Iterator<Cell> cellIter = myRow.cellIterator();
                    int colNum = 0;
                    String sno = "", date = "", det = "";
                    while (cellIter.hasNext()) {
                        HSSFCell myCell = (HSSFCell) cellIter.next();
                        /*if (colNum == 0) {
                            sno = myCell.toString();
                        } else if (colNum == 1) {
                            date = myCell.toString();
                        } else if (colNum == 2) {
                            det = myCell.toString();
                        }*/
                        colNum++;
                        System.out.print(myCell.toString() + " ");

                    }

                }
                rowNum++;
            }
        } catch(Exception e){

        }
    }

    }
