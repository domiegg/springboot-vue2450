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

import com.entity.Fafangshenqing;
import com.server.FafangshenqingServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class FafangshenqingController {
	@Resource
	private FafangshenqingServer fafangshenqingService;


   
	@RequestMapping("addFafangshenqing.do")
	public String addFafangshenqing(HttpServletRequest request,Fafangshenqing fafangshenqing,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		fafangshenqing.setAddtime(time.toString().substring(0, 19));
		fafangshenqingService.add(fafangshenqing);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "fafangshenqingList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:fafangshenqingList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateFafangshenqing.do")
	public String doUpdateFafangshenqing(int id,ModelMap map,Fafangshenqing fafangshenqing){
		fafangshenqing=fafangshenqingService.getById(id);
		map.put("fafangshenqing", fafangshenqing);
		return "fafangshenqing_updt";
	}
	
	
	
	@RequestMapping("doUpdateFafangshenqinglb.do")
	public String doUpdateFafangshenqinglb(int id,ModelMap map,Fafangshenqing fafangshenqing){
		fafangshenqing=fafangshenqingService.getById(id);
		map.put("fafangshenqing", fafangshenqing);
		return "fafangshenqing_updtlb";
	}
	
@RequestMapping("updateFafangshenqinglb.do")
	public String updateFafangshenqinglb(int id,ModelMap map,Fafangshenqing fafangshenqing){
		fafangshenqingService.updatelb(fafangshenqing);
		return "redirect:fafangshenqingList.do";
	}
	
//	后台详细
	@RequestMapping("fafangshenqingDetail.do")
	public String fafangshenqingDetail(int id,ModelMap map,Fafangshenqing fafangshenqing){
		fafangshenqing=fafangshenqingService.getById(id);
		map.put("fafangshenqing", fafangshenqing);
		return "fafangshenqing_detail";
	}
//	前台详细
	@RequestMapping("ffsqDetail.do")
	public String ffsqDetail(int id,ModelMap map,Fafangshenqing fafangshenqing){
		fafangshenqing=fafangshenqingService.getById(id);
		map.put("fafangshenqing", fafangshenqing);
		return "fafangshenqingdetail";
	}
//	
	@RequestMapping("updateFafangshenqing.do")
	public String updateFafangshenqing(int id,ModelMap map,Fafangshenqing fafangshenqing,HttpServletRequest request,HttpSession session){
		fafangshenqingService.update(fafangshenqing);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:fafangshenqingList.do";
	}

//	分页查询
	@RequestMapping("fafangshenqingList.do")
	public String fafangshenqingList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fafangshenqing fafangshenqing, String bianhao, String mingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2, String shenqingliyou, String riqi1,String riqi2, String gonghao, String xingming, String bumen, String fafangzhuangtai, String huifuyijian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}		if(fafangzhuangtai==null||fafangzhuangtai.equals("")){pmap.put("fafangzhuangtai", null);}else{pmap.put("fafangzhuangtai", fafangzhuangtai);}		if(huifuyijian==null||huifuyijian.equals("")){pmap.put("huifuyijian", null);}else{pmap.put("huifuyijian", huifuyijian);}		
		int total=fafangshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fafangshenqing> list=fafangshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fafangshenqing_list";
	}
	
	@RequestMapping("fafangshenqingList2.do")
	public String fafangshenqingList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fafangshenqing fafangshenqing, String bianhao, String mingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2, String shenqingliyou, String riqi1,String riqi2, String gonghao, String xingming, String bumen, String fafangzhuangtai, String huifuyijian,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}		if(fafangzhuangtai==null||fafangzhuangtai.equals("")){pmap.put("fafangzhuangtai", null);}else{pmap.put("fafangzhuangtai", fafangzhuangtai);}		if(huifuyijian==null||huifuyijian.equals("")){pmap.put("huifuyijian", null);}else{pmap.put("huifuyijian", huifuyijian);}		
		
		int total=fafangshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fafangshenqing> list=fafangshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fafangshenqing_list2";
	}	
	
	@RequestMapping("ffsqList.do")
	public String ffsqList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fafangshenqing fafangshenqing, String bianhao, String mingcheng, String kucun, String shenqingshuliang1,String shenqingshuliang2, String shenqingliyou, String riqi1,String riqi2, String gonghao, String xingming, String bumen, String fafangzhuangtai, String huifuyijian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(kucun==null||kucun.equals("")){pmap.put("kucun", null);}else{pmap.put("kucun", kucun);}		if(shenqingshuliang1==null||shenqingshuliang1.equals("")){pmap.put("shenqingshuliang1", null);}else{pmap.put("shenqingshuliang1", shenqingshuliang1);}		if(shenqingshuliang2==null||shenqingshuliang2.equals("")){pmap.put("shenqingshuliang2", null);}else{pmap.put("shenqingshuliang2", shenqingshuliang2);}		if(shenqingliyou==null||shenqingliyou.equals("")){pmap.put("shenqingliyou", null);}else{pmap.put("shenqingliyou", shenqingliyou);}		if(riqi1==null||riqi1.equals("")){pmap.put("riqi1", null);}else{pmap.put("riqi1", riqi1);}		if(riqi2==null||riqi2.equals("")){pmap.put("riqi2", null);}else{pmap.put("riqi2", riqi2);}		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(bumen==null||bumen.equals("")){pmap.put("bumen", null);}else{pmap.put("bumen", bumen);}		if(fafangzhuangtai==null||fafangzhuangtai.equals("")){pmap.put("fafangzhuangtai", null);}else{pmap.put("fafangzhuangtai", fafangzhuangtai);}		if(huifuyijian==null||huifuyijian.equals("")){pmap.put("huifuyijian", null);}else{pmap.put("huifuyijian", huifuyijian);}		
		int total=fafangshenqingService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fafangshenqing> list=fafangshenqingService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fafangshenqinglist";
	}
	
	@RequestMapping("deleteFafangshenqing.do")
	public String deleteFafangshenqing(int id,HttpServletRequest request){
		fafangshenqingService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:fafangshenqingList.do";
	}
	
	
}
