package com.example.squrriels;

import android.content.Context;
import android.content.res.AssetManager;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataReadIn {
    public double emission = 0;
    public String maker;
    public String brand;

    public Context context;
    public DataReadIn(Context context) {
        this.context = context;
    }

    public ArrayList<Car> readCarData(){
        ArrayList<Car> cars = new ArrayList<>();

        try{
            InputStream myInput;
            AssetManager assetManager = context.getAssets();
            myInput = assetManager.open("FuelEfficiency.xls");
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowNum = 0;

            while(rowIter.hasNext()){
                HSSFRow myRow = (HSSFRow) rowIter.next();
                if(rowNum != 0){
                    brand = myRow.getCell(0).getStringCellValue();
                    maker = myRow.getCell(1).getStringCellValue();
                    emission = myRow.getCell(2).getNumericCellValue();

                    cars.add(new Car(brand, maker, emission));
                }
                rowNum++;
            }
            return cars;
        }catch(Exception e){
            return null;
        }
    }
}
