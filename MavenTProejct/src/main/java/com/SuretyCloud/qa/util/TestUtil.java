package com.SuretyCloud.qa.util;

import java.util.ArrayList;

import com.SuretyCloud.qa.excel.util.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT = 10;
	
	public static ArrayList<Object[]> getLoginTestDataFromExcel(String sSheetName) {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("/Users/shamiksha/Documents/SeleniumProject2020/TestDataFiles/MasterTestDataFile.xlsx");		
			
	
			for (int rowNum=3; rowNum <=reader.getRowCount("Login"); rowNum++) {
				
				String xTestRun= reader.getCellData("Login", "TestRun", rowNum);
				if (xTestRun =="Y") {
						String xTestCaseName= reader.getCellData("Login", "TestCaseName", rowNum);
						String xuserName= reader.getCellData("Login", "UserName", rowNum);
						String xPassword= reader.getCellData("Login", "Password", rowNum);
				
						//Object ob[] = {xTestRun,xTestCaseName, xuserName, xPassword};
						Object ob[] = {xTestCaseName, xuserName, xPassword};
						myData.add (ob);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myData; 
	}
	// ############### ClientName and Create Bond Request Data ###############
public static ArrayList<Object[]> getCreateNBDataFromExcel(String sSheetName) {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("/Users/shamiksha/Documents/SeleniumProject2020/TestDataFiles/MasterTestDataFile.xlsx");		
		
	
			for (int rowNum=3; rowNum <=reader.getRowCount("CreateNB"); rowNum++) {
				
				String xTestRun= reader.getCellData("CreateNB", "TestRun", rowNum);
				if (xTestRun.equals("Y")) {
					String xuserName= reader.getCellData("CreateNB", "UserName", rowNum);
					String xPassword= reader.getCellData("CreateNB", "Password", rowNum);
					String xTestCaseName= reader.getCellData("CreateNB", "TestCaseName", rowNum);
					String xClientName= reader.getCellData("CreateNB", "ClientName", rowNum);
					String xState= reader.getCellData("CreateNB", "State", rowNum);
					String xBondForm= reader.getCellData("CreateNB", "BondForm", rowNum);
					String xBondFormBeingSearched= reader.getCellData("CreateNB", "BondFormBeingSearched", rowNum);
					String xBondAmt= reader.getCellData("CreateNB", "BondAmt", rowNum);
					//String xCarrier= reader.getCellData("MasterTestData", "Carrier", rowNum);
					//String xWriteUp= reader.getCellData("MasterTestData", "WriteUp", rowNum);
					//String xEffectiveDate= reader.getCellData("MasterTestData", "EffectiveDate", rowNum);
					//String xExpiryDate= reader.getCellData("MasterTestData", "ExpiryDate", rowNum);
					//String xRateType= reader.getCellData("MasterTestData", "RateType", rowNum);
					//String xApprovedBy= reader.getCellData("MasterTestData", "ApprovedBy", rowNum);
					//String xPOAType= reader.getCellData("MasterTestData", "POAType", rowNum);
					//String xIndType= reader.getCellData("MasterTestData", "IndType", rowNum);
					//String xIndAgrName= reader.getCellData("MasterTestData", "IndAgrName", rowNum);
					//String xWaiveIndChk= reader.getCellData("MasterTestData", "WaiveIndChk", rowNum);
					//String xValidUntilDate= reader.getCellData("MasterTestData", "ValidUntilDate", rowNum);
				
					//String xBaseRateType=reader.getCellData("MasterTestData", "BaseRateType", rowNum);
					//String xBaseRateValue=reader.getCellData("MasterTestData", "BaseRateValue", rowNum);
					//String xAgnComm=reader.getCellData("MasterTestData", "AgnComm", rowNum);
					//String xAgnFeeType=reader.getCellData("MasterTestData", "AgnFeeType", rowNum);
					//String xAgnFeeValue=reader.getCellData("MasterTestData", "AgnFeeValue", rowNum);
					//String xSCLiteComm=reader.getCellData("MasterTestData", "SCLiteComm", rowNum);
					//String xTax=reader.getCellData("MasterTestData", "BaseRateType", rowNum);
					
					
		//			Object ob[] = {xTestRun,xTestCaseName,xClientName, 
		//					xState, xBondForm,xBondFormBeingSearched, xBondAmt,
		//					xCarrier,xWriteUp,xEffectiveDate,xExpiryDate, xRateType,xApprovedBy,xPOAType,xIndType,xIndAgrName,xWaiveIndChk,xValidUntilDate,
		//					xBaseRateType,xBaseRateValue,xAgnComm,xAgnFeeType,xAgnFeeValue,xSCLiteComm};
				
					Object ob[] = {xTestCaseName, xuserName, xPassword,xClientName,xState, xBondForm,xBondFormBeingSearched, xBondAmt};
					myData.add (ob); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myData;
	}
		
}
	
