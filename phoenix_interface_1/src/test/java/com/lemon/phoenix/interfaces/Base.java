package com.lemon.phoenix.interfaces;

import org.testng.annotations.AfterSuite;

import com.lemon.phoenix.util.ExcelUtil;

public class Base {
	
    /**
     * @param sheetNum 表单的序号
     * @param filePath 需要操作的文件的相对路径
     */
    @AfterSuite
    public void batchWriteCaseResult(){
    	ExcelUtil.batchWriteCaseResult(2, "target/test-classes/rest_info.xlsx");
    }

}
