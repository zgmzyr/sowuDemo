/*
 * Copyright 2013 The JA-SIG Collaborative. All rights reserved.
 * distributed with this file and available online 
 */
package com.zgm.sowu;

import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import com.zgm.sowu.FtpHelper.DownloadStatus;
import com.zgm.sowu.FtpHelper.UploadStatus;

/**
 * 
 * @author 周光明 Exp
 * @version $FileName: FtpHelperTest.java $Date: Oct 11, 2013 11:25:29 AM -0400 2013
 * @since 1.0
 * 
 */
public class FtpHelperTest {

	FtpHelper ftpHelper = new FtpHelper();
	
	@Test
	public void connect() throws IOException {
		boolean success = ftpHelper.connect("ftp.noao.edu", 21, "anonymous", "");
		if (success) {
			System.out.println("连接成功");
		} else {
			fail("连接失败");
		}
	}

	@Test
	public void download() throws IOException {
		boolean success = ftpHelper.connect("ftp.noao.edu", 21, "anonymous", "");
		if (success) {
//			DownloadStatus status = ftpHelper.download("ftp://ftp.noao.edu/README", "e:/zgm/ftp/readme.txt");
			DownloadStatus status = ftpHelper.download("/README", "e:/zgm/ftp/readme.txt");
			if (status == DownloadStatus.Download_New_Success) {
				return;
			}
		}
		
		fail("下载文件失败");
	}

	@Test
	public void upload() throws IOException {
		boolean success = ftpHelper.connect("ftp.noao.edu", 21, "anonymous", "");
		if (success) {
			UploadStatus status = ftpHelper.upload("e:/zgm/ftp/readme.txt", "/readme.txt");
			if (status == UploadStatus.Upload_New_File_Success) {
				return;
			}
		}
		
		fail("上传文件失败");
	}

	@Test
	public void disconnect() {
		fail("Not yet implemented");
	}

	@Test
	public void createDirecroty() {
		fail("Not yet implemented");
	}

	@Test
	public void uploadFile() {
		fail("Not yet implemented");
	}

	@Test
	public void getFileNames() {
		fail("Not yet implemented");
	}

	@Test
	public void getDirAndFilesInfo() throws IOException {
		if (ftpHelper.connect("ftp.noao.edu", 21, "anonymous", "")) {
			System.out.println("连接成功");
			
			String[] fileArray = ftpHelper.getFileNames(null);
			for (String fileName : fileArray) {
				System.out.println("" + fileName);
			}
		}
	}

}
