package com.lemon.phoenix.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static Map<String,Map<Integer,String>> caseResultMap=new HashMap<String,Map<Integer,String>>();
	/**读取excel数据
	 * @param path 文件路径
	 * @param startRow 开始行数
	 * @param endRow  结束行数
	 * @param startColumn 开始列
	 * @param endColumn 结束列
	 */
	public static Object[][] read(String path,int sheetNum,int startRow,int endRow,int startColumn,int endColumn){
		Object [][] datas=new Object[endRow-startRow+1][endColumn-startColumn+1];
		try {
			Workbook workbook=WorkbookFactory.create(ExcelUtil.class.getResourceAsStream(path));
			Sheet sheet=workbook.getSheetAt(sheetNum);//传入值为0代表获取excel里的sheet1
			for(int i=startRow;i<=endRow;i++){
				Row row=sheet.getRow(i-1);
				for(int j=startColumn;j<=endColumn;j++){
					Cell cell=row.getCell(j-1, MissingCellPolicy.CREATE_NULL_AS_BLANK);//添加策略方法将空白行设置为""而不是null
					cell.setCellType(CellType.STRING);//将表里面数据全部设置为String类型
					String value=cell.getStringCellValue();
					datas[i-startRow][j-startColumn]=value;
				}
			}
			
			
		}  catch (Exception e) {//仅catch所有异常的父类
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
   }
	
	/**往excel指定行的指定列写入数据
	 * @param sheetNum 要操作的表单索引
	 * @param caseId 用例编号
	 * @param cellNum 列编号
	 * @param result 要写入的结果数据
	 * @param filePath 要写入的文件路径（非classpath路径）
	 */
	public static void write(int sheetNum,String caseId,int cellNum,String result,String filePath){
		try {
			InputStream is = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet=workbook.getSheetAt(sheetNum);
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 0; i < lastRowNum; i++) {
				Row row=sheet.getRow(i);
				Cell cell=row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK);
				cell.setCellType(CellType.STRING);
				String value =cell.getStringCellValue();
				if(value.equals(caseId)){
					Cell cellToBeWrite=row.getCell(cellNum-1,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cellToBeWrite.setCellType(CellType.STRING);
					cellToBeWrite.setCellValue(result);
					break;
				}
			}
			OutputStream os = new FileOutputStream(new File(filePath));
			workbook.write(os);
			os.close();
			is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void batchWriteCaseResult(int sheetNum,String Path){
		InputStream is =null;
		OutputStream os =null;
		try {
			is=new FileInputStream(new File(Path));
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet=workbook.getSheetAt(sheetNum-1);
			Set<String> caseIds = caseResultMap.keySet();
			int totalRowNum = sheet.getLastRowNum();
			for (String caseId : caseIds) {
				for (int i = 0; i < totalRowNum; i++) {
					Row row=sheet.getRow(i);
					Cell cell=row.getCell(0,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					cell.setCellType(CellType.STRING);
					String firstCellValue =cell.getStringCellValue();
					if(caseId.equals(firstCellValue)){
					  Map<Integer,String> cellValueMap=caseResultMap.get(caseId);
					  Set<Integer>cellNums=cellValueMap.keySet();
					  for (Integer cellNum : cellNums) {
						  	Cell cellToBeWrite=row.getCell(cellNum.intValue()-1,MissingCellPolicy.CREATE_NULL_AS_BLANK);
							cellToBeWrite.setCellType(CellType.STRING);
							cellToBeWrite.setCellValue(cellValueMap.get(cellNum));		
					}
					  break;
					}
				}
			}
			os = new FileOutputStream(new File(Path));
			workbook.write(os);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		Object[][]datas=ExcelUtil.read("/rest_info.xlsx",1,2,7,1,3);
		for (Object[] objects : datas) {
			for (Object object : objects) {
				System.out.print("["+object+"]");
			}
			System.out.println();
		}
	}
}
