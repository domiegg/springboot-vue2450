package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Fafangshenqing;

public interface FafangshenqingServer {

  public int add(Fafangshenqing po);

  public int update(Fafangshenqing po);
  
  public int updatelb(Fafangshenqing po);
  
  public int delete(int id);

  public List<Fafangshenqing> getAll(Map<String,Object> map);
  public List<Fafangshenqing> getsyfafangshenqing1(Map<String,Object> map);
  public List<Fafangshenqing> getsyfafangshenqing2(Map<String,Object> map);
  public List<Fafangshenqing> getsyfafangshenqing3(Map<String,Object> map);
  public Fafangshenqing quchongFafangshenqing(Map<String, Object> acount);

  public Fafangshenqing getById( int id);

  public List<Fafangshenqing> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Fafangshenqing> select(Map<String, Object> map);
}
//	所有List
