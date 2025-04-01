package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BumenxinxiMapper;
import com.entity.Bumenxinxi;
import com.server.BumenxinxiServer;
@Service
public class BumenxinxiServerImpi implements BumenxinxiServer {
   @Resource
   private BumenxinxiMapper gdao;
	@Override
	public int add(Bumenxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Bumenxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Bumenxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Bumenxinxi> getsybumenxinxi1(Map<String, Object> map) {
		return gdao.getsybumenxinxi1(map);
	}
	public List<Bumenxinxi> getsybumenxinxi2(Map<String, Object> map) {
		return gdao.getsybumenxinxi2(map);
	}
	public List<Bumenxinxi> getsybumenxinxi3(Map<String, Object> map) {
		return gdao.getsybumenxinxi3(map);
	}
	
	@Override
	public Bumenxinxi quchongBumenxinxi(Map<String, Object> account) {
		return gdao.quchongBumenxinxi(account);
	}

	@Override
	public List<Bumenxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Bumenxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Bumenxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

