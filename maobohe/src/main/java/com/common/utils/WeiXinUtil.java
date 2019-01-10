package com.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import net.sf.json.JSONObject;

public class WeiXinUtil {
	/**
	 * 获取微信登录信息
	 * @param code
	 * @return
	 */
	public static JSONObject getAccess_token(String code){
		ResourceBundle bundle = ResourceBundle.getBundle("weixin");
        String authUrl = bundle.getString("authUrl");
        String appid = bundle.getString("appid");
        String secret = bundle.getString("secret");
        authUrl= authUrl.replace("APPID", appid);
        authUrl = authUrl.replace("SECRET", secret);
        authUrl = authUrl.replace("CODE", code);
        String jsonString = HttpRequestUtil.sendPost(authUrl,"");
        System.out.println("jsonString: " + jsonString);
//        OAuthInfo auth = null;
        JSONObject json = null;
        try {
        	json = JSONObject.fromObject(jsonString);
            /*auth.setAccess_token(json.getString("access_token"));
            auth.setExpires_in(json.getString("expires_in"));
            auth.setOpenid(json.getString("openid"));
            auth.setRefresh_token(json.getString("refresh_token"));
            auth.setScope(json.getString("scope"));
            auth.setUnionid(json.getString("unionid"));*/
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return auth;
        return json;
    }
	
	
	/**
	  * 获取用户信息
	  *
	  * @param accessToken
	  * @param openId
	  * @return
	  */
	 public Map<String,String> getUserInfo(String accessToken, String openId) {
	     Map<String,String> data = new HashMap();
	     String url = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId + "&lang=zh_CN";
	     JSONObject userInfo = null;
	     try {
	         DefaultHttpClient httpClient = new DefaultHttpClient();
	         HttpGet httpGet = new HttpGet(url);
	         HttpResponse httpResponse = httpClient.execute(httpGet);
	         HttpEntity httpEntity = httpResponse.getEntity();
	         String response = EntityUtils.toString(httpEntity, "utf-8");
	         userInfo = JSONObject.fromObject(response);
	         data.put("openid", userInfo.get("openid").toString());
	         data.put("nickname", userInfo.get("nickname").toString());
	         data.put("city", userInfo.get("city").toString());
	         data.put("province", userInfo.get("province").toString());
	         data.put("country", userInfo.get("country").toString());
	         data.put("headimgurl", userInfo.get("headimgurl").toString());
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	     return data;
	 }
}
