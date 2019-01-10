package com.maobohe.register.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import net.sf.json.JSONObject;

/**
 * @title: 用户登录 交互层实现类
 */
@Controller
@RequestMapping(value = "/Download")
public class Download {
	/**
	 * 手机号注册
	 */
	@RequestMapping("/download")
	@ResponseBody
	public HttpServletResponse download(HttpServletResponse resp) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!");
		String filePath = "E:\\model\\目标医院导入模板.xlsx";
		String filename = "目标医院导入模板.xlsx";
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			filename = new String(filename.getBytes("utf-8"),"iso-8859-1");
			bis = new BufferedInputStream(new FileInputStream(filePath));
			bos = new BufferedOutputStream(resp.getOutputStream());
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("application/octet-stream;charset=UTF-8");
			resp.addHeader("Content-disposition", "attachment;filename="+filename);
			byte [] b = new byte[1024];
			int len = 0;
			while((len=bis.read(b,0,b.length))!=-1) {
				bos.write(b,0,len);
			}
			bos.flush();
			
			ResponseWrapper wrapper = new ResponseWrapper(resp);
			String responseStr = new String(wrapper.toByteArray(), resp.getCharacterEncoding());
	        Object parse = JSON.parse(responseStr);

	        BaseResult<Object> baseResult = new BaseResult<>();
	        baseResult.setData(parse);
	        if (parse instanceof JSONObject){
	               JSONObject resultObject = (JSONObject) parse;
	               if (resultObject.containsKey("status")&&resultObject.containsKey("message")&&resultObject.containsKey("data")){
	                   baseResult = (BaseResult<Object>) JSONObject.toBean(resultObject,BaseResult.class);
	               }
	           }
	           //必须设置ContentLength
	           resp.setContentLength(JSON.toJSONBytes(baseResult).length);
	           //根据http accept来设置，我这里为了简便直接写json了
	           resp.setContentType("application/json;charset=utf-8");
	           resp.getOutputStream().write(JSON.toJSONBytes(baseResult));
	           System.out.println("====================="+resp);
	           System.out.println("====================="+resp.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
			if(bis!=null) {
				
					bis.close();
					if(bos!=null) {
						bos.close();
					}
				
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resp;
	}
	
	public static void main(String[] args) {
		
	}
	
}
