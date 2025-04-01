package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fafangshenqing;

public interface FafangshenqingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fafangshenqing record);

    int insertSelective(Fafangshenqing record);

    Fafangshenqing selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fafangshenqing record);
	int updateByPrimaryKeySelectivelb(Fafangshenqing record);
    int updateByPrimaryKey(Fafangshenqing record);
	public Fafangshenqing quchongFafangshenqing(Map<String, Object> gonghao);
	public List<Fafangshenqing> getAll(Map<String, Object> map);
	public List<Fafangshenqing> getsyfafangshenqing1(Map<String, Object> map);
	public List<Fafangshenqing> getsyfafangshenqing3(Map<String, Object> map);
	public List<Fafangshenqing> getsyfafangshenqing2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Fafangshenqing> getByPage(Map<String, Object> map);
	public List<Fafangshenqing> select(Map<String, Object> map);
//	所有List
}

