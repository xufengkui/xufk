package com.maobohe.register.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.common.utils.PhSmsUtil;
import com.common.utils.StringUtils;
import com.common.utils.TranUtil;
import com.maobohe.register.service.IRegistService;
import com.maobohe.yhdl.service.IYhdlService;

/**
 * @title: 用户登录 交互层实现类
 */
@Controller
@RequestMapping(value = "/yhzc")
public class RegistController {
	private Log log = LogFactory.getLog(RegistController.class);
	@Autowired
	private IRegistService registService;
	
	/**
	 * 手机号注册
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public Map<String, Object> regist(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		// 获取用户注册信息
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		// 返回信息map
		Map<String, Object> outMap = new HashMap<String, Object>();
		//判断啊是否注册
		String flag = getSfzc(loginName);
		if("Y".equals(flag)) {
			outMap.put("rtnCode", "N");
			outMap.put("message", "当前手机号已注册！");
			return outMap;
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String userId = StringUtils.getUUID();
		paramMap.put("userId", userId);
		paramMap.put("loginName", loginName);
		paramMap.put("password", password);
		paramMap.put("jbDm", "0001");//表示新晋铲屎官，更多级别参考dm_jbxx表
		String mh = getMh(99999999);
		System.out.println("~~~~~~~~~~~~~~~~~~"+mh);
		paramMap.put("userMh", mh);
		//操作记录Map
		Map<String, Object> czjlMap = new HashMap<String, Object>();
		czjlMap.put("dmCz","01");
		czjlMap.put("mh", mh);
		TranUtil tran = new TranUtil().begin();
		try{
			registService.insertUserInfo(paramMap);
			registService.insertCzjl(czjlMap);//更新操作记录
			registService.insertMh(czjlMap);//更新操作记录
			outMap.put("rtnCode", "Y");
			outMap.put("message", "注册成功！");
			tran.commit();
		}catch(Exception e){
			outMap.put("rtnCode", "N");
			outMap.put("message", "注册失败！");
			e.printStackTrace();
			tran.rollback();
		}
		return outMap;
	}
	/**
	 * 根据身份获取菜单
	 */
	@RequestMapping("/getYzm")
	@ResponseBody
	public Map<String, Object> getYzm(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String phone = request.getParameter("sjh");
		String rtnCode = "0";
		String[] multiPhone = new String[1];
		multiPhone = phone.split(",");
		//获取短信验证码
		String yzm = PhSmsUtil.getRandNum(100000, 900000);
		//调用短信接口
		// 返回信息map
		Map<String, Object> outMap = new HashMap<String, Object>();
		try {
			rtnCode = PhSmsUtil.sendDX(multiPhone, yzm);
			if("0".equals(rtnCode)){
				outMap.put("rtnCode", "Y");
				outMap.put("yzm", yzm);
				outMap.put("message", "短信发送成功！");
			}else{
				outMap.put("rtnCode", "N");
				outMap.put("message", "短信发送失败！");
			}
		} catch (Exception e) {
			System.out.println("*******短信接口调用异常********");
			outMap.put("rtnCode", "N");
			outMap.put("message", "短信发送失败！");
			e.printStackTrace();
		}
		return outMap;
	}
	
	/**
	 * 返回8位瞄号
	 */
	@RequestMapping("/getMh")
	@ResponseBody
	public String getMh(int length) {
		String mh = "00000000";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("length", length);
		// 返回信息map
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap = registService.getMh(paramMap);
		if(outMap!=null&&outMap.size()!=0) {
			mh = outMap.get("mh").toString();
		}else {
			System.out.println("********获取瞄号失败！！！**********");
		}
		return mh;
	}
	/**
	 * 验证是否注册
	 */
	@RequestMapping("/getSfzc")
	@ResponseBody
	public String getSfzc(String sjh) {
		String flag = "N";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("loginName", sjh);
		// 返回信息map
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap = registService.getSfzc(paramMap);
		System.out.println("===================="+outMap);
		if(outMap!=null&&outMap.size()!=0) {
			flag = "Y";
		}
		return flag;
	}
}
