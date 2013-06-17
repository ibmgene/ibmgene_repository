package cn.ibm.com.common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DownloadUtil {
	
	/**
	 * 下载附件
	 * @param buffer
	 * @param fileName
	 * @param response
	 * @return
	 */
	public HttpServletResponse download(byte[] buffer,String fileName, HttpServletResponse response) {
        try {
            

            // 以流的形式下载文件。
           
            // 清空response
            response.reset(); 
            InputStream   input   =new ByteArrayInputStream(buffer); 
            // 设置response的Header
            byte[] bytes = fileName.getBytes("GBK");
			String encoded = new String(bytes, "ISO-8859-1");
            response.reset(); 
            response.addHeader("Content-Disposition","attachment; filename=" + encoded);
            response.setHeader( "Content-Length ",String.valueOf(input.available())); 
           
            response.setContentType( "application/x-msdownload "); 
            OutputStream   output   =   response.getOutputStream(); 
            byte[]   buff   =new   byte[32288]; 
            int   bytesRead; 
            while((bytesRead=input.read(buff,   0,   buff.length))!=-1) 
            { 
            output.write(buff,0,bytesRead); 
            }        
            input.close();
            output.flush();
            output.close();
            
            
            
        } catch (IOException ex) {
        	

        }finally {
        	
		}
        return response;
    }
	
	/**
	 * 下载附件
	 * @param buffer
	 * @param fileName
	 * @param response
	 * @return
	 */
	public HttpServletResponse download(byte[] buffer,String fileName, String contentType,HttpServletResponse response) {
        try {
            

            // 以流的形式下载文件。
           
            // 清空response
            response.reset(); 
            InputStream   input   =new ByteArrayInputStream(buffer); 
            // 设置response的Header
            byte[] bytes = fileName.getBytes("GBK");
			String encoded = new String(bytes, "ISO-8859-1");
            response.reset(); 
            response.addHeader("Content-Disposition","attachment; filename=" + encoded);
            response.setHeader( "Content-Length ",String.valueOf(input.available())); 
           
            response.setContentType( contentType); 
            OutputStream   output   =   response.getOutputStream(); 
            byte[]   buff   =new   byte[32288]; 
            int   bytesRead; 
            while((bytesRead=input.read(buff,   0,   buff.length))!=-1) 
            { 
            output.write(buff,0,bytesRead); 
            }        
            input.close();
            output.flush();
            output.close();
            
            
            
        } catch (IOException ex) {
        	

        }finally {
        	
		}
        return response;
    }

}
