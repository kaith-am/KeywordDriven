/**
 * 
 */
package com.runner;

import org.testng.annotations.Test;

import com.excelreaderkeyword.KeyWordReader;

/**
 * @author 91888
 *
 */
public class RunnerClass {
@Test
public void sheetRunner() {
	// TODO Auto-generated method stub
	KeyWordReader k = new KeyWordReader();
	k.keywordExcelReader("C:\\Users\\91888\\eclipse-workspace\\KeywordDriven\\Keyword driven.xlsx","login");
}
}
