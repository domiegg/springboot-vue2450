package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Bumenxinxi;

public interface BumenxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bumenxinxi record);

    int insertSelective(Bumenxinxi record);

    Bumenxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bumenxinxi record);
	
    int updateByPrimaryKey(Bumenxinxi record);
	public Bumenxinxi quchongBumenxinxi(Map<String, Object> bumen);
	public List<Bumenxinxi> getAll(Map<String, Object> map);
	public List<Bumenxinxi> getsybumenxinxi1(Map<String, Object> map);
	public List<Bumenxinxi> getsybumenxinxi3(Map<String, Object> map);
	public List<Bumenxinxi> getsybumenxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Bumenxinxi> getByPage(Map<String, Object> map);
	public List<Bumenxinxi> select(Map<String, Object> map);
//	所有List
}

