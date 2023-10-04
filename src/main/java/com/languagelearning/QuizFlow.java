package com.languagelearning;

import static com.languagelearning.ExcelReader.*;

public class QuizFlow {
    public static String getTask(int sheetIndex){
        getRandomRowNumber(sheetIndex);
        readExcel(sheetIndex, randomRowNumber, 0);
        String task = cellValue + ":   ";
        readExcel(sheetIndex, randomRowNumber, 1);
        return task + cellValue;
    }

}

