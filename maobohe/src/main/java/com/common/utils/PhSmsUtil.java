package com.common.utils;

import java.util.ResourceBundle;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * @Title: 短信平台调用
 * @author xufk
 */
public class PhSmsUtil {
	//随机生成6位短信验证码
	public static String getRandNum(int min, int max) {
		int randNum = min + (int)(Math.random() * max);
		String yzm = Integer.valueOf(randNum).toString();
		return yzm;
	}
	/**
	 * @Title: 短信平台调用
	 * @author xufk
	 * @param phone 电话
	 * @param yzm 验证码
	 */
	public static String sendDX(String[] phone,String yzm) throws Exception{
		String multiPhone = "";
		for(String ph:phone){
			multiPhone = ph + ",";
		}
		multiPhone = multiPhone.substring(0,multiPhone.length()-1);
		//解析配置文件，获取参数
		ResourceBundle bundle = ResourceBundle.getBundle("phSms");
		String url = bundle.getString("post.url");
		String corp_id = bundle.getString("corp_id");
		String corp_pwd = bundle.getString("corp_pwd");
		String corp_service = bundle.getString("corp_service");
		String corp_msg_id = bundle.getString("corp_msg_id") == null ? "" : bundle.getString("corp_msg_id");
		String ext = bundle.getString("ext") == null ? "" : bundle.getString("ext");
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(url); 
		
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ 
		new NameValuePair("corp_id", corp_id),
		new NameValuePair("corp_pwd", corp_pwd),
		new NameValuePair("corp_service",corp_service),
		new NameValuePair("mobile",multiPhone),
		new NameValuePair("msg_content","您正在使用猫薄荷APP进行注册登录操作，验证码为"+yzm+"，有效期30分钟，请妥善保管。"),
		new NameValuePair("corp_msg_id ",corp_msg_id),
		new NameValuePair("ext ",ext)
		};
		post.setRequestBody(data);
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers){
			System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString()); 
		String[] arrResult = result.split("#");
		String rtnCode = "0";//0代表发送成功
		String talCount = "0";//发送短信数量
		if(arrResult.length > 1){
			rtnCode = arrResult[0];
			talCount = arrResult[1];
			System.out.println("***********短信发送成功：共计"+talCount+"条！**************");
		}else{
			rtnCode = result;
			System.out.println("*************短信发送失败！*****************");
		}
		post.releaseConnection();
		return rtnCode;
	}
}
