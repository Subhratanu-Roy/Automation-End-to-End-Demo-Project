package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibrary {
	XSSFSheet sheet = null;
	XSSFWorkbook wb = null;
	XSSFRow row = null;
	XSSFCell cell = null;
	FileInputStream fis = null;
	FileOutputStream fos = null;
	String path =System.getProperty("user.dir")+"\\resources\\Testdata\\data.xlsx";

	public ExcelLibrary() throws IOException {
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);
	}

	public ExcelLibrary(String path) throws IOException {

		this.path = path;
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);

	}

	/*
	 * public String readData(String sheetName, int row, int col) { return
	 * wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue(); }
	 */

	public int getRowCount(String sheetname) {
		return wb.getSheet(sheetname).getLastRowNum() + 1;
	}

	public int getColumnCount(String sheetname) {
		sheet = wb.getSheet(sheetname);
		row = sheet.getRow(0);
		if (row == null) {
			System.out.println("No row present");
		}
		return row.getLastCellNum();

	}

	public String getCellData(String sheetname, int rowno, int colno) {

		if (rowno <= 0) {
			System.out.println("Invalid row number");
			return "";
		}

		int index = wb.getSheetIndex(sheetname);
		if (index == -1) {
			System.out.println("No sheet found with name " + sheetname);
			return "";
		}
		sheet = wb.getSheetAt(index);
		row = sheet.getRow(rowno - 1);
		if (row == null) {
			System.out.println("No row present at position " + rowno);
			return "";
		}
		cell = row.getCell(colno - 1);

		if (cell == null) {
			System.out.println("No column present at position " + colno);
			return "";
		}
		if (cell.getCellType().name().equals("STRING")) {
			return cell.getStringCellValue();

		} else if (cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA"))
			return String.valueOf(cell.getNumericCellValue());

		else if (cell.getCellType().name().equals("BLANK"))
			return "";

		else {
			System.out.println("Not performed");
			return String.valueOf(cell.getBooleanCellValue());
		}

	}

	public String getCellData(String sheetname, int rowno, String colname) {

		if (rowno <= 0) {
			System.out.println("Invalid row number");
			return "";
		}
		int index = wb.getSheetIndex(sheetname);
		if (index == -1) {
			System.out.println("No sheet found");
			return "";
		}
		sheet = wb.getSheetAt(index);
		row = sheet.getRow(0);
		if (row == null) {
			System.out.println("No row present");
			return "";
		}
		int colno = -1;
		int noOfColumns = row.getLastCellNum();
		for (int i = 0; i < noOfColumns; i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colname.trim())) {

				colno = i;
				System.out.println("Column found at position " + (i + 1));
				break;
			}
		}

		if (colno == -1) {
			System.out.println("No columns found");
			return "";
		}

		sheet = wb.getSheetAt(index);
		row = sheet.getRow(rowno - 1);
		if (row == null) {
			System.out.println("No row present at position " + rowno);
			return "";
		}
		cell = row.getCell(colno);

		if (cell == null) {
			System.out.println("No column present at " + colno + 1);
			return "";
		}
		if (cell.getCellType().name().equals("STRING"))
			return cell.getStringCellValue();

		else if (cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA"))
			return cell.getStringCellValue();

		else if (cell.getCellType().name().equals("BLANK"))
			return "";

		else
			return String.valueOf(cell.getBooleanCellValue());

	}

	public boolean setCellData(String sheetname, int rowno, String colname, String data) throws IOException {

		try {
			if (rowno <= 0) {
				System.out.println("Invalid row number");
				return false;
			}
			int colnum = -1;
			int index = wb.getSheetIndex(sheetname);
			if (index == -1) {
				System.out.println("No sheet found");
				return false;
			}

			sheet = wb.getSheetAt(index);
			row = sheet.getRow(0);

			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colname.trim())) {
					System.out.println("Found column at position " + (Integer.valueOf(i) + 1));
					colnum = i;
					break;
				}
			}

			if (colnum == -1) {
				System.out.println("No columns present");
				return false;
			}
			row = sheet.getRow(rowno - 1);
			if (row == null) {
				System.out.println("First row is created");
				row = sheet.createRow(rowno - 1);
			}
			cell = row.getCell(colnum);

			if (cell == null) {
				System.out.println("New cell is created");
				cell = row.createCell(colnum);
			}
			cell.setCellValue(data);
			System.out.println("Added value in the new cell");
			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();

		} catch (Exception e) {
			return false;
		}

		return true;

	}

	public boolean addSheet(String sheetname) {
		try {
			wb.createSheet(sheetname);
			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean removeSheet(String sheetname) {
		try {
			int index = wb.getSheetIndex(sheetname);
			if (index == -1)
				return false;
			wb.removeSheetAt(index);
			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean addColumn(String sheetname, String colname) throws Exception {
		try {
			int index = wb.getSheetIndex(sheetname);
			if (index == -1) {
				System.out.println("Sheet not found");
				return false;
			}
			sheet = wb.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null) {
				System.out.println("No row present initially");
				row = sheet.createRow(0);
			}
			if (row.getLastCellNum() == -1) {
				System.out.println("No column present initially");
				cell = row.createCell(0);
				System.out.println("First column created");
			} else {
				cell = row.createCell(row.getLastCellNum());
				System.out.println("New column created");
			}
			cell.setCellValue(colname);
			System.out.println("Added value to new column");
		}

		catch (Exception e) {
			System.out.println("Not performed");
			return false;
		}

		fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		return true;

	}

	public boolean removeColumn(String sheetname, int colnum) throws Exception {
		try {
			int index = wb.getSheetIndex(sheetname);
			if (index == -1)
				return false;
			sheet = wb.getSheetAt(index);
			int rowcount = sheet.getLastRowNum() + 1;
			for (int i = 0; i < rowcount; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					cell = row.getCell(colnum);
					if (cell != null)
						row.removeCell(cell);
				}
			}

			fos = new FileOutputStream(path);
			wb.write(fos);
			fos.close();

		} catch (Exception e) {
			return false;

		}
		return true;

	}

	public boolean isSheetExist(String sheetname) {
		int index = wb.getSheetIndex(sheetname);
		if (index == -1) {
			index = wb.getSheetIndex(sheetname.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;

	}
}

/*
 *****************************************************************************************************************************
 * wb.getSheetIndex(sheetname)
 * sheet.getRow(index).getCell(index).getStringCellValue();
 * row.getLastCellNum(); sheet.getLastRowNum(); wb.createSheet(sheetname);
 * wb.removeSheetAt(index); sheet.createRow(index); row.createCell(index);
 * row.removeCell(cell); cell.setCellValue(data); sheet -> row -> cell
 ****************************************************************************************************************************/
