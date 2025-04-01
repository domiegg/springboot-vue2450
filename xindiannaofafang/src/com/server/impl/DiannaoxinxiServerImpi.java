package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DiannaoxinxiMapper;
import com.entity.Diannaoxinxi;
import com.server.DiannaoxinxiServer;
@Service
public class DiannaoxinxiServerImpi implements DiannaoxinxiServer {
   @Resource
   private DiannaoxinxiMapper gdao;
	@Override
	public int add(Diannaoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Diannaoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Diannaoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Diannaoxinxi> getsydiannaoxinxi1(Map<String, Object> map) {
		return gdao.getsydiannaoxinxi1(map);
	}
	public List<Diannaoxinxi> getsydiannaoxinxi2(Map<String, Object> map) {
		return gdao.getsydiannaoxinxi2(map);
	}
	public List<Diannaoxinxi> getsydiannaoxinxi3(Map<String, Object> map) {
		return gdao.getsydiannaoxinxi3(map);
	}
	
	@Override
	public Diannaoxinxi quchongDiannaoxinxi(Map<String, Object> account) {
		return gdao.quchongDiannaoxinxi(account);
	}

	@Override
	public List<Diannaoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Diannaoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Diannaoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

