package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FafangshenqingMapper;
import com.entity.Fafangshenqing;
import com.server.FafangshenqingServer;
@Service
public class FafangshenqingServerImpi implements FafangshenqingServer {
   @Resource
   private FafangshenqingMapper gdao;
	@Override
	public int add(Fafangshenqing po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Fafangshenqing po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Fafangshenqing po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Fafangshenqing> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Fafangshenqing> getsyfafangshenqing1(Map<String, Object> map) {
		return gdao.getsyfafangshenqing1(map);
	}
	public List<Fafangshenqing> getsyfafangshenqing2(Map<String, Object> map) {
		return gdao.getsyfafangshenqing2(map);
	}
	public List<Fafangshenqing> getsyfafangshenqing3(Map<String, Object> map) {
		return gdao.getsyfafangshenqing3(map);
	}
	
	@Override
	public Fafangshenqing quchongFafangshenqing(Map<String, Object> account) {
		return gdao.quchongFafangshenqing(account);
	}

	@Override
	public List<Fafangshenqing> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Fafangshenqing> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Fafangshenqing getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

