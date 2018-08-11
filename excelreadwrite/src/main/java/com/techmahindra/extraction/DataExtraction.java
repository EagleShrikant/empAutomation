package com.techmahindra.extraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class DataExtraction {

	public void process(String fileName) {
		System.out.println("DataExtraction : Start");
		fileRead(fileName);
		
		
		System.out.println("DataExtraction : End");
	}
	
	public void fileRead(String fileName) {
		
		FileInputStream excelFile = null;
		Workbook workbook = null;
		String temp = null;
		  try {
			  	Thread.sleep(2000);
	            excelFile = new FileInputStream(new File(fileName));
	            workbook = new XSSFWorkbook(excelFile);
	            XSSFSheet datatypeSheet = (XSSFSheet) workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    //getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                        temp = currentCell.getStringCellValue();
	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        temp = Double.toString(currentCell.getNumericCellValue()); 
	                    }

	                    System.out.print(temp);
	                }
	                System.out.println();

	            }
	        } catch (IOException | InterruptedException e) {
	            System.out.println(e);
	        	e.printStackTrace();
	        } catch (Exception e){
	        	System.out.println(e);
	        	e.printStackTrace();
	        }	finally {
	        
	        	if(null != excelFile) {
					try {
						workbook.close();
						excelFile.close();						
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
			}


	}
	
}
