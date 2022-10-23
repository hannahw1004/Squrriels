package com.example.squrriels;

/*import org.apache.poi.openxml4j.opc.OPCPackage;
import android.content.Context;
import android.content.res.AssetManager;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class DataReadIn {

    public Context context;
    public DataReadIn(Context context) {
        this.context = context;
    }

    public ArrayList<Car> readCarData(){
        ArrayList<Car> cars = new ArrayList<>();

        try{
            InputStream myInput;
            AssetManager assetManager = context.getAssets();
            myInput = assetManager.open("FuelEfficiency.xlsx");

            OPCPackage pkg = OPCPackage.open(myInput);

            XSSFWorkbook myWorkBook = new XSSFWorkbook(pkg);

            XSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator<Row> rowIter = mySheet.rowIterator();
            int rowNum = 0;

            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                if(rowNum != 0){
                    int colNum = 0;
                    String brand = myRow.getCell(0).getStringCellValue();
                    String maker = myRow.getCell(1).getStringCellValue();
                    double emission = myRow.getCell(2).getNumericCellValue();

                    cars.add(new Car(brand, maker, emission));
                }
                rowNum++;
            }
            return cars;
        }catch(Exception e){
            return null;
        }
    }
} */
