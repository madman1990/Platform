/**
 *  <pre>	
 *  Project Name:ScorePlatform .</br>
 *  File: PoiExcel2k7Helper.java .</br>
 *  Package Name:com.imobpay.commons.utils.excel .</br>
 *  Date      Author       Changes .</br>
 *  2017年6月26日   Harrison Jiang     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 Harrison Jiang  FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>	
 */
package com.imobpay.commons.utils.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** 
 * <pre>
 * 【类型】: PoiExcel2k7Helper <br/> 
 * 【作用】: TODO ADD FUNCTION. <br/>  
 * 【时间】：2017年6月26日 上午10:41:07 <br/> 
 * 【作者】：Harrison Jiang <br/> 
 * </pre>
 */
public class PoiExcel2k7Helper extends PoiExcelHelper {  
    /** 获取sheet列表 */  
    public ArrayList<String> getSheetList(String filePath) {  
        ArrayList<String> sheetList = new ArrayList<String>(0);  
        try {  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));  
            Iterator<Sheet> iterator = wb.iterator();
            while (iterator.hasNext()) {  
                sheetList.add(iterator.next().getSheetName());  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return sheetList;  
    }  
  
    /** 读取Excel文件内容 */  
    public ArrayList<ArrayList<String>> readExcel(String filePath, int sheetIndex, String rows, String columns) {  
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>> ();  
        try {  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));  
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);  
              
            dataList = readExcel(sheet, rows, getColumnNumber(sheet, columns));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return dataList;  
    }  
      
    /** 读取Excel文件内容 */  
    public ArrayList<ArrayList<String>> readExcel(String filePath, int sheetIndex, String rows, int[] cols) {  
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>> ();  
        try {  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(filePath));  
            XSSFSheet sheet = wb.getSheetAt(sheetIndex);  
              
            dataList = readExcel(sheet, rows, cols);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return dataList;  
    }  
}  
