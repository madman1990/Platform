/** 
 * 包名: package com.qt.sales.common.excel; <br/> 
 * 添加时间: 2016年11月9日 下午2:31:37 <br/> 
 */
package com.imobpay.commons.utils.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.imobpay.commons.utils.DateUtils;

/**
 * 
 * <pre>
 * 描述: 读取Excel公用类. <br/>  
 * 时间：2017年5月22日 上午11:18:48 <br/> 
 * 
 * @author zhangyinghui 
 * @version 1.0
 * @since JDK 1.6
 * </pre>
 */
public class ParseExcelPoiUtil {

    /**
     * Log
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExportExcelUtil.class);

    /**
     * 描述 : 解析Excel文件. <br/>
     * 
     * @param excelFilePath
     *            excel文件路径
     * @return List<SheetBean>
     * @throws IOException
     *             IO异常.<br/>
     */
    public static List<SheetBean> parseFileExcel(String excelFilePath) throws IOException {
        FileInputStream stream = new FileInputStream(excelFilePath);
        return parseFileExcel(excelFilePath, stream);
    }

    /**
     * 方法名: parseFileExcel <br/>
     * 描述: 解析Excel文件<br/>
     * 
     * @param fileName
     *            文件名
     * @param fileStream
     *            文件流
     * @return List<SheetBean>
     * @throws IOException
     *             IO异常<br/>
     */
    public static List<SheetBean> parseFileExcel(String fileName, InputStream fileStream) throws IOException {
        List<SheetBean> sheetBeans = new ArrayList<SheetBean>();
        InputStream stream = null;
        /** Workbook对象 */
        Workbook wb = null;
        /**
         * 单元Sheet
         */
        Sheet sheet = null;
        /**
         * 行
         */
        Row row = null;
        /** 单元格 */
        Cell cell = null;
        try {
            if (fileName.endsWith(".xls")) {
                wb = (Workbook) new HSSFWorkbook(fileStream);
            } else if (fileName.endsWith(".xlsx")) {
                wb = (Workbook) new XSSFWorkbook(fileStream);
            } else {
                throw new IllegalArgumentException("文件格式出错！");
            }
            if (wb != null) {
                int sheetNum = wb.getNumberOfSheets();
                for (int m = 0; m < sheetNum; m++) {
                    if (null != wb.getSheetAt(m)) {
                        SheetBean sheetBean = new SheetBean();
                        sheet = wb.getSheetAt(m);
                        if (sheet != null) {
                            LOGGER.info("sheetName: " + sheet.getSheetName());
                            // 行数(从0开始,相当于最后一行的索引),列数
                            if (sheet.getLastRowNum() != 0 && sheet.getRow(0).getPhysicalNumberOfCells() != 0) {
                                int countRow = sheet.getLastRowNum();
                                int countCell = sheet.getRow(0).getPhysicalNumberOfCells();
                                String[][] strArray = new String[countRow][countCell];
                                sheetBean.setVarNameList(ParseExcelPoiUtil.getHeaderRow(sheet.getRow(0)));
                                for (int i = 0; i < countRow; i++) {
                                    for (int j = 0; j < countCell; j++) {
                                        if (sheet.getRow(i + 1) != null) {
                                            row = sheet.getRow(i + 1);
                                        }
                                        cell = row.getCell(j);
                                        String objConet = ParseExcelPoiUtil.convertCellValue(cell);
                                        strArray[i][j] = objConet;
                                    }
                                }
                                sheetBean.setSheetData(strArray);
                                sheetBeans.add(sheetBean);
                                cell = null;
                                row = null;
                                sheet = null;
                            }
                        }
                    }
                }
            }
            wb = null;
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return sheetBeans;
    }

    /**
     * 
     * 描述: 获取定义名称行. <br/>
     * 
     * @param row
     *            Row行记录
     * @return List.<br/>>
     */
    public static List<String> getHeaderRow(Row row) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            list.add(convertCellValue(row.getCell(i)));
        }
        return list;
    }

    /**
     * 
     * 描述 : 转换单元格数据的格式. <br/>
     * 
     * @param cell
     *            Cell对象
     * @return String.<br/>
     */
    private static String convertCellValue(Cell cell) {
        String cellVal = "";
        if (cell == null) {
            return cellVal;
        }
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_STRING:
            cellVal = cell.getRichStringCellValue().getString();
            break;
        case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                cellVal = DateUtils.getFormatDateTime(cell.getDateCellValue(), DateUtils.YYYYMMDDHHMMSS);
            } else {
                cellVal = String.valueOf(new Long((long) cell.getNumericCellValue()));
            }
            break;
        case Cell.CELL_TYPE_BOOLEAN:
            cellVal = String.valueOf(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            cellVal = cell.getCellFormula();
            break;
        default:
            break;
        }
        return cellVal;
    }

}
