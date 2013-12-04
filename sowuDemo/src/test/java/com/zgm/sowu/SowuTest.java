package com.zgm.sowu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.junit.Test;
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

	@Test
	public void readCsv() throws IOException {
		Reader reader = new FileReader(new File("E:/zgm/company/需求/对接/sowu/测试CSV数据包/Product_SaleProp.csv"));
		CsvListReader csvListReader = new CsvListReader(reader, CsvPreference.STANDARD_PREFERENCE);

		String[] headArray = csvListReader.getCSVHeader(true);
		// for (List<String> localList = csvListReader.read(); localList != null; localList = csvListReader.read()) {
		for (int lineIndex = 0; lineIndex < 10; lineIndex++) {
			List<String> localList = csvListReader.read();
			for (int index = 0; index < headArray.length; index++) {
				System.out.println(localList.get(index));
			}

			System.out.println("--------------------");

		}
	}
}
