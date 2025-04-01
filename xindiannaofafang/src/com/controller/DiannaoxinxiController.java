package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Diannaoxinxi;
import com.server.DiannaoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DiannaoxinxiController {
	@Resource
	private DiannaoxinxiServer diannaoxinxiService;


   
	@RequestMapping("addDiannaoxinxi.do")
	public String addDiannaoxinxi(HttpServletRequest request,Diannaoxinxi diannaoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		diannaoxinxi.setAddtime(time.toString().substring(0, 19));
		diannaoxinxiService.add(diannaoxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "diannaoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:diannaoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDiannaoxinxi.do")
	public String doUpdateDiannaoxinxi(int id,ModelMap map,Diannaoxinxi diannaoxinxi){
		diannaoxinxi=diannaoxinxiService.getById(id);
		map.put("diannaoxinxi", diannaoxinxi);
		return "diannaoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("diannaoxinxiDetail.do")
	public String diannaoxinxiDetail(int id,ModelMap map,Diannaoxinxi diannaoxinxi){
		diannaoxinxi=diannaoxinxiService.getById(id);
		map.put("diannaoxinxi", diannaoxinxi);
		return "diannaoxinxi_detail";
	}
//	前台详细
	@RequestMapping("dnxxDetail.do")
	public String dnxxDetail(int id,ModelMap map,Diannaoxinxi diannaoxinxi){
		diannaoxinxi=diannaoxinxiService.getById(id);
		map.put("diannaoxinxi", diannaoxinxi);
		return "diannaoxinxidetail";
	}
//	
	@RequestMapping("updateDiannaoxinxi.do")
	public String updateDiannaoxinxi(int id,ModelMap map,Diannaoxinxi diannaoxinxi,HttpServletRequest request,HttpSession session){
		diannaoxinxiService.update(diannaoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:diannaoxinxiList.do";
	}

//	分页查询
	@RequestMapping("diannaoxinxiList.do")
	public String diannaoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diannaoxinxi diannaoxinxi, String bianhao, String mingcheng, String pinpai, String xinghao, String peizhi, String kucun1,String kucun2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(pinpai==null||pinpai.equals("")){pmap.put("pinpai", null);}else{pmap.put("pinpai", pinpai);}		if(xinghao==null||xinghao.equals("")){pmap.put("xinghao", null);}else{pmap.put("xinghao", xinghao);}		if(peizhi==null||peizhi.equals("")){pmap.put("peizhi", null);}else{pmap.put("peizhi", peizhi);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		
		int total=diannaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diannaoxinxi> list=diannaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diannaoxinxi_list";
	}
	
	
	
	@RequestMapping("dnxxList.do")
	public String dnxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Diannaoxinxi diannaoxinxi, String bianhao, String mingcheng, String pinpai, String xinghao, String peizhi, String kucun1,String kucun2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(pinpai==null||pinpai.equals("")){pmap.put("pinpai", null);}else{pmap.put("pinpai", pinpai);}		if(xinghao==null||xinghao.equals("")){pmap.put("xinghao", null);}else{pmap.put("xinghao", xinghao);}		if(peizhi==null||peizhi.equals("")){pmap.put("peizhi", null);}else{pmap.put("peizhi", peizhi);}		if(kucun1==null||kucun1.equals("")){pmap.put("kucun1", null);}else{pmap.put("kucun1", kucun1);}		if(kucun2==null||kucun2.equals("")){pmap.put("kucun2", null);}else{pmap.put("kucun2", kucun2);}		
		int total=diannaoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Diannaoxinxi> list=diannaoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "diannaoxinxilist";
	}
	
	@RequestMapping("deleteDiannaoxinxi.do")
	public String deleteDiannaoxinxi(int id,HttpServletRequest request){
		diannaoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:diannaoxinxiList.do";
	}
	
	
}
