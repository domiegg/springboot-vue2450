package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Diannaoxinxi;

public interface DiannaoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diannaoxinxi record);

    int insertSelective(Diannaoxinxi record);

    Diannaoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Diannaoxinxi record);
	
    int updateByPrimaryKey(Diannaoxinxi record);
	public Diannaoxinxi quchongDiannaoxinxi(Map<String, Object> bianhao);
	public List<Diannaoxinxi> getAll(Map<String, Object> map);
	public List<Diannaoxinxi> getsydiannaoxinxi1(Map<String, Object> map);
	public List<Diannaoxinxi> getsydiannaoxinxi3(Map<String, Object> map);
	public List<Diannaoxinxi> getsydiannaoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Diannaoxinxi> getByPage(Map<String, Object> map);
	public List<Diannaoxinxi> select(Map<String, Object> map);
//	所有List
}

