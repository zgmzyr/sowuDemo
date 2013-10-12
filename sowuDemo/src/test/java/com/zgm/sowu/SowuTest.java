package com.zgm.sowu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;
import org.supercsv.io.AbstractCsvReader;
import org.supercsv.io.CsvListReader;
import org.supercsv.prefs.CsvPreference;

/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
/**
 * 
 * @author 周光明 Exp
 * @version $FileName: SowuTest.java $Date: Oct 10, 2013 9:54:40 AM -0400 2013
 * @since 1.0
 * 
 */
public class SowuTest {

	
	private CsvListReader clr;

	@Test
	public void readCvs() throws IOException {
		Reader reader = new FileReader(new File("E:/zgm/company/需求/对接/sowu/测试CSV数据包/Product_SaleProp.csv"));
//		CsvBeanReader cvsBeanReader = new CsvBeanReader(reader, CsvPreference.STANDARD_PREFERENCE);
//		cvsBeanReader.read(paramClass, paramArrayOfString);
	    CsvListReader csvListReader = new CsvListReader(reader, CsvPreference.STANDARD_PREFERENCE);
		
	    String[] headArray = csvListReader.getCSVHeader(true);
//	    for (List<String> localList = csvListReader.read(); localList != null; localList = csvListReader.read()) {
	    for (int lineIndex = 0; lineIndex <  10; lineIndex++) {
	    	List<String> localList = csvListReader.read();
	    	for (int index = 0; index < headArray.length; index++) {
//	    		System.out.println(localList.get(index));
	    		
				System.out.println(localList.get(index));
	    	}
	    	
	    	System.out.println("--------------------");
	    	
	    }
	}
	
	/*
	public void aa() {
		this.fr = new FileReader(this.sourceFile);
	      this.clr = new CsvListReader(this.fr, CsvPreference.STANDARD_PREFERENCE);
	      Connection localConnection = this.database.getConnection();
	      Statement localStatement = localConnection.createStatement();
	      localStatement.execute(this.tempTableCreateSql);
	      PreparedStatement localPreparedStatement = this.database.getConnection().prepareStatement(this.tempTableInsertSql);
	      String[] arrayOfString = this.clr.getCSVHeader(true);
	      for (List<String> localList = this.clr.read(); localList != null; localList = this.clr.read())
	      {
	        for (int i = 0; i < arrayOfString.length; i++)
	        {
	          String str = localList.get(i);
	          localPreparedStatement.setObject(i + 1, "NULL".endsWith(str) ? null : str);
	        }
	        try
	        {
	          localPreparedStatement.execute();
	        }
	        catch (SQLException localSQLException)
	        {
	          localSQLException.printStackTrace();
	        }
	      }

	}
	*/
}
