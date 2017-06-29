package com.acjkj.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.springframework.web.multipart.MultipartFile;



public class FileUploadUtil {
	/**
	 * 上传文件
	 * 
	 * @param file待上传的文件
	 * @param storePath待存储的路径
	 *            (该路径还包括文件名)
	 * @return 
	 */
	public static void uploadFormFile(MultipartFile file, String storePath)
			throws Exception {
		// 开始上传
		InputStream is = null;
		OutputStream os = null;
		try {
			is = file.getInputStream();
			os = new FileOutputStream(storePath);
			int bytes = 0;
			byte[] buffer = new byte[8192];
			while ((bytes = is.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytes);
			}
			os.close();
			is.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (os != null) {
				try {
					os.close();
					os = null;
				} catch (Exception e1) {
					;
				}
			}
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (Exception e1) {
					;
				}
			}
		}
	}
}