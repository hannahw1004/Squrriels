package com.example.squrriels;

import android.content.res.AssetManager;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.Iterator;

public class DataReadIn {

    public void readCarData(){
        try{
            InputStream myInput;
            AssetManager assetManager = getAssets();
            myInput = assetManager.open("CarData.xlxs");
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowNum = 0;

            while(rowIter.hasNext()){
                HSSFRow myRow = (HSSFRow) rowIter.next();
                if(rowNum != 0){
                    Iterator<Cell> cellIter = myRow.cellIterator();
                    int colNum = 0;
                    //number of rows and cols

                    while(cellIter.hasNext()){
                        HSSFCell myCell = (HSSFCell) cellIter.next();
                        if(){

                        }
                        colNum++;
                    }
                }
                rowNum++;
            }
        }catch(Exception e){

        }
    }
}
