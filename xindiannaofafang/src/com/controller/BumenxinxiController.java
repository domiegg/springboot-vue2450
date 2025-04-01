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

import com.entity.Bumenxinxi;
import com.server.BumenxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BumenxinxiController {
	@Resource
	private BumenxinxiServer bumenxinxiService;


   
	@RequestMapping("addBumenxinxi.do")
	public String addBumenxinxi(HttpServletRequest request,Bumenxinxi bumenxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		bumenxinxi.setAddtime(time.toString().substring(0, 19));
		bumenxinxiService.add(bumenxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "bumenxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:bumenxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBumenxinxi.do")
	public String doUpdateBumenxinxi(int id,ModelMap map,Bumenxinxi bumenxinxi){
		bumenxinxi=bumenxinxiService.getById(id);
		map.put("bumenxinxi", bumenxinxi);
		return "bumenxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("bumenxinxiDetail.do")
	public String bumenxinxiDetail(int id,ModelMap map,Bumenxinxi bumenxinxi){
		bumenxinxi=bumenxinxiService.getById(id);
		map.put("bumenxinxi", bumenxinxi);
		return "bumenxinxi_detail";
	}
//	前台详细
	@RequestMapping("bmxxDetail.do")
	public String bmxxDetail(int id,ModelMap map,Bumenxinxi bumenxinxi){
		bumenxinxi=bumenxinxiService.getById(id);
		map.put("bumenxinxi", bumenxinxi);
		return "bumenxinxidetail";
	}
//	
	@RequestMapping("updateBumenxinxi.do")
	public String updateBumenxinxi(int id,ModelMap map,Bumenxinxi bumenxinxi,HttpServletRequest request,HttpSession session){
		bumenxinxiService.update(bumenxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:bumenxinxiList.do";
	}

//	分页查询
	@RequestMapping("bumenxinxiList.do")
	public String bumenxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenxinxi bumenxinxi, String bumen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}		
		int total=bumenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenxinxi> list=bumenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenxinxi_list";
	}
	
	
	
	@RequestMapping("bmxxList.do")
	public String bmxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bumenxinxi bumenxinxi, String bumen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}		
		int total=bumenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bumenxinxi> list=bumenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bumenxinxilist";
	}
	
	@RequestMapping("deleteBumenxinxi.do")
	public String deleteBumenxinxi(int id,HttpServletRequest request){
		bumenxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:bumenxinxiList.do";
	}
	
	
}
