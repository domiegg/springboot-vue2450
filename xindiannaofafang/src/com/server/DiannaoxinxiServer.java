package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Diannaoxinxi;

public interface DiannaoxinxiServer {

  public int add(Diannaoxinxi po);

  public int update(Diannaoxinxi po);
  
  
  
  public int delete(int id);

  public List<Diannaoxinxi> getAll(Map<String,Object> map);
  public List<Diannaoxinxi> getsydiannaoxinxi1(Map<String,Object> map);
  public List<Diannaoxinxi> getsydiannaoxinxi2(Map<String,Object> map);
  public List<Diannaoxinxi> getsydiannaoxinxi3(Map<String,Object> map);
  public Diannaoxinxi quchongDiannaoxinxi(Map<String, Object> acount);

  public Diannaoxinxi getById( int id);

  public List<Diannaoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Diannaoxinxi> select(Map<String, Object> map);
}
//	所有List
