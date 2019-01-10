package com.maobohe.register.controller;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.io.output.ByteArrayOutputStream;

public class ResponseWrapper extends HttpServletResponseWrapper {
	private ByteArrayOutputStream output;
	private ServletOutputStream filterOutput;

	public ResponseWrapper(HttpServletResponse response) {
	   super(response);
	   output = new ByteArrayOutputStream();
	}
	
	/**
	* 巧妙将ServletOutputStream放到公共变量，解决不能多次读写问题
	* @return
	* @throws IOException
	*/
	public ServletOutputStream getOutputStream() throws IOException {
	   if (filterOutput == null) {
	       filterOutput = new ServletOutputStream() {

			@Override
			public void write(int b) throws IOException {
				output.write(b);
			}
	          
	       };
	   }
	   return filterOutput;
	}

	public byte[] toByteArray() {
	   return output.toByteArray();
	}
}
