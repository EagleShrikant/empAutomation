package com.techmahindra.extraction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.techmahindra.dao.CurrentEmployee;

@Component
public class DataExtraction {

	List<CurrentEmployee> currentDataList;

	public void process(String fileName) {
		System.out.println("DataExtraction : Start");
		fileRead(fileName);

		System.out.println("DataExtraction : End");
	}

	public void fileRead(String fileName) {

		FileInputStream excelFile = null;
		Workbook workbook = null;
		
		try {
		
			//Thread.sleep(2000);
			excelFile = new FileInputStream(new File(fileName));
			workbook = new XSSFWorkbook(excelFile);
			XSSFSheet datatypeSheet = (XSSFSheet) workbook.getSheetAt(2);
			currentDataList = readEmpData(datatypeSheet);
		
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {

			if (null != excelFile) {
				try {
					workbook.close();
					excelFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	public List<CurrentEmployee> readEmpData(XSSFSheet datatypeSheet){
		String temp = null;
		CurrentEmployee ce;
		int tempIntValue = 0;
		double tempDoubleValue = 0.0;
		Iterator<Row> iterator = datatypeSheet.iterator();
		List<CurrentEmployee> dataList = new LinkedList<>();
		if(iterator.hasNext()) iterator.next();
		while (iterator.hasNext()) {

			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();

			ce = new CurrentEmployee();

			for (int i = 0; cellIterator.hasNext() && i < 29; i++) {

				temp = "";
				Cell currentCell = cellIterator.next();
				// getCellTypeEnum shown as deprecated for version 3.15
				// getCellTypeEnum ill be renamed to getCellType starting from version 4.0
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					temp = currentCell.getStringCellValue();
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					temp = Double.toString(currentCell.getNumericCellValue());
				}

				if (i == 0 && temp.equals(""))
					continue;

				//System.out.print(temp);
				
				loop : switch (i) {
				case 0 :
					if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						Double d = currentCell.getNumericCellValue();
						temp = Integer.toString(d.intValue());
					}
					ce.setEMPID(temp);
					break loop;
				case 1 :
					ce.setEMP_NAME(temp);
					break loop;
				case 2 :
					
					if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						Double d = currentCell.getNumericCellValue();
						tempIntValue = d.intValue();
					}
					ce.setBUSINESS_WAIT_AGE(tempIntValue);
					break loop;
				case 3:
					ce.setBV_STATUS(temp);
					break loop;
				case 4:
					ce.setEMPLOYEE_CLASS_CATEGORY(temp);
					break loop;
				case 5:
					ce.setGENDER(temp);
					break loop;
				case 6:
					ce.setCATEGORY_CODE(temp);
					break loop;
				case 7:
					ce.setHTR_FLAG(temp);
					break loop;
				case 8:
					ce.setEMPLOYEE_IBU(temp);
					break loop;
				case 9:
					ce.setBAND(temp);
					break loop;
				case 10:
					if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						tempDoubleValue = currentCell.getNumericCellValue();
					}
					ce.setTOTAL_EXPERIENCE(tempDoubleValue);
					break loop;
				case 11:
					ce.setCURRENT_COUNTRY(temp);
					break loop;
				case 12:
					ce.setCURRENT_LOCATION_CITY(temp);
					break loop;
				case 13:
					ce.setONSITE_OFFSHORE(temp);
					break loop;
				case 14:
					ce.setPROJECT_ID(temp);
					break loop;
				case 15:
					ce.setPROJECT_DESCRIPTION(temp);
					break loop;
				case 16:
					ce.setPROJECT_CONTRACT_TYPE(temp);
					break loop;
				case 17:
					ce.setPROJECT_MAINTYPE_DESCR(temp);
					break loop;
				case 18:
					if(temp.equals("Y"))
					ce.setBILLABLITY_STATUS(true);
					else
					ce.setBILLABLITY_STATUS(false);
					break loop;
				case 19:
					ce.setCUSTOMER_ID(temp);
					break loop;
				case 20:
					ce.setCUSTOMER_NAME(temp);
					break loop;
				case 21:
					ce.setSUPERVISOR_ID(temp);
					break loop;
				case 22:
					ce.setSUPERVISOR_NAME(temp);
					break loop;
				case 23:
					ce.setPROGRAM_MANAGER_ID(temp);
					break loop;
				case 24:
					ce.setPROGRAM_MANAGER_NAME(temp);
					break loop;
				case 25:
					ce.setPRIMARY_SKILL_CATEGORY_1(temp);
					break loop;
				case 26:
					ce.setPRIMARY_SKILL_CATEGORY_2(temp);
					break loop;
				case 27:
					ce.setPROJECT_TYPE(temp);
					break loop;
				case 28:
					ce.setPO_FLAG(temp);
					break loop;

				}
	

			}
			if(null!=ce.getEMPID())
			dataList.add(ce);
			
			
		}
		System.out.println("\t" + dataList);
		return dataList;
	}

}
