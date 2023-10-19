package com.languagelearning;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

import static com.languagelearning.Constants.*;

public class ExcelReader {
    public static String cellValue;
    public static String message = null;
    public static int randomRowNumber;

    public static int getRandomRowNumber(int sheetIndex) {
        int nonEmptyRowCount = 0;
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH_XLSX);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    int cellCount = row.getPhysicalNumberOfCells();
                    boolean isRowEmpty = true;
                    for (int j = 0; j < cellCount; j++) {
                        Cell cell = row.getCell(j);
                        if (cell != null && cell.getCellType() != CellType.BLANK) {
                            isRowEmpty = false;
                            break;
                        }
                    }
                    if (!isRowEmpty) {
                        nonEmptyRowCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        randomRowNumber = random.nextInt(nonEmptyRowCount);
        return randomRowNumber;
    }

    public static String readExcel(String filePath, int sheetIndex, int rowIndex, int columnIndex) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(columnIndex);
                cellValue = cell.getStringCellValue();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cellValue;
    }

    public static String checkAnswer(int sheetIndex, int rowIndex, String enteredAnswer) throws IOException {
        Workbook workbook = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH_XLSX);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(2);
            cellValue = cell.getStringCellValue();
            if (Objects.equals(cellValue, enteredAnswer)) {
                message = MESSAGE_CORRECT_ANSWER;
            } else {
                message = MESSAGE_WRONG_ANSWER;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }
        return message;
    }

    public static String showAnswer(int sheetIndex, int rowIndex) {
        Workbook workbook = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH_XLSX);
            workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            Row row = sheet.getRow(rowIndex);
            Cell cell = row.getCell(2);
            cellValue = cell.getStringCellValue();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cellValue;
    }
}